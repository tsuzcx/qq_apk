import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class upx
  implements awkh
{
  upx(upw paramupw) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awki paramawki) {}
  
  public void b(awki paramawki)
  {
    if (paramawki.jdField_b_of_type_Int == 0)
    {
      this.a.jdField_a_of_type_Upc.c = paramawki.jdField_b_of_type_JavaLangString;
      this.a.jdField_a_of_type_Upc.a = paramawki.c;
      this.a.b();
      upw.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramawki.jdField_b_of_type_Int == baxx.a(940010)) && (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() < 2))
    {
      upw.a(this.a);
      wxe.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "retry load file");
      return;
    }
    this.a.b();
    paramawki = new ErrorMessage(paramawki.jdField_b_of_type_Int, paramawki.a);
    paramawki.extraMsg = "upload";
    upw.a(this.a, paramawki);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     upx
 * JD-Core Version:    0.7.0.1
 */