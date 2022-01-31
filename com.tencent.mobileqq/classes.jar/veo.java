import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class veo
  implements awfy
{
  veo(ven paramven) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awfz paramawfz) {}
  
  public void b(awfz paramawfz)
  {
    if ((paramawfz.jdField_b_of_type_Int == 0) && (!TextUtils.isEmpty(paramawfz.jdField_b_of_type_JavaLangString)))
    {
      this.a.a("UploadImageJob_out_image_url", paramawfz.jdField_b_of_type_JavaLangString);
      ven.a(this.a, true);
      return;
    }
    paramawfz = new ErrorMessage(paramawfz.jdField_b_of_type_Int, paramawfz.a);
    if (QLog.isColorLevel()) {
      QLog.e(this.a.jdField_b_of_type_JavaLangString, 2, paramawfz, new Object[0]);
    }
    ven.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     veo
 * JD-Core Version:    0.7.0.1
 */