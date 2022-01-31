import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class xfb
  implements CompoundButton.OnCheckedChangeListener
{
  xfb(xfa paramxfa) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GoldMsgSettingActivity", 2, "mGoldOnlyChanged. isChecked:" + paramBoolean);
    }
    xfa.a(this.a, paramBoolean);
    this.a.c = true;
    if (this.a.a.getVisibility() == 0) {
      this.a.a.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xfb
 * JD-Core Version:    0.7.0.1
 */