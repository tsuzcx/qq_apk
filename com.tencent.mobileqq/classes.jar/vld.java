import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

@TargetApi(14)
public class vld
  extends vlj
{
  public static int a;
  public static final int b;
  public static int c;
  public static int d = 270;
  public final long a;
  public Paint a;
  public vle a;
  public vlf a;
  public vpr a;
  public boolean a;
  private vlf b;
  public int e;
  public int f;
  public int g;
  public int h = jdField_b_of_type_Int;
  public int i;
  public int j;
  public int k;
  
  static
  {
    jdField_b_of_type_Int = Color.parseColor("#80000000");
  }
  
  public vld(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Long = 270L;
    e();
  }
  
  private void b(int paramInt)
  {
    veg.b("TextLayer", "setMode:" + paramInt + ",preMode:" + this.f);
    this.f = this.e;
    this.e = paramInt;
  }
  
  private boolean c()
  {
    return ("vivo Xplay3S".equalsIgnoreCase(Build.MODEL)) || ("G3226".equalsIgnoreCase(Build.MODEL));
  }
  
  private void e()
  {
    this.i = actn.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.g = vpp.a(this.jdField_a_of_type_AndroidContentContext);
    this.f = 1;
    this.e = 1;
    this.jdField_a_of_type_Vlf = new vlf(this);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.h);
    this.jdField_a_of_type_Vpr = new vpr();
    vpr localvpr = this.jdField_a_of_type_Vpr;
    if (c()) {}
    for (float f1 = 3.0F;; f1 = 6.0F)
    {
      localvpr.a(f1);
      this.jdField_a_of_type_Vpr.b(0.2F);
      this.jdField_a_of_type_Vpr.a(true);
      c = ViewConfiguration.get(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getContext()).getScaledTouchSlop();
      return;
    }
  }
  
  private void j()
  {
    b(6);
    this.jdField_b_of_type_Vlf = new vlf(this, this.jdField_a_of_type_Vlf);
    vlf.a(this.jdField_b_of_type_Vlf);
  }
  
  public int a()
  {
    if (b()) {
      return 1;
    }
    return 0;
  }
  
  public String a()
  {
    return "TextLayer";
  }
  
  public vls a()
  {
    return this.jdField_a_of_type_Vlf.a();
  }
  
  public void a()
  {
    this.e = 1;
    this.f = 1;
    this.h = jdField_b_of_type_Int;
    this.k = 0;
    this.jdField_a_of_type_Vlf.d();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.h);
    this.jdField_a_of_type_Vpr.b(this.jdField_a_of_type_Vlf);
    d();
    veg.b("TextLayer", "clear over");
    if (this.jdField_a_of_type_Vle != null) {
      this.jdField_a_of_type_Vle.b();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0)
    {
      veg.e("TextLayer", "setTextTop:" + paramInt);
      return;
    }
    veg.b("TextLayer", "setTextTop:" + paramInt);
    this.k = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    this.jdField_a_of_type_Vlf.jdField_a_of_type_AndroidGraphicsRect.set(0, this.jdField_a_of_type_AndroidGraphicsRect.height() / 2 - this.i / 2, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.height() / 2 + this.i / 2);
    this.jdField_a_of_type_Vlf.jdField_a_of_type_AndroidGraphicsPointF.x = (paramInt1 / 2);
    this.jdField_a_of_type_Vlf.jdField_a_of_type_AndroidGraphicsPointF.y = (0.42F * paramInt2);
    jdField_a_of_type_Int = (int)(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() * 0.04F);
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if ((this.e == 6) && (this.jdField_b_of_type_Vlf != null))
      {
        this.jdField_b_of_type_Vlf.a(paramCanvas);
        return;
      }
    } while ((this.e != 4) && (this.e != 3));
    this.jdField_a_of_type_Vlf.a(paramCanvas);
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    this.jdField_a_of_type_Vlf.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(vle paramvle)
  {
    this.jdField_a_of_type_Vle = paramvle;
  }
  
  public void a(vls paramvls)
  {
    if (paramvls == null)
    {
      veg.e("TextLayer", "textInfo is null.");
      return;
    }
    veg.b("TextLayer", "setTextInfo:" + paramvls.a);
    this.jdField_a_of_type_Vlf.a(paramvls);
    super.g();
  }
  
  public void a(boolean paramBoolean)
  {
    veg.b("TextLayer", "setKeyboardState:" + paramBoolean);
    if (paramBoolean) {}
    for (;;)
    {
      super.g();
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Vlf.jdField_a_of_type_Vls.a)) {
        b(1);
      } else {
        b(4);
      }
    }
  }
  
  public boolean a()
  {
    return this.e == 1;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int m;
    int n;
    if (b())
    {
      m = (int)paramMotionEvent.getY();
      n = Math.abs(m - this.j);
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 3: 
      case 4: 
      default: 
        this.jdField_a_of_type_Vpr.a(paramMotionEvent, false);
        if (this.jdField_a_of_type_Vlf != null) {
          this.jdField_a_of_type_Vle.a(this.jdField_a_of_type_Vlf.f, this.jdField_a_of_type_Vlf.k, (int)this.jdField_a_of_type_Vlf.l, (int)this.jdField_a_of_type_Vlf.m, this.jdField_a_of_type_Vlf.jdField_a_of_type_AndroidGraphicsPointF, this.jdField_a_of_type_Vlf.e, 2);
        }
        break;
      }
    }
    for (;;)
    {
      bool = true;
      return bool;
      if (this.jdField_a_of_type_Vlf != null)
      {
        this.jdField_a_of_type_Vlf.e = false;
        this.jdField_a_of_type_Vlf.f = false;
        this.jdField_a_of_type_Vlf.b();
      }
      this.jdField_a_of_type_Vpr.a(this.jdField_a_of_type_Vlf);
      this.j = m;
      break;
      if (this.jdField_a_of_type_Vlf == null) {
        break;
      }
      this.jdField_a_of_type_Vlf.e = true;
      this.jdField_a_of_type_Vlf.c();
      break;
      if (this.jdField_a_of_type_Vlf != null)
      {
        this.jdField_a_of_type_Vlf.f = true;
        if (this.e == 3) {
          this.jdField_a_of_type_Vlf.c();
        }
      }
      if (n <= c) {
        break;
      }
      b(3);
      break;
      if (this.jdField_a_of_type_Vlf != null)
      {
        this.jdField_a_of_type_Vlf.f = false;
        this.jdField_a_of_type_Vlf.c();
      }
      a(this, false);
      if (n < c)
      {
        b();
        break;
      }
      if (this.e != 3) {
        break;
      }
      b(4);
      break;
      if (this.jdField_a_of_type_Vlf == null) {
        break;
      }
      this.jdField_a_of_type_Vlf.e = false;
      break;
      this.jdField_a_of_type_Vle.a(false, 0.0F, 0, 0, null, false, 0);
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Vle != null) && (this.jdField_a_of_type_Vle.a(this.jdField_a_of_type_Vlf))) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  public boolean b()
  {
    return (this.e == 4) || (this.e == 3);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    float f1 = paramMotionEvent.getX(0);
    float f2 = paramMotionEvent.getY(0);
    boolean bool1 = bool2;
    if (b())
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Vpr.a(this.jdField_a_of_type_Vlf, f1, f2, false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void c()
  {
    if (!a()) {
      j();
    }
    while (this.jdField_a_of_type_Vle == null) {
      return;
    }
    this.jdField_a_of_type_Vle.a(1.0F);
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    if (!b()) {}
    while (paramMotionEvent.getPointerCount() < 2) {
      return false;
    }
    float f1 = paramMotionEvent.getX(0);
    float f2 = paramMotionEvent.getY(0);
    float f3 = paramMotionEvent.getX(1);
    float f4 = paramMotionEvent.getY(1);
    return this.jdField_a_of_type_Vpr.a(this.jdField_a_of_type_Vlf, f1, f2, f3, f4);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Vlf != null) {
      this.jdField_a_of_type_Vlf.d = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vld
 * JD-Core Version:    0.7.0.1
 */