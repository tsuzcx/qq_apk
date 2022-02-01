import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Collections;
import java.util.List;

public class aaea
  implements View.OnClickListener
{
  public aaea(ChooseItemView paramChooseItemView) {}
  
  public void onClick(View paramView)
  {
    if ((ChooseItemView.a(this.this$0) != null) && (ChooseItemView.a(this.this$0).size() > 1))
    {
      Collections.shuffle(ChooseItemView.a(this.this$0));
      this.this$0.bo(ChooseItemView.a(this.this$0), true);
    }
    if (ChooseItemView.a(this.this$0) != null) {
      ChooseItemView.a(this.this$0).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaea
 * JD-Core Version:    0.7.0.1
 */