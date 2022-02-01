import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class vrp
  implements aaaj
{
  vrp(vrn paramvrn) {}
  
  public void a(boolean paramBoolean, Map<String, aaah> paramMap)
  {
    if ((paramBoolean) && (paramMap != null))
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = (aaah)paramMap.get(str);
        if (!vry.a.containsKey(str))
        {
          localObject = AnimationView.AnimationInfo.loadFromFolder(((aaah)localObject).b);
          if (localObject != null)
          {
            ((AnimationView.AnimationInfo)localObject).mInterval = 50;
            ((AnimationView.AnimationInfo)localObject).mCycle = 2147483647;
            vry.a.put(str, localObject);
          }
        }
      }
      vrn.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrp
 * JD-Core Version:    0.7.0.1
 */