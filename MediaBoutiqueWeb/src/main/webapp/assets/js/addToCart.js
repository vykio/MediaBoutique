function addToCart(id){
    $.post('panier', { product_id_to_add: id },
        function(returnedData){
            successAlert("Votre article a été ajouté!");
        }
    ).fail(function(){
        console.log("Erreur lors de l'ajout de l'article au panier");
    });
}