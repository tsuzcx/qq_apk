package wf7;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class cm
{
  public static int R(int paramInt)
  {
    Object localObject = ch.aP();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("work_state_");
    localStringBuilder.append(paramInt);
    localObject = ((ch)localObject).getString(localStringBuilder.toString(), "");
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(aT());
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramInt2);
    localObject = ((StringBuilder)localObject).toString();
    ch localch = ch.aP();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("work_state_");
    localStringBuilder.append(paramInt1);
    localch.putString(localStringBuilder.toString(), (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.cm
 * JD-Core Version:    0.7.0.1
 */