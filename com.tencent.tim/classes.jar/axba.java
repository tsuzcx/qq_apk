import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.WMEditItem;

class axba
  implements View.OnClickListener
{
  axba(axaw paramaxaw, axaw.a parama, WMEditItem paramWMEditItem) {}
  
  public void onClick(View paramView)
  {
    axaw.a(this.this$0, this.a.editText, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axba
 * JD-Core Version:    0.7.0.1
 */