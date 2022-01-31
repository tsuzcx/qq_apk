import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qqcircle.fragments.QCircleHybirdFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class twg
  extends BroadcastReceiver
{
  private WeakReference<QCircleHybirdFragment> a;
  
  public twg(QCircleHybirdFragment paramQCircleHybirdFragment)
  {
    this.a = new WeakReference(paramQCircleHybirdFragment);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = (QCircleHybirdFragment)this.a.get();
    Object localObject;
    if ((paramContext != null) && (paramIntent != null))
    {
      localObject = paramIntent.getAction();
      if (!TextUtils.equals((CharSequence)localObject, "action_update_web_user_follow_state")) {
        break label96;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("uin", paramIntent.getStringExtra("uin"));
        ((JSONObject)localObject).put("followstate", paramIntent.getIntExtra("followstate", 0));
        if (paramContext.getWebView() != null) {
          paramContext.getWebView().callJs(WebViewPlugin.toJsScript("updateQCircleFollowState", (JSONObject)localObject, null));
        }
        return;
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      label96:
      if (TextUtils.equals((CharSequence)localObject, "action_update_web_tag_follow_state")) {
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("tagId", paramIntent.getStringExtra("tagId"));
          ((JSONObject)localObject).put("followstate", paramIntent.getIntExtra("followstate", 0));
          if (paramContext.getWebView() != null)
          {
            paramContext.getWebView().callJs(WebViewPlugin.toJsScript("updateQCircleTagFollowState", (JSONObject)localObject, null));
            return;
          }
        }
        catch (Exception paramContext)
        {
          QLog.e(QCircleHybirdFragment.d(), 1, "update tag follow state error.", paramContext);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twg
 * JD-Core Version:    0.7.0.1
 */