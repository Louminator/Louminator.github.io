<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>Louis F. Rossi PHP test page</title>
<meta name="generator" content="Bluefish 2.0.3" >
<meta name="author" content="Louis Frank Rossi" >
<meta name="date" content="2012-10-17T20:23:21-0400" >
<meta name="keywords" content="Rossi Math Bullock Creek Cafe">
<meta name="ROBOTS" content="NOINDEX, NOFOLLOW">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel=stylesheet type="text/css" href="2012spring.css">
</head>
<body>
<hr align="left" size="4" width="50%">
<table class="banner">
<tr>
<td><a href="louroo_med.jpg"><img src="louroo_sm.jpg" width="123" height="145" border="0" alt="Have some mathematics... It's on me." align="bottom"></a></td>
<td width="100%" valign="bottom" nowrap>
<p>
<img class="right" src="udmath.png" width="211" height="140" border="0" alt="" align="bottom">
<b><font size="+1">Louis F. Rossi</font></b> <br>
Professor <br>
Director of Undergraduate Studies <br>
<a href="http://www.math.udel.edu">Department of Mathematical Sciences</a><br>
University of Delaware
</p>
</table>
<hr align="left" size="4" width="70%">

<?php
include('simple_html_dom.php');

$html = file_get_html('http://primus.nss.udel.edu/CoursesSearch/search-results.jsp?course_sec=MATH241');
// print $html;
echo '<P>Here are the courses</P>';

echo '<table>';  
echo '<tr>';      
echo '<td><table>';    

foreach($html->find('.coursenum') as $e) 
    echo '<tr><td>' . $e->innertext . '</td>';

echo '</table></td>';

echo '<td><table>';
foreach($html->find('.openseats') as $e) 
    echo '<tr><td>' . $e->innertext . '</td>';

echo '</table></td>';
echo '</table>';
?>

<hr align="left" size="4" width="90%">

<?php
echo 'Current PHP version: ' . phpversion();
?>
<?php
print '  '.date('h:i:s A');
print '<br>&copy  '.date('j F Y');
?>
</body>
</html>
