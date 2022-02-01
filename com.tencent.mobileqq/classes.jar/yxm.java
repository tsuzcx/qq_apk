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
public class yxm
  extends yxs
{
  public static int a;
  public static final int b;
  public static int c;
  public static int d = 270;
  public final long a;
  public Paint a;
  public yxn a;
  public yxo a;
  public zca a;
  public boolean a;
  private yxo b;
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
  
  public yxm(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Long = 270L;
    e();
  }
  
  private void b(int paramInt)
  {
    yqp.b("TextLayer", "setMode:" + paramInt + ",preMode:" + this.f);
    this.f = this.e;
    this.e = paramInt;
  }
  
  private boolean c()
  {
    return ("vivo Xplay3S".equalsIgnoreCase(Build.MODEL)) || ("G3226".equalsIgnoreCase(Build.MODEL));
  }
  
  private void e()
  {
    this.i = afur.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.g = zby.a(this.jdField_a_of_type_AndroidContentContext);
    this.f = 1;
    this.e = 1;
    this.jdField_a_of_type_Yxo = new yxo(this);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.h);
    this.jdField_a_of_type_Zca = new zca();
    zca localzca = this.jdField_a_of_type_Zca;
    if (c()) {}
    for (float f1 = 3.0F;; f1 = 6.0F)
    {
      localzca.a(f1);
      this.jdField_a_of_type_Zca.b(0.2F);
      this.jdField_a_of_type_Zca.a(true);
      c = ViewConfiguration.get(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getContext()).getScaledTouchSlop();
      return;
    }
  }
  
  private void j()
  {
    b(6);
    this.jdField_b_of_type_Yxo = new yxo(this, this.jdField_a_of_type_Yxo);
    yxo.a(this.jdField_b_of_type_Yxo);
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
  
  public yyb a()
  {
    return this.jdField_a_of_type_Yxo.a();
  }
  
  public void a()
  {
    this.e = 1;
    this.f = 1;
    this.h = jdField_b_of_type_Int;
    this.k = 0;
    this.jdField_a_of_type_Yxo.d();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.h);
    this.jdField_a_of_type_Zca.b(this.jdField_a_of_type_Yxo);
    d();
    yqp.b("TextLayer", "clear over");
    if (this.jdField_a_of_type_Yxn != null) {
      this.jdField_a_of_type_Yxn.b();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0)
    {
      yqp.e("TextLayer", "setTextTop:" + paramInt);
      return;
    }
    yqp.b("TextLayer", "setTextTop:" + paramInt);
    this.k = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    this.jdField_a_of_type_Yxo.jdField_a_of_type_AndroidGraphicsRect.set(0, this.jdField_a_of_type_AndroidGraphicsRect.height() / 2 - this.i / 2, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.height() / 2 + this.i / 2);
    this.jdField_a_of_type_Yxo.jdField_a_of_type_AndroidGraphicsPointF.x = (paramInt1 / 2);
    this.jdField_a_of_type_Yxo.jdField_a_of_type_AndroidGraphicsPointF.y = (0.42F * paramInt2);
    jdField_a_of_type_Int = (int)(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() * 0.04F);
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if ((this.e == 6) && (this.jdField_b_of_type_Yxo != null))
      {
        this.jdField_b_of_type_Yxo.a(paramCanvas);
        return;
      }
    } while ((this.e != 4) && (this.e != 3));
    this.jdField_a_of_type_Yxo.a(paramCanvas);
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    this.jdField_a_of_type_Yxo.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(yxn paramyxn)
  {
    this.jdField_a_of_type_Yxn = paramyxn;
  }
  
  public void a(yyb paramyyb)
  {
    if (paramyyb == null)
    {
      yqp.e("TextLayer", "textInfo is null.");
      return;
    }
    yqp.b("TextLayer", "setTextInfo:" + paramyyb.a);
    this.jdField_a_of_type_Yxo.a(paramyyb);
    super.g();
  }
  
  public void a(boolean paramBoolean)
  {
    yqp.b("TextLayer", "setKeyboardState:" + paramBoolean);
    if (paramBoolean) {}
    for (;;)
    {
      super.g();
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Yxo.jdField_a_of_type_Yyb.a)) {
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
        this.jdField_a_of_type_Zca.a(paramMotionEvent, false);
        if (this.jdField_a_of_type_Yxo != null) {
          this.jdField_a_of_type_Yxn.a(this.jdField_a_of_type_Yxo.f, this.jdField_a_of_type_Yxo.k, (int)this.jdField_a_of_type_Yxo.l, (int)this.jdField_a_of_type_Yxo.m, this.jdField_a_of_type_Yxo.jdField_a_of_type_AndroidGraphicsPointF, this.jdField_a_of_type_Yxo.e, 2);
        }
        break;
      }
    }
    for (;;)
    {
      bool = true;
      return bool;
      if (this.jdField_a_of_type_Yxo != null)
      {
        this.jdField_a_of_type_Yxo.e = false;
        this.jdField_a_of_type_Yxo.f = false;
        this.jdField_a_of_type_Yxo.b();
      }
      this.jdField_a_of_type_Zca.a(this.jdField_a_of_type_Yxo);
      this.j = m;
      break;
      if (this.jdField_a_of_type_Yxo == null) {
        break;
      }
      this.jdField_a_of_type_Yxo.e = true;
      this.jdField_a_of_type_Yxo.c();
      break;
      if (this.jdField_a_of_type_Yxo != null)
      {
        this.jdField_a_of_type_Yxo.f = true;
        if (this.e == 3) {
          this.jdField_a_of_type_Yxo.c();
        }
      }
      if (n <= c) {
        break;
      }
      b(3);
      break;
      if (this.jdField_a_of_type_Yxo != null)
      {
        this.jdField_a_of_type_Yxo.f = false;
        this.jdField_a_of_type_Yxo.c();
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
      if (this.jdField_a_of_type_Yxo == null) {
        break;
      }
      this.jdField_a_of_type_Yxo.e = false;
      break;
      this.jdField_a_of_type_Yxn.a(false, 0.0F, 0, 0, null, false, 0);
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Yxn != null) && (this.jdField_a_of_type_Yxn.a(this.jdField_a_of_type_Yxo))) {
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
      if (this.jdField_a_of_type_Zca.a(this.jdField_a_of_type_Yxo, f1, f2, false)) {
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
    while (this.jdField_a_of_type_Yxn == null) {
      return;
    }
    this.jdField_a_of_type_Yxn.a(1.0F);
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
    return this.jdField_a_of_type_Zca.a(this.jdField_a_of_type_Yxo, f1, f2, f3, f4);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Yxo != null) {
      this.jdField_a_of_type_Yxo.d = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yxm
 * JD-Core Version:    0.7.0.1
 */