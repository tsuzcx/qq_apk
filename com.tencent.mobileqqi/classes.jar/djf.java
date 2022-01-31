import android.os.Bundle;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.observer.GameCenterObserver;

public class djf
  extends GameCenterObserver
{
  public djf(QQSettingMe paramQQSettingMe) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.b) {
      this.a.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     djf
 * JD-Core Version:    0.7.0.1
 */