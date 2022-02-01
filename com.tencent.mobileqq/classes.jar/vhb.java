import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDrawer;
import java.util.concurrent.atomic.AtomicLong;

public abstract class vhb
  implements Comparable<vhb>
{
  private static final AtomicLong a;
  protected byte a;
  protected float a;
  protected int a;
  protected final long a;
  protected Bitmap a;
  protected Canvas a;
  protected CharSequence a;
  protected String a;
  protected final vgp a;
  protected vhc a;
  protected vhe a;
  public boolean a;
  protected float b;
  protected int b;
  protected long b;
  protected Bitmap b;
  protected String b;
  protected boolean b;
  protected float c;
  public int c;
  protected long c;
  protected String c;
  protected boolean c;
  protected float d;
  public int d;
  protected long d;
  protected String d;
  protected volatile boolean d;
  protected float e;
  public int e;
  protected String e;
  protected boolean e;
  protected float f;
  public int f;
  protected String f;
  protected boolean f;
  protected float g;
  protected int g;
  protected boolean g;
  protected float h;
  protected int h;
  public boolean h;
  protected float i;
  protected int i;
  protected float j;
  protected int j;
  protected float k;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  protected final int o;
  protected final int p;
  protected int q;
  protected int r;
  public int s;
  public int t;
  public int u;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong();
  }
  
  public vhb(vgp paramvgp, vhc paramvhc, vhe paramvhe)
  {
    this.jdField_a_of_type_Long = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.incrementAndGet();
    this.jdField_b_of_type_Long = -1L;
    this.jdField_b_of_type_Int = -1;
    this.jdField_g_of_type_Int = -1;
    this.jdField_h_of_type_Float = -1.0F;
    this.jdField_i_of_type_Float = -1.0F;
    this.jdField_j_of_type_Float = -1.0F;
    this.jdField_k_of_type_Float = -1.0F;
    this.jdField_a_of_type_Vgp = paramvgp;
    this.jdField_a_of_type_Vhc = paramvhc;
    this.jdField_a_of_type_Vhe = paramvhe;
    this.r = 10000;
    this.o = this.jdField_a_of_type_Vgp.jdField_k_of_type_Int;
    this.p = this.jdField_a_of_type_Vgp.l;
    a();
  }
  
  public byte a()
  {
    return this.jdField_a_of_type_Byte;
  }
  
  public abstract float a();
  
  public abstract int a();
  
  public int a(int paramInt)
  {
    if (this.s > paramInt) {
      return paramInt - 1;
    }
    return this.s;
  }
  
  public int a(vhb paramvhb)
  {
    return vjk.a(this, paramvhb);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Vhc.a();
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public Canvas a()
  {
    return this.jdField_a_of_type_AndroidGraphicsCanvas;
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String a()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public vgp a()
  {
    return this.jdField_a_of_type_Vgp;
  }
  
  public vhe a()
  {
    return this.jdField_a_of_type_Vhe;
  }
  
  protected void a()
  {
    f(this.jdField_a_of_type_Vgp.jdField_h_of_type_Int);
    e(this.jdField_a_of_type_Vgp.jdField_g_of_type_Int);
    e(this.jdField_a_of_type_Vgp.jdField_b_of_type_Float);
    f(this.jdField_a_of_type_Vgp.jdField_c_of_type_Float);
    k(this.jdField_a_of_type_Vgp.jdField_d_of_type_Float);
    c(this.jdField_a_of_type_Vgp.jdField_i_of_type_Int);
    a(this.jdField_a_of_type_Vgp.jdField_a_of_type_Float);
    a(this.jdField_a_of_type_Vgp.jdField_j_of_type_Int);
    d(this.jdField_a_of_type_Vgp.jdField_a_of_type_Boolean);
    e(this.jdField_a_of_type_Vgp.jdField_c_of_type_Boolean);
    d(this.jdField_a_of_type_Vgp.jdField_e_of_type_Float);
    c(this.jdField_a_of_type_Vgp.jdField_b_of_type_Boolean);
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Float != paramFloat)
    {
      this.jdField_a_of_type_Float = paramFloat;
      this.jdField_e_of_type_JavaLangString = null;
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_e_of_type_JavaLangString = null;
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsCanvas = paramCanvas;
  }
  
  public void a(PhotoDanmakuDrawer paramPhotoDanmakuDrawer)
  {
    paramPhotoDanmakuDrawer.a(this);
  }
  
  public final void a(PhotoDanmakuDrawer paramPhotoDanmakuDrawer, float paramFloat1, float paramFloat2)
  {
    b(paramPhotoDanmakuDrawer, paramFloat1, paramFloat2);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_h_of_type_Float = -1.0F;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.equals(this.jdField_d_of_type_JavaLangString, paramString))
    {
      this.jdField_d_of_type_JavaLangString = paramString;
      this.jdField_f_of_type_JavaLangString = null;
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void a(vhe paramvhe)
  {
    this.jdField_a_of_type_Vhe = paramvhe;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.q = 1;
      b();
      return;
    }
    this.q = 0;
  }
  
  public boolean a()
  {
    return (this.jdField_h_of_type_Float >= 0.0F) && (this.jdField_i_of_type_Float >= 0.0F);
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    float[] arrayOfFloat = b(paramLong);
    return (arrayOfFloat[0] <= paramFloat1) && (paramFloat1 <= arrayOfFloat[2]) && (arrayOfFloat[1] <= paramFloat2) && (paramFloat2 <= arrayOfFloat[3]);
  }
  
  public boolean a(int paramInt)
  {
    if (this.r - paramInt >= 0)
    {
      this.r -= paramInt;
      this.jdField_c_of_type_Long += paramInt;
      return true;
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    return paramLong - this.jdField_c_of_type_Long >= this.jdField_a_of_type_Vhc.a();
  }
  
  public abstract float[] a(long paramLong);
  
  public abstract float b();
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long b()
  {
    return d() + a();
  }
  
  public Bitmap b()
  {
    return this.jdField_b_of_type_AndroidGraphicsBitmap;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected abstract void b();
  
  public void b(float paramFloat)
  {
    this.jdField_h_of_type_Float = paramFloat;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_i_of_type_Int != paramInt)
    {
      this.jdField_i_of_type_Int = paramInt;
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_d_of_type_Long != paramLong)
    {
      this.jdField_d_of_type_Long = paramLong;
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void b(Bitmap paramBitmap)
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void b(PhotoDanmakuDrawer paramPhotoDanmakuDrawer)
  {
    paramPhotoDanmakuDrawer.b(this);
  }
  
  protected abstract void b(PhotoDanmakuDrawer paramPhotoDanmakuDrawer, float paramFloat1, float paramFloat2);
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.q == 1;
  }
  
  public abstract float[] b(long paramLong);
  
  public abstract float c();
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public final void c()
  {
    long l1 = this.jdField_a_of_type_Vhe.b();
    if (this.jdField_g_of_type_Boolean) {
      this.jdField_c_of_type_Long = (l1 + this.jdField_c_of_type_Long);
    }
    d();
  }
  
  public void c(float paramFloat)
  {
    this.jdField_i_of_type_Float = paramFloat;
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_j_of_type_Int != paramInt)
    {
      this.jdField_j_of_type_Int = paramInt;
      this.jdField_e_of_type_JavaLangString = null;
      this.jdField_f_of_type_JavaLangString = null;
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Vhe != null) {
      return a(this.jdField_a_of_type_Vhe.a());
    }
    return true;
  }
  
  public abstract float d();
  
  public int d()
  {
    return this.jdField_j_of_type_Int;
  }
  
  public long d()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public String d()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public abstract void d();
  
  public void d(float paramFloat)
  {
    if (this.jdField_e_of_type_Float != paramFloat)
    {
      this.jdField_e_of_type_Float = paramFloat;
      this.jdField_f_of_type_JavaLangString = null;
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void d(int paramInt)
  {
    if (this.m != paramInt)
    {
      this.m = paramInt;
      this.jdField_f_of_type_JavaLangString = null;
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void d(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_d_of_type_Boolean = true;
  }
  
  public boolean d()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public abstract float e();
  
  public int e()
  {
    return this.m;
  }
  
  public long e()
  {
    return this.jdField_d_of_type_Long;
  }
  
  public String e()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public void e(float paramFloat)
  {
    this.jdField_c_of_type_Float = paramFloat;
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void e(int paramInt)
  {
    this.jdField_k_of_type_Int = paramInt;
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void e(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean e()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof vhb)) {}
    do
    {
      return false;
      paramObject = (vhb)paramObject;
    } while ((this.jdField_b_of_type_Long == -1L) || (paramObject.jdField_b_of_type_Long == -1L) || (this.jdField_b_of_type_Long != paramObject.jdField_b_of_type_Long));
    return true;
  }
  
  public float f()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int f()
  {
    return this.jdField_k_of_type_Int;
  }
  
  public void f(float paramFloat)
  {
    this.jdField_d_of_type_Float = paramFloat;
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void f(int paramInt)
  {
    this.l = paramInt;
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void f(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean f()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public float g()
  {
    return this.jdField_h_of_type_Float;
  }
  
  public int g()
  {
    return this.l;
  }
  
  public void g(float paramFloat)
  {
    this.jdField_f_of_type_Float = paramFloat;
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void g(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
  }
  
  public boolean g()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public float h()
  {
    return this.jdField_i_of_type_Float;
  }
  
  public int h()
  {
    return this.n;
  }
  
  public void h(float paramFloat)
  {
    this.jdField_g_of_type_Float = paramFloat;
  }
  
  public void h(int paramInt)
  {
    this.jdField_h_of_type_Int = paramInt;
  }
  
  public boolean h()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public int hashCode()
  {
    return (int)this.jdField_b_of_type_Long;
  }
  
  public float i()
  {
    return this.jdField_e_of_type_Float;
  }
  
  public int i()
  {
    return this.r;
  }
  
  public void i(float paramFloat)
  {
    this.jdField_k_of_type_Float = paramFloat;
  }
  
  public void i(int paramInt)
  {
    this.t = paramInt;
    this.jdField_d_of_type_Boolean = true;
  }
  
  public float j()
  {
    return this.jdField_c_of_type_Float;
  }
  
  public void j(float paramFloat)
  {
    this.jdField_j_of_type_Float = paramFloat;
  }
  
  public float k()
  {
    return this.jdField_d_of_type_Float;
  }
  
  public void k(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
    this.jdField_d_of_type_Boolean = true;
  }
  
  public float l()
  {
    return this.jdField_g_of_type_Float;
  }
  
  public float m()
  {
    return this.jdField_k_of_type_Float;
  }
  
  public float n()
  {
    return this.jdField_j_of_type_Float;
  }
  
  public float o()
  {
    return b() + g();
  }
  
  public float p()
  {
    return c() + f();
  }
  
  public float q()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public String toString()
  {
    return "absDanmaku_" + this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhb
 * JD-Core Version:    0.7.0.1
 */