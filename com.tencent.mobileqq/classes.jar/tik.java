import android.os.Bundle;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.observer.GameCenterObserver;

public class tik
  extends GameCenterObserver
{
  public tik(QQSettingMe paramQQSettingMe) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.c)
    {
      this.a.k();
      return;
    }
    QQSettingMe.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tik
 * JD-Core Version:    0.7.0.1
 */