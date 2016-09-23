<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		
	</head>
	<body>
        <g:link controller="message" class="btn btn-primary">
            <span class="glyphicon glyphicon-arrow-left"> </span> Back
        </g:link>
        <g:form action="save" class="form-group">
            <div>
                Your email*:
                <g:textField name="email" class="form-control"/>
            </div>
            <div>
                Your nickname:
                <g:textField name="nick" class="form-control"/>
            </div>
            <div>
                <g:textArea name="content" class="form-control"/>
            </div>
            <div>
                <g:actionSubmit value="Save" class="btn btn-success"/>
            </div>
            <g:renderErrors  as="list" />
        </g:form>
        
    </body>
</html>