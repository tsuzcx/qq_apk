import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;

public class wpm
{
  public static int ai(int paramInt1, int paramInt2)
  {
    int j = 1;
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 1)) {
      i = 3;
    }
    for (;;)
    {
      try
      {
        boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        paramInt1 = i;
        if (bool) {
          paramInt1 = i + 100;
        }
        return paramInt1;
      }
      catch (Exception localException) {}
      i = j;
      if (paramInt1 == 1)
      {
        i = j;
        if (paramInt2 == 0) {
          i = 4;
        }
      }
    }
    return i;
  }
  
  public static float b(float paramFloat, int paramInt)
  {
    return Math.abs(paramFloat) / paramInt;
  }
  
  public static int fe(int paramInt)
  {
    int i = paramInt;
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      i = paramInt + 100;
    }
    return i;
  }
  
  public static boolean gr(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 7) || (paramInt == 203) || (paramInt == 104) || (paramInt == 107) || (paramInt == 303);
  }
  
  public static boolean gs(int paramInt)
  {
    return paramInt <= 107;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wpm
 * JD-Core Version:    0.7.0.1
 */