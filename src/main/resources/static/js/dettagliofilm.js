//GESTIONE PLAYER INTEGRATO DI YOUTUBE PER TRAILER FILM
let player; 

function onYouTubeIframeAPIReady() {
	var trailer = document.getElementById("trailer").value;
    console.log("API caricato");
    player = new YT.Player("player", {
        height: 315,
        width: 560,
        videoId: trailer,
        playerVars: {
            playsinline: 1,
            autoplay: 0,
            controls: 1
        },
        events: {
            'onReady': onPlayerReady,
            'onStateChange': onPlayerStateChange
        }
    }); 
}

function onPlayerReady() {
    console.log("player pronto");
}

let done = false; 

function onPlayerStateChange(event) {
    if (event.data == YT.PlayerState.PLAYING && !done) {
        done = true;
    }
}
