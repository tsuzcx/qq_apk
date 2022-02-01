import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class vpv
  implements zwo
{
  vpv(vpu paramvpu) {}
  
  public void a(boolean paramBoolean, Map<String, zwm> paramMap)
  {
    if ((paramBoolean) && (paramMap != null))
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = (zwm)paramMap.get(str);
        if (!vpp.a.containsKey(str))
        {
          localObject = AnimationView.AnimationInfo.loadFromFolder(((zwm)localObject).b);
          if (localObject != null)
          {
            ((AnimationView.AnimationInfo)localObject).mInterval = 40;
            ((AnimationView.AnimationInfo)localObject).mCycle = 2147483647;
            vpp.a.put(str, localObject);
          }
        }
      }
      vpu.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpv
 * JD-Core Version:    0.7.0.1
 */