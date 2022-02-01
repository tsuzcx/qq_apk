import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qqstory.settings.QGSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xqe
  implements CompoundButton.OnCheckedChangeListener
{
  public xqe(QGSettingFragment paramQGSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      QGSettingFragment.a(true);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      QGSettingFragment.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xqe
 * JD-Core Version:    0.7.0.1
 */