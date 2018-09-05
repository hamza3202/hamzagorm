package hamzagorm

class GlobalIdStore {
    String publicId
    static constraints = {
        publicId unique: true
    }
}