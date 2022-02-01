import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnTopicRecommendHeaderFollowClickListener.4.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class lre
  implements ljc.c
{
  lre(lra paramlra, boolean paramBoolean) {}
  
  public void f(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnTopicRecommendHeaderFollowClickListener", 2, "关注 handleResp request businessID = " + lra.a(this.a).businessId + " requestFollowType = " + this.akK + " isSuccess = " + paramBoolean + " distUin = " + paramString + " data = " + paramInt);
    }
    if ((paramBoolean) && (paramInt == 1)) {
      ThreadManager.post(new OnTopicRecommendHeaderFollowClickListener.4.1(this), 5, null, true);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("OnTopicRecommendHeaderFollowClickListener", 2, "关注失败 isSuccess =" + paramBoolean + " distUin = " + paramString + " data = " + paramInt + " isfollow " + this.akK + " businessId = " + lra.a(this.a).businessId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lre
 * JD-Core Version:    0.7.0.1
 */