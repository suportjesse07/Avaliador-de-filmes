import {ReactComponent as GithubIcon} from 'assets/img/github.svg';
import './styles.css';
function Navbar (){
    return(
    <header>
      <nav className="container">
        <div className="notafilme-nav-content">
          <h1>Nota Filme</h1>
          <a href="https://github.com/suportjesse07/Avaliador-de-filmes">
            <div className="notafilme-contact-container">
              <GithubIcon />
              <p className="notafilme-contact-link">/equipe20</p>
              </div>
          </a>
        </div>
      </nav>
    </header>
    );
}

export default Navbar;