$(document).ready(function() {

	aplicarListener();

});

var aplicarListener = function() {
	$('#btn-salvar').on('click', function() {
		var url = 'pizzas';
		var dadosIngrediente = $('#form-pizza').serialize();

		$.post(url, dadosIngrediente).done(function(pagina) {
			$('#secao-pizzas').html(pagina)
			aplicarListeners();

		}).fail(function() {
			alert('Erro ao salvar!');

		}).always(function() {
			$('#modal-pizza').modal('hide');
		});
	});

	$('.btn-deletar').on('click', function() {
		var pizzaId = $(this).parents('tr').data('id');

		$.ajax({
			url : 'pizzas/' + pizzaId,
			type : 'DELETE',
			success : function() {
				$('tr[data-id="' + pizzaId + '"]').remove();
				var pizzas = parseInt($('#quantidade-pizzas').text());
				$('#quantidade-pizzas').text(pizzas - 1);
			}
		});
	});
	
	$('.btn-editar').on('click', function() {
		var pizzaId = $(this).parents('tr').data('id');
		var url = 'pizzas/' + pizzaId;
		
		$.get(url).success(function(pizza) {
			$('#id').val(pizza.id);
			$('#nome').val(pizza.nome);
			$('#preco').val(pizza.preco);
			$('#categoria').val(pizza.categoria);
			$('#ingredientes').val(pizza.ingredientes);
			
			$('#modal-pizza').modal('show');
		});
	});
};