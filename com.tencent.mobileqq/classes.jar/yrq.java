import android.os.Bundle;
import android.os.Message;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class yrq
  extends bayj
{
  public yrq(TroopMemberApiService paramTroopMemberApiService) {}
  
  public void handleMessage(Message paramMessage)
  {
    bass localbass;
    Bundle localBundle;
    if ((TroopMemberApiService.j(this.a) instanceof QQAppInterface))
    {
      localbass = (bass)paramMessage.obj;
      localBundle = new Bundle();
      localBundle.putInt("seq", this.a.c);
    }
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
    case 1003: 
      do
      {
        do
        {
          return;
          if (localbass.jdField_b_of_type_Int != 64) {
            break;
          }
          this.a.jdField_a_of_type_Int = bavb.jdField_a_of_type_Int;
        } while (this.a.jdField_a_of_type_Int == this.a.jdField_b_of_type_Int);
        this.a.jdField_b_of_type_Int = this.a.jdField_a_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.i("TroopMemberApiService", 2, "mPhotoUploadHandler.handleMessage(), static avatar upload success. photoId = " + this.a.jdField_a_of_type_Int);
        }
        paramMessage = (auxh)((QQAppInterface)TroopMemberApiService.k(this.a)).a(60);
        if (paramMessage != null) {
          paramMessage.a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Int, true);
        }
        localBundle.putInt("head_id", this.a.jdField_a_of_type_Int);
        localBundle.putString("video_id", this.a.jdField_b_of_type_JavaLangString);
        localBundle.putBoolean("isSuccess", true);
        this.a.a(75, localBundle);
        return;
        if (localbass.jdField_b_of_type_Int == 39)
        {
          this.a.jdField_b_of_type_JavaLangString = ((bavb)localbass.a).jdField_b_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.i("TroopMemberApiService", 2, "mPhotoUploadHandler.handleMessage(), big video upload success. videoId = " + this.a.jdField_b_of_type_JavaLangString);
          }
          auxb.a((QQAppInterface)TroopMemberApiService.l(this.a), this.a.jdField_a_of_type_JavaLangString);
          return;
        }
        localBundle.putBoolean("isSuccess", false);
        this.a.a(75, localBundle);
      } while (!QLog.isColorLevel());
      QLog.i("TroopMemberApiService", 2, "mPhotoUploadHandler.handleMessage(), upload photo failed.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopMemberApiService", 2, "mPhotoUploadHandler.handleMessage(), upload photo failed. STATUS_SEND_ERROR");
    }
    localBundle.putBoolean("isSuccess", false);
    this.a.a(75, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yrq
 * JD-Core Version:    0.7.0.1
 */