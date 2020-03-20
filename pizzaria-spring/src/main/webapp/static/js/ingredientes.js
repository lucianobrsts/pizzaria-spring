$(document).ready(function() {

	aplicarListeners();

});

var aplicarListeners = function() {
	$('.btn-deletar').on('click', function() {
		var id = $(this).parents('tr').data('id');
		var ingredientes = $('#quantidade-ingredientes').text();

		$.ajax({
			url : "ingredientes/" + id,
			type : 'DELETE',
			success : function(result) {
				$('tr[data-id="' + id + '"]').remove();
				$('#quantidade-ingredientes').text(ingredientes - 1);
			}
		});
	});

	$('#btn-salvar').on('click', function() {
		var url = 'ingredientes';
		var dadosIngrediente = $('#form-ingrediente').serialize();

		$.post(url, dadosIngrediente).done(function(pagina) {
			$('#secao-ingredientes').html(pagina)
			aplicarListeners();

		}).fail(function() {
			alert('Erro ao salvar!');

		}).always(function() {
			$('#modal-ingrediente').modal('hide');
		});
	});
}