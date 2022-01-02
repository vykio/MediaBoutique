function successAlert(message, id = "#success-alert") {
    $(id).html(message);
    $(id).fadeTo(5000, 500).slideUp(500, function() {
        $(id).slideUp(500);
    });
}

function failureAlert(message, id = "#failure-alert") {
    $(id).html(message);
    $(id).fadeTo(5000, 500).slideUp(500, function() {
        $(id).slideUp(500);
    });
}