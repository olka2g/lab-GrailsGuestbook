package pl.polsl.guestbook

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserController {
    
    def index() {
        def users = User.list()
        def usersToDisplay = [:]
        users.each { user ->
            def displayName = ""
            if (user.nick != null) {
                displayName = user.nick   
            } else {
                displayName = user.email
            }
            
            def messagesCount = Message.list().findAll{it.author == user}.size()
            usersToDisplay.put(displayName, messagesCount)
        }
        
        def usersSorted = usersToDisplay.sort { a, b -> b.value <=> a.value }
        
        [users: usersSorted]
    }
}
