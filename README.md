# CoursUASZ: une application mobile de visualisation des emplois du temps des étudiants
### 1. Enoncé du projet
Ce mini-projet consiste à développer un embryon d’application mobile qui va permettre aux étudiants de l’UASZ de visualiser leurs emplois du temps. En effet, à partir de la L3, les emplois du temps sont parfois sujets à de nombreux changements au cours de l’année. L’idée est d’avoir une application Android qui donne l’emploi du temps et notifie l’utilisateur si des changements sont survenus.
Nous supposons pour cela que l’UFR ST dispose déjà d’une application de gestion des emplois du temps (AGET) qui est constituée d’une interface graphique utilisateur permettant de gérer (créer, modifier, supprimer) les emplois du temps ; d’une base de données pour stocker ces informations et d’un service web permettant à des applications tierces (comme celle que nous proposons de développer) de cueillir ces informations. Une API est développe dans ce sens et offre les services suivants:
- Vérifier un étudiant en fournissant son mail (paramètre 'mail') et son mot de passe (paramètre 'pwd'). Si le compte de l'étudiant est vérifié, la liste des cours de sa classe est retournée. Ce service est accessible par la méthode 'POST' (en donnant des valeurs pour les paramètres 'mail' et 'pwd') à l'adresse: https://papaaliounecisse.herokuapp.com/gedt/api/verifier_etudiant/
- Récupérer la liste des classes dans lesquelles un étudiant peut s'inscrire en ouvrant un compte sur l'application. Ce service est accessible par 'GET' à l'adresse suivant: https://papaaliounecisse.herokuapp.com/gedt/api/classes/
- Ajouter un étudiant en fournissant les paramètres suivants: 'prenom', 'nom, 'mail', 'pwd', 'classe'. Ce service est accessible par 'POST' à l'adresse suivante: https://papaaliounecisse.herokuapp.com/gedt/api/ajouter_etudiant/
### 2. Fonctionnalités de l'application
#### 2.1 Connexion
A son lancement, l’application présente une page d’accueil pour permettre à un utilisateur inscrit de se connecter sur la plateforme. Cette page doit comporter un logo (celui de l’UASZ) ; un message d’accueil ; deux champs de login (email) et de mot de passe et un bouton pour se connecter ; et un lien pour se rediriger vers la page de création de compte.
![image](https://github.com/papaalioune/CoursUASZ2/assets/44668416/32d65961-1196-4672-ba47-23667ed3fb81)
#### 2.2 Création de compte
#### 2.3 Visualisation d'emploi du temps

