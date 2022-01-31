package wf7;

public class ev$a
{
  private int pj;
  private int pk;
  private String pl;
  
  public ev$a() {}
  
  public ev$a(String paramString, int paramInt)
  {
    this.pl = paramString;
    this.pk = paramInt;
  }
  
  public ev$a(String paramString, int paramInt1, int paramInt2)
  {
    this.pj = paramInt2;
    this.pl = paramString;
    this.pk = paramInt1;
  }
  
  protected Object clone()
  {
    return new a(this.pl, this.pk, this.pj);
  }
  
  public String df()
  {
    return this.pl;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (a)paramObject;
    } while ((!paramObject.pl.equals(this.pl)) || (paramObject.pk != this.pk));
    return true;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public String toString()
  {
    if (this.pk >= 0) {
      return this.pl + ":" + this.pk;
    }
    return this.pl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.ev.a
 * JD-Core Version:    0.7.0.1
 */