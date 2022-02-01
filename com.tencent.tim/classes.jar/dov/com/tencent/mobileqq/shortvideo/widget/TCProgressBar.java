package dov.com.tencent.mobileqq.shortvideo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import azbx;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TCProgressBar
  extends View
{
  ArrayList<e> AH = new ArrayList(10);
  ArrayList<e> AI = new ArrayList(10);
  long JD;
  a jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$a = new a();
  public b a;
  c jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c = new c();
  e jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$e = new e(true);
  TouchDelegate c = new TouchDelegate(this.cH, this);
  Rect cH = new Rect(0, 0, 0, 0);
  boolean cIe;
  boolean cIf = false;
  public int currentStatus = 3;
  public int dJB;
  int dJC = 0;
  int dJD = 1310991405;
  int dJE = -14408659;
  int dJF = -16737062;
  int dJG = -65536;
  int dJH = -15000805;
  int dJI = azbx.dip2px(1.0F);
  int dJJ = -1;
  int dJK = azbx.dip2px(5.0F);
  public int dJx;
  public Bitmap gm;
  public Bitmap gn;
  Handler mHandler = new Handler();
  Paint mPaint = new Paint();
  public int mProgress;
  int mStep = 1000;
  Rect rect = new Rect();
  int totaltime = 0;
  float zQ;
  
  public TCProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    try
    {
      this.gm = BitmapFactory.decodeResource(paramContext.getResources(), 2130846915);
      this.gn = BitmapFactory.decodeResource(paramContext.getResources(), 2130846914);
      this.dJB = this.gm.getWidth();
      this.mHandler.postDelayed(new TimerRefresh(), this.mStep);
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        this.dJB = 100;
      }
    }
  }
  
  int aM(int paramInt1, int paramInt2)
  {
    if (paramInt1 == this.dJx) {
      return paramInt2;
    }
    paramInt2 = paramInt2 * paramInt1 / this.dJx;
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 1;
    }
    return paramInt1;
  }
  
  void layout()
  {
    int i2 = super.getWidth();
    int i1 = this.dJB - 3;
    int m = i2 - i1;
    int n = this.AH.size();
    int i = 0;
    while (i < n - 1)
    {
      locale = (e)this.AH.get(i);
      if (locale.changed)
      {
        locale.dJP = aM(locale.dJS - locale.dJR, m);
        locale.length = aM(locale.dJR, m);
        locale.cIk = false;
      }
      i += 1;
    }
    int i3 = this.AI.size();
    i = 0;
    while (i < i3)
    {
      locale = (e)this.AI.get(i);
      if (locale.changed)
      {
        locale.dJP = aM(locale.dJS - locale.dJR, m);
        locale.length = aM(locale.dJR, m);
        locale.cIk = false;
      }
      i += 1;
    }
    if (n > 0)
    {
      locale = (e)this.AH.get(n - 1);
      locale.cIj = true;
      locale.cIk = false;
      if (!locale.cIm)
      {
        locale.dJS = this.mProgress;
        locale.dJR = (this.mProgress - this.totaltime);
      }
      if (locale.changed)
      {
        locale.dJP = aM(locale.dJS - locale.dJR, m);
        locale.length = aM(locale.dJR, m);
      }
    }
    int j;
    int i4;
    int k;
    if (n <= 0)
    {
      j = m;
      i = 0;
      if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$a.enabled) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$a.changed))
      {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$a.dJP = i;
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$a.length = this.dJK;
      }
      i4 = this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.Ka();
      k = n;
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.enabled)
      {
        k = n;
        if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.changed)
        {
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.length = this.dJB;
          if (!this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.cIi) {
            break label883;
          }
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.dJP = (i - 3);
        }
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.dJP < 0) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.cIi)) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.dJP = 0;
      }
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.dJP + this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.length + 1 >= i2) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.dJP = (i2 - this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.length);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TCProgressBar", 2, "layout:delete.requestLayout" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.cIi);
      }
      k = n;
      if (!this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.cIi)
      {
        n = this.AH.size();
        if (n > 0)
        {
          locale = (e)this.AH.get(n - 1);
          locale.cIj = false;
          if (locale.lD(i4))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TCProgressBar", 2, "layout:progress.checkBounds=true");
            }
            locale.dJQ = (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.dJP + 3);
            locale.cIk = true;
          }
        }
        k = n;
        if (i3 > 0)
        {
          locale = (e)this.AI.get(i3 - 1);
          k = n;
          if (locale.lD(i4))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TCProgressBar", 2, "layout:deletedList.checkBounds=true");
            }
            locale.dJQ = (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.dJP + 3);
            locale.cIk = true;
            k = n;
          }
        }
      }
      if (k > 0)
      {
        locale = (e)this.AH.get(k - 1);
        if (locale.isOver) {
          locale.length = (m - locale.dJP);
        }
      }
      if (i3 > 0)
      {
        locale = (e)this.AI.get(0);
        if (locale.isOver) {
          locale.length = (i2 - locale.dJP);
        }
        i = locale.dJP + locale.length;
        j = m - i;
      }
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$e.changed)
      {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$e.dJP = i;
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$e.length = j;
        if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$e.length > 1) {
          break label923;
        }
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$e.enabled = false;
      }
      return;
      locale = (e)this.AH.get(n - 1);
      j = locale.dJP + locale.length;
      i = j;
      j = m - j;
      break;
      label883:
      if ((i3 == 0) && (i4 > i))
      {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.dJP = (i - 3);
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.cIg = true;
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.cIi = true;
      }
    }
    label923:
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$e.enabled = true;
    e locale = this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$e;
    locale.length += i1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 0;
    super.onDraw(paramCanvas);
    if (super.isInEditMode()) {}
    do
    {
      return;
      int i = super.getWidth();
      int k = super.getHeight();
      int m = k / 7;
      int n = m * 3;
      layout();
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.height = k;
      this.rect.left = 0;
      this.rect.right = i;
      this.rect.top = 0;
      this.rect.bottom = n;
      this.mPaint.setColor(0);
      paramCanvas.drawRect(this.rect, this.mPaint);
      this.rect.top = (n + m);
      this.rect.bottom = k;
      this.mPaint.setColor(0);
      paramCanvas.drawRect(this.rect, this.mPaint);
      this.rect.top = n;
      this.rect.bottom = (n + m);
      k = this.AH.size();
      i = 0;
      e locale;
      while (i < k)
      {
        locale = (e)this.AH.get(i);
        if ((locale.changed) && (locale.enabled)) {
          locale.draw(paramCanvas);
        }
        i += 1;
      }
      k = this.AI.size();
      i = j;
      while (i < k)
      {
        locale = (e)this.AI.get(i);
        if ((locale.changed) && (locale.enabled)) {
          locale.draw(paramCanvas);
        }
        i += 1;
      }
      if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$e.changed) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$e.enabled)) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$e.draw(paramCanvas);
      }
      if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$a.changed) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$a.enabled)) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$a.draw(paramCanvas);
      }
    } while ((!this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.changed) || (!this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.enabled));
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.draw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 != this.cH.left) || (paramInt2 != this.cH.top + 25) || (paramInt3 != this.cH.right) || (paramInt4 != this.cH.bottom - 25))
    {
      this.cH.left = paramInt1;
      this.cH.right = paramInt3;
      this.cH.top = (paramInt2 - 25);
      this.cH.bottom = (paramInt4 + 25);
      ((View)getParent()).setTouchDelegate(this.c);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!super.isEnabled()) {
      return false;
    }
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction();
    float f = paramMotionEvent.getX();
    switch (j)
    {
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_DOWN count=" + i + " X=" + f);
      }
      this.JD = SystemClock.elapsedRealtime();
      this.zQ = paramMotionEvent.getX();
      this.dJC = this.AH.size();
      this.cIf = false;
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.l(f))
      {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.n(paramMotionEvent);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_MOVE count=" + i + " X=" + f);
        }
        if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.cIh)
        {
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.n(paramMotionEvent);
          if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.aym())
          {
            j = this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.Ka();
            if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.dJN < 0)
            {
              i = this.AH.size() - 1;
              while (i >= 0)
              {
                paramMotionEvent = (e)this.AH.get(i);
                if (!paramMotionEvent.lE(j)) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("TCProgressBar", 2, "onTouchEvent:checkDelBounds=true");
                }
                this.AH.remove(i);
                paramMotionEvent.deleted = true;
                this.AI.add(paramMotionEvent);
                i -= 1;
              }
            }
            i = this.AI.size() - 1;
            while (i >= 0)
            {
              paramMotionEvent = (e)this.AI.get(i);
              if (!paramMotionEvent.lF(j)) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("TCProgressBar", 2, "onTouchEvent:checkRecorverBounds=true");
              }
              this.AI.remove(i);
              paramMotionEvent.deleted = false;
              this.AH.add(paramMotionEvent);
              i -= 1;
            }
            invalidate();
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_UP count=" + i + " X=" + f);
            }
            if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.cIh)
            {
              this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.n(paramMotionEvent);
              if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.l(f))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_UP[checkBounds:true] count=" + i + " X=" + f);
                }
                if ((SystemClock.elapsedRealtime() - this.JD < 400L) && (Math.abs(paramMotionEvent.getX() - this.zQ) < 25.0F))
                {
                  i = this.AH.size();
                  if (i > 0)
                  {
                    paramMotionEvent = (e)this.AH.remove(i - 1);
                    paramMotionEvent.deleted = true;
                    this.AI.add(paramMotionEvent);
                    if (QLog.isColorLevel()) {
                      QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_UP progress:[size]=" + this.AH.size() + " deletedList[size]=" + this.AI.size());
                    }
                  }
                }
              }
              if (this.AI.size() > 0) {}
              for (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.cIg = false;; this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.cIg = true)
              {
                invalidate();
                if (QLog.isColorLevel()) {
                  QLog.d("TCProgressBar", 2, "[@] [...]delete.enabled=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.enabled + "delete.changed=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.changed);
                }
                i = this.AH.size();
                if (this.dJC - i > 0) {
                  this.cIf = true;
                }
                if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$b == null) {
                  break;
                }
                this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$b.CK(this.cIf);
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_CANCEL count=" + i + " X=" + f);
              }
              if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.cIh)
              {
                this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.n(paramMotionEvent);
                invalidate();
                if (QLog.isColorLevel()) {
                  QLog.d("TCProgressBar", 2, "[@] [...]delete.enabled=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.enabled + "delete.changed=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$c.changed);
                }
                i = this.AH.size();
                if (this.dJC - i > 0) {
                  this.cIf = true;
                }
                if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$b != null) {
                  this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetTCProgressBar$b.CK(this.cIf);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void setMax(int paramInt1, int paramInt2)
  {
    this.dJx = paramInt2;
  }
  
  public void setProgress(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TCProgressBar", 2, "setProgress, progress = " + paramInt + ",isOver = " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.mProgress = this.dJx;
      this.cIe = true;
    }
    for (;;)
    {
      postInvalidate();
      return;
      this.cIe = false;
      this.mProgress = paramInt;
    }
  }
  
  class TimerRefresh
    implements Runnable
  {
    TimerRefresh() {}
    
    public void run()
    {
      TCProgressBar.a locala;
      if (TCProgressBar.this.currentStatus == 3)
      {
        TCProgressBar.this.mHandler.postDelayed(new TimerRefresh(TCProgressBar.this), TCProgressBar.this.mStep);
        locala = TCProgressBar.this.a;
        if (TCProgressBar.this.a.enabled) {
          break label77;
        }
      }
      label77:
      for (boolean bool = true;; bool = false)
      {
        locala.enabled = bool;
        TCProgressBar.this.invalidate();
        return;
      }
    }
  }
  
  class a
    extends TCProgressBar.d
  {
    a()
    {
      super();
    }
    
    void draw(Canvas paramCanvas)
    {
      TCProgressBar.this.rect.left = this.dJP;
      TCProgressBar.this.rect.right = (this.dJP + this.length);
      TCProgressBar.this.mPaint.setColor(TCProgressBar.this.dJJ);
      paramCanvas.drawRect(TCProgressBar.this.rect, TCProgressBar.this.mPaint);
      super.draw(paramCanvas);
    }
  }
  
  public static abstract interface b
  {
    public abstract void CK(boolean paramBoolean);
  }
  
  class c
    extends TCProgressBar.d
  {
    boolean cIg;
    boolean cIh = false;
    boolean cIi = true;
    int dJL = -1;
    int dJM = 0;
    int dJN;
    int dJO = 0;
    int height;
    float zR = 0.0F;
    
    c()
    {
      super();
    }
    
    int Ka()
    {
      return this.dJP + this.dJO;
    }
    
    boolean aym()
    {
      if (this.dJN < 0) {}
      for (int i = -this.dJN; i > 1; i = this.dJN) {
        return true;
      }
      return false;
    }
    
    void draw(Canvas paramCanvas)
    {
      TCProgressBar.this.rect.left = this.dJP;
      TCProgressBar.this.rect.right = (this.dJP + this.length);
      int i = TCProgressBar.this.rect.top;
      int j = TCProgressBar.this.rect.bottom;
      TCProgressBar.this.rect.top = 0;
      TCProgressBar.this.rect.bottom = this.height;
      if (this.cIg) {
        f(paramCanvas, TCProgressBar.this.gm);
      }
      for (;;)
      {
        TCProgressBar.this.rect.top = i;
        TCProgressBar.this.rect.bottom = j;
        super.draw(paramCanvas);
        return;
        f(paramCanvas, TCProgressBar.this.gn);
      }
    }
    
    void f(Canvas paramCanvas, Bitmap paramBitmap)
    {
      if (paramBitmap == null)
      {
        TCProgressBar.this.mPaint.setColor(-1);
        if (!this.cIg) {
          TCProgressBar.this.mPaint.setColor(-65536);
        }
        paramCanvas.drawRect(TCProgressBar.this.rect, TCProgressBar.this.mPaint);
        return;
      }
      TCProgressBar.this.mPaint.setFilterBitmap(true);
      paramCanvas.drawBitmap(paramBitmap, null, TCProgressBar.this.rect, TCProgressBar.this.mPaint);
      TCProgressBar.this.mPaint.setFilterBitmap(false);
    }
    
    boolean l(float paramFloat)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TCProgressBar", 2, "checkBounds,x = " + paramFloat + ",x_coord = " + this.dJP + ",x_coord + length = " + (this.dJP + this.length));
      }
      return (paramFloat > this.dJP - 25) && (paramFloat < this.dJP + this.length + 25);
    }
    
    boolean n(MotionEvent paramMotionEvent)
    {
      float f = paramMotionEvent.getX();
      int i = paramMotionEvent.getAction();
      switch (i)
      {
      default: 
      case 0: 
      case 2: 
        do
        {
          return true;
          this.cIh = true;
          this.dJL = i;
          this.zR = f;
          this.dJM = 0;
          this.cIg = false;
          return true;
          this.dJN = ((int)(f - this.zR));
          this.dJL = i;
          this.zR = f;
          this.dJM += 1;
          this.cIi = false;
        } while (!aym());
        this.dJP += this.dJN;
        return true;
      }
      this.cIh = false;
      this.zR = 0.0F;
      this.cIi = true;
      return true;
    }
  }
  
  class d
  {
    boolean cIj = false;
    boolean changed = true;
    int dJP;
    boolean enabled = true;
    int length;
    
    d() {}
    
    void draw(Canvas paramCanvas)
    {
      this.cIj = false;
    }
    
    boolean l(float paramFloat)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TCProgressBar", 2, "checkBounds,x = " + paramFloat + ",x_coord = " + this.dJP + ",x_coord + length = " + (this.dJP + this.length));
      }
      return (paramFloat > this.dJP) && (paramFloat < this.dJP + this.length);
    }
  }
  
  class e
    extends TCProgressBar.d
  {
    boolean cIk;
    boolean cIl;
    boolean cIm = false;
    int dJQ;
    int dJR;
    int dJS;
    boolean deleted;
    boolean isOver = false;
    
    e(boolean paramBoolean)
    {
      super();
      this.cIl = paramBoolean;
    }
    
    void draw(Canvas paramCanvas)
    {
      if (this.cIl)
      {
        TCProgressBar.this.rect.left = this.dJP;
        TCProgressBar.this.rect.right = (this.dJP + this.length);
        TCProgressBar.this.mPaint.setColor(TCProgressBar.this.dJD);
        paramCanvas.drawRect(TCProgressBar.this.rect, TCProgressBar.this.mPaint);
        TCProgressBar.this.mPaint.setColor(TCProgressBar.this.dJE);
        super.draw(paramCanvas);
        return;
      }
      int i;
      if (this.cIj) {
        i = this.length;
      }
      for (;;)
      {
        boolean bool = lD(this.dJQ - 5);
        if (QLog.isColorLevel()) {
          QLog.d("TCProgressBar", 2, "ProgressBlock:hasMorePart=" + this.cIk + " bounds=" + bool);
        }
        if ((!this.cIk) || (!bool)) {
          break label392;
        }
        TCProgressBar.this.rect.left = this.dJP;
        TCProgressBar.this.rect.right = this.dJQ;
        TCProgressBar.this.mPaint.setColor(TCProgressBar.this.dJF);
        paramCanvas.drawRect(TCProgressBar.this.rect, TCProgressBar.this.mPaint);
        TCProgressBar.this.rect.left = this.dJQ;
        TCProgressBar.this.rect.right = (i + this.dJP);
        TCProgressBar.this.mPaint.setColor(TCProgressBar.this.dJG);
        paramCanvas.drawRect(TCProgressBar.this.rect, TCProgressBar.this.mPaint);
        break;
        i = this.length - TCProgressBar.this.dJI;
        TCProgressBar.this.rect.left = (this.dJP + i);
        TCProgressBar.this.rect.right = (this.dJP + this.length);
        TCProgressBar.this.mPaint.setColor(TCProgressBar.this.dJH);
        paramCanvas.drawRect(TCProgressBar.this.rect, TCProgressBar.this.mPaint);
      }
      label392:
      TCProgressBar.this.rect.left = this.dJP;
      TCProgressBar.this.rect.right = (i + this.dJP);
      if (this.deleted) {
        TCProgressBar.this.mPaint.setColor(TCProgressBar.this.dJG);
      }
      for (;;)
      {
        paramCanvas.drawRect(TCProgressBar.this.rect, TCProgressBar.this.mPaint);
        break;
        TCProgressBar.this.mPaint.setColor(TCProgressBar.this.dJF);
      }
    }
    
    boolean lD(int paramInt)
    {
      return (paramInt > this.dJP) && (paramInt < this.dJP + this.length - TCProgressBar.this.dJI);
    }
    
    boolean lE(int paramInt)
    {
      return (paramInt < this.dJP) || (lD(paramInt));
    }
    
    boolean lF(int paramInt)
    {
      return (paramInt > this.dJP + this.length) || (lD(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.widget.TCProgressBar
 * JD-Core Version:    0.7.0.1
 */