import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qqstory.settings.QGSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xzz
  implements CompoundButton.OnCheckedChangeListener
{
  public xzz(QGSettingFragment paramQGSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    QGSettingFragment.c(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzz
 * JD-Core Version:    0.7.0.1
 */