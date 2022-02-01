import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Property;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class aysn
  extends Drawable
  implements Animatable
{
  private float GA = this.Gz;
  private float Gs = 68.0F;
  private float Gt = 68.0F;
  private float Gu = 30.0F;
  private float Gv = 70.0F;
  private float Gw = 60.0F;
  private float Gx = 50.0F;
  private float Gy = 35.0F;
  private float Gz = 5.0F;
  private List<Integer> NE = new ArrayList();
  private RectF bW = new RectF();
  private String cXR;
  private ValueAnimator d;
  private boolean dAA;
  private Drawable hj;
  private Drawable hk;
  Property<aysn, Integer> k = new ayso(this, Integer.class, "bfIndex");
  Property<aysn, Integer> l = new aysp(this, Integer.class, "textAlpha");
  Property<aysn, Float> m = new aysq(this, Float.class, "textPos");
  private int mIndex;
  private WeakReference<aysn.a> mListenerRef;
  private int mState = 1;
  private int mTextAlpha = 255;
  private Paint mTextPaint = new Paint();
  private Map<String, Drawable> qW = new HashMap();
  private Map<String, Drawable> qX = new HashMap();
  private AnimationDrawable v;
  private AnimationDrawable w;
  private AnimationDrawable x;
  
  private int Sg()
  {
    return this.mTextAlpha;
  }
  
  private AnimationDrawable a(Context paramContext, int paramInt)
  {
    paramContext = (AnimationDrawable)paramContext.getResources().getDrawable(paramInt);
    paramContext.setVisible(true, false);
    paramContext.setOneShot(true);
    return paramContext;
  }
  
  private void afA(int paramInt)
  {
    if (this.mListenerRef == null) {}
    aysn.a locala;
    do
    {
      return;
      locala = (aysn.a)this.mListenerRef.get();
    } while (locala == null);
    locala.afF(paramInt);
  }
  
  private void afB(int paramInt)
  {
    if (this.mListenerRef == null) {}
    aysn.a locala;
    do
    {
      return;
      locala = (aysn.a)this.mListenerRef.get();
    } while (locala == null);
    locala.afH(paramInt);
  }
  
  private void afz(int paramInt)
  {
    if (this.mListenerRef == null) {}
    aysn.a locala;
    do
    {
      return;
      locala = (aysn.a)this.mListenerRef.get();
    } while (locala == null);
    locala.afG(paramInt);
  }
  
  private void bI(float paramFloat)
  {
    this.GA = paramFloat;
  }
  
  private void bJ(float paramFloat)
  {
    i(getBounds().width() - paramFloat, this.bW.centerY(), this.bW.width(), this.bW.height());
  }
  
  private void cl(Canvas paramCanvas)
  {
    int i = 0;
    if (this.mState == 1) {}
    do
    {
      Drawable localDrawable;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.mState != 2) {
                break;
              }
            } while (this.x == null);
            i = this.x.getNumberOfFrames();
            if (this.mIndex >= i) {
              this.mIndex = (i - 1);
            }
            localDrawable = this.x.getFrame(this.mIndex);
          } while (localDrawable == null);
          localDrawable.draw(paramCanvas);
          return;
          if (this.mState != 3) {
            break;
          }
          localDrawable = this.x.getFrame(this.x.getNumberOfFrames() - 1);
        } while (localDrawable == null);
        localDrawable.draw(paramCanvas);
        return;
        if (this.mState != 4) {
          break;
        }
        if (this.v != null) {
          i = this.v.getNumberOfFrames();
        }
        if (this.mIndex >= i) {
          this.mIndex = (i - 1);
        }
        localDrawable = this.v.getFrame(this.mIndex);
        if (localDrawable != null) {
          localDrawable.draw(paramCanvas);
        }
        localDrawable = this.w.getFrame(this.mIndex);
      } while (localDrawable == null);
      localDrawable.draw(paramCanvas);
      return;
    } while (this.mState != 5);
  }
  
  private float cm()
  {
    return this.GA;
  }
  
  private void cm(Canvas paramCanvas)
  {
    if (this.hj == null) {}
    while (this.mState == 1) {
      return;
    }
    Rect localRect = new Rect((int)this.bW.left, (int)this.bW.top, (int)this.bW.right, (int)this.bW.bottom);
    this.hj.setBounds(localRect);
    this.hj.setAlpha(this.mTextAlpha);
    this.hj.draw(paramCanvas);
  }
  
  private void cn(Canvas paramCanvas)
  {
    if (TextUtils.isEmpty(this.cXR)) {}
    while ((this.hk == null) || (this.mState == 2) || (this.mState == 4) || (this.mState == 3)) {
      return;
    }
    Rect localRect = getBounds();
    int i = (int)(localRect.right - this.Gv - this.Gw);
    int j = (int)(localRect.centerY() - this.Gx / 2.0F);
    localRect = new Rect(i, j, (int)(i + this.Gw), (int)(j + this.Gx));
    if (this.mState == 5) {
      localRect.offset(0, (int)this.GA);
    }
    for (;;)
    {
      this.hk.setBounds(localRect);
      this.hk.setAlpha(this.mTextAlpha);
      this.hk.draw(paramCanvas);
      return;
      if (this.mState != 6) {}
    }
  }
  
  private void eTt()
  {
    this.NE.add(Integer.valueOf(1000));
    this.NE.add(Integer.valueOf(42));
    this.NE.add(Integer.valueOf(47));
    this.NE.add(Integer.valueOf(54));
    this.NE.add(Integer.valueOf(61));
    this.NE.add(Integer.valueOf(65));
    this.NE.add(Integer.valueOf(67));
    this.NE.add(Integer.valueOf(69));
    this.NE.add(Integer.valueOf(66));
    this.NE.add(Integer.valueOf(64));
    this.NE.add(Integer.valueOf(64));
    this.NE.add(Integer.valueOf(64));
    this.NE.add(Integer.valueOf(64));
    this.NE.add(Integer.valueOf(64));
  }
  
  private void gI(Context paramContext)
  {
    this.Gs = PickerContainer.c(paramContext, this.Gs);
    this.Gt = PickerContainer.c(paramContext, this.Gt);
    this.Gu = PickerContainer.c(paramContext, this.Gu);
    this.Gv = PickerContainer.c(paramContext, this.Gv);
    this.Gw = PickerContainer.c(paramContext, this.Gw);
    this.Gx = PickerContainer.c(paramContext, this.Gx);
    this.Gy = PickerContainer.c(paramContext, this.Gy);
    this.Gz = PickerContainer.c(paramContext, this.Gz);
    if ((this.NE != null) && (this.NE.size() > 0))
    {
      int i = 0;
      while (i < this.NE.size())
      {
        this.NE.set(i, Integer.valueOf((int)PickerContainer.c(paramContext, ((Integer)this.NE.get(i)).intValue())));
        i += 1;
      }
    }
  }
  
  private void gK(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.qW.put("1/2", paramContext.getResources().getDrawable(2130842332));
    this.qW.put("1/4", paramContext.getResources().getDrawable(2130842333));
    this.qW.put("1x", paramContext.getResources().getDrawable(2130842334));
    this.qW.put("2x", paramContext.getResources().getDrawable(2130842335));
    this.qW.put("4x", paramContext.getResources().getDrawable(2130842336));
    this.qW.put(PickerContainer.cXS, paramContext.getResources().getDrawable(2130842359));
    this.qX.put("1/2", paramContext.getResources().getDrawable(2130842376));
    this.qX.put("1/4", paramContext.getResources().getDrawable(2130842377));
    this.qX.put("1x", paramContext.getResources().getDrawable(2130842378));
    this.qX.put("2x", paramContext.getResources().getDrawable(2130842379));
    this.qX.put("4x", paramContext.getResources().getDrawable(2130842380));
    this.qX.put(PickerContainer.cXS, paramContext.getResources().getDrawable(2130842381));
  }
  
  private int getIndex()
  {
    return this.mIndex;
  }
  
  private void i(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.bW.bottom = (paramFloat4 / 2.0F + paramFloat2);
    this.bW.top = (paramFloat2 - paramFloat4 / 2.0F);
    this.bW.right = (paramFloat3 / 2.0F + paramFloat1);
    this.bW.left = (paramFloat1 - paramFloat3 / 2.0F);
  }
  
  private void lC(int paramInt1, int paramInt2)
  {
    if (this.d != null)
    {
      this.d.cancel();
      this.d.removeAllUpdateListeners();
      this.d = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "startValueAnimator: state:" + this.mState + " mIndex:" + this.mIndex + " mTextAlpha:" + this.mTextAlpha);
    }
    if (paramInt1 == 2) {
      if (this.x != null)
      {
        this.d = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.k, new int[] { this.mIndex, this.x.getNumberOfFrames() }) });
        this.d.setDuration(600L);
      }
    }
    for (;;)
    {
      if (this.d != null)
      {
        this.d.setRepeatMode(1);
        this.d.setRepeatCount(0);
        this.d.setStartDelay(0L);
        this.d.addUpdateListener(new aysr(this));
        this.d.addListener(new ayss(this));
        this.d.start();
      }
      return;
      if (paramInt1 == 4)
      {
        if (this.v != null)
        {
          paramInt1 = me(this.mIndex);
          if (QLog.isColorLevel()) {
            QLog.d("MarkDrawable", 2, "calcBackIndex return : " + paramInt1);
          }
          this.d = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.k, new int[] { paramInt1, this.v.getNumberOfFrames() }) });
          this.d.setDuration(400L);
        }
      }
      else if (paramInt1 == 5)
      {
        this.d = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.l, new int[] { this.mTextAlpha, 255 }), PropertyValuesHolder.ofFloat(this.m, new float[] { this.GA, 0.0F }) });
        this.d.setDuration(paramInt2);
      }
      else if (paramInt1 == 6)
      {
        this.d = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.l, new int[] { this.mTextAlpha, 0 }) });
        this.d.setDuration(paramInt2);
      }
    }
  }
  
  private int me(int paramInt)
  {
    if (paramInt > this.v.getNumberOfFrames()) {
      return 0;
    }
    return this.v.getNumberOfFrames() - paramInt;
  }
  
  private void setIndex(int paramInt)
  {
    this.mIndex = paramInt;
    if (this.mState == 2)
    {
      if ((this.mIndex >= 0) && (this.mIndex < this.NE.size()))
      {
        paramInt = ((Integer)this.NE.get(this.mIndex)).intValue();
        float f = this.Gy;
        bJ(paramInt + f);
        setTextSize(this.Gs);
      }
      if (this.mIndex == 1) {
        this.mTextAlpha = 51;
      }
    }
    aysn.a locala;
    do
    {
      do
      {
        return;
        if (this.mIndex == 2)
        {
          this.mTextAlpha = 127;
          return;
        }
        this.mTextAlpha = 255;
        return;
      } while ((this.mState != 4) || (this.mListenerRef == null) || (this.v == null));
      locala = (aysn.a)this.mListenerRef.get();
    } while (locala == null);
    locala.bs(this.mState, this.mIndex, this.v.getNumberOfFrames());
  }
  
  private void setTextAlpha(int paramInt)
  {
    this.mTextAlpha = paramInt;
  }
  
  private void setTextSize(float paramFloat)
  {
    i(this.bW.centerX(), this.bW.centerY(), paramFloat, paramFloat);
  }
  
  public int Sf()
  {
    return this.mState;
  }
  
  public boolean a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, aysn.a parama)
  {
    eTt();
    gI(paramContext);
    this.v = a(paramContext, paramInt1);
    this.w = a(paramContext, paramInt2);
    this.x = a(paramContext, paramInt3);
    this.mListenerRef = new WeakReference(parama);
    gK(paramContext);
    this.mTextPaint.setTextSize(this.Gu);
    this.mTextPaint.setColor(16777215);
    this.mTextPaint.setTextAlign(Paint.Align.LEFT);
    return true;
  }
  
  public void afv(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "setAnimState: old state:" + this.mState + " new state:" + paramInt);
    }
    this.mState = paramInt;
    switch (this.mState)
    {
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    default: 
      return;
    }
    this.mIndex = 0;
    setTextSize(this.Gs);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mState == 0) {}
    do
    {
      do
      {
        return;
        if ((this.mState != 2) && (this.mState != 4) && (this.mState != 3)) {
          break;
        }
        cl(paramCanvas);
      } while (this.mState == 4);
      cm(paramCanvas);
      return;
    } while ((this.mState != 5) && (this.mState != 1) && (this.mState != 6));
    cn(paramCanvas);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    return this.dAA;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    int j = 0;
    super.onBoundsChange(paramRect);
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onBoundsChange: mState:" + this.mState + " bound:" + paramRect);
    }
    int i;
    Drawable localDrawable;
    if (this.x != null)
    {
      this.x.setBounds(paramRect);
      i = 0;
      while (i < this.x.getNumberOfFrames())
      {
        localDrawable = this.x.getFrame(i);
        if (localDrawable != null) {
          localDrawable.setBounds(paramRect);
        }
        i += 1;
      }
    }
    if (this.v != null)
    {
      this.v.setBounds(paramRect);
      i = 0;
      while (i < this.v.getNumberOfFrames())
      {
        localDrawable = this.v.getFrame(i);
        if (localDrawable != null) {
          localDrawable.setBounds(paramRect);
        }
        i += 1;
      }
    }
    if (this.w != null)
    {
      this.w.setBounds(paramRect);
      i = j;
      while (i < this.w.getNumberOfFrames())
      {
        localDrawable = this.w.getFrame(i);
        if (localDrawable != null) {
          localDrawable.setBounds(paramRect);
        }
        i += 1;
      }
    }
    i(paramRect.centerX(), paramRect.centerY(), this.Gs, this.Gt);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setText(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.cXR = "";
      this.hj = null;
      return;
    }
    this.cXR = paramString;
    this.hj = ((Drawable)this.qW.get(paramString));
    this.hk = ((Drawable)this.qX.get(paramString));
    invalidateSelf();
  }
  
  public void start()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "start:" + this.mState + " isRunning:" + this.dAA);
    }
    if (isRunning()) {
      stop();
    }
    this.dAA = true;
    if ((this.mState == 2) || (this.mState == 1))
    {
      this.mState = 2;
      lC(this.mState, 600);
    }
    do
    {
      return;
      if ((this.mState == 4) || (this.mState == 3))
      {
        this.mState = 4;
        lC(this.mState, 400);
        return;
      }
    } while ((this.mState != 5) && (this.mState != 6));
    lC(this.mState, 200);
  }
  
  public void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "stop:" + this.mState + " isRunning:" + this.dAA);
    }
    if (!this.dAA) {}
    do
    {
      return;
      this.dAA = false;
    } while (this.d == null);
    this.d.cancel();
    this.d.removeAllUpdateListeners();
    this.d = null;
  }
  
  public void unInit()
  {
    this.v = null;
    this.w = null;
    this.x = null;
    this.hj = null;
    this.hk = null;
    this.dAA = false;
    if (this.d != null)
    {
      this.d.cancel();
      this.d.removeAllUpdateListeners();
      this.d = null;
    }
    this.qW.clear();
    this.qX.clear();
    this.NE.clear();
    this.mListenerRef = null;
    this.k = null;
    this.l = null;
    this.m = null;
  }
  
  public static abstract interface a
  {
    public abstract void afF(int paramInt);
    
    public abstract void afG(int paramInt);
    
    public abstract void afH(int paramInt);
    
    public abstract void bs(int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aysn
 * JD-Core Version:    0.7.0.1
 */