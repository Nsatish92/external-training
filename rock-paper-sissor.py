import random

def play_game():
    choices = ["rock", "paper", "scissors"]

    # Create a dictionary of winning conditions
    winning_conditions = {
        "rock": "scissors",
        "paper": "rock",
        "scissors": "paper"
    }

    # Get player's choice
    player_choice = input("Enter your choice (rock/paper/scissors): ").lower()

    # Validate player's choice
    while player_choice not in choices:
        print("Invalid choice. Please try again.")
        player_choice = input("Enter your choice (rock/paper/scissors): ").lower()

    # Generate computer's choice
    computer_choice = random.choice(choices)

    print("Player chose:", player_choice)
    print("Computer chose:", computer_choice)

    # Determine the winner
    if player_choice == computer_choice:
        print("It's a tie!")
    elif winning_conditions[player_choice] == computer_choice:
        print("Player wins!")
    else:
        print("Computer wins!")

    play_again = input("Do you want to play again? (yes/no): ").lower()
    if play_again == "yes":
        play_game()
    else:
        print("Thanks for playing!")

# Start the game
play_game()
