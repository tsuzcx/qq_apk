import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axfe
  implements View.OnClickListener
{
  axfe(axeu paramaxeu) {}
  
  public void onClick(View paramView)
  {
    axeu.a(this.this$0).setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axfe
 * JD-Core Version:    0.7.0.1
 */