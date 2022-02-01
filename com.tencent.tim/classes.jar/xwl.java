import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1;
import com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.2;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class xwl
  extends BaseChatPie
{
  private adpi a;
  private String mAppName;
  private String mAppPath;
  private aqju mDialog;
  
  public xwl(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private static void aA(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      try
      {
        if (!paramJSONObject.has("forward")) {
          paramJSONObject.put("forward", 1);
        }
        if (!paramJSONObject.has("autosize"))
        {
          paramJSONObject.put("autosize", 1);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  private boolean c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    paramSessionInfo = anbi.a(paramQQAppInterface, paramSessionInfo.aTl, paramSessionInfo.troopUin, paramSessionInfo.cZ, paramArkAppMessage);
    paramQQAppInterface.b().z(paramSessionInfo);
    return true;
  }
  
  private void cfq()
  {
    if (this.mDialog != null)
    {
      this.mDialog.dismiss();
      this.mDialog = null;
    }
    cfr();
    if ((BaseActivity.sTopActivity instanceof ArkFullScreenAppActivity)) {
      ((ArkFullScreenAppActivity)BaseActivity.sTopActivity).finish();
    }
    hidePanel();
    if (this.a != null)
    {
      this.a.onDestroy();
      this.a = null;
    }
  }
  
  private void cfr()
  {
    String str = this.sessionInfo.aTl;
    int i = this.sessionInfo.cZ;
    this.app.b().N(str, i);
    this.app.b().cc(str, i);
    wyv.Da(2);
  }
  
  private void cfs()
  {
    long l = NetConnInfoCenter.getServerTime();
    acxw localacxw = this.app.a().a();
    RecentUser localRecentUser = localacxw.a(acbn.blJ, 1031);
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    localacxw.e(localRecentUser);
    localacxw.updateCache(localRecentUser);
  }
  
  private void yg(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  public void Ib()
  {
    this.TAG = "ArkDebugChatPie";
  }
  
  public boolean af(boolean paramBoolean)
  {
    this.mActivity.getWindow().addFlags(128);
    adsm.a(2, null);
    ArkAppCenter.setupArkEnvironment(true);
    ArkAppCenter.ad(new ArkDebugChatPie.1(this));
    return super.af(paramBoolean);
  }
  
  public void doOnDestroy()
  {
    ArkAppCenter.ad(new ArkDebugChatPie.2(this));
    super.doOnDestroy();
  }
  
  public void doOnStop()
  {
    this.mActivity.getWindow().clearFlags(128);
    super.doOnStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xwl
 * JD-Core Version:    0.7.0.1
 */