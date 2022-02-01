import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;

public class yws
  implements View.OnClickListener
{
  public yws(ShowExternalTroopListActivity paramShowExternalTroopListActivity) {}
  
  public void onClick(View paramView)
  {
    if (!aqiw.isNetworkAvailable(this.this$0.context))
    {
      QQToast.a(this.this$0, 1, this.this$0.getString(2131693316), 0).show(this.this$0.getTitleBarHeight());
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    String str1 = ((TextView)paramView).getText().toString();
    Object localObject = new Intent(this.this$0.context, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", "https://qqweb.qq.com/m/relativegroup/index.html?_bid=165&_wv=4194304&source=qun_tag&keyword=" + URLEncoder.encode(str1));
    ((Intent)localObject).putExtra("hide_operation_bar", true);
    ((Intent)localObject).putExtra("hide_more_button", true);
    this.this$0.startActivity((Intent)localObject);
    localObject = this.this$0.app;
    String str2 = this.this$0.aZM;
    if (this.this$0.xv) {}
    for (str1 = "0";; str1 = "1")
    {
      anot.a((QQAppInterface)localObject, "P_CliOper", "Grp_join", "", "person_data", "Clk_quntag", 0, 0, str2, str1, "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yws
 * JD-Core Version:    0.7.0.1
 */