


name = "";
eId = 0;
manager = undefined;
//__________Button________________________________________________________________________

const loginBtn = document.getElementById("loginBtn");
const signupBtn = document.getElementById("signupBtn");
const registerBtn = document.getElementById("registerBtn")
const reimApplyBtn = document.getElementById("reimApplyBtn")
const submitReimBtn = document.getElementById("submitReimBtn")
const logoutBtn = document.getElementsByClassName("logoutBtn")
const empSelector = document.getElementById("empSelector")
const managSelector = document.getElementById("managSelector")
//___________Div blocks_______________________________________________________________________

const register = document.getElementById("register");
const login = document.getElementById("login")
const empShow = document.getElementById("empShow")
const manaShow = document.getElementById("manaShow")
const reimApply = document.getElementById("reimApply")
const accountSelector = document.getElementById("accountSelector")
const managerVerfication = document.getElementById("managerVerfication")

//_______________Log In input elements_____________________________________________________________________________
const tryusername = document.getElementById("username")
const trypassword = document.getElementById("password")
//____________Tables__________________________________________________________________________
const empReimTbl = document.getElementById("empReimTbl")
const ManaReimTbl = document.getElementById("ManaReimTbl")
//____________status element___________________________________________________________________
const statusButtons = document.getElementsByClassName("statusButtons")
//___________Reimbursement application inputs________________________________________________________________
const amount = document.getElementById("amount")
const description = document.getElementById("description")
//____________Register values_____________________________________________________________________________________________________
const rname = document.getElementById("rname")
const rusername = document.getElementById("rusername")
const rpassword = document.getElementById("rpassword")
//____________Log In_______________________________________________________________________

loginBtn.addEventListener("click", loginBtnHandler )


function loginBtnHandler(){

    let usernameVal = tryusername.value;
    let passwordVal = trypassword.value;
    // let data = {"username":usernameVal,"password" : passwordVal};

    // console.log(JSON.stringify(data))

    // getReimbursements();


    getLoggedIn();
    async function getLoggedIn(){
        let httpResponse = await fetch("http://localhost:8080/ReimSystem/api/login")
        let users = await httpResponse.json();
        incorrectCount = 0;
        for(i=0;i<users.length;i++){
            incorrectCount++
            if (users[i].username === usernameVal && users[i].password === passwordVal){
                name = users[i].name;
                eId = users[i].employeeId;
                manager = users[i].manager;
                    hide(login)
                    incorrectCount = 0;
                    if(manager){
                        appear(manaShow)
                        let httpResponse = await fetch("http://localhost:8080/ReimSystem/api/reimbursements");
                        let body = await httpResponse.json();
                        let buttonId = 100;
                        for(let i=0;i<body.length;i++){
                            buttonId++;
                            // console.log(body[i])
                            if(body[i].Status == "Pending"){
                                buttons = 
                            `<div class = statusButtons >
                            <td><button  class = c${buttonId} ; id = ${body[i].rId} >Approve</button></td>
                            <td><button  class = c${buttonId} ; id = ${body[i].rId}>Deny</button></td></tr></div>`;
                            }else{
                                buttons = "<td></td><td></td>" ;
                            }
                            ManaReimTbl.innerHTML +=
                            `<tr><td>$${body[i].amount}</td>
                            <td>${body[i].description}</td>
                            <td id = ${body[i].rId}stat>${body[i].Status}</td>` + buttons ;
                        }
                    }else {
                    appear(empShow)
                    let httpResponse = await fetch("http://localhost:8080/ReimSystem/api/reimbursements");
                    let body = await httpResponse.json();
                    showEmployeePage(body)
                    }

            }
        }
        if(incorrectCount == users.length){
            alert("You have entered incorrect username or password! Please try again")
        }
    }
    function getMyReimbursements(id){
        allreimbursements = getReimbursements()
        console.log(id)
    }
}
//_____________________SHow Employee function for reusability_______________________________________________________
function showEmployeePage(body){

for(let i=0;i<body.length;i++){
    // console.log(body[i].employeeId)
    if (body[i].employeeId === eId){
        empReimTbl.innerHTML +=
        `<tr><td>$ ${body[i].amount}</td>
        <td>${body[i].description}</td>
        <td>${body[i].Status}</td></tr>`;
    }
}
}

//____________Sign up_________________________________________________________________________

signupBtn.addEventListener("click", signupBtnHandler)

function signupBtnHandler(){
    // console.log("hits sign up button")
    appear(accountSelector);
    hide(login)
}
//____________Register as Employee_____________________________________________________________
empSelector.addEventListener("click", accountSelectorHandler)
function accountSelectorHandler(){
    appear(register)
    hide(accountSelector)
}
//____________Manager Verification_______________________________________________________________

managSelector.addEventListener("click",managSelectorHandler)

function managSelectorHandler(){
    appear(managerVerfication)
    hide(accountSelector)
}

//_____________Register_________________________________________________________________________

registerBtn.addEventListener("click", registerBtnHandler)

function registerBtnHandler(){
    let rnameVal = rname.value
    let rusernameVal = rusername.value
    let rpasswordVal = rpassword.value

    recordEmployee()

    async function recordEmployee(){

        let data = {"name":rnameVal,"username" : rusernameVal, "password" : rpasswordVal }

        let httpResponse = await fetch("http://localhost:8080/ReimSystem/api/registeremployee",
            {
                 method: 'POST',
                 headers: {
                   'Accept': 'application/json',
                  'Content-Type': 'application/json'
                 },
                 body: JSON.stringify(data)
                //  `{rId=0, amount=${amountVal}, description=${descriptionVal}, Status=Approved, employeeId=${eId}}`
            });

    }

    alert("You have registered successfully. Please log in")
    tryusername.value = ""
    trypassword.value = ""
    rname.value = ""
    rusername.value = ""
    rpassword.value = ""
    mname.value = ""
    musername.value = ""
    mpassword.value = ""
    secret.value = ""
    appear(login)
    hide(register)

}
//___________Employee show_____________________________________________________________________________

reimApplyBtn.addEventListener("click", reimApplyBtnHandler)

function reimApplyBtnHandler(){
    hide(empShow)
    appear(reimApply)
}

//___________Apply for Reimbursements___________________________________________________________________________

submitReimBtn.addEventListener("click", submitReimBtnHandler)

function submitReimBtnHandler(){


    amountVal = amount.value
    descriptionVal = description.value

    console.log(JSON.stringify(descriptionVal))

    createReimbursement()

    async function createReimbursement(){

        let data = {"amount":amountVal,"description" : descriptionVal, "employeeId" : eId }

        let httpResponse = await fetch("http://localhost:8080/ReimSystem/api/reimbursementapplication",
            {
                 method: 'POST',
                 headers: {
                   'Accept': 'application/json',
                  'Content-Type': 'application/json'
                 },
                 body: JSON.stringify(data)
                //  `{rId=0, amount=${amountVal}, description=${descriptionVal}, Status=Approved, employeeId=${eId}}`
            });
            empReimTbl.innerHTML = ` <tr><th>Amount</th><th>Description</th><th>Status</th></tr>`;
            let rerenderingEmployee = await fetch("http://localhost:8080/ReimSystem/api/reimbursements");
            let body = await rerenderingEmployee.json();
            showEmployeePage(body)

    }
    amount.value = ""
    description.value = ""
    hide(reimApply)
    appear(empShow)
}

//__________Log out Button______________________________________________________________________________


for(i=0;i<logoutBtn.length;i++){
logoutBtn[i].addEventListener("click", logoutBtnHandler )
}

function logoutBtnHandler(){
    name = "";
    eId = 0;
    manager = undefined;
    tryusername.value = ""
    trypassword.value = ""
    rname.value = ""
    rusername.value = ""
    rpassword.value = ""
    mname.value = ""
    musername.value = ""
    mpassword.value = ""
    secret.value = ""
    appear(login)
    hide(empShow)
    hide(manaShow)
    ManaReimTbl.innerHTML = ` <tr><th>Amount</th><th>Description</th><th>Status</th></tr>`;
    empReimTbl.innerHTML = ` <tr><th>Amount</th><th>Description</th><th>Status</th></tr>`;
}

//___________Hide element helper functions___________________________________________________________________________

function hide(element){
    element.style.display = 'none';
}

function appear(element){
    element.style.display = 'block';
}

//________________Status change buttons handling_______________________________________________________________________________
ManaReimTbl.addEventListener("click",ReimStatusChange)

function ReimStatusChange(e){
    let buttonClass = e.target.className;
    let rowBtns = document.getElementsByClassName(`${buttonClass}`);
    for(i=0;i<rowBtns.length;i++){
    hide(rowBtns[i])
    }
    // console.log(e.target.innerHTML === "Approve")

    if(e.target.innerHTML === "Approve"){
        let reimId = e.target.id
        let statusId = document.getElementById(`${reimId}stat`)
        statusId.innerHTML = "Approved"
        getApproved()
        async function getApproved(){
            let httpResponse = await fetch("http://localhost:8080/ReimSystem/api/approveReimbursement",
                {
                     method: 'POST',
                     headers: {
                       'Accept': 'application/json',
                      'Content-Type': 'application/json'
                     },
                     body: `{rId=${reimId}, amount=0, description=null, Status=Approved}`
                });

        }
    }
    if(e.target.innerHTML === "Deny"){
        let reimId = e.target.id
        let statusId = document.getElementById(`${reimId}stat`)
        statusId.innerHTML = "Denied"

        getDenied()
        async function getDenied(){
            let httpResponse = await fetch("http://localhost:8080/ReimSystem/api/denyReimbursement",
                {
                     method: 'POST',
                     headers: {
                       'Accept': 'application/json',
                      'Content-Type': 'application/json'
                     },
                     body: `{rId=${reimId}, amount=0, description=null, Status=Denied}`
                });

        }

    }


}

//_____________________Secret handling__________________________________________________________________________

const secretBtn = document.getElementById("secretBtn")
const secret = document.getElementById("secret")
const mregister = document.getElementById("mregister")
secretBtn.addEventListener("click", secretBtnHandler)

function secretBtnHandler(){
    if(secret.value === "12345"){
        secret.value = ""
        appear(mregister)
        hide(managerVerfication)
    }else{
        alert("You have entered incorrect secret code. Please try again!")
    }
}
//___________________Manager Registration______________________________________________________________________________
const mregisterBtn = document.getElementById("mregisterBtn")
const mname = document.getElementById("mname")
const musername = document.getElementById("musername")
const mpassword = document.getElementById("mpassword")


mregisterBtn.addEventListener("click", mregisterBtnHandler)

function mregisterBtnHandler(){
    let mnameVal = mname.value
    let musernameVal = musername.value
    let mpasswordVal = mpassword.value

    recordManager()

    async function recordManager(){

        let data = {"name":mnameVal,"username" : musernameVal, "password" : mpasswordVal }

        let httpResponse = await fetch("http://localhost:8080/ReimSystem/api/registermanager",
            {
                 method: 'POST',
                 headers: {
                   'Accept': 'application/json',
                  'Content-Type': 'application/json'
                 },
                 body: JSON.stringify(data)
                //  `{rId=0, amount=${amountVal}, description=${descriptionVal}, Status=Approved, employeeId=${eId}}`
            });

    }

    alert("You have registered successfully. Please log in")
    tryusername.value = ""
    trypassword.value = ""
    rname.value = ""
    rusername.value = ""
    rpassword.value = ""
    mname.value = ""
    musername.value = ""
    mpassword.value = ""
    secret.value = ""
    appear(login)
    hide(mregister)

}