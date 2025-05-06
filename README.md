
# 🎓 Gestion Étudiants - Spring Boot

Une application de gestion des étudiants développée avec **Spring Boot**, permettant la gestion des filières, des modules, des inscriptions et des informations étudiantes.

## 🚀 Fonctionnalités principales

- ✅ CRUD pour les étudiants
- ✅ Gestion des filières
- ✅ Gestion des modules
- ✅ API REST complète pour toutes les entités
- ✅ Architecture propre et modulaire

## 📁 Structure du projet

```
gestion-etudiants/
├── controller/
├── model/
├── repository/
├── service/
├── dto/
├── config/
└── ...
```

## 🛠️ Technologies utilisées

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 / MySQL
- Lombok
- Maven

## 📦 Installation & Lancement

1. Clone le dépôt :
   ```bash
   git clone https://github.com/ryotashakur/gestion-etudiant-springboot.git
   ```

2. Ouvre le projet avec **IntelliJ** ou VsCode

3. Configure la base de données dans `application.properties` (ou utilise mysql pour les tests)

4. Lance l'application :
   ```bash
   mvn spring-boot:run
   ```

## 🔗 Endpoints API REST

| Méthode | URL                     | Description                      |
|--------|-------------------------|----------------------------------|
| GET    | /api/etudiants          | Liste des étudiants              |
| POST   | /api/etudiants          | Ajouter un étudiant              |
| PUT    | /api/etudiants/{id}     | Modifier un étudiant             |
| DELETE | /api/etudiants/{id}     | Supprimer un étudiant            |
| GET    | /api/filieres           | Liste des filières               |
| ...    |                         | Et bien d'autres...              |

## 👨‍💻 Auteur

- **ryotashakur**

## 📃 Licence

Ce projet est open-source et libre d'utilisation.
