import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yws
  implements CompoundButton.OnCheckedChangeListener
{
  public yws(QRLoginMgrActivity paramQRLoginMgrActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "qqmute onCheckedChanged:", Boolean.valueOf(paramBoolean) });
    }
    if (!NetworkUtil.isNetworkAvailable(this.a))
    {
      QQToast.a(QRLoginMgrActivity.a(this.a), 1, 2131695597, 0).b(this.a.getTitleBarHeight());
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
        QQCustomDialog localQQCustomDialog = bfur.a(QRLoginMgrActivity.a(this.a), 230);
        localQQCustomDialog.setTitle(2131716182);
        localQQCustomDialog.setMessage(2131716181);
        localQQCustomDialog.setPositiveButton(2131694201, new ywt(this));
        localQQCustomDialog.setNegativeButton(2131690620, new ywu(this, paramCompoundButton));
        localQQCustomDialog.show();
        bcef.b(null, "dc00898", "", "", "0X800A475", "0X800A475", 0, 0, "", "", "", "");
      }
      else
      {
        ((amzy)this.a.app.getBusinessHandler(10)).a(paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yws
 * JD-Core Version:    0.7.0.1
 */