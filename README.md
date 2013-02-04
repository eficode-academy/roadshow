RoadShow
========
This is the source for the continuous delivery road show.

# Repositories
We use two repositories for our show case that includes pretested commits.

## RoadShow
* https://github.com/Praqma/RoadShow
"RoadShow" is the integration repository is where we push changes, and if validated they end up in the RoadShow-stable repository (https://github.com/Praqma/RoadShow-stable)

## RoadShow stable
* (https://github.com/Praqma/RoadShow-stable
"RoadShow-stable" is where validated changes ends if they can be verified to a certain level.

# Need to know commands

### Git

git clone <URL>  
cd RoadShow  
... work  
git add <Files>  
git commit  
git pull stable master  
merge ???  
git push origin master  
git remote --add stable <URL of the stable repo>  

### Maven

mvn clean package
