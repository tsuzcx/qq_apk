import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.music.humrecognition.HummingActivity;

public class axry
  implements View.OnClickListener
{
  public axry(HummingActivity paramHummingActivity) {}
  
  public void onClick(View paramView)
  {
    if (axrr.qH()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("HUM_HummingActivity", 2, "onClick: play mHumMusicItemInfo = " + HummingActivity.a(this.this$0));
      }
      if (HummingActivity.a(this.this$0).b(HummingActivity.a(this.this$0)))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("EXTRA_HUM_RECOGNITION_RESULT", HummingActivity.a(this.this$0));
        this.this$0.setResult(-1, localIntent);
        this.this$0.finish();
      }
      else
      {
        HummingActivity.a(this.this$0).a(HummingActivity.a(this.this$0), this.this$0.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axry
 * JD-Core Version:    0.7.0.1
 */