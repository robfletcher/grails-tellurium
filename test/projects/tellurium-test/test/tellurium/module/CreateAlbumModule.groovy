package module

import org.tellurium.dsl.DslContext

class CreateAlbumModule extends DslContext {

	void defineUi() {
		ui.Container(uid: "CreateAlbum", clocator: [tag: "form"]) {
			InputBox(uid: "Artist", clocator: [tag: "input", name: "artist"])
			InputBox(uid: "Name", clocator: [tag: "input", name: "name"])
			InputBox(uid: "Year", clocator: [tag: "input", name: "year"])
			SubmitButton(uid: "Create", clocator: [tag: "input", type: "submit", name: "create"])
		}
	}

	void createAlbum(artist, name, year) {
		type "CreateAlbum.Artist", artist
		type "CreateAlbum.Name", name
		type "CreateAlbum.Year", year
		click "CreateAlbum.Create"
		waitForPageToLoad 30000
	}

}
