package cooperation.readinjoy;

import awit;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public final class ReadInJoyHelper$3
  implements Runnable
{
  public ReadInJoyHelper$3(AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    int j = 0;
    Object localObject1 = awit.y("local_kd_tab_has_set");
    if ((localObject1 instanceof Boolean)) {
      if (!((Boolean)localObject1).booleanValue()) {
        break label121;
      }
    }
    label121:
    for (int i = 1;; i = 0)
    {
      awit.f("local_kd_tab_has_set_prefix", Integer.valueOf(i));
      Object localObject2 = awit.y("local_kd_tab_switch");
      if ((localObject2 instanceof Boolean))
      {
        i = j;
        if (((Boolean)localObject2).booleanValue()) {
          i = 1;
        }
        awit.f("local_kd_tab_switch_prefix", Integer.valueOf(i));
      }
      QLog.i("ReadInJoyHelper", 1, this.val$app.getAccount() + " synSwitchCache async update preCache  hasSet:" + localObject1 + " switchOpen:" + localObject2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.readinjoy.ReadInJoyHelper.3
 * JD-Core Version:    0.7.0.1
 */