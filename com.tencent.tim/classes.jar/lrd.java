import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnTopicRecommendHeaderFollowClickListener.3.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class lrd
  implements ljc.c
{
  lrd(lra paramlra, boolean paramBoolean) {}
  
  public void f(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnTopicRecommendHeaderFollowClickListener", 2, "取消关注 handleResp request businessID = " + lra.a(this.a).businessId + " requestFollowType = " + this.akK + " isSuccess = " + paramBoolean + " distUin = " + paramString + " data = " + paramInt);
    }
    int i = lra.a(this.a).businessId;
    if ((paramBoolean) && (paramInt == 2) && (String.valueOf(i).equals(paramString))) {
      ThreadManager.post(new OnTopicRecommendHeaderFollowClickListener.3.1(this), 5, null, true);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("OnTopicRecommendHeaderFollowClickListener", 2, "取消关注失败 isSuccess =" + paramBoolean + " distUin = " + paramString + " data = " + paramInt + " isfollow " + this.akK + " businessId = " + lra.a(this.a).businessId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lrd
 * JD-Core Version:    0.7.0.1
 */