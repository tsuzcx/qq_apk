import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class abmd
  implements View.OnClickListener
{
  public abmd(CmGameLoadingView.1 param1) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.PL.setText(acfp.m(2131704097));
    this.a.this$0.PL.setVisibility(0);
    this.a.this$0.fB.setVisibility(4);
    this.a.this$0.setProgressViewVisibility(true);
    this.a.a.Hn(2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abmd
 * JD-Core Version:    0.7.0.1
 */