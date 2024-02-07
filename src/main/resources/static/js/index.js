// GESTIONE NAVBAR
const nav = document.querySelector('.nav')
window.addEventListener('scroll', fixNav)

function fixNav() {
    if (window.scrollY > nav.offsetHeight + 150) {
        nav.classList.add('active')
    } else {
        nav.classList.remove('active')
    }
}

//GESTIONE BOTTONE TORNA SU (SCROLL)

window.onscroll = function() {scrollFunction()};

function scrollFunction() {
    var tornaSuBtn = document.getElementById("tornaSuBtn");

    // Mostra il pulsante "Torna su" 
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        tornaSuBtn.style.display = "block";
    } else {
        tornaSuBtn.style.display = "none";
    }
}

//Tona a inizio pagina quando clicco sul pulsante torna su
function scrollToTop() {
    document.body.scrollTop = 0; // Per Safari
    document.documentElement.scrollTop = 0; 
}

/*//GESTIONE BARRA DI RICERCA
function cercaFilm() {
    
    var searchQuery = document.getElementById("movie-search").value.toLowerCase();
    var filmCards = document.querySelectorAll('.film-cards-container .card');

    filmCards.forEach(function(card) {
       
        var title = card.querySelector('h3').innerText.toLowerCase();

        // check del titolo nella query di ricerca
        if (title.includes(searchQuery)) {
            card.style.display = 'block';
        } else {
            card.style.display = 'none';
        }
    });
}*/

