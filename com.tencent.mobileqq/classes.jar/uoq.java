import android.os.Bundle;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class uoq
  implements BusinessObserver
{
  uoq(uoo paramuoo, uon paramuon) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "do unfollow->uin:" + this.jdField_a_of_type_Uon.a + ", success:" + String.valueOf(paramBoolean));
    }
    if ((uoo.a(this.jdField_a_of_type_Uoo) != null) && (uoo.a(this.jdField_a_of_type_Uoo).isResume())) {
      uoo.a(this.jdField_a_of_type_Uoo).b(false);
    }
    if (!paramBoolean) {
      uoo.a(this.jdField_a_of_type_Uoo);
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
            uoo.b(this.jdField_a_of_type_Uoo, this.jdField_a_of_type_Uon);
            StructLongMessageDownloadProcessor.deleteTask(uoo.a(this.jdField_a_of_type_Uoo), this.jdField_a_of_type_Uon.a);
            ((bgiy)uoo.a(this.jdField_a_of_type_Uoo).getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.jdField_a_of_type_Uon.a);
            return;
          }
          uoo.a(this.jdField_a_of_type_Uoo);
          return;
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uoq
 * JD-Core Version:    0.7.0.1
 */