import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.msf.service.protocol.push.SvcRespSetToken;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.user.set.SetUserSwitch.ReqBody;
import tencent.im.user.set.SetUserSwitch.RspBody;

public class auqd
  extends accg
{
  public auqd(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void mv(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = 0L;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int i = ((SvcRespSetToken)paramObject).cReplyCode;; i = 0)
    {
      long l2 = paramToServiceMsg.extraData.getLong("curr_time");
      if (l2 > 0L) {
        l1 = System.currentTimeMillis() - l2;
      }
      auqe.h(paramFromServiceMsg.isSuccess(), l1, i);
      if (QLog.isColorLevel()) {
        QLog.d("VendorPushHandler", 2, new Object[] { "handleRecvSetPushToken res:", Boolean.valueOf(paramFromServiceMsg.isSuccess()), "replycode:", Integer.valueOf(i) });
      }
      return;
    }
  }
  
  private void mw(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = 0L;
    int j = -1;
    int i = j;
    if (paramFromServiceMsg.isSuccess())
    {
      i = j;
      if (paramObject != null) {
        i = j;
      }
    }
    try
    {
      SetUserSwitch.RspBody localRspBody = new SetUserSwitch.RspBody();
      i = j;
      localRspBody.mergeFrom((byte[])paramObject);
      i = j;
      j = localRspBody.uint32_error_code.get();
      i = j;
      paramObject = localRspBody.bytes_error_msg.get().toStringUtf8();
      i = j;
      if (j != 0)
      {
        i = j;
        QLog.e("VendorPushHandler", 1, new Object[] { "handleRecvSetUserSwitch errCode:", Integer.valueOf(j), " ,errMsg:", paramObject });
        i = j;
      }
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        long l2;
        QLog.e("VendorPushHandler", 1, "handleRecvSetUserSwitch error:", paramObject);
      }
    }
    l2 = paramToServiceMsg.extraData.getLong("curr_time");
    if (l2 > 0L) {
      l1 = System.currentTimeMillis() - l2;
    }
    auqe.i(paramFromServiceMsg.isSuccess(), l1, i);
  }
  
  public void VX(boolean paramBoolean)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("VendorPushHandler", 2, new Object[] { "requestSetUserSwitch switch:", Boolean.valueOf(paramBoolean) });
    }
    SetUserSwitch.ReqBody localReqBody = new SetUserSwitch.ReqBody();
    Object localObject = localReqBody.uint32_notify_switch;
    if (paramBoolean) {}
    for (;;)
    {
      ((PBUInt32Field)localObject).set(i);
      localObject = createToServiceMsg("PushService.SetUserSwitch");
      ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
      ((ToServiceMsg)localObject).extraData.putLong("curr_time", System.currentTimeMillis());
      sendPbReq((ToServiceMsg)localObject);
      return;
      i = 0;
    }
  }
  
  public void Zv(String paramString)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("VendorPushHandler", 2, new Object[] { "TPush_requestSetPushToken token:", paramString });
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "PushService.SetToken");
    Bundle localBundle = localToServiceMsg.extraData;
    localBundle.putString("push_token", paramString);
    localBundle.putLong("curr_time", System.currentTimeMillis());
    if (SettingCloneUtil.readValue(this.app.getApplication(), this.app.getCurrentUin(), this.app.getApp().getString(2131718988), "qqsetting_notify_showcontent_key", true)) {}
    for (;;)
    {
      localBundle.putByte("show_content", (byte)i);
      send(localToServiceMsg);
      return;
      i = 1;
    }
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("PushService.SetToken");
      this.allowCmdSet.add("PushService.SetUserSwitch");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      return;
      str = paramFromServiceMsg.getServiceCmd();
      if ((msgCmdFilter(str)) && (QLog.isColorLevel())) {
        QLog.d("VendorPushHandler", 2, "onReceive, msgCmdFilter is true,cmd  = " + str);
      }
      if ("PushService.SetToken".equals(str))
      {
        mv(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"PushService.SetUserSwitch".equals(str));
    mw(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auqd
 * JD-Core Version:    0.7.0.1
 */