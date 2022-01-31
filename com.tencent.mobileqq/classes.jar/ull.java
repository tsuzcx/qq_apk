import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class ull
  implements awfy
{
  ull(ulk paramulk) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awfz paramawfz) {}
  
  public void b(awfz paramawfz)
  {
    if (paramawfz.jdField_b_of_type_Int == 0)
    {
      this.a.jdField_b_of_type_JavaLangString = paramawfz.jdField_b_of_type_JavaLangString;
      this.a.b();
      ulk.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramawfz.jdField_b_of_type_Int == bato.a(940010)) && (this.a.a.getAndIncrement() < 2))
    {
      ulk.a(this.a);
      wsv.d("Q.qqstory.publish.upload:ImageFileObject", "retry load file");
      return;
    }
    paramawfz = new ErrorMessage(paramawfz.jdField_b_of_type_Int, paramawfz.a);
    paramawfz.extraMsg = "upload";
    ulk.a(this.a, paramawfz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ull
 * JD-Core Version:    0.7.0.1
 */