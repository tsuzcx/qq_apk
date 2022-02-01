import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class aaqu
  implements SeekBar.OnSeekBarChangeListener
{
  public aaqu(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    this.this$0.ciN = paramInt;
    if (paramBoolean) {
      NewFlowCameraActivity.a(this.this$0, this.this$0.ciN, false);
    }
    float f = this.this$0.ciN / 100.0F;
    if (f != this.this$0.rx)
    {
      this.this$0.rx = f;
      if (this.this$0.a != null) {
        this.this$0.a.a(false, this.this$0.rx, this.this$0.ciN);
      }
    }
    if (paramBoolean) {
      NewFlowCameraActivity.a(this.this$0).setContentDescription(acfp.m(2131709018) + this.this$0.ciN + "%");
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if (this.this$0.b != null) {
      this.this$0.b.removeMessages(1011);
    }
    if (this.this$0.mTip != null) {
      this.this$0.mTip.setVisibility(0);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (this.this$0.rx >= 0.0F)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("beauty_setting", 0);
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localSharedPreferences.edit().putFloat("beauty_radius" + str, this.this$0.rx);
      localSharedPreferences.edit().putFloat("beauty_whitenmag" + str, this.this$0.rx);
      localSharedPreferences.edit().putInt("beauty_level" + str, paramSeekBar.getProgress());
      localSharedPreferences.edit().commit();
      if (QLog.isColorLevel()) {
        QLog.d("beauty", 2, "onStopTrackingTouch mBeautyValue" + this.this$0.rx + " mBeautyProcess=" + paramSeekBar.getProgress());
      }
      if (this.this$0.b != null)
      {
        this.this$0.b.removeMessages(1011);
        this.this$0.b.sendEmptyMessageDelayed(1011, NewFlowCameraActivity.Mq);
      }
      if (this.this$0.mTip != null) {
        this.this$0.mTip.setVisibility(4);
      }
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaqu
 * JD-Core Version:    0.7.0.1
 */