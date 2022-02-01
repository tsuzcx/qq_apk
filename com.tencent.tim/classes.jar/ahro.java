import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.LabelInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.RedInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.TopCardInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ahro
  implements AdapterView.OnItemClickListener
{
  ahro(ahrb.e parame) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    FeedsItemData.LabelInfo localLabelInfo = (FeedsItemData.LabelInfo)this.b.b.labelInfos.get(paramInt);
    Object localObject = new HashMap();
    tbb.b((Map)localObject, localLabelInfo.msgId);
    ((Map)localObject).put(Integer.valueOf(6), localLabelInfo.reportId);
    ((Map)localObject).put(Integer.valueOf(2), localLabelInfo.msgId);
    if (ahtz.a(localLabelInfo.redInfo))
    {
      ((Map)localObject).put(Integer.valueOf(3), "1");
      ((Map)localObject).put(Integer.valueOf(4), "20");
      tbb.a(abmt.getAppInterface(), "769", "205614", localLabelInfo.appId, "76903", "1", "160", (Map)localObject);
      ahtz.KJ(localLabelInfo.redInfo.redPointId);
      ((ahrb.c)paramView.getTag()).ko.setVisibility(8);
      if (!localLabelInfo.isFriend) {
        break label301;
      }
      new LinearLayout.LayoutParams(-1, -2).gravity = 80;
      new ahum(this.b.itemView.getContext(), this.b.c.a().gameAppId, localLabelInfo.friendType).show();
      tbb.a(abmt.getAppInterface(), "769", "205355", this.b.c.a().gameAppId, "76902", "1", "160", new String[] { "", "", "20" });
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      ((Map)localObject).put(Integer.valueOf(3), "0");
      break;
      label301:
      if (!TextUtils.isEmpty(localLabelInfo.jumpUrl)) {
        if (localLabelInfo.jumpUrl.startsWith("mqqapi://miniapp/"))
        {
          MiniAppLauncher.startMiniApp(this.b.mContext, localLabelInfo.jumpUrl, 2016, null);
        }
        else
        {
          localObject = new Intent(this.b.mContext, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", localLabelInfo.jumpUrl);
          this.b.mContext.startActivity((Intent)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahro
 * JD-Core Version:    0.7.0.1
 */