$(function(){ /*анонимная функция - нет имени; */
	$('#navigation > ul > li').hover(function(){ /*.hover - функция из библиотеки, возвращает эл-т при наведении, эл-т ivent*/
	$(this).find('.dd-holder').show(); /*this - указатель на объект, .find - стандартная функция,ищет первый дочерний эл-т класса  dd-holder*/
	/*делает видимым dd-holder из css*/
	$(this).find('a:eq(0)').addClass('hover'); /*a:eq(0) - первый дочерний эл-т - первый тег а*/
	/*.addClass('hover') - добавил св-во "наведен"*/
	},
	function(){
		$(this).find('.dd-holder').hide(); /* прячет эл-т в котором класс dd-holder находится */
		$(this).find('a:eq(0)').removeClass('hover'); /* типо удаляет эл-т -вообще для работы с цсс таблицей*/
	});
});



