import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class xge
  implements azrg
{
  xge(xgd paramxgd) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(azrh paramazrh) {}
  
  public void b(azrh paramazrh)
  {
    if ((paramazrh.jdField_b_of_type_Int == 0) && (!TextUtils.isEmpty(paramazrh.jdField_b_of_type_JavaLangString)))
    {
      this.a.a("UploadImageJob_out_image_url", paramazrh.jdField_b_of_type_JavaLangString);
      xgd.a(this.a, true);
      return;
    }
    paramazrh = new ErrorMessage(paramazrh.jdField_b_of_type_Int, paramazrh.a);
    if (QLog.isColorLevel()) {
      QLog.e(this.a.jdField_b_of_type_JavaLangString, 2, paramazrh, new Object[0]);
    }
    xgd.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xge
 * JD-Core Version:    0.7.0.1
 */