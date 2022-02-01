import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class aoia
  extends acnd
{
  aoia(aohy paramaohy) {}
  
  protected void cG(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlManager", 2, "onPassiveExit, troopUin=" + paramString + ", reason=" + paramInt);
    }
    Iterator localIterator = aohy.a(this.a).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((aoih)((Map.Entry)localIterator.next()).getValue()).cG(paramString, paramInt);
    }
  }
  
  protected void q(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlManager", 2, "onTroopManagerSuccess,reqType=" + paramInt1 + ", result=" + paramInt2 + ", troopUin=" + paramString);
    }
    if ((paramInt2 == 0) && ((paramInt1 == 9) || (paramInt1 == 2)))
    {
      Iterator localIterator = aohy.a(this.a).entrySet().iterator();
      while (localIterator.hasNext()) {
        ((aoih)((Map.Entry)localIterator.next()).getValue()).q(paramInt1, paramInt2, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoia
 * JD-Core Version:    0.7.0.1
 */