funcao_contador = function () {
    var capicuas = db.phones.count();
    var sequencias = db.phones.count();
    var digitosn = db.phones.count();
    db.phones.find().forEach(function(find_all)
    {
        var numero = find_all._id.toString();
        for (var i = 0; i<numero.length; i++){
            if (numero[i] != numero[-i-1]){
                capicuas -= 1;
                return;
            }
        }
        print(numero + " e capicua");
        
    });
    print("Numero de capicuas: "+ capicuas);
}