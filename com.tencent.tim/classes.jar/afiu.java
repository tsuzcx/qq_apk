import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;

public class afiu
  extends aobe
{
  public afiu(MessengerService paramMessengerService) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    Bundle localBundle;
    int i;
    String str;
    if (this.a.aC != null)
    {
      localBundle = new Bundle();
      localBundle.putString("url", null);
      if (paramTeamWorkFileImportInfo == null) {
        break label115;
      }
      i = paramTeamWorkFileImportInfo.retCode;
      localBundle.putInt("retCode", i);
      if (paramTeamWorkFileImportInfo == null) {
        break label120;
      }
      str = paramTeamWorkFileImportInfo.cjF;
      label53:
      localBundle.putString("errorStr", str);
      if (paramTeamWorkFileImportInfo == null) {
        break label126;
      }
    }
    label115:
    label120:
    label126:
    for (paramTeamWorkFileImportInfo = paramTeamWorkFileImportInfo.redirectUrl;; paramTeamWorkFileImportInfo = "")
    {
      localBundle.putString("redirectUrl", paramTeamWorkFileImportInfo);
      this.a.aC.putBundle("response", localBundle);
      this.a.cp(this.a.aC);
      this.a.aC = null;
      return;
      i = 0;
      break;
      str = "";
      break label53;
    }
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService onFileImportSuccess");
    }
    if (this.a.aC != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("url", paramString);
      if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.dNQ == 10)) {
        localBundle.putBoolean("needRefresh", true);
      }
      this.a.aC.putBundle("response", localBundle);
      this.a.cp(this.a.aC);
      this.a.aC = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afiu
 * JD-Core Version:    0.7.0.1
 */