## WebCrawlerTrial

This trial has been submitted as part of a role application.

I have not used GitHub before, nor created a web crawler or sitemap so the process took longer than 2 hours.  

Still, it has been a useful exercise for me.

I used jsoup to parse the html and the jar appears under /lib.

I also base my code on this helpful resource online and I felt this was okay as this is what I might  do in a work situation.

  http://www.netinstructions.com/how-to-make-a-simple-web-crawler-in-java/

Testing and refinement took a long time as I realised that I was initially not including the linkURL links, only href.  
I realised that the same searches were being performed multiple times.
So I removed duplication by not performing searches that had already been done.  

The project was created in IntelliJ.  
The main method is under SpiderTest where the website is set and also the txt file for output.
Executing this will generate a sitemap.txt file in about 5 minutes (an example is included in the upload).   
It is indented to demonstrate the structure but not in xml format.

I realised that I have not included image links and there are other improvements I could have made with more time:
e.g. config, unit testing, ant build, output format

Although it is not complete I hope you can run it and that there is enough content for the assignment.
