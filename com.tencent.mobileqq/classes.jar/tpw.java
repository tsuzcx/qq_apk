import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class tpw
  implements auoq
{
  tpw(tpv paramtpv) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(auor paramauor) {}
  
  public void b(auor paramauor)
  {
    if ((paramauor.jdField_b_of_type_Int == 0) && (!TextUtils.isEmpty(paramauor.jdField_b_of_type_JavaLangString)))
    {
      this.a.a("UploadImageJob_out_image_url", paramauor.jdField_b_of_type_JavaLangString);
      tpv.a(this.a, true);
      return;
    }
    paramauor = new ErrorMessage(paramauor.jdField_b_of_type_Int, paramauor.a);
    if (QLog.isColorLevel()) {
      QLog.e(this.a.jdField_b_of_type_JavaLangString, 2, paramauor, new Object[0]);
    }
    tpv.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tpw
 * JD-Core Version:    0.7.0.1
 */