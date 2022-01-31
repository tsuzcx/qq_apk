import com.tencent.mobileqq.activity.SetTroopAdminsActivity;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity.TroopAdmin;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.HashMap;

public class bjm
  extends TroopObserver
{
  public bjm(SetTroopAdminsActivity paramSetTroopAdminsActivity) {}
  
  protected void a(int paramInt)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "Grp", "Grant_cancel_admin", 0, 1, SetTroopAdminsActivity.a(this.a), "", "", "");
    if (SetTroopAdminsActivity.a(this.a) != null) {
      SetTroopAdminsActivity.a(this.a).dismiss();
    }
    String str;
    switch (paramInt)
    {
    case 5: 
    case 6: 
    default: 
      str = this.a.getString(2131362871);
    }
    for (;;)
    {
      QQToast.a(this.a, str, 0).b(this.a.getTitleBarHeight());
      return;
      if (SetTroopAdminsActivity.a(this.a) > 0)
      {
        str = String.format(this.a.getString(2131362875), new Object[] { Integer.valueOf(SetTroopAdminsActivity.a(this.a)) });
      }
      else
      {
        str = this.a.getString(2131362876);
        continue;
        str = this.a.getString(2131362877);
      }
    }
  }
  
  protected void a(String paramString1, String paramString2, byte paramByte)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {}
    TroopInfo localTroopInfo;
    do
    {
      return;
      paramString1 = (FriendsManagerImp)this.a.app.getManager(8);
      localTroopInfo = paramString1.a(SetTroopAdminsActivity.a(this.a));
    } while (localTroopInfo == null);
    if (localTroopInfo.Administrator != null)
    {
      if (localTroopInfo.Administrator.startsWith("|")) {
        localTroopInfo.Administrator = localTroopInfo.Administrator.substring(1);
      }
      if (!localTroopInfo.Administrator.endsWith("|")) {}
    }
    for (localTroopInfo.Administrator = localTroopInfo.Administrator.substring(0, localTroopInfo.Administrator.length() - 1); paramByte == 0; localTroopInfo.Administrator = "")
    {
      ReportController.b(this.a.app, "CliOper", "", "", "Grp", "Grant_cancel_admin", 0, 0, SetTroopAdminsActivity.a(this.a), "1", "", "");
      localTroopInfo.Administrator = localTroopInfo.Administrator.replace(paramString2 + "|", "").replace("|" + paramString2, "").replace(paramString2, "");
      int i = SetTroopAdminsActivity.a(this.a).size() - 1;
      while (i >= 0)
      {
        if (((SetTroopAdminsActivity.TroopAdmin)SetTroopAdminsActivity.a(this.a).get(i)).a.equals(paramString2)) {
          SetTroopAdminsActivity.a(this.a).remove(i);
        }
        i -= 1;
      }
    }
    if (paramByte == 1)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "Grp", "Grant_cancel_admin", 0, 0, SetTroopAdminsActivity.a(this.a), "0", "", "");
      localTroopInfo.Administrator = (localTroopInfo.Administrator + "|" + paramString2);
      SetTroopAdminsActivity.a(this.a).add(SetTroopAdminsActivity.a(this.a).get(paramString2));
    }
    paramString1.b(localTroopInfo);
    SetTroopAdminsActivity.a(this.a).remove(paramString2);
    SetTroopAdminsActivity.a(this.a).notifyDataSetChanged();
    SetTroopAdminsActivity.a(this.a);
    if (SetTroopAdminsActivity.a(this.a) != null) {
      SetTroopAdminsActivity.a(this.a).dismiss();
    }
    if (paramByte == 0) {
      QQToast.a(this.a, 2, 2131362873, 0).b(this.a.getTitleBarHeight());
    }
    for (;;)
    {
      this.a.setResult(-1);
      return;
      if (paramByte == 1) {
        QQToast.a(this.a, 2, 2131362869, 0).b(this.a.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bjm
 * JD-Core Version:    0.7.0.1
 */