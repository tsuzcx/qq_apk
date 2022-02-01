import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class ahgy
  extends akye.a
{
  ahgy(ahgx paramahgx, MessageForPic paramMessageForPic) {}
  
  public void a(int paramInt, akxr paramakxr)
  {
    if (this.jdField_a_of_type_Ahgx.a != null) {
      this.jdField_a_of_type_Ahgx.a.onDownloadFinish();
    }
    aoiz.getFilePath(aoop.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 1, null).toString().toString());
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "DownloadBigPic finish");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
      ahgq.a(this.jdField_a_of_type_Ahgx.this$0, xtm.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic), this.jdField_a_of_type_Ahgx.val$uin);
    }
  }
  
  public void aO(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     ahgy
 * JD-Core Version:    0.7.0.1
 */