import SwiftUI
import Shared

struct AboutScreen: View {
    var onUpButtonClick: () -> Void
    
    var body: some View {
        VStack(spacing: 0) {
            AboutToolBar(onUpButtonClick: onUpButtonClick)
            AboutContentView()
        }
    }
}

struct AboutToolBar: View {
    var onUpButtonClick: () -> Void
    
    var body: some View {
        HStack {
            Button(action: onUpButtonClick) {
                Image(systemName: "arrow.left")
                    .foregroundColor(.primary)
            }
            Text("About")
                .font(.headline)
            Spacer()
        }
        .padding()
    }
}

struct AboutContentView: View {
    private struct RowItem: Hashable {
        let title: String
        let subtitle: String
    }

    private let items: [RowItem] = {
        let platform = Platform()
        platform.logSystemInfo()

        var result: [RowItem] = [
            .init(
                title: "Operating System",
                subtitle: "\(platform.osName) \(platform.osVersion)"
            ),
            .init(
                title: "Device",
                subtitle: platform.deviceModel
            ),
            .init(
                title: "Density",
                subtitle: "@\(platform.density)x"
            )
        ]
        return result
    }()

    var body: some View {
        List {
            ForEach(items, id: \.self) { item in
                VStack(alignment: .leading) {
                    Text(item.title)
                        .font(.caption)
                        .foregroundStyle(.secondary)
                    Text(item.subtitle)
                        .font(.body)
                        .foregroundStyle(.primary)
                }
                .padding(.vertical, 4)
            }
        }
        .listStyle(.plain)
    }
}

#Preview {
    AboutScreen(onUpButtonClick: {})
}
