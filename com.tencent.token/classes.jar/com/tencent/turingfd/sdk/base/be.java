package com.tencent.turingfd.sdk.base;

import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import java.lang.ref.WeakReference;

public class be
  extends Handler
{
  public Handler a;
  public WeakReference b;
  public av c;
  public String d;
  
  public be(Handler paramHandler, Window paramWindow, Looper paramLooper, av paramav, String paramString)
  {
    super(paramLooper);
    this.a = paramHandler;
    this.c = paramav;
    this.b = new WeakReference(paramWindow);
    this.d = paramString;
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 45	android/os/Message:arg2	I
    //   4: istore_2
    //   5: aload_1
    //   6: getfield 48	android/os/Message:what	I
    //   9: istore_3
    //   10: aload_0
    //   11: getfield 19	com/tencent/turingfd/sdk/base/be:a	Landroid/os/Handler;
    //   14: aload_1
    //   15: invokevirtual 50	android/os/Handler:handleMessage	(Landroid/os/Message;)V
    //   18: aload_0
    //   19: getfield 21	com/tencent/turingfd/sdk/base/be:c	Lcom/tencent/turingfd/sdk/base/av;
    //   22: ifnonnull +4 -> 26
    //   25: return
    //   26: iload_3
    //   27: iconst_1
    //   28: if_icmpne -3 -> 25
    //   31: aload_0
    //   32: getfield 28	com/tencent/turingfd/sdk/base/be:b	Ljava/lang/ref/WeakReference;
    //   35: invokevirtual 54	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   38: checkcast 56	android/view/Window
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull -18 -> 25
    //   46: aload_1
    //   47: invokevirtual 60	android/view/Window:getDecorView	()Landroid/view/View;
    //   50: astore_1
    //   51: iload_2
    //   52: ifge +24 -> 76
    //   55: aconst_null
    //   56: astore_1
    //   57: aload_1
    //   58: ifnull -33 -> 25
    //   61: aload_0
    //   62: getfield 21	com/tencent/turingfd/sdk/base/be:c	Lcom/tencent/turingfd/sdk/base/av;
    //   65: aload_0
    //   66: getfield 30	com/tencent/turingfd/sdk/base/be:d	Ljava/lang/String;
    //   69: aload_1
    //   70: invokeinterface 65 3 0
    //   75: return
    //   76: aload_1
    //   77: ifnull -22 -> 55
    //   80: ldc 67
    //   82: ldc 69
    //   84: iconst_1
    //   85: anewarray 71	java/lang/Class
    //   88: dup
    //   89: iconst_0
    //   90: getstatic 77	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   93: aastore
    //   94: invokevirtual 81	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   97: astore 4
    //   99: aload 4
    //   101: iconst_1
    //   102: invokevirtual 87	java/lang/reflect/Method:setAccessible	(Z)V
    //   105: aload 4
    //   107: aload_1
    //   108: iconst_1
    //   109: anewarray 89	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: iload_2
    //   115: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: aastore
    //   119: invokevirtual 97	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   122: checkcast 67	android/view/View
    //   125: astore_1
    //   126: goto -69 -> 57
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 101	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   134: goto -79 -> 55
    //   137: astore_1
    //   138: aload_1
    //   139: athrow
    //   140: astore_1
    //   141: aload_1
    //   142: invokevirtual 102	java/lang/IllegalAccessException:printStackTrace	()V
    //   145: goto -90 -> 55
    //   148: astore_1
    //   149: aload_1
    //   150: invokevirtual 103	java/lang/NoSuchMethodException:printStackTrace	()V
    //   153: goto -98 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	be
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
 * Qualified Name:     com.tencent.turingfd.sdk.base.be
 * JD-Core Version:    0.7.0.1
 */