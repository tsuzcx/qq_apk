package mqq.app;

import com.tencent.mobileqq.msf.sdk.handler.IServerInfoHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

class MainService$8
  implements IServerInfoHandler
{
  MainService$8(MainService paramMainService) {}
  
  public void onReportResp(int paramInt1, int paramInt2, String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.MainService.8
 * JD-Core Version:    0.7.0.1
 */