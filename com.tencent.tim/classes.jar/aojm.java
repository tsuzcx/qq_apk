import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.BaseTransFileController.1;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class aojm
  implements aolm.b
{
  public aent.a a;
  public aojm.a a;
  public AppInterface app;
  public int count;
  public ConcurrentHashMap<String, aqoi> cz = new ConcurrentHashMap(20);
  AtomicBoolean mWorking = new AtomicBoolean(true);
  public long startTime;
  
  public aojm(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.TransFileController", 2, "construct transfilecontroller:" + this);
    }
    this.app = paramAppInterface;
    this.a = new aojm.a(ThreadManager.getSubThreadLooper());
    ThreadManager.executeOnSubThread(new BaseTransFileController.1(this));
  }
  
  public abstract aojn a(aool paramaool);
  
  public aqoi a(String paramString, long paramLong)
  {
    if (!this.cz.isEmpty()) {
      return (aqoi)this.cz.get(paramString + paramLong);
    }
    return null;
  }
  
  protected Set<String> a(ConcurrentHashMap<String, aqoi> paramConcurrentHashMap)
  {
    HashSet localHashSet = new HashSet();
    if (paramConcurrentHashMap != null) {}
    for (paramConcurrentHashMap = paramConcurrentHashMap.keySet(); paramConcurrentHashMap != null; paramConcurrentHashMap = null)
    {
      paramConcurrentHashMap = paramConcurrentHashMap.iterator();
      while (paramConcurrentHashMap.hasNext()) {
        localHashSet.add((String)paramConcurrentHashMap.next());
      }
    }
    return localHashSet;
  }
  
  public void a(aook paramaook)
  {
    aojn.c(paramaook);
  }
  
  public void a(aool paramaool)
  {
    paramaool = paramaool.AO();
    if (this.cz.containsKey(paramaool))
    {
      Object localObject = (aqoi)this.cz.get(paramaool);
      if ((localObject instanceof aojn))
      {
        localObject = (aojn)localObject;
        ((aojn)localObject).stop();
        ((aojn)localObject).cancel();
        this.cz.remove(paramaool);
      }
    }
  }
  
  public boolean a(aool paramaool)
  {
    Object localObject = paramaool.AO();
    if (this.mWorking.get())
    {
      if (!this.cz.containsKey(localObject))
      {
        paramaool = a(paramaool);
        if ((paramaool != null) && (paramaool.KH() == 0))
        {
          this.cz.put(localObject, paramaool);
          paramaool.setKey((String)localObject);
          if (this.a != null)
          {
            this.a.a(paramaool);
            return true;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.TransFileController", 2, "bad bad:" + paramaool.mUniseq);
        }
        long l = System.currentTimeMillis();
        if (this.startTime <= 0L) {
          this.startTime = l;
        }
        if (l - this.startTime > 2000L) {
          this.startTime = l;
        }
        for (this.count = 0;; this.count += 1)
        {
          if (this.count > 500) {
            QLog.e("Q.richmedia.TransFileController", 1, "bad bad 日志频繁打印" + QLog.getStackTraceString(new Throwable()));
          }
          localObject = (aojn)a(paramaool.mPeerUin, paramaool.mUniseq);
          if (localObject != null)
          {
            if ((paramaool.mFileType == 131078) && (((aojn)localObject).h != null) && (((aojn)localObject).h.b == null) && (paramaool.b != null))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.richmedia.TransFileController", 2, "multimsg-replace callback to predownload");
              }
              ((aojn)localObject).h.b = paramaool.b;
            }
            ((aojn)localObject).EN();
          }
          return false;
        }
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.e("Q.richmedia.TransFileController", 2, aoja.e(new Exception("tranfilecontroller closed")));
    }
    return false;
  }
  
  public void b(aook paramaook)
  {
    aojn.d(paramaook);
  }
  
  public void dUY()
  {
    Iterator localIterator = a(this.cz).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = (aqoi)this.cz.get(str);
      if ((localObject instanceof aojn))
      {
        localObject = (aojn)localObject;
        ((aojn)localObject).stop();
        ((aojn)localObject).cancel();
        ((aojn)localObject).dUR();
        this.cz.remove(str);
      }
    }
  }
  
  public void onResp(aomh paramaomh)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("doPreConn req").append(paramaomh.b).append(" result:");
      if (paramaomh.mResult != 0) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      QLog.e("Q.richmedia.TransFileController", 2, bool);
      return;
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  
  public boolean oy(String paramString)
  {
    if (paramString == null) {}
    while (this.cz.remove(paramString) == null) {
      return false;
    }
    return true;
  }
  
  public class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void a(aojn paramaojn)
    {
      sendMessage(obtainMessage(0, paramaojn));
    }
    
    public void handleMessage(Message paramMessage)
    {
      if ((paramMessage.what == 0) && (paramMessage.obj != null) && ((paramMessage.obj instanceof aojn))) {
        paramMessage = (aojn)paramMessage.obj;
      }
      try
      {
        aool localaool = paramMessage.a();
        if ((localaool != null) && (localaool.mUniseq != 0L) && (localaool.F == null) && ((paramMessage.app instanceof QQAppInterface))) {
          localaool.F = ((QQAppInterface)paramMessage.app).b().b(localaool.mPeerUin, localaool.mUinType, localaool.mUniseq);
        }
      }
      catch (Exception localException)
      {
        label96:
        break label96;
      }
      paramMessage.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aojm
 * JD-Core Version:    0.7.0.1
 */