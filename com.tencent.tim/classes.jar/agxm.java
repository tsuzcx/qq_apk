import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agxm
  implements View.OnClickListener
{
  agxm(agxi paramagxi) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.a.a() != null) {
      this.this$0.a.a().iE();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agxm
 * JD-Core Version:    0.7.0.1
 */