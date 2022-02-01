import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class kuw
  implements BusinessObserver
{
  kuw(kuu paramkuu, BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = 1;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label234;
        }
        WebSsoBody.WebSsoResponseBody localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
        localWebSsoResponseBody.mergeFrom(paramBundle);
        paramInt = localWebSsoResponseBody.ret.get();
        paramBundle = localWebSsoResponseBody.data.get();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentSSOModule", 2, "commentLike ret=" + paramBundle);
        }
        if (paramInt != 0) {
          break label234;
        }
        paramInt = i;
        paramBundle.printStackTrace();
      }
      catch (Exception paramBundle)
      {
        try
        {
          if (kuu.a(this.jdField_b_of_type_Kuu) != null)
          {
            kuu.a(this.jdField_b_of_type_Kuu).a(true, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, this.aLU, this.aLX);
            paramInt = i;
          }
          i = paramInt;
          if ((i == 0) && (kuu.a(this.jdField_b_of_type_Kuu) != null)) {
            kuu.a(this.jdField_b_of_type_Kuu).a(false, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, this.aLU, this.aLX);
          }
          return;
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            paramInt = 1;
          }
        }
        paramBundle = paramBundle;
        paramInt = 0;
      }
      i = paramInt;
      if (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyCommentSSOModule", 2, "fetchCommentList error info:" + paramBundle.getLocalizedMessage());
        i = paramInt;
        continue;
        label234:
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kuw
 * JD-Core Version:    0.7.0.1
 */