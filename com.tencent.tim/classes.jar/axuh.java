import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean.a;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.a;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class axuh
  implements aolm.b
{
  public axuh(DynamicTextConfigManager.a parama) {}
  
  public void onResp(aomh arg1)
  {
    DynamicTextConfigManager.DynamicTextConfigBean.a locala = (DynamicTextConfigManager.DynamicTextConfigBean.a)???.b.U();
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "onResp, url is: " + locala.resurl + " http status: " + ???.dPy);
    }
    DynamicTextConfigManager.a.a(this.b, locala);
    if ((DynamicTextConfigManager.a.a(this.b).b(locala)) && (DynamicTextConfigManager.a.a(this.b).a(locala))) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        int i;
        synchronized (DynamicTextConfigManager.a.a(this.b))
        {
          ArrayList localArrayList = (ArrayList)DynamicTextConfigManager.a.a(this.b).remove(locala.resurl);
          i = localArrayList.size() - 1;
          if (i >= 0)
          {
            WeakReference localWeakReference = (WeakReference)localArrayList.get(i);
            if (localWeakReference.get() != null) {
              ((DynamicTextConfigManager.b)localWeakReference.get()).bd(bool, locala.resurl);
            }
          }
          else
          {
            return;
          }
        }
        i -= 1;
      }
    }
  }
  
  public void onUpdateProgeress(aomg arg1, long paramLong1, long paramLong2)
  {
    DynamicTextConfigManager.DynamicTextConfigBean.a locala = (DynamicTextConfigManager.DynamicTextConfigBean.a)???.U();
    synchronized (DynamicTextConfigManager.a.a(this.b))
    {
      Iterator localIterator = ((ArrayList)DynamicTextConfigManager.a.a(this.b).get(locala.resurl)).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((DynamicTextConfigManager.b)localWeakReference.get()).a((float)(100L * paramLong1 / paramLong2), locala.resurl, locala.text_id);
        }
      }
    }
    float f = (float)paramLong1 * 100.0F / (float)paramLong2;
    localObject.progress = ((int)f);
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "onResDownloadProgressUpdate url: " + localObject.resurl + " progress: " + f + " curOffset: " + paramLong1 + " totalLen: " + paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axuh
 * JD-Core Version:    0.7.0.1
 */