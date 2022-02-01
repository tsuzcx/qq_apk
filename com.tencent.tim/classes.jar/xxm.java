import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xxm
  implements View.OnClickListener
{
  xxm(xxh paramxxh) {}
  
  public void onClick(View paramView)
  {
    this.this$0.zI(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xxm
 * JD-Core Version:    0.7.0.1
 */