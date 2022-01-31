package tmsdk.common.d.a.c;

public class i
{
  private int a;
  private int b;
  private String c;
  
  public i() {}
  
  public i(String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramInt2;
    this.c = paramString;
    this.b = paramInt1;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.c;
  }
  
  protected Object clone()
  {
    return new i(this.c, this.b, this.a);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (i)paramObject;
    } while ((!paramObject.c.equals(this.c)) || (paramObject.b != this.b));
    return true;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public String toString()
  {
    if (this.b >= 0) {
      return this.c + ":" + this.b;
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.c.i
 * JD-Core Version:    0.7.0.1
 */