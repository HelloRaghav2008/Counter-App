import SwiftUI

struct CounterScreen: View {
    @State private var viewModel = CounterViewModel()

    var body: some View {
        VStack(alignment: .center, spacing: 20) {
            Text("\(viewModel.count)")
                .font(.system(size: 40, weight: .medium))
                .padding(.bottom, 20)

            Button(action: viewModel.increment) {
                Text("+")
                    .frame(maxWidth: .infinity)
                    .padding()
                    .background(viewModel.count >= 8 ? Color.green : Color.gray)
                    .foregroundColor(.white)
                    .cornerRadius(8)
            }
            .disabled(!viewModel.incEnabled)
            .padding(.horizontal, 20)

            Button(action: viewModel.decrement) {
                Text("-")
                    .frame(maxWidth: .infinity)
                    .padding()
                    .background(viewModel.count < 2 ? Color.red : Color.gray)
                    .foregroundColor(.white)
                    .cornerRadius(8)
            }
            .disabled(!viewModel.decEnabled)
            .padding(.horizontal, 20)

            Button(action: viewModel.reset) {
                Text("Reset")
                    .frame(maxWidth: .infinity)
                    .padding()
                    .background(Color.gray)
                    .foregroundColor(.white)
                    .cornerRadius(8)
            }
            .padding(.horizontal, 20)
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
    }
}

#Preview {
    CounterScreen()
}