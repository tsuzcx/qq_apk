import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;

public class ypb
  implements RadioGroup.OnCheckedChangeListener
{
  public ypb(RelativePersonalBottomView paramRelativePersonalBottomView) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (RelativePersonalBottomView.a(this.a).getId() == paramInt) {
      RelativePersonalBottomView.a(this.a).setCurrentItem(0);
    }
    while (RelativePersonalBottomView.b(this.a).getId() != paramInt) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = amrk.a(this.a.getContext());; bool = true)
    {
      if (!bool)
      {
        bdgm.b((PublicFragmentActivity)this.a.getContext());
        RelativePersonalBottomView.a(this.a).getChildAt(0).performClick();
        return;
      }
      RelativePersonalBottomView.a(this.a).setCurrentItem(1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ypb
 * JD-Core Version:    0.7.0.1
 */