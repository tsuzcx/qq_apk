import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class jvi
  implements View.OnClickListener
{
  jvi(juk paramjuk, String paramString, jzs.a parama) {}
  
  public void onClick(View paramView)
  {
    juk.c(this.b, this.val$url);
    PublicAccountHandler.a(this.b.app, this.b.mUin, "Grp_tribe", "interest_data", "Clk_msg");
    juk.a(this.b, this.a.title);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jvi
 * JD-Core Version:    0.7.0.1
 */