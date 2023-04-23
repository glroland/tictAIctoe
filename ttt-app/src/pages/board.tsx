import React, {Component} from "react";
import Square from "./square.tsx";

class Board extends React.Component 
{
    render() 
    {
        return (

            <div className="mb-32 grid text-center lg:mb-0 lg:grid-cols-4 lg:text-left">

                <Square />
                <Square />
                <Square />
                <br/>
        
                <Square />
                <Square />
                <Square />
                <br/>
        
                <Square />
                <Square />
                <Square />
                <br/>
        
            </div>
    
            )
        }
    }

export default Board;
