<#-- @ftlvariable name="page" type="org.springframework.data.domain.Page<com.slyak.smarto.domain.UserInfo>" -->
<@layout.layout_admin title="用户" btnCreate={'title':'添加用户','modal':true,'url':'/admin/user','showSubmit':true}>
    <table class="table table-hover table-fa">
    <thead>
    <tr>
        <th scope="col">用户名</th>
        <th scope="col">角色</th>
        <th scope="col">状态</th>
    </tr>
    </thead>
    <tbody>
    <#list page.content as userInfo>
        <tr>
        <td>${userInfo.userName}</td>
        <#assign sysRole>
            <#list userInfo.roleList as roles>
                ${roles.role}
            </#list>
        </#assign>
        <td>${sysRole}</td>
        <td>
    <a href="<@slyak.query url="/user/groups?id=${userInfo.id}"/>">管理</a>
        <@bootstrap.a href="/user/delete?id=${userInfo.id}" title="删除" class="confirm ajax"/>
        </td>
        </tr>
    <#else >
        <tr>
            <td colspan="3" class="text-center">暂无记录</td>
        </tr>
    </#list>
    </tbody>
    </table>
</@layout.layout_admin>