import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer.b;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenStatusReceiver;
import com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingLocationWrapper.2;
import com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingLocationWrapper.3;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class arlh
  extends arlg
  implements aivl.a, FloatingScreenContainer.b
{
  public arlh(Context paramContext)
  {
    super(paramContext);
    duN();
  }
  
  private aivd a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return aivd.a((QQAppInterface)localAppRuntime);
    }
    return null;
  }
  
  private void duN()
  {
    this.b.setOnDragListener(this);
    if (a() != null) {
      a().a().a(this);
    }
  }
  
  private void ekf()
  {
    View localView = this.et.findViewById(2131375037);
    localView.setContentDescription("位置共享悬浮窗");
    if (auvj.isNightMode())
    {
      localView.setBackgroundColor(Color.parseColor("#4D000000"));
      return;
    }
    localView.setBackgroundColor(Color.parseColor("#00000000"));
  }
  
  public void Ze(int paramInt)
  {
    FloatingLocationWrapper.3 local3 = new FloatingLocationWrapper.3(this, paramInt);
    ThreadManager.getUIHandlerV2().post(local3);
  }
  
  public int a(FloatingScreenParams paramFloatingScreenParams, View paramView)
  {
    FloatingScreenParams localFloatingScreenParams = paramFloatingScreenParams;
    if (paramFloatingScreenParams == null)
    {
      if (this.mContext != null) {
        localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().build();
      }
    }
    else
    {
      paramFloatingScreenParams = new FloatingLocationWrapper.2(this, paramView, localFloatingScreenParams);
      ThreadManager.getUIHandlerV2().postDelayed(paramFloatingScreenParams, 500L);
      return 0;
    }
    return 2;
  }
  
  public void b(FloatingScreenParams paramFloatingScreenParams)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("qqfs_floating_sp", 4);
    int i = localSharedPreferences.getInt("KEY_QQFS_LOCATION_SHARE_CENTER_X", -2147483648);
    int j = localSharedPreferences.getInt("KEY_QQFS_LOCATION_SHARE_CENTER_Y", -2147483648);
    if ((i != -2147483648) && (j != -2147483648))
    {
      paramFloatingScreenParams.setFloatingCenterX(i);
      paramFloatingScreenParams.setFloatingCenterY(j);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FloatingLocationWrapper", 2, new Object[] { "restoreLastCenterPosition: invoked. ", " centerX: ", Integer.valueOf(i), " centerY: ", Integer.valueOf(j) });
    }
  }
  
  public void bRI()
  {
    anot.a(null, "CliOper", "", "", "0X800A977", "0X800A977", 0, 0, "", "0", "0", "");
  }
  
  public void eke()
  {
    if (this.a == null)
    {
      this.a = new FloatingScreenStatusReceiver(this.mContext);
      this.a.a(1, new arli(this));
    }
  }
  
  public void ekg()
  {
    if (this.b != null)
    {
      boolean bool = this.b.aGN();
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("qqfs_floating_sp", 4).edit();
      int i = this.b.getFloatingCenterX();
      int j = this.b.getFloatingCenterY();
      localEditor.putInt("KEY_QQFS_LOCATION_SHARE_CENTER_X", i);
      localEditor.putInt("KEY_QQFS_LOCATION_SHARE_CENTER_Y", j);
      localEditor.apply();
      if (QLog.isColorLevel()) {
        QLog.d("FloatingLocationWrapper", 2, new Object[] { "saveFloatingCenter: invoked. ", " centerX: ", Integer.valueOf(i), " centerY: ", Integer.valueOf(j), " isSmallFloating: ", Boolean.valueOf(bool) });
      }
    }
  }
  
  public void initViews(Context paramContext)
  {
    super.initViews(paramContext);
    this.FV.setContentDescription("关闭位置共享悬浮窗");
    ekf();
  }
  
  public void onThemeChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingLocationWrapper", 2, new Object[] { "onThemeChanged: invoked. ", " TAG: ", "FloatingLocationWrapper" });
    }
    ekf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arlh
 * JD-Core Version:    0.7.0.1
 */