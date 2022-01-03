# MediaBoutique - TP d'E-Services - ING 3 info

# Développement

- IDE: Intellij
- JDK: 11

### 1. Récupérer le projet

Faire un clone de ce projet : `git clone https://github.com/vykio/MediaBoutique.git`

### 2. Configurer Wildfly

Ajouter le driver MySQL dans les fichiers de Wildfly

Définir la configuration dans `standalone.xml` de Wildfly afin de configurer la connexion à notre BDD

Ajouter la source de données à notre projet Intellij

Lancer le script SQL dans notre console SQL (PHPMyAdmin, DBeaver...) sur la base de données afin de créer les tables

Faire le lien entre les tables créées et les entités en ajoutant la datasource aux entités JPA

### 3. Configurer la configuration de RUN sur Intellij

> Edit Configurations...

Créer une configuration de Wildfly REMOTE

Changer le port en 9990

Ajouter les identifiants de connexion (peut être optionnel?)

Dans l'URL, mettre `http://localhost:8080/MediaBoutique` où MediaBoutique est défini dans le fichier `jboss-web.xml` dans l'élément Context Root

Dans la droplist "Remote Staging" > "Type", mettre `Same file system`

Vérifier que nous avons déjà notre .ear dans l'onglet `Déploiement`, si non l'ajouter (MediaBoutique:ear)
