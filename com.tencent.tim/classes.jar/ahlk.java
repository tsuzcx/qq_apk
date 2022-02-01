import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class ahlk
  implements akyf
{
  ahlk(ahlj paramahlj) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(akyf.a parama)
  {
    if (parama != null) {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "upCallBack updateMsg info =" + parama);
    }
  }
  
  public void b(akyf.a parama)
  {
    String str2 = ahlj.a(this.this$0).getString("uin");
    HashMap localHashMap = new HashMap();
    String str1;
    if (ahlj.a(this.this$0))
    {
      str1 = "1";
      localHashMap.put("param_time_out", str1);
      if (!ahlj.b(this.this$0)) {
        break label167;
      }
      str1 = "1";
      label61:
      localHashMap.put("param_is_first_show", str1);
      if (str2 != null) {
        break label174;
      }
      str1 = "";
      label80:
      ahlw.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", str1, localHashMap, ForwardUtils.a(parama));
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "UpCallBack onSend result =", parama, ", isTimeOut=", Boolean.valueOf(ahlj.a(this.this$0)), ", isFirstShow =", Boolean.valueOf(ahlj.b(this.this$0)) });
      if (ahlj.b(this.this$0)) {
        break label181;
      }
    }
    label167:
    label174:
    label181:
    do
    {
      do
      {
        return;
        str1 = "0";
        break;
        str1 = "0";
        break label61;
        str1 = str2;
        break label80;
      } while (ahlj.a(this.this$0));
      i = parama.result;
      if (i == 0)
      {
        parama = (String[])parama.data;
        if ((parama != null) && (parama.length == 2))
        {
          QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "UpCallBack onSend urls=" + parama[0] + " ," + parama[1]);
          ahlj.a(this.this$0, ahlj.a(this.this$0), parama[0], parama[1]);
          return;
        }
        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "onSend updateMsg error !");
        return;
      }
    } while (-1 != i);
    int i = parama.errCode;
    boolean bool = ForwardUtils.aL(ahlj.a(this.this$0));
    parama = (String[])parama.data;
    QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "UpCallBack onSend failed errCode=" + i + ", hasSDPermission=" + bool);
    if ((i == 9402) && (!bool) && (parama != null) && (parama.length == 2))
    {
      QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "UpCallBack onSend failed urls=" + parama[0] + " ," + parama[1]);
      ahlj.a(this.this$0, ahlj.a(this.this$0), parama[0], parama[1]);
      return;
    }
    ahlj.a(this.this$0, ahlj.bKK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahlk
 * JD-Core Version:    0.7.0.1
 */