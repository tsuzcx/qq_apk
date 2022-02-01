import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akdd
  implements View.OnClickListener
{
  akdd(akcx paramakcx) {}
  
  public void onClick(View paramView)
  {
    ausj localausj = ausj.b(this.this$0.a);
    localausj.addButton(2131718050, 1);
    localausj.addCancelButton(2131721058);
    localausj.a(new akde(this, localausj));
    localausj.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akdd
 * JD-Core Version:    0.7.0.1
 */