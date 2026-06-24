# Learning JDBC
This is the repository for the LinkedIn Learning course `Learning JDBC`. The full course is available from [LinkedIn Learning][lil-course-url]. 

![lil-thumbnail-url]

## Course Description

Whether developers want to build mobile device apps for Android, web-based, or desktop-based applications with the core Java SDK from Oracle, they must contend with the fact that many dynamic applications need to integrate data from a relational database. In this course, Frank Moley helps you get up to speed with the Java Database Connectivity (JDBC) API, showing how to use it to read and manage data from relational databases such as Postgres, Oracle Database, MySQL, and SQL Server in applications programmed with Java. Frank begins by going over key JDBC terminology, the basics of configuring a PostgreSQL database, and how to create the course project. He then provides detailed instructions on how to select and update data, work with transactions, handle exceptions, and more.

> [!NOTE]
> This repo can take up to 2 minutes to fully load in GitHub Codespaces due to the complexity of the different components. This is expected.

_See the readme file in the main branch for updated instructions and information._
## Instructions
This repository has branches for each of the videos in the course. You can use the branch pop up menu in github to switch to a specific branch and take a look at the course at that stage, or you can add `/tree/BRANCH_NAME` to the URL to go to the branch you want to access.

## Branches
The branches are structured to correspond to the videos in the course. The naming convention is `CHAPTER#_MOVIE#`. As an example, the branch named `02_03` corresponds to the second chapter and the third video in that chapter. 
Some branches will have a beginning and an end state. These are marked with the letters `b` for "beginning" and `e` for "end". The `b` branch contains the code as it is at the beginning of the movie. The `e` branch contains the code as it is at the end of the movie. The `main` branch holds the final state of the code when in the course.

When switching from one exercise files branch to the next after making changes to the files, you may get a message like this:

    error: Your local changes to the following files would be overwritten by checkout:        [files]
    Please commit your changes or stash them before you switch branches.
    Aborting

To resolve this issue:
	
    Add changes to git using this command: git add .
	Commit changes using this command: git commit -m "some message"

## Instructor

Frank P Moley III

Principal Software Architect at Vertex, Inc.
         

Check out my other courses on [LinkedIn Learning](https://www.linkedin.com/learning/instructors/frank-p-moley-iii?u=104).


[0]: # (Replace these placeholder URLs with actual course URLs)

[lil-course-url]: https://www.linkedin.com/learning/learning-jdbc-24697410
[lil-thumbnail-url]: https://media.licdn.com/dms/image/v2/D560DAQELGCBArDCkxg/learning-public-crop_675_1200/learning-public-crop_675_1200/0/1728506593128?e=2147483647&v=beta&t=QZavY1s7ezWzBCxyr4UqF-uajftjI1IbfHDDZFzLg-g

