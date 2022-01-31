import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.theme.NightModeLogic.NightModeCallback;
import com.tencent.qphone.base.util.QLog;

public class ddi
  extends NightModeLogic.NightModeCallback
{
  public ddi(QQSettingMe paramQQSettingMe) {}
  
  public void a(Bundle paramBundle)
  {
    this.a.j();
  }
  
  public void b(Bundle paramBundle)
  {
    int i = paramBundle.getInt("start_status");
    if (i == 1) {
      this.a.j();
    }
    do
    {
      return;
      if (i == 2)
      {
        this.a.j();
        return;
      }
    } while (i != 3);
    if ((this.a.jdField_b_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {}
    for (;;)
    {
      i = paramBundle.getInt("percent");
      paramBundle = this.a.a.getString(2131562469);
      paramBundle = paramBundle + "  " + String.valueOf(i) + "%";
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText(paramBundle);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("QQSettingRedesign", 4, "NIGHTMODE_ACTION_DOWNLOADING: " + i);
      return;
      Drawable localDrawable = this.a.a.getResources().getDrawable(2130839064);
      this.a.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ddi
 * JD-Core Version:    0.7.0.1
 */