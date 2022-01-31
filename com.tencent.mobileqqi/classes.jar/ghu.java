import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.RecommendTroopInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.newfriend.RecommendTroopMessage;
import java.util.List;

public class ghu
  extends TroopObserver
{
  public ghu(RecommendTroopMessage paramRecommendTroopMessage) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    paramString = (RecommendTroopInfo)RecommendTroopMessage.a(this.a).get(0);
    if ((paramString == null) || (paramLong != Long.valueOf(paramString.uin).longValue())) {}
    do
    {
      return;
      RecommendTroopMessage.a(this.a).c(this.a.a);
    } while (!paramBoolean);
    paramString.option = paramTroopInfo.cGroupOption;
    RecommendTroopMessage.a(this.a, paramString, paramTroopInfo.joinTroopQuestion, paramTroopInfo.joinTroopAnswer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ghu
 * JD-Core Version:    0.7.0.1
 */