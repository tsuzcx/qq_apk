import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import java.io.BufferedReader;
import java.io.IOException;

public class imx
{
  float[] M = new float[2];
  float[] N = new float[2];
  private boolean SE;
  private boolean SF;
  private boolean SG;
  private boolean SH;
  private boolean SI;
  private boolean SJ = true;
  private imx.a jdField_a_of_type_Imx$a = new imx.a();
  private imx.d jdField_a_of_type_Imx$d = new imx.d();
  private imx.e jdField_a_of_type_Imx$e = new imx.e();
  private imx.h jdField_a_of_type_Imx$h = new imx.h();
  private BitmapDrawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable;
  private imx.b[] jdField_a_of_type_ArrayOfImx$b;
  private int apY;
  private int apZ = 4;
  private int aqa;
  private int aqb;
  private int aqc;
  private int aqd;
  private int aqe;
  private int aqf;
  private int aqg;
  private int aqh;
  private int aqi;
  private boolean attached;
  private imx.d jdField_b_of_type_Imx$d = new imx.d();
  private imx.e jdField_b_of_type_Imx$e = new imx.e();
  private imx.d jdField_c_of_type_Imx$d = new imx.e();
  private imx.e jdField_c_of_type_Imx$e = new imx.e();
  private imx.d jdField_d_of_type_Imx$d = new imx.e();
  private imx.e jdField_d_of_type_Imx$e = new imx.e();
  public float duration = 1.0F;
  private imx.e e = new imx.e();
  private imx.e f = new imx.e();
  private imx.e g = new imx.e();
  private float gk;
  private float gl;
  private float gm;
  private float gn;
  private float go;
  public float gp;
  private float gq;
  private float gr;
  private imx.e jdField_h_of_type_Imx$e = new imx.e();
  private boolean[] jdField_h_of_type_ArrayOfBoolean;
  private imx.e i = new imx.e();
  private imx.e j = new imx.e();
  private imx.e k = new imx.e();
  private imx.e l = new imx.e();
  private PathMeasure mPathMeasure;
  private String name;
  
  public imx()
  {
    initialize();
  }
  
  public imx(BufferedReader paramBufferedReader)
    throws IOException
  {
    initialize();
    a(paramBufferedReader);
  }
  
  static float a(BufferedReader paramBufferedReader, String paramString)
    throws IOException
  {
    return Float.parseFloat(a(paramBufferedReader, paramString));
  }
  
  static int a(BufferedReader paramBufferedReader, String paramString)
    throws IOException
  {
    return Integer.parseInt(a(paramBufferedReader, paramString));
  }
  
  static String a(BufferedReader paramBufferedReader, String paramString)
    throws IOException
  {
    paramBufferedReader = paramBufferedReader.readLine();
    if (paramBufferedReader == null) {
      throw new IOException("Missing value: " + paramString);
    }
    return paramBufferedReader.substring(paramBufferedReader.indexOf(":") + 1).trim();
  }
  
  private boolean a(imx.b paramb, float paramFloat, int paramInt)
  {
    paramInt = paramb.aqj - paramInt;
    if (paramInt <= 0) {
      return false;
    }
    paramb.aqj = paramInt;
    float f4 = 1.0F - paramb.aqj / paramb.aqh;
    paramInt = this.aqb;
    if ((paramInt & 0x1) != 0) {
      paramb.setScale(paramb.scale + paramb.scaleDiff * this.jdField_d_of_type_Imx$e.p(f4));
    }
    float f3;
    float f5;
    float f6;
    float f2;
    float f1;
    if ((paramInt & 0x8) != 0)
    {
      f3 = (paramb.gt + paramb.gu * this.f.p(f4)) * paramFloat;
      if ((paramInt & 0x2) != 0)
      {
        float f7 = paramb.angle + paramb.gv * this.g.p(f4);
        f5 = imt.n(f7);
        f6 = imt.m(f7);
        if ((paramInt & 0x4) != 0)
        {
          f2 = paramb.rotation + paramb.gs * this.e.p(f4);
          f1 = f2;
          if (this.SH) {
            f1 = f2 + f7;
          }
          paramb.setRotation(f1);
        }
        f1 = f6 * f3;
        f2 = f3 * f5;
        f3 = f2;
        if ((paramInt & 0x10) != 0) {
          f3 = f2 + (paramb.gA + paramb.gB * this.jdField_h_of_type_Imx$e.p(f4)) * paramFloat;
        }
        f2 = f1;
        if ((paramInt & 0x20) != 0) {
          f2 = f1 + (paramb.gC + paramb.gD * this.i.p(f4)) * paramFloat;
        }
        paramb.translate(f3, f2);
        label285:
        if ((paramInt & 0x40) == 0) {
          break label479;
        }
      }
    }
    label479:
    for (float[] arrayOfFloat = this.jdField_a_of_type_Imx$a.a(f4);; arrayOfFloat = paramb.R)
    {
      paramFloat = arrayOfFloat[0];
      f1 = arrayOfFloat[1];
      f2 = arrayOfFloat[2];
      f3 = paramb.gy;
      f5 = paramb.gz;
      paramb.b(paramFloat, f1, f2, f3 + this.j.p(f4) * f5);
      return true;
      f5 = paramb.gw;
      f6 = paramb.gx;
      if ((this.SH) || ((paramInt & 0x4) != 0))
      {
        f2 = paramb.rotation + paramb.gs * this.e.p(f4);
        f1 = f2;
        if (this.SH) {
          f1 = f2 + paramb.angle;
        }
        paramb.setRotation(f1);
      }
      f1 = f6 * f3;
      f2 = f3 * f5;
      break;
      if ((paramInt & 0x4) == 0) {
        break label285;
      }
      paramb.setRotation(paramb.rotation + paramb.gs * this.e.p(f4));
      break label285;
    }
  }
  
  static boolean a(BufferedReader paramBufferedReader, String paramString)
    throws IOException
  {
    return Boolean.parseBoolean(a(paramBufferedReader, paramString));
  }
  
  private void initialize()
  {
    this.jdField_b_of_type_Imx$d.iu(true);
    this.jdField_c_of_type_Imx$e.iu(true);
    this.jdField_b_of_type_Imx$e.iu(true);
    this.jdField_d_of_type_Imx$e.iu(true);
    this.j.iu(true);
    this.jdField_a_of_type_Imx$h.iu(true);
    this.k.iu(true);
    this.l.iu(true);
  }
  
  private void lc(int paramInt)
  {
    Object localObject2 = this.jdField_a_of_type_ArrayOfImx$b[paramInt];
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = this.jdField_a_of_type_ArrayOfImx$b;
      localObject1 = a(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable[imt.random(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable.length - 1)]);
      localObject2[paramInt] = localObject1;
    }
    float f6 = this.gp / this.duration;
    paramInt = this.aqb;
    int m = this.aqh + (int)(this.aqi * this.jdField_b_of_type_Imx$e.p(f6));
    ((imx.b)localObject1).aqh = m;
    ((imx.b)localObject1).aqj = m;
    if (this.f.active)
    {
      ((imx.b)localObject1).gt = this.f.O();
      ((imx.b)localObject1).gu = this.f.P();
      if (!this.f.isRelative()) {
        ((imx.b)localObject1).gu -= ((imx.b)localObject1).gt;
      }
    }
    ((imx.b)localObject1).angle = this.g.O();
    ((imx.b)localObject1).gv = this.g.P();
    if (!this.g.isRelative()) {
      ((imx.b)localObject1).gv -= ((imx.b)localObject1).angle;
    }
    float f1;
    if ((paramInt & 0x2) == 0)
    {
      f1 = ((imx.b)localObject1).angle + ((imx.b)localObject1).gv * this.g.p(0.0F);
      ((imx.b)localObject1).angle = f1;
      ((imx.b)localObject1).gw = imt.n(f1);
      ((imx.b)localObject1).gx = imt.m(f1);
    }
    for (;;)
    {
      float f7 = ((imx.b)localObject1).getBitmap().getWidth();
      ((imx.b)localObject1).scale = (this.jdField_d_of_type_Imx$e.O() / f7);
      ((imx.b)localObject1).scaleDiff = (this.jdField_d_of_type_Imx$e.P() / f7);
      if (!this.jdField_d_of_type_Imx$e.isRelative()) {
        ((imx.b)localObject1).scaleDiff -= ((imx.b)localObject1).scale;
      }
      ((imx.b)localObject1).setScale(((imx.b)localObject1).scale + ((imx.b)localObject1).scaleDiff * this.jdField_d_of_type_Imx$e.p(0.0F));
      float f2;
      if (this.e.active)
      {
        ((imx.b)localObject1).rotation = this.e.O();
        ((imx.b)localObject1).gs = this.e.P();
        if (!this.e.isRelative()) {
          ((imx.b)localObject1).gs -= ((imx.b)localObject1).rotation;
        }
        f2 = ((imx.b)localObject1).rotation + ((imx.b)localObject1).gs * this.e.p(0.0F);
        if (!this.SH) {
          break label1380;
        }
      }
      label1380:
      for (f1 += f2;; f1 = f2)
      {
        ((imx.b)localObject1).setRotation(f1);
        if (this.jdField_h_of_type_Imx$e.active)
        {
          ((imx.b)localObject1).gA = this.jdField_h_of_type_Imx$e.O();
          ((imx.b)localObject1).gB = this.jdField_h_of_type_Imx$e.P();
          if (!this.jdField_h_of_type_Imx$e.isRelative()) {
            ((imx.b)localObject1).gB -= ((imx.b)localObject1).gA;
          }
        }
        if (this.i.active)
        {
          ((imx.b)localObject1).gC = this.i.O();
          ((imx.b)localObject1).gD = this.i.P();
          if (!this.i.isRelative()) {
            ((imx.b)localObject1).gD -= ((imx.b)localObject1).gC;
          }
        }
        float[] arrayOfFloat = ((imx.b)localObject1).R;
        localObject2 = arrayOfFloat;
        if (arrayOfFloat == null)
        {
          localObject2 = new float[3];
          ((imx.b)localObject1).R = ((float[])localObject2);
        }
        arrayOfFloat = this.jdField_a_of_type_Imx$a.a(0.0F);
        localObject2[0] = arrayOfFloat[0];
        localObject2[1] = arrayOfFloat[1];
        localObject2[2] = arrayOfFloat[2];
        ((imx.b)localObject1).gy = this.j.O();
        ((imx.b)localObject1).gz = (this.j.P() - ((imx.b)localObject1).gy);
        float f3 = 3.4028235E+38F;
        float f4 = 3.4028235E+38F;
        f1 = f4;
        f2 = f3;
        float f5;
        if (this.mPathMeasure != null)
        {
          f5 = this.mPathMeasure.getLength();
          f1 = f4;
          f2 = f3;
          if (f5 > 0.0F)
          {
            f1 = imt.o(f5);
            this.mPathMeasure.getPosTan(f1, this.M, this.N);
            f2 = this.M[0];
            f1 = this.M[1];
          }
        }
        f4 = f2;
        if (this.jdField_c_of_type_Imx$d.active) {
          f4 = f2 + this.jdField_c_of_type_Imx$d.O();
        }
        f3 = f1;
        if (this.jdField_d_of_type_Imx$d.active) {
          f3 = f1 + this.jdField_d_of_type_Imx$d.O();
        }
        switch (this.jdField_a_of_type_Imx$h.shape)
        {
        default: 
          f2 = f4;
          f1 = f3;
        }
        for (;;)
        {
          f3 = ((imx.b)localObject1).getBitmap().getHeight();
          ((imx.b)localObject1).a(f2 - f7 / 2.0F, f1 - f3 / 2.0F, f7, f3);
          m = (int)(this.aqf + this.aqg * this.jdField_a_of_type_Imx$e.p(f6));
          if (m > 0)
          {
            paramInt = m;
            if (m >= ((imx.b)localObject1).aqj) {
              paramInt = ((imx.b)localObject1).aqj - 1;
            }
            a((imx.b)localObject1, paramInt / 1000.0F, paramInt);
          }
          return;
          f2 = this.gl + this.gm * this.k.p(f6);
          f1 = this.gn + this.go * this.l.p(f6);
          f2 = f4 + (imt.o(f2) - f2 / 2.0F);
          f1 = f3 + (imt.o(f1) - f1 / 2.0F);
          continue;
          f5 = this.gl + this.gm * this.k.p(f6);
          f1 = this.gn;
          f2 = this.go;
          float f9 = this.l.p(f6);
          float f8 = f5 / 2.0F;
          f9 = (f1 + f2 * f9) / 2.0F;
          f1 = f3;
          f2 = f4;
          if (f8 != 0.0F)
          {
            f1 = f3;
            f2 = f4;
            if (f9 != 0.0F)
            {
              f1 = f8 / f9;
              if (this.jdField_a_of_type_Imx$h.SM)
              {
                switch (this.jdField_a_of_type_Imx$h.TI)
                {
                default: 
                  f5 = imt.o(360.0F);
                }
                for (;;)
                {
                  f9 = imt.n(f5);
                  float f10 = imt.m(f5);
                  f4 += f9 * f8;
                  f3 += f8 * f10 / f1;
                  f1 = f3;
                  f2 = f4;
                  if ((paramInt & 0x2) != 0) {
                    break;
                  }
                  ((imx.b)localObject1).angle = f5;
                  ((imx.b)localObject1).gw = f9;
                  ((imx.b)localObject1).gx = f10;
                  f1 = f3;
                  f2 = f4;
                  break;
                  f5 = -imt.o(179.0F);
                  continue;
                  f5 = imt.o(179.0F);
                }
              }
              do
              {
                f2 = imt.o(f5) - f8;
                f9 = imt.o(f5) - f8;
              } while (f2 * f2 + f9 * f9 > f8 * f8);
              f2 = f4 + f2;
              f1 = f3 + f9 / f1;
              continue;
              f1 = this.gl + this.gm * this.k.p(f6);
              f5 = this.gn + this.go * this.l.p(f6);
              if (f1 != 0.0F)
              {
                f8 = imt.N() * f1;
                f2 = f4 + f8;
                f1 = f3 + f8 * (f5 / f1);
              }
              else
              {
                f1 = f3 + imt.N() * f5;
                f2 = f4;
              }
            }
          }
        }
      }
      f1 = 0.0F;
    }
  }
  
  private void restart()
  {
    float f1;
    if (this.jdField_a_of_type_Imx$d.active)
    {
      f1 = this.jdField_a_of_type_Imx$d.O();
      this.gq = f1;
      this.gr = 0.0F;
      this.gp -= this.duration;
      this.duration = this.jdField_b_of_type_Imx$d.O();
      this.aqc = ((int)this.jdField_c_of_type_Imx$e.O());
      this.aqd = ((int)this.jdField_c_of_type_Imx$e.P());
      if (!this.jdField_c_of_type_Imx$e.isRelative()) {
        this.aqd -= this.aqc;
      }
      this.aqh = ((int)this.jdField_b_of_type_Imx$e.O());
      this.aqi = ((int)this.jdField_b_of_type_Imx$e.P());
      if (!this.jdField_b_of_type_Imx$e.isRelative()) {
        this.aqi -= this.aqh;
      }
      if (!this.jdField_a_of_type_Imx$e.active) {
        break label478;
      }
    }
    label478:
    for (int m = (int)this.jdField_a_of_type_Imx$e.O();; m = 0)
    {
      this.aqf = m;
      this.aqg = ((int)this.jdField_a_of_type_Imx$e.P());
      if (!this.jdField_a_of_type_Imx$e.isRelative()) {
        this.aqg -= this.aqf;
      }
      this.gl = this.k.O();
      this.gm = this.k.P();
      if (!this.k.isRelative()) {
        this.gm -= this.gl;
      }
      this.gn = this.l.O();
      this.go = this.l.P();
      if (!this.l.isRelative()) {
        this.go -= this.gn;
      }
      this.aqb = 0;
      if ((this.g.active) && (this.g.Q.length > 1)) {
        this.aqb |= 0x2;
      }
      if (this.f.active) {
        this.aqb |= 0x8;
      }
      if (this.jdField_d_of_type_Imx$e.Q.length > 1) {
        this.aqb |= 0x1;
      }
      if ((this.e.active) && (this.e.Q.length > 1)) {
        this.aqb |= 0x4;
      }
      if (this.jdField_h_of_type_Imx$e.active) {
        this.aqb |= 0x10;
      }
      if (this.i.active) {
        this.aqb |= 0x20;
      }
      if (this.jdField_a_of_type_Imx$a.Q.length > 1) {
        this.aqb |= 0x40;
      }
      return;
      f1 = 0.0F;
      break;
    }
  }
  
  protected imx.b a(BitmapDrawable paramBitmapDrawable)
  {
    return new imx.b(paramBitmapDrawable);
  }
  
  public void a(PathMeasure paramPathMeasure)
  {
    this.mPathMeasure = paramPathMeasure;
  }
  
  public void a(BufferedReader paramBufferedReader)
    throws IOException
  {
    try
    {
      this.name = a(paramBufferedReader, "name");
      paramBufferedReader.readLine();
      this.jdField_a_of_type_Imx$d.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_b_of_type_Imx$d.a(paramBufferedReader);
      paramBufferedReader.readLine();
      ld(a(paramBufferedReader, "minParticleCount"));
      lb(a(paramBufferedReader, "maxParticleCount"));
      paramBufferedReader.readLine();
      this.jdField_c_of_type_Imx$e.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_b_of_type_Imx$e.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_a_of_type_Imx$e.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_c_of_type_Imx$d.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_d_of_type_Imx$d.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_a_of_type_Imx$h.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.k.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.l.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_d_of_type_Imx$e.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.f.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.g.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.e.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_h_of_type_Imx$e.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.i.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_a_of_type_Imx$a.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.j.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.attached = a(paramBufferedReader, "attached");
      this.SG = a(paramBufferedReader, "continuous");
      this.SH = a(paramBufferedReader, "aligned");
      this.SJ = a(paramBufferedReader, "additive");
      this.SI = a(paramBufferedReader, "behind");
      return;
    }
    catch (RuntimeException paramBufferedReader)
    {
      if (this.name == null) {
        throw paramBufferedReader;
      }
      throw new RuntimeException("Error parsing emitter: " + this.name, paramBufferedReader);
    }
  }
  
  public void a(BitmapDrawable[] paramArrayOfBitmapDrawable)
  {
    this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable = paramArrayOfBitmapDrawable;
  }
  
  public void aon()
  {
    int n = this.aqa;
    if (n == this.apZ) {}
    for (;;)
    {
      return;
      boolean[] arrayOfBoolean = this.jdField_h_of_type_ArrayOfBoolean;
      int m = 0;
      int i1 = arrayOfBoolean.length;
      while (m < i1)
      {
        if (arrayOfBoolean[m] == 0)
        {
          lc(m);
          arrayOfBoolean[m] = true;
          this.aqa = (n + 1);
          return;
        }
        m += 1;
      }
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    imx.b[] arrayOfb = this.jdField_a_of_type_ArrayOfImx$b;
    boolean[] arrayOfBoolean = this.jdField_h_of_type_ArrayOfBoolean;
    int m = 0;
    int n = arrayOfBoolean.length;
    while (m < n)
    {
      if (arrayOfBoolean[m] != 0) {
        arrayOfb[m].draw(paramCanvas);
      }
      m += 1;
    }
  }
  
  public void iU(int paramInt)
  {
    int n = 0;
    int i1 = Math.min(paramInt, this.apZ - this.aqa);
    if (i1 == 0) {
      return;
    }
    boolean[] arrayOfBoolean = this.jdField_h_of_type_ArrayOfBoolean;
    int i2 = arrayOfBoolean.length;
    int m = 0;
    paramInt = n;
    if (m < i1) {
      for (;;)
      {
        if (paramInt >= i2) {
          break label85;
        }
        if (arrayOfBoolean[paramInt] == 0)
        {
          lc(paramInt);
          arrayOfBoolean[paramInt] = true;
          m += 1;
          paramInt += 1;
          break;
        }
        paramInt += 1;
      }
    }
    label85:
    this.aqa += i1;
  }
  
  public void lb(int paramInt)
  {
    this.apZ = paramInt;
    this.jdField_h_of_type_ArrayOfBoolean = new boolean[paramInt];
    this.aqa = 0;
    this.jdField_a_of_type_ArrayOfImx$b = new imx.b[paramInt];
  }
  
  public void ld(int paramInt)
  {
    this.apY = paramInt;
  }
  
  public void update(float paramFloat)
  {
    if ((this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable == null) || (this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable.length <= 0)) {}
    do
    {
      return;
      this.gk += paramFloat * 1000.0F;
    } while (this.gk < 1.0F);
    int i2 = (int)this.gk;
    this.gk -= i2;
    if (this.gr < this.gq) {
      this.gr += i2;
    }
    int n;
    label378:
    for (;;)
    {
      boolean[] arrayOfBoolean = this.jdField_h_of_type_ArrayOfBoolean;
      n = this.aqa;
      imx.b[] arrayOfb = this.jdField_a_of_type_ArrayOfImx$b;
      int i3 = arrayOfBoolean.length;
      int m = 0;
      while (m < i3)
      {
        int i1 = n;
        if (arrayOfBoolean[m] != 0)
        {
          i1 = n;
          if (!a(arrayOfb[m], paramFloat, i2))
          {
            arrayOfBoolean[m] = false;
            i1 = n - 1;
          }
        }
        m += 1;
        n = i1;
      }
      if (this.SE)
      {
        this.SE = false;
        aon();
      }
      if (this.gp < this.duration)
      {
        this.gp += i2;
        m = 0;
      }
      for (;;)
      {
        if (m != 0) {
          break label378;
        }
        this.aqe += i2;
        float f1 = this.aqc + this.aqd * this.jdField_c_of_type_Imx$e.p(this.gp / this.duration);
        if (f1 > 0.0F)
        {
          f1 = 1000.0F / f1;
          if (this.aqe >= f1)
          {
            m = Math.min((int)(this.aqe / f1), this.apZ - this.aqa);
            this.aqe = ((int)(this.aqe - m * f1));
            this.aqe = ((int)(this.aqe % f1));
            iU(m);
          }
        }
        if (this.aqa >= this.apY) {
          break;
        }
        iU(this.apY - this.aqa);
        break;
        if ((!this.SG) || (this.SF))
        {
          m = 1;
        }
        else
        {
          restart();
          m = 0;
        }
      }
    }
    this.aqa = n;
  }
  
  public static class a
    extends imx.c
  {
    private static float[] O = new float[4];
    private float[] P = { 1.0F, 1.0F, 1.0F };
    float[] Q = { 0.0F };
    
    public a()
    {
      this.SK = true;
    }
    
    public void a(BufferedReader paramBufferedReader)
      throws IOException
    {
      int j = 0;
      super.a(paramBufferedReader);
      if (!this.active) {}
      for (;;)
      {
        return;
        this.P = new float[imx.a(paramBufferedReader, "colorsCount")];
        int i = 0;
        while (i < this.P.length)
        {
          this.P[i] = imx.a(paramBufferedReader, "colors" + i);
          i += 1;
        }
        this.Q = new float[imx.a(paramBufferedReader, "timelineCount")];
        i = j;
        while (i < this.Q.length)
        {
          this.Q[i] = imx.a(paramBufferedReader, "timeline" + i);
          i += 1;
        }
      }
    }
    
    public float[] a(float paramFloat)
    {
      float[] arrayOfFloat = this.Q;
      int k = arrayOfFloat.length;
      int i = 1;
      int j = 0;
      if (i < k) {
        if (arrayOfFloat[i] <= paramFloat) {}
      }
      for (;;)
      {
        float f4 = arrayOfFloat[j];
        j *= 3;
        float f1 = this.P[j];
        float f2 = this.P[(j + 1)];
        float f3 = this.P[(j + 2)];
        if (i == -1)
        {
          O[0] = f1;
          O[1] = f2;
          O[2] = f3;
          return O;
          j = i;
          i += 1;
          break;
        }
        paramFloat = (paramFloat - f4) / (arrayOfFloat[i] - f4);
        i *= 3;
        O[0] = ((this.P[i] - f1) * paramFloat + f1);
        O[1] = ((this.P[(i + 1)] - f2) * paramFloat + f2);
        O[2] = ((this.P[(i + 2)] - f3) * paramFloat + f3);
        return O;
        i = -1;
      }
    }
  }
  
  public static class b
    extends BitmapDrawable
  {
    protected float[] R;
    protected float angle;
    protected int aqh;
    protected int aqj;
    protected float gA;
    protected float gB;
    protected float gC;
    protected float gD;
    protected float gs;
    protected float gt;
    protected float gu;
    protected float gv;
    protected float gw;
    protected float gx;
    protected float gy;
    protected float gz;
    private float mHeight;
    private Matrix mMatrix = new Matrix();
    private float mPivotX;
    private float mPivotY;
    private float mRotation;
    private float mScale = 1.0F;
    private float mWidth;
    private float mX;
    private float mY;
    protected float rotation;
    protected float scale;
    protected float scaleDiff;
    
    public b(BitmapDrawable paramBitmapDrawable)
    {
      super();
    }
    
    private void aoo()
    {
      this.mMatrix.reset();
      this.mMatrix.preRotate(this.mRotation, this.mPivotX, this.mPivotY);
      this.mMatrix.preScale(this.mScale, this.mScale, this.mPivotX, this.mPivotY);
    }
    
    public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      Rect localRect1 = getBounds();
      Rect localRect2 = new Rect();
      this.mX = paramFloat1;
      this.mY = paramFloat2;
      this.mWidth = paramFloat3;
      this.mHeight = paramFloat4;
      localRect2.left = ((int)this.mX);
      localRect2.top = ((int)this.mY);
      localRect2.right = ((int)(this.mX + this.mWidth));
      localRect2.bottom = ((int)(this.mY + this.mHeight));
      if (!localRect1.equals(localRect2)) {
        setBounds(localRect2);
      }
    }
    
    public void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      setColorFilter(Color.argb(255, (int)(paramFloat1 * 255.0F), (int)(paramFloat2 * 255.0F), (int)(paramFloat3 * 255.0F)), PorterDuff.Mode.SRC_ATOP);
      setAlpha((int)(paramFloat4 * 255.0F));
    }
    
    public void draw(Canvas paramCanvas)
    {
      paramCanvas.save();
      paramCanvas.concat(this.mMatrix);
      super.draw(paramCanvas);
      paramCanvas.restore();
    }
    
    public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = 1;
      super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      float f1 = (paramInt1 + paramInt3) / 2;
      float f2 = (paramInt2 + paramInt4) / 2;
      paramInt1 = 0;
      if (this.mPivotX != f1)
      {
        this.mPivotX = f1;
        paramInt1 = 1;
      }
      if (this.mPivotY != f2)
      {
        this.mPivotY = f2;
        paramInt1 = i;
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          aoo();
        }
        return;
      }
    }
    
    public void setRotation(float paramFloat)
    {
      if (this.mRotation != paramFloat)
      {
        this.mRotation = paramFloat;
        aoo();
      }
    }
    
    public void setScale(float paramFloat)
    {
      if (this.mScale != paramFloat)
      {
        this.mScale = paramFloat;
        aoo();
      }
    }
    
    public void translate(float paramFloat1, float paramFloat2)
    {
      a(this.mX + paramFloat1, this.mY + paramFloat2, this.mWidth, this.mHeight);
    }
  }
  
  public static class c
  {
    boolean SK;
    boolean active;
    
    public void a(BufferedReader paramBufferedReader)
      throws IOException
    {
      if (!this.SK)
      {
        this.active = imx.a(paramBufferedReader, "active");
        return;
      }
      this.active = true;
    }
    
    public void iu(boolean paramBoolean)
    {
      this.SK = paramBoolean;
    }
  }
  
  public static class d
    extends imx.c
  {
    private float gE;
    private float gF;
    
    public float O()
    {
      return this.gE + (this.gF - this.gE) * imt.N();
    }
    
    public void a(BufferedReader paramBufferedReader)
      throws IOException
    {
      super.a(paramBufferedReader);
      if (!this.active) {
        return;
      }
      this.gE = imx.a(paramBufferedReader, "lowMin");
      this.gF = imx.a(paramBufferedReader, "lowMax");
    }
  }
  
  public static class e
    extends imx.d
  {
    float[] Q = { 0.0F };
    private float[] S = { 1.0F };
    private boolean SL;
    private float gG;
    private float gH;
    
    public float P()
    {
      return this.gG + (this.gH - this.gG) * imt.N();
    }
    
    public void a(BufferedReader paramBufferedReader)
      throws IOException
    {
      int j = 0;
      super.a(paramBufferedReader);
      if (!this.active) {}
      for (;;)
      {
        return;
        this.gG = imx.a(paramBufferedReader, "highMin");
        this.gH = imx.a(paramBufferedReader, "highMax");
        this.SL = imx.a(paramBufferedReader, "relative");
        this.S = new float[imx.a(paramBufferedReader, "scalingCount")];
        int i = 0;
        while (i < this.S.length)
        {
          this.S[i] = imx.a(paramBufferedReader, "scaling" + i);
          i += 1;
        }
        this.Q = new float[imx.a(paramBufferedReader, "timelineCount")];
        i = j;
        while (i < this.Q.length)
        {
          this.Q[i] = imx.a(paramBufferedReader, "timeline" + i);
          i += 1;
        }
      }
    }
    
    public boolean isRelative()
    {
      return this.SL;
    }
    
    public float p(float paramFloat)
    {
      float[] arrayOfFloat1 = this.Q;
      int j = arrayOfFloat1.length;
      int i = 1;
      if (i < j) {
        if (arrayOfFloat1[i] <= paramFloat) {}
      }
      for (;;)
      {
        if (i == -1)
        {
          return this.S[(j - 1)];
          i += 1;
          break;
        }
        float[] arrayOfFloat2 = this.S;
        j = i - 1;
        float f1 = arrayOfFloat2[j];
        float f2 = arrayOfFloat1[j];
        float f3 = arrayOfFloat2[i];
        return (paramFloat - f2) / (arrayOfFloat1[i] - f2) * (f3 - f1) + f1;
        i = -1;
      }
    }
  }
  
  public static class f
  {
    public static int ao(String paramString)
    {
      if ((paramString == null) || (paramString.equals("both"))) {}
      do
      {
        return 0;
        if (paramString.equals("top")) {
          return 1;
        }
      } while (!paramString.equals("bottom"));
      return 2;
    }
  }
  
  public static class g
  {
    public static int ao(String paramString)
    {
      if ((paramString == null) || (paramString.equals("point"))) {}
      do
      {
        return 0;
        if (paramString.equals("line")) {
          return 1;
        }
        if (paramString.equals("square")) {
          return 2;
        }
      } while (!paramString.equals("ellipse"));
      return 3;
    }
  }
  
  public static class h
    extends imx.c
  {
    boolean SM;
    int TI = 0;
    int shape = 0;
    
    public void a(BufferedReader paramBufferedReader)
      throws IOException
    {
      super.a(paramBufferedReader);
      if (!this.active) {}
      do
      {
        return;
        this.shape = imx.g.ao(imx.a(paramBufferedReader, "shape"));
      } while (this.shape != 3);
      this.SM = imx.a(paramBufferedReader, "edges");
      this.TI = imx.f.ao(imx.a(paramBufferedReader, "side"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     imx
 * JD-Core Version:    0.7.0.1
 */