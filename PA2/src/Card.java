/*
Implement a class Card whose constructor takes the card notation string and whose
getDescription method returns a description of the card. If the notation string is not in the correct
format, the getDescription method should return the string "Unknown".
 */
public class Card {
    private String description;

    public Card(String description) {
        this.description = description;
    }

    /**
     * Get full description of the Card
     *
     * @return full description of the card.
     */
    public String getDescription() {
        String number = getNumber();
        String suit = getSuit();
        if (number.equals("Unknown") || suit.equals("Unknown"))
            return "Unknown";
        else
            return number + " of " + suit;
    }

    /*
    Helper method to get the suit of the card.
     */
    private String getSuit() {
        char suit = 'u';
        String result = "";
        if (description.length() == 3)
            suit = description.charAt(2);
        else if (description.length() == 2)
            suit = description.charAt(1);
        switch (suit) {
            case 'D':
                result = "Diamonds";
                break;
            case 'H':
                result = "Hearts";
                break;
            case 'S':
                result = "Spades";
                break;
            case 'C':
                result = "Clubs";
                break;
            default:
                result = "Unknown";
                break;
        }
        return result;
    }

    /*
   Helper method to get the suit of the card.
    */
    private String getNumber() {
        char number = '0';
        String result = "";
        if (description.length() == 3 && description.startsWith("10"))
            number = 't';
        else if (description.length() == 2)
            number = description.charAt(0);
        switch (number) {
            case '2':
                result = "Two";
                break;
            case '3':
                result = "Three";
                break;
            case '4':
                result = "Four";
                break;
            case '5':
                result = "Five";
                break;
            case '6':
                result = "Six";
                break;
            case '7':
                result = "Seven";
                break;
            case '8':
                result = "Eight";
                break;
            case '9':
                result = "Nine";
                break;
            case 't':
                result = "Ten";
                break;
            case 'A':
                result = "Ace";
                break;
            case 'J':
                result = "Jack";
                break;
            case 'Q':
                result = "Queen";
                break;
            case 'K':
                result = "King";
                break;
            default:
                result = "Unknown";
                break;
        }
        return result;
    }
}
