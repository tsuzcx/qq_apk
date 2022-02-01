import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class qbx
  implements akyf
{
  qbx(qbw paramqbw) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(akyf.a parama) {}
  
  public void b(akyf.a parama)
  {
    if ((parama.errCode == 0) && (!TextUtils.isEmpty(parama.path)))
    {
      this.a.p("UploadImageJob_out_image_url", parama.path);
      qbw.a(this.a, true);
      return;
    }
    parama = new ErrorMessage(parama.errCode, parama.errStr);
    if (QLog.isColorLevel()) {
      QLog.e(this.a.TAG, 2, parama, new Object[0]);
    }
    qbw.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qbx
 * JD-Core Version:    0.7.0.1
 */