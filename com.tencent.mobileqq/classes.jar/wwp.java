import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class wwp
  implements azla
{
  wwp(wwo paramwwo) {}
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void onSend(azlb paramazlb)
  {
    if ((paramazlb.jdField_b_of_type_Int == 0) && (!TextUtils.isEmpty(paramazlb.jdField_b_of_type_JavaLangString)))
    {
      this.a.a("UploadImageJob_out_image_url", paramazlb.jdField_b_of_type_JavaLangString);
      wwo.a(this.a, true);
      return;
    }
    paramazlb = new ErrorMessage(paramazlb.jdField_b_of_type_Int, paramazlb.a);
    if (QLog.isColorLevel()) {
      QLog.e(this.a.jdField_b_of_type_JavaLangString, 2, paramazlb, new Object[0]);
    }
    wwo.b(this.a, false);
  }
  
  public void updateMsg(azlb paramazlb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwp
 * JD-Core Version:    0.7.0.1
 */