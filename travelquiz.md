
<style>
    *, *::before, *::after {
        box-sizing: border-box;
        font-family: ".AppleSystemUIFont";
    }

    :root {
        --hue-neutral: 200;
        --hue-wrong: 0;
        --hue-correct: 145;
    }

    body.correct {
        --hue: var(--hue-correct);
    }

    body.wrong {
        --hue: var(--hue-wrong);
    }

    .container {
        width: 800px;
        max-width: 80%;
        background-color: white;
        border-radius: 5px;
        padding: 10px;
        font-family: .AppleSystemUIFont;
    }

    .btn-grid {
        display: grid;
        grid-template-columns: repeat(2, auto);
        gap: 10px;
        margin: 20px 0;
        font-family: .AppleSystemUIFont;
    }

    .btn {
        --hue: var(--hue-neutral);
        border: 1px solid hsl(var(--hue), 100%, 30%);
        background-color: hsl(var(--hue), 100%, 50%);
        border-radius: 5px;
        padding: 5px 10px;
        color: white;
        outline: none;
        font-family: .AppleSystemUIFont;
    }

    .btn:hover {
        border-color: black;
    }

    .btn.correct {
        --hue: var(--hue-correct);
        color: black;
    }

    .btn.wrong {
        --hue: var(--hue-wrong);
    }

    .start-btn, .next-btn {
        font-size: 1.5rem;
        font-weight: bold;
        padding: 10px 20px;
    }

    .controls {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .hide {
        display: none;
    }

</style>


<center>


    &nbsp;&nbsp;

    &nbsp;&nbsp;
    <br>


    <body>
    <div class="container">
        <div id="question-container" class="hide">
            <div id="question">Question</div>
            <div id="answer-buttons" class="btn-grid">
                <button class="btn">Answer 1</button>
                <button class="btn">Answer 2</button>
                <button class="btn">Answer 3</button>
                <button class="btn">Answer 4</button>
            </div>
        </div>
        <div class="controls">
            <button id="start-btn" class="start-btn btn">Start</button>
            <button id="next-btn" class="next-btn btn hide">Next</button>
        </div>
    </div>
    </body>
    <br>
    <br>
  

    <script>
        const startButton = document.getElementById('start-btn')
        const nextButton = document.getElementById('next-btn')
        const questionContainerElement = document.getElementById('question-container')
        const questionElement = document.getElementById('question')
        const answerButtonsElement = document.getElementById('answer-buttons')

        let shuffledQuestions, currentQuestionIndex

        startButton.addEventListener('click', startGame)
        nextButton.addEventListener('click', () => {
            currentQuestionIndex++
            setNextProblem()
        })

        function startGame() {
            startButton.classList.add('hide')
            shuffledQuestions = questions.sort(() => Math.random() - .5)
            currentQuestionIndex = 0
            questionContainerElement.classList.remove('hide')
            setNextProblem()
        }

        function setNextProblem() {
            resetState()
            showQuestion(shuffledQuestions[currentQuestionIndex])
        }

        function showQuestion(question) {
            questionElement.innerText = question.question
            question.answers.forEach(answer => {
                const button = document.createElement('button')
                button.innerText = answer.text
                button.classList.add('btn')
                if (answer.correct) {
                    button.dataset.correct = answer.correct
                }
                button.addEventListener('click', selectAnswer)
                answerButtonsElement.appendChild(button)
            })
        }

        function resetState() {
            clearStatusClass(document.body)
            nextButton.classList.add('hide')
            while (answerButtonsElement.firstChild) {
                answerButtonsElement.removeChild(answerButtonsElement.firstChild)
            }
        }

        function selectAnswer(e) {
            const selectedButton = e.target
            const correct = selectedButton.dataset.correct
            setStatusClass(document.body, correct)
            Array.from(answerButtonsElement.children).forEach(button => {
                setStatusClass(button, button.dataset.correct)
            })
            if (shuffledQuestions.length > currentQuestionIndex + 1) {
                nextButton.classList.remove('hide')
            } else {
                startButton.innerText = 'Restart'
                startButton.classList.remove('hide')
            }
        }

        function setStatusClass(element, correct) {
            clearStatusClass(element)
            if (correct) {
                element.classList.add('correct')
            } else {
                element.classList.add('wrong')
            }
        }

        function clearStatusClass(element) {
            element.classList.remove('correct')
            element.classList.remove('wrong')
        }

        const questions = [
            {
                question: 'How far is Hawaii from the Mainland?',
                answers: [
                    { text: '4000 miles', correct: false },
                    { text: '2000 miles', correct: true },
                    { text: '555 miles', correct: false },
                    { text: '800 miles', correct: false },
                ]
            },
            {
                question: 'In which island is Bora Bora located?',
                answers: [
                    { text: 'The Philippines', correct: false },
                    { text: 'Japan', correct: false },
                    { text: 'Sicily', correct: false },
                    { text: 'French Polynesia', correct: true }
                ]
            },
            {
                question: 'Where is the popular tourist destination Santorini located??',
                answers: [
                    { text: 'Alaska', correct: false },
                    { text: 'Hawaii', correct: false },
                    { text: 'Greece', correct: true },
                    { text: 'Haiti', correct: false }
                ]
            },
            {
                question: 'Where is the Louvre located?',
                answers: [
                    { text: 'Canada', correct: false },
                    { text: 'The United States', correct: false },
                    { text: 'Belgium', correct: false },
                    { text: 'France', correct: true },

                ]
            }
        ]
    </script>

