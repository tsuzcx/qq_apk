import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class xdq
  implements ahav.d
{
  xdq(xci paramxci, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.this$0.mContext, ChatHistoryFileActivity.class);
    paramView.putExtra("uin", this.this$0.sessionInfo.aTl);
    paramView.putExtra("uintype", this.this$0.sessionInfo.cZ);
    paramView.putExtra("uinname", this.this$0.sessionInfo.aTn);
    paramView.putExtra("com.tencent.mobileqq.ChatHistoryFileActivity.initial_tab", this.aUS);
    this.this$0.mContext.startActivity(paramView);
    ahau.JH("0X800506C");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xdq
 * JD-Core Version:    0.7.0.1
 */