package com.quinacridone.cursed;

import static com.quinacridone.cursed.Utils.getCellFromLayer;
import static com.quinacridone.cursed.Utils.getPositionFromLayer;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
  static final int CHARACTER_TILE_ID = 60;
  static final int TILE_SIZE = 16;
  final Cursed game;
  TextureRegion player;
  TiledMap map;
  float unitScale = 1 / 16f;
  OrthogonalTiledMapRenderer renderer;
  OrthographicCamera camera;
  Hero character;

  public GameScreen(final Cursed game) {
    this.game = game;

    // create the camera
    camera = new OrthographicCamera();
    camera.setToOrtho(false, 16, 14);

    // load the map and create renderer
    map = new TmxMapLoader().load("level1.tmx");
    renderer = new OrthogonalTiledMapRenderer(map, unitScale);

    convertMapToObjects(map);
    //    TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(0);
    //    Cell cell = getCellFromLayer(layer, CHARACTER_TILE_ID);
    //    Position position = getPositionFromLayer(layer, CHARACTER_TILE_ID);
    //    if (cell != null && position != null) {
    //      TiledMapTile tile = cell.getTile();
    //      player = tile.getTextureRegion();
    //      character = new Hero(tile.getTextureRegion(), position.x * TILE_SIZE, position.y *
    // TILE_SIZE);
    //      cell.setTile(null);
    //    }
  }

  private void convertMapToObjects(TiledMap map) {
    TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(0);

    Cell cell = getCellFromLayer(layer, CHARACTER_TILE_ID);

    Position position = getPositionFromLayer(layer, CHARACTER_TILE_ID);
    if (cell != null && position != null) {
      TiledMapTile tile = cell.getTile();

      player = tile.getTextureRegion();
      character = new Hero(tile.getTextureRegion(), position.x * TILE_SIZE, position.y * TILE_SIZE);
      cell.setTile(null);
    }
  }

  @Override
  public void show() {}

  @Override
  public void render(float delta) {
    ScreenUtils.clear(0, 0, 0, 1);
    camera.update();
    renderer.setView(camera);
    renderer.render();

    game.batch.begin();
    //    game.batch.draw(
    //        player, character.x, character.y, player.getRegionWidth(), player.getRegionHeight());
    character.draw(game.batch);
    game.batch.end();

    character.update();
  }

  @Override
  public void resize(int width, int height) {}

  @Override
  public void pause() {}

  @Override
  public void resume() {}

  @Override
  public void hide() {}

  @Override
  public void dispose() {
    map.dispose();
  }
}
