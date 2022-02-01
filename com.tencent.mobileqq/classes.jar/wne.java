import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class wne
  implements azrg
{
  wne(wnd paramwnd) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(azrh paramazrh) {}
  
  public void b(azrh paramazrh)
  {
    if (paramazrh.jdField_b_of_type_Int == 0)
    {
      this.a.jdField_a_of_type_Wmj.c = paramazrh.jdField_b_of_type_JavaLangString;
      this.a.jdField_a_of_type_Wmj.a = paramazrh.c;
      this.a.b();
      wnd.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramazrh.jdField_b_of_type_Int == bext.a(940010)) && (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() < 2))
    {
      wnd.a(this.a);
      yuk.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "retry load file");
      return;
    }
    this.a.b();
    paramazrh = new ErrorMessage(paramazrh.jdField_b_of_type_Int, paramazrh.a);
    paramazrh.extraMsg = "upload";
    wnd.a(this.a, paramazrh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wne
 * JD-Core Version:    0.7.0.1
 */