package com.tencent.moai.proxycat.transport;

import android.util.Log;
import com.tencent.moai.proxycat.selectable.Acceptable;
import com.tencent.moai.proxycat.selectable.Connectable;
import com.tencent.moai.proxycat.selectable.Readable;
import com.tencent.moai.proxycat.selectable.Writable;
import com.tencent.moai.proxycat.util.Logger;
import java.io.IOException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class ProxySelector
  implements Runnable
{
  private static final String TAG = "ProxySelector";
  private final Selector selector = Selector.open();
  private final Thread thread = new Thread(this, "ProxySelectorThread");
  
  public ProxySelector()
    throws IOException
  {}
  
  public void close()
    throws IOException
  {
    this.selector.close();
  }
  
  /* Error */
  public <P extends Proxy> P create(java.lang.Class<P> paramClass)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 54	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   4: checkcast 56	com/tencent/moai/proxycat/transport/Proxy
    //   7: astore_1
    //   8: aload_1
    //   9: aload_0
    //   10: getfield 28	com/tencent/moai/proxycat/transport/ProxySelector:selector	Ljava/nio/channels/Selector;
    //   13: invokevirtual 60	com/tencent/moai/proxycat/transport/Proxy:start	(Ljava/nio/channels/Selector;)V
    //   16: aload_1
    //   17: areturn
    //   18: astore_2
    //   19: aconst_null
    //   20: astore_1
    //   21: aload_2
    //   22: invokevirtual 63	java/lang/InstantiationException:printStackTrace	()V
    //   25: aload_1
    //   26: areturn
    //   27: astore_2
    //   28: aconst_null
    //   29: astore_1
    //   30: aload_2
    //   31: invokevirtual 64	java/lang/IllegalAccessException:printStackTrace	()V
    //   34: aload_1
    //   35: areturn
    //   36: astore_2
    //   37: goto -7 -> 30
    //   40: astore_2
    //   41: goto -20 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	ProxySelector
    //   0	44	1	paramClass	java.lang.Class<P>
    //   18	4	2	localInstantiationException1	java.lang.InstantiationException
    //   27	4	2	localIllegalAccessException1	java.lang.IllegalAccessException
    //   36	1	2	localIllegalAccessException2	java.lang.IllegalAccessException
    //   40	1	2	localInstantiationException2	java.lang.InstantiationException
    // Exception table:
    //   from	to	target	type
    //   0	8	18	java/lang/InstantiationException
    //   0	8	27	java/lang/IllegalAccessException
    //   8	16	36	java/lang/IllegalAccessException
    //   8	16	40	java/lang/InstantiationException
  }
  
  public boolean isRunning()
  {
    return this.thread.isAlive();
  }
  
  public void run()
  {
    Logger.i("ProxySelector", "ProxySelector start");
    try
    {
      this.selector.select();
      Iterator localIterator = this.selector.selectedKeys().iterator();
      while (localIterator.hasNext())
      {
        localSelectionKey = (SelectionKey)localIterator.next();
        localIterator.remove();
        if (localSelectionKey.isValid())
        {
          if (!localSelectionKey.isAcceptable()) {
            break label101;
          }
          ((Acceptable)localSelectionKey.attachment()).onAcceptable(localSelectionKey);
        }
      }
    }
    catch (ClosedSelectorException localClosedSelectorException)
    {
      for (;;)
      {
        Logger.e("ProxySelector", Log.getStackTraceString(localClosedSelectorException));
        Logger.i("ProxySelector", "ProxySelector closed");
        return;
        if (!localSelectionKey.isConnectable()) {
          break;
        }
        ((Connectable)localSelectionKey.attachment()).onConnectible(localSelectionKey);
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        SelectionKey localSelectionKey;
        label101:
        Logger.e("ProxySelector", Log.getStackTraceString(localIOException));
        continue;
        if (localSelectionKey.isReadable()) {
          ((Readable)localSelectionKey.attachment()).onReadable(localSelectionKey);
        } else if (localSelectionKey.isWritable()) {
          ((Writable)localSelectionKey.attachment()).onWritable(localSelectionKey);
        }
      }
    }
  }
  
  public void start()
  {
    this.thread.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.transport.ProxySelector
 * JD-Core Version:    0.7.0.1
 */