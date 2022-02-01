import android.text.TextUtils;

public class uvz
{
  private static int a(String paramString)
  {
    int i = 2;
    if (TextUtils.equals(paramString, "trends")) {
      i = 6;
    }
    return i;
  }
  
  public static uvx a(String paramString)
  {
    int i = a(paramString);
    if (!TextUtils.equals(paramString, "trends")) {
      return new uvy(i);
    }
    return new uwa(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvz
 * JD-Core Version:    0.7.0.1
 */