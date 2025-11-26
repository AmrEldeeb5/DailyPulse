import SwiftUI
import Shared

struct ContentView: View {
    @State private var shouldOpenAbout = false
    
    var body: some View {
        NavigationStack {
            ArticlesScreen(viewModelWrapper: ArticlesViewModelWrapper())
                .toolbar {
                    ToolbarItem(placement: .primaryAction) {
                        Button {
                            shouldOpenAbout = true
                        } label: {
                            Label("About", systemImage: "info.circle")
                                .labelStyle(.titleAndIcon)
                        }
                        .popover(isPresented: $shouldOpenAbout) {
                            AboutListView()
                        }
                    }
                }
        }
    }
}