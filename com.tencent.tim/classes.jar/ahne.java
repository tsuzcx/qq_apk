import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.LangSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ahne
  implements View.OnClickListener
{
  public ahne(LangSettingFragment paramLangSettingFragment, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.val$position >= 0) && (this.val$position < LangSettingFragment.access$000().size()))
    {
      LangSettingFragment.a(this.this$0, this.val$position);
      LangSettingFragment.c(this.this$0, ((Integer)LangSettingFragment.access$000().get(this.val$position)).intValue());
    }
    if ((LangSettingFragment.a(this.this$0) != null) && (LangSettingFragment.a(this.this$0).isShowing())) {
      LangSettingFragment.a(this.this$0).dismiss();
    }
    if ((LangSettingFragment.a(this.this$0) != null) && (LangSettingFragment.a(this.this$0).isShowing())) {
      LangSettingFragment.a(this.this$0).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahne
 * JD-Core Version:    0.7.0.1
 */