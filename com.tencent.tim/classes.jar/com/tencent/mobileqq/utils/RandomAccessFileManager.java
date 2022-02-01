package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RandomAccessFileManager
{
  private static RandomAccessFileManager a = new RandomAccessFileManager();
  private byte[] gH = new byte[0];
  private byte[] gI = new byte[0];
  private Runnable hR;
  private Map<String, a> nP = new HashMap();
  private Map<String, a> oh = new HashMap();
  
  private a a(String paramString, Map<String, a> paramMap)
  {
    paramMap = (a)paramMap.get(paramString);
    int i;
    if (paramMap != null)
    {
      paramString = paramMap;
      if (paramString.threadId == Thread.currentThread().getId()) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        return paramString;
        a locala = paramString.a;
        paramString = locala;
        if (locala != paramMap) {
          break;
        }
        paramString = locala;
        i = 0;
        continue;
      }
      return null;
      i = 0;
      paramString = paramMap;
    }
  }
  
  public static RandomAccessFileManager a()
  {
    try
    {
      RandomAccessFileManager localRandomAccessFileManager = a;
      return localRandomAccessFileManager;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(a parama1, a parama2, String paramString, Map<String, a> paramMap)
  {
    if (parama1 == null) {
      parama1 = (a)paramMap.get(paramString);
    }
    for (;;)
    {
      if ((parama1 == null) || (parama2 == null)) {
        return;
      }
      if (parama2 == parama1)
      {
        if ((parama1.a != parama1) && (parama1.a != null)) {
          break label87;
        }
        paramMap.remove(paramString);
      }
      for (;;)
      {
        parama2.b.a = parama2.a;
        parama2.a.b = parama2.b;
        parama2.a = null;
        parama2.b = null;
        return;
        label87:
        paramMap.put(paramString, parama1.a);
      }
    }
  }
  
  private void a(a parama, String paramString, Map<String, a> paramMap)
  {
    a locala = (a)paramMap.get(paramString);
    if (parama == null) {
      return;
    }
    if (locala == null)
    {
      parama.b = parama;
      parama.a = parama;
      paramMap.put(paramString, parama);
      return;
    }
    parama.a = locala;
    parama.b = locala.b;
    locala.b.a = parama;
    locala.b = parama;
  }
  
  private void a(String arg1, a parama)
  {
    parama.acc = System.currentTimeMillis();
    synchronized (this.gH)
    {
      a(parama, ???, this.oh);
    }
    synchronized (this.gI)
    {
      if (this.hR == null)
      {
        this.hR = new CloseThread();
        ThreadManager.post(this.hR, 8, null, false);
      }
      return;
      ??? = finally;
      throw ???;
    }
  }
  
  public void UU(String paramString)
  {
    try
    {
      a locala = a(paramString, this.nP);
      if (locala != null)
      {
        locala.dZP -= 1;
        if (locala.dZP == 0)
        {
          a(null, locala, paramString, this.nP);
          a(paramString, locala);
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public RandomAccessFile a(String paramString)
    throws java.io.FileNotFoundException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: aload_0
    //   5: getfield 34	com/tencent/mobileqq/utils/RandomAccessFileManager:nP	Ljava/util/Map;
    //   8: invokespecial 113	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;Ljava/util/Map;)Lcom/tencent/mobileqq/utils/RandomAccessFileManager$a;
    //   11: astore_3
    //   12: aload_3
    //   13: astore_2
    //   14: aload_3
    //   15: ifnonnull +55 -> 70
    //   18: aload_0
    //   19: getfield 38	com/tencent/mobileqq/utils/RandomAccessFileManager:gH	[B
    //   22: astore_2
    //   23: aload_2
    //   24: monitorenter
    //   25: aload_0
    //   26: aload_1
    //   27: aload_0
    //   28: getfield 36	com/tencent/mobileqq/utils/RandomAccessFileManager:oh	Ljava/util/Map;
    //   31: invokespecial 113	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;Ljava/util/Map;)Lcom/tencent/mobileqq/utils/RandomAccessFileManager$a;
    //   34: astore_3
    //   35: aload_3
    //   36: ifnull +14 -> 50
    //   39: aload_0
    //   40: aconst_null
    //   41: aload_3
    //   42: aload_1
    //   43: aload_0
    //   44: getfield 36	com/tencent/mobileqq/utils/RandomAccessFileManager:oh	Ljava/util/Map;
    //   47: invokespecial 88	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Lcom/tencent/mobileqq/utils/RandomAccessFileManager$a;Lcom/tencent/mobileqq/utils/RandomAccessFileManager$a;Ljava/lang/String;Ljava/util/Map;)V
    //   50: aload_2
    //   51: monitorexit
    //   52: aload_3
    //   53: astore_2
    //   54: aload_3
    //   55: ifnull +15 -> 70
    //   58: aload_0
    //   59: aload_3
    //   60: aload_1
    //   61: aload_0
    //   62: getfield 34	com/tencent/mobileqq/utils/RandomAccessFileManager:nP	Ljava/util/Map;
    //   65: invokespecial 99	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Lcom/tencent/mobileqq/utils/RandomAccessFileManager$a;Ljava/lang/String;Ljava/util/Map;)V
    //   68: aload_3
    //   69: astore_2
    //   70: aload_2
    //   71: astore_3
    //   72: aload_2
    //   73: ifnonnull +85 -> 158
    //   76: new 9	com/tencent/mobileqq/utils/RandomAccessFileManager$a
    //   79: dup
    //   80: aload_0
    //   81: invokespecial 123	com/tencent/mobileqq/utils/RandomAccessFileManager$a:<init>	(Lcom/tencent/mobileqq/utils/RandomAccessFileManager;)V
    //   84: astore_3
    //   85: aload_3
    //   86: new 125	java/io/RandomAccessFile
    //   89: dup
    //   90: aload_1
    //   91: ldc 127
    //   93: invokespecial 130	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: putfield 134	com/tencent/mobileqq/utils/RandomAccessFileManager$a:file	Ljava/io/RandomAccessFile;
    //   99: aload_3
    //   100: invokestatic 57	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   103: invokevirtual 61	java/lang/Thread:getId	()J
    //   106: putfield 51	com/tencent/mobileqq/utils/RandomAccessFileManager$a:threadId	J
    //   109: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +36 -> 148
    //   115: ldc 142
    //   117: iconst_2
    //   118: invokestatic 147	wja:b	()Ljava/lang/StringBuilder;
    //   121: ldc 149
    //   123: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_1
    //   127: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc 157
    //   132: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_3
    //   136: getfield 51	com/tencent/mobileqq/utils/RandomAccessFileManager$a:threadId	J
    //   139: invokevirtual 160	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   142: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: aload_0
    //   149: aload_3
    //   150: aload_1
    //   151: aload_0
    //   152: getfield 34	com/tencent/mobileqq/utils/RandomAccessFileManager:nP	Ljava/util/Map;
    //   155: invokespecial 99	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Lcom/tencent/mobileqq/utils/RandomAccessFileManager$a;Ljava/lang/String;Ljava/util/Map;)V
    //   158: aload_3
    //   159: aload_3
    //   160: getfield 117	com/tencent/mobileqq/utils/RandomAccessFileManager$a:dZP	I
    //   163: iconst_1
    //   164: iadd
    //   165: putfield 117	com/tencent/mobileqq/utils/RandomAccessFileManager$a:dZP	I
    //   168: aload_3
    //   169: getfield 134	com/tencent/mobileqq/utils/RandomAccessFileManager$a:file	Ljava/io/RandomAccessFile;
    //   172: astore_1
    //   173: aload_0
    //   174: monitorexit
    //   175: aload_1
    //   176: areturn
    //   177: astore_1
    //   178: aload_2
    //   179: monitorexit
    //   180: aload_1
    //   181: athrow
    //   182: astore_1
    //   183: aload_0
    //   184: monitorexit
    //   185: aload_1
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	RandomAccessFileManager
    //   0	187	1	paramString	String
    //   11	158	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   25	35	177	finally
    //   39	50	177	finally
    //   50	52	177	finally
    //   178	180	177	finally
    //   2	12	182	finally
    //   18	25	182	finally
    //   58	68	182	finally
    //   76	148	182	finally
    //   148	158	182	finally
    //   158	173	182	finally
    //   180	182	182	finally
  }
  
  class CloseThread
    implements Runnable
  {
    CloseThread() {}
    
    public void run()
    {
      try
      {
        for (;;)
        {
          Thread.sleep(1000L);
          synchronized (RandomAccessFileManager.a(RandomAccessFileManager.this))
          {
            if (!RandomAccessFileManager.a(RandomAccessFileManager.this).isEmpty()) {}
          }
          Object localObject3;
          synchronized (RandomAccessFileManager.b(RandomAccessFileManager.this))
          {
            RandomAccessFileManager.a(RandomAccessFileManager.this, null);
            return;
            String[] arrayOfString = new String[RandomAccessFileManager.a(RandomAccessFileManager.this).size()];
            ??? = RandomAccessFileManager.a(RandomAccessFileManager.this).keySet().iterator();
            int i = 0;
            while (((Iterator)???).hasNext())
            {
              arrayOfString[i] = ((String)((Iterator)???).next());
              i += 1;
            }
            if (j < i)
            {
              locala2 = (RandomAccessFileManager.a)RandomAccessFileManager.a(RandomAccessFileManager.this).get(arrayOfString[j]);
              RandomAccessFileManager.a locala1;
              for (??? = locala2.b;; localObject3 = locala1)
              {
                locala1 = ((RandomAccessFileManager.a)???).b;
                if (((RandomAccessFileManager.a)???).dZP != 0) {
                  break;
                }
                long l1 = System.currentTimeMillis();
                long l2 = ((RandomAccessFileManager.a)???).acc;
                if (l1 - l2 <= 1000L) {
                  break;
                }
                try
                {
                  ((RandomAccessFileManager.a)???).file.close();
                  if (QLog.isColorLevel()) {
                    QLog.d("AppleMojiHandler", 2, "file " + arrayOfString[j] + "[" + ((RandomAccessFileManager.a)???).threadId + "]" + " close by Thread:" + Thread.currentThread().getId());
                  }
                  RandomAccessFileManager.a(RandomAccessFileManager.this, locala2, (RandomAccessFileManager.a)???, arrayOfString[j], RandomAccessFileManager.a(RandomAccessFileManager.this));
                }
                catch (IOException localIOException)
                {
                  for (;;)
                  {
                    localIOException.printStackTrace();
                  }
                }
                localObject2 = finally;
                throw localObject2;
              }
            }
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          RandomAccessFileManager.a locala2;
          continue;
          int j = 0;
          continue;
          if (locala2 == localInterruptedException) {
            j += 1;
          }
        }
      }
    }
  }
  
  class a
  {
    public a a;
    public long acc;
    public a b;
    public volatile int dZP;
    public RandomAccessFile file;
    public long threadId;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.RandomAccessFileManager
 * JD-Core Version:    0.7.0.1
 */