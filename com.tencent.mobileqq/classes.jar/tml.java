public class tml
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public tml(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if ((paramObject instanceof tml)) {
        return false;
      }
      paramObject = (tml)paramObject;
      if ((this.b == null) || (!this.b.equals(paramObject.b))) {
        break;
      }
    } while ((this.c != null) && (this.c.equals(paramObject.c)));
    return false;
    return false;
  }
  
  public String toString()
  {
    return " bid :" + this.b + " localPath:" + this.c + "  ";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tml
 * JD-Core Version:    0.7.0.1
 */