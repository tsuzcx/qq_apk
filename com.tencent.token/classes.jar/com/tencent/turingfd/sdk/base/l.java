package com.tencent.turingfd.sdk.base;

import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import java.lang.ref.WeakReference;

public class l
  extends Handler
{
  public Handler a;
  public WeakReference<Window> b;
  public g c;
  public String d;
  
  public l(Handler paramHandler, Window paramWindow, Looper paramLooper, g paramg, String paramString)
  {
    super(paramLooper);
    this.a = paramHandler;
    this.c = paramg;
    this.b = new WeakReference(paramWindow);
    this.d = paramString;
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 46	android/os/Message:arg2	I
    //   4: istore_2
    //   5: aload_1
    //   6: getfield 49	android/os/Message:what	I
    //   9: istore_3
    //   10: aload_0
    //   11: getfield 20	com/tencent/turingfd/sdk/base/l:a	Landroid/os/Handler;
    //   14: aload_1
    //   15: invokevirtual 51	android/os/Handler:handleMessage	(Landroid/os/Message;)V
    //   18: aload_0
    //   19: getfield 22	com/tencent/turingfd/sdk/base/l:c	Lcom/tencent/turingfd/sdk/base/g;
    //   22: ifnonnull +4 -> 26
    //   25: return
    //   26: iload_3
    //   27: iconst_1
    //   28: if_icmpne -3 -> 25
    //   31: aload_0
    //   32: getfield 29	com/tencent/turingfd/sdk/base/l:b	Ljava/lang/ref/WeakReference;
    //   35: invokevirtual 55	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   38: checkcast 57	android/view/Window
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull -18 -> 25
    //   46: aload_1
    //   47: invokevirtual 61	android/view/Window:getDecorView	()Landroid/view/View;
    //   50: astore_1
    //   51: iload_2
    //   52: ifge +24 -> 76
    //   55: aconst_null
    //   56: astore_1
    //   57: aload_1
    //   58: ifnull -33 -> 25
    //   61: aload_0
    //   62: getfield 22	com/tencent/turingfd/sdk/base/l:c	Lcom/tencent/turingfd/sdk/base/g;
    //   65: aload_0
    //   66: getfield 31	com/tencent/turingfd/sdk/base/l:d	Ljava/lang/String;
    //   69: aload_1
    //   70: invokeinterface 66 3 0
    //   75: return
    //   76: aload_1
    //   77: ifnull -22 -> 55
    //   80: ldc 68
    //   82: ldc 70
    //   84: iconst_1
    //   85: anewarray 72	java/lang/Class
    //   88: dup
    //   89: iconst_0
    //   90: getstatic 78	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   93: aastore
    //   94: invokevirtual 82	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   97: astore 4
    //   99: aload 4
    //   101: iconst_1
    //   102: invokevirtual 88	java/lang/reflect/Method:setAccessible	(Z)V
    //   105: aload 4
    //   107: aload_1
    //   108: iconst_1
    //   109: anewarray 90	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: iload_2
    //   115: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: aastore
    //   119: invokevirtual 98	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   122: checkcast 68	android/view/View
    //   125: astore_1
    //   126: goto -69 -> 57
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 102	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   134: goto -79 -> 55
    //   137: astore_1
    //   138: aload_1
    //   139: athrow
    //   140: astore_1
    //   141: aload_1
    //   142: invokevirtual 103	java/lang/IllegalAccessException:printStackTrace	()V
    //   145: goto -90 -> 55
    //   148: astore_1
    //   149: aload_1
    //   150: invokevirtual 104	java/lang/NoSuchMethodException:printStackTrace	()V
    //   153: goto -98 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	l
    //   0	156	1	paramMessage	android.os.Message
    //   4	111	2	i	int
    //   9	20	3	j	int
    //   97	9	4	localMethod	java.lang.reflect.Method
    // Exception table:
    //   from	to	target	type
    //   80	126	129	java/lang/reflect/InvocationTargetException
    //   80	126	137	finally
    //   130	134	137	finally
    //   141	145	137	finally
    //   149	153	137	finally
    //   80	126	140	java/lang/IllegalAccessException
    //   80	126	148	java/lang/NoSuchMethodException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.l
 * JD-Core Version:    0.7.0.1
 */