import Observation

// 1. The State & Logic (ViewModel)
@Observable
class CounterViewModel {
    var count: Int = 0
    var incEnabled: Bool = true
    var decEnabled: Bool = false

    func increment() {
        let newCount = count + 1
        count = newCount
        incEnabled = newCount < 10
        decEnabled = newCount > 0
    }

    func decrement() {
        let newCount = count - 1
        count = newCount
        incEnabled = newCount < 10
        decEnabled = newCount > 0
    }

    func reset() {
        count = 0
        incEnabled = true
        decEnabled = false
    }
}
