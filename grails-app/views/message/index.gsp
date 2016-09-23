<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		
	</head>
	<body>
		<div class="container-fluid">
            <div class="jumbotron">
                <h1>Welcome!</h1>
                <p>Hello and welcome in our Guestbook! Feel free to read the 
                    messages we collected or leave your own comment. You can also
                    see who is the most active commentator here!
                </p>
                <g:link class="btn btn-primary btn-lg">
                    <span class="glyphicon glyphicon-pencil"></span>  Leave your message
                </g:link>
                <g:link controller="user" class="btn btn-primary btn-lg">
                    <span class="glyphicon glyphicon-list-alt"></span>  See commentators list
                </g:link>
            </div>
            <g:each in="${allMessages}" var="message">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <g:if test="${message.author.nick != null}">
                            ${message.author.nick}
                        </g:if>
                        <g:else>
                            ${message.author.email}
                        </g:else>
                    </h3>
                    <span class="date">${message.dateCreated.format('dd-MM-yyyy HH:mm')}</span>
                </div>
                <div class="panel-body">
                    ${message.content}
                </div>
            </div>
            </g:each>
			
        </div>
	</body>
</html>
