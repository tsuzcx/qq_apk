import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ausq
  implements View.OnClickListener
{
  ausq(ausj paramausj) {}
  
  public void onClick(View paramView)
  {
    this.this$0.dismiss();
    if (ausj.a(this.this$0) != null) {
      ausj.a(this.this$0).onDismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ausq
 * JD-Core Version:    0.7.0.1
 */