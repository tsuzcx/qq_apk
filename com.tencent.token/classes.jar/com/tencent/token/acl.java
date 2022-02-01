package com.tencent.token;

import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import java.lang.ref.WeakReference;

public final class acl
  extends Handler
{
  public Handler a;
  public WeakReference<Window> b;
  public acf c;
  public String d;
  
  public acl(Handler paramHandler, Window paramWindow, Looper paramLooper, acf paramacf, String paramString)
  {
    super(paramLooper);
    this.a = paramHandler;
    this.c = paramacf;
    this.b = new WeakReference(paramWindow);
    this.d = paramString;
  }
  
  /* Error */
  public final void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 46	android/os/Message:arg2	I
    //   4: istore_2
    //   5: aload_1
    //   6: getfield 49	android/os/Message:what	I
    //   9: istore_3
    //   10: aload_0
    //   11: getfield 20	com/tencent/token/acl:a	Landroid/os/Handler;
    //   14: aload_1
    //   15: invokevirtual 51	android/os/Handler:handleMessage	(Landroid/os/Message;)V
    //   18: aload_0
    //   19: getfield 22	com/tencent/token/acl:c	Lcom/tencent/token/acf;
    //   22: ifnonnull +4 -> 26
    //   25: return
    //   26: iload_3
    //   27: iconst_1
    //   28: if_icmpeq +4 -> 32
    //   31: return
    //   32: aload_0
    //   33: getfield 29	com/tencent/token/acl:b	Ljava/lang/ref/WeakReference;
    //   36: invokevirtual 55	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   39: checkcast 57	android/view/Window
    //   42: astore_1
    //   43: aload_1
    //   44: ifnonnull +4 -> 48
    //   47: return
    //   48: aload_1
    //   49: invokevirtual 61	android/view/Window:getDecorView	()Landroid/view/View;
    //   52: astore_1
    //   53: iload_2
    //   54: ifge +6 -> 60
    //   57: goto +86 -> 143
    //   60: aload_1
    //   61: ifnull +82 -> 143
    //   64: ldc 63
    //   66: ldc 65
    //   68: iconst_1
    //   69: anewarray 67	java/lang/Class
    //   72: dup
    //   73: iconst_0
    //   74: getstatic 73	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   77: aastore
    //   78: invokevirtual 77	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   81: astore 4
    //   83: aload 4
    //   85: iconst_1
    //   86: invokevirtual 83	java/lang/reflect/Method:setAccessible	(Z)V
    //   89: aload 4
    //   91: aload_1
    //   92: iconst_1
    //   93: anewarray 85	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: iload_2
    //   99: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokevirtual 93	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   106: checkcast 63	android/view/View
    //   109: astore_1
    //   110: goto +35 -> 145
    //   113: astore_1
    //   114: goto +27 -> 141
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 97	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   122: goto +21 -> 143
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual 98	java/lang/IllegalAccessException:printStackTrace	()V
    //   130: goto +13 -> 143
    //   133: astore_1
    //   134: aload_1
    //   135: invokevirtual 99	java/lang/NoSuchMethodException:printStackTrace	()V
    //   138: goto +5 -> 143
    //   141: aload_1
    //   142: athrow
    //   143: aconst_null
    //   144: astore_1
    //   145: aload_1
    //   146: ifnonnull +4 -> 150
    //   149: return
    //   150: aload_0
    //   151: getfield 22	com/tencent/token/acl:c	Lcom/tencent/token/acf;
    //   154: aload_0
    //   155: getfield 31	com/tencent/token/acl:d	Ljava/lang/String;
    //   158: aload_1
    //   159: invokeinterface 104 3 0
    //   164: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	acl
    //   0	165	1	paramMessage	android.os.Message
    //   4	95	2	i	int
    //   9	20	3	j	int
    //   81	9	4	localMethod	java.lang.reflect.Method
    // Exception table:
    //   from	to	target	type
    //   64	110	113	finally
    //   118	122	113	finally
    //   126	130	113	finally
    //   134	138	113	finally
    //   64	110	117	java/lang/reflect/InvocationTargetException
    //   64	110	125	java/lang/IllegalAccessException
    //   64	110	133	java/lang/NoSuchMethodException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acl
 * JD-Core Version:    0.7.0.1
 */