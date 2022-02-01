import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Properties;

public class alxg
{
  public static String bZh;
  public static boolean cAm;
  public static int dyL;
  public static int orientation;
  public static long videoDuration;
  
  public static void Oo(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      aaqi.ao("", "0X8007BB7", str);
      return;
    }
  }
  
  public static void clear()
  {
    cAm = false;
    bZh = null;
    orientation = 90;
    dyL = 2;
    videoDuration = 0L;
  }
  
  public static void dD(int paramInt, String paramString)
  {
    try
    {
      long l = ambd.at(paramString);
      if (l == 0L) {}
      for (float f = -1.0F;; f = paramInt * 1000.0F / (float)l)
      {
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "capture_video_fps", false, f, 0L, null, "");
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void dKC()
  {
    if (cAm)
    {
      aaqi.h("", "0X80072C3", yH(), bZh, "", "");
      return;
    }
    aaqi.ao("", "0X80072C2", yH());
  }
  
  public static void dKD()
  {
    if (cAm)
    {
      aaqi.h("", "0X8006A18", String.valueOf(videoDuration), yG(), yH(), bZh);
      return;
    }
    aaqi.h("", "0X8006A13", String.valueOf(videoDuration), yG(), yH(), "");
  }
  
  public static void dKE()
  {
    aaqi.ec("", "0X80072C1");
  }
  
  public static void dKF()
  {
    aaqi.ec("", "0X8006A12");
  }
  
  public static void dKG()
  {
    aaqi.ec("", "0X8006A15");
    aasp.c("shortvideo_rotate_camera", null);
  }
  
  public static void dKH()
  {
    if (!TextUtils.isEmpty(bZh)) {}
  }
  
  public static void f(Activity paramActivity, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
        if (paramInt2 == -1)
        {
          if (cAm)
          {
            aaqi.h("", "0X80072C5", yH(), bZh, "", "");
            return;
          }
          aaqi.ao("", "0X80072C4", yH());
          return;
        }
      } while (paramInt2 != 0);
      if (cAm)
      {
        aaqi.ec("", "0X80072C6");
        return;
      }
      aaqi.ec("", "0X80072C7");
      return;
      if (paramInt2 == -1)
      {
        paramActivity = new Properties();
        paramActivity.setProperty("shortvideo_duration", String.valueOf(videoDuration));
        paramActivity.setProperty("shortvideo_rotation", yG());
        paramActivity.setProperty("shortvideo_camera", yH());
        if (!cAm)
        {
          aaqi.h("", "0X8006A16", String.valueOf(videoDuration), yG(), yH(), "");
          aasp.c("shortvideo_send_noeffects", paramActivity);
          return;
        }
        aaqi.h("", "0X8006A19", String.valueOf(videoDuration), yG(), yH(), bZh);
        aasp.c("shortvideo_send_effects", paramActivity);
        return;
      }
    } while (paramInt2 != 0);
    if (cAm)
    {
      aaqi.ec("", "0X8006A1B");
      return;
    }
    aaqi.ec("", "0X8006A17");
  }
  
  private static String yG()
  {
    if (orientation % 180 == 0) {
      return "0";
    }
    return "1";
  }
  
  private static String yH()
  {
    if (dyL == 1) {
      return "1";
    }
    return "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alxg
 * JD-Core Version:    0.7.0.1
 */