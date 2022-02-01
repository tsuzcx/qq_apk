import android.util.Log;
import java.nio.charset.Charset;

public class ahqe
  implements ahqd
{
  public static final Charset logCharset = Charset.forName("UTF-8");
  
  public void b(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if ("d".equals(paramString2))
    {
      Log.d(paramString1, paramString3, paramThrowable);
      return;
    }
    if ("e".equals(paramString2))
    {
      Log.e(paramString1, paramString3, paramThrowable);
      return;
    }
    if ("w".equals(paramString2))
    {
      Log.w(paramString1, paramString3, paramThrowable);
      return;
    }
    if ("i".equals(paramString2))
    {
      Log.i(paramString1, paramString3, paramThrowable);
      return;
    }
    Log.i(paramString1, paramString3, paramThrowable);
  }
  
  public void log(String paramString1, String paramString2, String paramString3)
  {
    b(paramString1, paramString2, paramString3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahqe
 * JD-Core Version:    0.7.0.1
 */