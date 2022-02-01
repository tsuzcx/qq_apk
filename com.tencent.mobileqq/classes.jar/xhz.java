import android.support.annotation.NonNull;

public class xhz
{
  @NonNull
  public final String a;
  @NonNull
  public final String b;
  @NonNull
  public final String c;
  public final String d;
  
  public xhz(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null))
    {
      yqp.e("Q.qqstory.playernew.TVKPreloader", "vid=%s, videoUrl=%s, localPath=%s", new Object[] { paramString1, paramString2, paramString3 });
      throw new IllegalArgumentException("vid, videoUrl, localPath should not be null");
    }
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool3;
          } while (paramObject == null);
          bool1 = bool3;
        } while (getClass() != paramObject.getClass());
        paramObject = (xhz)paramObject;
        bool1 = bool3;
      } while (!this.a.equals(paramObject.a));
      bool1 = bool3;
    } while (!this.b.equals(paramObject.b));
    if (this.d != null) {
      bool1 = this.d.equals(paramObject.d);
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramObject.d != null) {
        bool1 = false;
      }
    }
  }
  
  public int hashCode()
  {
    int j = this.a.hashCode();
    int k = this.b.hashCode();
    if (this.d != null) {}
    for (int i = this.d.hashCode();; i = 0) {
      return i + (j * 31 + k) * 31;
    }
  }
  
  public String toString()
  {
    return "PreloadItem{vid='" + this.a + '\'' + ", debugMsg='" + this.d + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhz
 * JD-Core Version:    0.7.0.1
 */