package com.tencent.qqmail.view.imageview;

import android.graphics.PointF;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;

public class GestureImageViewTouchListener
  implements View.OnTouchListener
{
  private float boundaryBottom = 0.0F;
  private float boundaryLeft = 0.0F;
  private float boundaryRight = 0.0F;
  private float boundaryTop = 0.0F;
  private boolean canDragX = false;
  private boolean canDragY = false;
  private int canvasHeight = 0;
  private int canvasWidth = 0;
  private float centerX = 0.0F;
  private float centerY = 0.0F;
  private final PointF current = new PointF();
  private float currentScale = 1.0F;
  private int displayHeight;
  private int displayWidth;
  private float fitScaleHorizontal = 1.0F;
  private float fitScaleVertical = 1.0F;
  private FlingAnimation flingAnimation;
  private GestureDetector flingDetector;
  private FlingListener flingListener;
  private QMGestureImageView image;
  private int imageHeight;
  private GestureImageViewListener imageListener;
  private int imageWidth;
  private boolean inZoom = false;
  private float initialDistance;
  private final PointF last = new PointF();
  private int lastEffectiveHeight;
  private int lastEffectiveWidth;
  private float lastScale = 1.0F;
  private float maxScale = 5.0F;
  private final PointF midpoint = new PointF();
  private float minScale = 0.25F;
  private MoveAnimation moveAnimation;
  private boolean multiTouch = false;
  private final PointF next = new PointF();
  private View.OnClickListener onClickListener;
  private View.OnLongClickListener onLongClickListener;
  private final VectorF pinchVector = new VectorF();
  private final VectorF scaleVector = new VectorF();
  private float startingScale = 0.0F;
  private GestureDetector tapDetector;
  private boolean touched = false;
  private ZoomAnimation zoomAnimation;
  
  public GestureImageViewTouchListener(QMGestureImageView paramQMGestureImageView, int paramInt1, int paramInt2)
  {
    this.image = paramQMGestureImageView;
    this.displayWidth = paramInt1;
    this.displayHeight = paramInt2;
    this.centerX = (paramInt1 / 2.0F);
    this.centerY = (paramInt2 / 2.0F);
    this.imageWidth = paramQMGestureImageView.getImageWidth();
    this.imageHeight = paramQMGestureImageView.getImageHeight();
    this.startingScale = paramQMGestureImageView.getScale();
    this.currentScale = this.startingScale;
    this.lastScale = this.startingScale;
    this.boundaryRight = paramInt1;
    this.boundaryBottom = paramInt2;
    this.boundaryLeft = 0.0F;
    this.boundaryTop = 0.0F;
    Log.d("download", "calculateBoundaries boundaryLeft " + this.boundaryLeft + " boundaryRight " + this.boundaryRight + ", currentScale:" + this.currentScale);
    this.next.x = paramQMGestureImageView.getImageX();
    this.next.y = paramQMGestureImageView.getImageY();
    this.flingListener = new FlingListener();
    this.flingAnimation = new FlingAnimation();
    this.zoomAnimation = new ZoomAnimation();
    this.moveAnimation = new MoveAnimation();
    this.flingAnimation.setListener(new GestureImageViewTouchListener.1(this));
    this.zoomAnimation.setZoom(2.0F);
    this.zoomAnimation.setZoomAnimationListener(new GestureImageViewTouchListener.2(this));
    this.moveAnimation.setMoveAnimationListener(new GestureImageViewTouchListener.3(this, paramQMGestureImageView));
    this.tapDetector = new GestureDetector(paramQMGestureImageView.getContext(), new GestureImageViewTouchListener.4(this, paramQMGestureImageView));
    this.flingDetector = new GestureDetector(paramQMGestureImageView.getContext(), this.flingListener);
    this.imageListener = paramQMGestureImageView.getGestureImageViewListener();
    calculateBoundaries();
  }
  
  private void startFling()
  {
    this.flingAnimation.setVelocityX(this.flingListener.getVelocityX());
    this.flingAnimation.setVelocityY(this.flingListener.getVelocityY());
    this.image.animationStart(this.flingAnimation);
  }
  
  private void startZoom(MotionEvent paramMotionEvent)
  {
    this.inZoom = true;
    this.zoomAnimation.reset();
    float f;
    if (this.image.isLandscape()) {
      if (this.image.getDeviceOrientation() == 1) {
        if (this.image.getScaledHeight() < this.canvasHeight)
        {
          f = this.fitScaleVertical / this.currentScale;
          this.zoomAnimation.setTouchX(paramMotionEvent.getX());
          this.zoomAnimation.setTouchY(this.image.getCenterY());
        }
      }
    }
    for (;;)
    {
      Log.d("download", "start zoom animation zooto=" + f);
      this.zoomAnimation.setZoom(f);
      this.image.animationStart(this.zoomAnimation);
      return;
      f = this.fitScaleHorizontal / this.currentScale;
      this.zoomAnimation.setTouchX(this.image.getCenterX());
      this.zoomAnimation.setTouchY(this.image.getCenterY());
      continue;
      int i = this.image.getScaledWidth();
      if (i == this.canvasWidth)
      {
        f = this.currentScale * 4.0F;
        this.zoomAnimation.setTouchX(paramMotionEvent.getX());
        this.zoomAnimation.setTouchY(paramMotionEvent.getY());
      }
      else if (i < this.canvasWidth)
      {
        f = this.fitScaleHorizontal / this.currentScale;
        this.zoomAnimation.setTouchX(this.image.getCenterX());
        this.zoomAnimation.setTouchY(paramMotionEvent.getY());
      }
      else
      {
        f = this.fitScaleHorizontal / this.currentScale;
        this.zoomAnimation.setTouchX(this.image.getCenterX());
        this.zoomAnimation.setTouchY(this.image.getCenterY());
        continue;
        if (this.image.getDeviceOrientation() == 1)
        {
          i = this.image.getScaledHeight();
          if (i == this.canvasHeight)
          {
            f = this.currentScale * 4.0F;
            this.zoomAnimation.setTouchX(paramMotionEvent.getX());
            this.zoomAnimation.setTouchY(paramMotionEvent.getY());
          }
          else if (i < this.canvasHeight)
          {
            f = this.fitScaleVertical / this.currentScale;
            this.zoomAnimation.setTouchX(paramMotionEvent.getX());
            this.zoomAnimation.setTouchY(this.image.getCenterY());
          }
          else
          {
            f = this.fitScaleVertical / this.currentScale;
            this.zoomAnimation.setTouchX(this.image.getCenterX());
            this.zoomAnimation.setTouchY(this.image.getCenterY());
          }
        }
        else if (this.image.getScaledWidth() < this.canvasWidth)
        {
          f = this.fitScaleHorizontal / this.currentScale;
          this.zoomAnimation.setTouchX(this.image.getCenterX());
          this.zoomAnimation.setTouchY(paramMotionEvent.getY());
        }
        else
        {
          f = this.fitScaleVertical / this.currentScale;
          this.zoomAnimation.setTouchX(this.image.getCenterX());
          this.zoomAnimation.setTouchY(this.image.getCenterY());
        }
      }
    }
  }
  
  private void stopAnimations()
  {
    this.image.animationStop();
  }
  
  protected void boundCoordinates()
  {
    if (!this.image.getMoveable())
    {
      if (this.next.x >= this.boundaryLeft) {
        break label63;
      }
      this.next.x = this.boundaryLeft;
    }
    label63:
    do
    {
      while (this.next.y < this.boundaryTop)
      {
        this.next.y = this.boundaryTop;
        return;
        if (this.next.x > this.boundaryRight) {
          this.next.x = this.boundaryRight;
        }
      }
    } while (this.next.y <= this.boundaryBottom);
    this.next.y = this.boundaryBottom;
  }
  
  protected void calculateBoundaries()
  {
    boolean bool2 = false;
    int i = Math.round(this.imageWidth * this.currentScale);
    int j = Math.round(this.imageHeight * this.currentScale);
    this.lastEffectiveWidth = i;
    this.lastEffectiveHeight = j;
    boolean bool1;
    label117:
    float f;
    if (this.image.isImageSmall() == true) {
      if (i * this.image.getFactorWidth() > this.displayWidth)
      {
        bool1 = true;
        this.canDragX = bool1;
        if (this.image.isImageSmall() != true) {
          break label636;
        }
        bool1 = bool2;
        if (j * this.image.getFactorHeight() > this.displayHeight) {
          bool1 = true;
        }
        this.canDragY = bool1;
        Log.d("download", "calculateBoundaries imageWidth " + this.imageWidth + " displayWidth " + this.displayWidth);
        Log.d("download", "calculateBoundaries imageHeight " + this.imageHeight + " displayHeight " + this.displayHeight);
        if (this.canDragX)
        {
          if (!this.image.isImageSmall()) {
            break label667;
          }
          if (i <= this.displayWidth) {
            break label654;
          }
          f = (i - this.displayWidth) / 2.0F;
          label242:
          Log.d("download", "haha imagewidth " + this.imageWidth + " lastscale " + this.lastScale + " effectiveWidth " + i + " centerx " + this.centerX + " diff " + (i - this.imageWidth * this.lastScale) / 2.0F);
          label331:
          this.boundaryLeft = (this.centerX - f);
          this.boundaryRight = (f + this.centerX);
          Log.d("download", "calculateBoundaries boundaryLeft " + this.boundaryLeft + " boundaryRight " + this.boundaryRight + ", currentScale:" + this.currentScale);
        }
        if (this.canDragY)
        {
          if (!this.image.isImageSmall()) {
            break label693;
          }
          if (j <= this.displayHeight) {
            break label680;
          }
          f = (j - this.displayHeight) / 2.0F;
          label438:
          Log.d("download", "haha imageheight " + this.imageHeight + " lastscale " + this.lastScale + " effectiveHeight " + j + " centerx " + this.centerX + " diff " + (j - this.imageHeight * this.lastScale) / 2.0F);
        }
      }
    }
    for (;;)
    {
      this.boundaryTop = (this.centerY - f);
      this.boundaryBottom = (f + this.centerY);
      Log.d("download", "calculateBoundaries boundaryTop " + this.boundaryTop + " boundaryBottom " + this.boundaryBottom);
      if (this.image.getMoveable())
      {
        this.canDragX = true;
        this.canDragY = true;
      }
      return;
      bool1 = false;
      break;
      if (i > this.displayWidth)
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      label636:
      bool1 = bool2;
      if (j <= this.displayHeight) {
        break label117;
      }
      bool1 = true;
      break label117;
      label654:
      f = (i - this.lastEffectiveWidth) / 2.0F;
      break label242;
      label667:
      f = (i - this.displayWidth) / 2.0F;
      break label331;
      label680:
      f = (j - this.lastEffectiveHeight) / 2.0F;
      break label438;
      label693:
      f = (j - this.displayHeight) / 2.0F;
    }
  }
  
  public float getMaxScale()
  {
    return this.maxScale;
  }
  
  public float getMinScale()
  {
    return this.minScale;
  }
  
  protected boolean handleDrag(float paramFloat1, float paramFloat2)
  {
    this.current.x = paramFloat1;
    this.current.y = paramFloat2;
    paramFloat1 = this.current.x - this.last.x;
    paramFloat2 = this.current.y - this.last.y;
    if ((paramFloat1 != 0.0F) || (paramFloat2 != 0.0F))
    {
      PointF localPointF;
      if (this.canDragX)
      {
        localPointF = this.next;
        localPointF.x = (paramFloat1 + localPointF.x);
      }
      if (this.canDragY)
      {
        localPointF = this.next;
        localPointF.y = (paramFloat2 + localPointF.y);
      }
      boundCoordinates();
      this.last.x = this.current.x;
      this.last.y = this.current.y;
      if ((this.canDragX) || (this.canDragY))
      {
        this.image.setPosition(this.next.x, this.next.y);
        if (this.imageListener != null) {
          this.imageListener.onPosition(this.next.x, this.next.y);
        }
        return true;
      }
    }
    return false;
  }
  
  protected void handleScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.currentScale = paramFloat1;
    if (this.currentScale > this.maxScale) {
      this.currentScale = this.maxScale;
    }
    for (;;)
    {
      calculateBoundaries();
      this.image.setScale(this.currentScale);
      this.image.setPosition(this.next.x, this.next.y);
      if (this.imageListener != null)
      {
        this.imageListener.onScale(this.currentScale, this.boundaryLeft, this.boundaryRight);
        this.imageListener.onPosition(this.next.x, this.next.y);
      }
      this.image.redraw();
      return;
      if (this.currentScale < this.minScale)
      {
        this.currentScale = this.minScale;
      }
      else
      {
        this.next.x = paramFloat2;
        this.next.y = paramFloat3;
      }
    }
  }
  
  protected void handleUp()
  {
    this.multiTouch = false;
    this.initialDistance = 0.0F;
    this.lastScale = this.currentScale;
    if (!this.canDragX) {
      this.next.x = this.centerX;
    }
    if (!this.canDragY) {
      this.next.y = this.centerY;
    }
    boundCoordinates();
    if ((!this.canDragX) && (!this.canDragY))
    {
      if (!this.image.isLandscape()) {
        break label233;
      }
      this.currentScale = this.fitScaleHorizontal;
    }
    for (this.lastScale = this.fitScaleHorizontal;; this.lastScale = this.fitScaleVertical)
    {
      this.image.setScale(this.currentScale);
      this.moveAnimation.reset();
      this.moveAnimation.setAnimationTimeMS(200L);
      this.moveAnimation.setTargetX(this.next.x);
      this.moveAnimation.setTargetY(this.next.y);
      this.image.animationStart(this.moveAnimation);
      if (this.imageListener != null)
      {
        Log.d("download", "handleUp onscale");
        this.imageListener.onScale(this.currentScale, this.boundaryLeft, this.boundaryRight);
        this.imageListener.onPosition(this.next.x, this.next.y);
      }
      this.image.redraw();
      return;
      label233:
      this.currentScale = this.fitScaleVertical;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1;
    if ((!this.inZoom) && (!this.tapDetector.onTouchEvent(paramMotionEvent)))
    {
      if ((paramMotionEvent.getPointerCount() != 1) || (!this.flingDetector.onTouchEvent(paramMotionEvent))) {
        break label1571;
      }
      if (this.image.isSmall)
      {
        if (this.image.isImageSmall() != true) {
          break label243;
        }
        f1 = this.image.getScaledHeight() * this.image.getFactorHeight() / this.image.startingScale;
        if (f1 <= this.displayHeight) {
          break label263;
        }
        this.canDragY = true;
        label98:
        if (this.image.isImageSmall() != true) {
          break label316;
        }
        f1 = this.image.getScaledWidth() * this.image.getFactorWidth() / this.image.startingScale;
        label134:
        if (f1 <= this.displayWidth) {
          break label336;
        }
        this.canDragX = true;
      }
      label149:
      startFling();
    }
    label263:
    label1425:
    label1569:
    label1571:
    for (int i = 1;; i = 0)
    {
      if (paramMotionEvent.getAction() == 1)
      {
        Log.d("download", "imageview-> action up  curscale " + this.currentScale + " lastscale " + this.lastScale + " fithor " + this.fitScaleHorizontal + " fitver " + this.fitScaleVertical);
        if (i == 0) {
          handleUp();
        }
      }
      for (;;)
      {
        return true;
        label243:
        f1 = this.image.getScaledHeight() / this.image.startingScale;
        break;
        Log.d("download", "image is small ScaledHeight " + this.image.getScaledHeight() + " displayHeight " + this.displayHeight);
        this.canDragY = false;
        break label98;
        label316:
        f1 = this.image.getScaledWidth() / this.image.startingScale;
        break label134;
        label336:
        Log.d("download", "image is small ScaledHeight " + this.image.getScaledHeight() + " displayWidth " + this.displayWidth);
        this.canDragX = false;
        break label149;
        if (paramMotionEvent.getAction() == 0)
        {
          stopAnimations();
          this.last.x = paramMotionEvent.getX();
          this.last.y = paramMotionEvent.getY();
          if (this.imageListener != null) {
            this.imageListener.onTouch(this.last.x, this.last.y);
          }
          this.touched = true;
          Log.d("download", "imageview-> action down  curscale " + this.currentScale + " lastscale " + this.lastScale + " fithor " + this.fitScaleHorizontal + " fitver " + this.fitScaleVertical);
          return true;
        }
        if (paramMotionEvent.getAction() == 2)
        {
          if (paramMotionEvent.getPointerCount() > 1)
          {
            this.multiTouch = true;
            if (this.initialDistance > 0.0F)
            {
              this.pinchVector.set(paramMotionEvent);
              this.pinchVector.calculateLength();
              f1 = this.pinchVector.length;
              if (this.initialDistance != f1)
              {
                float f2 = f1 / this.initialDistance * this.lastScale;
                if (f2 <= this.maxScale)
                {
                  paramView = this.scaleVector;
                  paramView.length *= f2;
                  this.scaleVector.calculateEndPoint();
                  paramView = this.scaleVector;
                  paramView.length /= f2;
                  float f3 = this.scaleVector.end.x;
                  float f4 = this.scaleVector.end.y;
                  Log.d("download", "action move initialDistance " + this.initialDistance + " distance " + f1 + " newscal " + f2 + " newx " + f3 + " newy " + f4);
                  handleScale(f2, f3, f4);
                }
              }
              Log.d("download", "imageview-> action move mult if curscale " + this.currentScale + " lastscale " + this.lastScale + " fithor " + this.fitScaleHorizontal + " fitver " + this.fitScaleVertical + " initialDistance " + this.initialDistance + " distance " + f1);
              return true;
            }
            this.initialDistance = MathUtils.distance(paramMotionEvent);
            MathUtils.midpoint(paramMotionEvent, this.midpoint);
            this.scaleVector.setStart(this.midpoint);
            this.scaleVector.setEnd(this.next);
            this.scaleVector.calculateLength();
            this.scaleVector.calculateAngle();
            paramView = this.scaleVector;
            paramView.length /= this.lastScale;
            Log.d("download", "imageview-> action move mult else  curscale " + this.currentScale + " lastscale " + this.lastScale + " fithor " + this.fitScaleHorizontal + " fitver " + this.fitScaleVertical + " initialDistance " + this.initialDistance + " startx " + this.midpoint.x + " starty " + this.midpoint.y + " endx " + this.next.x + " endy " + this.next.y);
            return true;
          }
          if (!this.touched)
          {
            this.touched = true;
            this.last.x = paramMotionEvent.getX();
            this.last.y = paramMotionEvent.getY();
            this.next.x = this.image.getImageX();
            this.next.y = this.image.getImageY();
            Log.d("download", "!touch last.x " + this.last.x + " last.y " + this.last.y + " next.x " + this.next.x + " next.y " + this.next.y);
            return true;
          }
          if (!this.multiTouch)
          {
            if (this.image.isSmall)
            {
              if (this.image.isImageSmall() != true) {
                break label1425;
              }
              f1 = this.image.getScaledHeight() * this.image.getFactorHeight() / this.image.startingScale;
              if (f1 <= this.displayHeight) {
                break label1445;
              }
              this.canDragY = true;
              if (this.image.isImageSmall() != true) {
                break label1498;
              }
              f1 = this.image.getScaledWidth() * this.image.getFactorWidth() / this.image.startingScale;
              label1318:
              if (f1 <= this.displayWidth) {
                break label1518;
              }
            }
            for (this.canDragX = true;; this.canDragX = false)
            {
              if (!handleDrag(paramMotionEvent.getX(), paramMotionEvent.getY())) {
                break label1569;
              }
              this.image.redraw();
              Log.d("download", "imageview-> action move one  curscale " + this.currentScale + " lastscale " + this.lastScale + " fithor " + this.fitScaleHorizontal + " fitver " + this.fitScaleVertical);
              return true;
              f1 = this.image.getScaledHeight() / this.image.startingScale;
              break;
              label1445:
              Log.d("download", "issmall nomult ScaledHeight " + this.image.getScaledHeight() + " displayheight " + this.displayHeight);
              this.canDragY = false;
              break label1282;
              label1498:
              f1 = this.image.getScaledWidth() / this.image.startingScale;
              break label1318;
              label1518:
              Log.d("download", "issmall nomult ScaledWidth " + this.image.getScaledWidth() + " displaywidth " + this.displayWidth);
            }
          }
        }
      }
    }
  }
  
  public void reset()
  {
    this.currentScale = this.startingScale;
    this.next.x = this.centerX;
    this.next.y = this.centerY;
    calculateBoundaries();
    this.image.setScale(this.currentScale);
    this.image.setPosition(this.next.x, this.next.y);
    this.image.redraw();
  }
  
  protected void setCanvasHeight(int paramInt)
  {
    this.canvasHeight = paramInt;
  }
  
  protected void setCanvasWidth(int paramInt)
  {
    this.canvasWidth = paramInt;
  }
  
  protected void setFitScaleHorizontal(float paramFloat)
  {
    this.fitScaleHorizontal = paramFloat;
  }
  
  protected void setFitScaleVertical(float paramFloat)
  {
    this.fitScaleVertical = paramFloat;
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.maxScale = paramFloat;
  }
  
  public void setMinScale(float paramFloat)
  {
    this.minScale = paramFloat;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.onClickListener = paramOnClickListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.onLongClickListener = paramOnLongClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.imageview.GestureImageViewTouchListener
 * JD-Core Version:    0.7.0.1
 */