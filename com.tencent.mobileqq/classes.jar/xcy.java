import android.support.annotation.NonNull;

public class xcy
{
  public String a;
  public String b;
  
  public xcy(@NonNull String paramString)
  {
    this.a = paramString;
    zdl.a(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (xcy)paramObject;
      if (this.a != null) {
        return this.a.equals(paramObject.a);
      }
    } while (paramObject.a == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.a != null) {
      return this.a.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.b == null) {}
    for (String str = "";; str = this.b) {
      return str + this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcy
 * JD-Core Version:    0.7.0.1
 */