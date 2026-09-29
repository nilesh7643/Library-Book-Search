const API = "http://localhost:8080/api/books";

const searchInput = document.getElementById("searchInput");
const searchType = document.getElementById("searchType");
const searchBtn = document.getElementById("searchBtn");
const allBtn = document.getElementById("allBtn");
const results = document.getElementById("results");
const message = document.getElementById("message");
const algorithmBadge = document.getElementById("algorithmBadge");

searchBtn.addEventListener("click", searchBooks);
allBtn.addEventListener("click", loadAllBooks);
searchInput.addEventListener("keydown", e => {
  if (e.key === "Enter") searchBooks();
});

searchType.addEventListener("change", updateAlgorithm);

function updateAlgorithm() {
  algorithmBadge.textContent =
    searchType.value === "title"
      ? "Binary Search — O(log n)"
      : "HashMap — O(1) average";
}

async function searchBooks() {
  const value = searchInput.value.trim();

  if (!value) {
    message.textContent = "Please enter a search value.";
    return;
  }

  message.textContent = "Searching...";

  try {
    const type = searchType.value;
    const response = await fetch(
      `${API}/${type}/${encodeURIComponent(value)}`
    );

    if (!response.ok) {
      throw new Error("No matching books found.");
    }

    const data = await response.json();
    const books = Array.isArray(data) ? data : [data];

    renderBooks(books);
    message.textContent = `${books.length} result(s) found.`;
  } catch (error) {
    renderBooks([]);
    message.textContent = error.message;
  }
}

async function loadAllBooks() {
  message.textContent = "Loading books...";

  try {
    const response = await fetch(API);
    if (!response.ok) throw new Error("Backend is not running.");

    const books = await response.json();
    renderBooks(books);
    message.textContent = `Showing all ${books.length} books.`;
  } catch (error) {
    renderBooks([]);
    message.textContent = error.message;
  }
}

function renderBooks(books) {
  document.getElementById("resultCount").textContent = books.length;

  if (!books.length) {
    results.innerHTML =
      '<div class="empty">No books found. Try another search.</div>';
    return;
  }

  results.innerHTML = books.map(book => `
    <article class="book-card">
      <h3>📖 ${escapeHtml(book.title)}</h3>
      <p><strong>Author:</strong> ${escapeHtml(book.author)}</p>
      <p><strong>Category:</strong> ${escapeHtml(book.category)}</p>
      <p><strong>ISBN:</strong> ${escapeHtml(book.isbn)}</p>
      <span class="status ${book.available ? "available" : "issued"}">
        ${book.available ? "✓ Available" : "✕ Issued"}
      </span>
    </article>
  `).join("");
}

function escapeHtml(value) {
  return String(value)
    .replaceAll("&", "&amp;")
    .replaceAll("<", "&lt;")
    .replaceAll(">", "&gt;")
    .replaceAll('"', "&quot;")
    .replaceAll("'", "&#039;");
}

async function loadStats() {
  try {
    const response = await fetch(API);
    const books = await response.json();

    document.getElementById("bookCount").textContent = books.length;
    document.getElementById("availableCount").textContent =
      books.filter(book => book.available).length;

    renderBooks(books);
  } catch {
    message.textContent =
      "Start the Spring Boot backend, then refresh this page.";
  }
}

updateAlgorithm();
loadStats();
