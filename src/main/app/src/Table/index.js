import DataBody from './DataBody';
import Header from './Header';

const NavBar = ({headers, keys, data}) => {
    return (
        <table>
            <thead>
                <Header headers={headers}/>
            </thead>
            <tbody>
                <DataBody headers={keys} data={data}/>
            </tbody>
        </table>
    )
};

export default NavBar;