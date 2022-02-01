import android.os.Bundle;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;

class ojv
  implements MiniAppLauncher.MiniAppLaunchListener
{
  ojv(oju paramoju, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    ooz.bY("WSMiniAppJumpStrategy", "[WSMiniAppJumpStrategy.java][jumpAction] onLaunchResult isSuc:" + paramBoolean + ", bundle:" + paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqMiniSdkMiniAppLauncher$MiniAppLaunchListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniSdkMiniAppLauncher$MiniAppLaunchListener.onLaunchResult(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ojv
 * JD-Core Version:    0.7.0.1
 */