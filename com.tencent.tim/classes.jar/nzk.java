import android.os.Bundle;
import android.os.Message;
import com.tencent.biz.pubaccount.subscript.ReadInJoyArticle;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class nzk
  extends nzt
{
  public nzk(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  protected void b(boolean paramBoolean, ArrayList<ReadInJoyArticle> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptObserver", 2, "onGetRecommendReadInJoyArticleList isSuccess: " + paramBoolean + " | data: " + paramArrayList);
    }
    if (!paramBoolean) {}
    do
    {
      do
      {
        return;
        if ((paramArrayList != null) && (paramArrayList.size() == 4)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SubscriptObserver", 2, "onGetRecommendReadInJoyArticleList data is null or small than 4");
      return;
    } while (this.this$0.k == null);
    Message localMessage = new Message();
    localMessage.what = 1003;
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("ReadInJoyArticleList", paramArrayList);
    localMessage.setData(localBundle);
    this.this$0.k.removeMessages(1003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nzk
 * JD-Core Version:    0.7.0.1
 */