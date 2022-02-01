import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.LangSettingFragment;
import com.tencent.mobileqq.fragment.LangSettingFragment.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahnf
  implements View.OnClickListener
{
  public ahnf(LangSettingFragment.a parama, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (LangSettingFragment.a.a(this.a, this.dag))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null) {
        anot.a(localQQAppInterface, "dc00898", "", "", "0X800A612", "0X800A612", 0, 0, "", "", "", "");
      }
    }
    if (LangSettingFragment.a(this.a.this$0) != ((Integer)paramView.getTag()).intValue()) {
      LangSettingFragment.a(this.a.this$0, ((Integer)paramView.getTag()).intValue());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahnf
 * JD-Core Version:    0.7.0.1
 */