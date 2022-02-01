import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.os.MqqHandler;

class oad
  extends nzt
{
  oad(oac paramoac) {}
  
  protected void r(boolean paramBoolean, List<nzw> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptObserver", 2, "onGetRecommendList isSuccess: " + paramBoolean + " | data: " + paramList + " | isShowRecommend: " + this.this$0.avU);
    }
    if ((paramBoolean) && (this.this$0.avU))
    {
      if ((paramList == null) || (paramList.isEmpty())) {
        break label145;
      }
      this.this$0.setData(paramList);
      paramList = this.this$0.mApp.getHandler(SubscriptFeedsActivity.class);
      if ((paramList != null) && (this.this$0.mContext.get() != null) && ((this.this$0.mContext.get() instanceof SubscriptFeedsActivity))) {
        paramList.sendEmptyMessage(1004);
      }
    }
    label145:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SubscriptObserver", 2, "onGetRecommendList data is null or empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oad
 * JD-Core Version:    0.7.0.1
 */