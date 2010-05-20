package test

import grails.plugin.tellurium.TelluriumGrailsTestCase
import module.CreateAlbumModule
import musicstore.Album
import musicstore.Artist
import org.junit.After
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import static org.hamcrest.Matchers.equalTo
import static org.hamcrest.Matchers.hasProperty
import static org.junit.Assert.assertThat

class CreateAlbumTests extends TelluriumGrailsTestCase {

	private static CreateAlbumModule module;

	@BeforeClass static void setUpModules() {
		module = new CreateAlbumModule();
		module.defineUi();
	}

	@Before
	void setUp() {
		super.setUp()
		connectUrl("http://localhost:8080/album/create");
	}

	@After
	void tearDown() {
		super.tearDown()
		Album.withTransaction {
			Album.list()*.delete()
			Artist.list()*.delete()
		}
	}

	@Test
	void createAlbumCreatesNewArtists() {
		module.createAlbum("Edward Sharpe & the Magnetic Zeros", "Up From Below", "2009")

		assertThat "Album count", Album.count(), equalTo(1)
		assertThat "Artist count", Artist.count(), equalTo(1)
		def album = Album.list()[0]
		assertThat "Artist name", album.artist, hasProperty("name", equalTo("Edward Sharpe & the Magnetic Zeros"))
		assertThat "Album name", album.name, equalTo("Up From Below")
		assertThat "Album year", album.year, equalTo("2009")
	}

	@Test
	void createAlbumUsesExistingArtist() {
		Artist.withTransaction {
			new Artist(name: "Edward Sharpe & the Magnetic Zeros").save(failOnError: true, flush: true)
		}

		module.createAlbum("Edward Sharpe & the Magnetic Zeros", "Up From Below", "2009")

		assertThat "Album count", Album.count(), equalTo(1)
		assertThat "Artist count", Artist.count(), equalTo(1)
		def album = Album.list()[0]
		assertThat "Artist name", album.artist, hasProperty("name", equalTo("Edward Sharpe & the Magnetic Zeros"))
		assertThat "Album name", album.name, equalTo("Up From Below")
		assertThat "Album year", album.year, equalTo("2009")
	}

}
