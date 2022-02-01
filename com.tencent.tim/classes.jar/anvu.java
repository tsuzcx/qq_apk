import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.studymode.ModeRadioGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
public final class anvu
  implements View.OnClickListener
{
  public anvu(ModeRadioGroup paramModeRadioGroup, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (ModeRadioGroup.a(this.b)) {
      ModeRadioGroup.a(this.b, this.dMW, true, false, 4, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anvu
 * JD-Core Version:    0.7.0.1
 */