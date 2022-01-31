import com.tencent.mobileqq.activity.SubaccountUgActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;

public class dte
  extends MessageObserver
{
  public dte(SubaccountUgActivity paramSubaccountUgActivity) {}
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (this.a.isFinishing()) {
      return;
    }
    paramString = this.a.getString(2131562520);
    if (paramSubAccountBackProtocData.p == 0) {}
    for (int i = 2131563288;; i = 2131563291)
    {
      paramSubAccountBackProtocData = this.a.getString(i);
      this.a.a(paramString, paramSubAccountBackProtocData, this.a.getString(2131562543), new dtf(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dte
 * JD-Core Version:    0.7.0.1
 */