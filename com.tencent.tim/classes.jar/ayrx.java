import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Property;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;
import java.lang.ref.WeakReference;

public class ayrx
  extends Drawable
  implements Animatable
{
  private float Gl = 16.0F;
  private float Gm = 5.0F;
  private float Gn = 50.0F;
  private float Go = 50.0F;
  private float Gp = 30.0F;
  private float Gq = 22.0F;
  private ayst jdField_a_of_type_Ayst = new ayst();
  private aysx jdField_a_of_type_Aysx = new aysx();
  Property<ayrx, Integer> b = new aysa(this, Integer.class, "backAlpha");
  private RectF bT = new RectF();
  private RectF bU = new RectF();
  private RectF bV = new RectF();
  Property<ayrx, Float> c = new ayry(this, Float.class, "backHeight");
  private int cVo = -1;
  private ValueAnimator jdField_d_of_type_AndroidAnimationValueAnimator;
  Property<ayrx, Integer> jdField_d_of_type_AndroidUtilProperty = new aysb(this, Integer.class, "speedAlpha");
  private boolean dAA;
  private boolean dAC;
  Property<ayrx, Integer> e = new aysc(this, Integer.class, "reverseAlpha");
  private int eME;
  private int eMF = 255;
  private int eMG;
  private int eMH = 179;
  private int eMI;
  private int eMJ = 179;
  Property<ayrx, Float> f = new aysd(this, Float.class, "foreSpeed");
  Property<ayrx, Float> g = new ayse(this, Float.class, "foreHeight");
  Property<ayrx, Float> h = new aysf(this, Float.class, "speedPos");
  private Drawable hh;
  private Drawable hi;
  Property<ayrx, Integer> i = new aysg(this, Integer.class, "markAlpha");
  private WeakReference<ayrx.a> mListenerRef;
  private int mState = 0;
  
  private int Sb()
  {
    return this.eME;
  }
  
  private int Sc()
  {
    return this.eMJ;
  }
  
  private int Sd()
  {
    return this.eMI;
  }
  
  private int Se()
  {
    return this.eMF;
  }
  
  private void a(Float paramFloat)
  {
    if (this.mState == 3)
    {
      this.bU.left = (this.bU.centerX() - paramFloat.floatValue() / 2.0F);
      this.bU.right = (this.bU.centerX() + paramFloat.floatValue() / 2.0F);
      this.bU.top = (this.bU.centerY() - paramFloat.floatValue() / 2.0F);
      this.bU.bottom = (this.bU.centerY() + paramFloat.floatValue() / 2.0F);
    }
  }
  
  private void afA(int paramInt)
  {
    if (this.mListenerRef == null) {}
    ayrx.a locala;
    do
    {
      return;
      locala = (ayrx.a)this.mListenerRef.get();
    } while (locala == null);
    locala.afC(paramInt);
  }
  
  private void afB(int paramInt)
  {
    if (this.mListenerRef == null) {}
    ayrx.a locala;
    do
    {
      return;
      locala = (ayrx.a)this.mListenerRef.get();
    } while (locala == null);
    locala.afE(paramInt);
  }
  
  private void afu(int paramInt)
  {
    if ((this.mState == 3) || (this.mState == 1))
    {
      this.eME = paramInt;
      return;
    }
    this.eME = 115;
  }
  
  private void afw(int paramInt)
  {
    if ((this.mState == 3) || (this.mState == 1))
    {
      this.eMJ = paramInt;
      return;
    }
    if (this.mState == 0)
    {
      this.eMJ = 179;
      return;
    }
    this.eMJ = 127;
  }
  
  private void afx(int paramInt)
  {
    if ((this.mState == 1) || (this.mState == 3))
    {
      this.eMF = paramInt;
      return;
    }
    this.eME = 255;
  }
  
  private void afy(int paramInt)
  {
    if (this.mState == 1)
    {
      this.eMI = paramInt;
      this.eMH = (255 - this.eMI);
    }
    while (this.mState != 3) {
      return;
    }
    this.eMI = paramInt;
    this.eMH = ((int)((255 - this.eMI) * 179 * 1.0F / 255.0F));
  }
  
  private void afz(int paramInt)
  {
    if (this.mListenerRef == null) {}
    ayrx.a locala;
    do
    {
      return;
      locala = (ayrx.a)this.mListenerRef.get();
    } while (locala == null);
    locala.afD(paramInt);
  }
  
  private void b(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_d_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_d_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_d_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_d_of_type_AndroidAnimationValueAnimator = null;
    }
    int j = getBounds().height();
    PropertyValuesHolder localPropertyValuesHolder1;
    PropertyValuesHolder localPropertyValuesHolder2;
    PropertyValuesHolder localPropertyValuesHolder3;
    if (paramInt1 == 1)
    {
      localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat(this.c, new float[] { this.bT.height(), j });
      localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat(this.g, new float[] { this.bV.height(), j });
      localPropertyValuesHolder3 = PropertyValuesHolder.ofInt(this.b, new int[] { this.eME, 115 });
      this.jdField_d_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { localPropertyValuesHolder1, localPropertyValuesHolder2, PropertyValuesHolder.ofInt(this.jdField_d_of_type_AndroidUtilProperty, new int[] { this.eMF, 0 }), PropertyValuesHolder.ofInt(this.e, new int[] { this.eMI, 255 }), localPropertyValuesHolder3, PropertyValuesHolder.ofInt(this.i, new int[] { this.eMJ, 127 }) });
      this.jdField_d_of_type_AndroidAnimationValueAnimator.setDuration(paramInt2);
    }
    for (;;)
    {
      if (this.jdField_d_of_type_AndroidAnimationValueAnimator != null)
      {
        this.jdField_d_of_type_AndroidAnimationValueAnimator.setRepeatMode(1);
        this.jdField_d_of_type_AndroidAnimationValueAnimator.setRepeatCount(0);
        this.jdField_d_of_type_AndroidAnimationValueAnimator.setStartDelay(0L);
        this.jdField_d_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aysh(this));
        this.jdField_d_of_type_AndroidAnimationValueAnimator.addListener(new ayrz(this));
        this.jdField_d_of_type_AndroidAnimationValueAnimator.start();
      }
      return;
      if (paramInt1 == 3)
      {
        localPropertyValuesHolder1 = PropertyValuesHolder.ofInt(this.b, new int[] { this.eME, 0 });
        localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat(this.c, new float[] { this.bT.height(), 0.0F });
        localPropertyValuesHolder3 = PropertyValuesHolder.ofFloat(this.g, new float[] { this.bV.height(), (int)(j * 0.9F) });
        PropertyValuesHolder localPropertyValuesHolder4 = PropertyValuesHolder.ofFloat(this.f, new float[] { this.bU.height(), (int)this.Gn });
        PropertyValuesHolder localPropertyValuesHolder5 = PropertyValuesHolder.ofInt(this.jdField_d_of_type_AndroidUtilProperty, new int[] { this.eMF, 255 });
        this.jdField_d_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { localPropertyValuesHolder1, localPropertyValuesHolder3, localPropertyValuesHolder4, PropertyValuesHolder.ofInt(this.e, new int[] { this.eMI, 0 }), localPropertyValuesHolder2, localPropertyValuesHolder5, PropertyValuesHolder.ofInt(this.i, new int[] { this.eMJ, 179 }) });
        this.jdField_d_of_type_AndroidAnimationValueAnimator.setDuration(paramInt2);
      }
      else if (paramInt1 == 4)
      {
        this.jdField_d_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(this.h, new float[] { paramFloat1, paramFloat2 }) });
        this.jdField_d_of_type_AndroidAnimationValueAnimator.setDuration(paramInt2);
      }
    }
  }
  
  private void b(RectF paramRectF, float paramFloat)
  {
    if (paramRectF == null) {
      return;
    }
    Rect localRect = getBounds();
    float f1 = paramFloat;
    if (localRect.height() < paramFloat) {
      f1 = localRect.height();
    }
    float f2 = localRect.width() * 1.0F / localRect.height() * f1;
    paramFloat = f2;
    if (localRect.width() < f2) {
      paramFloat = localRect.width();
    }
    f2 = (localRect.width() - paramFloat) / 2.0F;
    float f3 = (localRect.height() - f1) / 2.0F;
    paramRectF.set(f2, f3, paramFloat + f2, f3 + f1);
  }
  
  private void bE(float paramFloat)
  {
    if (this.mState == 4)
    {
      float f1 = this.bU.centerY();
      this.bU.offset(0.0F, paramFloat - f1);
      if (this.mListenerRef != null)
      {
        ayrx.a locala = (ayrx.a)this.mListenerRef.get();
        if (locala != null) {
          locala.a(this.mState, this.bU);
        }
      }
    }
  }
  
  private void bF(float paramFloat)
  {
    if ((this.mState == 1) || (this.mState == 3))
    {
      b(this.bT, paramFloat);
      if (this.jdField_a_of_type_Ayst != null) {
        this.jdField_a_of_type_Ayst.e(this.bT);
      }
    }
  }
  
  private void bG(float paramFloat)
  {
    if ((this.mState == 1) || (this.mState == 3))
    {
      b(this.bV, paramFloat);
      if (this.jdField_a_of_type_Aysx != null)
      {
        this.jdField_a_of_type_Aysx.e(this.bV);
        if (this.mListenerRef != null)
        {
          ayrx.a locala = (ayrx.a)this.mListenerRef.get();
          if (locala != null) {
            locala.a(this.mState, o());
          }
        }
      }
    }
  }
  
  private float ch()
  {
    return this.bU.centerY();
  }
  
  private float ci()
  {
    return this.bU.height();
  }
  
  private float cj()
  {
    return this.bT.height();
  }
  
  private void cj(Canvas paramCanvas)
  {
    RectF localRectF = this.jdField_a_of_type_Aysx.c(this.cVo);
    if (localRectF != null)
    {
      float f1 = localRectF.centerX();
      float f2 = localRectF.centerY();
      f1 -= this.bU.width() / 2.0F;
      f2 -= this.bU.height() / 2.0F;
      float f3 = this.bU.width();
      float f4 = this.bU.height();
      paramCanvas.save();
      if (this.hh != null)
      {
        this.hh.setBounds((int)f1, (int)f2, (int)(f3 + f1), (int)(f4 + f2));
        this.hh.setAlpha(this.eMF);
        this.hh.draw(paramCanvas);
      }
      paramCanvas.restore();
    }
  }
  
  private float ck()
  {
    return this.bV.height();
  }
  
  private void ck(Canvas paramCanvas)
  {
    if (this.hh != null)
    {
      this.hh.setBounds((int)this.bU.left, (int)this.bU.top, (int)this.bU.right, (int)this.bU.bottom);
      this.hh.setAlpha(this.eMF);
      this.hh.draw(paramCanvas);
    }
  }
  
  private void d(Canvas paramCanvas, boolean paramBoolean)
  {
    RectF localRectF = this.jdField_a_of_type_Aysx.c(this.eMG - 1);
    if ((localRectF != null) && (this.hi != null))
    {
      float f1 = localRectF.centerX();
      float f2 = localRectF.centerY();
      f1 -= this.Gp / 2.0F;
      f2 -= this.Gq / 2.0F;
      float f3 = this.Gp;
      float f4 = this.Gq;
      this.hi.setBounds((int)f1, (int)f2, (int)(f3 + f1), (int)(f4 + f2));
      if (paramBoolean) {
        break label119;
      }
      this.hi.setAlpha(this.eMI);
    }
    for (;;)
    {
      this.hi.draw(paramCanvas);
      return;
      label119:
      this.hi.setAlpha(255);
    }
  }
  
  private void gJ(Context paramContext)
  {
    this.Gn = PickerContainer.c(paramContext, this.Gn);
    this.Go = PickerContainer.c(paramContext, this.Go);
    this.Gp = PickerContainer.c(paramContext, this.Gp);
    this.Gq = PickerContainer.c(paramContext, this.Gq);
    this.Gm = PickerContainer.c(paramContext, this.Gm);
    this.Gl /= paramContext.getResources().getDisplayMetrics().density;
  }
  
  private void o(Rect paramRect)
  {
    if (paramRect == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!this.dAA) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("GroundDrawable", 2, "isrunning, cannot resetdata:" + this.mState);
          return;
          if ((this.mState != 0) && (this.mState != 1)) {
            break;
          }
          b(this.bT, paramRect.height() * 0.4F);
          if (this.jdField_a_of_type_Ayst != null) {
            this.jdField_a_of_type_Ayst.e(this.bT);
          }
          b(this.bV, paramRect.height() * 0.9F);
        } while (this.jdField_a_of_type_Aysx == null);
        this.jdField_a_of_type_Aysx.e(this.bV);
        return;
      } while ((this.mState != 3) && (this.mState != 2));
      b(this.bT, paramRect.height());
      b(this.bV, paramRect.height());
      if (this.jdField_a_of_type_Ayst != null) {
        this.jdField_a_of_type_Ayst.e(this.bT);
      }
    } while (this.jdField_a_of_type_Aysx == null);
    this.jdField_a_of_type_Aysx.e(this.bV);
  }
  
  public int Sf()
  {
    return this.mState;
  }
  
  public RectF a(float paramFloat)
  {
    int j = y(paramFloat);
    if (this.jdField_a_of_type_Aysx != null) {
      return this.jdField_a_of_type_Aysx.c(j);
    }
    return null;
  }
  
  public RectF a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = this.cVo;
    this.cVo = paramInt;
    if (paramBoolean1) {
      this.dAC = paramBoolean1;
    }
    RectF localRectF;
    Object localObject;
    if (this.jdField_a_of_type_Aysx != null)
    {
      localRectF = this.jdField_a_of_type_Aysx.c(paramInt);
      if (localRectF != null)
      {
        if (paramBoolean2) {
          break label160;
        }
        this.bU.set(localRectF.centerX() - this.Gn / 2.0F, localRectF.centerY() - this.Go / 2.0F, localRectF.centerX() + this.Go / 2.0F, localRectF.centerY() + this.Go / 2.0F);
        if ((paramBoolean1) && (this.mListenerRef != null))
        {
          localObject = (ayrx.a)this.mListenerRef.get();
          if (localObject != null)
          {
            ((ayrx.a)localObject).a(this.mState, this.cVo, localRectF);
            this.dAC = false;
          }
        }
        invalidateSelf();
      }
    }
    for (;;)
    {
      return this.bU;
      label160:
      localObject = this.jdField_a_of_type_Aysx.c(j);
      if (localObject != null)
      {
        this.bU.set(((RectF)localObject).centerX() - this.Gn / 2.0F, ((RectF)localObject).centerY() - this.Go / 2.0F, ((RectF)localObject).centerX() + this.Go / 2.0F, ((RectF)localObject).centerY() + this.Go / 2.0F);
        float f1 = Math.abs(((RectF)localObject).centerY() - localRectF.centerY());
        float f2 = this.Gl;
        if (isRunning()) {
          stop();
        }
        this.mState = 4;
        this.dAA = true;
        b(this.mState, (int)(f1 * f2), ((RectF)localObject).centerY(), localRectF.centerY());
      }
    }
  }
  
  public boolean a(Context paramContext, int paramInt, float paramFloat1, float paramFloat2, ayrx.a parama)
  {
    this.mListenerRef = new WeakReference(parama);
    if (paramInt > 0) {
      this.Gl /= paramInt;
    }
    gJ(paramContext);
    this.eMG = paramInt;
    this.jdField_a_of_type_Aysx.a(-1, paramInt, this.Gm, paramFloat1, paramFloat2);
    this.jdField_a_of_type_Ayst.g(0, paramFloat1, paramFloat2);
    this.hh = paramContext.getResources().getDrawable(2130842375);
    this.hi = paramContext.getResources().getDrawable(2130842374);
    return true;
  }
  
  public void afv(int paramInt)
  {
    this.mState = paramInt;
    switch (this.mState)
    {
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mState == 0)
    {
      this.jdField_a_of_type_Aysx.d(paramCanvas, this.eMH, this.cVo, (int)(this.eMI * 1.0F * 179.0F / 255.0F), this.eMJ);
      if ((this.cVo >= 0) && (this.cVo < this.eMG)) {
        cj(paramCanvas);
      }
    }
    for (;;)
    {
      return;
      if ((this.mState == 1) || (this.mState == 3) || (this.mState == 2))
      {
        this.jdField_a_of_type_Ayst.d(paramCanvas, this.eME);
        this.jdField_a_of_type_Aysx.d(paramCanvas, this.eMH, this.cVo, (int)(this.eMI * 1.0F * 127.0F / 255.0F), this.eMJ);
        d(paramCanvas, false);
        if ((this.mState == 3) || (this.mState == 1))
        {
          if (this.cVo == this.eMG - 1)
          {
            d(paramCanvas, true);
            return;
          }
          cj(paramCanvas);
        }
      }
      else if (this.mState == 4)
      {
        RectF localRectF = o();
        if (localRectF != null)
        {
          if (Math.abs(localRectF.centerY() - this.bU.centerY()) >= this.bU.height() / 2.0F) {
            break label289;
          }
          this.jdField_a_of_type_Aysx.d(paramCanvas, this.eMH, this.cVo, (int)(this.eMI * 1.0F * 179.0F / 255.0F), this.eMJ);
        }
        while ((this.cVo >= 0) && (this.cVo < this.eMG))
        {
          ck(paramCanvas);
          return;
          label289:
          this.jdField_a_of_type_Aysx.d(paramCanvas, this.eMH, -1, (int)(this.eMI * 1.0F * 179.0F / 255.0F), this.eMJ);
        }
      }
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    return this.dAA;
  }
  
  public RectF o()
  {
    if (this.jdField_a_of_type_Aysx != null) {
      return this.jdField_a_of_type_Aysx.c(this.cVo);
    }
    return null;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    o(paramRect);
    if (this.cVo >= 0)
    {
      a(this.cVo, false, false);
      if ((this.dAC) && (this.mListenerRef != null))
      {
        paramRect = (ayrx.a)this.mListenerRef.get();
        if (paramRect != null)
        {
          RectF localRectF = new RectF();
          localRectF.set(this.bU);
          paramRect.a(this.mState, this.cVo, localRectF);
          this.dAC = false;
        }
      }
      this.dAC = false;
    }
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void start()
  {
    if (isRunning()) {
      stop();
    }
    this.dAA = true;
    if (QLog.isColorLevel()) {
      QLog.d("GroundDrawable", 2, "start :" + this.mState);
    }
    if ((this.mState == 1) || (this.mState == 0))
    {
      this.mState = 1;
      b(this.mState, 300, -1.0F, -1.0F);
    }
    while ((this.mState != 3) && (this.mState != 2)) {
      return;
    }
    this.mState = 3;
    b(this.mState, 200, -1.0F, -1.0F);
  }
  
  public void stop()
  {
    if (!this.dAA) {}
    do
    {
      return;
      this.dAA = false;
      if (this.jdField_d_of_type_AndroidAnimationValueAnimator != null)
      {
        this.jdField_d_of_type_AndroidAnimationValueAnimator.cancel();
        this.jdField_d_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
        this.jdField_d_of_type_AndroidAnimationValueAnimator = null;
      }
      if (this.mState == 1)
      {
        this.mState = 2;
        o(getBounds());
        this.eME = 115;
        return;
      }
    } while (this.mState != 3);
    this.mState = 0;
    o(getBounds());
    this.eME = 115;
  }
  
  public void unInit()
  {
    this.jdField_a_of_type_Aysx.unInit();
    this.jdField_a_of_type_Ayst.unInit();
    this.hh = null;
    this.hi = null;
    this.dAA = false;
    if (this.jdField_d_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_d_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_d_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_d_of_type_AndroidAnimationValueAnimator = null;
    }
    this.mListenerRef = null;
    this.c = null;
    this.b = null;
    this.jdField_d_of_type_AndroidUtilProperty = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = null;
  }
  
  public int y(float paramFloat)
  {
    if (this.jdField_a_of_type_Aysx != null) {
      return this.jdField_a_of_type_Aysx.y(paramFloat);
    }
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, RectF paramRectF);
    
    public abstract void a(int paramInt, RectF paramRectF);
    
    public abstract void afC(int paramInt);
    
    public abstract void afD(int paramInt);
    
    public abstract void afE(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayrx
 * JD-Core Version:    0.7.0.1
 */