import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

class ahri
  implements View.OnClickListener
{
  ahri(ahrb.a parama) {}
  
  public void onClick(View paramView)
  {
    if ((ahrb.a.a(this.a) == null) || (TextUtils.isEmpty(ahrb.a.a(this.a).jumpUrl))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = new Intent(ahrb.a(ahrb.a.a(this.a)), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", ahrb.a.a(this.a).jumpUrl);
      ahrb.a(ahrb.a.a(this.a)).startActivity((Intent)localObject);
      localObject = new HashMap();
      tbb.b((Map)localObject, ahrb.a.a(this.a).msgId);
      ((Map)localObject).put(Integer.valueOf(2), ahrb.a.a(this.a).msgId);
      ((Map)localObject).put(Integer.valueOf(6), ahrb.a.a(this.a).feedId);
      ((Map)localObject).put(Integer.valueOf(4), "20");
      ((Map)localObject).put(Integer.valueOf(43), ahrb.a.a(this.a).algorithmId);
      ((Map)localObject).put(Integer.valueOf(44), ahrb.a.a(this.a).type + "");
      tbb.a(abmt.getAppInterface(), "769", "205022", ahrb.a.a(this.a).a().gameAppId, "76902", "1", "160", (Map)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahri
 * JD-Core Version:    0.7.0.1
 */