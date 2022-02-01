import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.ConcurrentHashMap;

class adry
  implements View.OnClickListener
{
  adry(adrw paramadrw) {}
  
  public void onClick(View paramView)
  {
    adrw.a(this.a).put(adrw.a(this.a).appId, Integer.valueOf(1));
    Activity localActivity = adrw.a(this.a).getActivity();
    if (!aqiz.isAppInstalled(localActivity, adrw.a(this.a).packageName))
    {
      if (!TextUtils.isEmpty(adrw.a(this.a).url))
      {
        Intent localIntent = new Intent(localActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", adrw.a(this.a).url);
        localIntent.putExtra("fromArkAppDownload", true);
        localActivity.startActivity(localIntent);
      }
      ubu.a(adrw.a(this.a), -4, "need to download");
    }
    for (;;)
    {
      adrw.a(this.a).reset();
      adrw.a(this.a).dismiss();
      adrw.a(this.a, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      adrw.a(this.a, adrw.a(this.a).appId, adrw.a(this.a).params, adrw.a(this.a).packageName, adrw.a(this.a).flags, adrw.a(this.a).type, adrw.a(this.a).bvp);
      ubu.a(adrw.a(this.a), tzf.EMPTY);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adry
 * JD-Core Version:    0.7.0.1
 */