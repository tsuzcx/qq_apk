import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class wnb
  implements azrg
{
  wnb(wna paramwna) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(azrh paramazrh) {}
  
  public void b(azrh paramazrh)
  {
    if (paramazrh.jdField_b_of_type_Int == 0)
    {
      this.a.jdField_b_of_type_JavaLangString = paramazrh.jdField_b_of_type_JavaLangString;
      this.a.b();
      wna.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramazrh.jdField_b_of_type_Int == bext.a(940010)) && (this.a.a.getAndIncrement() < 2))
    {
      wna.a(this.a);
      yuk.d("Q.qqstory.publish.upload:ImageFileObject", "retry load file");
      return;
    }
    paramazrh = new ErrorMessage(paramazrh.jdField_b_of_type_Int, paramazrh.a);
    paramazrh.extraMsg = "upload";
    wna.a(this.a, paramazrh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnb
 * JD-Core Version:    0.7.0.1
 */