import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;

public class dnc
  extends MessageObserver
{
  public dnc(SubLoginActivity paramSubLoginActivity) {}
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    paramString = this.a.getString(2131562520);
    if (paramSubAccountBackProtocData.p == 0) {}
    for (int i = 2131563288;; i = 2131563291)
    {
      paramSubAccountBackProtocData = this.a.getString(i);
      this.a.a(paramString, paramSubAccountBackProtocData, this.a.getString(2131562543), new dnd(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dnc
 * JD-Core Version:    0.7.0.1
 */