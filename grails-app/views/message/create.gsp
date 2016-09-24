<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		
	</head>
	<body>
        <row>
            <div class="col-xs-12">
                <g:link controller="message" class="btn btn-primary">
                    <span class="glyphicon glyphicon-arrow-left"> </span> Back
                </g:link>
            </div>
        </row>
        <row>
            <div class="col-xs-12">
                <g:form action="save">
                    <div class="form-group">
                        Your email*:
                        <g:textField name="email" class="form-control"/>
                    </div>
                    <div class="form-group">
                        Your nickname (optional; will hide your email):
                        <g:textField name="nick" class="form-control"/>
                    </div>
                    <div class="form-group">
                        Message*:
                        <g:textArea name="content" class="form-control"/>
                    </div>
                    <div>
                        <g:actionSubmit value="Save" class="btn btn-success"/>
                    </div>
                    <g:hasErrors>
                        <div class="alert alert-danger">
                            <g:renderErrors  as="list" class="alert alert-danger"/>
                        </div>
                    </g:hasErrors>
                </g:form>
            </div>
        </row>
        
    </body>
</html>