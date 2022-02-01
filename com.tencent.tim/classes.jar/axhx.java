import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axhx
  implements View.OnClickListener
{
  axhx(axhu paramaxhu) {}
  
  public void onClick(View paramView)
  {
    axhu.a(this.a).setText(null);
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axhx
 * JD-Core Version:    0.7.0.1
 */