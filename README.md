# VerteilteSysteme
Verteilte Systeme - Lea Kollmar, Nico Pfaff

Bei diesem Microservice handelt es sich um einen Alltagshelfer der mit Hilfe einer ToDo-Liste Struktur und Übersicht bieten soll.

How to start:

1. Klone das Repository
2. Starte Docker
3. Starte die Datenbank in der Commandline:
	docker run -d --env MYSQL_ROOT_PASSWORD="mysecretpassword" --env MYSQL_DATABASE="db" --publish 3306:3306 mysql
4. Starte das Projekt „ToDoListe-configServer“ in Eclipse
5. Starte das Projekt „ToDoListeService“ in Eclipse
6. Öffne den Webbrowser:
	http://localhost:8080
7. Viel Spaß! 
