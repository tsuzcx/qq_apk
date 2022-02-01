import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class axtc
  implements aolm.b
{
  axtc(axsz.b paramb) {}
  
  public void onResp(aomh paramaomh)
  {
    ayna.c localc = (ayna.c)paramaomh.b.U();
    String str1 = localc.resUrl;
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "onResp ,url is :" + str1 + " http status:" + paramaomh.dPy);
    }
    Object localObject;
    String str2;
    if (paramaomh.dPy == 200)
    {
      localObject = axsz.a(localc);
      QLog.d("QIMInformationPasterManager", 1, "info paster path:" + (String)localObject);
      str2 = aqhq.px((String)localObject);
      if ((localc.tT == null) || (!localc.tT.equalsIgnoreCase(str2))) {}
    }
    for (boolean bool = axsz.b.a(this.b).d(localc);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "onResp:" + paramaomh.dPy + ",isSuccess:" + bool);
      }
      paramaomh = ((ArrayList)axsz.b.a(this.b).get(str1)).iterator();
      while (paramaomh.hasNext())
      {
        localObject = (WeakReference)paramaomh.next();
        if (((WeakReference)localObject).get() != null) {
          ((axsz.a)((WeakReference)localObject).get()).a(bool, str1, localc);
        }
      }
      aqhq.delete((String)localObject, false);
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "info paster res md5 error, res md5:" + localc.tT + ",file md5:" + str2);
      }
    }
    axsz.b.a(this.b).remove(str1);
  }
  
  public void onUpdateProgeress(aomg arg1, long paramLong1, long paramLong2)
  {
    String str = ((ayna.c)???.U()).resUrl;
    float f = (float)(100L * paramLong1 / paramLong2);
    synchronized (axsz.b.a(this.b))
    {
      Iterator localIterator = ((ArrayList)axsz.b.a(this.b).get(str)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((axsz.a)localWeakReference.get()).a(f, str, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axtc
 * JD-Core Version:    0.7.0.1
 */