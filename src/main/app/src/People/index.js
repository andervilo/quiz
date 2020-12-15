import React, {useState, useEffect} from 'react'
import axios from 'axios';
import './starwars.css'
import Table from '../Table'

const People = () => {
    const [people, setPeople] = useState([]);

    // eslint-disable-next-line
    useEffect(() => {
        return getPeople();
    }, [])

    const headers = ['Nome', 'Sexo', 'E-mail']
    const keys = ['name', 'gender', 'email']

    const getPeople = async () =>{
        const url = `https://randomuser.me/api/?nat=br&results=10&inc=gender,name,nat,picture,email,cell`;

        const {data} = await axios.get(url);
        let peoplearray = []
        
        if(data.results){
            for (const p in data.results) {
                let item = data.results[p]
                item.name = `${item.name.first} ${item.name.last}`
                peoplearray.push(item)
            }
        }
        

        setPeople(peoplearray); 
    };

    return (
        <div >
            {/* {people?.map(item => {
                return(
                    <p>
                        {item.name}
                    </p>
                )                
            })} */}
            <Table headers={headers} keys={keys} data={people}/>
        </div>
    )
}

export default People
