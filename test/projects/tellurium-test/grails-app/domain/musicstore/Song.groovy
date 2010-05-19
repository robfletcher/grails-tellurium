package musicstore

class Song {

	static belongsTo = [album: Album]
	String name

    static constraints = {
		name blank: false
    }
}
