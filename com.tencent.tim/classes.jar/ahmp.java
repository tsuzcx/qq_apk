import android.widget.CompoundButton;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.fragment.AppletsSettingFragment;
import com.tencent.mobileqq.fragment.AppletsSettingFragment.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ahmp
  implements AppletsSettingFragment.a
{
  public ahmp(AppletsSettingFragment paramAppletsSettingFragment) {}
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean, AppletItem paramAppletItem)
  {
    int i = 1;
    ArrayList localArrayList;
    if (paramAppletItem != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppletsSettingFragment", 2, "OnChangeSwitchListener onChangeSwitchListener " + paramAppletItem.toString() + ",  isChecked:" + paramBoolean);
      }
      this.this$0.showProgressBar(true);
      paramCompoundButton.setChecked(paramBoolean);
      paramCompoundButton = (adag)AppletsSettingFragment.a(this.this$0).getBusinessHandler(148);
      localArrayList = new ArrayList();
      if (!paramBoolean) {
        break label113;
      }
    }
    for (;;)
    {
      paramAppletItem.setValue(i);
      localArrayList.add(paramAppletItem);
      paramCompoundButton.dS(localArrayList);
      return;
      label113:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahmp
 * JD-Core Version:    0.7.0.1
 */