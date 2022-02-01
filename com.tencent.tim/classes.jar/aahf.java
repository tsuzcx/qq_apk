import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aahf
  implements View.OnClickListener
{
  aahf(aahb paramaahb) {}
  
  public void onClick(View paramView)
  {
    aboy localaboy = aboy.c();
    if (localaboy != null)
    {
      localaboy.r(aahb.a(this.this$0));
      localaboy.YQ();
      aboy.cDR();
    }
    anot.c(aahb.a(this.this$0).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 10, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aahf
 * JD-Core Version:    0.7.0.1
 */