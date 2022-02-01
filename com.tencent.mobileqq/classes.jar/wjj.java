import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class wjj
  implements ayyt
{
  wjj(wji paramwji) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(ayyu paramayyu) {}
  
  public void b(ayyu paramayyu)
  {
    if (paramayyu.jdField_b_of_type_Int == 0)
    {
      this.a.jdField_a_of_type_Wio.c = paramayyu.jdField_b_of_type_JavaLangString;
      this.a.jdField_a_of_type_Wio.a = paramayyu.c;
      this.a.b();
      wji.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramayyu.jdField_b_of_type_Int == bdza.a(940010)) && (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() < 2))
    {
      wji.a(this.a);
      yqp.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "retry load file");
      return;
    }
    this.a.b();
    paramayyu = new ErrorMessage(paramayyu.jdField_b_of_type_Int, paramayyu.a);
    paramayyu.extraMsg = "upload";
    wji.a(this.a, paramayyu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjj
 * JD-Core Version:    0.7.0.1
 */