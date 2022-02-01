import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zlk
  implements View.OnClickListener
{
  zlk(zli paramzli) {}
  
  public void onClick(View paramView)
  {
    this.c.v.setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zlk
 * JD-Core Version:    0.7.0.1
 */