// app/routes/index.tsx
import {createFileRoute} from '@tanstack/react-router'
import {useState} from 'react'
import {Button} from "#/components/ui/button.tsx";

// 1. TanStack Start Route Definition
export const Route = createFileRoute('/')({
  component: CounterScreen,
})

// 2. The Logic (Standard React hook for client-side state)
interface CounterState {
  count: number;
  incEnabled: boolean;
  decEnabled: boolean;
}

function useCounterViewModel() {
  const [state, setState] = useState<CounterState>({
    count: 0,
    incEnabled: true,
    decEnabled: false,
  });

  const increment = () => {
    setState((prev) => {
      const newCount = prev.count + 1;
      return {count: newCount, incEnabled: newCount < 10, decEnabled: newCount > 0};
    });
  };

  const decrement = () => {
    setState((prev) => {
      const newCount = prev.count - 1;
      return {count: newCount, incEnabled: newCount < 10, decEnabled: newCount > 0};
    });
  };

  const reset = () => {
    setState({count: 0, incEnabled: true, decEnabled: false});
  };

  return {state, increment, decrement, reset};
}

// 3. The UI Component
function CounterScreen() {
  const {state, increment, decrement, reset} = useCounterViewModel();

  return (
    <div className="flex flex-col items-center justify-center min-h-screen w-full px-4">
      <h1 className="text-[40px] font-medium mb-6 leading-none">
        {state.count}
      </h1>

      <div className="flex flex-col w-full max-w-sm space-y-4">
        <Button
          onClick={increment}
          disabled={!state.incEnabled}
          className={`w-full text-white ${
            state.count >= 8
              ? "bg-green-600 hover:bg-green-700"
              : "bg-gray-500 hover:bg-gray-600"
          }`}
        >
          +
        </Button>

        <Button
          onClick={decrement}
          disabled={!state.decEnabled}
          className={`w-full text-white ${
            state.count < 2
              ? "bg-red-500 hover:bg-red-600"
              : "bg-gray-500 hover:bg-gray-600"
          }`}
        >
          -
        </Button>

        <Button
          onClick={reset}
          className="w-full bg-gray-500 hover:bg-gray-600 text-white"
        >
          Reset
        </Button>
      </div>
    </div>
  );
}