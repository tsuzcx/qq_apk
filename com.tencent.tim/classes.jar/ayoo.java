import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextItem;

public class ayoo
{
  private Matrix C = new Matrix();
  private float FS;
  private float FT;
  private final int STATE_NONE = 0;
  private boolean aIk;
  private boolean aIl;
  private boolean aIm;
  private final int bsm = 1;
  private final int bsn = 2;
  private final int bso = 3;
  private ayoo.a e;
  private final int eMu = 4;
  private Matrix mMatrix = new Matrix();
  private float mMaxScale = 2.147484E+009F;
  private float mMinScale;
  private float mStartX;
  private float mStartY;
  private int mState = 0;
  private float nA;
  private float nB;
  private float nC;
  private float nD;
  private float nE;
  private float nF;
  private float nG;
  private float nH;
  
  private void N(MotionEvent paramMotionEvent)
  {
    this.e.aIq = false;
    this.e.aHC = false;
    this.mState = 0;
    reset();
  }
  
  private void P(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getX(1);
    paramMotionEvent.getY(1);
    this.e.aHC = true;
    if ((this.mState == 1) || (this.mState == 3))
    {
      this.mState = 2;
      this.nG = this.e.scaleValue;
      this.nH = this.e.nI;
      this.nE = this.e.translateXValue;
      this.nF = this.e.translateYValue;
      this.nA = ayop.spacing(paramMotionEvent);
      this.nB = ayop.b(paramMotionEvent);
      paramMotionEvent = ayop.a(paramMotionEvent);
      this.nC = paramMotionEvent[0];
      this.nD = paramMotionEvent[1];
    }
  }
  
  private void Q(MotionEvent paramMotionEvent)
  {
    this.e.aHC = false;
    if (this.mState == 2)
    {
      this.aIk = true;
      this.mState = 1;
    }
  }
  
  private boolean a(ayoo.a parama, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    if (!parama.dzE) {
      return false;
    }
    float f3 = ayom.tw() / 2.0F;
    if ((parama.isAnchor) && (parama.dzH)) {
      return (paramFloat1 >= parama.FJ + parama.FH - f3 - 10.0F) && (paramFloat1 <= parama.FJ + parama.FH + f3 + 10.0F) && (paramFloat2 >= parama.FK + parama.FI - f3 - 10.0F) && (paramFloat2 <= parama.FK + parama.FI + f3 + 10.0F);
    }
    paramFloat1 = a(parama);
    float f1 = parama.width;
    paramFloat2 = parama.height;
    f1 += parama.bsp / paramFloat1 * 2.0F;
    float f2 = parama.bsp / paramFloat1 * 2.0F + paramFloat2;
    paramFloat2 = f1;
    if (this.aIm)
    {
      paramFloat1 = f1;
      if (parama.scaleValue * f1 < 200.0F) {
        paramFloat1 = 200.0F / parama.scaleValue;
      }
      paramFloat2 = paramFloat1;
      if (parama.scaleValue * f2 < 200.0F)
      {
        paramFloat2 = 200.0F / parama.scaleValue;
        f1 = paramFloat1;
        paramFloat1 = paramFloat2;
      }
    }
    for (;;)
    {
      paramFloat2 = -f1 / 2.0F;
      paramFloat1 /= 2.0F;
      return (paramFloat3 >= paramFloat2 - f3 - 10.0F) && (paramFloat3 <= paramFloat2 + f3 + 10.0F) && (paramFloat4 >= paramFloat1 - f3 - 10.0F) && (paramFloat4 <= paramFloat1 + f3 + 10.0F);
      paramFloat1 = f2;
      f1 = paramFloat2;
    }
  }
  
  private void b(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    this.aIl = true;
    this.mState = 1;
    float f2 = paramMotionEvent.getX(0);
    float f1 = paramMotionEvent.getY(0);
    this.mStartX = f2;
    this.mStartY = f1;
    this.nE = this.e.translateXValue;
    this.nF = this.e.translateYValue;
    this.e.aIq = false;
    this.e.aHC = false;
    if ((b(this.e, f2, f1)) && (paramBoolean))
    {
      this.mState = 3;
      this.nG = this.e.scaleValue;
      this.nH = this.e.nI;
      f2 = f2 - this.e.centerP.x - this.e.translateXValue;
      f1 = f1 - this.e.centerP.y - this.e.translateYValue;
      this.nA = ayop.e(f2, f1);
      this.nB = ayop.f(f2, f1);
      this.nC = this.e.centerP.x;
      this.nD = this.e.centerP.y;
    }
    do
    {
      do
      {
        return;
      } while (!c(this.e, f2, f1));
      if ((this.e.isAnchor) && (!this.e.dzH))
      {
        this.e.dzH = true;
        a(this.e, true);
      }
    } while ((!this.e.isAnchor) || (!this.e.dzH));
    this.mState = 4;
    this.FS = this.e.FH;
    this.FT = this.e.FI;
  }
  
  private void c(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (!this.aIl)
    {
      this.aIl = true;
      b(paramMotionEvent, paramBoolean);
    }
    label402:
    do
    {
      do
      {
        do
        {
          return;
          this.e.aIq = true;
          if ((paramMotionEvent.getPointerCount() == 1) && (this.mState == 1))
          {
            if (this.aIk)
            {
              this.aIk = false;
              this.mStartX = paramMotionEvent.getX(0);
              this.mStartY = paramMotionEvent.getY(0);
              this.nE = this.e.translateXValue;
              this.nF = this.e.translateYValue;
              return;
            }
            f1 = paramMotionEvent.getX(0);
            f2 = this.mStartX;
            f3 = paramMotionEvent.getY(0);
            f4 = this.mStartY;
            this.e.translateXValue = (f1 - f2 + this.nE);
            this.e.translateYValue = (f3 - f4 + this.nF);
            return;
          }
          if ((paramMotionEvent.getPointerCount() != 2) || (this.mState != 2)) {
            break label402;
          }
          f4 = ayop.spacing(paramMotionEvent);
          f1 = ayop.b(paramMotionEvent);
          paramMotionEvent = ayop.a(paramMotionEvent);
          f2 = paramMotionEvent[0];
          f3 = paramMotionEvent[1];
          paramMotionEvent = this.e;
          float f5 = this.nG;
          paramMotionEvent.scaleValue = (f4 / this.nA * f5);
          paramMotionEvent = this.e;
          f4 = this.nH;
          paramMotionEvent.nI = ((f1 - this.nB + f4) % 360.0F);
          this.e.translateXValue = (this.nE + (f2 - this.nC));
          this.e.translateYValue = (this.nF + (f3 - this.nD));
          if (!this.e.aIn) {
            break;
          }
          if (this.e.scaleValue > this.mMaxScale) {
            this.e.scaleValue = this.mMaxScale;
          }
          if (this.e.scaleValue < this.mMinScale) {
            this.e.scaleValue = this.mMinScale;
          }
        } while (this.e.nI >= 0.0F);
        this.e.nI += 360.0F;
        return;
        this.e.scaleValue = this.nG;
        this.e.nI = this.nH;
        return;
        if ((paramMotionEvent.getPointerCount() != 1) || (this.mState != 3) || (!paramBoolean)) {
          break label654;
        }
        f2 = paramMotionEvent.getX() - this.e.centerP.x - this.e.translateXValue;
        f3 = paramMotionEvent.getY() - this.e.centerP.y - this.e.translateYValue;
        f1 = ayop.e(f2, f3);
        f2 = ayop.f(f2, f3);
        paramMotionEvent = this.e;
        f3 = this.nG;
        paramMotionEvent.scaleValue = (f1 / this.nA * f3);
        paramMotionEvent = this.e;
        f1 = this.nH;
        paramMotionEvent.nI = ((f2 - this.nB + f1) % 360.0F);
        if (!this.e.aIn) {
          break;
        }
        if (this.e.scaleValue > this.mMaxScale) {
          this.e.scaleValue = this.mMaxScale;
        }
        if (this.e.scaleValue < this.mMinScale) {
          this.e.scaleValue = this.mMinScale;
        }
      } while (this.e.nI >= 0.0F);
      this.e.nI += 360.0F;
      return;
      this.e.scaleValue = this.nG;
      this.e.nI = this.nH;
      return;
    } while ((paramMotionEvent.getPointerCount() != 1) || (this.mState != 4));
    label654:
    float f1 = paramMotionEvent.getX(0);
    float f2 = this.mStartX;
    float f3 = paramMotionEvent.getY(0);
    float f4 = this.mStartY;
    this.e.FH = (f1 - f2 + this.FS);
    this.e.FI = (f3 - f4 + this.FT);
  }
  
  public float a(ayoo.a parama)
  {
    float f = 1.0F;
    if (parama != null) {
      f = parama.scaleValue * parama.nJ;
    }
    return f;
  }
  
  public int a(ayjw.c paramc, float paramFloat1, float paramFloat2)
  {
    if (paramc == null) {
      return -1;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(paramc).mapPoints(arrayOfFloat);
    float f1 = paramc.width;
    float f2 = paramc.height;
    paramFloat2 = f1;
    if (this.aIm)
    {
      paramFloat1 = f1;
      if (paramc.scaleValue * f1 < 200.0F) {
        paramFloat1 = 200.0F / paramc.scaleValue;
      }
      paramFloat2 = paramFloat1;
      if (paramc.scaleValue * f2 < 200.0F)
      {
        paramFloat2 = 200.0F / paramc.scaleValue;
        f1 = paramFloat1;
        paramFloat1 = paramFloat2;
      }
    }
    for (;;)
    {
      return paramc.c.a(f1, paramFloat1, arrayOfFloat[0], arrayOfFloat[1]);
      paramFloat1 = f2;
      f1 = paramFloat2;
    }
  }
  
  public Matrix a(ayoo.a parama)
  {
    this.mMatrix.reset();
    if (parama == null) {
      return this.mMatrix;
    }
    this.mMatrix.postRotate(parama.nI);
    this.mMatrix.postScale(a(parama), a(parama));
    if (parama.centerP != null) {
      this.mMatrix.postTranslate(parama.centerP.x, parama.centerP.y);
    }
    this.mMatrix.postTranslate(parama.translateXValue, parama.translateYValue);
    return this.mMatrix;
  }
  
  public void a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (this.e == null) {
      return;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 0: 
      b(paramMotionEvent, paramBoolean);
      return;
    case 5: 
      P(paramMotionEvent);
      return;
    case 2: 
      c(paramMotionEvent, paramBoolean);
      return;
    case 6: 
      Q(paramMotionEvent);
      return;
    }
    N(paramMotionEvent);
  }
  
  public void a(ayoo.a parama, boolean paramBoolean)
  {
    float f4 = parama.width;
    float f3 = parama.height;
    float f2 = f3;
    float f1 = f4;
    if (paramBoolean)
    {
      f1 = f4 + parama.bsp * 2;
      f2 = f3 + parama.bsp * 2;
    }
    f4 = f2;
    float f5 = f1;
    if (this.aIm)
    {
      f3 = f1;
      if (parama.scaleValue * f1 < 200.0F) {
        f3 = 200.0F / parama.scaleValue;
      }
      f4 = f2;
      f5 = f3;
      if (parama.scaleValue * f2 < 200.0F)
      {
        f4 = 200.0F / parama.scaleValue;
        f5 = f3;
      }
    }
    f2 = f5 / 2.0F;
    f1 = f4 / 2.0F;
    f2 = -f2;
    f3 = -f1;
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = f2;
    arrayOfFloat[1] = f1;
    a(parama).mapPoints(arrayOfFloat);
    parama.FJ = arrayOfFloat[0];
    parama.FK = arrayOfFloat[1];
  }
  
  public boolean a(ayoo.a parama, float paramFloat1, float paramFloat2)
  {
    if (parama == null) {}
    float[] arrayOfFloat;
    float f2;
    do
    {
      return false;
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      c(parama).mapPoints(arrayOfFloat);
      paramFloat1 = a(parama);
      f2 = parama.width;
      float f3 = parama.bsp / paramFloat1;
      paramFloat2 = parama.height;
      float f1 = parama.bsp / paramFloat1;
      f2 = (f2 + f3 * 2.0F) / 2.0F;
      paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
      paramFloat1 = ayom.tw() / paramFloat1 / 2.0F;
    } while ((arrayOfFloat[0] < -f2 - paramFloat1 - 10.0F) || (arrayOfFloat[0] > -f2 + paramFloat1 + 10.0F) || (arrayOfFloat[1] < -paramFloat2 - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + -paramFloat2 + 10.0F));
    return true;
  }
  
  public boolean a(ayoo.a parama, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (parama == null) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(parama).mapPoints(arrayOfFloat);
    float f5 = a(parama);
    float f4 = parama.width;
    float f3 = parama.height;
    float f2 = f3;
    float f1 = f4;
    if (paramBoolean)
    {
      f1 = f4 + parama.bsp / f5 * 2.0F;
      f2 = f3 + parama.bsp / f5 * 2.0F;
    }
    f4 = f2;
    f5 = f1;
    if (this.aIm)
    {
      f3 = f1;
      if (parama.scaleValue * f1 < 200.0F) {
        f3 = 200.0F / parama.scaleValue;
      }
      f4 = f2;
      f5 = f3;
      if (parama.scaleValue * f2 < 200.0F)
      {
        f4 = 200.0F / parama.scaleValue;
        f5 = f3;
      }
    }
    f1 = f5 / 2.0F;
    f2 = f4 / 2.0F;
    f3 = -f1;
    f4 = -f2;
    f5 = ayom.tw() / a(parama) / 2.0F;
    float f6 = parama.FH / a(parama);
    f6 = parama.FI / a(parama);
    parama.dzF = false;
    if ((arrayOfFloat[0] >= f3) && (arrayOfFloat[0] <= f1) && (arrayOfFloat[1] >= f4) && (arrayOfFloat[1] <= f2)) {
      return true;
    }
    if ((arrayOfFloat[0] >= f3 - f5 - 10.0F) && (arrayOfFloat[0] <= f3 + f5 + 10.0F) && (arrayOfFloat[1] >= f4 - f5 - 10.0F) && (arrayOfFloat[1] <= f4 + f5 + 10.0F)) {
      return true;
    }
    if ((arrayOfFloat[0] >= f1 - f5 - 10.0F) && (arrayOfFloat[0] <= f1 + f5 + 10.0F) && (arrayOfFloat[1] >= f4 - f5 - 10.0F) && (arrayOfFloat[1] <= f4 + f5 + 10.0F)) {
      return true;
    }
    if ((parama.dzE) && (arrayOfFloat[0] >= f3 - f5 - 10.0F) && (arrayOfFloat[0] <= f3 + f5 + 10.0F) && (arrayOfFloat[1] >= f2 - f5 - 10.0F) && (arrayOfFloat[1] <= f2 + f5 + 10.0F))
    {
      parama.dzF = true;
      return true;
    }
    if (a(parama, paramFloat1, paramFloat2, arrayOfFloat[0], arrayOfFloat[1], paramBoolean))
    {
      parama.dzF = true;
      return true;
    }
    if ((arrayOfFloat[0] >= f1 - f5 - 10.0F) && (arrayOfFloat[0] <= f1 + f5 + 10.0F) && (arrayOfFloat[1] >= f2 - f5 - 10.0F) && (arrayOfFloat[1] <= f2 + f5 + 10.0F)) {
      return true;
    }
    return (arrayOfFloat[0] >= f3 - f5) && (arrayOfFloat[0] <= f1 + f5) && (arrayOfFloat[1] >= f4 - f5) && (arrayOfFloat[1] <= f2 + f5);
  }
  
  public boolean a(ayoo.a parama, float paramFloat, boolean paramBoolean)
  {
    if (parama == null) {}
    float[] arrayOfFloat1;
    float[] arrayOfFloat2;
    float[] arrayOfFloat3;
    float[] arrayOfFloat4;
    do
    {
      do
      {
        return false;
        float f2 = parama.width;
        float f1 = parama.height / 2.0F;
        f2 /= 2.0F;
        arrayOfFloat1 = new float[2];
        arrayOfFloat1[0] = (-f2);
        arrayOfFloat1[1] = (-f1);
        arrayOfFloat2 = new float[2];
        arrayOfFloat2[0] = f2;
        arrayOfFloat2[1] = (-f1);
        arrayOfFloat3 = new float[2];
        arrayOfFloat3[0] = (-f2);
        arrayOfFloat3[1] = f1;
        arrayOfFloat4 = new float[2];
        arrayOfFloat4[0] = f2;
        arrayOfFloat4[1] = f1;
        parama = a(parama);
        this.mMatrix = parama;
        parama.mapPoints(arrayOfFloat1);
        parama.mapPoints(arrayOfFloat2);
        parama.mapPoints(arrayOfFloat3);
        parama.mapPoints(arrayOfFloat4);
        if (QLog.isColorLevel())
        {
          parama = new StringBuilder();
          parama.append("isCloseToXLine x=").append(paramFloat).append(" leftReach=").append(paramBoolean).append("\n");
          parama.append("f[").append(arrayOfFloat1[0]).append(",").append(arrayOfFloat1[1]).append("]\n");
          parama.append("f1[").append(arrayOfFloat2[0]).append(",").append(arrayOfFloat2[1]).append("]\n");
          parama.append("f2[").append(arrayOfFloat3[0]).append(",").append(arrayOfFloat3[1]).append("]\n");
          parama.append("f3[").append(arrayOfFloat4[0]).append(",").append(arrayOfFloat4[1]).append("]\n");
          QLog.d("GestureHelper", 2, parama.toString());
        }
        if (!paramBoolean) {
          break;
        }
      } while ((arrayOfFloat1[0] > paramFloat) && (arrayOfFloat2[0] > paramFloat) && (arrayOfFloat3[0] > paramFloat) && (arrayOfFloat4[0] > paramFloat));
      return true;
    } while ((arrayOfFloat1[0] < paramFloat) && (arrayOfFloat2[0] < paramFloat) && (arrayOfFloat3[0] < paramFloat) && (arrayOfFloat4[0] < paramFloat));
    return true;
  }
  
  public Matrix b(ayoo.a parama)
  {
    this.mMatrix.reset();
    if (parama == null) {
      return this.mMatrix;
    }
    this.mMatrix.postRotate(parama.nI);
    this.mMatrix.postTranslate(parama.centerP.x, parama.centerP.y);
    this.mMatrix.postTranslate(parama.translateXValue, parama.translateYValue);
    return this.mMatrix;
  }
  
  public ayoo.a b()
  {
    return this.e;
  }
  
  public boolean b(ayoo.a parama, float paramFloat1, float paramFloat2)
  {
    if (parama == null) {}
    float[] arrayOfFloat;
    float f2;
    do
    {
      return false;
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      c(parama).mapPoints(arrayOfFloat);
      paramFloat1 = a(parama);
      f2 = parama.width;
      float f3 = parama.bsp / paramFloat1;
      paramFloat2 = parama.height;
      float f1 = parama.bsp / paramFloat1;
      f2 = (f2 + f3 * 2.0F) / 2.0F;
      paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
      paramFloat1 = ayom.tw() / paramFloat1 / 2.0F;
    } while ((arrayOfFloat[0] < f2 - paramFloat1 - 10.0F) || (arrayOfFloat[0] > f2 + paramFloat1 + 10.0F) || (arrayOfFloat[1] < paramFloat2 - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + paramFloat2 + 10.0F));
    return true;
  }
  
  public boolean b(ayoo.a parama, float paramFloat, boolean paramBoolean)
  {
    if (parama == null) {}
    float[] arrayOfFloat1;
    float[] arrayOfFloat2;
    float[] arrayOfFloat3;
    float[] arrayOfFloat4;
    do
    {
      do
      {
        return false;
        float f2 = parama.width;
        float f1 = parama.height / 2.0F;
        f2 /= 2.0F;
        arrayOfFloat1 = new float[2];
        arrayOfFloat1[0] = (-f2);
        arrayOfFloat1[1] = (-f1);
        arrayOfFloat2 = new float[2];
        arrayOfFloat2[0] = f2;
        arrayOfFloat2[1] = (-f1);
        arrayOfFloat3 = new float[2];
        arrayOfFloat3[0] = (-f2);
        arrayOfFloat3[1] = f1;
        arrayOfFloat4 = new float[2];
        arrayOfFloat4[0] = f2;
        arrayOfFloat4[1] = f1;
        parama = a(parama);
        this.mMatrix = parama;
        parama.mapPoints(arrayOfFloat1);
        parama.mapPoints(arrayOfFloat2);
        parama.mapPoints(arrayOfFloat3);
        parama.mapPoints(arrayOfFloat4);
        if (QLog.isColorLevel())
        {
          parama = new StringBuilder();
          parama.append("isCloseToYLine y=").append(paramFloat).append(" topReach=").append(paramBoolean).append("\n");
          parama.append("f[").append(arrayOfFloat1[0]).append(",").append(arrayOfFloat1[1]).append("]\n");
          parama.append("f1[").append(arrayOfFloat2[0]).append(",").append(arrayOfFloat2[1]).append("]\n");
          parama.append("f2[").append(arrayOfFloat3[0]).append(",").append(arrayOfFloat3[1]).append("]\n");
          parama.append("f3[").append(arrayOfFloat4[0]).append(",").append(arrayOfFloat4[1]).append("]\n");
          QLog.d("GestureHelper", 2, parama.toString());
        }
        if (!paramBoolean) {
          break;
        }
      } while ((arrayOfFloat1[1] > paramFloat) && (arrayOfFloat2[1] > paramFloat) && (arrayOfFloat3[1] > paramFloat) && (arrayOfFloat4[1] > paramFloat));
      return true;
    } while ((arrayOfFloat1[1] < paramFloat) && (arrayOfFloat2[1] < paramFloat) && (arrayOfFloat3[1] < paramFloat) && (arrayOfFloat4[1] < paramFloat));
    return true;
  }
  
  public Matrix c(ayoo.a parama)
  {
    this.C.reset();
    if (parama == null) {
      return this.C;
    }
    this.mMatrix = a(parama);
    this.mMatrix.invert(this.C);
    return this.C;
  }
  
  public boolean c(ayoo.a parama, float paramFloat1, float paramFloat2)
  {
    if (parama == null) {}
    float[] arrayOfFloat;
    do
    {
      return false;
      if ((!parama.isAnchor) || (!parama.dzH)) {
        break;
      }
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      paramFloat1 = ayom.tw() / 2.0F;
    } while ((arrayOfFloat[0] < parama.FJ + parama.FH - paramFloat1 - 10.0F) || (arrayOfFloat[0] > parama.FJ + parama.FH + paramFloat1 + 10.0F) || (arrayOfFloat[1] < parama.FK + parama.FI - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + (parama.FK + parama.FI) + 10.0F));
    return true;
    return d(parama, paramFloat1, paramFloat2);
  }
  
  public boolean d(ayoo.a parama, float paramFloat1, float paramFloat2)
  {
    if (parama == null) {}
    float[] arrayOfFloat;
    float f2;
    do
    {
      return false;
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      c(parama).mapPoints(arrayOfFloat);
      paramFloat1 = a(parama);
      f2 = parama.width;
      float f3 = parama.bsp / paramFloat1;
      paramFloat2 = parama.height;
      float f1 = parama.bsp / paramFloat1;
      f2 = (f2 + f3 * 2.0F) / 2.0F;
      paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
      paramFloat1 = ayom.tw() / paramFloat1 / 2.0F;
    } while ((arrayOfFloat[0] < -f2 - paramFloat1 - 10.0F) || (arrayOfFloat[0] > -f2 + paramFloat1 + 10.0F) || (arrayOfFloat[1] < paramFloat2 - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + paramFloat2 + 10.0F));
    return true;
  }
  
  public boolean e(ayoo.a parama, float paramFloat1, float paramFloat2)
  {
    if (parama == null) {}
    float[] arrayOfFloat;
    float f2;
    do
    {
      return false;
      arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramFloat1;
      arrayOfFloat[1] = paramFloat2;
      c(parama).mapPoints(arrayOfFloat);
      paramFloat1 = a(parama);
      f2 = parama.width;
      float f3 = parama.bsp / paramFloat1;
      paramFloat2 = parama.height;
      float f1 = parama.bsp / paramFloat1;
      f2 = (f2 + f3 * 2.0F) / 2.0F;
      paramFloat2 = (paramFloat2 + f1 * 2.0F) / 2.0F;
      paramFloat1 = ayom.tw() / paramFloat1 / 2.0F;
    } while ((arrayOfFloat[0] < f2 - paramFloat1 - 10.0F) || (arrayOfFloat[0] > f2 + paramFloat1 + 10.0F) || (arrayOfFloat[1] < -paramFloat2 - paramFloat1 - 10.0F) || (arrayOfFloat[1] > paramFloat1 + -paramFloat2 + 10.0F));
    return true;
  }
  
  public void l(ayoo.a parama)
  {
    reset();
    this.e = parama;
  }
  
  public void m(ayoo.a parama)
  {
    if ((parama == null) || (parama.um == null)) {
      return;
    }
    Matrix localMatrix = c(parama);
    float[] arrayOfFloat1 = new float[2];
    float[] arrayOfFloat2 = new float[2];
    float[] arrayOfFloat3 = new float[2];
    float[] arrayOfFloat4 = new float[2];
    float f4 = 0.0F;
    arrayOfFloat1[0] = aykb.bqQ;
    arrayOfFloat1[1] = aykb.bqS;
    arrayOfFloat2[0] = aykb.bqQ;
    arrayOfFloat2[1] = aykb.bqT;
    arrayOfFloat3[0] = aykb.bqR;
    arrayOfFloat3[1] = aykb.bqS;
    arrayOfFloat4[0] = aykb.bqR;
    arrayOfFloat4[1] = aykb.bqT;
    localMatrix.mapPoints(arrayOfFloat1);
    localMatrix.mapPoints(arrayOfFloat2);
    localMatrix.mapPoints(arrayOfFloat3);
    localMatrix.mapPoints(arrayOfFloat4);
    int i;
    int j;
    label164:
    int k;
    label179:
    int m;
    if (arrayOfFloat2[0] == arrayOfFloat1[0])
    {
      i = 1;
      if (arrayOfFloat4[0] != arrayOfFloat3[0]) {
        break label635;
      }
      j = 1;
      if (arrayOfFloat1[0] != arrayOfFloat3[0]) {
        break label641;
      }
      k = 1;
      if (arrayOfFloat2[0] != arrayOfFloat4[0]) {
        break label647;
      }
      m = 1;
      label194:
      if ((i != 0) && (arrayOfFloat2[0] <= parama.eMw - parama.width / 2.0F) && (arrayOfFloat2[0] >= parama.eMv - parama.width / 2.0F)) {
        QLog.d("GestureHelper", 1, "checkEdge result, LEFT");
      }
      if ((j != 0) && (arrayOfFloat3[0] <= parama.eMw - parama.width / 2.0F) && (arrayOfFloat3[0] >= parama.eMv - parama.width / 2.0F)) {
        QLog.d("GestureHelper", 1, "checkEdge result, RIGHT");
      }
      if ((k != 0) && (arrayOfFloat1[0] <= parama.eMw - parama.width / 2.0F) && (arrayOfFloat1[0] >= parama.eMv - parama.width / 2.0F)) {
        QLog.d("GestureHelper", 1, "checkEdge result, TOP");
      }
      if ((m != 0) && (arrayOfFloat2[0] <= parama.eMw - parama.width / 2.0F) && (arrayOfFloat2[0] >= parama.eMv - parama.width / 2.0F)) {
        QLog.d("GestureHelper", 1, "checkEdge result, BOTTOM");
      }
      if (i != 0) {
        break label894;
      }
    }
    label635:
    label894:
    for (float f1 = (arrayOfFloat2[1] - arrayOfFloat1[1]) / (arrayOfFloat2[0] - arrayOfFloat1[0]);; f1 = 0.0F)
    {
      if (j == 0) {}
      for (float f2 = (arrayOfFloat4[1] - arrayOfFloat3[1]) / (arrayOfFloat4[0] - arrayOfFloat3[0]);; f2 = 0.0F)
      {
        if (k == 0) {}
        for (float f3 = (arrayOfFloat1[1] - arrayOfFloat3[1]) / (arrayOfFloat1[0] - arrayOfFloat3[0]);; f3 = 0.0F)
        {
          if (m == 0) {
            f4 = (arrayOfFloat2[1] - arrayOfFloat4[1]) / (arrayOfFloat2[0] - arrayOfFloat4[0]);
          }
          int n = 0;
          for (;;)
          {
            if (n >= parama.width) {
              break label881;
            }
            float f5 = parama.um[(n * 2)];
            float f6 = parama.um[(n * 2 + 1)];
            int i1;
            if (i == 0)
            {
              i1 = (int)((n - parama.width / 2.0F - arrayOfFloat1[0]) * f1 + arrayOfFloat1[1]);
              if ((i1 >= f5 - parama.height / 2.0F) && (i1 <= f6 - parama.height / 2.0F))
              {
                QLog.d("GestureHelper", 1, "checkEdge result, LEFT");
                return;
                i = 0;
                break;
                j = 0;
                break label164;
                k = 0;
                break label179;
                m = 0;
                break label194;
              }
            }
            if (j == 0)
            {
              i1 = (int)((n - parama.width / 2.0F - arrayOfFloat3[0]) * f2 + arrayOfFloat3[1]);
              if ((i1 >= f5 - parama.height / 2.0F) && (i1 <= f6 - parama.height / 2.0F))
              {
                QLog.d("GestureHelper", 1, "checkEdge result, RIGHT");
                return;
              }
            }
            if (k == 0)
            {
              i1 = (int)((n - parama.width / 2.0F - arrayOfFloat3[0]) * f3 + arrayOfFloat3[1]);
              if ((i1 >= f5 - parama.height / 2.0F) && (i1 <= f6 - parama.height / 2.0F))
              {
                QLog.d("GestureHelper", 1, "checkEdge result, TOP");
                return;
              }
            }
            if (m == 0)
            {
              i1 = (int)((n - parama.width / 2.0F - arrayOfFloat4[0]) * f4 + arrayOfFloat4[1]);
              if ((i1 >= f5 - parama.height / 2.0F) && (i1 <= f6 - parama.height / 2.0F))
              {
                QLog.d("GestureHelper", 1, "checkEdge result, BOTTOM");
                return;
              }
            }
            n += 1;
          }
          break;
        }
      }
    }
  }
  
  public void reset()
  {
    this.e = null;
    this.mStartX = 0.0F;
    this.mStartY = 0.0F;
    this.nA = 0.0F;
    this.nB = 0.0F;
    this.nC = 0.0F;
    this.nD = 0.0F;
    this.nE = 0.0F;
    this.nF = 0.0F;
    this.nG = 0.0F;
    this.nH = 0.0F;
    this.FS = 0.0F;
    this.FT = 0.0F;
    this.aIk = false;
    this.aIl = false;
    this.mMatrix.reset();
    this.C.reset();
  }
  
  public void setMaxScale(float paramFloat)
  {
    if (paramFloat >= 0.0F) {
      this.mMaxScale = paramFloat;
    }
  }
  
  public void setMinScale(float paramFloat)
  {
    if (paramFloat >= 0.0F) {
      this.mMinScale = paramFloat;
    }
  }
  
  public void tP(boolean paramBoolean)
  {
    this.aIm = paramBoolean;
  }
  
  public static abstract class a
    extends aykh
  {
    public ValueAnimator N;
    public boolean aHC;
    public boolean aIn = true;
    public boolean aIo;
    public boolean aIp;
    public boolean aIq;
    public int ajB = -1;
    public int bsp;
    public PointF centerP;
    public boolean dAg;
    public int eMv = -1;
    public int eMw = -1;
    public float height;
    public SegmentKeeper mSegmentKeeper = new SegmentKeeper();
    public float nI;
    public float nJ = 1.0F;
    public float scaleValue = 1.0F;
    public float translateXValue;
    public float translateYValue;
    public int[] um;
    public float width;
    
    public a() {}
    
    public a(@NonNull PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
    {
      this.centerP = new PointF(paramPointF.x, paramPointF.y);
      this.scaleValue = paramFloat1;
      this.nI = paramFloat2;
      this.translateXValue = paramFloat3;
      this.translateYValue = paramFloat4;
      this.width = paramFloat5;
      this.height = paramFloat6;
      this.aIn = paramBoolean;
      this.dAg = Build.MODEL.equals("MI 5C");
    }
    
    public a(a parama, float paramFloat)
    {
      this.centerP = new PointF(parama.centerP.x * paramFloat, parama.centerP.y * paramFloat);
      parama.scaleValue *= paramFloat;
      this.nI = parama.nI;
      parama.translateXValue *= paramFloat;
      parama.translateYValue *= paramFloat;
      this.width = parama.width;
      this.height = parama.height;
      this.aIn = parama.aIn;
      this.mSegmentKeeper.set(parama.mSegmentKeeper);
    }
    
    public boolean aQT()
    {
      return !this.mSegmentKeeper.isEmpty();
    }
    
    public void draw(Canvas paramCanvas) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayoo
 * JD-Core Version:    0.7.0.1
 */