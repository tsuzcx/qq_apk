import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class xcj
  implements ayyt
{
  xcj(xci paramxci) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(ayyu paramayyu) {}
  
  public void b(ayyu paramayyu)
  {
    if ((paramayyu.jdField_b_of_type_Int == 0) && (!TextUtils.isEmpty(paramayyu.jdField_b_of_type_JavaLangString)))
    {
      this.a.a("UploadImageJob_out_image_url", paramayyu.jdField_b_of_type_JavaLangString);
      xci.a(this.a, true);
      return;
    }
    paramayyu = new ErrorMessage(paramayyu.jdField_b_of_type_Int, paramayyu.a);
    if (QLog.isColorLevel()) {
      QLog.e(this.a.jdField_b_of_type_JavaLangString, 2, paramayyu, new Object[0]);
    }
    xci.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcj
 * JD-Core Version:    0.7.0.1
 */