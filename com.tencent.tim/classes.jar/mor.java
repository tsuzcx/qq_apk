import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mor
  implements View.OnClickListener
{
  public mor(ReadInJoySelectMemberFragment paramReadInJoySelectMemberFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.aQS();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mor
 * JD-Core Version:    0.7.0.1
 */