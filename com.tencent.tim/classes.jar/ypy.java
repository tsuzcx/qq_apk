import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment.4.1;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

public class ypy
  extends aczc.b
{
  public ypy(AddContactViewPagerTroopFragment paramAddContactViewPagerTroopFragment, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ac_ft.AddContactViewPagerTroopFragment", 2, "getview onLocationFinish info = " + paramSosoLbsInfo);
    }
    if (paramInt != 0)
    {
      QLog.i("ac_ft.AddContactViewPagerTroopFragment", 1, "getview onLocationFinish, errorCode=" + paramInt);
      this.a.hy.post(new AddContactViewPagerTroopFragment.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ypy
 * JD-Core Version:    0.7.0.1
 */