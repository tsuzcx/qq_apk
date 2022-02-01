import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class advn
  implements aolm.b
{
  advn(advm paramadvm) {}
  
  public void onResp(aomh arg1)
  {
    Object localObject1;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("onResp reqUrl: resp is null: ");
      if (??? == null)
      {
        bool = true;
        QLog.i("Q.dynamicAvatar", 2, bool);
      }
    }
    else
    {
      if (??? != null) {
        break label51;
      }
    }
    label51:
    do
    {
      return;
      bool = false;
      break;
      localObject1 = ((aoll)???.b).bZ;
      int i = ???.mResult;
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "onResp reqUrl: " + (String)localObject1 + " mResult: " + i + ",httpCode:" + ???.dPy + ",errDesc:" + ???.clO);
      }
      for (;;)
      {
        synchronized (advm.a(this.this$0))
        {
          if (advm.a(this.this$0).isEmpty()) {
            break;
          }
          Iterator localIterator = advm.a(this.this$0).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject3 = (WeakReference)localIterator.next();
          if ((localObject3 == null) || (((WeakReference)localObject3).get() == null)) {
            continue;
          }
          localObject3 = (advm.a)((WeakReference)localObject3).get();
          if (i == 0)
          {
            bool = true;
            ((advm.a)localObject3).j((String)localObject1, bool, false);
          }
        }
        bool = false;
      }
      advm.a(this.this$0).remove(localObject2);
    } while ((!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext())) || (aqiw.isWifiConnected(BaseApplicationImpl.getContext())));
    advm.a(this.this$0);
  }
  
  public void onUpdateProgeress(aomg arg1, long paramLong1, long paramLong2)
  {
    if ((!advm.a(this.this$0).isEmpty()) && ((??? instanceof aoll))) {
      if (paramLong2 <= 0L) {
        break label148;
      }
    }
    label148:
    for (int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);; i = 0)
    {
      String str = ((aoll)???).bZ;
      synchronized (advm.a(this.this$0))
      {
        if (!advm.a(this.this$0).isEmpty())
        {
          Iterator localIterator = advm.a(this.this$0).iterator();
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((advm.a)localWeakReference.get()).ei(str, i);
            }
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     advn
 * JD-Core Version:    0.7.0.1
 */