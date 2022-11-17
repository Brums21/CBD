funcao2_3c = function () {
    var prefixes = [21, 22, 231, 232, 233, 234 ];

    for (var i = 0; i < prefixes.length; i++){
        var total = db.phones.find( 
        {"components.prefix": prefixes[i]})
        .count()
        // criar comando que procura todos os telemoveis de cada prefixo
        print("Para o prefixo " + prefixes[i] + " ha " + total + " numeros");
    }

}