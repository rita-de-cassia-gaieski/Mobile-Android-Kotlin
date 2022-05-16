# Activitys e Intents

![Aula01](https://cdn.discordapp.com/attachments/702006701628325900/944011571527561296/unknown.png)

---

## O que você irá aprender?

Conforme você navega nos apps no seu dispositivo, percebe que ocorre uma mudança em cada tela ao realizar uma ação. Nesta aula, aprenderemos alguns tipos de telas e como ocorre de fato essas interações.

## Objetivo

Criar uma aplicação utlizando a  Linguagem Kotlin que permita faça a Interação de Telas através de Activitys e Intents.

## Conteúdo

1. [Activitys](#activitys)
   - O que é uma Activity?
   - Ciclo de Vida:
2. [Intents](#intents)
   - Intent
3. [Exemplos-Prática](#exemplos)

### Activitys

#### Activity significa "atividade"

Uma activity é basicamente uma classe gerenciadora de UI (interface com o Usuário), ou seja ela é o componente chave do Android. Todo aplicativo Android começa por uma Activity.

Veja na figura a seguir a imagem de uma Classe MainActivity.kt já com o primeiro método declarado.

~~~kotlin
package rita.gaieski.exemploactivityeintent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
~~~

  >Figura 1: Classe MainActivity.kt.
  
Quando você começa a criar Telas no Android, precisa entender antes de tudo como funciona o Ciclo de Vida de uma Activity.
Em algumas ações que são realizadas durante a execução do app, como abrir, minimizar, bloquear a tela do Celular com o App aberto, ou até mesmo fechá-lo, fazem parte do Ciclo de Vida.

### Ciclo de Vida

#### Como funciona o Ciclo de Vida?

O ciclo de vida são fases que ocorrem no controle da aplicação. A activity possui um conjunto de seis callbacks (retorno de chamada), sendo que a cada atividade, o sistema chama um desses callbacks.
São eles: `onCreate()` `onStart()` `onResume()` `onPause()` `onStop()` `onDestroy()`.

Entenda como funciona cada chamada...

![CiclodeVida](https://developer.android.com/guide/components/images/activity_lifecycle.png?hl=pt-br)

  >Figura 2: Ilustração simplificada do ciclo de vida da atividade. Fonte: [Site Android Developer](https://developer.android.com/guide/components/activities/activity-lifecycle?hl=pt-br)
  
- `onCreate()` - É a primeira função a ser executada em uma Activity. Geralmente ela é responsável por carregar os layouts XML e outras operações de inicialização. É executada apenas uma vez.
- `onStart()` - É chamada imediatamente após a `onCreate()` – e também quando uma Activity que estava em background volta a ter foco.
- `onResume()` - Assim como a `onStart()`, é chamada na inicialização da Activity e também quando uma Activity volta a ter foco. Qual a diferença entre as duas? A `onStart()` só é chamada quando a Activity não estava mais visível e volta a ter o foco, já a `onResume()` é chamada nas “_retomadas de foco_”.
- `onPause()` - É a primeira função a ser invocada quando a Activity perde o foco (isso ocorre quando uma nova Activity é iniciada).
- `onStop()` - Só é chamada quando a Activity fica completamente encoberta por outra Activity.
- `onDestroy()` - A última função a ser executada. Depois dela, a Activity é considerada "_morta_" – ou seja, não pode mais ser relançada. Se o usuário voltar a requisitar essa Activity, um novo objeto será construído.

Agora que você já entendeu a teoria do Ciclo da Activity, vamos entender como aplicar através das Intents.

---

### Intents

#### A classe Intent, é chamada de intenção - intenções  

![interacoes](https://cdn.discordapp.com/attachments/702006701628325900/944074612768145408/unknown.png)

Através de alguns comandos e componentes pode-se ordenar que a activity com o foco realize uma possível ação.
Essas ações podem ser feitas em 3 formas diferentes, sendo duas delas principais.

##### Intents Explícitas

A famosa de tela pra tela. É definida explicitamente através de um componente e declarada na classe com o seu identificador. Seu controle é feito no momento da implementação do código na MainActivity.

#### Intents Implícita

Um dos exemplos mais práticos no uso de Intent implícita é criar uma aplicação que abra uma URL, ou seja, "Preciso de um componente, tenho uma URL, quem sabe abrir?" Cria-se um botão por exemplo e direciona para uma nova URL. Outro exemplo é criar uma função que inicie uma chamada para um determinado numero.

#### Intent Filter – feita pelo próprio programa

Quando se recebe uma intenção para abrir uma URL por exemplo, o programa recebe essa intenção e faz um filtro. No caso abrir um PDF, uma música. Outro exemplo é na hora de efetuar o download de um comprovante/arquivo, abre então uma janela de diálogo e pergunta com qual programa você deseja abrir o arquivo. Escolha um padrão..

---

### Exemplos - Prática

#### Vamos praticar?

 1. Comece criando um Projeto em Kotlin com o nome: ExemploActivityEIntent
  ![projeto1](https://cdn.discordapp.com/attachments/702006701628325900/944080559708188672/unknown.png)![projeto2](https://cdn.discordapp.com/attachments/702006701628325900/944079971276709958/unknown.png)
 2. Crie duas Telas, ou seja, duas empty activitys para realizar a interação de forma explícita. A primeira Tela permanecerá com o nome "MainActivity" e a segunda como "Screen2".
 3. Mude a cor do plano de fundo de ambas as Telas, para que você posso perceber a troca no momento da ação.
 4. Crie um TextView com a Frase: Olá você esta na Tela 2.
 5. Na primeira Tela poderá ter um Botão de Ação, no caso a ida para a próxima Tela.

   ![tela1](https://cdn.discordapp.com/attachments/702006701628325900/944082423174545418/unknown.png) ![tela2](https://cdn.discordapp.com/attachments/702006701628325900/944082548718452737/unknown.png)

##### Comandos Básicos da classe

- Classe Intent: (intenções):são comandos que podemos enviar ao Sistema Operacional Android para realizar alguma ação de envio ou recuperação de dados.
- Método startActivity(Intent intent): envia dados e requisições de telas.
  
##### Arquivo AndroidManifest

É onde acontece o mapeamento das Activitys. Todo projeto Android deve conter um arquivo AndroidManifest.xml, que funciona como o web.xml de um mapeamento de
servlets em Java, ou seja, descreve os componentes de aplicação, define nomes para as activitys, modos de orientação da tela (vertical, horizontal ou ambos), declara permissões para acesso aos
recursos como o GPS ou Internet por exemplo, lista também as bibliotecas que a aplicação vai usar e ainda qual activity iniciará primeiro quando a aplicação for aberta.

~~~xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="rita.gaieski.exemploactivityeintent">
    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.ExemploActivityEIntent">
        <activity
            android:name=".Screen2"
            android:exported="false" />
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>
~~~

#### Criando a função de interação na MainActivity - Explícita

Comandos da Classe MainActivity

~~~kotlin
package rita.gaieski.exemploactivityeintent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
class MainActivity : AppCompatActivity() {
    // criando a var do button
    private lateinit var botaoScreen2 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buscarReferencias()
        botaoScreen2.setOnClickListener {
            // Criando a intent..intenções
            val intent = Intent(this@MainActivity, Screen2::class.java)
            startActivity(intent)
        }
    }
        private fun buscarReferencias(){
            botaoScreen2 = findViewById(R.id.btScreen2)
        }
}// fim 
~~~

#### Exemplo de Intent ímplicita - Realizando uma Ligação

Antes de iniciar o exemplo, você precisa adicionar no arquivo AndroidManifest a seguinte permissão:

~~~xml
<uses-permission android:name="android.permission.CALL_PHONE"></uses-permission>
~~~

Criando as variáveis:

~~~kotlin
private lateinit var btDiscar : Button
private lateinit var etTelefone : EditText
~~~

Criando a função do Botão Discar e leitura do Campo de texto - telefone:

~~~kotlin
btDiscar.setOnClickListener {
  //intent da ligação
  var telefone = etTelefone.text.toString()
  var intent = Intent(Intent.ACTION_DIAL,Uri.parse("tel:${telefone}"))
  startActivity(intent)
}
~~~

Função Buscar Referências - Ids

~~~kotlin
private fun buscarReferencias(){
    botaoScreen2 = findViewById(R.id.btScreen2)
    btDiscar = findViewById(R.id.btDiscar)
    etTelefone = findViewById(R.id.etTelefone)
}
~~~

Links de Apoio:

- Interação com Outros Apps [Android Developer](https://developer.android.com/training/basics/intents?hl=pt-br)
- Introdução a Activitys (Atividades)[Android Developer](https://developer.android.com/guide/components/activities/intro-activities?hl=pt-br)
- Trabalhando com Intents [Android Developer](https://developer.android.com/guide/components/intents-filters)
- Permissões no Android [Android Developer](https://developer.android.com/guide/topics/permissions/overview?hl=pt-br)
- Try Kotlin [Kotlin](https://kotlinlang.org/)

### Gabarito

Baixe a pasta para ter acesso ao Gabarito.

#### Bons Estudos
  