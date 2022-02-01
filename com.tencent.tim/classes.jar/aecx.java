import android.graphics.drawable.Drawable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;

public class aecx
{
  public static Drawable b(String paramString, int paramInt)
  {
    return aqdj.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramInt, 4, paramString);
  }
  
  public static Drawable n(String paramString)
  {
    String[] arrayOfString1 = paramString.split("&");
    paramString = "";
    int m = arrayOfString1.length;
    int i = 0;
    int j = 1;
    if (i < m)
    {
      String[] arrayOfString2 = arrayOfString1[i].split("=");
      if ((arrayOfString2.length == 2) || (arrayOfString2[0].equals("type"))) {}
      for (;;)
      {
        try
        {
          k = Integer.parseInt(arrayOfString2[1]);
          i += 1;
          j = k;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.e("UinToDrawableUtil", 1, "type wrong", localNumberFormatException);
          k = j;
          continue;
        }
        int k = j;
        if (localNumberFormatException[0].equals("uin"))
        {
          paramString = localNumberFormatException[1];
          k = j;
        }
      }
    }
    return b(paramString, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aecx
 * JD-Core Version:    0.7.0.1
 */