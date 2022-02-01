import android.text.TextUtils;

public class uof
{
  private static int a(String paramString)
  {
    int i = 2;
    if (TextUtils.equals(paramString, "trends")) {
      i = 6;
    }
    return i;
  }
  
  public static uod a(String paramString)
  {
    int i = a(paramString);
    if (!TextUtils.equals(paramString, "trends")) {
      return new uoe(i);
    }
    return new uog(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uof
 * JD-Core Version:    0.7.0.1
 */