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
Il s’agit d’un écran qui permet de créer un compte utilisateur dans notre application. Il comporte entre autres, les champs suivants : Prénom, Nom, Référence (numéro d’identification de l’étudiant UASZ), Email, Mot de passe, classe (L3 Info par exemple).

![image](https://github.com/papaalioune/CoursUASZ2/assets/44668416/b3114255-a7a1-43f3-abcc-e463022d012e)

#### 2.3 Visualisation d'emploi du temps
Quand un utilisateur se connecte sur l’écran d’accueil, le système doit vérifier et récupérer auprès de l’application AGET, l’emploi du temps de l’utilisateur. Celui-ci est ensuite redirigé vers l’écran d’affichage de son emploi du temps. Cet écran affiche l’emploi du temps sous forme de tableau. Chaque cellule de ce tableau correspond à une heure de cours. S’il y’a cours à cette heure, la cellule est coloriée en jaune et rempli avec le code du cours. Au clic sur la cellule, les détails du cours sont affichés en bas du tableau de l’emploi du temps.

![image](https://github.com/papaalioune/CoursUASZ2/assets/44668416/976ad4ce-989f-42b5-9e12-187b64f43ea6)



