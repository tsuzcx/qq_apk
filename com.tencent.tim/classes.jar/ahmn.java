import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.AppletsSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahmn
  implements View.OnClickListener
{
  public ahmn(AppletsSettingFragment paramAppletsSettingFragment) {}
  
  public void onClick(View paramView)
  {
    if (AppletsSettingFragment.a(this.this$0))
    {
      this.this$0.bFG();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    AppletsSettingFragment localAppletsSettingFragment = this.this$0;
    if (!AppletsSettingFragment.a(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      AppletsSettingFragment.a(localAppletsSettingFragment, bool);
      AppletsSettingFragment.a(this.this$0, AppletsSettingFragment.a(this.this$0));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahmn
 * JD-Core Version:    0.7.0.1
 */