import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class xzu
  implements CompoundButton.OnCheckedChangeListener
{
  public xzu(QRLoginMgrActivity paramQRLoginMgrActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "qqmute onCheckedChanged:", Boolean.valueOf(paramBoolean) });
    }
    if (!bdin.g(this.a))
    {
      QQToast.a(QRLoginMgrActivity.a(this.a), 1, 2131696590, 0).b(this.a.getTitleBarHeight());
      if (!paramBoolean) {
        bool = true;
      }
      paramCompoundButton.setChecked(bool);
      return;
    }
    if (paramBoolean)
    {
      bdjz localbdjz = bdgm.a(QRLoginMgrActivity.a(this.a), 230);
      localbdjz.setTitle(2131717614);
      localbdjz.setMessage(2131717613);
      localbdjz.setPositiveButton(2131694953, new xzv(this));
      localbdjz.setNegativeButton(2131690648, new xzw(this, paramCompoundButton));
      localbdjz.show();
      azqs.b(null, "dc00898", "", "", "0X800A475", "0X800A475", 0, 0, "", "", "", "");
      return;
    }
    ((ambq)this.a.app.a(10)).a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xzu
 * JD-Core Version:    0.7.0.1
 */