import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class tpz
  implements auoo
{
  tpz(tpy paramtpy) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(auop paramauop) {}
  
  public void b(auop paramauop)
  {
    if ((paramauop.jdField_b_of_type_Int == 0) && (!TextUtils.isEmpty(paramauop.jdField_b_of_type_JavaLangString)))
    {
      this.a.a("UploadImageJob_out_image_url", paramauop.jdField_b_of_type_JavaLangString);
      tpy.a(this.a, true);
      return;
    }
    paramauop = new ErrorMessage(paramauop.jdField_b_of_type_Int, paramauop.a);
    if (QLog.isColorLevel()) {
      QLog.e(this.a.jdField_b_of_type_JavaLangString, 2, paramauop, new Object[0]);
    }
    tpy.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tpz
 * JD-Core Version:    0.7.0.1
 */