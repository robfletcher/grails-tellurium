package musicstore

class Album {
	
	static belongsTo = [artist: Artist]
	String name
	String year

    static constraints = {
		artist()
		name blank: false, unique: true
		year matches: /\d{4}/
    }

	static mapping = {
		artist cascade: "save-update"
	}
	
	boolean equals(other) {
		if (!other) return false
		if (this.is(other)) return true
		if (!other.instanceOf(Album)) return false
		return name == other.name
	}
	
	int hashCode() {
		name.hashCode()
	}
	
	String toString() {
		name
	}
}
