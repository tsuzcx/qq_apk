import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vyl
  implements View.OnClickListener
{
  public vyl(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.this$0.GZ >= 1500L) {}
    for (;;)
    {
      try
      {
        this.this$0.GZ = System.currentTimeMillis();
        int i = paramView.getId();
        switch (i)
        {
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TroopAssistantFeedsJsHandler", 2, "feedsTitle onClick:" + localException.toString());
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      TroopStoryMainActivity.bg(this.this$0);
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "feedsTitle onClick, url:https://qqweb.qq.com/m/qunfeeds/index.html?_wv=1031&_bid=200");
      }
      if (this.this$0.rq != null) {
        this.this$0.rq.setVisibility(8);
      }
      rar.a("grp_help", "clk_video", 0, 0, new String[] { "", "", "", "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vyl
 * JD-Core Version:    0.7.0.1
 */