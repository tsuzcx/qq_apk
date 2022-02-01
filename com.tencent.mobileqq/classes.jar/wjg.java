import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class wjg
  implements ayyt
{
  wjg(wjf paramwjf) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(ayyu paramayyu) {}
  
  public void b(ayyu paramayyu)
  {
    if (paramayyu.jdField_b_of_type_Int == 0)
    {
      this.a.jdField_b_of_type_JavaLangString = paramayyu.jdField_b_of_type_JavaLangString;
      this.a.b();
      wjf.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramayyu.jdField_b_of_type_Int == bdza.a(940010)) && (this.a.a.getAndIncrement() < 2))
    {
      wjf.a(this.a);
      yqp.d("Q.qqstory.publish.upload:ImageFileObject", "retry load file");
      return;
    }
    paramayyu = new ErrorMessage(paramayyu.jdField_b_of_type_Int, paramayyu.a);
    paramayyu.extraMsg = "upload";
    wjf.a(this.a, paramayyu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjg
 * JD-Core Version:    0.7.0.1
 */