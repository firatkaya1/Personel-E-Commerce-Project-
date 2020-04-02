function createRandomCode() {
    document.getElementById("inputRandomCode").value = randomCode();
}

function createDiscountCode() {
    document.getElementById("inputDiscountCode").value = randomDiscountCode();
}

function clearTextArea() {

    document.getElementById("productExplain").value = "";
}

function clearFileArea() {
    for (var i = 0; i < 4; i++) {
        document.getElementById("file" + i).value = "";
    }

}

function clearAllArea() {
    var elements = document.getElementsByTagName("input");
    for (var ii = 0; ii < elements.length; ii++) {
        if (elements[ii].type == "text") {
            elements[ii].value = "";
        }
    }
}

function disableAllElements() {
    var elems = document.getElementsByTagName('input');
    var len = elems.length;

    var buttons = document.getElementsByTagName('button');
    var button_len = buttons.length;


    for (var i = 0; i < len; i++) {
        if (elems[i].disabled == true) {
            elems[i].disabled = false;
        } else {
            elems[i].disabled = true;
        }
    }

    for (var i = 0; i < button_len; i++) {
        if (buttons[i].disabled == true) {
            buttons[i].disabled = false;
        } else {
            buttons[i].disabled = true;
        }
    }

    document.getElementById("locked").disabled = false;


}

function randomCode() {
    var alphabe = ["A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "M", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
        "Y", "Z",
    ]
    var code = "";
    for (var i = 0; i < 6; i++) {
        code += alphabe[Math.floor(Math.random() * (alphabe.length - 1))];
    }
    return code;
}

function randomDiscountCode() {
    var alphabe = ["A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "M", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
        "Y", "Z",
    ]
    
    var code = "";
    for (var i = 0; i < 9; i++) {
        code += alphabe[Math.floor(Math.random() * (alphabe.length - 1))];
    }
    return code;

}