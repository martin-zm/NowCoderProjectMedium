<html>
<body>
HELLO FREEMAKER.<br>
<#-- 这是注释 -->
${value1}<br>

<#--遍历集合-->
<#list colors as color>
    ${color_index}/${colors?size} : ${color}<br>
</#list>
<#--遍历map-->
<#list map?keys as key>
    ${key_index}/${map?size} ${key} : ${map["${key}"]}<br>
</#list>
<#--级联属性引用后面为默认值-->
User:${user.name!"123"}<br>

<#assign title = "nowcoder">

include:<#include "header1.ftl"><br>

<#--宏定义-->
<#macro render_color colors>
    <#list colors as color>
        Color By Macro ${color_index}, ${color}<br>
    </#list>
</#macro>

<#--宏调用-->
<@render_color colors = ["red", "yellow", "blue"]/>

<#assign hello = "hello">
<#assign hworld1 = "${hello} world">
<#assign hworld2 = '${hello} world'>

hworld1: ${hworld1}<br>
hworld2: ${hworld2}<br>

${colors?size}



</body>
</html>