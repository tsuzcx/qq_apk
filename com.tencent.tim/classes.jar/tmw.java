import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class tmw
  implements View.OnClickListener
{
  public tmw(GdtVideoImaxFragment paramGdtVideoImaxFragment) {}
  
  public void onClick(View paramView)
  {
    GdtVideoImaxFragment.a(this.this$0);
    GdtVideoImaxFragment.b(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tmw
 * JD-Core Version:    0.7.0.1
 */