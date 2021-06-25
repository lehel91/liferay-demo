<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="init.jsp"%>
<portlet:resourceURL var="getUsers">
	<portlet:param name="<%=Constants.CMD%>" value="get_users" />
</portlet:resourceURL>
<h2>Liferay Auto Complete List with Ajax</h2><br/>
<aui:input id="myInputNode" name="myInputNode" label="User Email"
	helpMessage="Type User Email address in Input Box" />
<aui:script>
AUI().use('autocomplete-list','aui-base','aui-io-request','autocomplete-filters','autocomplete-highlighters',function (A) {
var testData;
new A.AutoCompleteList({
allowBrowserAutocomplete: 'true',
activateFirstItem: 'true',
inputNode: '#<portlet:namespace />myInputNode',
resultTextLocator:'email',
render: 'true',
resultHighlighter: 'phraseMatch',
resultFilters:['phraseMatch'],
source:function(){
			var inputValue=A.one("#<portlet:namespace />myInputNode").get('value');
			var myAjaxRequest=A.io.request('<%=getUsers.toString()%>',{
	  						    dataType: 'json',
	  							method:'POST',
	  							data:{
	  							<portlet:namespace />userEmail:inputValue,
	  							},
	  							autoLoad:false,
	  							sync:false,
	  						    on: {
	   			 				 success:function(){
	   			 					var data=this.get('responseData');
	   			 					testData=data;
	   			 				}}
							});
							myAjaxRequest.start();
							return testData;},
							});
});
</aui:script>