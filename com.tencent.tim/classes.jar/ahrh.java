import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class ahrh
  implements View.OnClickListener
{
  ahrh(ahrb paramahrb, String paramString1, JSONObject paramJSONObject, String paramString2) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new HashMap();
    tbb.b((Map)localObject, this.val$msgId);
    ((Map)localObject).put(Integer.valueOf(2), this.val$msgId);
    ((Map)localObject).put(Integer.valueOf(10), "2");
    tbb.a(abmt.getAppInterface(), "769", "205711", this.a.a().gameAppId, "76905", "1", "160", (Map)localObject);
    localObject = new Intent();
    ((Intent)localObject).setClass(ahrb.a(this.a), ForwardRecentActivity.class);
    ((Intent)localObject).putExtra("forward_type", 27);
    String str1 = this.bz.optString("desc", "");
    String str2 = this.bz.optString("ver", "");
    String str3 = this.bz.optString("view");
    String str4 = this.bz.optString("config");
    String str5 = this.bz.optString("meta");
    String str6 = this.bz.optString("prompt");
    ((Intent)localObject).putExtra("forward_ark_app_name", this.val$appName);
    ((Intent)localObject).putExtra("forward_ark_app_view", str3);
    ((Intent)localObject).putExtra("forward_ark_app_desc", str1);
    ((Intent)localObject).putExtra("forward_ark_app_ver", str2);
    ((Intent)localObject).putExtra("forward_ark_app_prompt", str6);
    ((Intent)localObject).putExtra("forward_ark_app_meta", str5);
    ((Intent)localObject).putExtra("forward_ark_app_config", str4);
    ((Intent)localObject).putExtra("is_ark_display_share", true);
    ((Intent)localObject).putExtra("appName", this.val$appName);
    ((Intent)localObject).putExtra("appView", str3);
    ((Intent)localObject).putExtra("appMinVersion", str2);
    ((Intent)localObject).putExtra("metaData", str5);
    ((Intent)localObject).putExtra("scale", ahrb.a(this.a).getResources().getDisplayMetrics().scaledDensity);
    ahrb.a(this.a).startActivity((Intent)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahrh
 * JD-Core Version:    0.7.0.1
 */