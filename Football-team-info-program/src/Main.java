import java.io.*;
import java.util.*;

class team {

    String name = "";
    String family = "";
    String nationality = "";
    int counterTeam = 0;
    int age = 0;
}

class player extends team {

    int Tshirtnumber;
    int yellowcard = 0;
    int redcard = 0;

    public void status() {
        System.out.println("Player :");
        System.out.println("\tName: " + this.name);
        System.out.println("\tFamily: " + this.family);
        System.out.println("\tnationality: " + this.nationality);
        System.out.println("\tAge: " + this.age);
        System.out.println("\tT-shirt number: " + this.Tshirtnumber);
        System.out.println("\tnumber yellow cards: " + this.yellowcard);
        System.out.println("\tnumber red cards:" + this.redcard);
    }

    public void addyellowcards() {
        this.yellowcard++;
    }

    public void addredcards() {
        this.redcard++;
    }
}

class coach extends team {

    int idcode;

    public void status() {
        System.out.println("Coach:");
        System.out.println("\tName: " + this.name);
        System.out.println("\tFamily: " + this.family);
        System.out.println("\tnationality: " + this.nationality);
        System.out.println("\tAge: " + this.age);
        System.out.println("\tID code: " + this.idcode);
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        File file = new File("Football_file.txt");
        System.out.println(
                """
                        Hi
                        Welcome to our football program."""
        );
        ArrayList<player> playerList = new ArrayList<>();
        ArrayList<coach> coachesList = new ArrayList<>();
        boolean flag1 = false;
        while (!flag1) {
            System.out.println(
                    """
                            *****************************************************
                            * You can use below items for running program:      *
                            * 1 - Add player                                    *
                            * 2 - Add coach                                     *
                            * 3 - Delete player                                 *
                            * 4 - Delete coach                                  *
                            * 5 - Show my team                                  *
                            * 6 - Reset team                                    *
                            * 7 - Yellow cards                                  *
                            * 8 - Red cards                                     *
                            * 9 - Save team                                     *
                            * 10- load last team                                *
                            * 11- Exit                                          *
                            *****************************************************"""
            );
            System.out.print("------>");
            int firstoption = scanner.nextInt();
            switch (firstoption) {
                case 1:
                    System.out.println("How many player you want to add?");
                    int playerc = scanner.nextInt();
                    for (int i = 0; i < playerc; i++) {
                        player player = new player();
                        System.out.println("Player (" + (i + 1) + ") information:");
                        System.out.print("Player Name: ");
                        player.name = scanner.next();
                        System.out.print("Family name: ");
                        player.family = scanner.next();
                        System.out.print("Nationality: ");
                        player.nationality = scanner.next();
                        System.out.print("Age: ");
                        player.age = scanner.nextInt();
                        System.out.print("T-Shirt number: ");
                        player.Tshirtnumber = scanner.nextInt();
                        playerList.add(player);
                    }
                    System.out.println("Players have been added to the list.");
                    Thread.sleep(1500);
                    break;
                case 2:
                    for (int i = 0; i < 1; i++) {
                        coach coach = new coach();
                        System.out.println("Coach:");
                        System.out.print("Name: ");
                        coach.name = scanner.next();
                        System.out.print("Family name: ");
                        coach.family = scanner.next();
                        System.out.print("Nationality: ");
                        coach.nationality = scanner.next();
                        System.out.print("Age: ");
                        coach.age = scanner.nextInt();
                        System.out.print("ID code: ");
                        coach.idcode = scanner.nextInt();
                        coachesList.add(coach);
                    }
                    break;
                case 3:
                    System.out.print("Enter the player T-Shirt number to delete it: ");
                    int deleteplayer = scanner.nextInt();
                    for (int i = 0; i < playerList.size(); i++) {
                        if (playerList.get(i).Tshirtnumber == deleteplayer) {
                            playerList.remove(i);
                            System.out.println("Player removed.");
                            Thread.sleep(1000);
                        } else {
                            System.out.println("Entered T Shirt Number does not exist.");
                            Thread.sleep(1000);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter the coach IDcode to delete it: ");
                    int deletecoach = scanner.nextInt();
                    for (int i = 0; i < coachesList.size(); i++) {
                        if (coachesList.get(i).idcode == deletecoach) {
                            coachesList.remove(i);
                            System.out.println("Coach removed.");
                            Thread.sleep(1000);
                        }
                    }
                    break;
                case 5:
                    System.out.println(
                            "You have (" +
                                    playerList.size() +
                                    ") player and (" +
                                    coachesList.size() +
                                    ") coach in your team."
                    );
                    for (coach coach : coachesList) {
                        coach.status();
                        Thread.sleep(1000);
                        System.out.println("*********************");
                    }

                    for (player player : playerList) {
                        player.status();
                        Thread.sleep(1000);
                        System.out.println("*********************");
                    }
                    System.out.print("Enter (y) for continue. -->");
                    char ch = scanner.next().charAt(0);
                    if (ch == 'y') {
                        break;
                    } else {
                        System.out.println("That was not (y) but we accept it.");
                        Thread.sleep(1000);
                        break;
                    }
                    //break;
                case 6:
                    System.out.println(
                            """
                                    *****************************************************
                                    Warning:
                                    This action will erase every information you entered.
                                    Do you want to continue?? (y/n)"""
                    );
                    char continue1 = scanner.next().charAt(0);
                    if (continue1 == 'y') {
                        playerList.clear();
                        coachesList.clear();
                        System.out.println("Your team list restarted.");
                        Thread.sleep(2003);
                    } else {
                        break;
                    }
                    break;
                case 7:
                    System.out.println(
                            "Enter the shirt number of the player you want to give a yellow card to:"
                    );
                    int givey = scanner.nextInt();
                    playerList.get(givey - 1).addyellowcards();
                    System.out.println("Player has received a yellow card.");
                    Thread.sleep(2003);
                    break;
                case 8:
                    System.out.println(
                            "Enter the shirt number of the player you want to give a red card to:"
                    );
                    int giver = scanner.nextInt();
                    playerList.get(giver - 1).addredcards();
                    System.out.println("Player has received a red card.");
                    Thread.sleep(2003);
                    break;
                case 9:
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    for (int i = 0; i < playerList.size(); i++) {
                        writer.write(0 + ",");
                        writer.write(playerList.get(i).name + ",");
                        writer.write(playerList.get(i).family + ",");
                        writer.write(playerList.get(i).nationality + ",");
                        writer.write(playerList.get(i).age + ",");
                        writer.write(playerList.get(i).Tshirtnumber + ",");
                        writer.write(playerList.get(i).yellowcard + ",");
                        writer.write(playerList.get(i).redcard + "\n");
                    }
                    for (int i = 0; i < coachesList.size(); i++) {
                        writer.write(1 + ",");
                        writer.write(coachesList.get(i).name + ",");
                        writer.write(coachesList.get(i).family + ",");
                        writer.write(coachesList.get(i).nationality + ",");
                        writer.write(coachesList.get(i).age + ",");
                        writer.write(coachesList.get(i).idcode + "\n");
                    }
                    writer.close();
                    System.out.println("Your program information is been saved.");
                    Thread.sleep(2000);
                    break;
                case 10:
                    Scanner freader = new Scanner(file);
                    while (freader.hasNextLine()) {
                        String data = freader.nextLine();
                        String[] arrayData = data.split(",");
                        if (Integer.parseInt(arrayData[0]) == 0) {
                            player player = new player();
                            player.name = arrayData[1];
                            player.family = arrayData[2];
                            player.nationality = arrayData[3];
                            player.age = Integer.parseInt(arrayData[4]);
                            player.Tshirtnumber = Integer.parseInt(arrayData[5]);
                            player.yellowcard = Integer.parseInt(arrayData[6]);
                            player.redcard = Integer.parseInt(arrayData[7]);
                            playerList.add(player);
                        } else if (Integer.parseInt(arrayData[0]) == 1) {
                            coach coach = new coach();
                            coach.name = arrayData[1];
                            coach.family = arrayData[2];
                            coach.nationality = arrayData[3];
                            coach.age = Integer.parseInt(arrayData[4]);
                            coach.idcode = Integer.parseInt(arrayData[5]);
                            coachesList.add(coach);
                        }
                    }
                    freader.close();
                    System.out.println("Your cars list has been received.");
                    Thread.sleep(2000);
                    System.out.println("received list is include this players and coaches: ");
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                        reader.close();
                    } catch (IOException e) {
                        System.out.println("Error occurred.");
                        e.printStackTrace();
                    }
                    Thread.sleep(2003);
                    break;
                case 11:
                    System.out.print("Logging out");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.print(".");
                    flag1 = true;
                    break;
                default:
                    System.out.println("The entered number does not exist.");
                    Thread.sleep(1000);
            }
        }
    }
}
