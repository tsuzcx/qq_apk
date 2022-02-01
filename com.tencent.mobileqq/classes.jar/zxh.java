import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zxh
  implements CompoundButton.OnCheckedChangeListener
{
  public zxh(QRLoginMgrActivity paramQRLoginMgrActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "qqmute onCheckedChanged:", Boolean.valueOf(paramBoolean) });
    }
    if (!bhnv.g(this.a))
    {
      QQToast.a(QRLoginMgrActivity.a(this.a), 1, 2131695458, 0).b(this.a.getTitleBarHeight());
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
        bhpc localbhpc = bhlq.a(QRLoginMgrActivity.a(this.a), 230);
        localbhpc.setTitle(2131715948);
        localbhpc.setMessage(2131715947);
        localbhpc.setPositiveButton(2131694098, new zxi(this));
        localbhpc.setNegativeButton(2131690580, new zxj(this, paramCompoundButton));
        localbhpc.show();
        bdll.b(null, "dc00898", "", "", "0X800A475", "0X800A475", 0, 0, "", "", "", "");
      }
      else
      {
        ((aogj)this.a.app.a(10)).a(paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxh
 * JD-Core Version:    0.7.0.1
 */