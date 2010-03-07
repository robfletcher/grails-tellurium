package test

import grails.plugin.tellurium.TelluriumGrailsTestCase
import module.CreateAlbumModule
import musicstore.Album
import musicstore.Artist

class CreateAlbumTests extends TelluriumGrailsTestCase {

	private static CreateAlbumModule module;

	static {
		module = new CreateAlbumModule();
		module.defineUi();
	}

	void setUp() {
		super.setUp()
		connectUrl("http://localhost:8080/album/create");
	}

	void tearDown() {
		super.tearDown()
		Album.withNewSession {
			Album.list()*.delete()
			Artist.list()*.delete()
		}
	}

	void testCreateAlbumCreatesNewArtistsz() {
		module.createAlbum("Edward Sharpe & the Magnetic Zeros", "Up From Below", "2009")

		assertEquals 1, Album.count()
		assertEquals 1, Artist.count()
		def album = Album.list()[0]
		assertEquals "Edward Sharpe & the Magnetic Zeros", album.artist.name
		assertEquals "Up From Below", album.name
		assertEquals "2009", album.year
	}

	void testCreateAlbumUsesExistingArtist() {
		new Artist(name: "Edward Sharpe & the Magnetic Zeros").save(failOnError: true, flush: true)

		module.createAlbum("Edward Sharpe & the Magnetic Zeros", "Up From Below", "2009")

		assertEquals 1, Album.count()
		assertEquals 1, Artist.count()
		def album = Album.list()[0]
		assertEquals "Edward Sharpe & the Magnetic Zeros", album.artist.name
		assertEquals "Up From Below", album.name
		assertEquals "2009", album.year
	}

}
