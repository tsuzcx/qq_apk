import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.FilePreviewActivity;
import com.tencent.tim.filemanager.activity.FilePreviewActivity.5.1;
import java.util.Random;

public class atoh
  implements View.OnClickListener
{
  public atoh(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.startTitleProgress();
    this.this$0.zE.setVisibility(8);
    this.this$0.Sh.setText(2131696924);
    this.this$0.iS.setOnClickListener(null);
    if (this.this$0.a != null)
    {
      atwe localatwe = this.this$0.a;
      localatwe.mRetryTimes += 1;
    }
    int i = new Random(System.currentTimeMillis()).nextInt(1500);
    new Handler().postDelayed(new FilePreviewActivity.5.1(this), i % 1001 + 500);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atoh
 * JD-Core Version:    0.7.0.1
 */