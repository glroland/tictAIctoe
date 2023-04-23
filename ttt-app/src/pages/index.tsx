import { Inter } from 'next/font/google'
import Board from './board.tsx'
import { newGame } from './api/hello.ts'

const inter = Inter({ subsets: ['latin'] })

export default function Home() {
  return (
    <main className="flex min-h-screen flex-col items-center justify-between p-24">

      <div className={`${inter.className} mb-3 text-2xl font-semibold`}>

        <p>X is player, O is cpu</p>
        <br/>

        <Board />

        <br/>
        <br/>
        <br/>
        <button className={`${inter.className} mb-3 text-2xl font-semibold`} onClick={newGame}>Reset</button>

      </div>

    </main>
  )
}
