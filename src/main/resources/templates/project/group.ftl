<@layout.detail title="分组详情" action="/project">
    <@bootstrap.formgroup label="名称" required=true>
        <@bootstrap.input type="text" name="name" value="${group.name}"/>
    </@bootstrap.formgroup>
    <@bootstrap.formgroup label="描述" required=true>
        <@bootstrap.textarea name="desc" value="${group.desc}"/>
    </@bootstrap.formgroup>
    <@bootstrap.formgroup label="主机选择" required=true>
        <@bootstrap.checkboxes name="host" />
    </@bootstrap.formgroup>
</@layout.detail>