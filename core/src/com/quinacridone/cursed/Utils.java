package com.quinacridone.cursed;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;

public final class Utils {
  public static Position getPositionFromLayer(TiledMapTileLayer layer, int id) {
    for (int x = 0; x < layer.getWidth(); x++) {
      for (int y = 0; y < layer.getHeight(); y++) {
        Cell cell = layer.getCell(x, y);
        if (cell != null) {
          if (cell.getTile().getId() - 1 == id) {
            return new Position(x, y);
          }
        }
      }
    }
    return null;
  }

  public static Cell getCellFromLayer(TiledMapTileLayer layer, int id) {
    for (int x = 0; x < layer.getWidth(); x++) {
      for (int y = 0; y < layer.getHeight(); y++) {
        Cell cell = layer.getCell(x, y);
        if (cell != null) {
          if (cell.getTile().getId() - 1 == id) {
            return cell;
          }
        }
      }
    }
    return null;
  }
}
