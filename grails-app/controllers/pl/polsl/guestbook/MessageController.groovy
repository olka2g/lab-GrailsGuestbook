package pl.polsl.guestbook



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MessageController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        def messages = Message.list()
        [allMessages:messages]
    }

    def show(Message messageInstance) {
        respond messageInstance
    }

    def create() {
        respond new Message(params)
    }

    @Transactional
    def save() {        
        
        def user = new User(email: params.email, nick: params.nick)
        user.save()
        
        def messageInstance = new Message(content: params.content, author: user)
        
        if (messageInstance.hasErrors()) {
            respond messageInstance.errors, view:'create'
            return
        }

        messageInstance.save()

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'message.label', default: 'Message'), messageInstance.id])
                redirect messageInstance
            }
            '*' { respond messageInstance, [status: CREATED] }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'message.label', default: 'Message'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
