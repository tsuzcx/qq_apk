import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.open.agent.OpenCardContainer.b;
import com.tencent.open.agent.OpenCardContainer.e;
import com.tencent.open.agent.OpenCardContainer.f;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class arsa
  implements View.OnClickListener
{
  public arsa(OpenCardContainer.e parame, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((OpenCardContainer.e.a(this.b) == null) || (this.val$position >= OpenCardContainer.e.a(this.b).size()) || (this.val$position < 0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.b.this$0.mContext != null) && (OpenCardContainer.e.a(this.b).get(this.val$position) != null) && (OpenCardContainer.a(this.b.this$0) != null)) {
        OpenCardContainer.a(this.b.this$0).mq(((OpenCardContainer.f)OpenCardContainer.e.a(this.b).get(this.val$position)).awp);
      }
      OpenCardContainer.e.a(this.b).remove(OpenCardContainer.e.a(this.b).get(this.val$position));
      this.b.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arsa
 * JD-Core Version:    0.7.0.1
 */