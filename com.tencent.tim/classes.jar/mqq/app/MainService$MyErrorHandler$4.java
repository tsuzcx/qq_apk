package mqq.app;

import com.tencent.qphone.base.remote.FromServiceMsg;

class MainService$MyErrorHandler$4
  implements Runnable
{
  MainService$MyErrorHandler$4(MainService.MyErrorHandler paramMyErrorHandler, FromServiceMsg paramFromServiceMsg, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    MainService.MyErrorHandler.access$600(this.this$1, "mqq.intent.action.GRAY", this.val$fromServiceMsg.getUin(), this.val$is_yingyongbao, this.val$fromServiceMsg.getBusinessFailMsg(), Constants.LogoutReason.gray, this.val$isSameDevice);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.MainService.MyErrorHandler.4
 * JD-Core Version:    0.7.0.1
 */