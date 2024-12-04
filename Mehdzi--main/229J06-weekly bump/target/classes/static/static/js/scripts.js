document.addEventListener("DOMContentLoaded", function() {
    // Handle form validation for login and registration forms
    const loginForm = document.querySelector("form[action='/login']");
    const registerForm = document.querySelector("form[action='/register']");

    if (loginForm) {
        loginForm.addEventListener("submit", function(e) {
            const email = document.getElementById("email");
            const password = document.getElementById("password");

            if (!email.value || !password.value) {
                e.preventDefault();
                alert("Please enter both email and password.");
            }
        });
    }

    if (registerForm) {
        registerForm.addEventListener("submit", function(e) {
            const email = document.getElementById("email");
            const password = document.getElementById("password");

            if (!email.value || !password.value) {
                e.preventDefault();
                alert("Please fill in all fields.");
            }
        });
    }
});

function showPostDetails(postId) {
    // Implement functionality to show more post details, perhaps in a modal
    alert("Showing post details for post: " + postId);
}
