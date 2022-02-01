import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList.6.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class mbu
  extends lce
{
  public mbu(ComponentContentRecommendFollowList paramComponentContentRecommendFollowList) {}
  
  public void W(long paramLong, boolean paramBoolean)
  {
    ComponentContentRecommendFollowList.6.1 local1 = new ComponentContentRecommendFollowList.6.1(this, paramLong, paramBoolean);
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (int i = 1; i == 0; i = 0)
    {
      ThreadManager.getUIHandler().post(local1);
      return;
    }
    local1.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mbu
 * JD-Core Version:    0.7.0.1
 */