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

public class bfl
  extends NightModeLogic.NightModeCallback
{
  public bfl(QQSettingMe paramQQSettingMe) {}
  
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
    if ((this.a.b.getDrawable() instanceof Animatable)) {}
    for (;;)
    {
      i = paramBundle.getInt("percent");
      paramBundle = this.a.a.getString(2131364295);
      paramBundle = paramBundle + "  " + String.valueOf(i) + "%";
      this.a.c.setText(paramBundle);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("QQSettingRedesign", 4, "NIGHTMODE_ACTION_DOWNLOADING: " + i);
      return;
      Drawable localDrawable = this.a.a.getResources().getDrawable(2130838941);
      this.a.b.setImageDrawable(localDrawable);
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bfl
 * JD-Core Version:    0.7.0.1
 */