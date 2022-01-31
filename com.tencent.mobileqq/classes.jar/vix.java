import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class vix
  implements awkh
{
  vix(viw paramviw) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awki paramawki) {}
  
  public void b(awki paramawki)
  {
    if ((paramawki.jdField_b_of_type_Int == 0) && (!TextUtils.isEmpty(paramawki.jdField_b_of_type_JavaLangString)))
    {
      this.a.a("UploadImageJob_out_image_url", paramawki.jdField_b_of_type_JavaLangString);
      viw.a(this.a, true);
      return;
    }
    paramawki = new ErrorMessage(paramawki.jdField_b_of_type_Int, paramawki.a);
    if (QLog.isColorLevel()) {
      QLog.e(this.a.jdField_b_of_type_JavaLangString, 2, paramawki, new Object[0]);
    }
    viw.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vix
 * JD-Core Version:    0.7.0.1
 */