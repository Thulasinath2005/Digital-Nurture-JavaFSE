// Exercise 1: JavaScript Basics & Setup

// 1. Console log
console.log("Welcome to the Community Portal");

// 2. Show message on the page
document.getElementById('output').textContent =
  "✅ JavaScript is working! Check the Console (F12) for the welcome message.";

// 3. Alert when page is fully loaded
window.addEventListener('load', function () {
  alert("✅ Page is fully loaded! Welcome to the Community Event Portal.");
});
