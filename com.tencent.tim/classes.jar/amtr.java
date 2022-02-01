import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amtr
  implements View.OnClickListener
{
  amtr(amtn paramamtn, amqp paramamqp, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.a.jumpUrl))
    {
      String str = amxh.k(this.a.getKeyword(), 0, amub.eZ(this.a.from));
      Intent localIntent = new Intent(this.val$context, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      this.val$context.startActivity(localIntent);
      amub.a(null, new ReportModelDC02528().module("all_result").action("clk_web_search").obj1("2073745984").ver1(this.a.keyword).ver2(amub.eZ(UniteSearchActivity.dCK)).ver5("1").ver6("1").ver7("{experiment_id:" + amub.cce + "}"));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amtr
 * JD-Core Version:    0.7.0.1
 */