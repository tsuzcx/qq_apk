import com.tencent.qphone.base.util.QLog;

public class wsf
{
  public wse a = new wse();
  public wse b = new wse();
  public wse c = new wse();
  public wse d = new wse();
  
  public void a(wsf paramwsf)
  {
    this.a.a(paramwsf.a);
    this.b.a(paramwsf.b);
    this.c.a(paramwsf.c);
    this.d.a(paramwsf.d);
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.a(this.b);
      this.c.a(this.d);
      this.b.c((this.c.mX + paramFloat1) / 2.0F, (this.c.mY + paramFloat2) / 2.0F, (this.c.mWidth + paramFloat3) / 2.0F, (this.c.mTime + paramLong) / 2L);
      this.d.c(paramFloat1, paramFloat2, paramFloat3, paramLong);
      return;
    }
    this.b.c((this.c.mX + paramFloat1) / 2.0F, (this.c.mY + paramFloat2) / 2.0F, (this.c.mWidth + paramFloat3) / 2.0F, (this.c.mTime + paramLong) / 2L);
    this.d.c(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  public void b(wsf paramwsf)
  {
    if (paramwsf.d == this.c)
    {
      this.a = paramwsf.a;
      this.c = paramwsf.c;
      this.b.c((this.d.mX + this.c.mX) / 2.0F, (this.d.mY + this.c.mY) / 2.0F, (this.d.mWidth + this.c.mWidth) / 2.0F, (this.d.mTime + this.c.mTime) / 2L);
    }
    do
    {
      return;
      if (this.d == paramwsf.c)
      {
        this.d.a(paramwsf.d);
        this.b.c((this.d.mX + this.c.mX) / 2.0F, (this.d.mY + this.c.mY) / 2.0F, (this.d.mWidth + this.c.mWidth) / 2.0F, (this.d.mTime + this.c.mTime) / 2L);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TransPathJob", 2, "TransPathJob merge point error");
  }
  
  public void e(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    this.a.c(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.b.c(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.c.c(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.d.c(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  public void end()
  {
    this.a.a(this.b);
    this.c.a(this.d);
    this.b.a(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wsf
 * JD-Core Version:    0.7.0.1
 */