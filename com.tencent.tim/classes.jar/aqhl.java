import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class aqhl
  implements View.OnClickListener
{
  aqhl(DialogInterface.OnClickListener paramOnClickListener, aqju paramaqju) {}
  
  public void onClick(View paramView)
  {
    this.Z.onClick(this.L, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqhl
 * JD-Core Version:    0.7.0.1
 */