public class bvv
{
  private static final String c = bvv.class.getName();
  String a;
  String b;
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" apn = " + this.a);
    localStringBuilder.append(" name = " + this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bvv
 * JD-Core Version:    0.7.0.1
 */