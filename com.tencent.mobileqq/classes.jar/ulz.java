import android.os.Bundle;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;

class ulz
  implements MiniAppLauncher.MiniAppLaunchListener
{
  ulz(ulx paramulx) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("launch mini program ");
    if (paramBoolean) {}
    for (String str = "success";; str = "fail")
    {
      uqf.d("WSHomeFragmentPresenter", str + ", bundle: " + paramBundle.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulz
 * JD-Core Version:    0.7.0.1
 */