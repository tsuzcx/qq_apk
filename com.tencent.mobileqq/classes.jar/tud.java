import android.os.Bundle;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class tud
  implements BusinessObserver
{
  tud(tub paramtub, tua paramtua) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "do unfollow->uin:" + this.jdField_a_of_type_Tua.a + ", success:" + String.valueOf(paramBoolean));
    }
    if ((tub.a(this.jdField_a_of_type_Tub) != null) && (tub.a(this.jdField_a_of_type_Tub).isResume())) {
      tub.a(this.jdField_a_of_type_Tub).b(false);
    }
    if (!paramBoolean) {
      tub.a(this.jdField_a_of_type_Tub);
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
            tub.b(this.jdField_a_of_type_Tub, this.jdField_a_of_type_Tua);
            StructLongMessageDownloadProcessor.a(tub.a(this.jdField_a_of_type_Tub), this.jdField_a_of_type_Tua.a);
            ((bgre)tub.a(this.jdField_a_of_type_Tub).getManager(132)).a(this.jdField_a_of_type_Tua.a);
            return;
          }
          tub.a(this.jdField_a_of_type_Tub);
          return;
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tud
 * JD-Core Version:    0.7.0.1
 */