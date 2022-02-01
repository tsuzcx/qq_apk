import android.os.Bundle;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class tub
  implements BusinessObserver
{
  tub(ttz paramttz, tty paramtty) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "do unfollow->uin:" + this.jdField_a_of_type_Tty.a + ", success:" + String.valueOf(paramBoolean));
    }
    if ((ttz.a(this.jdField_a_of_type_Ttz) != null) && (ttz.a(this.jdField_a_of_type_Ttz).isResume())) {
      ttz.a(this.jdField_a_of_type_Ttz).b(false);
    }
    if (!paramBoolean) {
      ttz.a(this.jdField_a_of_type_Ttz);
    }
    for (;;)
    {
      return;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.UnFollowResponse localUnFollowResponse = new mobileqq_mp.UnFollowResponse();
          localUnFollowResponse.mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)localUnFollowResponse.ret_info.get()).ret_code.get() == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow success");
            }
            ttz.b(this.jdField_a_of_type_Ttz, this.jdField_a_of_type_Tty);
            StructLongMessageDownloadProcessor.a(ttz.a(this.jdField_a_of_type_Ttz), this.jdField_a_of_type_Tty.a);
            ((bfrd)ttz.a(this.jdField_a_of_type_Ttz).getManager(132)).a(this.jdField_a_of_type_Tty.a);
            return;
          }
          ttz.a(this.jdField_a_of_type_Ttz);
          return;
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tub
 * JD-Core Version:    0.7.0.1
 */