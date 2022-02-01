import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zlq
  implements CompoundButton.OnCheckedChangeListener
{
  public zlq(QRLoginMgrActivity paramQRLoginMgrActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "qqmute onCheckedChanged:", Boolean.valueOf(paramBoolean) });
    }
    if (!NetworkUtil.isNetworkAvailable(this.a))
    {
      QQToast.a(QRLoginMgrActivity.a(this.a), 1, 2131695849, 0).b(this.a.getTitleBarHeight());
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
        QQCustomDialog localQQCustomDialog = bhdj.a(QRLoginMgrActivity.a(this.a), 230);
        localQQCustomDialog.setTitle(2131716539);
        localQQCustomDialog.setMessage(2131716538);
        localQQCustomDialog.setPositiveButton(2131694399, new zlr(this));
        localQQCustomDialog.setNegativeButton(2131690697, new zls(this, paramCompoundButton));
        localQQCustomDialog.show();
        bdla.b(null, "dc00898", "", "", "0X800A475", "0X800A475", 0, 0, "", "", "", "");
      }
      else
      {
        ((aocn)this.a.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).a(paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zlq
 * JD-Core Version:    0.7.0.1
 */