package com.quinacridone.cursed;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Hero {
  static final int HALF_STEP = 8;
  static final int MOVEMENT = 1;
  public float x;
  public float y;
  public int targetPos;
  public boolean isMoving;
  public Direction direction;
  private Sprite sprite;

  public Hero(TextureRegion texture, float x, float y) {
    this.sprite = new Sprite(texture);
    this.x = x;
    this.y = y;
    isMoving = false;
    direction = Direction.Up;
    targetPos = 0;
  }

  public void draw(Batch batch) {
    sprite.draw(batch);
  }

  public void update() {
    movement();
  }

  private void movement() {
    if (Gdx.input.isKeyPressed(Input.Keys.UP) && !isMoving) {
      direction = Direction.Up;
      if (isAligned()) {
        targetPos = HALF_STEP;
        isMoving = true;
      }
    }
    if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && !isMoving) {
      direction = Direction.Down;
      if (isAligned()) {
        targetPos = -HALF_STEP;
        isMoving = true;
      }
    }
    if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && !isMoving) {
      direction = Direction.Right;
      if (isAligned()) {
        targetPos = HALF_STEP;
        isMoving = true;
      }
    }
    if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && !isMoving) {
      direction = Direction.Left;
      if (isAligned()) {
        targetPos = -HALF_STEP;
        isMoving = true;
      }
    }
    checkMovementState();
    sprite.setPosition(x, y);
  }

  private boolean isAligned() {
    return (x % HALF_STEP == 0 && y % HALF_STEP == 0);
  }

  private void checkMovementState() {
    if (targetPos < 0) {
      if (direction == Direction.Left) {
        targetPos += MOVEMENT;
        x -= MOVEMENT;
      } else {
        targetPos += MOVEMENT;
        y -= MOVEMENT;
      }
    }
    if (targetPos > 0) {
      if (direction == Direction.Right) {
        targetPos -= MOVEMENT;
        x += MOVEMENT;
      } else { // down
        targetPos -= MOVEMENT;
        y += MOVEMENT;
      }
    }
    if (targetPos == 0) {
      isMoving = false;
    }
  }

  enum Direction {
    Up,
    Down,
    Left,
    Right,
    None
  }
}
