import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.b;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView.2;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class abme
  implements View.OnClickListener
{
  public abme(CmGameLoadingView.2 param2) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.PL.setVisibility(4);
    this.a.this$0.fB.setVisibility(4);
    this.a.this$0.setProgressViewVisibility(true);
    if (this.a.val$checker != null) {
      this.a.val$checker.b(this.a.val$startCheckParam);
    }
    if ((this.a.val$startCheckParam != null) && (this.a.val$startCheckParam.mLoadingOnMainProcess)) {
      ApolloGameUtil.r(this.a.val$startCheckParam);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abme
 * JD-Core Version:    0.7.0.1
 */