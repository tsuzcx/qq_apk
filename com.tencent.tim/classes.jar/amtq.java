import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amtq
  implements View.OnClickListener
{
  amtq(amtn paramamtn, amqq paramamqq, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    amub.a(null, 0, this.a.from, "0X8009D5D", 0, 0, null, null);
    amub.a(null, new ReportModelDC02528().module("all_result").action("clk_web_search").obj1("2073745984").ver1(this.a.keyword).ver2(amub.eZ(UniteSearchActivity.dCK)).ver5("1").ver6("1").ver7("{experiment_id:" + amub.cce + "}"));
    String str;
    if (TextUtils.isEmpty(this.a.jumpUrl))
    {
      str = amxh.fa(this.a.from);
      str = amxh.k(this.a.getKeyword(), 0, str);
      Intent localIntent = new Intent(this.val$context, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "open Browser append suffix url = " + str);
      }
      this.val$context.startActivity(localIntent);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str = amxh.av(amxh.b(this.a.jumpUrl, this.a.getKeyword(), 0, amub.eZ(this.a.from)), this.a.from);
      amxk.E(this.val$context, this.a.getKeyword(), str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amtq
 * JD-Core Version:    0.7.0.1
 */