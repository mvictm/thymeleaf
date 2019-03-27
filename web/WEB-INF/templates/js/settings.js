function validate() {
    if (document.UserRegistration.names.value === "") {
        alert("Please enter your name!");
        document.UserRegistration.names.focus();
        return false;
    }

    if (document.UserRegistration.address.value === "") {
        alert("Please enter your address!");
        document.UserRegistration.focus();
        return false;
    }

    if (document.UserRegistration.city.value === "-1") {
        alert("Please select your city!");
        document.UserRegistration.city.focus();
        return false;
    }

    var email = document.UserRegistration.email.value;
    var dog = email.indexOf("@");
    var dot = email.lastIndex(".");
    var domen = email.indexOf("com");
    if (email === "" || dog < 1 || (dot - dog < 2)) {
        alert("Please enter correct email address");
        email.focus();
        return false;
    }
    return true;
}

function check(form) {
    if (form.username.value === "" || form.password.value === "") {
        alert("Your data are empy!");
        return false;
    }
}