import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.adapter.contacts.BuddyListDevices;

public class yoz
  implements Animation.AnimationListener
{
  public yoz(BuddyListDevices paramBuddyListDevices, SmartDeviceProxyMgr paramSmartDeviceProxyMgr, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr.a("");
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838593);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yoz
 * JD-Core Version:    0.7.0.1
 */