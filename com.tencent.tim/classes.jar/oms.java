import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;

public class oms
  extends omr<omj, WSPushStrategyInfo>
{
  public oms(omj paramomj)
  {
    super(paramomj);
  }
  
  public boolean a(Context paramContext, WSPushStrategyInfo paramWSPushStrategyInfo)
  {
    WSHomeFragment.c(paramContext, 0, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oms
 * JD-Core Version:    0.7.0.1
 */