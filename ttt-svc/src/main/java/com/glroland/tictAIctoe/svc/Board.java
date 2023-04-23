package com.glroland.tictAIctoe.svc;

public class Board 
{
    private Constants.Values [] board;

    public Board()
    {
        board = new Constants.Values[Constants.ROWS * Constants.COLUMNS];
        for (int i=0; i<board.length; i++)
            board[i] = Constants.Values.NONE;
    }

    public Constants.Values[] getBoard() {
        return board;
    }

    public void setValue(int x, int y, Constants.Values v)
    {
        board[(y * Constants.COLUMNS) + x] = v;
    }
 
    public Constants.Values getValue(int x, int y)
    {
        return board[(y * Constants.COLUMNS) + x];
    }

    public boolean isOver()
    {
        if (isFull())
            return true;

        if (isHorizontalWinner())
            return true;

        if (isVerticalWinner())
            return true;

        
        return false;
    }

    private boolean isFull()
    {
        // every square filled?
        for (int i=0; i<board.length; i++)
        {
            if (board[i] == Constants.Values.NONE)
            {
                return false;
            }
        }
        return true;
    }

    private boolean isHorizontalWinner()
    {
        for (int y=0; y<Constants.ROWS; y++)
        {
            if (this.getValue(0, y) != Constants.Values.NONE)
            {
                boolean winner = true;
                for (int x=1; x<Constants.COLUMNS; x++)
                {
                    if(this.getValue(x, y) != this.getValue(0, y))
                    {
                        winner = false;
                        break;
                    }
                }
                if (winner)
                    return true;
            }
        }

        return false;
    }

    private boolean isVerticalWinner()
    {
        for (int x=0; x<Constants.ROWS; x++)
        {
            if (this.getValue(x, 0) != Constants.Values.NONE)
            {
                boolean winner = true;
                for (int y=1; y<Constants.COLUMNS; y++)
                {
                    if(this.getValue(x, y) != this.getValue(x, 0))
                    {
                        winner = false;
                        break;
                    }
                }
                if (winner)
                    return true;
            }
        }

        return false;
    }

    private boolean isDiagonalWinner()
    {
        if (this.getValue(1, 1) != Constants.Values.NONE)
        {
            if ((this.getValue(0, 0) == this.getValue(1,1)) && (this.getValue(1, 1) == this.getValue(2,2)))
            {
                return true;
            }

            if ((this.getValue(0, 2) == this.getValue(1,1)) && (this.getValue(1, 1) == this.getValue(2,0)))
            {
                return true;
            }
        }

        return false;
    }
}
