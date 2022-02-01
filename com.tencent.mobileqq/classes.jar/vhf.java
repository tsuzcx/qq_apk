import com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDrawer;

public class vhf
  extends vhb
{
  private vhg a;
  protected float[] a;
  protected float l;
  protected float m = -1.0F;
  protected float n;
  protected int v;
  
  public vhf(vgp paramvgp, vhc paramvhc, vhe paramvhe)
  {
    super(paramvgp, paramvhc, paramvhe);
  }
  
  public float a()
  {
    return -this.n;
  }
  
  protected float a(long paramLong)
  {
    long l1 = this.c;
    return this.o - (float)(paramLong - l1) * this.n;
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(vhg paramvhg)
  {
    this.jdField_a_of_type_Vhg = paramvhg;
  }
  
  public float[] a(long paramLong)
  {
    if (!a()) {
      return null;
    }
    float f = a(paramLong);
    if (this.jdField_a_of_type_ArrayOfFloat == null) {
      this.jdField_a_of_type_ArrayOfFloat = new float[4];
    }
    this.jdField_a_of_type_ArrayOfFloat[0] = f;
    this.jdField_a_of_type_ArrayOfFloat[1] = this.m;
    this.jdField_a_of_type_ArrayOfFloat[2] = (f + this.h);
    this.jdField_a_of_type_ArrayOfFloat[3] = (this.m + this.i);
    return this.jdField_a_of_type_ArrayOfFloat;
  }
  
  public float b()
  {
    return this.l;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Vhg != null) {
      this.jdField_a_of_type_Vhg.a();
    }
  }
  
  public void b(PhotoDanmakuDrawer paramPhotoDanmakuDrawer)
  {
    super.b(paramPhotoDanmakuDrawer);
    this.v = ((int)(this.o + this.h));
    this.n = (this.v / (float)this.jdField_a_of_type_Vhc.a());
    this.l = this.o;
  }
  
  public void b(PhotoDanmakuDrawer paramPhotoDanmakuDrawer, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Vhe != null)
    {
      if (!c())
      {
        this.l = a(this.jdField_a_of_type_Vhe.a());
        if (!b())
        {
          this.m = paramFloat2;
          a(true);
        }
        return;
      }
      a(false);
    }
    this.l = this.o;
  }
  
  public float[] b(long paramLong)
  {
    if (!a()) {
      return null;
    }
    float f = a(paramLong);
    if (this.jdField_a_of_type_ArrayOfFloat == null) {
      this.jdField_a_of_type_ArrayOfFloat = new float[4];
    }
    this.jdField_a_of_type_ArrayOfFloat[0] = f;
    this.jdField_a_of_type_ArrayOfFloat[1] = this.m;
    this.jdField_a_of_type_ArrayOfFloat[2] = (f + this.h);
    this.jdField_a_of_type_ArrayOfFloat[3] = (this.m + this.i);
    return this.jdField_a_of_type_ArrayOfFloat;
  }
  
  public float c()
  {
    return this.m;
  }
  
  public float d()
  {
    return this.l + this.h;
  }
  
  public void d()
  {
    this.l = a(this.jdField_a_of_type_Vhe.a());
  }
  
  public float e()
  {
    return this.m + this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhf
 * JD-Core Version:    0.7.0.1
 */