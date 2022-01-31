import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView;

public class wgw
  implements RadioGroup.OnCheckedChangeListener
{
  public wgw(RelativePersonalBottomView paramRelativePersonalBottomView) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (RelativePersonalBottomView.a(this.a).getId() == paramInt) {
      RelativePersonalBottomView.a(this.a).setCurrentItem(0);
    }
    while (RelativePersonalBottomView.b(this.a).getId() != paramInt) {
      return;
    }
    RelativePersonalBottomView.a(this.a).setCurrentItem(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wgw
 * JD-Core Version:    0.7.0.1
 */