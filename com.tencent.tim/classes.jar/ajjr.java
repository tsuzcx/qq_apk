import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.multicard.MultiCardFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajjr
  implements View.OnClickListener
{
  public ajjr(MultiCardFragment paramMultiCardFragment) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "onClick() called with: v = [" + paramView + "]");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajjr
 * JD-Core Version:    0.7.0.1
 */