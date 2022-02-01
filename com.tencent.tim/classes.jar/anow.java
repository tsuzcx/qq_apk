import android.text.TextUtils;

public class anow
{
  public static void report(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramString1 = new Exception(paramString1);
    if (paramString2 == null)
    {
      annt.e(paramString1);
      return;
    }
    annt.e(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anow
 * JD-Core Version:    0.7.0.1
 */