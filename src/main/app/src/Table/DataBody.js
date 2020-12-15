import React from 'react'

const DataBody = ({headers, data}) => {
    return (
        <>
            {
                data.map(item =>{
                    return(
                        <tr>
                            {
                                headers.map(key => {
                                    return(
                                        <td  key={item.email}>{item[key]}</td> 
                                    );                    
                                })
                            }
                        </tr>
                    ); 
                })
                
            }
        </>
    );
}

export default DataBody

