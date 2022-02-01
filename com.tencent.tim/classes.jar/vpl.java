import MQQ.PayRuleCfg;
import android.graphics.Color;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.qphone.base.util.QLog;

public class vpl
  extends aoop.a
{
  public vpl(QQSettingMe paramQQSettingMe, TextView paramTextView) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("QQSettingRedesign", 1, "VipInfoHandler updateVipItemView onLoadFialed: ", paramThrowable);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "VipInfoHandler onLoadSuccessed: " + QQSettingMe.a(this.this$0).iconUrl);
    }
    try
    {
      this.Fp.setText(QQSettingMe.a(this.this$0).iconText);
      this.Fp.setTextColor(Color.parseColor(QQSettingMe.a(this.this$0).iconTextCol));
      return;
    }
    catch (Exception paramURLDrawable)
    {
      QLog.e("QQSettingRedesign", 1, "VipInfoHandler setTextColor: " + QQSettingMe.a(this.this$0).iconTextCol, paramURLDrawable);
      this.Fp.setTextColor(-16777216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vpl
 * JD-Core Version:    0.7.0.1
 */