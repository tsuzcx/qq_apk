import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xzg
  implements View.OnClickListener
{
  xzg(xys paramxys) {}
  
  public void onClick(View paramView)
  {
    if (!akti.a().a(this.this$0.mActivity.app, this.this$0.mActivity, this.this$0.sessionInfo, paramView)) {
      aqqb.b.J(this.this$0.mActivity, "aio");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xzg
 * JD-Core Version:    0.7.0.1
 */