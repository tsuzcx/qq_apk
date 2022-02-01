import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.a;
import com.tencent.mobileqq.activity.ChatHistory.d;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class unp
  implements View.OnClickListener
{
  public unp(ChatHistory.a parama, afpu paramafpu) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && ((paramView instanceof ImageView)))
    {
      View localView = (View)paramView.getParent();
      Object localObject = paramView.getTag();
      String str = afnu.bEr.replace("[epId]", this.a.e.epId).replace("[eId]", this.a.e.eId);
      if (this.b.this$0.a == null) {
        this.b.this$0.a = new ChatHistory.d(this.b.this$0);
      }
      this.b.this$0.a.a(1, localView, localObject, str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     unp
 * JD-Core Version:    0.7.0.1
 */