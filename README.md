# Gerenciamento de Tarefas para Funcionários de Fazenda

Este projeto é uma aplicação Android para gerenciar as tarefas dos funcionários de uma fazenda. O aplicativo permite que o usuário faça login e visualize a lista de tarefas, com a possibilidade de marcar as tarefas como concluídas ou pendentes.

## Funcionalidades

1. **Tela de Login**: O usuário realiza o login informando seu e-mail e senha. Caso ambos os campos sejam preenchidos corretamente, o usuário é redirecionado para a tela de gerenciamento de tarefas.
   
2. **Tela de Gerenciamento de Tarefas**: Exibe uma lista de tarefas dos funcionários, com a possibilidade de alterar o status das tarefas (de "Pendente" para "Concluída" ou vice-versa).

3. **Integração com API**: A aplicação se comunica com uma API para listar as tarefas, permitindo o gerenciamento em tempo real.

## Estrutura de Arquivos

1. **LoginActivity**: Tela de login que solicita o e-mail e a senha do usuário. Caso as informações sejam válidas, o usuário é redirecionado para a tela de gerenciamento de tarefas.
   
2. **TaskManagementActivity**: Tela que lista as tarefas dos funcionários. Aqui, o usuário pode visualizar as tarefas e alterar seu status.

3. **TaskAdapter**: Adaptador usado para exibir as tarefas em uma lista na tela de gerenciamento.

## Dependências

- **Retrofit**: Usado para realizar chamadas de rede e buscar as tarefas via API.

