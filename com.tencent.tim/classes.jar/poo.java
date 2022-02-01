import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class poo
  implements akyf
{
  poo(pon parampon) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(akyf.a parama) {}
  
  public void b(akyf.a parama)
  {
    if (parama.errCode == 0)
    {
      this.a.aud = parama.path;
      this.a.bmd();
      pon.a(this.a, new ErrorMessage());
      return;
    }
    if ((parama.errCode == aoob.jD(940010)) && (this.a.ai.getAndIncrement() < 2))
    {
      pon.a(this.a);
      ram.w("Q.qqstory.publish.upload:ImageFileObject", "retry load file");
      return;
    }
    parama = new ErrorMessage(parama.errCode, parama.errStr);
    parama.extraMsg = "upload";
    pon.a(this.a, parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     poo
 * JD-Core Version:    0.7.0.1
 */