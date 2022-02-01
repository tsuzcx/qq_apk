import android.widget.TextView;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment.6.1;

public class adsl
  extends adsm.a
{
  public adsl(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onStatusChanged(int paramInt)
  {
    if (ArkIDESettingFragment.a(this.b) != null)
    {
      TextView localTextView = ArkIDESettingFragment.a(this.b);
      ArkAppCenter.a().postToMainThread(new ArkIDESettingFragment.6.1(this, paramInt, localTextView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adsl
 * JD-Core Version:    0.7.0.1
 */