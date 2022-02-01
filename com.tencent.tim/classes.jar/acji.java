import android.content.Intent;
import com.tencent.mobileqq.activity.QPayReminderActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import tencent.im.s2c.msgtype0x210.submsgtype0x72.SubMsgType0x72.MsgBody;
import tencent.mobileim.structmsg.QPayReminderMsg.GetInfoReq;
import tencent.mobileim.structmsg.QPayReminderMsg.GetInfoRsp;

public class acji
  extends accg
{
  private String boU;
  
  public acji(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void fr(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!((Boolean)paramToServiceMsg.getAttribute("is_query", Boolean.valueOf(false))).booleanValue()) {}
    do
    {
      for (;;)
      {
        return;
        paramToServiceMsg = new QPayReminderMsg.GetInfoRsp();
        try
        {
          paramFromServiceMsg = (QPayReminderMsg.GetInfoRsp)paramToServiceMsg.mergeFrom((byte[])paramObject);
          if (paramFromServiceMsg.result_code.get() == 0) {
            break label107;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("QPayHandler", 2, "QPayReminder: receive pull response, but result_code = " + paramFromServiceMsg.result_code.get());
            return;
          }
        }
        catch (Exception paramToServiceMsg) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("QPayHandler", 2, "QPayReminder: receive pull response, parse error");
    return;
    label107:
    int i = paramFromServiceMsg.urgency.get();
    int j = paramFromServiceMsg.template_no.get();
    paramToServiceMsg = paramFromServiceMsg.content.get();
    paramFromServiceMsg = paramFromServiceMsg.info_date.get();
    if (QLog.isColorLevel()) {
      QLog.d("QPayHandler", 2, "QPayReminder: receive pull response, message content: " + paramToServiceMsg);
    }
    h(i, j, paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void h(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(BaseActivity.sTopActivity, QPayReminderActivity.class);
    localIntent.putExtra("URGENCY", paramInt1);
    localIntent.putExtra("TEMPLATE", paramInt2);
    localIntent.putExtra("CONTENT", paramString1);
    BaseActivity.sTopActivity.startActivity(localIntent);
    BaseActivity.sTopActivity.overridePendingTransition(2130772367, 2130772002);
    if (QLog.isColorLevel()) {
      QLog.d("QPayHandler", 2, "QPayReminder: lauching popup QPayReminderActivity");
    }
    EC(paramString2);
  }
  
  public void EC(String paramString)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("QPayReminderSvc.query_over_due_info");
    QPayReminderMsg.GetInfoReq localGetInfoReq = new QPayReminderMsg.GetInfoReq();
    localGetInfoReq.scene.set("qpay");
    localGetInfoReq.sub_cmd.set("feedback_overdue");
    localGetInfoReq.info_date.set(paramString);
    localToServiceMsg.putWupBuffer(localGetInfoReq.toByteArray());
    localToServiceMsg.setNeedCallback(false);
    sendPbReq(localToServiceMsg);
  }
  
  public void Fx(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.app.getCurrentAccountUin() + ":" + SimpleDateFormat.getDateInstance().format(new Date());
      if ((this.boU != null) && (this.boU.equals(localObject))) {
        if (QLog.isColorLevel()) {
          QLog.d("QPayHandler", 2, "QPayReminder: only one offline msg is processed everyday");
        }
      }
    }
    do
    {
      return;
      this.boU = ((String)localObject);
      localObject = createToServiceMsg("QPayReminderSvc.query_over_due_info");
      QPayReminderMsg.GetInfoReq localGetInfoReq = new QPayReminderMsg.GetInfoReq();
      localGetInfoReq.scene.set("qpay");
      localGetInfoReq.sub_cmd.set("query_overdue");
      ((ToServiceMsg)localObject).putWupBuffer(localGetInfoReq.toByteArray());
      ((ToServiceMsg)localObject).addAttribute("is_query", Boolean.valueOf(true));
      sendPbReq((ToServiceMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.d("QPayHandler", 2, "QPayReminder: send pull request");
  }
  
  public void az(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return;
      localObject = new SubMsgType0x72.MsgBody();
      try
      {
        localObject = (SubMsgType0x72.MsgBody)((SubMsgType0x72.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        if (((SubMsgType0x72.MsgBody)localObject).uint32_sub_cmd.get() == 2) {
          break;
        }
        Fx(false);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("QPayHandler", 2, "QPayReminder: receive online push message, parse error");
    return;
    int i = ((SubMsgType0x72.MsgBody)localObject).uint32_urgency.get();
    int j = ((SubMsgType0x72.MsgBody)localObject).uint32_template_no.get();
    paramArrayOfByte = ((SubMsgType0x72.MsgBody)localObject).str_content.get();
    Object localObject = ((SubMsgType0x72.MsgBody)localObject).str_info_date.get();
    if (QLog.isColorLevel()) {
      QLog.d("QPayHandler", 2, "QPayReminder: receive online push message, message content: " + paramArrayOfByte);
    }
    h(i, j, paramArrayOfByte, (String)localObject);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QPayReminderSvc.query_over_due_info".equals(paramFromServiceMsg.getServiceCmd())) {
      fr(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acji
 * JD-Core Version:    0.7.0.1
 */