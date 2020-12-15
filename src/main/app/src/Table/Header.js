import React from 'react';

const Header = ({ headers }) => {
  return (
    <tr>
        {
            headers.map(key => {
                return(
                    <th  key={key}><strong>{key}</strong></th>
                );
            })
        }
    </tr>
  );
}

export default Header

