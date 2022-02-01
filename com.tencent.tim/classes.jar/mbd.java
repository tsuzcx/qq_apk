import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentNoteCard;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentNotIntrest;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mbd
  implements View.OnClickListener
{
  public mbd(ComponentContentNoteCard paramComponentContentNoteCard) {}
  
  public void onClick(View paramView)
  {
    ComponentContentNoteCard.a(this.this$0).onClick(ComponentContentNoteCard.a(this.this$0).kR);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mbd
 * JD-Core Version:    0.7.0.1
 */