import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class ulo
  implements awfy
{
  ulo(uln paramuln) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awfz paramawfz) {}
  
  public void b(awfz paramawfz)
  {
    if (paramawfz.jdField_b_of_type_Int == 0)
    {
      this.a.jdField_a_of_type_Ukt.c = paramawfz.jdField_b_of_type_JavaLangString;
      this.a.jdField_a_of_type_Ukt.a = paramawfz.c;
      this.a.b();
      uln.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramawfz.jdField_b_of_type_Int == bato.a(940010)) && (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() < 2))
    {
      uln.a(this.a);
      wsv.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "retry load file");
      return;
    }
    this.a.b();
    paramawfz = new ErrorMessage(paramawfz.jdField_b_of_type_Int, paramawfz.a);
    paramawfz.extraMsg = "upload";
    uln.a(this.a, paramawfz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ulo
 * JD-Core Version:    0.7.0.1
 */