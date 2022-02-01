import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aahk
  implements View.OnClickListener
{
  aahk(aahb paramaahb) {}
  
  public void onClick(View paramView)
  {
    aahb.a(this.this$0).app.a().gK("0X800474F", 1);
    avhc.c(aahb.a(this.this$0), 4, null);
    anot.c(aahb.a(this.this$0).app, "dc00898", "", "", "0X8009EE5", "0X8009EE5", 3, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aahk
 * JD-Core Version:    0.7.0.1
 */