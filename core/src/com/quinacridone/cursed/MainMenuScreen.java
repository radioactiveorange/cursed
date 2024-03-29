package com.quinacridone.cursed;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {

  final Cursed game;

  OrthographicCamera camera;

  public MainMenuScreen(final Cursed game) {
    this.game = game;

    camera = new OrthographicCamera();
    camera.setToOrtho(false, 256, 224);
    camera.update();
  }

  @Override
  public void show() {}

  @Override
  public void render(float delta) {
    ScreenUtils.clear(0, 0, 0, 1);

    camera.update();
    game.batch.setProjectionMatrix(camera.combined);

    game.batch.begin();
    game.font.draw(game.batch, "Welcome to Cursed!!! ", 20, 150);
    game.font.draw(game.batch, "Tap anywhere to begin!", 0, 100);
    game.batch.end();

    if (Gdx.input.isTouched()) {
      game.setScreen(new GameScreen(game));
      dispose();
    }
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
  public void dispose() {}
}
