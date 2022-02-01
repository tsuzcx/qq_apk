import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahoh
  implements CompoundButton.OnCheckedChangeListener
{
  public ahoh(QQSettingAutoDownloadAndSaveFragment paramQQSettingAutoDownloadAndSaveFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = QQSettingAutoDownloadAndSaveFragment.a(this.a);
    int i;
    if (paramBoolean)
    {
      i = 1;
      anot.a(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Download_new", 0, i, "", "", "", "");
      ((accy)QQSettingAutoDownloadAndSaveFragment.a(this.a).getBusinessHandler(4)).cIb();
      accy.t(QQSettingAutoDownloadAndSaveFragment.a(this.a), paramBoolean);
      if (!paramBoolean) {
        break label144;
      }
      if (aqap.a().getDownloadState() != 4) {
        aqap.a().ecY();
      }
      anot.a(null, "CliOper", "", "", "0X8007212", "0X8007212", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      ((MessageHandler)QQSettingAutoDownloadAndSaveFragment.a(this.a).getBusinessHandler(0)).Fk(paramBoolean);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break;
      label144:
      aqap.a().ecZ();
      anot.a(null, "CliOper", "", "", "0X8007213", "0X8007213", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahoh
 * JD-Core Version:    0.7.0.1
 */