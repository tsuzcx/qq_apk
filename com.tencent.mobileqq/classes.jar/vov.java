import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class vov
  implements ayeo
{
  vov(vou paramvou) {}
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void onSend(ayep paramayep)
  {
    if (paramayep.jdField_b_of_type_Int == 0)
    {
      this.a.jdField_a_of_type_Voi.c = paramayep.jdField_b_of_type_JavaLangString;
      this.a.jdField_a_of_type_Voi.a = paramayep.c;
      this.a.b();
      vou.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramayep.jdField_b_of_type_Int == StoryUploadProcessor.makeStoryErrorCoder(940010)) && (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() < 2))
    {
      vou.a(this.a);
      xvv.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "retry load file");
      return;
    }
    this.a.b();
    paramayep = new ErrorMessage(paramayep.jdField_b_of_type_Int, paramayep.a);
    paramayep.extraMsg = "upload";
    vou.a(this.a, paramayep);
  }
  
  public void updateMsg(ayep paramayep) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vov
 * JD-Core Version:    0.7.0.1
 */