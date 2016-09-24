package pl.polsl.guestbook

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MessageController {

    static allowedMethods = [save: "POST"]

    def index() {
        def messages = Message.list().sort{ it.dateCreated }.reverse()
        [allMessages:messages]
    }

    def create() {
        respond new Message(params)
    }

    @Transactional
    def save() {        
        def author = User.find { email == params.email && nick == params.nick}
        
        if (author == null) {
            author = new User(email: params.email, nick: params.nick)
            if (author.validate()) {
                author.save()
            }
            else {
                respond author.errors, view: 'create'
                return
            }
        }
        
        def message = new Message(content: params.content, author: author)
        
        if (message.validate()) {
            message.save()
            redirect(action: "index")
            return
        }
        else {
            respond message.errors, view: 'create'
            return   
        }
    }
}
