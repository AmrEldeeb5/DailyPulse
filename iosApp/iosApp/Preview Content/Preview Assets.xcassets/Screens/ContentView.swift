import SwiftUI
import Shared

enum AppScreen {
    case articles
    case about
}

struct ContentView: View {
    @State private var currentScreen: AppScreen = .articles
    @StateObject private var viewModelWrapper = ArticlesViewModelWrapper()
    
    var body: some View {
        switch currentScreen {
        case .articles:
            ArticlesScreen(
                viewModelWrapper: viewModelWrapper,
                onAboutClick: { currentScreen = .about }
            )
        case .about:
            AboutScreen(
                onUpButtonClick: { currentScreen = .articles }
            )
        }
    }
}