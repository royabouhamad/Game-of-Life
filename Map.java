import java.lang.Math;

public class Map {
  private int[][] map;

  public Map(int height, int width) {
    map = new int[height][width];
    setRandomState();
  }

  private void setRandomState() {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        map[i][j] = (int)(Math.random() + 0.5);
      }
    }
  }

  protected void setDeadState() {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        map[i][j] = 0;
      }
    }
  }

  protected void setTile(int y, int x, int tileState) {
    map[y][x] = tileState;
  }

  protected void setState(Map newState) {
    int[][] newMap = newState.getMap();
    for (int i = 0; i < newMap.length; i++) {
      for (int j = 0; j < newMap[0].length; j++) {
        map[i][j] = newMap[i][j];
      }
    }
  }

  protected int[][] getMap() {
    return map;
  }
}
