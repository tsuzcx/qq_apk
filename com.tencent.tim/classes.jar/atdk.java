import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atdk
  implements View.OnClickListener
{
  atdk(atdh paramatdh) {}
  
  public void onClick(View paramView)
  {
    atdh.a(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atdk
 * JD-Core Version:    0.7.0.1
 */