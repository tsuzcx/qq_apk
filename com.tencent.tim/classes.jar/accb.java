import android.os.Bundle;
import android.os.Looper;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.BaseBusinessHandler.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;

public abstract class accb
  extends acij
{
  public static final int BG_OBSERVERS = 2;
  public static final int DEFAULT_OBSERVER = 0;
  public static final String SEQ_KEY = accb.class.getName();
  public static final int UI_OBSERVERS = 1;
  private static MqqHandler bgHandler = ThreadManager.getSubThreadHandler();
  private static int notReportedCallNum;
  private static int reportThreshold = -1;
  private static MqqHandler uiHandler = new MqqHandler(Looper.getMainLooper());
  protected Set<String> allowCmdSet;
  private Map<Long, acci> bgObserverMap = new HashMap();
  private long seq;
  private Map<Long, acci> uiObserverMap = new HashMap();
  
  private void dispatchMessage(int paramInt, boolean paramBoolean1, Object paramObject, boolean paramBoolean2, acci paramacci, MqqHandler paramMqqHandler)
  {
    paramObject = new BaseBusinessHandler.1(this, paramacci, paramInt, paramMqqHandler, paramBoolean1, paramObject);
    if (paramBoolean2)
    {
      paramMqqHandler.postAtFrontOfQueue(paramObject);
      return;
    }
    paramMqqHandler.post(paramObject);
  }
  
  protected void addBusinessObserver(ToServiceMsg paramToServiceMsg, acci paramacci, boolean paramBoolean)
  {
    if ((paramacci == null) || (paramBoolean)) {}
    synchronized (this.bgObserverMap)
    {
      ???.put(Long.valueOf(this.seq), paramacci);
      paramToServiceMsg = paramToServiceMsg.extraData;
      paramacci = SEQ_KEY;
      long l = this.seq;
      this.seq = (1L + l);
      paramToServiceMsg.putLong(paramacci, l);
      return;
      ??? = this.uiObserverMap;
    }
  }
  
  public ToServiceMsg createToServiceMsg(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), paramString);
  }
  
  public ToServiceMsg createToServiceMsg(String paramString, acci paramacci)
  {
    return createToServiceMsg(paramString, paramacci, false);
  }
  
  ToServiceMsg createToServiceMsg(String arg1, acci paramacci, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg(???);
    if ((paramacci == null) || (paramBoolean)) {}
    synchronized (this.bgObserverMap)
    {
      ???.put(Long.valueOf(this.seq), paramacci);
      paramacci = localToServiceMsg.extraData;
      String str = SEQ_KEY;
      long l = this.seq;
      this.seq = (1L + l);
      paramacci.putLong(str, l);
      return localToServiceMsg;
      ??? = this.uiObserverMap;
    }
  }
  
  public final <T> T decodePacket(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramT);
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public abstract String getCurrentAccountUin();
  
  public abstract List<acci> getObservers(int paramInt);
  
  protected boolean msgCmdFilter(String paramString)
  {
    return false;
  }
  
  public final void notifyUI(int paramInt, boolean paramBoolean, Object paramObject)
  {
    notifyUI(paramInt, paramBoolean, paramObject, false);
  }
  
  public void notifyUI(int paramInt, boolean paramBoolean1, Object paramObject, boolean paramBoolean2)
  {
    List localList = getObservers(0);
    Iterator localIterator;
    Object localObject;
    if ((localList != null) && (localList.size() > 0)) {
      try
      {
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (acci)localIterator.next();
          if ((observerClass() != null) && (observerClass().isAssignableFrom(localObject.getClass())))
          {
            long l = System.currentTimeMillis();
            ((acci)localObject).onUpdate(paramInt, paramBoolean1, paramObject);
            l = System.currentTimeMillis() - l;
            if ((l > 100L) && (QLog.isColorLevel()))
            {
              localObject = new Exception("run too long!");
              QLog.d("BaseBusinessHandler.notifyUI", 2, "defaultObserver onUpdate cost:" + l, (Throwable)localObject);
            }
          }
        }
      }
      finally {}
    }
    localList = getObservers(1);
    if ((localList != null) && (localList.size() > 0)) {
      try
      {
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (acci)localIterator.next();
          if ((observerClass() != null) && (observerClass().isAssignableFrom(localObject.getClass()))) {
            dispatchMessage(paramInt, paramBoolean1, paramObject, paramBoolean2, (acci)localObject, uiHandler);
          }
        }
      }
      finally {}
    }
    localList = getObservers(2);
    if ((localList != null) && (localList.size() > 0)) {
      try
      {
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (acci)localIterator.next();
          if ((observerClass() != null) && (observerClass().isAssignableFrom(localObject.getClass()))) {
            dispatchMessage(paramInt, paramBoolean1, paramObject, paramBoolean2, (acci)localObject, bgHandler);
          }
        }
      }
      finally {}
    }
  }
  
  public void notifyUI(ToServiceMsg paramToServiceMsg, int paramInt, boolean paramBoolean, Object paramObject)
  {
    long l;
    MqqHandler localMqqHandler;
    if (paramToServiceMsg.extraData.containsKey(SEQ_KEY))
    {
      l = paramToServiceMsg.extraData.getLong(SEQ_KEY);
      synchronized (this.uiObserverMap)
      {
        paramToServiceMsg = (acci)this.uiObserverMap.remove(Long.valueOf(l));
        localMqqHandler = uiHandler;
        if (paramToServiceMsg != null) {}
      }
    }
    for (;;)
    {
      synchronized (this.bgObserverMap)
      {
        paramToServiceMsg = (acci)this.bgObserverMap.remove(Long.valueOf(l));
        localMqqHandler = bgHandler;
        if (paramToServiceMsg != null)
        {
          dispatchMessage(paramInt, paramBoolean, paramObject, false, paramToServiceMsg, localMqqHandler);
          return;
          paramToServiceMsg = finally;
          throw paramToServiceMsg;
        }
      }
      notifyUI(paramInt, paramBoolean, paramObject);
      return;
    }
  }
  
  protected abstract Class<? extends acci> observerClass();
  
  public void onDestroy() {}
  
  public abstract void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject);
  
  protected achq removeMessageObserver(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg == null) || (!paramToServiceMsg.extraData.containsKey(SEQ_KEY))) {
      return null;
    }
    synchronized (this.uiObserverMap)
    {
      long l = paramToServiceMsg.extraData.getLong(SEQ_KEY);
      if (achq.class.isInstance((acci)this.uiObserverMap.get(Long.valueOf(l))))
      {
        paramToServiceMsg = (achq)this.uiObserverMap.remove(Long.valueOf(l));
        return paramToServiceMsg;
      }
    }
    return null;
  }
  
  public abstract void send(ToServiceMsg paramToServiceMsg);
  
  public abstract void sendPbReq(ToServiceMsg paramToServiceMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     accb
 * JD-Core Version:    0.7.0.1
 */