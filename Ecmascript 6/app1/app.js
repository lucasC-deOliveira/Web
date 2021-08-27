class Despesa{
	constructor(dia,mes,ano,tipo,descricao,valor){
		this.dia = dia
		this.mes = mes
		this.ano = ano
		this.tipo = tipo
		this.descricao = descricao
		this.valor = valor
	}


	validarDados(){
		for(let i in this){
			if(this[i]==undefined || this[i]=="" || this[i]==null || this[i] =="0"){
				return false
			}
			return true
		}
	}
}

class Bd{
	constructor(){
		let id = localStorage.getItem('id')
		if(id===null){
			localStorage.setItem('id',0)
		}
	}


	getProximoId(){
	//recuperar item
	let proximoId= localStorage.getItem('id')
	return parseInt(proximoId)+1
}

gravar(d){
	//acessar localStorage
	//localStorage.setItem('identificador', JSON)
	//converter objeto para JSON
	//da pra conveter JSON para objeto se preciso: JSON.parse(notação json)
	//localStorage.setItem('despesa', JSON.stringify(d))
	let id =this.getProximoId()

	localStorage.setItem(id, JSON.stringify(d))

	localStorage.setItem('id', id)

}

pesquisar(despesa){
	let despesasFiltradas = []
	despesasFiltradas= this.recuperarTodosRegistros()

	console.log(despesasFiltradas)
	console.log(despesa)

	//ano
	if(despesa.ano != ''){
		despesasFiltradas = despesasFiltradas.filter(d => d.ano == despesa.ano)
	}

	//mes
	if(despesa.mes != ''){
		despesasFiltradas = despesasFiltradas.filter(d => d.mes == despesa.mes)
	}

	//dia

	if(despesa.dia != ''){
		despesasFiltradas = despesasFiltradas.filter(d => d.dia == despesa.dia)
	}

	//tipo
	if(despesa.tipo != ''){
		despesasFiltradas = despesasFiltradas.filter(d => d.tipo == despesa.tipo)
	}

	//descrição
	if(despesa.descricao != ''){
		despesasFiltradas = despesasFiltradas.filter(d => d.descricao == despesa.descricao)
	}

	//valor
	if(despesa.valor != ''){
		despesasFiltradas = despesasFiltradas.filter(d => d.valor == despesa.valor)
	}

	console.log(despesasFiltradas)
	return despesasFiltradas
}


recuperarTodosRegistros(){
	//array de despesas
	let despesas = []
	let id = localStorage.getItem('id')

	for(let i = 1; i<=id; i++){
		let despesa = JSON.parse(localStorage.getItem(i))
		//pular indices vazios//null
		if(despesa==null){
			continue
		}
		despesa.id = i
		despesas.push(despesa)
	}
	return despesas
}


remover(id){
	localStorage.removeItem(id)

}


}


let bd = new Bd()



function cadastrarDespesa(){
	let dia = document.getElementById('dia')
	let mes = document.getElementById('mes')
	let ano = document.getElementById('ano')
	let tipo = document.getElementById('tipo')
	let descricao = document.getElementById('descricao')
	let valor = document.getElementById('valor')

	let despesa = new Despesa(dia.value, mes.value, ano.value, tipo.value, descricao.value, valor.value)
	console.log(despesa.validarDados())
	
	if(despesa.validarDados()){
		bd.gravar(despesa)
		document.getElementById('ano').value=""
		document.getElementById('mes').value=""
		document.getElementById('dia').value=""
		document.getElementById('tipo').value=""
		document.getElementById('descricao').value=""
		document.getElementById('valor').value=""
		console.log('dados validos')

		$('#modalRegistraDespesa').modal('show')
		document.getElementById('exampleModalLabel').innerHTML = 'Sucesso'
		document.getElementById('modal-header-div').className = `text-success modal-header`
		document.getElementById('descricao-modal').innerHTML = 'Despesa cadastrada com sucesso!'
		document.getElementById('button-modal').innerHTML = 'voltar'
		document.getElementById('button-modal').className = `btn btn-success`
	}
	else{
		console.log('dados invalidos')
		$('#modalRegistraDespesa').modal('show')
		document.getElementById('exampleModalLabel').innerHTML = 'Erro Campos Invalidos'
		document.getElementById('modal-header-div').className = `text-danger modal-header`
		document.getElementById('descricao-modal').innerHTML = 'Preencha os campos corretamente'
		document.getElementById('button-modal').innerHTML = 'corrigir'
		document.getElementById('button-modal').className = `btn btn-danger`

	}
	console.log(despesa)}

	function carregaListaDespesas(despesas = new Array(), filtro = false){
		if(despesas.length ==0 && filtro ==false){
		despesas =bd.recuperarTodosRegistros()
	}
		console.log(despesas)
		let listaDespesas = document.getElementById('listaDespesas')
		listaDespesas.innerHTML = ''

	//listar cada dispesa de forma dinamica
	despesas.forEach(function(d){
		//console.log(d)
		//criar <th>
		let linha= listaDespesas.insertRow()
		//criar as colunas (td)
		//começa em zero
		linha.insertCell(0).innerHTML =	`${d.dia}/${d.mes}/${d.ano}`
		//ajustar tipo
		switch (d.tipo){
			case '1':
			d.tipo = 'Alimentação' 

			break

			case '2': 
			d.tipo = 'Educação'
			break

			case '3': 
			d.tipo = 'Lazer'
			break

			case '4': 
			d.tipo = 'Saude'
			break

			case '5': 
			d.tipo = 'Transporte'
			break


		}
		linha.insertCell(1).innerHTML = d.tipo
		linha.insertCell(2).innerHTML = d.descricao
		linha.insertCell(3).innerHTML = d.valor


		//botao de exclusão

		let btn = document.createElement('button')
		linha.insertCell(4).append(btn)
		btn.className = 'btn btn-danger'
		btn.innerHTML ='<i class="fas fa-times"></i>'
		btn.id= 'id_despesa_'+d.id
		btn.onclick = function(){
			let id = this.id.replace('id_despesa_','')

			
			bd.remover(id)
			window.location.reload()

		}
		


	})

}

function pesquisarDespesa(){
	console.log('teste')

	let ano = document.getElementById('ano').value
	let mes = document.getElementById('mes').value
	let dia = document.getElementById('dia').value
	let tipo = document.getElementById('tipo').value
	let descricao = document.getElementById('descricao').value
	let valor = document.getElementById('valor').value

	let despesa = new Despesa(dia,mes,ano,tipo,descricao,valor)
	let despesas = bd.pesquisar(despesa)

	this.carregaListaDespesas(despesas, true)

}

