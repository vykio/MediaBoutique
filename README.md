# MediaBoutique - TP d'E-Services - ING 3 info

# Développement

- IDE: Intellij
- JDK: 11

### 1. Récupérer le projet

- [ ] Faire un clone de ce projet : `git clone https://github.com/vykio/MediaBoutique.git`

### 2. Configurer Wildfly

- [ ] Ajouter le driver MySQL dans les fichiers de Wildfly

- [ ] Définir la configuration dans `standalone.xml` de Wildfly afin de configurer la connexion à notre BDD

```xml
<datasource jta="true" jndi-name="java:/MaBootiqueDS" pool-name="MaBootiqueDS" enabled="true" use-java-context="true" use-ccm="true">
    <connection-url>jdbc:mysql://localhost:(((PORT)))/(((Base De Données)))</connection-url>
    <driver>mysql</driver>
    <security>
        <user-name>(((USERNAME)))</user-name>
        <password>(((PASSWORD)))</password>
    </security>
    <statement>
        <prepared-statement-cache-size>100</prepared-statement-cache-size>
        <share-prepared-statements>true</share-prepared-statements>
    </statement>
</datasource>
```
où `MaBootiqueDS` représente le Data Store utilisé dans le projet


- [ ] Ajouter la source de données à notre projet Intellij

- [ ] Lancer le [Script SQL](https://gist.github.com/vykio/b3427b5a0eb61d8067103671412584c7) dans notre console SQL (PHPMyAdmin, DBeaver...) sur la base de données afin de créer les tables

- [ ] Faire le lien entre les tables créées et les entités en ajoutant la datasource aux entités JPA

### 3. Configurer la configuration de RUN sur Intellij

> Edit Configurations...

- [ ] Créer une configuration de Wildfly REMOTE

- [ ] Changer le port en 9990

- [ ] Ajouter les identifiants de connexion (peut être optionnel?)

- [ ] Dans l'URL, mettre `http://localhost:8080/MediaBoutique` où MediaBoutique est défini dans le fichier `jboss-web.xml` dans l'élément Context Root

- [ ] Dans la droplist "Remote Staging" > "Type", mettre `Same file system`

- [ ] Vérifier que nous avons déjà notre .ear dans l'onglet `Déploiement`, si non l'ajouter (MediaBoutique:ear)

    - > Dans le cas où dans les `Artifacts` vous ne trouvez pas l'EJB et l'EAR, il faut les créer manuellement.
        
        Pour cela,il faut créer l'artifact de type `EJB exploded` (nommé MediaBoutiqueEJB:ejb exploded) puis créer l'artifact de type `EJB Archive` contenant l'exploded (nommé MediaBoutiqueEJB:ejb)
        
        Pour l'EAR, il faut créer un nouvel artifact nommé MediaBoutique:ear exploded de type `JavaEE Application Exploded` contenant les artifacts EJB et WEB et créer l'artifact de type `JavaEE Application Archive` contenant l'EAR exploded.
