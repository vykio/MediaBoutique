function removeFromCart(id){
    $.post('panier', { product_id_to_remove: id },
        function(returnedData){
            let buttonToDelete = document.getElementById("button-remove-"+id);
            let row = buttonToDelete.parentElement.parentElement;
            row.parentNode.removeChild(row);

            $("#panierTotal").text(returnedData);

            successAlert("Votre article a été supprimé!");
        }
    ).fail(function(){
        console.log("Erreur lors de la suppression de l'article du panier");
    });
}