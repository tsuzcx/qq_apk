import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ztm
  implements CompoundButton.OnCheckedChangeListener
{
  public ztm(QRLoginMgrActivity paramQRLoginMgrActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "qqmute onCheckedChanged:", Boolean.valueOf(paramBoolean) });
    }
    if (!bgnt.g(this.a))
    {
      QQToast.a(QRLoginMgrActivity.a(this.a), 1, 2131695415, 0).b(this.a.getTitleBarHeight());
      if (!paramBoolean) {
        bool = true;
      }
      paramCompoundButton.setChecked(bool);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (paramBoolean)
      {
        bgpa localbgpa = bglp.a(QRLoginMgrActivity.a(this.a), 230);
        localbgpa.setTitle(2131715839);
        localbgpa.setMessage(2131715838);
        localbgpa.setPositiveButton(2131694081, new ztn(this));
        localbgpa.setNegativeButton(2131690582, new zto(this, paramCompoundButton));
        localbgpa.show();
        bcst.b(null, "dc00898", "", "", "0X800A475", "0X800A475", 0, 0, "", "", "", "");
      }
      else
      {
        ((antz)this.a.app.a(10)).a(paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ztm
 * JD-Core Version:    0.7.0.1
 */