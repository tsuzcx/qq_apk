import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class wdn
  implements azla
{
  wdn(wdm paramwdm) {}
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void onSend(azlb paramazlb)
  {
    if (paramazlb.jdField_b_of_type_Int == 0)
    {
      this.a.jdField_b_of_type_JavaLangString = paramazlb.jdField_b_of_type_JavaLangString;
      this.a.b();
      wdm.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramazlb.jdField_b_of_type_Int == StoryUploadProcessor.makeStoryErrorCoder(940010)) && (this.a.a.getAndIncrement() < 2))
    {
      wdm.a(this.a);
      ykq.d("Q.qqstory.publish.upload:ImageFileObject", "retry load file");
      return;
    }
    paramazlb = new ErrorMessage(paramazlb.jdField_b_of_type_Int, paramazlb.a);
    paramazlb.extraMsg = "upload";
    wdm.a(this.a, paramazlb);
  }
  
  public void updateMsg(azlb paramazlb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdn
 * JD-Core Version:    0.7.0.1
 */