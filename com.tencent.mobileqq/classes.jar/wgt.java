import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class wgt
  implements CompoundButton.OnCheckedChangeListener
{
  public wgt(QRLoginMgrActivity paramQRLoginMgrActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "qqmute onCheckedChanged:", Boolean.valueOf(paramBoolean) });
    }
    if (!bbfj.g(this.a))
    {
      bcql.a(QRLoginMgrActivity.a(this.a), 1, 2131696414, 0).b(this.a.getTitleBarHeight());
      if (!paramBoolean) {
        bool = true;
      }
      paramCompoundButton.setChecked(bool);
      return;
    }
    if (paramBoolean)
    {
      bbgu localbbgu = bbdj.a(QRLoginMgrActivity.a(this.a), 230);
      localbbgu.setTitle(2131717230);
      localbbgu.setMessage(2131717229);
      localbbgu.setPositiveButton(2131694794, new wgu(this));
      localbbgu.setNegativeButton(2131690596, new wgv(this, paramCompoundButton));
      localbbgu.show();
      axqy.b(null, "dc00898", "", "", "0X800A475", "0X800A475", 0, 0, "", "", "", "");
      return;
    }
    ((akfl)this.a.app.a(10)).a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wgt
 * JD-Core Version:    0.7.0.1
 */