import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.6.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Random;

public class agbw
  implements View.OnClickListener
{
  public agbw(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.startTitleProgress();
    this.this$0.zE.setVisibility(8);
    this.this$0.Sh.setText(2131696924);
    this.this$0.iS.setOnClickListener(null);
    if (this.this$0.a != null)
    {
      agnf localagnf = this.this$0.a;
      localagnf.mRetryTimes += 1;
    }
    int i = new Random(System.currentTimeMillis()).nextInt(1500);
    new Handler().postDelayed(new FilePreviewActivity.6.1(this), i % 1001 + 500);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agbw
 * JD-Core Version:    0.7.0.1
 */