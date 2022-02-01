import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import cooperation.vip.qqbanner.QbossADBannerCountDownManager.1;
import cooperation.vip.qqbanner.QbossADBannerCountDownManager.2;
import java.util.Timer;
import java.util.TimerTask;

public class awmn
  extends aaje
{
  private TextView Wj;
  private awmm a;
  private TextView agE;
  private TextView agF;
  private Timer mTimer;
  private TimerTask mTimerTask;
  
  private String Hh()
  {
    if (this.a == null) {
      return "";
    }
    if (this.a.eBS != 1) {
      return this.a.cRz;
    }
    return Z(this.a.eBT, this.a.eBU);
  }
  
  private String Z(int paramInt1, int paramInt2)
  {
    String str1;
    String str2;
    if (paramInt1 > 99)
    {
      str1 = "99";
      if (paramInt2 <= 59) {
        break label106;
      }
      str2 = "59";
    }
    for (;;)
    {
      return str1 + ":" + str2;
      if ((paramInt1 >= 10) && (paramInt1 <= 99))
      {
        str1 = String.valueOf(paramInt1);
        break;
      }
      if ((paramInt1 >= 0) && (paramInt1 < 10))
      {
        str1 = "0" + String.valueOf(paramInt1);
        break;
      }
      str1 = "00";
      break;
      label106:
      if ((paramInt2 >= 10) && (paramInt2 <= 59)) {
        str2 = String.valueOf(paramInt2);
      } else if ((paramInt2 >= 0) && (paramInt2 < 10)) {
        str2 = "0" + String.valueOf(paramInt2);
      } else {
        str2 = "00";
      }
    }
  }
  
  private void abX(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.agF.setVisibility(8);
      return;
    }
    this.agF.setVisibility(0);
    this.agF.setText(paramString);
  }
  
  private void startCountDown()
  {
    stopTimer();
    this.mTimer = new Timer();
    this.mTimerTask = new QbossADBannerCountDownManager.2(this);
    this.mTimer.schedule(this.mTimerTask, 0L, 1000L);
  }
  
  private void stopTimer()
  {
    if (this.mTimerTask != null) {
      this.mTimerTask.cancel();
    }
    if (this.mTimer != null) {
      this.mTimer.cancel();
    }
    this.mTimer = null;
    this.mTimerTask = null;
  }
  
  private Drawable v(String paramString)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(aqnm.dpToPx(20.0F));
    localGradientDrawable.setColor(bV(paramString));
    return localGradientDrawable;
  }
  
  protected void a(aajc paramaajc)
  {
    super.a(paramaajc);
    ThreadManagerV2.getUIHandlerV2().post(new QbossADBannerCountDownManager.1(this, paramaajc));
  }
  
  public View bH()
  {
    View localView = super.bH();
    this.Wj = ((TextView)localView.findViewById(2131380796));
    this.agE = ((TextView)localView.findViewById(2131380921));
    this.agF = ((TextView)localView.findViewById(2131380578));
    return localView;
  }
  
  public void cuI()
  {
    super.cuI();
    stopTimer();
  }
  
  public void onRecycle()
  {
    super.onRecycle();
    stopTimer();
  }
  
  protected int yE()
  {
    return 2131562128;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awmn
 * JD-Core Version:    0.7.0.1
 */