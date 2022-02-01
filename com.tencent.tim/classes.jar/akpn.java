import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mobileqq.ocr.view.gesture.Settings;

public class akpn
{
  private static final PointF Z = new PointF();
  private static final RectF aI;
  private static final Rect bF;
  private static final akpm e = new akpm();
  private static final Point m;
  private final akpk jdField_a_of_type_Akpk;
  private final Settings jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings;
  private final akpi b;
  private boolean ctT = true;
  private float yf;
  
  static
  {
    bF = new Rect();
    aI = new RectF();
    m = new Point();
  }
  
  public akpn(Settings paramSettings)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings = paramSettings;
    this.jdField_a_of_type_Akpk = new akpk(paramSettings);
    this.b = new akpi(paramSettings);
  }
  
  private float b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if (paramFloat5 == 1.0F) {}
    for (;;)
    {
      return paramFloat1;
      float f = paramFloat3 / paramFloat5;
      if ((paramFloat1 < paramFloat3) && (paramFloat1 < paramFloat2)) {
        paramFloat3 = (paramFloat3 - paramFloat1) / (paramFloat3 - f);
      }
      while (paramFloat3 != 0.0F)
      {
        return paramFloat1 + (float)Math.sqrt(paramFloat3) * (paramFloat2 - paramFloat1);
        if ((paramFloat1 > paramFloat4) && (paramFloat1 > paramFloat2)) {
          paramFloat3 = (paramFloat1 - paramFloat4) / (paramFloat4 * paramFloat5 - paramFloat4);
        } else {
          paramFloat3 = 0.0F;
        }
      }
    }
  }
  
  private float c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    float f1 = 1.0F;
    if (paramFloat5 == 0.0F) {}
    for (;;)
    {
      return paramFloat1;
      float f2 = (paramFloat1 + paramFloat2) * 0.5F;
      if ((f2 < paramFloat3) && (paramFloat1 < paramFloat2)) {
        paramFloat3 = (paramFloat3 - f2) / paramFloat5;
      }
      while (paramFloat3 != 0.0F)
      {
        if (paramFloat3 > 1.0F) {
          paramFloat3 = f1;
        }
        for (;;)
        {
          return paramFloat1 - (float)Math.sqrt(paramFloat3) * (paramFloat1 - paramFloat2);
          if ((f2 <= paramFloat4) || (paramFloat1 <= paramFloat2)) {
            break label98;
          }
          paramFloat3 = (f2 - paramFloat4) / paramFloat5;
          break;
        }
        label98:
        paramFloat3 = 0.0F;
      }
    }
  }
  
  public akpm a(akpm paramakpm, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Akpk.a(paramakpm);
    float f2 = this.jdField_a_of_type_Akpk.bo();
    float f1;
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.bi() > 0.0F)
    {
      f1 = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.bi();
      if (paramakpm.getZoom() >= 0.5F * (f2 + f1)) {
        break label82;
      }
    }
    for (;;)
    {
      paramakpm = paramakpm.b();
      paramakpm.d(f1, paramFloat1, paramFloat2);
      return paramakpm;
      f1 = this.jdField_a_of_type_Akpk.getMaxZoom();
      break;
      label82:
      f1 = f2;
    }
  }
  
  public akpm a(akpm paramakpm1, akpm paramakpm2, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    e.c(paramakpm1);
    if (a(e, paramakpm2, paramFloat1, paramFloat2, paramBoolean1, paramBoolean2, paramBoolean3)) {
      return e.b();
    }
    return null;
  }
  
  public void a(akpm paramakpm, RectF paramRectF)
  {
    this.b.a(paramakpm).d(paramRectF);
  }
  
  public boolean a(akpm paramakpm1, akpm paramakpm2, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.asp()) {
      return false;
    }
    float f2;
    float f1;
    if (!Float.isNaN(paramFloat1))
    {
      f2 = paramFloat1;
      f1 = paramFloat2;
      if (!Float.isNaN(paramFloat2)) {}
    }
    else
    {
      akpo.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings, m);
      f2 = m.x;
      f1 = m.y;
    }
    if ((paramBoolean3) && (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.asl()))
    {
      paramFloat1 = Math.round(paramakpm1.getRotation() / 90.0F) * 90.0F;
      if (!akpm.equals(paramFloat1, paramakpm1.getRotation())) {
        paramakpm1.m(paramFloat1, f2, f1);
      }
    }
    label233:
    label491:
    label500:
    for (paramBoolean3 = true;; paramBoolean3 = false)
    {
      this.jdField_a_of_type_Akpk.a(paramakpm1);
      float f5 = this.jdField_a_of_type_Akpk.bh();
      float f4 = this.jdField_a_of_type_Akpk.getMaxZoom();
      float f3;
      if (paramBoolean2)
      {
        paramFloat1 = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.bj();
        f3 = this.jdField_a_of_type_Akpk.k(paramakpm1.getZoom(), paramFloat1);
        paramFloat2 = f3;
        if (paramakpm2 != null) {
          paramFloat2 = b(f3, paramakpm2.getZoom(), f5, f4, paramFloat1);
        }
        if (akpm.equals(paramFloat2, paramakpm1.getZoom())) {
          break label510;
        }
        paramakpm1.d(paramFloat2, f2, f1);
      }
      label247:
      label510:
      for (paramBoolean2 = true;; paramBoolean2 = paramBoolean3)
      {
        if (paramBoolean1)
        {
          f1 = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.bk();
          if (!paramBoolean1) {
            break label491;
          }
          f2 = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.bl();
          this.b.a(paramakpm1);
          this.b.a(paramakpm1.getX(), paramakpm1.getY(), f1, f2, Z);
          f4 = Z.x;
          f3 = Z.y;
          if (paramFloat2 >= f5) {
            break label500;
          }
          paramFloat1 = (float)Math.sqrt((paramFloat2 * paramFloat1 / f5 - 1.0F) / (paramFloat1 - 1.0F));
          this.b.a(f4, f3, Z);
          paramFloat2 = Z.x;
          f5 = Z.y;
          paramFloat2 += (f4 - paramFloat2) * paramFloat1;
        }
        for (paramFloat1 = (f3 - f5) * paramFloat1 + f5;; paramFloat1 = f3)
        {
          f4 = paramFloat1;
          f3 = paramFloat2;
          if (paramakpm2 != null)
          {
            this.b.d(aI);
            f3 = c(paramFloat2, paramakpm2.getX(), aI.left, aI.right, f1);
            f4 = c(paramFloat1, paramakpm2.getY(), aI.top, aI.bottom, f2);
          }
          if ((!akpm.equals(f3, paramakpm1.getX())) || (!akpm.equals(f4, paramakpm1.getY())))
          {
            paramakpm1.W(f3, f4);
            return true;
            paramFloat1 = 1.0F;
            break;
            f1 = 0.0F;
            break label233;
            f2 = 0.0F;
            break label247;
          }
          return paramBoolean2;
          paramFloat2 = f4;
        }
      }
    }
  }
  
  public boolean b(akpm paramakpm)
  {
    this.ctT = true;
    return c(paramakpm);
  }
  
  public boolean c(akpm paramakpm)
  {
    if (this.ctT)
    {
      paramakpm.set(0.0F, 0.0F, this.jdField_a_of_type_Akpk.a(paramakpm).bo(), 0.0F);
      akpo.a(paramakpm, this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings, bF);
      paramakpm.W(bF.left, bF.top);
      if ((!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.asq()) || (!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.asr())) {}
      for (boolean bool = true;; bool = false)
      {
        this.ctT = bool;
        if (this.ctT) {
          break;
        }
        return true;
      }
      return false;
    }
    a(paramakpm, paramakpm, (0.0F / 0.0F), (0.0F / 0.0F), false, false, true);
    return false;
  }
  
  public void d(akpm paramakpm)
  {
    if (this.yf > 0.0F) {
      paramakpm.set(paramakpm.getX(), paramakpm.getY(), paramakpm.getZoom() * this.yf, paramakpm.getRotation());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akpn
 * JD-Core Version:    0.7.0.1
 */