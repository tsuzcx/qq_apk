import android.os.Bundle;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.observer.GameCenterObserver;

public class tsb
  extends GameCenterObserver
{
  public tsb(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QQSettingSettingActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tsb
 * JD-Core Version:    0.7.0.1
 */