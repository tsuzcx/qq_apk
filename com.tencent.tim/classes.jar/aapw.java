import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;

public class aapw
  implements View.OnClickListener
{
  public aapw(FlowCameraActivity2 paramFlowCameraActivity2, File paramFile, Button paramButton) {}
  
  public void onClick(View paramView)
  {
    if (new File(this.this$0.bdF).exists())
    {
      this.this$0.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(this.aa)));
      this.this$0.cws();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.this$0.bdF);
      aaqi.d(this.this$0, localArrayList);
      this.fi.setClickable(false);
      this.this$0.setResult(1001);
      this.this$0.finish();
      if (aaqh.cix != 1) {
        break label127;
      }
      aaqi.B("", "0X8005F5C", "0");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label127:
      aaqi.B("", "0X8005F5C", "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aapw
 * JD-Core Version:    0.7.0.1
 */