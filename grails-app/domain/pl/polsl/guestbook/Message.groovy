package pl.polsl.guestbook

class Message {

    String content
    Date dateCreated
    
    User author
    static constraints = {
        content(size:1..400)
    }
}
