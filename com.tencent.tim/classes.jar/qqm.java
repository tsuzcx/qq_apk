import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qqm
  implements View.OnClickListener
{
  qqm(qql.a parama) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (this.a.a.a != null) {
      this.a.a.a.a(paramView, this.a.a.a(i));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqm
 * JD-Core Version:    0.7.0.1
 */