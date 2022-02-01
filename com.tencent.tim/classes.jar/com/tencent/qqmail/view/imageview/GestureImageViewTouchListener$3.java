package com.tencent.qqmail.view.imageview;

class GestureImageViewTouchListener$3
  implements MoveAnimationListener
{
  GestureImageViewTouchListener$3(GestureImageViewTouchListener paramGestureImageViewTouchListener, QMGestureImageView paramQMGestureImageView) {}
  
  public void onMove(float paramFloat1, float paramFloat2)
  {
    this.val$image.setPosition(paramFloat1, paramFloat2);
    this.val$image.redraw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.imageview.GestureImageViewTouchListener.3
 * JD-Core Version:    0.7.0.1
 */