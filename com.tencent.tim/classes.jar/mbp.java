import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup.4.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class mbp
  extends lce
{
  public mbp(ComponentContentRecommendFollowGroup paramComponentContentRecommendFollowGroup) {}
  
  public void W(long paramLong, boolean paramBoolean)
  {
    ComponentContentRecommendFollowGroup.4.1 local1 = new ComponentContentRecommendFollowGroup.4.1(this, paramLong, paramBoolean);
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
 * Qualified Name:     mbp
 * JD-Core Version:    0.7.0.1
 */