package musicstore

class Artist {
	
	String name
	static hasMany = [albums: Album]

    static constraints = {
		name blank: false, unique: true
    }

	static mapping = {
		albums sort: "year"
	}

	boolean equals(other) {
		if (!other) return false
		if (this.is(other)) return true
		if (!other.instanceOf(Artist)) return false
		return name == other.name
	}
	
	int hashCode() {
		name.hashCode()
	}
	
	String toString() {
		name
	}
}
