import android.text.TextUtils;

public class vkn
{
  private static int a(String paramString)
  {
    int i = 2;
    if (TextUtils.equals(paramString, "trends")) {
      i = 6;
    }
    return i;
  }
  
  public static vkl a(String paramString)
  {
    int i = a(paramString);
    if (!TextUtils.equals(paramString, "trends")) {
      return new vkm(i);
    }
    return new vko(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vkn
 * JD-Core Version:    0.7.0.1
 */