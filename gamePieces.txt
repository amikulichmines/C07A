Authors: Alex Mikulich and Chantal Wang


Pieces:
Death Snail (D): follows player but slowly, kills if touches
Catapult (C): aims shots within three blocks but takes pot shots, doesn't move, does damage
Player (P) : You.
Terrible NPC (N) : Completely useless. Just observes, doesn't move or interact
Assassin (A): pops up in a random location and kills you if you land on it
Imposter (I): Takes the icon of another piece randomly, doesn't move - advances level on impact
Trophy (X): gives point if player lands on it



Questions:

In a turn, what is the sequence of actions?  (Player Move? Display? Pieces Move? Interactions Resolved?
First displays last board, then moves player, then does interactions, then pieces move

How does each level configuration get into the game?
Each level configuration gets into the game


Can a player and a piece be in the same location?
Yes they can, and it will show the player symbol instead of the other one


Can two pieces be in the same location?
Yes, and it will show the standstill piece symbol over the one that moved into its space


When a piece moves, what information must be updated (note, all movement is handled in the piece)
The information of its location and interaction conditions must be updated


How does the game know a level is complete?
The game knows the level is complete when you trigger the advance result in the enum interaction result
This comes from finding and landing on the imposter




Character/Game description:
In this game, you are the player, trying to get enough prizes to win, and find the 
sneaky imposter to advance the level. You have two health and need two points to win.
Points are won by getting a trophy, while the level is advanced by finding and landing 
on the imposter. There are things trying to kill you (such as death snail and assassin)
things that can harm you (catapult), and annoying people such as the useless NPC who just
watch you fail. 




