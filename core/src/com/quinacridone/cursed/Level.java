package com.quinacridone.cursed;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import static java.lang.String.format;

public class Level {
  public Level(int floor, int level) {
    TiledMap map = new TmxMapLoader().load(format("level_%s-%s.tmx", floor, level));
  }

  public void draw(Batch batch) {}
}
