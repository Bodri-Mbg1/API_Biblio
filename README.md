API de Gestion des Emprunts de Livres
Cette API permet de gérer les emprunts et les retours de livres dans une bibliothèque. Elle permet aux utilisateurs de créer des emprunts de livres, retourner des livres empruntés et consulter les emprunts actifs. Elle met également à jour la disponibilité des exemplaires de livres lors des retours.

Fonctionnalités principales :
Création d'un emprunt : L'utilisateur peut emprunter un livre en spécifiant l'ID du livre, l'ID de l'utilisateur et la date d'emprunt.
Retour d'un livre : L'utilisateur peut retourner un livre en spécifiant la date de retour. Lors du retour, le nombre d'exemplaires disponibles pour ce livre est mis à jour.
Consultation des emprunts actifs : Permet de récupérer la liste de tous les emprunts en cours, c'est-à-dire les livres qui n'ont pas encore été retournés.
Consultation des détails d'un emprunt : Permet de consulter les informations détaillées d'un emprunt spécifique, incluant la date d'emprunt, la date de retour (si elle existe), et le livre emprunté.
Sécurisation :
L'API utilise JWT (JSON Web Tokens) pour sécuriser les accès. Chaque utilisateur doit d'abord s'authentifier pour obtenir un jeton d'accès, qui sera ensuite utilisé pour toutes les requêtes nécessitant une authentification.

C'est un résumé simple expliquant le but et les fonctionnalités de l'API sans entrer dans les détails techniques. Si tu veux des ajustements, n'hésite pas à me le dire ! 😊
