package com.tencent.token.core.protocolcenter;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.tencent.token.by;
import com.tencent.token.do;
import com.tencent.token.dp;
import com.tencent.token.upload.useraction.a;
import com.tencent.token.utils.l;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class e
{
  private ExecutorService a = Executors.newFixedThreadPool(5);
  private b b = new b("");
  private a c = new a()
  {
    public void a(do paramAnonymousdo)
    {
      MotionEvent localMotionEvent = a.a().b();
      if (localMotionEvent != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cginame:");
        localStringBuilder.append(paramAnonymousdo.a);
        com.tencent.token.global.g.c(localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pagename:");
        localStringBuilder.append(paramAnonymousdo.i);
        com.tencent.token.global.g.c(localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getRawX:");
        localStringBuilder.append(localMotionEvent.getRawX());
        com.tencent.token.global.g.c(localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getRawY:");
        localStringBuilder.append(localMotionEvent.getRawY());
        com.tencent.token.global.g.c(localStringBuilder.toString());
        long l = System.currentTimeMillis() - (SystemClock.uptimeMillis() - localMotionEvent.getDownTime());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("eventStartTime:");
        localStringBuilder.append(l);
        com.tencent.token.global.g.c(localStringBuilder.toString());
        int i = a.a().c();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("touch_type:");
        localStringBuilder.append(i);
        com.tencent.token.global.g.c(localStringBuilder.toString());
        a.a().a(i, paramAnonymousdo.a, paramAnonymousdo.i, "", "", "", (int)localMotionEvent.getRawX(), (int)localMotionEvent.getRawY(), l);
        a.a().d();
      }
    }
    
    public void a(do paramAnonymousdo, com.tencent.token.global.e paramAnonymouse)
    {
      if (paramAnonymouse.b())
      {
        by.a().a(System.currentTimeMillis(), 0, paramAnonymousdo.a, 0, "", l.k());
        if ((!paramAnonymousdo.e) && (paramAnonymousdo.d != null))
        {
          paramAnonymouse = paramAnonymousdo.d.obtainMessage(paramAnonymousdo.f);
          paramAnonymouse.arg1 = 0;
          paramAnonymouse.sendToTarget();
          paramAnonymousdo.e = true;
        }
      }
      else
      {
        if (paramAnonymouse.a < 10000) {
          by.a().a(System.currentTimeMillis(), 0, paramAnonymousdo.a, 0, "", l.k());
        } else {
          by.a().a(System.currentTimeMillis(), by.a(paramAnonymouse.a), paramAnonymousdo.a, 1, paramAnonymouse.b, l.k());
        }
        if ((!paramAnonymousdo.e) && (paramAnonymousdo.d != null))
        {
          Message localMessage = paramAnonymousdo.d.obtainMessage(paramAnonymousdo.f);
          localMessage.arg1 = paramAnonymouse.a;
          localMessage.obj = paramAnonymouse;
          localMessage.sendToTarget();
          paramAnonymousdo.e = true;
        }
      }
      e.a(e.this).b(paramAnonymousdo);
    }
  };
  
  public int a(do paramdo)
  {
    paramdo.l = this.c;
    this.b.a(paramdo);
    return 0;
  }
  
  public int a(String paramString)
  {
    this.b.a(paramString);
    return 0;
  }
  
  public dp b(do paramdo)
  {
    d locald = b.a(paramdo.a);
    if (locald == null) {
      return null;
    }
    return locald.d(paramdo);
  }
  
  public static abstract interface a
  {
    public abstract void a(do paramdo);
    
    public abstract void a(do paramdo, com.tencent.token.global.e parame);
  }
  
  class b
    extends HandlerThread
  {
    private Handler b = new Handler();
    private Map<do, Future<com.tencent.token.global.e>> c = Collections.synchronizedMap(new HashMap());
    
    public b(String paramString)
    {
      super();
    }
    
    public void a(final do paramdo)
    {
      paramdo.l.a(paramdo);
      this.b.post(new Runnable()
      {
        public void run()
        {
          Object localObject;
          switch (paramdo.b)
          {
          default: 
            localObject = null;
            break;
          case 3: 
            localObject = c.a(paramdo);
            break;
          case 2: 
            localObject = g.a(paramdo);
            break;
          case 1: 
            localObject = h.a(paramdo);
          }
          if (localObject != null)
          {
            localObject = e.b(e.this).submit((Callable)localObject);
            e.b.a(e.b.this).put(paramdo, localObject);
          }
        }
      });
      this.b.postDelayed(new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 20	com/tencent/token/core/protocolcenter/e$b$2:b	Lcom/tencent/token/core/protocolcenter/e$b;
          //   4: invokestatic 38	com/tencent/token/core/protocolcenter/e$b:a	(Lcom/tencent/token/core/protocolcenter/e$b;)Ljava/util/Map;
          //   7: aload_0
          //   8: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   11: invokeinterface 44 2 0
          //   16: checkcast 46	java/util/concurrent/Future
          //   19: astore_2
          //   20: aload_2
          //   21: ifnonnull +4 -> 25
          //   24: return
          //   25: aload_2
          //   26: iconst_1
          //   27: invokeinterface 50 2 0
          //   32: pop
          //   33: new 52	com/tencent/token/global/e
          //   36: dup
          //   37: invokespecial 53	com/tencent/token/global/e:<init>	()V
          //   40: astore_1
          //   41: aload_2
          //   42: invokeinterface 57 1 0
          //   47: checkcast 52	com/tencent/token/global/e
          //   50: astore_2
          //   51: aload_0
          //   52: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   55: getfield 63	com/tencent/token/do:e	Z
          //   58: ifne +520 -> 578
          //   61: aload_0
          //   62: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   65: getfield 67	com/tencent/token/do:d	Landroid/os/Handler;
          //   68: ifnonnull +4 -> 72
          //   71: return
          //   72: aload_0
          //   73: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   76: getfield 67	com/tencent/token/do:d	Landroid/os/Handler;
          //   79: aload_0
          //   80: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   83: getfield 71	com/tencent/token/do:f	I
          //   86: invokevirtual 77	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
          //   89: astore_1
          //   90: aload_1
          //   91: aload_2
          //   92: getfield 79	com/tencent/token/global/e:a	I
          //   95: putfield 84	android/os/Message:arg1	I
          //   98: aload_1
          //   99: aload_2
          //   100: putfield 88	android/os/Message:obj	Ljava/lang/Object;
          //   103: aload_1
          //   104: invokevirtual 91	android/os/Message:sendToTarget	()V
          //   107: aload_0
          //   108: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   111: iconst_1
          //   112: putfield 63	com/tencent/token/do:e	Z
          //   115: return
          //   116: astore_2
          //   117: goto +462 -> 579
          //   120: astore_2
          //   121: new 93	java/lang/StringBuilder
          //   124: dup
          //   125: invokespecial 94	java/lang/StringBuilder:<init>	()V
          //   128: astore_3
          //   129: aload_3
          //   130: ldc 96
          //   132: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   135: pop
          //   136: aload_3
          //   137: aload_0
          //   138: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   141: getfield 104	com/tencent/token/do:i	Ljava/lang/String;
          //   144: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   147: pop
          //   148: aload_3
          //   149: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   152: invokestatic 113	com/tencent/token/global/g:b	(Ljava/lang/String;)V
          //   155: new 93	java/lang/StringBuilder
          //   158: dup
          //   159: invokespecial 94	java/lang/StringBuilder:<init>	()V
          //   162: astore_3
          //   163: aload_3
          //   164: ldc 115
          //   166: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   169: pop
          //   170: aload_3
          //   171: aload_2
          //   172: invokevirtual 116	java/lang/Exception:toString	()Ljava/lang/String;
          //   175: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   178: pop
          //   179: aload_1
          //   180: sipush 10000
          //   183: aload_3
          //   184: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   187: invokevirtual 119	com/tencent/token/global/e:a	(ILjava/lang/String;)V
          //   190: aload_0
          //   191: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   194: getfield 63	com/tencent/token/do:e	Z
          //   197: ifne +381 -> 578
          //   200: aload_0
          //   201: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   204: getfield 67	com/tencent/token/do:d	Landroid/os/Handler;
          //   207: ifnonnull +4 -> 211
          //   210: return
          //   211: aload_0
          //   212: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   215: getfield 67	com/tencent/token/do:d	Landroid/os/Handler;
          //   218: aload_0
          //   219: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   222: getfield 71	com/tencent/token/do:f	I
          //   225: invokevirtual 77	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
          //   228: astore_2
          //   229: aload_2
          //   230: aload_1
          //   231: getfield 79	com/tencent/token/global/e:a	I
          //   234: putfield 84	android/os/Message:arg1	I
          //   237: aload_2
          //   238: aload_1
          //   239: putfield 88	android/os/Message:obj	Ljava/lang/Object;
          //   242: aload_2
          //   243: invokevirtual 91	android/os/Message:sendToTarget	()V
          //   246: goto -139 -> 107
          //   249: new 93	java/lang/StringBuilder
          //   252: dup
          //   253: invokespecial 94	java/lang/StringBuilder:<init>	()V
          //   256: astore_2
          //   257: aload_2
          //   258: ldc 121
          //   260: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   263: pop
          //   264: aload_2
          //   265: aload_0
          //   266: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   269: getfield 104	com/tencent/token/do:i	Ljava/lang/String;
          //   272: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   275: pop
          //   276: aload_2
          //   277: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   280: invokestatic 113	com/tencent/token/global/g:b	(Ljava/lang/String;)V
          //   283: aload_1
          //   284: sipush 200
          //   287: invokevirtual 124	com/tencent/token/global/e:b	(I)V
          //   290: aload_0
          //   291: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   294: getfield 63	com/tencent/token/do:e	Z
          //   297: ifne +281 -> 578
          //   300: aload_0
          //   301: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   304: getfield 67	com/tencent/token/do:d	Landroid/os/Handler;
          //   307: ifnonnull +4 -> 311
          //   310: return
          //   311: aload_0
          //   312: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   315: getfield 67	com/tencent/token/do:d	Landroid/os/Handler;
          //   318: aload_0
          //   319: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   322: getfield 71	com/tencent/token/do:f	I
          //   325: invokevirtual 77	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
          //   328: astore_2
          //   329: aload_2
          //   330: aload_1
          //   331: getfield 79	com/tencent/token/global/e:a	I
          //   334: putfield 84	android/os/Message:arg1	I
          //   337: aload_2
          //   338: aload_1
          //   339: putfield 88	android/os/Message:obj	Ljava/lang/Object;
          //   342: aload_2
          //   343: invokevirtual 91	android/os/Message:sendToTarget	()V
          //   346: goto -239 -> 107
          //   349: astore_2
          //   350: new 93	java/lang/StringBuilder
          //   353: dup
          //   354: invokespecial 94	java/lang/StringBuilder:<init>	()V
          //   357: astore_3
          //   358: aload_3
          //   359: ldc 96
          //   361: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   364: pop
          //   365: aload_3
          //   366: aload_0
          //   367: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   370: getfield 104	com/tencent/token/do:i	Ljava/lang/String;
          //   373: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   376: pop
          //   377: aload_3
          //   378: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   381: invokestatic 113	com/tencent/token/global/g:b	(Ljava/lang/String;)V
          //   384: new 93	java/lang/StringBuilder
          //   387: dup
          //   388: invokespecial 94	java/lang/StringBuilder:<init>	()V
          //   391: astore_3
          //   392: aload_3
          //   393: ldc 115
          //   395: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   398: pop
          //   399: aload_3
          //   400: aload_2
          //   401: invokevirtual 125	java/util/concurrent/ExecutionException:toString	()Ljava/lang/String;
          //   404: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   407: pop
          //   408: aload_1
          //   409: sipush 10000
          //   412: aload_3
          //   413: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   416: invokevirtual 119	com/tencent/token/global/e:a	(ILjava/lang/String;)V
          //   419: aload_0
          //   420: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   423: getfield 63	com/tencent/token/do:e	Z
          //   426: ifne +152 -> 578
          //   429: aload_0
          //   430: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   433: getfield 67	com/tencent/token/do:d	Landroid/os/Handler;
          //   436: ifnonnull +4 -> 440
          //   439: return
          //   440: aload_0
          //   441: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   444: getfield 67	com/tencent/token/do:d	Landroid/os/Handler;
          //   447: aload_0
          //   448: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   451: getfield 71	com/tencent/token/do:f	I
          //   454: invokevirtual 77	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
          //   457: astore_2
          //   458: aload_2
          //   459: aload_1
          //   460: getfield 79	com/tencent/token/global/e:a	I
          //   463: putfield 84	android/os/Message:arg1	I
          //   466: aload_2
          //   467: aload_1
          //   468: putfield 88	android/os/Message:obj	Ljava/lang/Object;
          //   471: aload_2
          //   472: invokevirtual 91	android/os/Message:sendToTarget	()V
          //   475: goto -368 -> 107
          //   478: new 93	java/lang/StringBuilder
          //   481: dup
          //   482: invokespecial 94	java/lang/StringBuilder:<init>	()V
          //   485: astore_2
          //   486: aload_2
          //   487: ldc 127
          //   489: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   492: pop
          //   493: aload_2
          //   494: aload_0
          //   495: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   498: getfield 104	com/tencent/token/do:i	Ljava/lang/String;
          //   501: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   504: pop
          //   505: aload_2
          //   506: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   509: invokestatic 113	com/tencent/token/global/g:b	(Ljava/lang/String;)V
          //   512: aload_1
          //   513: sipush 200
          //   516: invokevirtual 124	com/tencent/token/global/e:b	(I)V
          //   519: aload_0
          //   520: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   523: getfield 63	com/tencent/token/do:e	Z
          //   526: ifne +52 -> 578
          //   529: aload_0
          //   530: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   533: getfield 67	com/tencent/token/do:d	Landroid/os/Handler;
          //   536: ifnonnull +4 -> 540
          //   539: return
          //   540: aload_0
          //   541: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   544: getfield 67	com/tencent/token/do:d	Landroid/os/Handler;
          //   547: aload_0
          //   548: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   551: getfield 71	com/tencent/token/do:f	I
          //   554: invokevirtual 77	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
          //   557: astore_2
          //   558: aload_2
          //   559: aload_1
          //   560: getfield 79	com/tencent/token/global/e:a	I
          //   563: putfield 84	android/os/Message:arg1	I
          //   566: aload_2
          //   567: aload_1
          //   568: putfield 88	android/os/Message:obj	Ljava/lang/Object;
          //   571: aload_2
          //   572: invokevirtual 91	android/os/Message:sendToTarget	()V
          //   575: goto -468 -> 107
          //   578: return
          //   579: aload_0
          //   580: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   583: getfield 63	com/tencent/token/do:e	Z
          //   586: ifne +57 -> 643
          //   589: aload_0
          //   590: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   593: getfield 67	com/tencent/token/do:d	Landroid/os/Handler;
          //   596: ifnonnull +4 -> 600
          //   599: return
          //   600: aload_0
          //   601: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   604: getfield 67	com/tencent/token/do:d	Landroid/os/Handler;
          //   607: aload_0
          //   608: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   611: getfield 71	com/tencent/token/do:f	I
          //   614: invokevirtual 77	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
          //   617: astore_3
          //   618: aload_3
          //   619: aload_1
          //   620: getfield 79	com/tencent/token/global/e:a	I
          //   623: putfield 84	android/os/Message:arg1	I
          //   626: aload_3
          //   627: aload_1
          //   628: putfield 88	android/os/Message:obj	Ljava/lang/Object;
          //   631: aload_3
          //   632: invokevirtual 91	android/os/Message:sendToTarget	()V
          //   635: aload_0
          //   636: getfield 22	com/tencent/token/core/protocolcenter/e$b$2:a	Lcom/tencent/token/do;
          //   639: iconst_1
          //   640: putfield 63	com/tencent/token/do:e	Z
          //   643: aload_2
          //   644: athrow
          //   645: astore_2
          //   646: goto -168 -> 478
          //   649: astore_2
          //   650: goto -401 -> 249
          //   653: astore_1
          //   654: return
          //   655: astore_1
          //   656: goto -13 -> 643
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	659	0	this	2
          //   40	588	1	localObject1	Object
          //   653	1	1	localException1	java.lang.Exception
          //   655	1	1	localException2	java.lang.Exception
          //   19	81	2	localObject2	Object
          //   116	1	2	localObject3	Object
          //   120	52	2	localException3	java.lang.Exception
          //   228	115	2	localObject4	Object
          //   349	52	2	localExecutionException	java.util.concurrent.ExecutionException
          //   457	187	2	localObject5	Object
          //   645	1	2	localInterruptedException	java.lang.InterruptedException
          //   649	1	2	localCancellationException	java.util.concurrent.CancellationException
          //   128	504	3	localObject6	Object
          // Exception table:
          //   from	to	target	type
          //   41	51	116	finally
          //   121	190	116	finally
          //   249	290	116	finally
          //   350	419	116	finally
          //   478	519	116	finally
          //   41	51	120	java/lang/Exception
          //   41	51	349	java/util/concurrent/ExecutionException
          //   41	51	645	java/lang/InterruptedException
          //   41	51	649	java/util/concurrent/CancellationException
          //   51	71	653	java/lang/Exception
          //   72	107	653	java/lang/Exception
          //   107	115	653	java/lang/Exception
          //   190	210	653	java/lang/Exception
          //   211	246	653	java/lang/Exception
          //   290	310	653	java/lang/Exception
          //   311	346	653	java/lang/Exception
          //   419	439	653	java/lang/Exception
          //   440	475	653	java/lang/Exception
          //   519	539	653	java/lang/Exception
          //   540	575	653	java/lang/Exception
          //   579	599	655	java/lang/Exception
          //   600	643	655	java/lang/Exception
        }
      }, paramdo.h);
    }
    
    public void a(final String paramString)
    {
      this.b.post(new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 20	com/tencent/token/core/protocolcenter/e$b$3:b	Lcom/tencent/token/core/protocolcenter/e$b;
          //   4: invokestatic 38	com/tencent/token/core/protocolcenter/e$b:a	(Lcom/tencent/token/core/protocolcenter/e$b;)Ljava/util/Map;
          //   7: invokeinterface 44 1 0
          //   12: invokeinterface 50 1 0
          //   17: astore_2
          //   18: aload_2
          //   19: invokeinterface 56 1 0
          //   24: ifeq +477 -> 501
          //   27: aload_2
          //   28: invokeinterface 60 1 0
          //   33: checkcast 62	java/util/Map$Entry
          //   36: astore_1
          //   37: aload_1
          //   38: invokeinterface 65 1 0
          //   43: checkcast 67	java/util/concurrent/Future
          //   46: astore 4
          //   48: aload_1
          //   49: invokeinterface 70 1 0
          //   54: checkcast 72	com/tencent/token/do
          //   57: astore_1
          //   58: aload_1
          //   59: getfield 75	com/tencent/token/do:i	Ljava/lang/String;
          //   62: ifnull -44 -> 18
          //   65: aload_0
          //   66: getfield 22	com/tencent/token/core/protocolcenter/e$b$3:a	Ljava/lang/String;
          //   69: ifnull -51 -> 18
          //   72: aload_1
          //   73: getfield 75	com/tencent/token/do:i	Ljava/lang/String;
          //   76: aload_0
          //   77: getfield 22	com/tencent/token/core/protocolcenter/e$b$3:a	Ljava/lang/String;
          //   80: invokevirtual 81	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
          //   83: ifne +6 -> 89
          //   86: goto -68 -> 18
          //   89: aload_2
          //   90: invokeinterface 84 1 0
          //   95: aload 4
          //   97: iconst_1
          //   98: invokeinterface 88 2 0
          //   103: pop
          //   104: new 90	com/tencent/token/global/e
          //   107: dup
          //   108: invokespecial 91	com/tencent/token/global/e:<init>	()V
          //   111: astore_3
          //   112: aload 4
          //   114: invokeinterface 94 1 0
          //   119: checkcast 90	com/tencent/token/global/e
          //   122: astore 4
          //   124: aload_1
          //   125: getfield 98	com/tencent/token/do:e	Z
          //   128: ifne -110 -> 18
          //   131: aload_1
          //   132: getfield 102	com/tencent/token/do:d	Landroid/os/Handler;
          //   135: ifnull -117 -> 18
          //   138: aload_1
          //   139: getfield 102	com/tencent/token/do:d	Landroid/os/Handler;
          //   142: sipush 2002
          //   145: invokevirtual 108	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
          //   148: astore_3
          //   149: aload_3
          //   150: aload 4
          //   152: getfield 111	com/tencent/token/global/e:a	I
          //   155: putfield 116	android/os/Message:arg1	I
          //   158: aload_3
          //   159: aload 4
          //   161: putfield 120	android/os/Message:obj	Ljava/lang/Object;
          //   164: aload_3
          //   165: invokevirtual 123	android/os/Message:sendToTarget	()V
          //   168: aload_1
          //   169: iconst_1
          //   170: putfield 98	com/tencent/token/do:e	Z
          //   173: goto -155 -> 18
          //   176: astore_2
          //   177: goto +271 -> 448
          //   180: astore 4
          //   182: new 125	java/lang/StringBuilder
          //   185: dup
          //   186: invokespecial 126	java/lang/StringBuilder:<init>	()V
          //   189: astore 5
          //   191: aload 5
          //   193: ldc 128
          //   195: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   198: pop
          //   199: aload 5
          //   201: aload 4
          //   203: invokevirtual 136	java/lang/Exception:toString	()Ljava/lang/String;
          //   206: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   209: pop
          //   210: aload_3
          //   211: sipush 10000
          //   214: aload 5
          //   216: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   219: invokevirtual 140	com/tencent/token/global/e:a	(ILjava/lang/String;)V
          //   222: aload_1
          //   223: getfield 98	com/tencent/token/do:e	Z
          //   226: ifne -208 -> 18
          //   229: aload_1
          //   230: getfield 102	com/tencent/token/do:d	Landroid/os/Handler;
          //   233: ifnull -215 -> 18
          //   236: goto +118 -> 354
          //   239: new 125	java/lang/StringBuilder
          //   242: dup
          //   243: invokespecial 126	java/lang/StringBuilder:<init>	()V
          //   246: astore 4
          //   248: aload 4
          //   250: ldc 142
          //   252: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   255: pop
          //   256: aload 4
          //   258: aload_1
          //   259: getfield 75	com/tencent/token/do:i	Ljava/lang/String;
          //   262: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   265: pop
          //   266: aload 4
          //   268: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   271: invokestatic 146	com/tencent/token/global/g:b	(Ljava/lang/String;)V
          //   274: aload_3
          //   275: sipush 10024
          //   278: invokevirtual 149	com/tencent/token/global/e:b	(I)V
          //   281: aload_1
          //   282: getfield 98	com/tencent/token/do:e	Z
          //   285: ifne -267 -> 18
          //   288: aload_1
          //   289: getfield 102	com/tencent/token/do:d	Landroid/os/Handler;
          //   292: ifnull -274 -> 18
          //   295: goto +59 -> 354
          //   298: astore 4
          //   300: new 125	java/lang/StringBuilder
          //   303: dup
          //   304: invokespecial 126	java/lang/StringBuilder:<init>	()V
          //   307: astore 5
          //   309: aload 5
          //   311: ldc 128
          //   313: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   316: pop
          //   317: aload 5
          //   319: aload 4
          //   321: invokevirtual 150	java/util/concurrent/ExecutionException:toString	()Ljava/lang/String;
          //   324: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   327: pop
          //   328: aload_3
          //   329: sipush 10000
          //   332: aload 5
          //   334: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   337: invokevirtual 140	com/tencent/token/global/e:a	(ILjava/lang/String;)V
          //   340: aload_1
          //   341: getfield 98	com/tencent/token/do:e	Z
          //   344: ifne -326 -> 18
          //   347: aload_1
          //   348: getfield 102	com/tencent/token/do:d	Landroid/os/Handler;
          //   351: ifnull -333 -> 18
          //   354: aload_1
          //   355: getfield 102	com/tencent/token/do:d	Landroid/os/Handler;
          //   358: sipush 2002
          //   361: invokevirtual 108	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
          //   364: astore 4
          //   366: aload 4
          //   368: aload_3
          //   369: getfield 111	com/tencent/token/global/e:a	I
          //   372: putfield 116	android/os/Message:arg1	I
          //   375: aload 4
          //   377: aload_3
          //   378: putfield 120	android/os/Message:obj	Ljava/lang/Object;
          //   381: aload 4
          //   383: invokevirtual 123	android/os/Message:sendToTarget	()V
          //   386: goto -218 -> 168
          //   389: new 125	java/lang/StringBuilder
          //   392: dup
          //   393: invokespecial 126	java/lang/StringBuilder:<init>	()V
          //   396: astore 4
          //   398: aload 4
          //   400: ldc 152
          //   402: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   405: pop
          //   406: aload 4
          //   408: aload_1
          //   409: getfield 75	com/tencent/token/do:i	Ljava/lang/String;
          //   412: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   415: pop
          //   416: aload 4
          //   418: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   421: invokestatic 146	com/tencent/token/global/g:b	(Ljava/lang/String;)V
          //   424: aload_3
          //   425: sipush 10024
          //   428: invokevirtual 149	com/tencent/token/global/e:b	(I)V
          //   431: aload_1
          //   432: getfield 98	com/tencent/token/do:e	Z
          //   435: ifne -417 -> 18
          //   438: aload_1
          //   439: getfield 102	com/tencent/token/do:d	Landroid/os/Handler;
          //   442: ifnull -424 -> 18
          //   445: goto -91 -> 354
          //   448: aload_1
          //   449: getfield 98	com/tencent/token/do:e	Z
          //   452: ifne +47 -> 499
          //   455: aload_1
          //   456: getfield 102	com/tencent/token/do:d	Landroid/os/Handler;
          //   459: ifnull +40 -> 499
          //   462: aload_1
          //   463: getfield 102	com/tencent/token/do:d	Landroid/os/Handler;
          //   466: sipush 2002
          //   469: invokevirtual 108	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
          //   472: astore 4
          //   474: aload 4
          //   476: aload_3
          //   477: getfield 111	com/tencent/token/global/e:a	I
          //   480: putfield 116	android/os/Message:arg1	I
          //   483: aload 4
          //   485: aload_3
          //   486: putfield 120	android/os/Message:obj	Ljava/lang/Object;
          //   489: aload 4
          //   491: invokevirtual 123	android/os/Message:sendToTarget	()V
          //   494: aload_1
          //   495: iconst_1
          //   496: putfield 98	com/tencent/token/do:e	Z
          //   499: aload_2
          //   500: athrow
          //   501: return
          //   502: astore 4
          //   504: goto -115 -> 389
          //   507: astore 4
          //   509: goto -270 -> 239
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	512	0	this	3
          //   36	459	1	localObject1	Object
          //   17	73	2	localIterator	java.util.Iterator
          //   176	324	2	localObject2	Object
          //   111	375	3	localObject3	Object
          //   46	114	4	localObject4	Object
          //   180	22	4	localException	java.lang.Exception
          //   246	21	4	localStringBuilder1	StringBuilder
          //   298	22	4	localExecutionException	java.util.concurrent.ExecutionException
          //   364	126	4	localObject5	Object
          //   502	1	4	localInterruptedException	java.lang.InterruptedException
          //   507	1	4	localCancellationException	java.util.concurrent.CancellationException
          //   189	144	5	localStringBuilder2	StringBuilder
          // Exception table:
          //   from	to	target	type
          //   112	124	176	finally
          //   182	222	176	finally
          //   239	281	176	finally
          //   300	340	176	finally
          //   389	431	176	finally
          //   112	124	180	java/lang/Exception
          //   112	124	298	java/util/concurrent/ExecutionException
          //   112	124	502	java/lang/InterruptedException
          //   112	124	507	java/util/concurrent/CancellationException
        }
      });
    }
    
    public void b(final do paramdo)
    {
      this.b.post(new Runnable()
      {
        public void run()
        {
          e.b.a(e.b.this).remove(paramdo);
          paramdo.a();
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.e
 * JD-Core Version:    0.7.0.1
 */