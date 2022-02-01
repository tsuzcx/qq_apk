import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class vse
  implements aaaj
{
  vse(vsd paramvsd) {}
  
  public void a(boolean paramBoolean, Map<String, aaah> paramMap)
  {
    if ((paramBoolean) && (paramMap != null))
    {
      Iterator localIterator = paramMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = (aaah)paramMap.get(str);
        if (!vry.a.containsKey(str))
        {
          localObject = ((aaah)localObject).b;
          AnimationView.AnimationInfo localAnimationInfo = AnimationView.AnimationInfo.loadFromFolder((String)localObject);
          if (localAnimationInfo == null) {
            break label182;
          }
          localAnimationInfo.mInterval = 40;
          localAnimationInfo.mCycle = 2147483647;
          vry.a.put(str, localAnimationInfo);
          label108:
          localObject = zzc.a((String)localObject);
          if ((localObject == null) || (localObject.length <= 0)) {
            break label193;
          }
          QLog.d("QCirclePolymorphicLikePopWindow", 1, "lists length = " + localObject.length);
        }
        for (;;)
        {
          QLog.d("QCirclePolymorphicLikePopWindow", 1, "downUrl = " + str);
          break;
          label182:
          QLog.d("QCirclePolymorphicLikePopWindow", 1, "info is null");
          break label108;
          label193:
          QLog.d("QCirclePolymorphicLikePopWindow", 1, "this is not files");
        }
      }
      vsd.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vse
 * JD-Core Version:    0.7.0.1
 */