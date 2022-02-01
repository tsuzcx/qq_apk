import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class aorj
  implements akyf
{
  aorj(aori paramaori) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(akyf.a parama) {}
  
  public void b(akyf.a parama)
  {
    if (parama.errCode == 0)
    {
      this.a.a.cdnUrl = parama.path;
      this.a.a.fileKey = parama.uuid;
      aori.a(this.a);
      aori.a(this.a, new ErrorMessage());
      return;
    }
    if ((parama.errCode == aoob.jD(940010)) && (aori.a(this.a).getAndIncrement() < 2))
    {
      aori.b(this.a);
      ram.w("tribe_publish_TribeVideoFileObject", "retry load file");
      return;
    }
    aori.c(this.a);
    parama = new ErrorMessage(parama.errCode, parama.errStr);
    aori.a(this.a, parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aorj
 * JD-Core Version:    0.7.0.1
 */