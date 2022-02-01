import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axhy
  implements View.OnClickListener
{
  axhy(axhu paramaxhu) {}
  
  public void onClick(View paramView)
  {
    axhu.a(this.a).setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axhy
 * JD-Core Version:    0.7.0.1
 */