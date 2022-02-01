import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aknp
  implements View.OnClickListener
{
  public aknp(ScanOcrActivity paramScanOcrActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ScanOcrActivity.a(this.this$0) == 1) && ((ScanOcrActivity.b(this.this$0) == 0) || (ScanOcrActivity.b(this.this$0) == 4)))
    {
      ScanOcrActivity.a(this.this$0).dCk();
      ScanOcrActivity.a(this.this$0, false);
      ScanOcrActivity.b(this.this$0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aknp
 * JD-Core Version:    0.7.0.1
 */