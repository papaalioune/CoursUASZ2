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

### 3. Premiers pas dans la resolution du problème
#### 3.1 Modélisation du problème
Un Cours est défini par : 
- une matière (définie par un code – Dev Mob par exemple – et un intitulée – Développement Mobile par exemple);
- un type de cours (défini par un ocde - CM par exemple- et un libellé - Cours magistral par exemple);
- une classe (définie par un code - 2I par exemple - et un nom - Ingénieurie informatique par exemple);
- un enseignant (défini par un nom et un prenom);
- d’une salle de classe (définie par un nom - Ex : C003);
- d’un jour (Ex : Lundi);
- d’une heure de début et d'une heure de fin de types "Heure de cours" (défini par une heure (entier) et une minute (entier)).

Un Emploi du temps n’est ici rien d’autre qu’un ensemble de Cours donnant une répartition des différents enseignements dans le temps et dans l’espace (les salles de classes). Attention : il est important de signaler qu’un emploi du temps ici n’est pas le tableau graphique qui donne une représentation visuelle.
Un Tableau d’Emploi du Temps est un tableau constitué d’un ensemble de colonnes (les différents jours de cours : Lundi à Samedi) ; d’un ensemble de lignes (les différentes heures de cours : 8h à 13h et 15h à 20h) et d’un ensemble de Cellules ou cases correspondant chacune à un Cours d’une classe donnée.
Une Cellule d’un Tableau d’Emploi du Temps est donc un objet qui se réfère (qui porte la référence) à un cours donné.
#### 3.2 Aperçu sur l'architecture MVC
Dans le souci de faciliter le développement logiciel et la compréhension des codes, il existe plusieurs conventions ou des méthodes de bonne pratique. Parmi ces conventions, il y’a l’architecture MVC pour Model-View-Controller (ou Modèle-Vue-Controller en français).
L'architecture MVC consiste à découper son code pour qu'il appartienne à l'une des trois composantes du MVC. Lorsque vous créez une nouvelle classe ou un nouveau fichier, vous devez donc savoir à quelle composante il appartient :
-	Modèle : contient les données de l'application et la logique métier. Par exemple, les Cours et les Emplois du temps constituent, pour le problème que nous posons ici, le « métier » de l’application. La composante modèle n'a aucune connaissance de l'interface graphique. Dans notre application, elle regroupera l'ensemble des données sur les cours et les emplois du temps. Nous créons un package nommé « model » pour cela et y mettre tout le modèle (les différentes classes).
-	Vue : contient tout ce qui est visible à l'écran et qui propose une interaction avec l'utilisateur. Par exemple, les boutons, les images, les zones de saisie, etc. Dans notre application, cette composante est définie par le dossier layout (qui contiendra les fichiers xml correspondant aux interfaces des activités).
-	Contrôleur : c'est la "colle" entre la vue et le modèle, qui gère également la logique de l'application. Le contrôleur permet de réagir aux interactions de l'utilisateur et de lui présenter les données qu'il demande. Et ces données, où les récupère-t-il ? Dans le modèle bien entendu ! Dans notre application, cela correspond aux différentes activités que nous aurons à développer). Nous pourrions ajouter un package nommé « controller » et y mettre toutes les activités de l’application.

#### 3.3 Exemple d'application du modèle MVC
Les écrans des téléphones étant petits, il nous sera difficile de mettre toutes les informations de tous les Cours dans les Cellules du Tableau d’emploi du temps. Nous allons donc procéder ainsi : une Cellule de Cours sera coloriée en jaune avec seulement le code de la matière concernée. On permet ainsi à l’utilisateur de cliquer sur une Cellule et de visualiser les détails du Cours en bas de du Tableau d’emploi du temps. Avec MVC, ce processus est matérialisé dans l’image suivant :

![image](https://github.com/papaalioune/CoursUASZ2/assets/44668416/6402d448-2bec-4f8a-9154-c6d6800f4aa1)

### 4. Développement du cas d'application
#### 4.1 Création du projet et mise en place de l’architecture MVC
Nous allons créer un « projet à Empty Activity » appelé « Cours UASZ » avec comme Package name « com.uasz.pacisse.coursuasz » (remplacer pacisse par votre nom par exemple).
Pour mettre en place l’architecture MVC dans notre projet, nous allons juste ajouter les packages suivants : model (pour contenir le modèle de l’application, c’est-à-dire les différentes classes de notre application) ; controler (pour contenir les différents contrôleurs, c’est-à-dire les différentes activités) et normalement le package view (sauf que nous n’avons pas besoin de l’ajouter, puisque le répertoire res/layout joue déjà le ce rôle).
Dans AS, l’ajout d’un package se réalise en faisant clic droit sur le répertoire parent (ici le package com.uasz.pacisse.coursuasz), puis New -> Package. Ajouter le mot « model » à la fin de la chaine dans la petite fenêtre qui s’ouvre et tapez la touche « enter » pour valider. Répéter le même procédé pour ajouter le sous package « controler » au même niveau que « model ». 
La création du projet s’est accompagnée de la création d’une activité principale (MainActivity) et de son interface associée (activity_main). Nous allons considérer MainActivity comme étant l’écran d’accueil qui permet à un utilisateur de se connecter à l’application.
Pour respecter l’architecture MVC, nous devons déplacer MainActivity dans le package controler. Pour cela, il faut faire un clic-maintient-déposer, puis Refractor.
#### 4.2 Développement du modèle de l'application
Le modèle de l’application (c’est-à-dire les différentes classes métier de l’application, du répertoire model) est constitué des classes citées plus haut dans la section 3.1, des différentes classes permettant d'interrroger l'API et de traiter les données recueillies (sous packages "webservices" du package "model") et des classes utilitaires du sous package "utilities" dont la classe "Constantes" (), la classe "JsonToObjectConverter" () et la classe "DataConverter" (). Tout le modèle de l'application (contenu du package "model") est ici (:




