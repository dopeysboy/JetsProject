<a name="readme-top"></a>
<h1 align="center">JetsProject</h1>
<h2 align="center">Table of Contents</h2>
<ul>
    <li><a href="#readme-description">Description</a></li>
    <li><a href="#readme-built">Built With</a></li>
    <li><a href="#readme-learned">Things I learned</a></li>
    <li><a href="#readme-future">Next Time</a></li>
    <li><a href="#readme-note">Things of Note</a></li>
    <li><a href="#readme-contact">Contact me</a></li>
</ul>
<a name="readme-description"></a>
<h2 align="center">Description</h2>
<p>This program allows users to manage an airfield, with options to:</p>
<ul>
	<li>List the fleet</li>
	<li>Fly all jets</li>
	<li>View the fastest jet</li>
	<li>View the jet with the farthest range</li>
	<li>"Load" all carriers (print out a line)</li>
	<li>Conduct a "war in the skies" (print out a different line)</li>
	<li>Add a jet to the fleet</li>
	<li>Remove a jet from the fleet</li>
	<li>Load a random list of jets</li>
	<li>Save the jets to a file</li>
	<li>Load the jets from a file</li>
	<li>Quit</li>
</ul>
<p>Of note, load a random list of jets allows the user to select a number of jets and creates that many random jets</p>
<p align="right">(<a href="#readme-top">back to top</a>)</p>
<a name="readme-built"></a>
<h2 align="center">Built With</h2>
<p>This program was built with Eclipse and git, with name lists taken from wikipedia and this github: https://raw.githubusercontent.com/hadley/data-baby-names/master/baby-names.csv</p>
<a name="readme-learned"></a>
<h2 align="center">Things learned</h2>
<p>I learned that eclipse runs out of memory fairly quickly (loading between 130 and 140 random jets on my machine)</p>
<p align="right">(<a href="#readme-top">back to top</a>)</p>
<a name="readme-future"></a>
<h2 align="center">Things to do next time</h2>
<p>In the future, I would try to incorporate ANSI color codes into the project to make the console a more interactive and interesting platform for display</p>
<p align="right">(<a href="#readme-top">back to top</a>)</p>
<a name="readme-note"></a>
<h2 align="center">Things of Note</h2>
<p>Something to take note of is that loadRandom() is able to take any int as parameter, but because I believe each machine would have a different max memory allocation, and the amount of jets you're able to add before the JVM runs out of memory changes after each run of the method, I chose not to implement a max, and let the user use their best judgement.</p>
<p align="right">(<a href="#readme-top">back to top</a>)</p>
<a name="readme-contact"></a>
<h2 align="center">Contact me</h2>
<p>You can contact me at:</p>
	<ul>
		<li>github: github.com/dopeysboy</li>
		<li>email: tyler.j.tanner@gmail.com</li>
	</ul>
<p align="right">(<a href="#readme-top">back to top</a>)</p>
