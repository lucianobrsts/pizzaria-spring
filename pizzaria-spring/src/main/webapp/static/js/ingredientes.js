$(document).ready(function() {

	$('#btn-salvar').on('click', function() {
		var url = 'ingredientes';
		var dadosIngrediente = $('#form-ingrediente').serialize();

		$.post(url, dadosIngrediente).done(function() {
			alert('Ingrediente salvo com sucesso!');

		}).fail(function() {
			alert('Erro ao Salvar um ingrediente!')
		});
	});

});