<!DOCTYPE html>
<html>
<head>
    <title>Hacker News</title>
</head>
<body>
<h1>Hacker News - Top Stories</h1>

<ul>
    <#list newsItems as newsItem>
        <li><a href="${newsItem.url}" target="_blank">${newsItem.title}</a></li>
    </#list>
</ul>
</body>
</html>
