import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qrg
  implements View.OnClickListener
{
  qrg(qre paramqre) {}
  
  public void onClick(View paramView)
  {
    this.b.bpS();
    this.b.a.brE();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qrg
 * JD-Core Version:    0.7.0.1
 */