import android.support.annotation.NonNull;

public class twl
{
  public String a;
  public String b;
  
  public twl(@NonNull String paramString)
  {
    this.a = paramString;
    vxp.a(paramString);
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
      paramObject = (twl)paramObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twl
 * JD-Core Version:    0.7.0.1
 */