import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;

public class ofo
  implements MiniAppLauncher.MiniAppLaunchListener
{
  public ofo(WSHomeFragment paramWSHomeFragment) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("launch mini program ");
    if (paramBoolean) {}
    for (String str = "success";; str = "fail")
    {
      ooz.e("WSHomeFragment", str + ", bundle: " + paramBundle.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ofo
 * JD-Core Version:    0.7.0.1
 */