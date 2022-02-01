import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class aoib
  extends acfd
{
  aoib(aohy paramaohy) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    QLog.i("TogetherControlManager", 1, "onUpdateDelFriend isSuccess: " + paramBoolean + " object: " + paramObject);
    if (paramBoolean)
    {
      Iterator localIterator = aohy.a(this.a).entrySet().iterator();
      while (localIterator.hasNext()) {
        ((aoih)((Map.Entry)localIterator.next()).getValue()).bp(paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoib
 * JD-Core Version:    0.7.0.1
 */