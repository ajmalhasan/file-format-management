File-Format-Management

This is sample project to show how Aspose API's can help in document processing/conversion in difference file formats. This application shows reports against different queries and display the reports in Excel, PDF, HTML and PNG formats.

For this sample project I have used Aspose Cell component API for JAVA. For programmers guide you can visit following link.

http://www.aspose.com/docs/display/cellsjava/Programmers+Guide

You can download evaluation API's from following URLs.

http://www.aspose.com/community/files/default.aspx

USAGE:

When the application is run it shows four options as radio button group i.e

    Search All Employees.
    Search All Department.
    Search By Employee.
    Search By Department.

When search by employee or by department is checked a combo box with employees or departments is shown which can be selected.

User have to select file format type in the combo box.

After the search criteria is submitted, a download link will display from where a report can be downloaded in required format.

CONFIGURATION:

This is a web project and you can easily import it on Eclipse however there will be slight modifications on Net-beans or InteliJ IDE's. I have included all the dependencies in the lib folder you can add these into you class-path.

I have included database dump as employees.rar file with the project.

I have used Tomcat 6 as a application server, however project can be run on other application servers like J Boss or Glass-fish.

If you are developer you can deploy the project in IDE as a exploded type however if you want to use build script I have provided ANT build script for that purpose. Build process will create a war file in dist folder that you can later deploy.

I have also included unit tests for the project and created a ANT target for the unit tests as well.

Thanks
.
