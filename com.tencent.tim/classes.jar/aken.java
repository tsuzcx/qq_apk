import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aken
  implements View.OnClickListener
{
  aken(akef paramakef) {}
  
  public void onClick(View paramView)
  {
    ausj localausj = ausj.b(this.this$0.a);
    localausj.addButton(2131718050, 1);
    localausj.addCancelButton(2131721058);
    localausj.a(new akeo(this, localausj));
    localausj.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aken
 * JD-Core Version:    0.7.0.1
 */