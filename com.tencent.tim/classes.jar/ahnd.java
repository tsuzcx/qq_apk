import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.LangSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahnd
  implements View.OnClickListener
{
  public ahnd(LangSettingFragment paramLangSettingFragment) {}
  
  public void onClick(View paramView)
  {
    LangSettingFragment.a(this.this$0).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahnd
 * JD-Core Version:    0.7.0.1
 */