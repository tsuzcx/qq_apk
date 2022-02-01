import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class vpw
  implements aogs.a
{
  public vpw(QQSettingMe paramQQSettingMe) {}
  
  public void bp(Bundle paramBundle)
  {
    int i = paramBundle.getInt("start_status");
    if (i == 1) {
      this.this$0.bPz();
    }
    do
    {
      do
      {
        return;
        if (i == 2)
        {
          this.this$0.bPz();
          return;
        }
      } while (i != 3);
      if (!(this.this$0.qR.getDrawable() instanceof Animatable)) {
        break;
      }
      i = paramBundle.getInt("percent");
      paramBundle = String.valueOf(i) + "%";
      this.this$0.Fh.setText(paramBundle);
    } while (!QLog.isDevelopLevel());
    QLog.d("QQSettingRedesign", 4, "NIGHTMODE_ACTION_DOWNLOADING: " + i);
    return;
    if (QQSettingMe.f(this.this$0)) {}
    for (Drawable localDrawable = this.this$0.c.getResources().getDrawable(2130846960);; localDrawable = this.this$0.c.getResources().getDrawable(2130846961))
    {
      this.this$0.qR.setImageDrawable(localDrawable);
      if (!(localDrawable instanceof Animatable)) {
        break;
      }
      ((Animatable)localDrawable).start();
      break;
    }
  }
  
  public void bq(Bundle paramBundle)
  {
    this.this$0.bPz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vpw
 * JD-Core Version:    0.7.0.1
 */