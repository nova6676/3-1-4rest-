async function getUser() {
    fetch("/user/api")
        .then(res => res.json())
        .then(user => {
            const roles = user.roles.map(role => role.name).join(',')
            $('#navbar-email').append(`<span>${user.email}</span>`)
            $('#navbar-roles').append(`<span>${roles.replace('ROLE_', '') + ' '}</span>`)
            const u = `$(
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.roles.map(role=>" " + role.name.substring(5))}</td>
                    </tr>)`;
            $('#usertable').append(u)
        })
}
getUser()