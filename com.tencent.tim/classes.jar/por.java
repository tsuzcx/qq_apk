import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class por
  implements akyf
{
  por(poq parampoq) {}
  
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
      this.a.bmd();
      poq.a(this.a, new ErrorMessage());
      return;
    }
    if ((parama.errCode == aoob.jD(940010)) && (this.a.ai.getAndIncrement() < 2))
    {
      poq.a(this.a);
      ram.w("Q.qqstory.publish.upload:StoryVideoFileObject  ", "retry load file");
      return;
    }
    this.a.bmd();
    parama = new ErrorMessage(parama.errCode, parama.errStr);
    parama.extraMsg = "upload";
    poq.a(this.a, parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     por
 * JD-Core Version:    0.7.0.1
 */