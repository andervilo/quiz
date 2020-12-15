import React from 'react';
import './navbar.css';


const NavBar = () => {
  return (
    <header className="header-container">

        <a href="/">QUIZ</a>
        
        <nav>
            <ul className="menu">
                <li className="nav-link-item"><a href="/">Home</a></li>
                <li className="nav-link-item"><a href="/">Serviços</a></li>
                <li className="nav-link-item"><a href="/">Blog</a></li>
                <li className="nav-link-item"><a href="/">Sobre</a></li>
                <li className="nav-link-item"><a href="/">Contato</a></li>
            </ul>
        </nav>

    </header>
  )
}

export default NavBar;
