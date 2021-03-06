<#assign valueMap=death.valueMap>
<subjectOf2 typeCode="SBJ">
    <observation classCode="OBS" moodCode="EVN">
        <code code="32" codeSystem="2.16.840.1.113883.3.989.2.1.1.19" codeSystemVersion="1.1"
              displayName="reportedCauseOfDeath"/>
        <#if valueMap["D.9.2.r.1b"]?has_content>
        <value xsi:type="CE" code="${valueMap['D.9.2.r.1b']?if_exists?xml}" codeSystem="2.16.840.1.113883.6.163"
               codeSystemVersion="${valueMap['D.9.2.r.1a']?if_exists?xml}">
                <#if isDebug == 1><!-- D.9.2.r.1b --></#if> <#if isDebug == 1><!-- D.9.2.r.1a --></#if>
            <#if valueMap["D.9.2.r.2"]?exists>
            <originalText>${valueMap["D.9.2.r.2"]?if_exists?xml}</originalText> <#if isDebug == 1><!-- D.9.2.r.2 --></#if>
            </#if>
        </value>
        </#if>

    </observation>
</subjectOf2>