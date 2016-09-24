<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		
	</head>
	<body>
        <row>
            <div class="col-xs-2">
                <g:link controller="message" class="btn btn-primary">
                    <span class="glyphicon glyphicon-arrow-left"> </span> Back
                </g:link>
            </div>
        </row>
        <row>
            <div class="col-xs-12">
                <h2>Users and messages count</h2>
                <hr>
            </div>
        </row>
        <g:each in="${users}" var="user">
            <row>
                <div class="col-xs-10">
                    ${user.key}
                </div>
                <div class="col-xs-2">
                    ${user.value}
                </div>
            </row>
        </g:each>
    </body>
</html>