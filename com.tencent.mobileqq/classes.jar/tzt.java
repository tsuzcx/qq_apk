import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportCover;
import com.tencent.qphone.base.util.QLog;

public class tzt
  extends Client.onRemoteRespObserver
{
  public tzt(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onBindedToClient()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "-->onBindedToClient");
    }
    TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a);
  }
  
  public void onDisconnectWithService()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "-->onDisconnectWithService");
    }
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "-->onPushMsg");
    }
  }
  
  public void onResponse(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "-->onResponse");
    }
    if (paramBundle == null) {}
    String str;
    do
    {
      do
      {
        return;
      } while (paramBundle.getInt("respkey", 0) != TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a).key);
      TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a, false);
      str = paramBundle.getString("cmd");
      paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
    } while ((!"ipc_cmd_get_team_work_url".equals(str)) || (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a) == null));
    paramBundle = paramBundle.getString("url");
    if ((!TextUtils.isEmpty(paramBundle)) && (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a) != null) && (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a).a()))
    {
      this.a.a.loadUrl(paramBundle);
      return;
    }
    TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tzt
 * JD-Core Version:    0.7.0.1
 */