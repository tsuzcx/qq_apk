import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData.a;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_head.InstCtrl;
import tencent.im.msg.im_msg_head.InstInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x11a.submsgtype0x11a.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x11a.submsgtype0x11a.UserData;
import tencent.im.s2c.msgtype0x210.submsgtype0x11b.submsgtype0x11b.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd;

public class ajdv
{
  private static ajdv a;
  
  public static ajdv a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ajdv();
      }
      return a;
    }
    finally {}
  }
  
  private MsgBackupUserData a(submsgtype0x11a.UserData paramUserData)
  {
    MsgBackupUserData.a locala = new MsgBackupUserData.a();
    if (paramUserData.bytes_ip.has()) {
      locala.a(paramUserData.bytes_ip.get().toStringUtf8());
    }
    if (paramUserData.rpt_fixed32_port.has()) {
      locala.a(paramUserData.rpt_fixed32_port.get());
    }
    if (paramUserData.bytes_bssid.has()) {
      locala.c(paramUserData.bytes_bssid.get().toStringUtf8());
    }
    if (paramUserData.bytes_ssid.has()) {
      locala.b(paramUserData.bytes_ssid.get().toStringUtf8());
    }
    if (paramUserData.enum_platform.has()) {
      locala.a(paramUserData.enum_platform.get());
    }
    return locala.b();
  }
  
  private String xk()
  {
    Object localObject = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cmd", "exit");
      localJSONObject.put("sig", ajdt.a().xj());
      ((JSONArray)localObject).put(localJSONObject);
      localObject = ((JSONArray)localObject).toString();
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupPushHandler", 2, "getExitJsonStr create: " + (String)localObject);
      }
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void Ms(String paramString)
  {
    Object localObject1 = new SubMsgType0x7.MsgBody.GenericSubCmd();
    ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject1).uint64_sessionid.set(1L);
    ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject1).uint32_size.set(1);
    ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject1).uint32_index.set(0);
    ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject1).uint32_type.set(7);
    ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject1).bytes_buf.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject1).uint32_support_auth.set(1);
    ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject1).setHasFlag(true);
    Object localObject2 = new SubMsgType0x7.MsgBody();
    ((SubMsgType0x7.MsgBody)localObject2).uint32_sub_cmd.set(4);
    paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    new ProtocolHelper(paramString, 0).fillMsgHeader(((SubMsgType0x7.MsgBody)localObject2).msg_header, Long.valueOf(paramString.getCurrentAccountUin()).longValue());
    ((SubMsgType0x7.MsgBody)localObject2).msg_subcmd_0x4_generic.set((MessageMicro)localObject1);
    ((SubMsgType0x7.MsgBody)localObject2).setHasFlag(true);
    localObject1 = new anbn();
    localObject2 = ((SubMsgType0x7.MsgBody)localObject2).toByteArray();
    ((anbn)localObject1).dEY = 7;
    ((anbn)localObject1).msg = ((byte[])localObject2);
    long l1 = ahav.ge();
    long l2 = ahav.bA();
    localObject1 = anbh.a(paramString, 13, paramString.getCurrentUin(), (anbn)localObject1, l2, anbk.ac(l1));
    localObject2 = new im_msg_head.InstInfo();
    ((im_msg_head.InstInfo)localObject2).uint32_apppid.set(1);
    ((im_msg_head.InstInfo)localObject2).uint32_instid.set(0);
    ((im_msg_head.InstInfo)localObject2).enum_device_type.set(2);
    ((im_msg_head.InstInfo)localObject2).setHasFlag(true);
    ((msg_svc.PbSendMsgReq)localObject1).routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add((MessageMicro)localObject2);
    localObject2 = new im_msg_head.InstInfo();
    ((im_msg_head.InstInfo)localObject2).uint32_apppid.set(1001);
    ((im_msg_head.InstInfo)localObject2).uint32_instid.set(AppSetting.getAppId());
    ((im_msg_head.InstInfo)localObject2).enum_device_type.set(2);
    ((im_msg_head.InstInfo)localObject2).setHasFlag(true);
    ((msg_svc.PbSendMsgReq)localObject1).routing_head.trans_0x211.inst_ctrl.msg_from_inst = ((im_msg_head.InstInfo)localObject2);
    ((msg_svc.PbSendMsgReq)localObject1).routing_head.trans_0x211.inst_ctrl.setHasFlag(true);
    localObject2 = new ToServiceMsg("mobileqq.service", paramString.getCurrentAccountUin(), "MessageSvc.PbSendMsg");
    ((ToServiceMsg)localObject2).putWupBuffer(((msg_svc.PbSendMsgReq)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putBoolean("req_pb_protocol_flag", true);
    ((ToServiceMsg)localObject2).extraData.putBoolean("exit_push_0x211_key", true);
    paramString.sendToService((ToServiceMsg)localObject2);
  }
  
  public void a(submsgtype0x11a.MsgBody paramMsgBody)
  {
    int i;
    if (paramMsgBody != null)
    {
      ajeo.a locala = new ajeo.a();
      if (paramMsgBody.enum_result.has())
      {
        i = paramMsgBody.enum_result.get();
        if (i != 0) {
          break label180;
        }
        if (paramMsgBody.bytes_token.has()) {
          locala.a(paramMsgBody.bytes_token.get().toStringUtf8());
        }
        if (paramMsgBody.bytes_encrypt_key.has()) {
          locala.b(paramMsgBody.bytes_encrypt_key.get().toStringUtf8());
        }
        if (paramMsgBody.msg_user_data.has()) {
          locala.a(a((submsgtype0x11a.UserData)paramMsgBody.msg_user_data.get()));
        }
        if (paramMsgBody.enum_biz_type.has()) {
          locala.a(paramMsgBody.enum_biz_type.get());
        }
        paramMsgBody = locala.a();
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupPushHandler", 2, "processOnLinePush receive processOnLinePush0x11a response = " + paramMsgBody);
        }
        ajee.a().br(paramMsgBody);
      }
    }
    label180:
    do
    {
      return;
      if (i == 6)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupPushHandler", 2, "processOnLinePush receive 0x210_0x11a， 对端拒绝了！");
        }
        ajee.a().br(Integer.valueOf(6));
        return;
      }
    } while (i != 20);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupPushHandler", 2, "processOnLinePush receive 0x210_0x11a， 内部错误");
    }
    ajee.a().br(Integer.valueOf(20));
  }
  
  public void a(submsgtype0x11b.MsgBody paramMsgBody)
  {
    if (paramMsgBody != null)
    {
      ajet.a locala = new ajet.a();
      if (paramMsgBody.bytes_qr_sig.has()) {
        locala.a(paramMsgBody.bytes_qr_sig.get().toStringUtf8());
      }
      if (paramMsgBody.enum_biz_type.has()) {
        locala.a(paramMsgBody.enum_biz_type.get());
      }
      paramMsgBody = locala.a();
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupPushHandler", 2, "processOnLinePush receive processOnLinePush0x11b " + paramMsgBody);
      }
      ajee.a().a(paramMsgBody);
      return;
    }
    ajee.a().a(null);
  }
  
  public void a(SubMsgType0x7.MsgBody.GenericSubCmd paramGenericSubCmd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupPushHandler", 2, "processExit0x7-------------->");
    }
    if (paramGenericSubCmd.bytes_buf.has())
    {
      paramGenericSubCmd = paramGenericSubCmd.bytes_buf.get().toStringUtf8();
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupPushHandler", 2, "processExit0x7, genericSubCmd: " + paramGenericSubCmd);
      }
      if (TextUtils.isEmpty(paramGenericSubCmd)) {}
    }
    try
    {
      paramGenericSubCmd = new JSONArray(paramGenericSubCmd);
      if (paramGenericSubCmd.length() == 1)
      {
        paramGenericSubCmd = (JSONObject)paramGenericSubCmd.get(0);
        if ("exit".equals(paramGenericSubCmd.optString("cmd")))
        {
          paramGenericSubCmd = paramGenericSubCmd.optString("sig");
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupPushHandler", 2, "-------------------exit-------------------");
          }
          if (TextUtils.equals(paramGenericSubCmd, ajdt.a().xj())) {
            ajgp.b().LX(true);
          }
        }
      }
      return;
    }
    catch (JSONException paramGenericSubCmd)
    {
      QLog.e("MsgBackup.MsgBackupPushHandler", 2, "processExit0x7 parse json error!", paramGenericSubCmd);
    }
  }
  
  public void jZ(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupPushHandler", 2, "processOnlinePush0x211 receive: res.getResultCode() = " + paramFromServiceMsg.getResultCode());
    }
    if (paramFromServiceMsg.getResultCode() != 1000) {
      Ms(xk());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajdv
 * JD-Core Version:    0.7.0.1
 */