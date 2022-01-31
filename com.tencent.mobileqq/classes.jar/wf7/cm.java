package wf7;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class cm
{
  public static int R(int paramInt)
  {
    Object localObject = ch.aP().getString("work_state_" + paramInt, "");
    try
    {
      localObject = ((String)localObject).split(",");
      if ((localObject.length == 2) && (TextUtils.equals(aT(), localObject[0])))
      {
        paramInt = Integer.valueOf(localObject[1]).intValue();
        return paramInt;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 3;
  }
  
  private static String aT()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yyyyMMdd", Locale.CHINA).format(localDate);
  }
  
  public static void q(int paramInt1, int paramInt2)
  {
    String str = aT() + "," + paramInt2;
    ch.aP().putString("work_state_" + paramInt1, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.cm
 * JD-Core Version:    0.7.0.1
 */