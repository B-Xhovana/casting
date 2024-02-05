document.querySelector("#form").addEventListener("submit", validazioneForm);

// Funzione per validare il form di registrazione
function validazioneForm(event) {
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var confermaPassword = document.getElementById('confermaPassword').value;

    if (email == '') {
        document.querySelector(".email-wrapper .messageA").innerHTML="Campo obblicatorio!";
        event.preventDefault(); //prevenire il comportamento di default della submit (andare alla next page del form)
        return false;
    }
    console.log(email);

    if (password == '') {
        document.querySelector(".password-wrapper .messageB").innerHTML="Inserisci una password!";
        event.preventDefault(); //prevenire il comportamento di default della submit (andare alla next page del form)
        return false;
    }
    console.log(password);

    if (confermaPassword == '') {
        document.querySelector(".confermaPassword-wrapper .messageC").innerHTML="Conferma la password!";
        event.preventDefault(); //prevenire il comportamento di default della submit (andare alla next page del form)
        return false;
    }
    console.log(confermaPassword);
    return false;
}
