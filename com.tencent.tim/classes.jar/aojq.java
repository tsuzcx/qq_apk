import com.tencent.mobileqq.highway.netprobe.WeakNetCallback;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

final class aojq
  implements WeakNetCallback
{
  private anpc b = anpc.a(BaseApplication.getContext());
  
  public void onResultOverflow(HashMap<String, String> paramHashMap)
  {
    this.b.collectPerformance(aqlr.getUin(), "actWeaknetProbe", true, 0L, paramHashMap.size(), paramHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aojq
 * JD-Core Version:    0.7.0.1
 */