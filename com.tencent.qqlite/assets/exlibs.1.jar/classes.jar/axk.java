import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class axk
  implements Runnable
{
  public axk(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    NearbyPeopleProfileActivity.a(this.a, (ays)NearbyPeopleProfileActivity.a(this.a).poll());
    if (NearbyPeopleProfileActivity.a(this.a) == null) {
      return;
    }
    CompressInfo localCompressInfo = new CompressInfo();
    localCompressInfo.c = NearbyPeopleProfileActivity.a(this.a).a;
    localCompressInfo.g = 0;
    localCompressInfo.f = 0;
    CompressOperator.a(localCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.upload_local_photo", 2, "NearbyPeopleProfileActivity.uploadPhoto(), img_path = " + localCompressInfo.e);
    }
    if (!StringUtil.b(localCompressInfo.e))
    {
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.a = true;
      localTransferRequest.h = localCompressInfo.e;
      localTransferRequest.b = 8;
      this.a.app.a().a(localTransferRequest);
      return;
    }
    this.a.runOnUiThread(new axl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     axk
 * JD-Core Version:    0.7.0.1
 */