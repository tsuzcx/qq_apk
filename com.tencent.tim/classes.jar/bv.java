import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.dataline.activities.LiteAdvanceActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

public class bv
  implements CompoundButton.OnCheckedChangeListener
{
  public bv(LiteAdvanceActivity paramLiteAdvanceActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool;
    if (!LiteAdvanceActivity.a(this.a, paramBoolean))
    {
      Switch localSwitch = LiteAdvanceActivity.a(this.a);
      if (!paramBoolean)
      {
        bool = true;
        localSwitch.setChecked(bool);
        QQToast.a(this.a, 1, acfp.m(2131707826), 0).show(this.a.getTitleBarHeight());
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      LiteAdvanceActivity.b(this.a, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     bv
 * JD-Core Version:    0.7.0.1
 */