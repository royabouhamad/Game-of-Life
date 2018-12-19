import java.util.*;
import java.io.*;

public class GameLogic {

  private Map myMap;
  private Map newState;
  private Scanner scan = new Scanner(System.in);
  private int height;
  private int width;

  public GameLogic() {
    System.out.print("Please enter width: ");
    width = getInput();
    System.out.print("Please enter height: ");
    height = getInput();
    myMap = new Map(height, width);
    newState = new Map(height, width);
  }

  private int getInput() {
    int command = scan.nextInt();
    return command;
  }

  protected void printMap() {
    int[][] fullMap = myMap.getMap();
    for (int i = 0; i < fullMap.length; i++) {
      for (int j = 0; j < fullMap[0].length; j++) {
        System.out.print(fullMap[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  protected void nextBoardState() {
    int counter = 0;
    while (counter < 100) {
      newState.setDeadState();
      int[][] fullMap = myMap.getMap();
      for (int y = 0; y < fullMap.length; y++) {
        for (int x = 0; x < fullMap[0].length; x++) {
          int liveNeighbours = 0;
          int currentState = fullMap[y][x];

          outerloop:
          for (int i = y - 1; i < y + 2; i++) {
            innerloop:
            for (int j = x - 1; j < x + 2; j++) {
              if (j == x && i == y) {
                continue innerloop;
              } else if (j < 0) {
                continue innerloop;
              } else if (i < 0){
                continue outerloop;
              } else if (j > width - 1) {
                break innerloop;
              } else if (i > height - 1) {
                break outerloop;
              } else {
                if (fullMap[i][j] == 1) {
                  liveNeighbours++;
                }
              }
            }
          }

          if (liveNeighbours < 2 && currentState == 1) {
            newState.setTile(y, x, 0);
          } else if (liveNeighbours > 1 && liveNeighbours < 4 && currentState == 1) {
            newState.setTile(y, x, 1);
          } else if (liveNeighbours > 3 && currentState == 1) {
            newState.setTile(y, x, 0);
          } else if (liveNeighbours == 3 && currentState == 0) {
            newState.setTile(y, x, 1);
          }
        }
      }

      myMap.setState(newState);
      printMap();
      try {
        Thread.sleep(200);
      } catch (InterruptedException ex) {}
      counter++;
    }
  }

  public static void main(String[] args) {
    GameLogic logic = new GameLogic();
    logic.printMap();
    logic.nextBoardState();
  }
}
