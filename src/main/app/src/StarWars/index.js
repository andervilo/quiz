import React, {useState, useEffect} from 'react'
import axios from 'axios';
import './starwars.css'

const StarWars = () => {
    const [people, setPeople] = useState([]);
    const [proximo, setProximo] = useState(1);

    // eslint-disable-next-line
    useEffect(() => {
        return getPeople(1);
    }, [])

    // eslint-disable-next-line
    useEffect(() => {
        return getPeople(proximo);
    }, [proximo])// eslint-disable-next-line

    const getPeople = async (numberPage) =>{
        const url = `https://swapi.dev/api/people/?page=${numberPage}`;
        
        const {data} = await axios.get(url);
        setPeople(people.concat(data.results));
        if(data.next !== null){
            setProximo(parseInt(data.next.split('=')[1]));
        }       
    };

    return (
        <div className="sw_cards">
            {
                people.map(item => {
                    return(
                        
                        <div key={item.name}>
                            <div className="ws_card">
                                <strong>{item.name}</strong> 
                                <small><strong>Peso: </strong> {item.mass}</small>
                                <small><strong>Altura</strong> {item.height}</small>
                            </div>
                        </div>
                    );
                })
            }
        </div>
    )
}

export default StarWars
