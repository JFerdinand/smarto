<#-- @ftlvariable name="user" type="com.slyak.smarto.domain.UserInfo" -->
<#-- @ftlvariable name="sysRoles" type="java.util.List<com.slyak.web.ui.Option>" -->
<@layout.cleanHtml>
    <@slyak.css url="/css/bootstrap-select.min.css"/>
    <@slyak.js url="/js/bootstrap-select.min.js"/>
    <#--<@slyak.css url="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/css/bootstrap-select.min.css"/>-->
    <#--<@slyak.js url="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/js/bootstrap-select.min.js"/>-->
    <@slyakUI.form action="/admin/user">
        <@bootstrap.formgroup label="用户名">
            <@bootstrap.input name="userName"  value="${user.userName}"/>
        </@bootstrap.formgroup>
        <@bootstrap.formgroup label="用户密码">
            <@bootstrap.input name="password" type="password" value="${user.password}"/>
        </@bootstrap.formgroup>
        <@bootstrap.formgroup label="确认密码">
            <@bootstrap.input name="repassword" type="password" value="${user.password}"/>
        </@bootstrap.formgroup>
        <@bootstrap.formgroup label="用户角色">
            <select name="roleIds" class="selectpicker show-tick form-control" multiple data-live-search="false">
                <option value="1">超级管理员</option>
                <option value="2">部署管理员</option>
            </select>
            <#--<@bootstrap_ext.select name="userRole" options=sysRoles value=user.roleList mention="选择用户角色"/>-->
        </@bootstrap.formgroup>
    </@slyakUI.form>

    <#--<@ace.init cssSelector="#scriptArea" mode="sh" theme="tomorrow" minLines=20 maxLines=20>-->
        <#--window['editor'] = editor;-->
    <#--</@ace.init>-->
</@layout.cleanHtml>