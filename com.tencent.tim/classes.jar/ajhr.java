import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajhr
  implements View.OnClickListener
{
  public ajhr(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "onClick() called with: v = [" + paramView + "]");
    }
    MultiAIOFragment.b(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajhr
 * JD-Core Version:    0.7.0.1
 */