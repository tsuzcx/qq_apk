public class wsz
  extends bhwk
{
  private bhwf<Boolean> a = new bhwf();
  private bhwf<Boolean> b = new bhwf();
  private bhwf<Boolean> c = new bhwf();
  
  public bhwf<Boolean> a()
  {
    return this.a;
  }
  
  public boolean a()
  {
    if (this.b.a() != null) {
      return ((Boolean)this.b.a()).booleanValue();
    }
    return false;
  }
  
  public bhwf<Boolean> b()
  {
    return this.b;
  }
  
  public boolean b()
  {
    if (this.c.a() != null) {
      return ((Boolean)this.c.a()).booleanValue();
    }
    return false;
  }
  
  public bhwf<Boolean> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wsz
 * JD-Core Version:    0.7.0.1
 */