import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class amts
  implements View.OnClickListener
{
  amts(amtn paramamtn, amqp paramamqp, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.a.jumpUrl))
    {
      Object localObject = amxh.k(this.a.getKeyword(), 0, amub.eZ(this.a.from));
      Intent localIntent = new Intent(this.val$context, QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      this.val$context.startActivity(localIntent);
      localObject = new StringBuilder();
      int i = 0;
      if (i < this.a.Ge.size())
      {
        if (i != this.a.Ge.size() - 1) {
          ((StringBuilder)localObject).append(((amqd)this.a.Ge.get(i)).desc).append("::");
        }
        for (;;)
        {
          i += 1;
          break;
          ((StringBuilder)localObject).append(((amqd)this.a.Ge.get(i)).desc);
        }
      }
      amub.a(null, new ReportModelDC02528().module("all_result").action("clk_web_search").obj1("2073745984").ver1(this.a.keyword).ver2(amub.eZ(UniteSearchActivity.dCK)).ver4(((StringBuilder)localObject).toString()).ver5("1").ver6("2").ver7("{experiment_id:" + amub.cce + "}"));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amts
 * JD-Core Version:    0.7.0.1
 */