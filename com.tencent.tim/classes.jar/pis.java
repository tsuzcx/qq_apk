import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pis
  implements View.OnClickListener
{
  pis(pio parampio, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    ovx localovx;
    boolean bool;
    if ((this.val$context instanceof Activity))
    {
      localovx = pio.a(this.b);
      StringBuilder localStringBuilder = new StringBuilder().append("startReply getFeedCommentInfo is");
      if (localovx == null) {
        break label104;
      }
      bool = true;
      QLog.d("QCircleReplyMessagePresenter", 1, bool);
      if (localovx != null)
      {
        if (paramView.getId() != 2131380971) {
          break label109;
        }
        pio.a(this.b, localovx, 2);
      }
    }
    for (;;)
    {
      pdp.a().a((Activity)this.val$context, localovx, pio.a(this.b));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label104:
      bool = false;
      break;
      label109:
      if (this.b.mViewType == 1) {
        pio.a(this.b, localovx, 6);
      } else if (this.b.mViewType == 2) {
        pio.a(this.b, localovx, 10);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pis
 * JD-Core Version:    0.7.0.1
 */