import android.os.Bundle;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;

class udm
  implements MiniAppLauncher.MiniAppLaunchListener
{
  udm(udl paramudl) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("launch mini program ");
    if (paramBoolean) {}
    for (String str = "success";; str = "fail")
    {
      uqf.d("WSPublisherDialog", str + ", bundle: " + paramBundle.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     udm
 * JD-Core Version:    0.7.0.1
 */