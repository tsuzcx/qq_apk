import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class vua
  implements CompoundButton.OnCheckedChangeListener
{
  public vua(QRLoginMgrActivity paramQRLoginMgrActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "qqmute onCheckedChanged:", Boolean.valueOf(paramBoolean) });
    }
    if (!badq.g(this.a))
    {
      bbmy.a(QRLoginMgrActivity.a(this.a), 1, 2131630710, 0).b(this.a.getTitleBarHeight());
      if (!paramBoolean) {
        bool = true;
      }
      paramCompoundButton.setChecked(bool);
      return;
    }
    if (paramBoolean)
    {
      bafb localbafb = babr.a(QRLoginMgrActivity.a(this.a), 230);
      localbafb.setTitle(2131651427);
      localbafb.setMessage(2131651426);
      localbafb.setPositiveButton(2131629116, new vub(this));
      localbafb.setNegativeButton(2131625035, new vuc(this, paramCompoundButton));
      localbafb.show();
      awqx.b(null, "dc00898", "", "", "0X800A475", "0X800A475", 0, 0, "", "", "", "");
      return;
    }
    ((ajrc)this.a.app.a(10)).a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     vua
 * JD-Core Version:    0.7.0.1
 */