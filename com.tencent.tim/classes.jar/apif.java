import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class apif
  implements View.OnClickListener
{
  public apif(SubmitHomeWorkFragment paramSubmitHomeWorkFragment, ausj paramausj) {}
  
  public void onClick(View paramView)
  {
    this.val$actionSheet.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apif
 * JD-Core Version:    0.7.0.1
 */