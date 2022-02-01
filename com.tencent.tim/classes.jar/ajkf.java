import com.tencent.mobileqq.multicard.MultiCardRecommendFragment;
import com.tencent.mobileqq.multicard.RecommendPerson;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class ajkf
  extends ajkr
{
  public ajkf(MultiCardRecommendFragment paramMultiCardRecommendFragment) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt, Map<Integer, List<RecommendPerson>> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopMemberRecommend.MultiCardRecommendFragment", 2, "onGetTroopMemRecommendCards, success = " + paramBoolean + ",troopUin = " + paramString + ",notifySource = " + paramInt);
    }
    if ((MultiCardRecommendFragment.a(this.a) != null) && (MultiCardRecommendFragment.a(this.a).equals(paramString)))
    {
      MultiCardRecommendFragment.a(this.a).ma.clear();
      MultiCardRecommendFragment.a(this.a).ma.putAll(paramMap);
      this.a.q.removeMessages(1);
      this.a.q.sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajkf
 * JD-Core Version:    0.7.0.1
 */