import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class ahoi
  implements CompoundButton.OnCheckedChangeListener
{
  public ahoi(QQSettingAutoDownloadAndSaveFragment paramQQSettingAutoDownloadAndSaveFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    auqv.cI(true, paramBoolean);
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (paramBoolean) {}
    for (;;)
    {
      anot.a(null, "CliOper", "", str, "0X800A6E3", "0X800A6E3", 0, i, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahoi
 * JD-Core Version:    0.7.0.1
 */