import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.QQToast;

public class vok
  implements ausj.a
{
  public vok(QQLSActivity paramQQLSActivity, MessageForPtt paramMessageForPtt, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ujt.b(QQLSActivity.a(this.this$0), this.a);
    paramView = ujt.a(QQLSActivity.a(this.this$0), new SessionInfo(), this.a);
    if (paramView != null) {}
    try
    {
      ((MessageForPtt)paramView).c2cViaOffline = true;
      Bundle localBundle = new Bundle();
      localBundle.putInt("DiyTextId", paramView.vipBubbleDiyTextId);
      ujt.a(QQLSActivity.a(this.this$0), this.a.istroop, this.a.frienduin, this.a.getLocalFilePath(), paramView.uniseq, true, this.a.voiceLength * 1000, this.a.voiceType, true, this.a.voiceChangeFlag, 0, true, paramView.vipSubBubbleId, localBundle);
      this.this$0.notifyDataSetChanged();
      this.c.dismiss();
      return;
    }
    catch (RuntimeException paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        QQToast.a(this.this$0, paramView.getMessage(), 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vok
 * JD-Core Version:    0.7.0.1
 */