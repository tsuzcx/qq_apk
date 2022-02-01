import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sjk
  implements RadioGroup.OnCheckedChangeListener
{
  public sjk(RelativePersonalBottomView paramRelativePersonalBottomView) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (RelativePersonalBottomView.a(this.this$0).getId() == paramInt) {
      RelativePersonalBottomView.a(this.this$0).setCurrentItem(0);
    }
    while (RelativePersonalBottomView.b(this.this$0).getId() != paramInt)
    {
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = aczy.bd(this.this$0.getContext());; bool = true)
    {
      if (!bool)
      {
        aqha.b((PublicFragmentActivity)this.this$0.getContext());
        RelativePersonalBottomView.a(this.this$0).getChildAt(0).performClick();
        break;
      }
      RelativePersonalBottomView.a(this.this$0).setCurrentItem(1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sjk
 * JD-Core Version:    0.7.0.1
 */