// GESTIONE NAVBAR
const menu = document.querySelector(".menu");
const menuItems = document.querySelectorAll(".menuItem");
const hamburger= document.querySelector(".hamburger");
const closeIcon= document.querySelector(".closeIcon");
const menuIcon = document.querySelector(".menuIcon");

function toggleMenu() {
  if (menu.classList.contains("showMenu")) {
    menu.classList.remove("showMenu");
    closeIcon.style.display = "none";
    menuIcon.style.display = "block";
  } else {
    menu.classList.add("showMenu");
    closeIcon.style.display = "block";
    menuIcon.style.display = "none";
  }
}

hamburger.addEventListener("click", toggleMenu);

menuItems.forEach( 
  function(menuItem) { 
    menuItem.addEventListener("click", toggleMenu);
  }
)

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

