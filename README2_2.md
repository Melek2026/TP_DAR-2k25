# TP2 - Échange d'objets entre Client/Serveur via Sockets TCP

## Description du projet
Ce projet illustre l'échange d'objets Java entre un client et un serveur en utilisant les sockets TCP. Il permet au client d'envoyer un objet contenant deux opérandes et un opérateur au serveur. Le serveur effectue le calcul correspondant et renvoie le résultat au client.

L’objectif de ce TP est de se familiariser avec :
- L’utilisation de l’interface `Serializable` pour transmettre des objets en Java.
- La communication réseau via les sockets TCP.
- La structuration d’un projet client/serveur simple en Java.

---

## Fonctionnalités

1. **Client** :
   - Crée un objet contenant deux opérandes et un opérateur (`+`, `-`, `*`, `/`).
   - Envoie l'objet au serveur.
   - Reçoit le résultat du serveur et l’affiche.

2. **Serveur** :
   - Attend la connexion d’un client.
   - Reçoit l’objet envoyé par le client.
   - Effectue le calcul demandé.
   - Renvoie le résultat au client.

---

## Technologies utilisées

- Java JDK >= 1.8
- Eclipse IDE / IntelliJ IDEA / VS Code
- Git & GitHub

---

## Structure du projet

