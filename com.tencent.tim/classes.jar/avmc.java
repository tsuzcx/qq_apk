import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qqreader.QRPluginManagerClient.1;
import cooperation.qqreader.QRPluginManagerClient.2;
import cooperation.qqreader.proxy.ReaderInterfacePluginBuilder;
import cooperation.qqreader.proxy.ReaderInterfacePluginProxy;
import cooperation.qqreader.proxy.ReaderJsCallback;
import cooperation.qqreader.proxy.ReaderJsPluginBuilder;
import cooperation.qqreader.proxy.ReaderJsPluginProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class avmc
{
  private static avmc jdField_a_of_type_Avmc;
  private ReaderInterfacePluginBuilder jdField_a_of_type_CooperationQqreaderProxyReaderInterfacePluginBuilder;
  private ReaderJsPluginBuilder jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginBuilder;
  private long azF;
  private volatile boolean dns;
  private List<WeakReference<avmc.a>> mListenerList = new ArrayList();
  
  public static avmc a()
  {
    
    if (jdField_a_of_type_Avmc == null) {}
    try
    {
      if (jdField_a_of_type_Avmc == null) {
        jdField_a_of_type_Avmc = new avmc();
      }
      return jdField_a_of_type_Avmc;
    }
    finally {}
  }
  
  private void b(avmc.a parama)
  {
    if (parama == null) {
      return;
    }
    try
    {
      Iterator localIterator = this.mListenerList.iterator();
      avmc.a locala;
      do
      {
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label68;
          }
          locala = (avmc.a)((WeakReference)localIterator.next()).get();
          if (locala != null) {
            break;
          }
          localIterator.remove();
        }
      } while (locala != parama);
    }
    finally {}
    return;
    label68:
    this.mListenerList.add(new WeakReference(parama));
  }
  
  private void c(avmc.a parama)
  {
    if (parama == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new QRPluginManagerClient.2(this, parama));
  }
  
  private void eAG()
  {
    avoc.u("QRPluginManagerClient", "dispatchPluginReadyEvent");
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator2 = this.mListenerList.iterator();
      while (localIterator2.hasNext())
      {
        avmc.a locala = (avmc.a)((WeakReference)localIterator2.next()).get();
        if (locala != null) {
          localArrayList.add(locala);
        }
      }
      this.mListenerList.clear();
    }
    finally {}
    Iterator localIterator1 = localObject.iterator();
    while (localIterator1.hasNext()) {
      c((avmc.a)localIterator1.next());
    }
  }
  
  private static void eAH()
  {
    if (BaseApplicationImpl.sProcessId != 7) {
      avoc.e("QRPluginManagerClient", "checkToolProcess: QRPluginManagerClient的逻辑必须在Tool进程调用");
    }
  }
  
  public void WF(boolean paramBoolean)
  {
    this.dns = paramBoolean;
    if (this.dns) {
      eAG();
    }
  }
  
  @Nullable
  public ReaderInterfacePluginProxy a()
  {
    if (this.jdField_a_of_type_CooperationQqreaderProxyReaderInterfacePluginBuilder == null) {
      return null;
    }
    return this.jdField_a_of_type_CooperationQqreaderProxyReaderInterfacePluginBuilder.create();
  }
  
  @Nullable
  public ReaderJsPluginProxy a(ReaderJsCallback paramReaderJsCallback)
  {
    if (this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginBuilder == null) {
      return null;
    }
    return this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginBuilder.create(paramReaderJsCallback);
  }
  
  public void a(avmc.a parama)
  {
    if (aKJ()) {
      c(parama);
    }
    do
    {
      return;
      b(parama);
    } while (System.currentTimeMillis() - this.azF < 3000L);
    this.azF = System.currentTimeMillis();
    if (avno.aKN())
    {
      avno.gr(BaseApplicationImpl.getApplication());
      return;
    }
    ThreadManager.getSubThreadHandler().post(new QRPluginManagerClient.1(this));
  }
  
  public void a(ReaderJsPluginBuilder paramReaderJsPluginBuilder, ReaderInterfacePluginBuilder paramReaderInterfacePluginBuilder)
  {
    this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginBuilder = paramReaderJsPluginBuilder;
    this.jdField_a_of_type_CooperationQqreaderProxyReaderInterfacePluginBuilder = paramReaderInterfacePluginBuilder;
  }
  
  public boolean aKJ()
  {
    return this.dns;
  }
  
  public void d(Context paramContext, Intent paramIntent, String paramString)
  {
    if (!aKJ())
    {
      avoc.e("QRPluginManagerClient", "startPluginActivityWhenReady: plugin is not ready");
      return;
    }
    if (avno.aKN())
    {
      avno.e(paramContext, paramIntent, paramString);
      return;
    }
    avlw.jumpToPlugin(paramContext, paramIntent, paramString);
  }
  
  public void elN()
  {
    a(null);
  }
  
  public static abstract interface a
  {
    public abstract void eAI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avmc
 * JD-Core Version:    0.7.0.1
 */