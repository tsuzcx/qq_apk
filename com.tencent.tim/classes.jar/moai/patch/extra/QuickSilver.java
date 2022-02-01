package moai.patch.extra;

import android.content.Context;
import moai.patch.log.PatchLog;

public class QuickSilver
{
  private boolean implement(Class paramClass)
  {
    boolean bool2 = false;
    paramClass = paramClass.getInterfaces();
    int j = paramClass.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramClass[i].equals(QuickLaunch.class)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public QuickLaunch launch(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, long paramLong)
  {
    String str = paramString2;
    try
    {
      if (paramString2.startsWith(".")) {
        str = paramContext.getPackageName() + paramString2;
      }
      paramString2 = Class.forName(str, true, paramContext.getClassLoader());
      PatchLog.i(2024, "quick launch:" + str + ",odex:" + paramBoolean);
      if (implement(paramString2))
      {
        paramString2 = (QuickLaunch)paramString2.newInstance();
        paramString2.launch(paramContext, paramString1, paramBoolean, paramLong);
        return paramString2;
      }
    }
    catch (Exception paramContext)
    {
      PatchLog.e(2035, "quick launch fail!", paramContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.extra.QuickSilver
 * JD-Core Version:    0.7.0.1
 */