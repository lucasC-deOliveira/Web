
var altura = 0
var largura = 0
var vidas = 1
var tempo = 1000
var criaMosquitoTempo = 1000
var pontos = 0


nivel =window.location.search
nivel = nivel.replace('?', '')

if(nivel ==="normal"){
	//1500
	criaMosquitoTempo = 1500
	tempo = 30

}
else if(nivel==='dificil'){
	//1000
	criaMosquitoTempo = 1000
	tempo = 30
	
}
else if(nivel==='chuck'){
	//750
	criaMosquitoTempo = 750
	tempo = 30
	}

else if(nivel==='score'){
	
	window.location.href ="app2.html"
	}




	function ajustaTamanhoPalcoJogo(){
//altura
altura = window.innerHeight
//largura
largura = window.innerWidth

console.log(largura,altura)

}

ajustaTamanhoPalcoJogo()

var cronometro = setInterval(function(){
		tempo= tempo -1

		if(tempo<0){
			clearInterval(cronometro)
			clearInterval(criaMosca)
			window.location.href= 'vitoria.html'

		}	
		else{document.getElementById('cronometro').innerHTML = tempo
	}
},1000)

var score = setInterval(function(){
	document.getElementById('score').innerHTML = pontos
}, 1000)





//criar o elemento html
function posicaoRandom(){
// remover mosquito caso exista
if(document.getElementById('mosquito')){
	document.getElementById('mosquito').remove()


	if(vidas > 3){
		window.location.href= "fim_de_jogo.html"
	}
	else{document.getElementById('v' +vidas).src= "imagens/coracao_vazio.png"
		vidas++
}
}

	//determinar posição do mosquito
	var posicaoy = Math.floor(Math.random() * altura) - 180
	var posicaox = Math.floor(Math.random() * largura )  - 180
	
	posicaox = posicaox < 0 ? 0 : posicaox
	posicaoy = posicaoy < 0 ? 0 : posicaoy

	console.log(posicaox, posicaoy)

	var mosquito = document.createElement('img')
	mosquito.src = 'imagens/mosquito.png'
	mosquito.className = tamanhoAleatorio() +" "+ladoAleatorio()
	mosquito.style.left = posicaox+"px"
	mosquito.style.top = posicaoy+"px"
	mosquito.style.position = "absolute"
	mosquito.id = 'mosquito'
	mosquito.onclick = function() {
		this.remove()
		pontos = pontos + 100



	}


	document.body.appendChild(mosquito)

}

function tamanhoAleatorio(){
	var classe = Math.floor(Math.random() * 3)
	//console.log(classe)
	switch(classe){
		case 0:
		return "mosquito1"


		case 1:
		return "mosquito2"


		case 2:
		return "mosquito3"

	}
}

function ladoAleatorio(){
	var classe = Math.floor(Math.random() * 2)
	
	switch(classe){
		case 0:
		return "ladoA"


		case 1:
		return "ladoB"
	}



}
