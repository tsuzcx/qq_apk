import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qqstory.settings.QGSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xqf
  implements CompoundButton.OnCheckedChangeListener
{
  public xqf(QGSettingFragment paramQGSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    QGSettingFragment.c(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xqf
 * JD-Core Version:    0.7.0.1
 */