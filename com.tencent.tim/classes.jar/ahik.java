import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class ahik
  implements akyf
{
  ahik(ahij paramahij) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(akyf.a parama)
  {
    if ((parama != null) && (QLog.isColorLevel())) {
      QLog.d(ahij.access$000(), 2, "requestNormalShare updateMsg info =" + parama);
    }
  }
  
  public void b(akyf.a parama)
  {
    String str = ahij.a(this.this$0).getString("uin");
    HashMap localHashMap = new HashMap();
    if (ahij.a(this.this$0))
    {
      localObject = "1";
      localHashMap.put("param_time_out", localObject);
      if (str != null) {
        break label125;
      }
    }
    label125:
    for (Object localObject = "";; localObject = str)
    {
      ahlw.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", (String)localObject, localHashMap, ForwardUtils.a(parama));
      QLog.d(ahij.access$000(), 1, new Object[] { "requestNormalShare onSend result =", parama, ", isTimeOut=", Boolean.valueOf(ahij.a(this.this$0)) });
      if (!ahij.a(this.this$0)) {
        break label132;
      }
      return;
      localObject = "0";
      break;
    }
    label132:
    if (ForwardUtils.a(parama))
    {
      parama = (String[])parama.data;
      QLog.i(ahij.access$000(), 1, "requestNormalShare onSend urls=" + parama[0] + " ," + parama[1]);
      ahij.a(this.this$0, parama[0], parama[1]);
      return;
    }
    int i = parama.errCode;
    boolean bool = ForwardUtils.aL(ahij.a(this.this$0));
    localObject = (String[])parama.data;
    QLog.e(ahij.access$000(), 1, new Object[] { "requestNormalShare onSend error result.result : ", Integer.valueOf(parama.result), ", errCode=" + i + ", hasSDPermission=" + bool });
    if ((i == 9402) && (!bool) && (localObject != null) && (localObject.length == 2))
    {
      ahij.a(this.this$0, localObject[0], localObject[1]);
      return;
    }
    ahij.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahik
 * JD-Core Version:    0.7.0.1
 */