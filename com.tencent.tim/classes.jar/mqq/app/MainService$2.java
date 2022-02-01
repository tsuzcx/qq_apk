package mqq.app;

import android.os.Process;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.mobileqq.msf.sdk.MsfRespHandleUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.VerifyCodeManager;
import mqq.manager.VerifyDevLockManager;
import mqq.os.MqqRegulatorCallback;
import mqq.util.MqqConnRateReport;
import mqq.util.MqqConnRateReport.EventType;

class MainService$2
  implements Runnable
{
  MainService$2(MainService paramMainService) {}
  
  private void handleResp(MsfMessagePair paramMsfMessagePair)
  {
    paramMsfMessagePair.fromServiceMsg.setAppSeq(paramMsfMessagePair.toServiceMsg.getAppSeq());
    MainService.access$200(this.this$0).handleRespMsg(paramMsfMessagePair.toServiceMsg, paramMsfMessagePair.fromServiceMsg);
  }
  
  public void run()
  {
    com.tencent.qphone.base.util.BaseApplication.gMsfReceiverStarted = 1;
    MainService.sNativeTidOfReceiver = Process.myTid();
    for (;;)
    {
      Object localObject3;
      MsfMessagePair localMsfMessagePair;
      try
      {
        if (MainService.access$100(this.this$0)) {
          MainService.sRegulatorCallback.checkInRegulatorMsg();
        }
        localObject3 = MainService.access$000(this.this$0).waitAppRuntime(null);
        if (localObject3 == null) {
          break label402;
        }
        Object localObject1 = (VerifyCodeManager)((AppRuntime)localObject3).getManager(6);
        localObject3 = (VerifyDevLockManager)((AppRuntime)localObject3).getManager(7);
        localMsfMessagePair = this.this$0.msfSub.getServiceRespMsg();
        if (localMsfMessagePair == null) {
          break label410;
        }
        if (localMsfMessagePair.toServiceMsg == null)
        {
          localObject3 = localMsfMessagePair.fromServiceMsg;
          localObject1 = localObject3;
          if (localObject3 != null)
          {
            if ((((FromServiceMsg)localObject3).getServiceCmd() != null) && (((FromServiceMsg)localObject3).getServiceCmd().equals("SharpSvr.s2c"))) {
              MqqConnRateReport.getInstance().doReport(MqqConnRateReport.EventType.eVideoMSFReceiverProcess, ((FromServiceMsg)localObject3).getWupBuffer(), 0);
            }
            localObject1 = localObject3;
            if (!MainService.access$200(this.this$0).handlePushMsg((FromServiceMsg)localObject3))
            {
              localObject1 = localObject3;
              if (QLog.isColorLevel())
              {
                QLog.w("mqq", 2, "[MSF Receive] No handler for " + ((FromServiceMsg)localObject3).getServiceCmd());
                localObject1 = localObject3;
              }
            }
          }
          if ((localObject1 != null) || (localMsfMessagePair != null)) {
            break label336;
          }
          this.this$0.msfSub.queueWait();
          continue;
          continue;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("mqq", 2, "[MSF Receive]" + localException.toString());
        }
        localException.printStackTrace();
      }
      if ((localException != null) && (localObject3 != null))
      {
        if ((localException.checkVerifyCodeResp(localMsfMessagePair.toServiceMsg, localMsfMessagePair.fromServiceMsg)) && (((VerifyDevLockManager)localObject3).checkVerifyDevLockSmsResp(localMsfMessagePair.toServiceMsg, localMsfMessagePair.fromServiceMsg)))
        {
          handleResp(localMsfMessagePair);
          localObject2 = null;
        }
      }
      else
      {
        handleResp(localMsfMessagePair);
        break label410;
        label336:
        if (MainService.sPwdPacketTime == 0L) {
          continue;
        }
        long l = System.currentTimeMillis() - MainService.sPwdPacketTime;
        if ((l >= 40000L) || (l <= 0L) || (this.this$0.msfSub.getQueueSize() <= 0)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "[MSF Receive] UI_BUSY");
        }
        Thread.sleep(120L);
        continue;
        label402:
        localObject3 = null;
        localObject2 = null;
        continue;
      }
      label410:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.MainService.2
 * JD-Core Version:    0.7.0.1
 */