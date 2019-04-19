<#ftl strip_whitespace=true>
<#-- @ftlvariable name="slyakRequestContext" type="com.slyak.web.support.freemarker.SlyakRequestContext" -->
<#-- @ftlvariable name="sysRoles" type="java.util.List<com.slyak.smarto.domain.SysRole>" -->
<#macro cssAndJs>
    <@slyak.js url=[
    '/webjars/jquery/jquery.min.js',
    '/webjars/popper.js/umd/popper-utils.min.js',
    '/webjars/popper.js/umd/popper.min.js',
    '/webjars/bootstrap/js/bootstrap.min.js'
    ]/>
    <@slyak.css url=[
    '/webjars/bootstrap/css/bootstrap.min.css'
    ]/>
</#macro>
<#--
TODO:
layout content
alters badge breadcrumb buttons button group card carousel collapse dropdowns forms
inputgroup jumbotron listgroup modal navs navbar popovers progress scrollspy tooltips
-->

<#macro select name editable=true options=[{'title':'test','value':'test','content':sysRoles}] value=sysRoles mention="" class="" attributes...>
    <select class="selectpicker"<@slyak.attributes values=attributes/> name="${name}">
    <#if mention?has_content>
        <option>${mention}</option>
    </#if>
    <#list options as opt>
        <option selected value="" >${opt.title}</option>
        <#--<option<#if value?? && (value?size > 0)><#if value.get(0).getRole()==opt.value> selected</#if></#if> value=${opt.content}>${opt.title}</option>-->

    </#list>
    </select>
</#macro>