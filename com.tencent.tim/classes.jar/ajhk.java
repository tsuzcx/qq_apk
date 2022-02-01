import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajhk
  implements View.OnClickListener
{
  public ajhk(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void onClick(View paramView)
  {
    TextView localTextView = (TextView)MultiAIOFragment.a(this.this$0).findViewById(2131381020);
    ajin.djl -= 1;
    if (ajin.djl < 1) {
      ajin.djl = 1;
    }
    localTextView.setText(acfp.m(2131708567) + ajin.djl);
    MultiAIOFragment.d(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajhk
 * JD-Core Version:    0.7.0.1
 */