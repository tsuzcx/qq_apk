import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class wzl
  implements CompoundButton.OnCheckedChangeListener
{
  wzl(wzk paramwzk) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GoldMsgSettingActivity", 2, "mGoldOnlyChanged. isChecked:" + paramBoolean);
    }
    wzk.a(this.a, paramBoolean);
    this.a.c = true;
    if (this.a.a.getVisibility() == 0) {
      this.a.a.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wzl
 * JD-Core Version:    0.7.0.1
 */