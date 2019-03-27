<#import "common.ftl" as c>

<@c.page>
    <div class="container">
        <div class="row">
            <div class="col-12 m-4">
                <h2 class="mt-3" style="text-align:center;">Список компаний</h2>
                <table>
                    <thead>
                    <tr>
                        <th style="width: 350px; text-align: center">Title</th>
                        <th style="width: 300px; text-align: center">Address</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list companies as company>
                        <tr>
                            <td style="width: 50px; text-align: center">${company.name!'-'}</td>
                            <td style="width: 50px; text-align: center">${company.address!'-'}</td>
                            <td class="px-1"><a href="/deleteCompany/${company.id}"
                                                class="btn btn-primary mb-2">Delete</a></td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
                <form action="/saveCompany" method="post" class="form-inline mt-4">
                    <div class="form-group mx-sm-3 mb-2">
                        <input type="text" name="name" class="form-control m-2" placeholder="Name">
                        <input type="text" name="address" class="form-control m-2" placeholder="Address">
                    </div>
                    <button type="submit" class="btn btn-primary mb-2">Save Company</button>
                </form>
            </div>
        </div>
    </div>
</@c.page>
