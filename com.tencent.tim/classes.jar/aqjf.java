import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;

public class aqjf
{
  public static int a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {
      return 1;
    }
    if (paramBoolean2) {
      return 2;
    }
    if (paramBoolean1) {
      return 3;
    }
    return 4;
  }
  
  public static String a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, float paramFloat)
  {
    String str = "";
    boolean bool1 = MediaPlayerManager.f(paramFloat);
    boolean bool2 = MediaPlayerManager.C(paramFloat, MediaPlayerManager.pD);
    boolean bool3 = MediaPlayerManager.C(paramFloat, MediaPlayerManager.pE);
    if ((paramInt == 0) && (bool1)) {
      if (bool3)
      {
        paramFloat = 2.0F;
        if (!paramBoolean3) {
          break label95;
        }
        str = acfp.m(2131709695) + paramFloat + acfp.m(2131709681);
      }
    }
    label95:
    do
    {
      do
      {
        return str;
        paramFloat = 1.5F;
        break;
        if (paramBoolean2) {
          return acfp.m(2131709707) + paramFloat + acfp.m(2131709702);
        }
        if (paramBoolean1) {
          return acfp.m(2131709690) + paramFloat + acfp.m(2131709689);
        }
        return acfp.m(2131709680) + paramFloat + acfp.m(2131709687);
      } while (paramInt == 0);
      str = acfp.m(2131709696);
      if (bool2) {
        return "当前为1.5倍速播放";
      }
    } while (!bool3);
    return "当前为2倍速播放";
  }
  
  public static int b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 0;
    if (!AppSetting.enableTalkBack)
    {
      if (paramBoolean3) {
        i = 2131720475;
      }
    }
    else {
      return i;
    }
    if (paramBoolean2) {
      return 2131720477;
    }
    if (paramBoolean1) {
      return 2131720479;
    }
    return 2131720476;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqjf
 * JD-Core Version:    0.7.0.1
 */