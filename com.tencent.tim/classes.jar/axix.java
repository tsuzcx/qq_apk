import com.tencent.common.app.BaseApplicationImpl;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.mode.AECaptureMode;

public final class axix
{
  private static aasq b = new aasq(aqnm.getScreenWidth(), aqnm.getScreenHeight());
  
  public static aasq a()
  {
    return b;
  }
  
  public static aasq a(AECaptureMode paramAECaptureMode, aasq paramaasq, boolean paramBoolean, AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    aasq localaasq;
    if (paramAECaptureMode == AECaptureMode.NORMAL)
    {
      localaasq = paramaasq;
      if (paramBoolean)
      {
        if (paramRatio != AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
          break label50;
        }
        i = Math.min(paramaasq.mWidth, paramaasq.mHeight);
        localaasq = new aasq(i, i);
      }
    }
    label50:
    do
    {
      do
      {
        return localaasq;
        localaasq = paramaasq;
      } while (paramRatio != AEVideoStoryTopBarViewModel.Ratio.FULL);
      return paramaasq;
      localaasq = paramaasq;
    } while (paramAECaptureMode != AECaptureMode.GIF);
    int j = Math.min(paramaasq.mWidth, paramaasq.mHeight);
    int k = aqcx.dip2px(BaseApplicationImpl.getContext(), 250.0F);
    int i = j;
    if (k > 0) {
      i = Math.min(j, k);
    }
    return new aasq(i, i);
  }
  
  public static void c(aasq paramaasq)
  {
    b = paramaasq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axix
 * JD-Core Version:    0.7.0.1
 */