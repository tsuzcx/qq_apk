import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;

public class aavb
{
  private aaux jdField_a_of_type_Aaux;
  private aavb.a jdField_a_of_type_Aavb$a;
  private int btB = Color.parseColor("#298be7");
  private final Bitmap cO;
  private final Bitmap cP;
  private int ckM = -1;
  private int lineHeight = 4;
  private float mLastX;
  private final float of;
  private final Paint paint = new Paint(1);
  private final float rW;
  private final float rX;
  private final float rY;
  private float rZ;
  private float sa;
  private float sb;
  private float sc;
  private float sd;
  private float se;
  
  public aavb(aaux paramaaux, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Aaux = paramaaux;
    Object localObject = this.jdField_a_of_type_Aaux.getContext();
    this.rW = (aqnm.getScreenWidth() * 0.0375F);
    this.rX = paramFloat2;
    this.rY = (this.rW * 0.5F);
    this.of = paramInt3;
    paramaaux = b(((Context)localObject).getResources(), 2130850017, (int)this.rW, (int)this.rX);
    localObject = b(((Context)localObject).getResources(), 2130850019, (int)this.rW, (int)this.rX);
    ColorDrawable localColorDrawable = new ColorDrawable(this.btB);
    localColorDrawable.setBounds(0, 0, (int)this.rW, (int)this.rX);
    this.cO = Bitmap.createBitmap((int)this.rW, (int)this.rX, Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(this.cO);
    localColorDrawable.draw(localCanvas);
    if (paramaaux != null) {
      localCanvas.drawBitmap(paramaaux, (this.rW - paramaaux.getWidth()) / 2.0F, (this.rX - paramaaux.getHeight()) / 2.0F, this.paint);
    }
    this.cP = Bitmap.createBitmap((int)this.rW, (int)this.rX, Bitmap.Config.RGB_565);
    localCanvas.setBitmap(this.cP);
    localColorDrawable.draw(localCanvas);
    if (localObject != null) {
      localCanvas.drawBitmap((Bitmap)localObject, (this.rW - ((Bitmap)localObject).getWidth()) / 2.0F, (this.rX - ((Bitmap)localObject).getHeight()) / 2.0F, this.paint);
    }
    this.sc = (1.0F * paramInt4 / paramInt2 * paramFloat1 + this.rW);
    this.sb = (2000.0F / paramInt2 * paramFloat1);
    this.sd = (paramInt3 - this.rW);
    this.se = this.rW;
    this.rZ = this.rW;
    this.sa = this.sc;
  }
  
  private boolean E(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) == 0.0F;
  }
  
  private void a(float paramFloat, Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.cP, paramFloat, 0.0F, this.paint);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (Math.abs(paramFloat1 - paramFloat3) <= this.rW * 2.0F) && (paramFloat2 > 0.0F) && (paramFloat2 < this.rX);
  }
  
  private void b(float paramFloat, Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.cO, paramFloat - this.rW, 0.0F, this.paint);
  }
  
  public boolean F(float paramFloat1, float paramFloat2)
  {
    boolean bool1 = a(paramFloat1, paramFloat2, this.rZ - this.rY);
    boolean bool2 = a(paramFloat1, paramFloat2, this.sa + this.rY);
    if (bool1)
    {
      this.ckM = 0;
      return true;
    }
    if (bool2)
    {
      this.ckM = 1;
      return true;
    }
    return false;
  }
  
  public void J(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 >= 0.0F) {}
    for (this.se = (this.rW + paramFloat1);; this.se = this.rW)
    {
      if (paramFloat2 >= 0.0F) {
        this.sd = Math.min(this.rW + paramFloat2, this.of - this.rW);
      }
      return;
    }
  }
  
  public void a(aavb.a parama)
  {
    this.jdField_a_of_type_Aavb$a = parama;
  }
  
  public float aR()
  {
    return this.rW;
  }
  
  public float aS()
  {
    return this.sa - this.rZ;
  }
  
  public Bitmap b(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    if (paramResources == null) {}
    while (paramInt1 <= 0) {
      return null;
    }
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
      if ((paramInt2 <= 0) && (paramInt3 <= 0)) {}
      for (paramInt2 = i;; paramInt2 = calculateInSampleSize(localOptions, paramInt2, paramInt3))
      {
        localOptions.inJustDecodeBounds = false;
        localOptions.inSampleSize = paramInt2;
        return BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
      }
      return null;
    }
    catch (Exception paramResources)
    {
      paramResources.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError paramResources)
    {
      paramResources.printStackTrace();
    }
  }
  
  public int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int j = 1;
    int i = 1;
    if ((k > paramInt2) || (m > paramInt1))
    {
      k /= 2;
      m /= 2;
      for (;;)
      {
        j = i;
        if (k / i <= paramInt2) {
          break;
        }
        j = i;
        if (m / i <= paramInt1) {
          break;
        }
        i *= 2;
      }
    }
    return j;
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_Aavb$a = null;
    this.cO.recycle();
    this.cP.recycle();
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.save();
    int i = this.paint.getColor();
    this.paint.setColor(this.btB);
    paramCanvas.drawRect(this.rZ, 0.0F, this.sa, this.lineHeight, this.paint);
    paramCanvas.drawRect(this.rZ, this.rX - this.lineHeight, this.sa, this.rX, this.paint);
    this.paint.setColor(i);
    b(this.rZ, paramCanvas);
    a(this.sa, paramCanvas);
    paramCanvas.restore();
  }
  
  public float getHeight()
  {
    return this.rX;
  }
  
  public boolean hasChanged()
  {
    return (!E(this.rZ, this.rW)) || (!E(this.sa, this.sc));
  }
  
  public void processTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    if (paramMotionEvent.getAction() == 1) {
      this.ckM = -1;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.mLastX = paramMotionEvent.getX();
      return;
    }
    float f2;
    float f3;
    if (paramMotionEvent.getAction() == 2)
    {
      f2 = f1 - this.mLastX;
      if (this.ckM != 0) {
        break label186;
      }
      f3 = Math.max(this.sa - this.sc, this.se);
      if (f1 < f3)
      {
        this.rZ = f3;
        return;
      }
      if ((f2 >= 0.0F) || (f2 + this.rZ > this.rW)) {
        break label148;
      }
      this.rZ = f3;
    }
    for (;;)
    {
      this.jdField_a_of_type_Aaux.invalidate();
      if (this.jdField_a_of_type_Aavb$a == null) {
        break;
      }
      this.jdField_a_of_type_Aavb$a.K(this.rZ, this.sa);
      return;
      label148:
      if (this.sa - f1 < this.sb)
      {
        this.rZ = (this.sa - this.sb);
      }
      else
      {
        this.rZ = f1;
        continue;
        label186:
        if (this.ckM == 1)
        {
          f3 = Math.min(this.rZ + this.sc, this.sd);
          if (f1 > f3)
          {
            this.sa = f3;
            return;
          }
          if ((f2 > 0.0F) && (f2 + this.sa >= this.sc)) {
            this.sa = f3;
          } else if (f1 - this.rZ < this.sb) {
            this.sa = (this.rZ + this.sb);
          } else {
            this.sa = f1;
          }
        }
      }
    }
  }
  
  public void reset()
  {
    this.jdField_a_of_type_Aavb$a = null;
    this.rZ = 0.0F;
    this.sa = 0.0F;
  }
  
  public static abstract interface a
  {
    public abstract void K(float paramFloat1, float paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aavb
 * JD-Core Version:    0.7.0.1
 */