import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.4.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class vwx
  extends Client.b
{
  public vwx(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onBindedToClient()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "-->onBindedToClient");
    }
    ThreadManager.getUIHandler().postDelayed(new TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.4.1(this), 30L);
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
    long l;
    do
    {
      do
      {
        return;
      } while (paramBundle.getInt("respkey", 0) != TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.this$0).key);
      TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.this$0, false);
      str = paramBundle.getString("cmd");
      paramBundle.getString("callbackid");
      localObject = paramBundle.getBundle("response");
      paramBundle = paramBundle.getBundle("request");
      l = aodb.aO("get_url_time");
    } while ((!"ipc_cmd_get_team_work_url".equals(str)) || (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.this$0) == null));
    String str = ((Bundle)localObject).getString("url");
    Bundle localBundle = new Bundle();
    localBundle.putString("url", str);
    QIPCClientHelper.getInstance().callServer("Module_TDFileChangeNameQIPCModule", "Action_url_2_fmdb", localBundle);
    if ((!TextUtils.isEmpty(str)) && (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.this$0) != null) && (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.this$0).isCoverVisible()))
    {
      TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.b(this.this$0, ((Bundle)localObject).getBoolean("needRefresh"));
      if (this.this$0.getIntent().getStringExtra("tdsourcetag") != null)
      {
        localObject = this.this$0.getIntent().getStringExtra("tdsourcetag");
        str = aobw.bD(str, (String)localObject);
        if (TeamWorkDocEditBrowserActivity.a(this.this$0.j.getContext(), str, (String)localObject, true))
        {
          aobw.e(paramBundle, "0X8009ED7");
          this.this$0.getActivity().finish();
        }
        for (;;)
        {
          aodb.aX("WebLog_WebViewFragment", "get_url_time", String.valueOf(l) + " - url:" + str);
          return;
          aobw.e(paramBundle, "0X8009ED6");
          this.this$0.j.loadUrl(str);
        }
      }
      if (TeamWorkDocEditBrowserActivity.a(this.this$0.j.getContext(), str, "s_qq_file_edit", true))
      {
        aobw.e(paramBundle, "0X8009ED7");
        this.this$0.getActivity().finish();
      }
      for (;;)
      {
        aodb.aX("WebLog_WebViewFragment", "get_url_time", String.valueOf(l) + " - url:" + str);
        return;
        aobw.e(paramBundle, "0X8009ED6");
        this.this$0.j.loadUrl(str);
      }
    }
    int i = ((Bundle)localObject).getInt("retCode");
    str = ((Bundle)localObject).getString("errorStr");
    Object localObject = ((Bundle)localObject).getString("redirectUrl");
    if ((Math.abs(i) == 115) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      str = this.this$0.getIntent().getStringExtra("tdsourcetag");
      if (TeamWorkDocEditBrowserActivity.a(this.this$0.j.getContext(), (String)localObject, str, true))
      {
        aobw.e(paramBundle, "0X8009ED7");
        this.this$0.getActivity().finish();
      }
      for (;;)
      {
        aodb.aX("WebLog_WebViewFragment", "get_url_time", String.valueOf(l) + " - redirectUrl:" + (String)localObject);
        return;
        aobw.e(paramBundle, "0X8009ED6");
        this.this$0.j.loadUrl((String)localObject);
      }
    }
    TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.this$0).dK(i, str);
    if (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.this$0, null)) {
      aodb.aN(null, "0X800A755");
    }
    aodb.aX("WebLog_WebViewFragment", "get_url_time", "retCode = " + i + " errorStr = " + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vwx
 * JD-Core Version:    0.7.0.1
 */