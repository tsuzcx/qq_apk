import android.os.Message;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ajub
  extends aook
{
  public ajub(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    aoko localaoko = (aoko)paramMessage.obj;
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1002: 
      if (localaoko.fileSize <= 0L) {
        break;
      }
    }
    for (int i = (int)(localaoko.transferedSize * 100L / localaoko.fileSize); QLog.isColorLevel(); i = 0)
    {
      QLog.d("Q.nearby_people_card.upload_local_photo", 2, "NearbyGuideActivity .mPicUploadHandler.handleMessage, send process : " + i);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.upload_local_photo", 2, "NearbyGuideActivity.mPicUploadHandler.handleMessage(), upload success. photo_id = " + aomd.bxx);
      }
      i = aomd.bxx;
      if (i >= 0) {
        this.this$0.yb.set(0, Integer.valueOf(i));
      }
      this.this$0.eB(this.this$0.yb);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.upload_local_photo", 2, "NearbyGuideActivity.mPicUploadHandler.handleMessage(), upload fail.");
      }
      this.this$0.cwL();
      this.this$0.showToast(acfp.m(2131708736));
      this.this$0.aF(true, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajub
 * JD-Core Version:    0.7.0.1
 */