import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qqstory.settings.QGSettingFragment;

public class vyj
  implements CompoundButton.OnCheckedChangeListener
{
  public vyj(QGSettingFragment paramQGSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QGSettingFragment.a(true);
      return;
    }
    QGSettingFragment.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vyj
 * JD-Core Version:    0.7.0.1
 */