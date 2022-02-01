import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.PrinterStatusHandler.1;
import com.tencent.mobileqq.app.PrinterStatusHandler.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.TimerTask;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import tencent.im.msg.im_msg_head.InstCtrl;
import tencent.im.msg.im_msg_head.InstInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody;

public class acir
  extends accg
{
  private Timer D;
  private achq jdField_a_of_type_Achq = new acis(this);
  private ackx jdField_a_of_type_Ackx = new acit(this);
  private boolean bt;
  private int cxh;
  
  public acir(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.app.addObserver(this.jdField_a_of_type_Achq);
    this.app.addObserver(this.jdField_a_of_type_Ackx);
    cKX();
  }
  
  private ToServiceMsg a(boolean paramBoolean, long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
    localToServiceMsg.extraData.putBoolean("ISFROM_DATALINE", true);
    localToServiceMsg.extraData.putInt("DATALINE_CMD", paramInt3);
    localToServiceMsg.addAttribute("cookie", Long.valueOf(paramLong1));
    localToServiceMsg.addAttribute("sendFromNative", Boolean.valueOf(paramBoolean));
    localToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", 0);
    paramLong1 = ahav.ge();
    paramLong2 = ahav.bA();
    anbn localanbn = new anbn();
    localanbn.dEY = paramInt2;
    localanbn.msg = paramArrayOfByte;
    paramString = anbh.a(this.app, 13, paramString, localanbn, paramLong2, anbk.ac(paramLong1));
    paramArrayOfByte = new im_msg_head.InstInfo();
    paramArrayOfByte.uint32_apppid.set(1);
    paramArrayOfByte.uint32_instid.set(0);
    paramArrayOfByte.enum_device_type.set(1);
    paramArrayOfByte.setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add(paramArrayOfByte);
    paramArrayOfByte = new im_msg_head.InstInfo();
    paramArrayOfByte.uint32_apppid.set(1001);
    paramArrayOfByte.uint32_instid.set(AppSetting.getAppId());
    paramArrayOfByte.enum_device_type.set(2);
    paramArrayOfByte.setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.msg_from_inst = paramArrayOfByte;
    paramString.routing_head.trans_0x211.inst_ctrl.setHasFlag(true);
    localToServiceMsg.putWupBuffer(paramString.toByteArray());
    sendPbReq(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public void Fw(boolean paramBoolean)
  {
    if (this.D != null)
    {
      this.D.cancel();
      this.D = null;
    }
    this.bt = paramBoolean;
  }
  
  public ToServiceMsg a(long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2)
  {
    return a(true, paramLong1, paramString, paramInt1, paramInt2, paramInt3, paramArrayOfByte, paramLong2);
  }
  
  public boolean abe()
  {
    return this.bt;
  }
  
  public void cKX()
  {
    Object localObject1 = (ackv)this.app.getBusinessHandler(10);
    if ((((ackv)localObject1).bi() != 0) && (((ackv)localObject1).AP() == 1))
    {
      if (this.D == null)
      {
        localObject1 = new PrinterStatusHandler.1(this);
        this.D = new Timer();
        this.D.schedule((TimerTask)localObject1, 30000L);
        Object localObject2 = new C2CType0x211_SubC2CType0x9.MsgBody();
        ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).str_service.set("printer");
        ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).uint32_CMD.set(1);
        this.cxh += 1;
        localObject1 = this.app.getCurrentAccountUin();
        localObject2 = ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).toByteArray();
        a(this.cxh, (String)localObject1, 529, 9, 1021, (byte[])localObject2, 0L);
      }
      return;
    }
    this.bt = false;
    notifyUI(12, false, null);
  }
  
  public void cKY()
  {
    Object localObject1 = (ackv)this.app.getBusinessHandler(10);
    if ((((ackv)localObject1).bi() != 0) && (((ackv)localObject1).AP() == 1))
    {
      Object localObject2 = new C2CType0x211_SubC2CType0x9.MsgBody();
      ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).str_service.set("printer");
      ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).uint32_CMD.set(5);
      this.cxh += 1;
      localObject1 = this.app.getCurrentAccountUin();
      localObject2 = ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).toByteArray();
      a(this.cxh, (String)localObject1, 529, 9, 1021, (byte[])localObject2, 0L);
    }
  }
  
  public void cW(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.Printer", 2, "received a cmd=" + paramFromServiceMsg.getServiceCmd());
    }
    if ((paramToServiceMsg.extraData.getInt("ROUNTING_TYPE") != 13) || (!paramToServiceMsg.extraData.getBoolean("ISFROM_DATALINE"))) {}
    int i;
    do
    {
      do
      {
        return;
      } while (paramFromServiceMsg.getResultCode() == 1000);
      i = paramToServiceMsg.extraData.getInt("DATALINE_TRYINDEX");
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Printer", 2, "<PbSendMsg><R><---handle0x211C2CMessageError, retry = " + i);
      }
    } while (i >= 3);
    paramToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", i + 1);
    sendPbReq(paramToServiceMsg);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return acdl.class;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Achq != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_Achq);
      this.jdField_a_of_type_Achq = null;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"MessageSvc.PbSendMsg".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Printer", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new PrinterStatusHandler.2(this, paramToServiceMsg, paramFromServiceMsg, paramObject));
      return;
    }
    cW(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acir
 * JD-Core Version:    0.7.0.1
 */