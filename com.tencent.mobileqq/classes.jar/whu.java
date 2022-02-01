import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class whu
  implements ayeo
{
  whu(wht paramwht) {}
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void onSend(ayep paramayep)
  {
    if ((paramayep.jdField_b_of_type_Int == 0) && (!TextUtils.isEmpty(paramayep.jdField_b_of_type_JavaLangString)))
    {
      this.a.a("UploadImageJob_out_image_url", paramayep.jdField_b_of_type_JavaLangString);
      wht.a(this.a, true);
      return;
    }
    paramayep = new ErrorMessage(paramayep.jdField_b_of_type_Int, paramayep.a);
    if (QLog.isColorLevel()) {
      QLog.e(this.a.jdField_b_of_type_JavaLangString, 2, paramayep, new Object[0]);
    }
    wht.b(this.a, false);
  }
  
  public void updateMsg(ayep paramayep) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     whu
 * JD-Core Version:    0.7.0.1
 */