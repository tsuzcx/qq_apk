import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class wdq
  implements azla
{
  wdq(wdp paramwdp) {}
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void onSend(azlb paramazlb)
  {
    if (paramazlb.jdField_b_of_type_Int == 0)
    {
      this.a.jdField_a_of_type_Wdd.c = paramazlb.jdField_b_of_type_JavaLangString;
      this.a.jdField_a_of_type_Wdd.a = paramazlb.c;
      this.a.b();
      wdp.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramazlb.jdField_b_of_type_Int == StoryUploadProcessor.makeStoryErrorCoder(940010)) && (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() < 2))
    {
      wdp.a(this.a);
      ykq.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "retry load file");
      return;
    }
    this.a.b();
    paramazlb = new ErrorMessage(paramazlb.jdField_b_of_type_Int, paramazlb.a);
    paramazlb.extraMsg = "upload";
    wdp.a(this.a, paramazlb);
  }
  
  public void updateMsg(azlb paramazlb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdq
 * JD-Core Version:    0.7.0.1
 */