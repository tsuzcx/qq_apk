import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rvi
  implements CompoundButton.OnCheckedChangeListener
{
  public rvi(QRLoginMgrActivity paramQRLoginMgrActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "qqmute onCheckedChanged:", Boolean.valueOf(paramBoolean) });
    }
    if (!aqiw.isNetworkAvailable(this.this$0))
    {
      QQToast.a(QRLoginMgrActivity.a(this.this$0), 1, 2131698346, 0).show(this.this$0.getTitleBarHeight());
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
        aqju localaqju = aqha.a(QRLoginMgrActivity.a(this.this$0), 230);
        localaqju.setTitle(2131717192);
        localaqju.setMessage(2131717191);
        localaqju.setPositiveButton(2131721079, new rvj(this));
        localaqju.setNegativeButton(2131721058, new rvk(this, paramCompoundButton));
        localaqju.show();
        anot.a(null, "dc00898", "", "", "0X800A475", "0X800A475", 0, 0, "", "", "", "");
      }
      else
      {
        ((ackv)this.this$0.app.getBusinessHandler(10)).FA(paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rvi
 * JD-Core Version:    0.7.0.1
 */