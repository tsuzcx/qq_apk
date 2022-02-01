import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.mobileqq.richmedia.capture.view.BeautyBar;
import dov.com.tencent.mobileqq.richmedia.capture.view.BeautyBar.a;
import mqq.app.AppRuntime;

public class ayxi
  implements SeekBar.OnSeekBarChangeListener
{
  public ayxi(BeautyBar paramBeautyBar) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    BeautyBar.a(this.this$0, paramInt);
    if (paramBoolean) {
      BeautyBar.a(this.this$0, BeautyBar.a(this.this$0), false);
    }
    if (BeautyBar.a(this.this$0) != BeautyBar.b(this.this$0))
    {
      if (BeautyBar.a(this.this$0) != null) {
        BeautyBar.a(this.this$0).ada(BeautyBar.a(this.this$0));
      }
      BeautyBar.b(this.this$0, BeautyBar.a(this.this$0));
    }
    if (paramBoolean) {
      BeautyBar.a(this.this$0).setContentDescription(acfp.m(2131703175) + BeautyBar.a(this.this$0) + "%");
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    BeautyBar.a(this.this$0).removeMessages(1011);
    if (BeautyBar.a(this.this$0) != null) {
      BeautyBar.a(this.this$0).setVisibility(0);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (BeautyBar.b(this.this$0) >= 0)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("beauty_setting", 0);
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localSharedPreferences.edit().putFloat("beauty_radius" + str, BeautyBar.b(this.this$0));
      localSharedPreferences.edit().putFloat("beauty_whitenmag" + str, BeautyBar.b(this.this$0));
      localSharedPreferences.edit().putInt("beauty_level" + str, paramSeekBar.getProgress());
      localSharedPreferences.edit().commit();
      if (QLog.isColorLevel()) {
        QLog.d("beauty", 2, "onStopTrackingTouch mBeautyValue" + BeautyBar.b(this.this$0) + " mBeautyProcess=" + paramSeekBar.getProgress());
      }
      BeautyBar.a(this.this$0).removeMessages(1011);
      BeautyBar.a(this.this$0).sendEmptyMessageDelayed(1011, BeautyBar.Mq);
      if (BeautyBar.a(this.this$0) != null) {
        BeautyBar.a(this.this$0).setVisibility(4);
      }
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayxi
 * JD-Core Version:    0.7.0.1
 */