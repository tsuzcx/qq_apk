import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

class ahrg
  implements View.OnClickListener
{
  ahrg(ahrb paramahrb, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    HashMap localHashMap = new HashMap();
    tbb.b(localHashMap, this.val$msgId);
    localHashMap.put(Integer.valueOf(2), this.val$msgId);
    localHashMap.put(Integer.valueOf(10), "1");
    localHashMap.put(Integer.valueOf(12), this.bLu);
    Intent localIntent = new Intent(ahrb.a(this.a), QQBrowserActivity.class);
    if (TextUtils.isEmpty(this.bLu))
    {
      localIntent.putExtra("url", "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=gzh&_wv=18950115&_wwv=393");
      localHashMap.put(Integer.valueOf(12), this.bLu + "&adtag=gzhyuyuezq");
    }
    for (;;)
    {
      tbb.a(abmt.getAppInterface(), "769", "205711", this.a.a().gameAppId, "76905", "1", "160", localHashMap);
      ahrb.a(this.a).startActivity(localIntent);
      ahrb.a(this.a).dismiss();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localIntent.putExtra("url", this.bLu);
      localHashMap.put(Integer.valueOf(12), this.bLu + "&adtag=gzhyuyuebl");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahrg
 * JD-Core Version:    0.7.0.1
 */