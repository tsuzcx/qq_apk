import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class wgw
  implements CompoundButton.OnCheckedChangeListener
{
  public wgw(QRLoginMgrActivity paramQRLoginMgrActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "qqmute onCheckedChanged:", Boolean.valueOf(paramBoolean) });
    }
    if (!bbev.g(this.a))
    {
      bcpw.a(QRLoginMgrActivity.a(this.a), 1, 2131696413, 0).b(this.a.getTitleBarHeight());
      if (!paramBoolean) {
        bool = true;
      }
      paramCompoundButton.setChecked(bool);
      return;
    }
    if (paramBoolean)
    {
      bbgg localbbgg = bbcv.a(QRLoginMgrActivity.a(this.a), 230);
      localbbgg.setTitle(2131717219);
      localbbgg.setMessage(2131717218);
      localbbgg.setPositiveButton(2131694793, new wgx(this));
      localbbgg.setNegativeButton(2131690596, new wgy(this, paramCompoundButton));
      localbbgg.show();
      axqw.b(null, "dc00898", "", "", "0X800A475", "0X800A475", 0, 0, "", "", "", "");
      return;
    }
    ((akfm)this.a.app.a(10)).a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wgw
 * JD-Core Version:    0.7.0.1
 */