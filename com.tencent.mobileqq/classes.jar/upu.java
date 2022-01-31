import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class upu
  implements awkh
{
  upu(upt paramupt) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awki paramawki) {}
  
  public void b(awki paramawki)
  {
    if (paramawki.jdField_b_of_type_Int == 0)
    {
      this.a.jdField_b_of_type_JavaLangString = paramawki.jdField_b_of_type_JavaLangString;
      this.a.b();
      upt.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramawki.jdField_b_of_type_Int == baxx.a(940010)) && (this.a.a.getAndIncrement() < 2))
    {
      upt.a(this.a);
      wxe.d("Q.qqstory.publish.upload:ImageFileObject", "retry load file");
      return;
    }
    paramawki = new ErrorMessage(paramawki.jdField_b_of_type_Int, paramawki.a);
    paramawki.extraMsg = "upload";
    upt.a(this.a, paramawki);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     upu
 * JD-Core Version:    0.7.0.1
 */