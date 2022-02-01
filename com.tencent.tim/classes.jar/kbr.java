import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.ac.ArticleComment.GetRecommendPubAccountResponse;
import com.tencent.mobileqq.ac.ArticleComment.Record;
import com.tencent.mobileqq.ac.ArticleComment.RetInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

class kbr
  implements BusinessObserver
{
  kbr(kbq paramkbq, NewIntent paramNewIntent, QQAppInterface paramQQAppInterface, kbq.a parama) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(kbq.b(this.this$0), 2, "OnReceiveGetRecommendPubAccountResponse failed!");
      }
      kbq.a(this.this$0, this.val$app, this.jdField_a_of_type_Kbq$a);
      return;
    }
    Object localObject;
    try
    {
      localObject = new ArticleComment.GetRecommendPubAccountResponse();
      ((ArticleComment.GetRecommendPubAccountResponse)localObject).mergeFrom(paramBundle.getByteArray("data"));
      if (QLog.isColorLevel()) {
        QLog.d(kbq.b(this.this$0), 2, "OnReceiveGetRecommendPubAccountResponse->retCode:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get() + ", title:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get() + ", listSize:" + ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size());
      }
      if (!((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d(kbq.b(this.this$0), 2, "OnReceiveGetRecommendPubAccountResponse failed!(no ret)");
        }
        kbq.a(this.this$0, this.val$app, this.jdField_a_of_type_Kbq$a);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d(kbq.b(this.this$0), 2, "OnReceiveGetRecommendPubAccountResponse exception:" + paramBundle);
      }
      kbq.a(this.this$0, this.val$app, this.jdField_a_of_type_Kbq$a);
      return;
    }
    paramInt = ((ArticleComment.GetRecommendPubAccountResponse)localObject).ret.ret_code.get();
    if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(kbq.b(this.this$0), 2, "OnReceiveGetRecommendPubAccountResponse forbidden!");
      }
      kbq.a(this.this$0, true);
      this.jdField_a_of_type_Kbq$a.b(new ArrayList(), null, true);
      return;
    }
    kbq.a(this.this$0, false);
    if (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.has()) {}
    for (paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_title.get().toStringUtf8();; paramBundle = "")
    {
      if ((paramInt == 0) && (!TextUtils.isEmpty(paramBundle)) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.has()) && (((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d(kbq.b(this.this$0), 2, "OnReceiveGetRecommendPubAccountResponse update cache!");
        }
        kbq.a(this.this$0, paramBundle);
        kbq.a(this.this$0).clear();
        paramBundle = ((ArticleComment.GetRecommendPubAccountResponse)localObject).recom_list.get().iterator();
        while (paramBundle.hasNext())
        {
          localObject = (ArticleComment.Record)paramBundle.next();
          kbq.a(this.this$0).add(new kbq.c(this.this$0, ((ArticleComment.Record)localObject).puin.get().toStringUtf8(), ((ArticleComment.Record)localObject).name.get().toStringUtf8(), true));
        }
        kbq.a(this.this$0, NetConnInfoCenter.getServerTimeMillis());
        kbq.a(this.this$0, this.val$app);
      }
      kbq.a(this.this$0, this.val$app, this.jdField_a_of_type_Kbq$a);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(kbq.b(this.this$0), 2, "OnReceiveGetRecommendPubAccountResponse update UI->title:" + kbq.a(this.this$0) + ", cacheTime:" + kbq.a(this.this$0) + ", isFobidden:" + kbq.a(this.this$0) + ", recommendSize:" + kbq.a(this.this$0).size());
      paramBundle = kbq.a(this.this$0).iterator();
      while (paramBundle.hasNext())
      {
        localObject = (kbq.c)paramBundle.next();
        QLog.d(kbq.b(this.this$0), 2, ((kbq.c)localObject).toString());
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kbr
 * JD-Core Version:    0.7.0.1
 */