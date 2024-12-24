let totalQestions = 0;
let questions =[];
let currentQuestionIndex = 0;
let correctAnswers = 0;

async function fetchQuestions() {
    try{
        const response = await fetch('http://localhost:9090/api/java/questions');

        if(!response.ok){
            throw new Error('Network response was not OK');
        }

        questions = await response.json();
        totalQestions = questions.length;
        console.log(totalQestions);
        document.getElementById('total-question').textContent = totalQestions;
        displayQuestion();
    }catch(error){
        console.error("Error fetching questions: ",error);
        document.getElementById('question-text').textContent = "Failed to load questions . Please try again..."
    }
}

function displayQuestion(){
    if(questions.length === 0)return;

    const questionText = document.getElementById('question-text');
    const optionContainer = document.getElementById('options-container');
    const currentQuestion = questions[currentQuestionIndex];

    questionText.textContent = currentQuestion.question;
    optionContainer.innerHTML =''; //clearing previous data

    currentQuestion.options.forEach(option => {
        const btn = document.createElement('button');
        btn.textContent = option;
        btn.className = 'option';
        btn.onclick = () => checkAnswer(option);
        optionContainer.appendChild(btn);
    });

    document.getElementById('current-question').textContent = currentQuestionIndex + 1;

}

function checkAnswer(selectedOption){
    const currentQuestion = questions[currentQuestionIndex];


    if(selectedOption === currentQuestion.answer){
        correctAnswers++;
    }

    nextQuestion();
}

function nextQuestion() {
    if(currentQuestionIndex < questions.length - 1){
        currentQuestionIndex++;
        displayQuestion();
    }else{
        //store in local storage 
        localStorage.setItem('quizScore',correctAnswers);
        localStorage.setItem('totalQuestions',totalQestions);
        window.location.href = 'result.html';
    }
}

window.onload = fetchQuestions;