const API_BASE = "/api";

async function fetchEmployees() {
    const res = await fetch(`${API_BASE}/employees`);
    const data = await res.json();

    const list = document.getElementById("list");
    list.innerHTML = "";

    data.forEach(emp => {
        const li = document.createElement("li");
        li.innerText = emp.name + " - " + emp.role;
        list.appendChild(li);
    });
}

async function addEmployee() {
    const name = document.getElementById("name").value;
    const role = document.getElementById("role").value;

    await fetch(`${API_BASE}/employees`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, role })
    });

    fetchEmployees();
}

async function checkHealth() {
    const res = await fetch(`${API_BASE}/health`);
    const text = await res.text();

    document.getElementById("health").innerText = text;
}

fetchEmployees();