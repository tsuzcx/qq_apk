import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class xcq
  implements ahav.d
{
  xcq(xci paramxci, String paramString1, String paramString2, MessageRecord paramMessageRecord, String paramString3, aquv paramaquv) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putString(aqrf.cwz, this.val$fUrl);
    paramView.putString(aqrf.cwu, this.aUK);
    if (!this.e.isSend()) {
      paramView.putString(aqrf.cws, this.e.senderuin);
    }
    aqrf.b(this.this$0.app, this.this$0.mContext, paramView);
    String str = this.val$keyword;
    if (this.e.isSend()) {}
    for (paramView = "0";; paramView = "1")
    {
      VasWebviewUtil.reportVipKeywords(str, paramView, "1", this.a.go(this.this$0.sessionInfo.cZ), this.this$0.sessionInfo.aTl, "", "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xcq
 * JD-Core Version:    0.7.0.1
 */