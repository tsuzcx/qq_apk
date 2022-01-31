import com.tencent.qphone.base.util.QLog;

public class upz
{
  public upy a = new upy();
  public upy b = new upy();
  public upy c = new upy();
  public upy d = new upy();
  
  public void a()
  {
    this.a.a(this.b);
    this.c.a(this.d);
    this.b.a(this.d);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    this.a.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.b.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.c.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.a(this.b);
      this.c.a(this.d);
      this.b.a((this.c.jdField_a_of_type_Float + paramFloat1) / 2.0F, (this.c.b + paramFloat2) / 2.0F, (this.c.c + paramFloat3) / 2.0F, (this.c.jdField_a_of_type_Long + paramLong) / 2L);
      this.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
      return;
    }
    this.b.a((this.c.jdField_a_of_type_Float + paramFloat1) / 2.0F, (this.c.b + paramFloat2) / 2.0F, (this.c.c + paramFloat3) / 2.0F, (this.c.jdField_a_of_type_Long + paramLong) / 2L);
    this.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  public void a(upz paramupz)
  {
    this.a.a(paramupz.a);
    this.b.a(paramupz.b);
    this.c.a(paramupz.c);
    this.d.a(paramupz.d);
  }
  
  public void b(upz paramupz)
  {
    if (paramupz.d == this.c)
    {
      this.a = paramupz.a;
      this.c = paramupz.c;
      this.b.a((this.d.jdField_a_of_type_Float + this.c.jdField_a_of_type_Float) / 2.0F, (this.d.b + this.c.b) / 2.0F, (this.d.c + this.c.c) / 2.0F, (this.d.jdField_a_of_type_Long + this.c.jdField_a_of_type_Long) / 2L);
    }
    do
    {
      return;
      if (this.d == paramupz.c)
      {
        this.d.a(paramupz.d);
        this.b.a((this.d.jdField_a_of_type_Float + this.c.jdField_a_of_type_Float) / 2.0F, (this.d.b + this.c.b) / 2.0F, (this.d.c + this.c.c) / 2.0F, (this.d.jdField_a_of_type_Long + this.c.jdField_a_of_type_Long) / 2L);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TransPathJob", 2, "TransPathJob merge point error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     upz
 * JD-Core Version:    0.7.0.1
 */