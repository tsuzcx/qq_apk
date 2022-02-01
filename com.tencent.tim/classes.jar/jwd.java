import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

public class jwd
  extends Handler
{
  public jwd(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3: 
      this.this$0.aAx();
      return;
    case 1: 
      if (this.this$0.isFirst)
      {
        this.this$0.updateView();
        this.this$0.aAt();
      }
      for (;;)
      {
        this.this$0.aK(this.this$0.getIntent());
        return;
        this.this$0.updateView();
      }
    case 2: 
      paramMessage = new Intent();
      paramMessage.putExtra("isNeedFinish", true);
      this.this$0.setResult(-1, paramMessage);
      this.this$0.finish();
      return;
    case 4: 
      paramMessage = new Intent(this.this$0.getActivity(), QQBrowserActivity.class);
      paramMessage.putExtra("BSafeReportPost", true);
      try
      {
        if (this.this$0.J != null) {
          paramMessage.putExtra("SafeReportData", this.this$0.J.toString().getBytes("utf-8"));
        }
        paramMessage.putExtra("hide_more_buttonbutton", true);
        paramMessage.putExtra("ishiderefresh", true);
        paramMessage.putExtra("ishidebackforward", true);
        this.this$0.startActivity(paramMessage.putExtra("url", "https://jubao.mp.qq.com/mobile/reportAccount"));
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
    }
    paramMessage = new AlphaAnimation(1.0F, 0.0F);
    paramMessage.setDuration(500L);
    this.this$0.bK.startAnimation(paramMessage);
    this.this$0.bK.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jwd
 * JD-Core Version:    0.7.0.1
 */