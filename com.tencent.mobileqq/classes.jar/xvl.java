import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class xvl
  implements CompoundButton.OnCheckedChangeListener
{
  public xvl(QRLoginMgrActivity paramQRLoginMgrActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "qqmute onCheckedChanged:", Boolean.valueOf(paramBoolean) });
    }
    if (!bdee.g(this.a))
    {
      QQToast.a(QRLoginMgrActivity.a(this.a), 1, 2131696588, 0).b(this.a.getTitleBarHeight());
      if (!paramBoolean) {
        bool = true;
      }
      paramCompoundButton.setChecked(bool);
      return;
    }
    if (paramBoolean)
    {
      bdfq localbdfq = bdcd.a(QRLoginMgrActivity.a(this.a), 230);
      localbdfq.setTitle(2131717602);
      localbdfq.setMessage(2131717601);
      localbdfq.setPositiveButton(2131694951, new xvm(this));
      localbdfq.setNegativeButton(2131690648, new xvn(this, paramCompoundButton));
      localbdfq.show();
      azmj.b(null, "dc00898", "", "", "0X800A475", "0X800A475", 0, 0, "", "", "", "");
      return;
    }
    ((alxb)this.a.app.a(10)).a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xvl
 * JD-Core Version:    0.7.0.1
 */