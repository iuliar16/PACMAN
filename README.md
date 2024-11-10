# Java PACMAN Game

This project is a classic PACMAN game implemented in Java, showcasing strong Object-Oriented Programming (OOP) techniques. The game features multiple levels, each increasing in difficulty with more complex labyrinths and faster, more intelligent ghosts that follow PACMAN. 

##### Features
##### Multiple Levels: Progressively challenging levels with labyrinths that become increasingly intricate, introducing more ghosts that move faster and chase PACMAN more intelligently.
##### OOP Architecture: The game is built around key OOP principles like inheritance, encapsulation, polymorphism, and abstraction, creating a modular, easy-to-extend structure.
##### Design Patterns:
###### Singleton Pattern: Used for managing game settings and configurations, ensuring only one instance is active throughout the game lifecycle.
###### State Pattern: Manages game states (e.g., paused, running, game over), allowing smooth transitions between different stages of gameplay.
##### Exception Handling: Custom exception classes for game-specific issues (e.g., invalid level data, database connection errors), providing clear, context-specific error messages and robust error handling.
##### SQLite Database: Stores game data, including high scores and progress tracking, making it easy to retrieve and update player data across sessions.
##### Runnable and Threads: The game logic and animations are managed through Java's Runnable interface and multithreading, allowing smooth gameplay and responsive controls.

