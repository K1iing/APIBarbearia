document.getElementById("clienteForm").addEventListener("submit", async function (event) {
    event.preventDefault();

    const nome = document.getElementById("nome").value;
    const telefone = document.getElementById("telefone").value;
    const data = document.getElementById("data").value;
    const servico = document.getElementById("servico").value;

    const clienteData = {
        nome: nome,
        telefone: telefone,
        data: data,
        servicos: servico
    };

    try {
        const response = await fetch("http://localhost:8080/cliente/cadastrar", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(clienteData)
        });

        if (response.ok) {
            document.getElementById("message").innerText = "Cliente cadastrado com sucesso!";
            document.getElementById("clienteForm").reset();
        } else {
            const errorText = await response.text();
            document.getElementById("message").innerText = "Erro ao cadastrar cliente: " + errorText;
        }
    } catch (error) {
        document.getElementById("message").innerText = "Erro de conexão: " + error.message;
    }
});

// Função para atualizar cliente
document.getElementById("atualizarForm").addEventListener("submit", async function (event) {
    event.preventDefault();

    const id = document.getElementById("atualizarId").value;
    const nome = document.getElementById("atualizarNome").value;
    const telefone = document.getElementById("atualizarTelefone").value;
    const servico = document.getElementById("atualizarServico").value;

    const clienteData = {
        id: id,
        nome: nome || null,
        telefone: telefone || null,
        servicos: servico || null
    };

    try {
        const response = await fetch("http://localhost:8080/cliente/atualizar", {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(clienteData)
        });

        if (response.ok) {
            document.getElementById("message").innerText = "Cliente atualizado com sucesso!";
            document.getElementById("atualizarForm").reset();
        } else {
            const errorText = await response.text();
            document.getElementById("message").innerText = "Erro ao atualizar cliente: " + errorText;
        }
    } catch (error) {
        document.getElementById("message").innerText = "Erro de conexão: " + error.message;
    }
});

// Função para listar clientes
document.getElementById("listarClientes").addEventListener("click", async function () {
    try {
        const response = await fetch("http://localhost:8080/cliente/listar");
        const clientes = await response.json();

        const listaDiv = document.getElementById("listaClientes");
        listaDiv.innerHTML = ""; // Limpa a lista anterior

        if (clientes.content.length === 0) {
            listaDiv.innerHTML = "<p>Nenhum cliente encontrado.</p>";
            return;
        }

        const ul = document.createElement("ul");
        clientes.content.forEach(cliente => {
            const li = document.createElement("li");
            li.textContent = `ID: ${cliente.id}, Nome: ${cliente.nome}, Telefone: ${cliente.telefone}, Serviço: ${cliente.servicos}`;
            ul.appendChild(li);
        });

        listaDiv.appendChild(ul);
    } catch (error) {
        document.getElementById("message").innerText = "Erro de conexão: " + error.message;
    }
});

// Função para desativar cliente
document.getElementById("desativarCliente").addEventListener("click", async function () {
    const id = document.getElementById("idAtivarDesativar").value;

    try {
        const response = await fetch(`http://localhost:8080/cliente/desativar/${id}`, {
            method: "PUT"
        });

        if (response.ok) {
            document.getElementById("message").innerText = "Cliente desativado com sucesso!";
        } else {
            const errorText = await response.text();
            document.getElementById("message").innerText = "Erro ao desativar cliente: " + errorText;
        }
    } catch (error) {
        document.getElementById("message").innerText = "Erro de conexão: " + error.message;
    }
});

// Função para ativar cliente
document.getElementById("ativarCliente").addEventListener("click", async function () {
    const id = document.getElementById("idAtivarDesativar").value;

    try {
        const response = await fetch(`http://localhost:8080/cliente/ativar/${id}`, {
            method: "PUT"
        });

        if (response.ok) {
            document.getElementById("message").innerText = "Cliente ativado com sucesso!";
        } else {
            const errorText = await response.text();
            document.getElementById("message").innerText = "Erro ao ativar cliente: " + errorText;
        }
    } catch (error) {
        document.getElementById("message").innerText = "Erro de conexão: " + error.message;
    }
});
