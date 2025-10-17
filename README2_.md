# TP2 – Activité 2-1 : Échange de chaînes de caractères entre Client et Serveur via les Sockets TCP

## Objectif
Ce projet permet l’échange de messages textuels complets entre un client et un serveur en Java, en utilisant les sockets TCP.  
Contrairement au TP précédent, où un seul octet était transmis, cette activité permet l’envoi d’une **opération arithmétique complète** (par exemple : `55 * 25`).  

Le client saisit l’opération (les deux nombres et l’opérateur), l’envoie au serveur, qui calcule le résultat et le renvoie au client.

## Technologies utilisées
- Java (JDK ≥ 1.8)  
- Eclipse IDE  
- Communication TCP via `Socket` et `ServerSocket`  
- Flux de caractères : `InputStreamReader`, `BufferedReader`, `PrintWriter`  

## Fonctionnement
1. **Client** :  
   - Saisie de l’opération arithmétique.  
   - Envoi de la chaîne de caractères au serveur.

2. **Serveur** :  
   - Réception de la chaîne.  
   - Analyse pour extraire les nombres et l’opérateur.  
   - Calcul du résultat et renvoi au client.

3. **Communication** :  
   - Transfert des messages via des flux de caractères pour permettre l’échange de chaînes complètes.

## Livrables
- Code source Java pour le client et le serveur.  
- Document Word avec captures d’écran des étapes.  
- Dépôt GitHub avec le projet complet et ce fichier README.

## Bénéfices pédagogiques
- Se familiariser avec la **programmation réseau** en Java (client/serveur).  
- Gérer les **flux d’entrée et de sortie** (`java.io`).  
- Comprendre la structure et le fonctionnement d’une **application client/serveur**.
