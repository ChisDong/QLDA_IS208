const passwordInput = document.getElementById("password");
const togglePassword = document.getElementById("toggle-password");
const emailInput = document.getElementById("email");
const emailCheck = document.getElementById("email-check");

togglePassword.addEventListener("click", () => {
    const type = passwordInput.getAttribute("type");
    passwordInput.setAttribute("type", type === "password" ? "text" : "password");
});

emailInput.addEventListener("input", () => {
    const email = emailInput.value;
    emailCheck.classList.toggle("hidden", !email.includes("@") || !email.includes("."));
});

function handleLogin(event) {
    event.preventDefault();
    const email = emailInput.value;
    const password = passwordInput.value;

    // Giả sử luôn thành công
    if (email && password.length >= 8) {
        window.location.href = "index.html"; // ← Chuyển hướng tại đây
    } else {
        alert("Please enter valid credentials.");
    }
}
