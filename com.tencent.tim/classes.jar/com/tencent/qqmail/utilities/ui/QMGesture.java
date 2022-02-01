package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.Iterator;

public class QMGesture
  extends View
{
  public static int PSW_FAIL_TIME = 400;
  private String TAG = "QMGesture";
  private Bitmap bitmaproundChecked;
  private Bitmap bitmaproundCheckedFail;
  private Bitmap bitmaproundNormal;
  private ArrayList<Point> checkPointList = new ArrayList();
  private boolean isChecking;
  private boolean isFinishReset = true;
  private boolean isPswFail;
  private boolean isShowTrack = SharedPreferenceUtil.isGesturePasswordShowTrack();
  private Paint mPaint = new Paint(1);
  private int minHeight = 0;
  private float moveingX;
  private float moveingY;
  boolean movingNoPoint = false;
  private int passwordMinLength = 4;
  private Point point1;
  private Point point2;
  private Point point3;
  private Point point4;
  private Point point5;
  private Point point6;
  private Point point7;
  private Point point8;
  private Point point9;
  private ArrayList<Point> pointList = new ArrayList();
  private float radius;
  private OnRollingListener rollingListener;
  private String wrongPsw;
  
  public QMGesture(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  private boolean checkInRound(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return Math.sqrt((paramFloat1 - paramFloat4) * (paramFloat1 - paramFloat4) + (paramFloat2 - paramFloat5) * (paramFloat2 - paramFloat5)) < paramFloat3;
  }
  
  private int crossPoint(Point paramPoint)
  {
    if (this.checkPointList.contains(paramPoint))
    {
      if ((this.checkPointList.size() > 2) && (((Point)this.checkPointList.get(this.checkPointList.size() - 1)).getIndex() != paramPoint.getIndex())) {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  private void doDraw(Canvas paramCanvas, boolean paramBoolean)
  {
    int i = 1;
    Point localPoint;
    if (!paramBoolean)
    {
      localObject = this.pointList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localPoint = (Point)((Iterator)localObject).next();
        if ((localPoint.getState() == 1) && (this.isShowTrack)) {
          paramCanvas.drawBitmap(this.bitmaproundChecked, localPoint.getX() - this.radius, localPoint.getY() - this.radius, this.mPaint);
        } else {
          paramCanvas.drawBitmap(this.bitmaproundNormal, localPoint.getX() - this.radius, localPoint.getY() - this.radius, this.mPaint);
        }
      }
      if ((this.isShowTrack) && (this.checkPointList.size() > 0))
      {
        for (localObject = (Point)this.checkPointList.get(0); i < this.checkPointList.size(); localObject = localPoint)
        {
          localPoint = (Point)this.checkPointList.get(i);
          drawLine(paramCanvas, (Point)localObject, localPoint);
          i += 1;
        }
        if (this.movingNoPoint) {
          drawLine(paramCanvas, (Point)localObject, new Point((int)this.moveingX, (int)this.moveingY - getResources().getDimensionPixelOffset(2131299384) * 0, 0));
        }
      }
      return;
    }
    Object localObject = this.pointList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localPoint = (Point)((Iterator)localObject).next();
      if ((this.isShowTrack) && (this.wrongPsw.contains(localPoint.index + ""))) {
        paramCanvas.drawBitmap(this.bitmaproundCheckedFail, localPoint.getX() - this.radius, localPoint.getY() - this.radius, this.mPaint);
      } else {
        paramCanvas.drawBitmap(this.bitmaproundNormal, localPoint.getX() - this.radius, localPoint.getY() - this.radius, this.mPaint);
      }
    }
    if ((this.isShowTrack) && (this.wrongPsw.length() > 0))
    {
      int j = this.wrongPsw.length();
      i = 0;
      while (i < j - 1)
      {
        drawLine(paramCanvas, (Point)this.pointList.get(Integer.parseInt(String.valueOf(this.wrongPsw.charAt(i))) - 1), (Point)this.pointList.get(Integer.parseInt(String.valueOf(this.wrongPsw.charAt(i + 1))) - 1));
        i += 1;
      }
    }
    Threads.runOnMainThread(new QMGesture.1(this), PSW_FAIL_TIME);
  }
  
  private void drawLine(Canvas paramCanvas, Point paramPoint1, Point paramPoint2)
  {
    int i = this.mPaint.getColor();
    float f = this.mPaint.getStrokeWidth();
    if (this.isPswFail) {
      this.mPaint.setColor(getResources().getColor(2131167258));
    }
    for (;;)
    {
      this.mPaint.setStrokeWidth(getResources().getDimensionPixelSize(2131299384));
      paramCanvas.drawLine(paramPoint1.getX(), paramPoint1.getY(), paramPoint2.getX(), paramPoint2.getY(), this.mPaint);
      this.mPaint.setColor(i);
      this.mPaint.setStrokeWidth(f);
      return;
      this.mPaint.setColor(getResources().getColor(2131167257));
    }
  }
  
  private void initView()
  {
    this.bitmaproundChecked = BitmapFactory.decodeResource(getResources(), 2130840607);
    this.bitmaproundNormal = BitmapFactory.decodeResource(getResources(), 2130840606);
    this.bitmaproundCheckedFail = BitmapFactory.decodeResource(getResources(), 2130840608);
    this.radius = (getResources().getDimensionPixelSize(2131299383) / 2);
    int k = getResources().getDimensionPixelSize(2131299382);
    int i = Math.min(QMUIKit.getScreenWidth(), QMUIKit.getScreenHeight());
    int j = i;
    if (i <= 0) {
      j = (int)(this.radius * 10.0F);
    }
    i = k;
    if (this.radius * 6.0F + k * 2 > j) {
      if (this.radius * 6.0F >= j) {
        break label707;
      }
    }
    label707:
    for (i = (int)(j - this.radius * 6.0F) / 4;; i = 0)
    {
      k = i / 2;
      float f1 = (j - (i * 2 + this.radius * 6.0F)) / 2.0F;
      j = QMUIKit.dpToPx(5);
      float f2 = this.radius;
      this.minHeight = ((int)(i * 2 + f2 * 6.0F + j * 2));
      this.point1 = new Point(this.radius + f1, j + this.radius, 1);
      this.point2 = new Point(this.radius * 3.0F + f1 + k * 2, j + this.radius, 2);
      this.point3 = new Point(this.radius * 5.0F + f1 + k * 4, j + this.radius, 3);
      this.point4 = new Point(this.radius + f1, j + this.radius * 3.0F + k * 2, 4);
      this.point5 = new Point(this.radius * 3.0F + f1 + k * 2, j + this.radius * 3.0F + k * 2, 5);
      this.point6 = new Point(this.radius * 5.0F + f1 + k * 4, j + this.radius * 3.0F + k * 2, 6);
      this.point7 = new Point(this.radius + f1, j + this.radius * 5.0F + k * 4, 7);
      this.point8 = new Point(this.radius * 3.0F + f1 + k * 2, j + this.radius * 5.0F + k * 4, 8);
      f2 = this.radius;
      float f3 = k * 4;
      float f4 = j;
      float f5 = this.radius;
      this.point9 = new Point(f1 + f2 * 5.0F + f3, k * 4 + (f4 + f5 * 5.0F), 9);
      this.pointList.add(this.point1);
      this.pointList.add(this.point2);
      this.pointList.add(this.point3);
      this.pointList.add(this.point4);
      this.pointList.add(this.point5);
      this.pointList.add(this.point6);
      this.pointList.add(this.point7);
      this.pointList.add(this.point8);
      this.pointList.add(this.point9);
      return;
    }
  }
  
  private Point isCheckPoint(float paramFloat1, float paramFloat2)
  {
    Iterator localIterator = this.pointList.iterator();
    while (localIterator.hasNext())
    {
      Point localPoint = (Point)localIterator.next();
      if (checkInRound(localPoint.getX(), localPoint.getY(), this.radius, (int)paramFloat1, (int)paramFloat2)) {
        return localPoint;
      }
    }
    return null;
  }
  
  private void reset()
  {
    Iterator localIterator = this.pointList.iterator();
    while (localIterator.hasNext()) {
      ((Point)localIterator.next()).setState(0);
    }
    this.checkPointList.clear();
  }
  
  public int getCheckPointSize()
  {
    return this.checkPointList.size();
  }
  
  public String getPasswd()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.checkPointList != null)
    {
      Iterator localIterator = this.checkPointList.iterator();
      while (localIterator.hasNext())
      {
        Point localPoint = (Point)localIterator.next();
        localStringBuilder.append(localPoint.getIndex() + "");
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public int getPasswordMinLength()
  {
    return this.passwordMinLength;
  }
  
  public int getViewHeight()
  {
    return this.minHeight;
  }
  
  public boolean isFinishReset()
  {
    return this.isFinishReset;
  }
  
  public boolean isPswFail()
  {
    return this.isPswFail;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    QMUIHelper.recycleBitmap(this.bitmaproundNormal);
    QMUIHelper.recycleBitmap(this.bitmaproundChecked);
    QMUIHelper.recycleBitmap(this.bitmaproundCheckedFail);
    this.bitmaproundNormal = null;
    this.bitmaproundChecked = null;
    this.bitmaproundCheckedFail = null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    doDraw(paramCanvas, this.isPswFail);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return false;
    }
    this.movingNoPoint = false;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int j;
    int i;
    switch (paramMotionEvent.getAction())
    {
    default: 
      paramMotionEvent = null;
      j = 0;
      i = 0;
    }
    for (;;)
    {
      label68:
      int k;
      if ((j == 0) && (this.isChecking) && (paramMotionEvent != null))
      {
        k = crossPoint(paramMotionEvent);
        if (k == 2)
        {
          this.movingNoPoint = true;
          this.moveingX = f1;
          this.moveingY = f2;
        }
      }
      else
      {
        label112:
        k = i;
        if (j != 0)
        {
          if (this.checkPointList.size() != 1) {
            break label367;
          }
          reset();
          k = 1;
        }
      }
      for (;;)
      {
        if (isFinishReset())
        {
          reset();
          k = 1;
        }
        if (k != 0) {
          this.rollingListener.onReset();
        }
        postInvalidate();
        return true;
        paramMotionEvent = isCheckPoint(f1, f2);
        if (paramMotionEvent != null)
        {
          this.isChecking = true;
          this.rollingListener.onBegin();
          this.rollingListener.onItemCheck(paramMotionEvent.getIndex(), getPasswd());
          j = 0;
          i = 0;
          break label68;
        }
        reset();
        j = 0;
        i = 1;
        break label68;
        if (!this.isChecking) {
          break;
        }
        paramMotionEvent = isCheckPoint(f1, f2);
        if (paramMotionEvent != null) {
          break label462;
        }
        this.movingNoPoint = true;
        this.moveingX = f1;
        this.moveingY = f2;
        j = 0;
        i = 0;
        break label68;
        paramMotionEvent = isCheckPoint(f1, f2);
        this.isChecking = false;
        j = 1;
        i = 0;
        break label68;
        if (k != 0) {
          break label112;
        }
        paramMotionEvent.setState(1);
        this.checkPointList.add(paramMotionEvent);
        this.rollingListener.onItemCheck(paramMotionEvent.getIndex(), getPasswd());
        QMLog.log(2, this.TAG, "onTouchEvent. new point:" + paramMotionEvent);
        break label112;
        label367:
        if ((this.checkPointList.size() < this.passwordMinLength) && (this.checkPointList.size() > 0))
        {
          this.rollingListener.onFinish(getPasswd(), true);
          k = i;
        }
        else
        {
          k = i;
          if (this.rollingListener != null)
          {
            k = i;
            if (this.checkPointList.size() >= this.passwordMinLength)
            {
              this.rollingListener.onFinish(getPasswd(), false);
              k = i;
            }
          }
        }
      }
      label462:
      j = 0;
      i = 0;
    }
  }
  
  public void setFinishReset(boolean paramBoolean)
  {
    this.isFinishReset = paramBoolean;
  }
  
  public void setOnRollingListener(OnRollingListener paramOnRollingListener)
  {
    this.rollingListener = paramOnRollingListener;
  }
  
  public void setPasswordMinLength(int paramInt)
  {
    this.passwordMinLength = paramInt;
  }
  
  public void setPswFail(boolean paramBoolean, String paramString)
  {
    this.isPswFail = paramBoolean;
    this.wrongPsw = paramString;
  }
  
  public static abstract interface OnRollingListener
  {
    public abstract void onBegin();
    
    public abstract void onFinish(String paramString, boolean paramBoolean);
    
    public abstract void onItemCheck(int paramInt, String paramString);
    
    public abstract void onReset();
  }
  
  class Point
  {
    public static final int CHECKED = 1;
    public static final int NORMAL = 0;
    private int index;
    private int state = 0;
    private float x;
    private float y;
    
    public Point(float paramFloat1, float paramFloat2, int paramInt)
    {
      this.x = paramFloat1;
      this.y = paramFloat2;
      this.index = paramInt;
    }
    
    public int getIndex()
    {
      return this.index;
    }
    
    public int getState()
    {
      return this.state;
    }
    
    public float getX()
    {
      return this.x;
    }
    
    public float getY()
    {
      return this.y;
    }
    
    public void setState(int paramInt)
    {
      this.state = paramInt;
    }
    
    public void setXYI(float paramFloat1, float paramFloat2, int paramInt)
    {
      this.x = paramFloat1;
      this.y = paramFloat2;
      this.index = paramInt;
    }
    
    public String toString()
    {
      return "Point [x=" + this.x + ", y=" + this.y + ", index=" + this.index + ", state=" + this.state + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMGesture
 * JD-Core Version:    0.7.0.1
 */