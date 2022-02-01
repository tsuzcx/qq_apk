import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zjf
  implements View.OnClickListener
{
  zjf(zje paramzje, zje.a parama) {}
  
  public void onClick(View paramView)
  {
    String str = String.valueOf(this.a.textView.getText());
    zje.a(this.b, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zjf
 * JD-Core Version:    0.7.0.1
 */