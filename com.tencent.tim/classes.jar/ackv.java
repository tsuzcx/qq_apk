import IPwdPxyMQQ.RespondQueryIPwdStat;
import RegisterProxySvcPack.OnlineInfos;
import RegisterProxySvcPack.SvcRespParam;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.im.statsvc.getonline.StatSvcGetOnline.Instance;
import tencent.im.statsvc.getonline.StatSvcGetOnline.ReqBody;
import tencent.im.statsvc.getonline.StatSvcGetOnline.RspBody;
import tencent.im.statsvc.stat.mute.StatSetMute.ReqBody;
import tencent.im.statsvc.stat.mute.StatSetMute.RspBody;

public class ackv
  extends accg
{
  private boolean bJi;
  private long bf;
  private int cxJ;
  private int cxK;
  private int cxL = 1;
  private int cxM;
  private long iAppId;
  private long iClientType;
  private int jF;
  private int jG = 1;
  private int jH;
  private int jI = 1;
  protected Handler mHandler = new ackw(this, Looper.getMainLooper());
  
  public ackv(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public int AM()
  {
    try
    {
      int i = this.cxJ;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int AN()
  {
    try
    {
      int i = this.cxK;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int AO()
  {
    try
    {
      int i = this.jG;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int AP()
  {
    try
    {
      int i = this.jH;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int AQ()
  {
    try
    {
      int i = this.jI;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void FA(boolean paramBoolean)
  {
    StatSetMute.ReqBody localReqBody = new StatSetMute.ReqBody();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localReqBody.set_mute.set(i);
      ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.SetMute");
      localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
      localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      localToServiceMsg.extraData.putBoolean("param_is_mute", paramBoolean);
      send(localToServiceMsg);
      return;
    }
  }
  
  public void FB(boolean paramBoolean)
  {
    try
    {
      this.bJi = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void JG(int paramInt)
  {
    try
    {
      this.cxM = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void JH(int paramInt)
  {
    try
    {
      this.cxJ = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void JI(int paramInt)
  {
    try
    {
      this.cxK = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void aa(int paramInt)
  {
    try
    {
      this.jF = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean abD()
  {
    try
    {
      boolean bool = this.bJi;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void ac(int paramInt)
  {
    try
    {
      this.jG = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void ad(int paramInt)
  {
    try
    {
      this.jH = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void ae(int paramInt)
  {
    try
    {
      this.jI = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int bi()
  {
    try
    {
      int i = this.jF;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void cMe()
  {
    send(createToServiceMsg("RegPrxySvc.infoAndroid"));
  }
  
  public void cMf()
  {
    StatSvcGetOnline.ReqBody localReqBody = new StatSvcGetOnline.ReqBody();
    localReqBody.uint64_uin.set(this.app.getLongAccountUin());
    localReqBody.uint32_appid.set(0);
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.GetOnlineStatus");
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    send(localToServiceMsg);
  }
  
  public void cMg()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterProxySvcPack", 2, "iState:" + this.jF + ", clientType:" + this.iClientType + ", appId:" + this.iAppId);
    }
    if (!this.mHandler.hasMessages(102)) {
      this.mHandler.sendEmptyMessageDelayed(102, 1000L);
    }
  }
  
  public long eW()
  {
    try
    {
      long l = this.bf;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void hK(long paramLong)
  {
    try
    {
      this.iClientType = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void hL(long paramLong)
  {
    try
    {
      this.iAppId = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void hM(long paramLong)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (!QLog.isColorLevel()) {
          break label163;
        }
        QLog.d("RegisterProxySvcPack", 2, "uIsSetPwd = " + paramLong);
      }
      finally {}
      if ((this.app != null) && (i != -1))
      {
        this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit().putInt("message_roam_is_set_password" + this.app.getCurrentAccountUin(), i).commit();
        return;
        if (paramLong != 2L) {
          i = -1;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("RegisterProxySvcPack", 2, "RegisterProxySvcPackHandler.app is null or isSetPassword is error ,isSetPassword = " + i);
        continue;
        label163:
        if (paramLong != 1L) {
          break;
        }
        i = 1;
      }
    }
  }
  
  public void k(long paramLong)
  {
    try
    {
      QLog.d("RegisterProxySvcPack", 2, "setSelfPcSuppViewPcVersion:" + paramLong);
      this.bf = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return ackx.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    boolean bool = true;
    int i = 1;
    if (paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.infoAndroid")) {
      QLog.d("RegisterProxySvcPack", 2, "resp of RegPrxySvc.infoAndroid");
    }
    label142:
    label311:
    label320:
    label510:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.PushParam"))
            {
              if (paramObject != null)
              {
                paramObject = (SvcRespParam)paramObject;
                ac(paramObject.iIsSupportDataLine);
                ad(paramObject.iIsSupportPrintable);
                ae(paramObject.iIsSupportViewPCFile);
                k(paramObject.iPcVersion);
                ArrayList localArrayList = paramObject.onlineinfos;
                paramFromServiceMsg = null;
                paramToServiceMsg = null;
                if (localArrayList == null) {
                  break label1084;
                }
                i = 0;
                paramFromServiceMsg = paramToServiceMsg;
                if (i >= localArrayList.size()) {
                  break label1084;
                }
                paramFromServiceMsg = (OnlineInfos)localArrayList.get(i);
                if (paramFromServiceMsg.clientType == 9)
                {
                  i = paramFromServiceMsg.onlineStatus;
                  JH(i);
                  if ((paramToServiceMsg == null) || (paramToServiceMsg.onlineStatus != 1)) {
                    break label320;
                  }
                  aa(1);
                  hK(66831L);
                  hL(paramToServiceMsg.instanceId);
                }
                for (;;)
                {
                  i = j;
                  if (((rwp)this.app.getManager(335)).a(paramObject)) {
                    i = 1;
                  }
                  this.cxM = i;
                  cMg();
                  QLog.d("RegisterProxySvcPack", 2, "online status of pc: state:" + paramObject.PCstat + "- ram:" + paramObject.iIsSupportC2CRoamMsg + "- supportdataline:" + paramObject.iIsSupportDataLine + "- PcVersion:" + paramObject.iPcVersion + "- uRoamFlag:" + paramObject.uRoamFlag);
                  return;
                  if (paramFromServiceMsg.clientType != 15) {
                    break label1081;
                  }
                  paramToServiceMsg = paramFromServiceMsg;
                  i += 1;
                  break;
                  if ((paramObject.iPCClientType == 65793) || (paramObject.iPCClientType == 77313))
                  {
                    i = paramObject.PCstat;
                    if (paramObject.iIsSupportDataLine == 2) {
                      i = 0;
                    }
                    aa(i);
                    if (i == 1)
                    {
                      hK(paramObject.iPCClientType);
                      hL(1L);
                    }
                    notifyUI(1, true, new Object[] { Integer.valueOf(i), Integer.valueOf(paramObject.iIsSupportDataLine) });
                  }
                }
              }
              QLog.d("RegisterProxySvcPack", 2, "RegPrxySvc.PushParam is null");
              return;
            }
            if (!paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.QueryIpwdStat")) {
              break label510;
            }
            if (paramObject == null) {
              break;
            }
            paramToServiceMsg = (RespondQueryIPwdStat)paramObject;
          } while (paramToServiceMsg == null);
          hM(paramToServiceMsg.uIsSetPwd);
        } while (!QLog.isColorLevel());
        QLog.d("RegisterProxySvcPack", 2, "QueryIPwdStat:" + paramToServiceMsg.uIsSetPwd);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("RegisterProxySvcPack", 2, "IPwdPxyMQQ.RespondQueryIPwdStat is null");
      return;
      if (!paramFromServiceMsg.getServiceCmd().equals("StatSvc.GetOnlineStatus")) {
        break label875;
      }
      if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
        break;
      }
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("RegisterProxySvcPack", 2, "CMD_GET_SELFPCSTATUS_KICKED onReceive :" + bool);
      }
    } while (!bool);
    for (;;)
    {
      try
      {
        label536:
        paramToServiceMsg = new StatSvcGetOnline.RspBody();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        j = paramToServiceMsg.error_code.get();
        if (j != 0) {
          break label820;
        }
        if (QLog.isColorLevel()) {
          QLog.e("RegisterProxySvcPack", 2, "errorCode: " + j);
        }
        if (i == 0) {
          break label826;
        }
        if ((!paramToServiceMsg.uint64_uin.has()) || (this.app.getLongAccountUin() != paramToServiceMsg.uint64_uin.get()) || (!paramToServiceMsg.msg_instances.has())) {
          break;
        }
        paramToServiceMsg = paramToServiceMsg.msg_instances.get().iterator();
        if (!paramToServiceMsg.hasNext()) {
          break;
        }
        paramFromServiceMsg = (StatSvcGetOnline.Instance)paramToServiceMsg.next();
        if (paramFromServiceMsg == null) {
          continue;
        }
        i = paramFromServiceMsg.uint32_client_type.get();
        if (!QLog.isColorLevel()) {
          break label1092;
        }
        QLog.e("RegisterProxySvcPack", 2, "uint32_client_type: " + i);
      }
      catch (Exception paramToServiceMsg) {}
      aa(1);
      hK(i);
      hL(paramFromServiceMsg.uint32_instance_id.get());
      cMg();
      continue;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("RegisterProxySvcPack", 2, "CMD_GET_SELFPCSTATUS_KICKED onReceive fail: ", paramToServiceMsg);
      return;
      bool = false;
      break label536;
      label820:
      i = 0;
      continue;
      label826:
      if ((!paramToServiceMsg.error_msg.has()) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.e("RegisterProxySvcPack", 2, "err msg: " + paramToServiceMsg.error_msg.get());
      return;
      label875:
      if (!paramFromServiceMsg.getServiceCmd().equals("StatSvc.SetMute")) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RegisterProxySvcPack", 2, "CMD_REQ_SET_MUTE onReceive :" + paramFromServiceMsg.isSuccess());
      }
      if (paramObject == null) {
        break;
      }
      for (;;)
      {
        try
        {
          paramToServiceMsg = new StatSetMute.RspBody();
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          i = paramToServiceMsg.error_code.get();
          if (i != 0) {
            break label1040;
          }
          if (paramToServiceMsg.set_mute_resp.get() == 1)
          {
            SettingCloneUtil.writeValue(this.app.getApp().getApplicationContext(), this.app.getCurrentUin(), null, "qqsetting_qrlogin_set_mute", bool);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("RegisterProxySvcPack", 2, new Object[] { "setmute success ismute:", Boolean.valueOf(bool) });
            return;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          paramToServiceMsg.printStackTrace();
          return;
        }
        bool = false;
      }
      label1040:
      QLog.d("RegisterProxySvcPack", 1, new Object[] { "setmute err:", Integer.valueOf(i), " ,msg:", paramToServiceMsg.error_msg.get() });
      return;
      label1081:
      break label311;
      label1084:
      i = 0;
      paramToServiceMsg = paramFromServiceMsg;
      break label142;
      label1092:
      if ((i != 65793) && (i != 77313)) {
        if (i != 66831) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ackv
 * JD-Core Version:    0.7.0.1
 */