import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver;

public class tmc
  extends DingdongPluginBizObserver
{
  public tmc(QQSettingMe paramQQSettingMe) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 5)
    {
      QQSettingMe.a(this.a, true);
      this.a.I();
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 13);
      QQSettingMe.a(this.a, true);
    } while (!QQSettingMe.f(this.a));
    QQSettingMe.d(this.a);
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tmc
 * JD-Core Version:    0.7.0.1
 */