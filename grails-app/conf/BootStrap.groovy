import pl.polsl.guestbook.*

class BootStrap {

    def init = { servletContext ->
        if (User.count == 0) {
            User u1 = new User(email: 'jon.snow@got.com', nick: 'I_know_nothig(<3Ygritte)')
            User u2 = new User(email: 'stranger+withoutNick@fancydomain.com')
            User u3 = new User(email: 'sweetyKitty@fancydomain.com', nick: 'John_Smith')
        
            u1.save()
            u2.save()
            u3.save()
            
            if (Message.count == 0) {
                new Message(author: u1, content: 'Hello guys! Nice to be with you here, you know, alive. Just one thing, no spoilers pleaase. P.S. Miss U Wildling!').save()   
                new Message(author: u2, content: '<Mysterious message>').save()
                new Message(author: u3, content: 'Litwo, ojczyzno moja, ty jesteś jak zdrowie, ile cię cenić trzeba ten tylko się dowie lorem ipsum').save()
                new Message(author: u3, content: 'Polały się łzy czyste, rzęsiste na moją młodość chmurną i durną').save()
            }
        }
        
    }
    def destroy = {
    }
}
