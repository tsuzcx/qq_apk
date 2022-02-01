import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardMultServerShare.2;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import tencent.im.msg.im_msg_body.RichText;

public class ahil
  implements akyf
{
  public ahil(ForwardMultServerShare.2 param2) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(akyf.a parama)
  {
    if (parama != null) {
      QLog.d(ahij.access$000(), 1, "requestImageShare updateMsg info =" + parama);
    }
  }
  
  public void b(akyf.a parama)
  {
    this.a.kS.put(this.a.c, parama);
    QLog.d(ahij.access$000(), 1, new Object[] { "requestImageShare onSend result =", parama, ", isTimeOut=", Boolean.valueOf(ahij.a(this.a.this$0)) });
    if (this.a.kS.size() == ahij.a(this.a.this$0).size())
    {
      ahlw.report("KEY_STAGE_2_UPLOAD_IMAGE_MULT");
      ahij.a(this.a.this$0, this.a.kS);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahil
 * JD-Core Version:    0.7.0.1
 */