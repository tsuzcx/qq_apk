import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;

public class yvo
{
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int = 0;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private yvp jdField_a_of_type_Yvp;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int = 1;
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int = 2;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private final int jdField_d_of_type_Int = 3;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int = 0;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k = 2.147484E+009F;
  private float l;
  
  private void a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getX(1);
    paramMotionEvent.getY(1);
    if (this.jdField_e_of_type_Int == 1)
    {
      this.jdField_e_of_type_Int = 2;
      this.i = this.jdField_a_of_type_Yvp.j;
      this.j = this.jdField_a_of_type_Yvp.k;
      this.g = this.jdField_a_of_type_Yvp.l;
      this.h = this.jdField_a_of_type_Yvp.m;
      this.jdField_c_of_type_Float = yvq.a(paramMotionEvent);
      this.jdField_d_of_type_Float = yvq.b(paramMotionEvent);
      paramMotionEvent = yvq.a(paramMotionEvent);
      this.jdField_e_of_type_Float = paramMotionEvent[0];
      this.f = paramMotionEvent[1];
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if (this.jdField_e_of_type_Int == 2)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_e_of_type_Int = 1;
    }
  }
  
  private void b(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_e_of_type_Int = 1;
    float f2 = paramMotionEvent.getX(0);
    float f1 = paramMotionEvent.getY(0);
    this.jdField_a_of_type_Float = f2;
    this.jdField_b_of_type_Float = f1;
    this.g = this.jdField_a_of_type_Yvp.l;
    this.h = this.jdField_a_of_type_Yvp.m;
    if ((a(this.jdField_a_of_type_Yvp, f2, f1)) && (paramBoolean))
    {
      this.jdField_e_of_type_Int = 3;
      this.i = this.jdField_a_of_type_Yvp.j;
      this.j = this.jdField_a_of_type_Yvp.k;
      f2 = f2 - this.jdField_a_of_type_Yvp.a.x - this.jdField_a_of_type_Yvp.l;
      f1 = f1 - this.jdField_a_of_type_Yvp.a.y - this.jdField_a_of_type_Yvp.m;
      this.jdField_c_of_type_Float = yvq.a(f2, f1);
      this.jdField_d_of_type_Float = yvq.b(f2, f1);
      this.jdField_e_of_type_Float = this.jdField_a_of_type_Yvp.a.x;
      this.f = this.jdField_a_of_type_Yvp.a.y;
    }
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    this.jdField_e_of_type_Int = 0;
    a();
  }
  
  private void c(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      b(paramMotionEvent, paramBoolean);
    }
    label394:
    do
    {
      do
      {
        do
        {
          return;
          if ((paramMotionEvent.getPointerCount() == 1) && (this.jdField_e_of_type_Int == 1))
          {
            if (this.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_Boolean = false;
              this.jdField_a_of_type_Float = paramMotionEvent.getX(0);
              this.jdField_b_of_type_Float = paramMotionEvent.getY(0);
              this.g = this.jdField_a_of_type_Yvp.l;
              this.h = this.jdField_a_of_type_Yvp.m;
              return;
            }
            f1 = paramMotionEvent.getX(0);
            f2 = this.jdField_a_of_type_Float;
            f3 = paramMotionEvent.getY(0);
            f4 = this.jdField_b_of_type_Float;
            this.jdField_a_of_type_Yvp.l = (f1 - f2 + this.g);
            this.jdField_a_of_type_Yvp.m = (f3 - f4 + this.h);
            return;
          }
          if ((paramMotionEvent.getPointerCount() != 2) || (this.jdField_e_of_type_Int != 2)) {
            break label394;
          }
          float f4 = yvq.a(paramMotionEvent);
          f1 = yvq.b(paramMotionEvent);
          paramMotionEvent = yvq.a(paramMotionEvent);
          f2 = paramMotionEvent[0];
          f3 = paramMotionEvent[1];
          paramMotionEvent = this.jdField_a_of_type_Yvp;
          float f5 = this.i;
          paramMotionEvent.j = (f4 / this.jdField_c_of_type_Float * f5);
          paramMotionEvent = this.jdField_a_of_type_Yvp;
          f4 = this.j;
          paramMotionEvent.k = ((f1 - this.jdField_d_of_type_Float + f4) % 360.0F);
          this.jdField_a_of_type_Yvp.l = (this.g + (f2 - this.jdField_e_of_type_Float));
          this.jdField_a_of_type_Yvp.m = (this.h + (f3 - this.f));
          if (!this.jdField_a_of_type_Yvp.jdField_b_of_type_Boolean) {
            break;
          }
          if (this.jdField_a_of_type_Yvp.j > this.k) {
            this.jdField_a_of_type_Yvp.j = this.k;
          }
          if (this.jdField_a_of_type_Yvp.j < this.l) {
            this.jdField_a_of_type_Yvp.j = this.l;
          }
        } while (this.jdField_a_of_type_Yvp.k >= 0.0F);
        this.jdField_a_of_type_Yvp.k += 360.0F;
        return;
        this.jdField_a_of_type_Yvp.j = this.i;
        this.jdField_a_of_type_Yvp.k = this.j;
        return;
      } while ((paramMotionEvent.getPointerCount() != 1) || (this.jdField_e_of_type_Int != 3) || (!paramBoolean));
      float f2 = paramMotionEvent.getX() - this.jdField_a_of_type_Yvp.a.x - this.jdField_a_of_type_Yvp.l;
      float f3 = paramMotionEvent.getY() - this.jdField_a_of_type_Yvp.a.y - this.jdField_a_of_type_Yvp.m;
      float f1 = yvq.a(f2, f3);
      f2 = yvq.b(f2, f3);
      paramMotionEvent = this.jdField_a_of_type_Yvp;
      f3 = this.i;
      paramMotionEvent.j = (f1 / this.jdField_c_of_type_Float * f3);
      paramMotionEvent = this.jdField_a_of_type_Yvp;
      f1 = this.j;
      paramMotionEvent.k = ((f2 - this.jdField_d_of_type_Float + f1) % 360.0F);
      if (!this.jdField_a_of_type_Yvp.jdField_b_of_type_Boolean) {
        break;
      }
      if (this.jdField_a_of_type_Yvp.j > this.k) {
        this.jdField_a_of_type_Yvp.j = this.k;
      }
      if (this.jdField_a_of_type_Yvp.j < this.l) {
        this.jdField_a_of_type_Yvp.j = this.l;
      }
    } while (this.jdField_a_of_type_Yvp.k >= 0.0F);
    this.jdField_a_of_type_Yvp.k += 360.0F;
    return;
    this.jdField_a_of_type_Yvp.j = this.i;
    this.jdField_a_of_type_Yvp.k = this.j;
  }
  
  public float a(yvp paramyvp)
  {
    float f1 = 1.0F;
    if (paramyvp != null) {
      f1 = paramyvp.j * paramyvp.p;
    }
    return f1;
  }
  
  public Matrix a(yvp paramyvp)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    if (paramyvp == null) {
      return this.jdField_a_of_type_AndroidGraphicsMatrix;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(paramyvp.k);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(a(paramyvp), a(paramyvp));
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(paramyvp.a.x, paramyvp.a.y);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(paramyvp.l, paramyvp.m);
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Yvp = null;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_d_of_type_Float = 0.0F;
    this.jdField_e_of_type_Float = 0.0F;
    this.f = 0.0F;
    this.g = 0.0F;
    this.h = 0.0F;
    this.i = 0.0F;
    this.j = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat >= 0.0F) {
      this.k = paramFloat;
    }
  }
  
  public void a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Yvp == null) {
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
      a(paramMotionEvent);
      return;
    case 2: 
      c(paramMotionEvent, paramBoolean);
      return;
    case 6: 
      b(paramMotionEvent);
      return;
    }
    c(paramMotionEvent);
  }
  
  public void a(yvp paramyvp)
  {
    a();
    this.jdField_a_of_type_Yvp = paramyvp;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(yvp paramyvp, float paramFloat1, float paramFloat2)
  {
    if (paramyvp == null) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(paramyvp).mapPoints(arrayOfFloat);
    float f1 = paramyvp.n;
    float f2 = paramyvp.jdField_e_of_type_Int * 2;
    paramFloat1 = paramyvp.o;
    paramFloat2 = paramyvp.jdField_e_of_type_Int * 2;
    f1 = (f1 + f2) / 2.0F;
    paramFloat1 = (paramFloat1 + paramFloat2) / 2.0F;
    paramFloat2 = DisplayUtil.getStickerButtonSize() / a(paramyvp) / 2.0F;
    int m = 10;
    if (paramyvp.j > 2.5F) {
      m = 20;
    }
    return (arrayOfFloat[0] >= f1 - paramFloat2 - m) && (arrayOfFloat[0] <= f1 + paramFloat2 + m) && (arrayOfFloat[1] >= paramFloat1 - paramFloat2 - m) && (arrayOfFloat[1] <= m + (paramFloat1 + paramFloat2));
  }
  
  public boolean a(yvp paramyvp, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramyvp == null) {
      return false;
    }
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = paramFloat1;
    arrayOfFloat1[1] = paramFloat2;
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = paramFloat3;
    arrayOfFloat2[1] = paramFloat4;
    Matrix localMatrix = c(paramyvp);
    localMatrix.mapPoints(arrayOfFloat1);
    localMatrix.mapPoints(arrayOfFloat2);
    paramFloat3 = paramyvp.n;
    paramFloat4 = paramyvp.o;
    paramFloat2 = paramFloat3;
    if (this.jdField_c_of_type_Boolean)
    {
      paramFloat1 = paramFloat3;
      if (paramyvp.j * paramFloat3 < 200.0F) {
        paramFloat1 = 200.0F / paramyvp.j;
      }
      paramFloat2 = paramFloat1;
      if (paramyvp.j * paramFloat4 < 200.0F)
      {
        paramFloat2 = 200.0F / paramyvp.j;
        paramFloat3 = paramFloat1;
        paramFloat1 = paramFloat2;
      }
    }
    for (;;)
    {
      paramFloat2 = paramFloat3 / 2.0F;
      paramFloat1 /= 2.0F;
      paramyvp = new RectF(-paramFloat2, -paramFloat1, paramFloat2, paramFloat1);
      return yvq.a(new PointF(arrayOfFloat1[0], arrayOfFloat1[1]), new PointF(arrayOfFloat2[0], arrayOfFloat2[1]), paramyvp);
      paramFloat1 = paramFloat4;
      paramFloat3 = paramFloat2;
    }
  }
  
  public boolean a(yvp paramyvp, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramyvp == null) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(paramyvp).mapPoints(arrayOfFloat);
    float f2 = paramyvp.n;
    float f1 = paramyvp.o;
    paramFloat2 = f1;
    paramFloat1 = f2;
    if (paramBoolean)
    {
      paramFloat1 = f2 + paramyvp.jdField_e_of_type_Int * 2;
      paramFloat2 = f1 + paramyvp.jdField_e_of_type_Int * 2;
    }
    f2 = paramFloat2;
    float f3 = paramFloat1;
    if (this.jdField_c_of_type_Boolean)
    {
      f1 = paramFloat1;
      if (paramyvp.j * paramFloat1 < 200.0F) {
        f1 = 200.0F / paramyvp.j;
      }
      f2 = paramFloat2;
      f3 = f1;
      if (paramyvp.j * paramFloat2 < 200.0F)
      {
        f2 = 200.0F / paramyvp.j;
        f3 = f1;
      }
    }
    paramFloat1 = f3 / 2.0F;
    paramFloat2 = f2 / 2.0F;
    f1 = -paramFloat1;
    f2 = -paramFloat2;
    f3 = DisplayUtil.getStickerButtonSize() / a(paramyvp) / 2.0F;
    if ((arrayOfFloat[0] >= f1) && (arrayOfFloat[0] <= paramFloat1) && (arrayOfFloat[1] >= f2) && (arrayOfFloat[1] <= paramFloat2)) {
      return true;
    }
    if ((arrayOfFloat[0] >= f1 - f3 - 10.0F) && (arrayOfFloat[0] <= f1 + f3 + 10.0F) && (arrayOfFloat[1] >= f2 - f3 - 10.0F) && (arrayOfFloat[1] <= f2 + f3 + 10.0F)) {
      return true;
    }
    if ((arrayOfFloat[0] >= paramFloat1 - f3 - 10.0F) && (arrayOfFloat[0] <= paramFloat1 + f3 + 10.0F) && (arrayOfFloat[1] >= f2 - f3 - 10.0F) && (arrayOfFloat[1] <= f2 + f3 + 10.0F)) {
      return true;
    }
    if ((arrayOfFloat[0] >= f1 - f3 - 10.0F) && (arrayOfFloat[0] <= f1 + f3 + 10.0F) && (arrayOfFloat[1] >= paramFloat2 - f3 - 10.0F) && (arrayOfFloat[1] <= paramFloat2 + f3 + 10.0F)) {
      return true;
    }
    if ((arrayOfFloat[0] >= paramFloat1 - f3 - 10.0F) && (arrayOfFloat[0] <= paramFloat1 + f3 + 10.0F) && (arrayOfFloat[1] >= paramFloat2 - f3 - 10.0F) && (arrayOfFloat[1] <= paramFloat2 + f3 + 10.0F)) {
      return true;
    }
    return (arrayOfFloat[0] >= f1 - f3) && (arrayOfFloat[0] <= paramFloat1 + f3) && (arrayOfFloat[1] >= f2 - f3) && (arrayOfFloat[1] <= paramFloat2 + f3);
  }
  
  public Matrix b(yvp paramyvp)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    if (paramyvp == null) {
      return this.jdField_a_of_type_AndroidGraphicsMatrix;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(paramyvp.k);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(paramyvp.a.x, paramyvp.a.y);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(paramyvp.l, paramyvp.m);
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
  
  public void b(float paramFloat)
  {
    if (paramFloat >= 0.0F) {
      this.l = paramFloat;
    }
  }
  
  public void b(yvp paramyvp)
  {
    if (paramyvp == null) {
      return;
    }
    paramyvp.j = 1.0F;
    paramyvp.l = 0.0F;
    paramyvp.m = 0.0F;
    paramyvp.k = 0.0F;
  }
  
  public boolean b(yvp paramyvp, float paramFloat1, float paramFloat2)
  {
    if (paramyvp == null) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    c(paramyvp).mapPoints(arrayOfFloat);
    float f1 = paramyvp.n;
    float f2 = paramyvp.jdField_e_of_type_Int * 2;
    paramFloat1 = paramyvp.o;
    paramFloat2 = paramyvp.jdField_e_of_type_Int * 2;
    f1 = (f1 + f2) / 2.0F;
    paramFloat2 = (paramFloat1 + paramFloat2) / 2.0F;
    paramFloat1 = DisplayUtil.getStickerButtonSize() / a(paramyvp) / 2.0F;
    int m = 10;
    if (paramyvp.j > 2.5F) {
      m = 20;
    }
    if ((arrayOfFloat[0] >= f1 - paramFloat1 - m) && (arrayOfFloat[0] <= f1 + paramFloat1 + m) && (arrayOfFloat[1] >= -paramFloat2 - paramFloat1 - m))
    {
      f1 = arrayOfFloat[1];
      paramFloat2 = -paramFloat2;
      if (f1 <= m + (paramFloat2 + paramFloat1)) {
        return true;
      }
    }
    return false;
  }
  
  public Matrix c(yvp paramyvp)
  {
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
    if (paramyvp == null) {
      return this.jdField_b_of_type_AndroidGraphicsMatrix;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix = a(paramyvp);
    this.jdField_a_of_type_AndroidGraphicsMatrix.invert(this.jdField_b_of_type_AndroidGraphicsMatrix);
    return this.jdField_b_of_type_AndroidGraphicsMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     yvo
 * JD-Core Version:    0.7.0.1
 */