import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.voiceChange.VipVoiceChange.subCmd0x1ReqAuth;
import com.tencent.pb.voiceChange.VipVoiceChange.subCmd0x1RspAuth;
import com.tencent.pb.voiceChange.VipVoiceChange.voiceChangeReq;
import com.tencent.pb.voiceChange.VipVoiceChange.voiceChangeRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class acoa
  extends accg
{
  final String TAG = "VoiceChangeHandler";
  WeakReference<ListenChangeVoicePanel> gk;
  private QQAppInterface mApp;
  
  public acoa(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.mApp = paramQQAppInterface;
  }
  
  public void a(int paramInt1, int paramInt2, ListenChangeVoicePanel paramListenChangeVoicePanel)
  {
    this.gk = new WeakReference(paramListenChangeVoicePanel);
    paramListenChangeVoicePanel = super.createToServiceMsg("voiceChange.Auth");
    paramListenChangeVoicePanel.extraData.putInt("callId", paramInt2);
    VipVoiceChange.voiceChangeReq localvoiceChangeReq = new VipVoiceChange.voiceChangeReq();
    localvoiceChangeReq.int32_platform.set(109);
    localvoiceChangeReq.int32_sub_cmd.set(1);
    localvoiceChangeReq.str_qq_version.set("3.4.4");
    VipVoiceChange.subCmd0x1ReqAuth localsubCmd0x1ReqAuth = new VipVoiceChange.subCmd0x1ReqAuth();
    localsubCmd0x1ReqAuth.int32_item_id.set(paramInt2);
    localvoiceChangeReq.msg_subcmd0x1_req_auth.set(localsubCmd0x1ReqAuth);
    localvoiceChangeReq.setHasFlag(true);
    paramListenChangeVoicePanel.putWupBuffer(localvoiceChangeReq.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.d("VoiceChangeHandler", 2, "sendReqToSVR funcType=" + paramInt1 + ", voiceID:" + paramInt2);
    }
    super.sendPbReq(paramListenChangeVoicePanel);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return aqxs.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"voiceChange.Auth".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    Bundle localBundle;
    for (;;)
    {
      try
      {
        localBundle = new Bundle();
        localBundle.putInt("callId", paramToServiceMsg.extraData.getInt("callId"));
        if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
          break label171;
        }
        i = 1;
        if (i != 0) {
          break;
        }
        QLog.e("VoiceChangeHandler", 1, "onReceive~ isSuccess=false ,data=" + aqoj.C((byte[])paramObject));
        arts.a().a("voiceChange.Auth", 100, paramFromServiceMsg.getBusinessFailCode(), this.app.getCurrentAccountUin(), 0, acfp.m(2131716862), true);
        localBundle.putInt("result", -1);
        super.notifyUI(1, false, localBundle);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("VoiceChangeHandler", 1, "onReceive prb.mergeFrom error: " + paramToServiceMsg.getMessage());
      }
      this.gk = null;
      return;
      label171:
      i = 0;
    }
    paramToServiceMsg = new VipVoiceChange.voiceChangeRsp();
    paramToServiceMsg.mergeFrom((byte[])paramObject);
    int i = paramToServiceMsg.int32_sub_cmd.get();
    paramToServiceMsg = (VipVoiceChange.subCmd0x1RspAuth)paramToServiceMsg.msg_subcmd0x1_rsp_auth.get();
    int j = paramToServiceMsg.int32_ret.get();
    paramFromServiceMsg = paramToServiceMsg.str_error_msg.get();
    paramObject = paramToServiceMsg.str_active_url.get();
    localBundle.putInt("result", j);
    if (QLog.isColorLevel()) {
      QLog.d("VoiceChangeHandler", 2, "VoiceChangeHandler onReceive~ ret=" + j + ",msg=" + paramFromServiceMsg + ", url=" + paramObject + ", funcType=" + i + ", actStr=" + null);
    }
    localBundle.putString("message", paramFromServiceMsg);
    localBundle.putString("svr_url", paramObject);
    localBundle.putString("svr_actStr", null);
    if ((this.gk != null) && (this.gk.get() != null)) {}
    for (paramToServiceMsg = (ListenChangeVoicePanel)this.gk.get();; paramToServiceMsg = null)
    {
      if (paramToServiceMsg != null)
      {
        paramToServiceMsg.a(i, j, localBundle, false);
        break;
      }
      QLog.e("VoiceChangeHandler", 1, "VoiceChangeHandler onReceive~ null == listenChangeVoicePanel ret=" + j + ",msg=" + paramFromServiceMsg + ", url=" + paramObject + ", funcType=" + i + ", actStr=" + null);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acoa
 * JD-Core Version:    0.7.0.1
 */