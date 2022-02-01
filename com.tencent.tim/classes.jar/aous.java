import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;

public class aous
  extends Handler
{
  public aous(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(this.this$0.mBid)) {
      localBundle.putString("bid", this.this$0.mBid);
    }
    if ((this.this$0.ZZ != null) && (this.this$0.ZZ.getVisibility() == 0)) {}
    int i;
    for (String str = "interestcircle";; str = "qqbuluo")
    {
      localBundle.putString("from", str);
      localBundle.putString("uin", this.this$0.app.getCurrentAccountUin());
      localBundle.putString("title", aprv.f(this.this$0.a).trim());
      localBundle.putString("content", aprv.f(this.this$0.b).trim());
      switch (paramMessage.what)
      {
      case 3: 
      default: 
        i = 3;
        TroopBarPublishUtils.a(this.this$0, 1, i, localBundle);
        return;
      }
    }
    localBundle.putString("clicktype", "music");
    if ((this.this$0.ZZ != null) && (this.this$0.ZZ.getVisibility() == 0))
    {
      i = 2;
      label210:
      if (!TextUtils.isEmpty(this.this$0.mBid)) {
        break label259;
      }
    }
    label259:
    for (paramMessage = "0";; paramMessage = this.this$0.mBid)
    {
      anot.a(null, "dc00899", "pub_page_new", "", "pub_page", "Clk_music", i, 0, paramMessage, "", "", "");
      i = 4;
      break;
      i = 1;
      break label210;
    }
    if ((this.this$0.ZZ != null) && (this.this$0.ZZ.getVisibility() == 0))
    {
      i = 2;
      if (!TextUtils.isEmpty(this.this$0.mBid)) {
        break label340;
      }
    }
    label340:
    for (paramMessage = "0";; paramMessage = this.this$0.mBid)
    {
      anot.a(null, "dc00899", "pub_page_new", "", "pub_page", "Clk_record", i, 0, paramMessage, "", "", "");
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aous
 * JD-Core Version:    0.7.0.1
 */