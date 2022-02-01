import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;

class xkz
  implements ausj.a
{
  xkz(xkx paramxkx, MessageForPtt paramMessageForPtt, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ujt.b(this.this$0.app, this.a);
    paramView = ujt.a(this.this$0.app, this.this$0.sessionInfo, this.a);
    if (paramView != null) {}
    try
    {
      ((MessageForPtt)paramView).c2cViaOffline = true;
      ((MessageForPtt)paramView).isResend = true;
      Bundle localBundle = new Bundle();
      localBundle.putInt("DiyTextId", paramView.vipBubbleDiyTextId);
      ujt.a(this.this$0.app, this.a.istroop, this.a.frienduin, this.a.getLocalFilePath(), paramView.uniseq, true, this.a.voiceLength * 1000, this.a.voiceType, true, this.a.voiceChangeFlag, 0, true, paramView.vipSubBubbleId, localBundle);
      this.this$0.notifyDataSetChanged();
      this.c.dismiss();
      return;
    }
    catch (RuntimeException paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        Toast.makeText(this.this$0.mContext, paramView.getMessage(), 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xkz
 * JD-Core Version:    0.7.0.1
 */