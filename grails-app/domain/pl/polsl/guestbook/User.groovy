package pl.polsl.guestbook

class User {

    String email
    String nick
    
    static constraints = {
        nick (nullable: true, size:0..35, matches:"[a-zA-Z0-9/+@#\$%&/*/^<>!/?/./(/)'_/:;=|/-]*")
        email (email: true)
    }
}
