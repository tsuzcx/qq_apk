import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.HomeworkGuideFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class apgx
  implements View.OnClickListener
{
  public apgx(HomeworkGuideFragment paramHomeworkGuideFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().setResult(1000);
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apgx
 * JD-Core Version:    0.7.0.1
 */