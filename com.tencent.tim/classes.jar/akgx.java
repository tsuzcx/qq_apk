import android.os.Message;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;

class akgx
  extends aook
{
  akgx(akgm paramakgm) {}
  
  public void handleMessage(Message paramMessage)
  {
    aoko localaoko = (aoko)paramMessage.obj;
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
        } while (localaoko.fileType != 8);
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..mPicUploadHandler.handleMessage(), upload success. photo_id = " + aomd.bxx);
        }
      } while (akgm.a(this.this$0) == null);
      akgm.a(this.this$0).photoId = aomd.bxx;
      akgm.a(this.this$0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..mPicUploadHandler.handleMessage(), upload fail.");
    }
    this.this$0.a.aqz();
    this.this$0.a.showToast(acfp.m(2131708865));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akgx
 * JD-Core Version:    0.7.0.1
 */