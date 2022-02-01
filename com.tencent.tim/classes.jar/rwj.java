import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qrcode.ipc.VoiceScan.1;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView.a;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;

public class rwj
  implements ClickableColorSpanTextView.a
{
  public rwj(VoiceScan.1 param1) {}
  
  public void a(ClickableColorSpanTextView paramClickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan paramStatableForegroundColorSpan)
  {
    paramClickableColorSpanTextView = new Intent(rwi.a(this.a.this$0), QQBrowserActivity.class);
    paramClickableColorSpanTextView.putExtra("url", "https://kf.qq.com/touch/apifaq/1211147RVfAV140904mA3QjU.html?platform=14");
    rwi.a(this.a.this$0).startActivity(paramClickableColorSpanTextView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rwj
 * JD-Core Version:    0.7.0.1
 */