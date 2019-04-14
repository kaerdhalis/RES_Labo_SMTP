# RES_Labo_SMTP
Benjamin le Guillou
# Descrition
Le projet suis l'architecture proposer dans les labos cad un client SMTP qui prend en parametre une instance de la classe message et ouvre un socket SMTP vers le serveur.
IL y a egalement un generateur de prank qui genere une combinaison de message et de groupe de maniere aleatoire.
Les informations relatives a l'utilisateur sont stocker dans le fichier config

# Instruction pour le Mock smtp
Le dockerfile utilise directement l'adresse du repository github et est base sur le repo git https://github.com/robinong79/docker-mockmock
construire l'image pour le mock smtp puis lancer la commande:
sudo docker run -p 2525:2525 -p 8282:8282  mock
le port par default a ete configurer a 25252

# Instruction pour configurer l'application
Les seuls fichiers que l'utilisateur doit modifier sont situe dans le dossier config.
Les messages doivent etre ecrit selon le template fournis
les victimes doivent etre reference par une adresse de la forme firstname.lastname@domain

les configuration du serveur se font dans le fichier config.properties

