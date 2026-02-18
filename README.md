# 📱 Kotlin e Java Mobile - Aula 02: Debug e LogCat

[![Android](https://img.shields.io/badge/Android-API%2024+-3DDC84?logo=android&logoColor=white)](https://android.com)
[![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.9+-7F52FF?logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Android Studio](https://img.shields.io/badge/Android%20Studio-Otter%203-3DDC84?logo=androidstudio&logoColor=white)](https://developer.android.com/studio)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

> Projeto educacional desenvolvido para aprender técnicas de **Debug** e uso do **LogCat** no desenvolvimento Android com Java e Kotlin.

## 📚 Sobre o Projeto

Este projeto faz parte da disciplina de **Desenvolvimento Mobile** e tem como objetivo ensinar conceitos fundamentais de debugging e monitoramento de aplicações Android através de práticas hands-on.

### 🎯 Objetivos de Aprendizagem

- [x] Dominar o uso do **LogCat** para monitoramento em tempo real
- [x] Implementar diferentes níveis de log (Verbose, Debug, Info, Warning, Error)
- [x] Configurar e utilizar **breakpoints** efetivamente
- [x] Inspecionar variáveis durante a execução
- [x] Compreender o **ciclo de vida** das Activities
- [x] Analisar **stack traces** para identificar erros
- [x] Aplicar filtros no LogCat para otimizar análise
- [x] Debugar aplicações em dispositivos físicos e emuladores

## 🏗️ Estrutura do Projeto

```
Kotlin-e-Java-Mobile-Aula02-Debug-e-LogCat/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/kotlin_e_java_mobile_aula02_debug_e_logcat/
│   │   │   │   ├── MainActivity.java          # Activity principal em Java
│   │   │   │   └── Pessoa.java               # Classe modelo exemplo
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   └── activity_main.xml     # Layout principal
│   │   │   │   ├── values/
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   └── themes.xml
│   │   │   │   └── drawable/                 # Recursos visuais
│   │   │   └── AndroidManifest.xml           # Configurações do app
│   │   └── androidTest/                       # Testes instrumentados
│   └── build.gradle.kts                       # Configurações do módulo app
│
├── gradle/
│   └── wrapper/
│       └── gradle-wrapper.properties
├── build.gradle.kts                           # Configurações do projeto
├── settings.gradle.kts
├── gradle.properties
├── .gitignore
└── README.md
```

## 🚀 Como Executar

### Pré-requisitos

- **Android Studio Otter 3** ou superior
- **JDK 17** ou superior
- **Android SDK API 24+** (Android 7.0 Nougat ou superior)
- Dispositivo Android ou Emulador configurado

### Passos para Executar

#### 1️⃣ Clone o Repositório

```bash
git clone https://github.com/LucNath/Kotlin-e-Java-Mobile-Aula02-Debug-e-LogCat.git
cd Kotlin-e-Java-Mobile-Aula02-Debug-e-LogCat
```

#### 2️⃣ Abra no Android Studio

1. Abra o **Android Studio**
2. Selecione **File → Open**
3. Navegue até a pasta do projeto clonado
4. Aguarde o **Gradle** sincronizar todas as dependências

#### 3️⃣ Execute o Aplicativo

**Opção A - Emulador:**
1. Clique em **Tools → Device Manager**
2. Crie ou inicie um dispositivo virtual (AVD)
3. Clique no botão **Run** (▶️) ou pressione `Shift + F10`

**Opção B - Dispositivo Físico:**
1. Habilite as **Opções do Desenvolvedor** no dispositivo
2. Ative a **Depuração USB**
3. Conecte o dispositivo via USB
4. Selecione o dispositivo e clique em **Run**

## 🐛 Técnicas de Debug

### 1. Níveis de Log no LogCat

```java
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Verbose - Informações muito detalhadas (use com moderação)
        Log.v(TAG, "Verbose: Detalhes minuciosos da execução");
        
        // Debug - Informações úteis para debug
        Log.d(TAG, "Debug: Activity iniciada");
        
        // Info - Informações gerais de estado
        Log.i(TAG, "Info: Usuário logado com sucesso");
        
        // Warning - Avisos sobre situações inesperadas mas não críticas
        Log.w(TAG, "Warning: Conexão lenta detectada");
        
        // Error - Erros que precisam atenção
        Log.e(TAG, "Error: Falha ao carregar dados");
    }
}
```

### 2. Debug com Breakpoints

#### Como Configurar:

1. Clique na margem esquerda do editor (ao lado do número da linha)
2. Um círculo vermelho aparecerá indicando o breakpoint
3. Execute o app em modo Debug: **Run → Debug 'app'** ou `Shift + F9`

#### Durante o Debug:

- **F8** - Step Over (próxima linha)
- **F7** - Step Into (entrar no método)
- **Shift + F8** - Step Out (sair do método)
- **F9** - Resume (continuar execução)

```java
public void calcularTotal() {
    int preco = 100;
    int quantidade = 5;
    int desconto = 10;
    
    int subtotal = preco * quantidade;  // ← Coloque breakpoint aqui
    int total = subtotal - desconto;    // Inspecione as variáveis
    
    Log.d(TAG, "Total calculado: " + total);
}
```

### 3. Filtros do LogCat

#### Filtrar por Tag:
```
package:mine tag:MainActivity
```

#### Filtrar por Nível:
- **Verbose** - Mostra tudo
- **Debug** - Debug e acima
- **Info** - Info e acima
- **Warn** - Warning e Error
- **Error** - Apenas erros

#### Filtrar por Texto:
```
Exception
NullPointerException
onCreate
```

### 4. Monitoramento do Ciclo de Vida

```java
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Lifecycle";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() chamado");
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() chamado");
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() chamado - Activity visível e interativa");
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() chamado");
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() chamado");
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() chamado");
    }
}
```

## 📊 Exemplos Práticos

### Exemplo 1: Debug de Cálculos

```java
public class CalculadoraActivity extends AppCompatActivity {
    private static final String TAG = "Calculadora";
    
    private void dividir(int a, int b) {
        try {
            Log.d(TAG, "Tentando dividir " + a + " por " + b);
            int resultado = a / b;  // ← Breakpoint aqui
            Log.i(TAG, "Resultado: " + resultado);
        } catch (ArithmeticException e) {
            Log.e(TAG, "Erro: Divisão por zero!", e);
        }
    }
}
```

### Exemplo 2: Rastreamento de Objetos

```java
public class Pessoa {
    private String nome;
    private int idade;
    
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        Log.d("Pessoa", "Nova pessoa criada: " + toString());
    }
    
    @Override
    public String toString() {
        return "Pessoa{nome='" + nome + "', idade=" + idade + "}";
    }
}

// Na Activity:
Pessoa pessoa = new Pessoa("João", 25);  // ← Breakpoint aqui
Log.d(TAG, "Pessoa criada: " + pessoa);
```

### Exemplo 3: Tratamento de Exceções

```java
private void carregarDados() {
    try {
        Log.i(TAG, "Iniciando carregamento de dados...");
        
        // Simula operação que pode falhar
        String dados = obterDadosDoServidor();
        
        if (dados == null) {
            Log.w(TAG, "Dados retornados são nulos");
            return;
        }
        
        Log.i(TAG, "Dados carregados com sucesso");
        
    } catch (Exception e) {
        Log.e(TAG, "Erro ao carregar dados: " + e.getMessage(), e);
    }
}
```

## 📱 Especificações Técnicas

| Tecnologia | Versão/Configuração |
|------------|---------------------|
| **Linguagem** | Java 17 / Kotlin 1.9+ |
| **Min SDK** | API 24 (Android 7.0 Nougat) |
| **Target SDK** | API 34 (Android 14) |
| **Compile SDK** | API 34 |
| **Build System** | Gradle (Kotlin DSL) |
| **IDE** | Android Studio Otter 3 |

## 🎓 Conceitos Abordados

### Fundamentos de Debug
- ✅ Configuração de breakpoints simples e condicionais
- ✅ Inspeção de variáveis em tempo de execução
- ✅ Navegação pelo código durante debug (Step Into, Over, Out)
- ✅ Análise de call stack

### LogCat Avançado
- ✅ Diferentes níveis de log e quando usar cada um
- ✅ Criação de TAGs personalizadas
- ✅ Filtros por pacote, tag e nível
- ✅ Regex para filtros avançados

### Ciclo de Vida Android
- ✅ onCreate, onStart, onResume
- ✅ onPause, onStop, onDestroy
- ✅ onRestart, onSaveInstanceState

### Boas Práticas
- ✅ Logs informativos mas não excessivos
- ✅ Remoção de logs de debug em produção (ProGuard)
- ✅ Tratamento adequado de exceções
- ✅ Uso de constantes para TAGs

## 🛠️ Tecnologias Utilizadas

- **[Android SDK](https://developer.android.com/)** - Framework de desenvolvimento Android
- **[Java 17](https://www.oracle.com/java/)** - Linguagem de programação
- **[Kotlin](https://kotlinlang.org/)** - Linguagem moderna para Android
- **[Gradle](https://gradle.org/)** - Sistema de build
- **[Android Studio](https://developer.android.com/studio)** - IDE oficial

## 📖 Recursos de Aprendizagem

### Documentação Oficial
- [Debug Your App - Android Developers](https://developer.android.com/studio/debug)
- [Write and View Logs with Logcat](https://developer.android.com/studio/debug/logcat)
- [Activity Lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle)

### Tutoriais Recomendados
- [Debugging in Android Studio](https://developer.android.com/studio/debug)
- [Best Practices for Logging](https://developer.android.com/reference/android/util/Log)
- [Java Programming Guide](https://docs.oracle.com/javase/tutorial/)

### Vídeos e Cursos
- [Android Development for Beginners](https://developer.android.com/courses)
- [Debugging Android Apps](https://www.youtube.com/results?search_query=android+debugging+tutorial)

## 🤝 Como Contribuir

Contribuições são bem-vindas! Para contribuir:

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/NovaFuncionalidade`)
3. Commit suas mudanças (`git commit -m 'feat: adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/NovaFuncionalidade`)
5. Abra um Pull Request

## 👨‍💻 Autor

**Lucas Nathanael**
- GitHub: [@LucNath](https://github.com/LucNath)
- Disciplina: Desenvolvimento Mobile
- Instituição: UNIFOR
- Semestre: 2025.2

## 📄 Licença

Este projeto é desenvolvido para fins educacionais como parte do curso de Desenvolvimento Mobile na UNIFOR.

## 🙏 Agradecimentos

- Professor da disciplina de Desenvolvimento Mobile
- Comunidade Android Developers
- Colegas de classe que contribuíram com ideias e testes

## 📞 Suporte

Se você tiver dúvidas ou encontrar problemas:

1. Verifique a [documentação oficial do Android](https://developer.android.com/docs)
2. Abra uma [Issue](https://github.com/LucNath/Kotlin-e-Java-Mobile-Aula02-Debug-e-LogCat/issues)
3. Entre em contato via GitHub

---

<div align="center">

### ⭐ Se este projeto foi útil para você, considere dar uma estrela!

**Feito com ❤️ por Lucas Nathanael**

</div>
