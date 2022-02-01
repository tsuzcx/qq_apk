import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.IActionListener;
import cooperation.qzone.remote.RemoteServiceProxy;
import cooperation.qzone.remote.SendMsg;
import cooperation.qzone.remote.logic.QzoneWebPluginProxyService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class avzf
{
  private static avzf jdField_a_of_type_Avzf;
  private static Object lock = new Object();
  private ArrayList<WeakReference<avzi>> Fi = new ArrayList();
  private avzh jdField_a_of_type_Avzh;
  IActionListener mActionListener = new avzg(this);
  private AtomicInteger mReqestId = new AtomicInteger(1);
  private RemoteServiceProxy serviceProxy = new RemoteServiceProxy("com.qzone.common.webplugin.WebPluginHandleService", QzoneWebPluginProxyService.class, BaseApplicationImpl.getApplication().getRuntime().getAccount());
  
  public avzf()
  {
    this.serviceProxy.setActionListener(this.mActionListener);
  }
  
  public static avzf a()
  {
    if (jdField_a_of_type_Avzf == null) {}
    synchronized (lock)
    {
      if (jdField_a_of_type_Avzf == null) {
        jdField_a_of_type_Avzf = new avzf();
      }
      return jdField_a_of_type_Avzf;
    }
  }
  
  protected int a(String paramString, Bundle paramBundle, long paramLong, boolean paramBoolean)
  {
    SendMsg localSendMsg = new SendMsg(paramString);
    paramString = paramBundle;
    if (paramBundle == null) {
      paramString = new Bundle();
    }
    if ((paramString != null) && (paramString.size() > 0)) {
      localSendMsg.extraData.putAll(paramString);
    }
    int i = this.mReqestId.incrementAndGet();
    localSendMsg.setRequestId(i);
    if (paramLong > 0L) {
      localSendMsg.setTimeout(paramLong);
    }
    localSendMsg.setNeedCallback(paramBoolean);
    if (paramBoolean) {
      localSendMsg.actionListener = this.mActionListener;
    }
    try
    {
      this.serviceProxy.sendMsg(localSendMsg);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      throw new RuntimeException("sendMsg is fail", paramString);
    }
  }
  
  public int a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    try
    {
      int i = a(paramString, paramBundle, 0L, paramBoolean);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public avzh a()
  {
    if (this.jdField_a_of_type_Avzh == null) {
      this.jdField_a_of_type_Avzh = new avzh(this);
    }
    return this.jdField_a_of_type_Avzh;
  }
  
  public void a(avzi paramavzi)
  {
    if (paramavzi == null) {
      return;
    }
    Iterator localIterator = this.Fi.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      if (localObject != null)
      {
        localObject = (avzi)((WeakReference)localObject).get();
        if (localObject == null) {
          localIterator.remove();
        } else if (localObject == paramavzi) {
          return;
        }
      }
    }
    this.Fi.add(new WeakReference(paramavzi));
  }
  
  public void b(avzi paramavzi)
  {
    if (paramavzi == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.Fi.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        if (localObject != null)
        {
          localObject = (avzi)((WeakReference)localObject).get();
          if (localObject == null) {
            localIterator.remove();
          } else if (localObject == paramavzi) {
            localIterator.remove();
          }
        }
      }
    }
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RemoteHandleManager", 2, "----destroy----");
    }
    if (this.serviceProxy != null) {
      this.serviceProxy.unbindBaseService();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avzf
 * JD-Core Version:    0.7.0.1
 */