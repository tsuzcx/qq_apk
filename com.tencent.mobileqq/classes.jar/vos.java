import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class vos
  implements ayeo
{
  vos(vor paramvor) {}
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void onSend(ayep paramayep)
  {
    if (paramayep.jdField_b_of_type_Int == 0)
    {
      this.a.jdField_b_of_type_JavaLangString = paramayep.jdField_b_of_type_JavaLangString;
      this.a.b();
      vor.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramayep.jdField_b_of_type_Int == StoryUploadProcessor.makeStoryErrorCoder(940010)) && (this.a.a.getAndIncrement() < 2))
    {
      vor.a(this.a);
      xvv.d("Q.qqstory.publish.upload:ImageFileObject", "retry load file");
      return;
    }
    paramayep = new ErrorMessage(paramayep.jdField_b_of_type_Int, paramayep.a);
    paramayep.extraMsg = "upload";
    vor.a(this.a, paramayep);
  }
  
  public void updateMsg(ayep paramayep) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vos
 * JD-Core Version:    0.7.0.1
 */