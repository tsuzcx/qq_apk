import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class xcz
  implements ausj.a
{
  xcz(xcx paramxcx, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.t.dismiss();
    switch (paramInt)
    {
    default: 
      return;
    }
    String str;
    if (this.a.this$0.sessionInfo.cZ == 1006)
    {
      str = this.a.this$0.sessionInfo.aTl;
      paramView = null;
    }
    for (;;)
    {
      ChatActivityUtils.a(this.a.this$0.app, (Activity)this.a.this$0.mContext, this.a.this$0.sessionInfo.cZ, paramView, this.a.this$0.sessionInfo.aTn, str, true, this.a.this$0.sessionInfo.troopUin, true, true, null, null);
      str = ChatActivityUtils.cr(this.a.this$0.sessionInfo.cZ);
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      anot.a(this.a.this$0.app, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "12", paramView, "", "");
      anot.a(this.a.this$0.app, "CliOper", "", "", "0X8005974", "0X8005974", 0, 0, "", "", "", "");
      return;
      paramView = this.a.this$0.sessionInfo.aTl;
      str = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xcz
 * JD-Core Version:    0.7.0.1
 */