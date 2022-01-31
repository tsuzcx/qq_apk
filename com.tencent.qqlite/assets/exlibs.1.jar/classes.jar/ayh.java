import android.os.Message;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ayh
  extends TransProcessorHandler
{
  public ayh(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (NearbyPeopleProfileActivity.b(this.a) != 1) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      case 1004: 
      default: 
        return;
      case 1003: 
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby_people_card.upload_local_photo", 2, "NearbyPeopleProfileActivity.mPicUploadHandler.handleMessage(), upload success. photo_id = " + NearbyPeoplePhotoUploadProcessor.aN);
        }
        break;
      }
    } while (NearbyPeopleProfileActivity.a(this.a) == null);
    NearbyPeopleProfileActivity.a(this.a).a = NearbyPeoplePhotoUploadProcessor.aN;
    NearbyPeopleProfileActivity.f(this.a);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.upload_local_photo", 2, "NearbyPeopleProfileActivity.mPicUploadHandler.handleMessage(), upload fail.");
    }
    this.a.c();
    QQToast.a(this.a, "上传失败", 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ayh
 * JD-Core Version:    0.7.0.1
 */