import SwiftUI
import composeApp

struct ContentView: View {
	let greet = Greeting().greet()

	var body: some View {
		Text(
		    greet
		)
		.font(.largeTitle)
		.foregroundStyle(.red)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}