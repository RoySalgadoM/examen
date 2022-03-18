const url = "http://localhost:8080/api/category/";
var modalRegister = new bootstrap.Modal(document.getElementById('register'), {
    keyboard: false
  })
  var modalModify = new bootstrap.Modal(document.getElementById('modify'), {
    keyboard: false
  })

const getAll = () => {
    $.ajax({
        method: "GET",
        url: url
    }).done(function (res) {
        content = "";
        res = res.data
        for (let i = 0; i < res.length; i++) {
            if(res[i].status.description==="Activo"){
                content += `
                <tr>
                    <td>${res[i].id}</td>
                    <td>${res[i].description}</td>
                    <td>${res[i].status.description} </td>
                    <td>
                        <button type="button" onclick="getById(${res[i].id})" data-bs-toggle="modal" data-bs-target="#modify" class="btn btn-outline-primary"><i class="fas fa-edit"></i></button>
                    </td>
                    <td>
                    
                        <button onclick="remove(${res[i].id})" class="btn btn-outline-danger"><i class="fas fa-trash"></i></button>
                    </td>
                </tr>
            `;
            }else{
                content += `
                        <tr>
                            <td>${res[i].id}</td>
                            <td>${res[i].description}</td>
                            <td>${res[i].status.description} </td>
                            <td>
                                <button type="button" onclick="getById(${res[i].id})" data-bs-toggle="modal" data-bs-target="#modify" class="btn btn-outline-primary"><i class="fas fa-edit"></i></button>
                            </td>
                            <td>
                            
                                <button onclick="enable(${res[i].id})" class="btn btn-outline-success"><i class="fas fa-check"></i></button>
                            </td>
                        </tr>
                    `;
            }
            
        }
        $("#table > tbody").html(content);

    });
};

const getById = async (id) => {
    await $.ajax({
        method: "GET",
        url: url  + id
    }).done(res =>{
        res = res.data
        document.getElementById("idM").value = res.id;
        document.getElementById("descriptionM").value = res.description;
    });
};

const register = async() => {
    let description = document.getElementById("description").value;
    let data = {
        "description": description,
        "status":
                {
                    "id": 1,
                    "description":"Activo"
                }        
    }
    await $.ajax({
        method: "POST",
        url: url,
        contentType:"application/json",
        data: JSON.stringify(data),
        error:function(){
            Swal.fire({
                title: 'Error, comprueba los datos ingresados',
                confirmButtonText: 'Ok',
                icon: 'error',
            })
        }
    }).done(res =>{
        Swal.fire({
            title: 'La categoria ha sido registrada',
            confirmButtonText: 'Recargar tabla',
            icon: 'success',
        }).then((result) => {
            if (result.isConfirmed) {
                getAll();
                document.getElementById("description").value="";
                modalRegister.hide()
            }
        })
    });
}

const modify= async()=>{
    let description = document.getElementById("descriptionM").value;
    let id = document.getElementById("idM").value;
    let data = {
        "id":id,
        "description": description,
        "status":
                {
                    "id": 1,
                    "description":"Activo"
                }        
    }
    await $.ajax({
        method: "PUT",
        url: url,
        contentType:"application/json",
        data: JSON.stringify(data),
        error:function(){
            Swal.fire({
                title: 'Error, comprueba los datos ingresados',
                confirmButtonText: 'Ok',
                icon: 'error',
            })
        }
    }).done(res =>{
        Swal.fire({
            title: 'La categoria ha sido modificada',
            confirmButtonText: 'Recargar tabla',
            icon: 'success',
        }).then((result) => {
            if (result.isConfirmed) {
                getAll();
                document.getElementById("description").value="";
                modalModify.hide()
            }
        })
    });
}
const remove = async(id)=>{
    await $.ajax({
        method: "DELETE",
        url: url + id,
        error:function(){
            Swal.fire({
                title: 'Error, comprueba los datos ingresados',
                confirmButtonText: 'Ok',
                icon: 'error',
            })
        }
    }).done(res =>{
        Swal.fire({
            title: 'La categoria ha sido desactivada',
            confirmButtonText: 'Recargar tabla',
            icon: 'success',
        }).then((result) => {
            if (result.isConfirmed) {
                getAll();
            }
        })
    });
}

const enable = async(id)=>{
    await $.ajax({
        method: "PUT",
        url: url + id,
        error:function(){
            Swal.fire({
                title: 'Error, comprueba los datos ingresados',
                confirmButtonText: 'Ok',
                icon: 'error',
            })
        }
    }).done(res =>{
        Swal.fire({
            title: 'La categoria ha sido activada',
            confirmButtonText: 'Recargar tabla',
            icon: 'success',
        }).then((result) => {
            if (result.isConfirmed) {
                getAll();
            }
        })
    });
}