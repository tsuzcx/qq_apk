import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer.b;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenStatusReceiver;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingWatchTogetherWrapper.2;
import com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingWatchTogetherWrapper.3;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arln
  extends arlg
  implements aivl.a, FloatingScreenContainer.b, IVideoOuterStatusListener
{
  private IVideoInnerStatusListener a;
  private ImageView pd;
  
  arln(Context paramContext)
  {
    super(paramContext);
    this.b.setOnDragListener(this);
  }
  
  private void ekf()
  {
    View localView = this.et.findViewById(2131375037);
    localView.setContentDescription("一起看悬浮窗");
    if (auvj.isNightMode())
    {
      localView.setBackgroundColor(Color.parseColor("#4D000000"));
      return;
    }
    localView.setBackgroundColor(Color.parseColor("#00000000"));
  }
  
  public void Ze(int paramInt)
  {
    FloatingWatchTogetherWrapper.3 local3 = new FloatingWatchTogetherWrapper.3(this, paramInt);
    ThreadManager.getUIHandlerV2().post(local3);
  }
  
  public int a(FloatingScreenParams paramFloatingScreenParams, View paramView)
  {
    FloatingScreenParams localFloatingScreenParams = paramFloatingScreenParams;
    if (paramFloatingScreenParams == null)
    {
      if (this.mContext != null) {
        localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(1).build();
      }
    }
    else
    {
      paramFloatingScreenParams = new FloatingWatchTogetherWrapper.2(this, paramView, localFloatingScreenParams);
      ThreadManager.getUIHandlerV2().postDelayed(paramFloatingScreenParams, 500L);
      return 0;
    }
    return 2;
  }
  
  public IVideoOuterStatusListener a(IVideoInnerStatusListener paramIVideoInnerStatusListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener = paramIVideoInnerStatusListener;
    return this;
  }
  
  public void b(FloatingScreenParams paramFloatingScreenParams)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("qqfs_floating_sp", 4);
    int i = localSharedPreferences.getInt("KEY_QQFS_WATCH_TOGETHER_CENTER_X", -2147483648);
    int j = localSharedPreferences.getInt("KEY_QQFS_WATCH_TOGETHER_CENTER_Y", -2147483648);
    if ((i != -2147483648) && (j != -2147483648))
    {
      paramFloatingScreenParams.setFloatingCenterX(i);
      paramFloatingScreenParams.setFloatingCenterY(j);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FloatingWatchTogetherWrapper", 2, new Object[] { "restoreLastCenterPosition: invoked. ", " centerX: ", Integer.valueOf(i), " centerY: ", Integer.valueOf(j) });
    }
  }
  
  public void bRI() {}
  
  public void eke()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver = new FloatingScreenStatusReceiver(this.mContext);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver.a(2, new arlo(this));
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
      localEditor.putInt("KEY_QQFS_WATCH_TOGETHER_CENTER_X", i);
      localEditor.putInt("KEY_QQFS_WATCH_TOGETHER_CENTER_Y", j);
      localEditor.apply();
      if (QLog.isColorLevel()) {
        QLog.d("FloatingWatchTogetherWrapper", 2, new Object[] { "saveFloatingCenter: invoked. ", " centerX: ", Integer.valueOf(i), " centerY: ", Integer.valueOf(j), " isSmallFloating: ", Boolean.valueOf(bool) });
      }
    }
  }
  
  public void initViews(Context paramContext)
  {
    super.initViews(paramContext);
    this.FV.setContentDescription("关闭一起看悬浮窗");
    this.pd = ((ImageView)this.et.findViewById(2131375034));
    this.pd.setContentDescription(acfp.m(2131706351));
    g(new View[] { this.pd });
    a(false, new View[] { this.pd });
    ekf();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131375034) {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener.notifyVideoStart();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
    }
  }
  
  public void onOrientationChange(boolean paramBoolean) {}
  
  public void onSetVideoCover(Bitmap paramBitmap) {}
  
  public void onSetVideoCover(Drawable paramDrawable) {}
  
  public void onThemeChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingWatchTogetherWrapper", 2, new Object[] { "onThemeChanged: invoked. ", " TAG: ", "FloatingWatchTogetherWrapper" });
    }
    ekf();
  }
  
  public void onVideoBuffering() {}
  
  public void onVideoComplete(boolean paramBoolean) {}
  
  public void onVideoError(int paramInt) {}
  
  public void onVideoProgressUpdate(int paramInt) {}
  
  public void onVideoSize(int paramInt1, int paramInt2) {}
  
  public void onVideoStart(int paramInt)
  {
    a(false, new View[] { this.pd });
  }
  
  public void onVideoStop()
  {
    a(true, new View[] { this.pd });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arln
 * JD-Core Version:    0.7.0.1
 */