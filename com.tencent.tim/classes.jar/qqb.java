import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.shareGroup.infocard.view.MyMemoriesListView.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qqb
  implements View.OnClickListener
{
  qqb(qqa.c paramc, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (this.a.b != null) {
      this.a.b.a(null, 0, this.a.jF, this.val$vid);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqb
 * JD-Core Version:    0.7.0.1
 */