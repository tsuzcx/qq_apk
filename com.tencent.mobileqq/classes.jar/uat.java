import android.os.Bundle;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class uat
  implements BusinessObserver
{
  uat(uar paramuar, uaq paramuaq) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "do unfollow->uin:" + this.jdField_a_of_type_Uaq.a + ", success:" + String.valueOf(paramBoolean));
    }
    if ((uar.a(this.jdField_a_of_type_Uar) != null) && (uar.a(this.jdField_a_of_type_Uar).isResume())) {
      uar.a(this.jdField_a_of_type_Uar).b(false);
    }
    if (!paramBoolean) {
      uar.a(this.jdField_a_of_type_Uar);
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
            uar.b(this.jdField_a_of_type_Uar, this.jdField_a_of_type_Uaq);
            StructLongMessageDownloadProcessor.deleteTask(uar.a(this.jdField_a_of_type_Uar), this.jdField_a_of_type_Uaq.a);
            ((bfas)uar.a(this.jdField_a_of_type_Uar).getManager(132)).a(this.jdField_a_of_type_Uaq.a);
            return;
          }
          uar.a(this.jdField_a_of_type_Uar);
          return;
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uat
 * JD-Core Version:    0.7.0.1
 */