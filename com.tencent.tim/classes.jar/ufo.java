import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ufo
  implements View.OnClickListener
{
  public ufo(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public void onClick(View paramView)
  {
    if (ArkFullScreenAppActivity.a(this.this$0) != null) {
      adqu.b(this.this$0.app, "FullScreenClickOper", ArkFullScreenAppActivity.a(this.this$0).appName, null, adqu.cJk, 0, 0);
    }
    this.this$0.Qq();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ufo
 * JD-Core Version:    0.7.0.1
 */