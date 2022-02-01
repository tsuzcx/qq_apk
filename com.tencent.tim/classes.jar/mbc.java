import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentNoteCard;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mbc
  implements View.OnClickListener
{
  public mbc(ComponentContentNoteCard paramComponentContentNoteCard) {}
  
  public void onClick(View paramView)
  {
    ComponentContentNoteCard.a(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mbc
 * JD-Core Version:    0.7.0.1
 */