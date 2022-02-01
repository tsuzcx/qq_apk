import android.graphics.Typeface;
import java.util.Hashtable;

final class zzu
  implements zwi
{
  zzu(String paramString) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    }
    for (;;)
    {
      if (i < 3) {}
      try
      {
        Typeface localTypeface = Typeface.createFromFile(paramString);
        zzr.a().put(this.a, localTypeface);
        return;
      }
      catch (Throwable localThrowable)
      {
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzu
 * JD-Core Version:    0.7.0.1
 */