import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class assn
  extends BaseJsPlugin
{
  private void a(RequestEvent paramRequestEvent, String paramString1, int paramInt, String paramString2)
  {
    MiniAppController.getInstance().setActivityResultListener(new asso(this, paramRequestEvent));
    BaseActivity localBaseActivity = (BaseActivity)this.mMiniAppContext.getAttachedActivity();
    if ((TroopInfo)localBaseActivity.getAppInterface().getEntityManagerFactory().createEntityManager().find(TroopInfo.class, paramString1) != null)
    {
      gotoSelectMembers(paramInt, paramString2, localBaseActivity, paramString1);
      return;
    }
    paramRequestEvent.fail(acfp.m(2131707042));
  }
  
  private static void gotoSelectMembers(int paramInt, String paramString1, BaseActivity paramBaseActivity, String paramString2)
  {
    Intent localIntent = new Intent(paramBaseActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 1);
    localIntent.putExtra("param_from", 37);
    localIntent.putExtra("param_entrance", 37);
    localIntent.putExtra("param_only_troop_member", true);
    localIntent.putExtra("param_max", paramInt);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_title", paramString1);
    localIntent.putExtra("group_uin", paramString2);
    localIntent.putExtra("param_groupcode", paramString2);
    localIntent.putExtra("group_name", paramString1);
    localIntent.putExtra("param_exit_animation", 3);
    paramBaseActivity.startActivityForResult(localIntent, 10);
    paramBaseActivity.overridePendingTransition(2130772009, 0);
  }
  
  @JsEvent({"getMultiMemList"})
  public void getMultiMemList(RequestEvent paramRequestEvent)
  {
    Object localObject = null;
    int j = 0;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramRequestEvent.jsonParams).optJSONObject("data").optJSONObject("data");
        if (localJSONObject != null) {
          continue;
        }
        str = null;
      }
      catch (Exception paramRequestEvent)
      {
        JSONObject localJSONObject;
        String str;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("GroupPlugin", 2, "===>onInvoke exception", paramRequestEvent);
        return;
        paramRequestEvent.fail(acfp.m(2131707043));
        return;
        if (localJSONObject != null) {
          continue;
        }
        int i = 0;
        if (localJSONObject != null) {
          continue;
        }
        if (localJSONObject != null) {
          continue;
        }
        continue;
      }
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (j < 1) || (j > 3))
      {
        paramRequestEvent.fail(acfp.m(2131707044));
        return;
        str = localJSONObject.optString("title");
        continue;
        i = localJSONObject.optInt("limitNum", 1);
        continue;
        localObject = localJSONObject.optString("listId");
        continue;
        j = localJSONObject.optInt("type");
      }
      else if (j == 1)
      {
        a(paramRequestEvent, (String)localObject, i, str);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     assn
 * JD-Core Version:    0.7.0.1
 */