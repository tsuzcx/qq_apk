package com.tencent.token;

import android.text.TextUtils;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.halley.downloader.c.d.a;
import com.tencent.halley.downloader.c.d.a.a;
import com.tencent.halley.downloader.exceptions.DownloaderAddTaskException;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public final class mp
  implements mm
{
  public final mn a(String paramString1, String paramString2, String paramString3, String paramString4, mo parammo)
  {
    String str1 = "";
    if (TextUtils.isEmpty(paramString2)) {
      str1 = "url is empty.";
    } else if (parammo == null) {
      str1 = "listener is null.";
    }
    String str2 = paramString3;
    if (ml.a(paramString3)) {
      str2 = ls.g();
    }
    if ("".equals(str1))
    {
      paramString2 = new ne(paramString2);
      if (!TextUtils.isEmpty(null))
      {
        paramString2.c = new a(null, a.a.g);
        paramString2.c.c = paramString2.e.getAndIncrement();
      }
      return new nf(paramString1, paramString2, str2, paramString4, parammo);
    }
    throw new DownloaderAddTaskException(str1);
  }
  
  /* Error */
  public final void a(mn parammn)
  {
    // Byte code:
    //   0: invokestatic 89	com/tencent/token/ms:b	()Lcom/tencent/token/ms;
    //   3: astore 4
    //   5: ldc 15
    //   7: astore_3
    //   8: aload_1
    //   9: ifnull +290 -> 299
    //   12: aload_1
    //   13: instanceof 76
    //   16: ifne +6 -> 22
    //   19: goto +280 -> 299
    //   22: aload_1
    //   23: checkcast 76	com/tencent/token/nf
    //   26: astore 5
    //   28: aload 4
    //   30: monitorenter
    //   31: aload 5
    //   33: getfield 93	com/tencent/token/nf:k	Ljava/lang/String;
    //   36: invokestatic 30	com/tencent/token/ml:a	(Ljava/lang/String;)Z
    //   39: ifeq +10 -> 49
    //   42: aload 5
    //   44: ldc 15
    //   46: putfield 93	com/tencent/token/nf:k	Ljava/lang/String;
    //   49: aload_3
    //   50: astore_2
    //   51: aload 5
    //   53: getfield 93	com/tencent/token/nf:k	Ljava/lang/String;
    //   56: invokestatic 95	com/tencent/token/ls:c	(Ljava/lang/String;)Z
    //   59: ifeq +157 -> 216
    //   62: aload 4
    //   64: invokevirtual 99	com/tencent/token/ms:d	()Ljava/util/List;
    //   67: invokeinterface 105 1 0
    //   72: astore_2
    //   73: aload_3
    //   74: astore_1
    //   75: aload_2
    //   76: invokeinterface 111 1 0
    //   81: ifeq +118 -> 199
    //   84: aload_2
    //   85: invokeinterface 115 1 0
    //   90: checkcast 117	com/tencent/token/mn
    //   93: astore_1
    //   94: aload 5
    //   96: getfield 120	com/tencent/token/nf:j	Ljava/lang/String;
    //   99: aload_1
    //   100: invokeinterface 123 1 0
    //   105: invokevirtual 126	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   108: ifeq -35 -> 73
    //   111: aload 5
    //   113: getfield 93	com/tencent/token/nf:k	Ljava/lang/String;
    //   116: astore 6
    //   118: aload_1
    //   119: checkcast 76	com/tencent/token/nf
    //   122: getfield 93	com/tencent/token/nf:k	Ljava/lang/String;
    //   125: invokestatic 95	com/tencent/token/ls:c	(Ljava/lang/String;)Z
    //   128: ifeq +13 -> 141
    //   131: aload_1
    //   132: invokeinterface 129 1 0
    //   137: astore_1
    //   138: goto +10 -> 148
    //   141: aload_1
    //   142: invokeinterface 131 1 0
    //   147: astore_1
    //   148: aload 6
    //   150: aload_1
    //   151: invokevirtual 126	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   154: ifeq -81 -> 73
    //   157: new 133	java/lang/StringBuilder
    //   160: dup
    //   161: ldc 135
    //   163: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   166: astore_1
    //   167: aload_1
    //   168: aload 5
    //   170: getfield 120	com/tencent/token/nf:j	Ljava/lang/String;
    //   173: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_1
    //   178: ldc 142
    //   180: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_1
    //   185: aload 5
    //   187: getfield 93	com/tencent/token/nf:k	Ljava/lang/String;
    //   190: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload_1
    //   195: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: astore_1
    //   199: aload_1
    //   200: astore_2
    //   201: ldc 15
    //   203: aload_1
    //   204: invokevirtual 42	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   207: ifne +9 -> 216
    //   210: aload 4
    //   212: monitorexit
    //   213: goto +89 -> 302
    //   216: aload 4
    //   218: getfield 148	com/tencent/token/ms:a	Ljava/util/Vector;
    //   221: astore_1
    //   222: aload_1
    //   223: monitorenter
    //   224: aload 4
    //   226: getfield 148	com/tencent/token/ms:a	Ljava/util/Vector;
    //   229: aload 5
    //   231: invokevirtual 153	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   234: pop
    //   235: aload_1
    //   236: monitorexit
    //   237: aload 5
    //   239: invokevirtual 156	com/tencent/token/nf:r	()V
    //   242: aload_2
    //   243: astore_1
    //   244: goto -34 -> 210
    //   247: astore_1
    //   248: goto +38 -> 286
    //   251: astore_1
    //   252: aload_1
    //   253: invokevirtual 159	com/tencent/halley/downloader/exceptions/DownloaderAddTaskException:getLocalizedMessage	()Ljava/lang/String;
    //   256: astore_1
    //   257: aload 4
    //   259: getfield 148	com/tencent/token/ms:a	Ljava/util/Vector;
    //   262: astore_2
    //   263: aload_2
    //   264: monitorenter
    //   265: aload 4
    //   267: getfield 148	com/tencent/token/ms:a	Ljava/util/Vector;
    //   270: aload 5
    //   272: invokevirtual 162	java/util/Vector:remove	(Ljava/lang/Object;)Z
    //   275: pop
    //   276: aload_2
    //   277: monitorexit
    //   278: goto -68 -> 210
    //   281: astore_1
    //   282: aload_2
    //   283: monitorexit
    //   284: aload_1
    //   285: athrow
    //   286: aload_1
    //   287: athrow
    //   288: astore_2
    //   289: aload_1
    //   290: monitorexit
    //   291: aload_2
    //   292: athrow
    //   293: astore_1
    //   294: aload 4
    //   296: monitorexit
    //   297: aload_1
    //   298: athrow
    //   299: ldc 164
    //   301: astore_1
    //   302: ldc 15
    //   304: aload_1
    //   305: invokevirtual 42	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   308: ifeq +4 -> 312
    //   311: return
    //   312: new 81	com/tencent/halley/downloader/exceptions/DownloaderAddTaskException
    //   315: dup
    //   316: aload_1
    //   317: invokespecial 82	com/tencent/halley/downloader/exceptions/DownloaderAddTaskException:<init>	(Ljava/lang/String;)V
    //   320: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	mp
    //   0	321	1	parammn	mn
    //   288	4	2	localObject2	Object
    //   7	67	3	str1	String
    //   3	292	4	localms	ms
    //   26	245	5	localnf	nf
    //   116	33	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   237	242	247	finally
    //   252	265	247	finally
    //   282	286	247	finally
    //   237	242	251	com/tencent/halley/downloader/exceptions/DownloaderAddTaskException
    //   265	278	281	finally
    //   224	237	288	finally
    //   31	49	293	finally
    //   51	73	293	finally
    //   75	138	293	finally
    //   141	148	293	finally
    //   148	199	293	finally
    //   201	210	293	finally
    //   210	213	293	finally
    //   216	224	293	finally
    //   286	288	293	finally
    //   289	293	293	finally
  }
  
  public final void b(mn parammn)
  {
    ms localms = ms.b();
    if (parammn != null)
    {
      ??? = new StringBuilder("delete task:");
      ((StringBuilder)???).append(parammn.c());
      mc.b("TaskManager", ((StringBuilder)???).toString());
      nf localnf = (nf)parammn;
      if (!localnf.u())
      {
        if (!localnf.t())
        {
          localnf.q();
          localnf.o();
          if (localnf.e) {
            localnf.p();
          }
        }
        localnf.D = true;
        localnf.a(true, 0, "", DownloaderTaskStatus.DELETED);
      }
      synchronized (localms.a)
      {
        localms.a.remove(parammn);
        localms.a(localnf, 3);
        if (localms.e())
        {
          localms.b.a();
          return;
        }
        localms.b.b();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.mp
 * JD-Core Version:    0.7.0.1
 */