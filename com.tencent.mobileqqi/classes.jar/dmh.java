import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;

public class dmh
  extends MessageObserver
{
  public dmh(SubAccountSettingActivity paramSubAccountSettingActivity) {}
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    paramString = this.a.getString(2131562520);
    if (paramSubAccountBackProtocData.p == 0) {}
    for (int i = 2131563288;; i = 2131563291)
    {
      paramSubAccountBackProtocData = this.a.getString(i);
      this.a.a(paramString, paramSubAccountBackProtocData, this.a.getString(2131562543), new dmi(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dmh
 * JD-Core Version:    0.7.0.1
 */