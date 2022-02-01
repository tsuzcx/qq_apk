package com.tencent.token;

import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;

public final class ack
  implements ViewTreeObserver.OnPreDrawListener
{
  public ack(Window paramWindow, String paramString, acf paramacf) {}
  
  /* Error */
  public final boolean onPreDraw()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/token/ack:a	Landroid/view/Window;
    //   4: invokevirtual 32	android/view/Window:getDecorView	()Landroid/view/View;
    //   7: invokevirtual 38	android/view/View:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   10: aload_0
    //   11: invokevirtual 44	android/view/ViewTreeObserver:removeOnPreDrawListener	(Landroid/view/ViewTreeObserver$OnPreDrawListener;)V
    //   14: aload_0
    //   15: getfield 16	com/tencent/token/ack:a	Landroid/view/Window;
    //   18: astore_2
    //   19: invokestatic 49	com/tencent/token/adf:a	()I
    //   22: istore_1
    //   23: aconst_null
    //   24: astore 4
    //   26: iload_1
    //   27: bipush 30
    //   29: if_icmpge +37 -> 66
    //   32: aload_2
    //   33: invokevirtual 53	java/lang/Object:getClass	()Ljava/lang/Class;
    //   36: astore_3
    //   37: aload_3
    //   38: ldc 55
    //   40: iconst_0
    //   41: anewarray 57	java/lang/Class
    //   44: invokevirtual 61	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   47: astore_3
    //   48: aload_3
    //   49: iconst_1
    //   50: invokevirtual 67	java/lang/reflect/Method:setAccessible	(Z)V
    //   53: aload_3
    //   54: aload_2
    //   55: iconst_0
    //   56: anewarray 4	java/lang/Object
    //   59: invokevirtual 71	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   62: astore_2
    //   63: goto +5 -> 68
    //   66: aconst_null
    //   67: astore_2
    //   68: aload_2
    //   69: ifnonnull +5 -> 74
    //   72: iconst_1
    //   73: ireturn
    //   74: aload_2
    //   75: invokevirtual 53	java/lang/Object:getClass	()Ljava/lang/Class;
    //   78: astore_3
    //   79: aload_3
    //   80: ldc 73
    //   82: iconst_0
    //   83: anewarray 57	java/lang/Class
    //   86: invokevirtual 61	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   89: astore_3
    //   90: aload_3
    //   91: iconst_1
    //   92: invokevirtual 67	java/lang/reflect/Method:setAccessible	(Z)V
    //   95: aload_3
    //   96: aload_2
    //   97: iconst_0
    //   98: anewarray 4	java/lang/Object
    //   101: invokevirtual 71	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   104: astore_2
    //   105: goto +5 -> 110
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: ifnonnull +5 -> 116
    //   114: iconst_1
    //   115: ireturn
    //   116: aload_2
    //   117: invokevirtual 53	java/lang/Object:getClass	()Ljava/lang/Class;
    //   120: ldc 75
    //   122: invokevirtual 79	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   125: astore_3
    //   126: aload_3
    //   127: iconst_1
    //   128: invokevirtual 82	java/lang/reflect/Field:setAccessible	(Z)V
    //   131: aload_3
    //   132: aload_2
    //   133: invokevirtual 86	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   136: astore_3
    //   137: goto +5 -> 142
    //   140: aconst_null
    //   141: astore_3
    //   142: aload_3
    //   143: ifnull +115 -> 258
    //   146: aload_3
    //   147: instanceof 88
    //   150: ifne +108 -> 258
    //   153: aload_3
    //   154: invokevirtual 53	java/lang/Object:getClass	()Ljava/lang/Class;
    //   157: astore 5
    //   159: aload 5
    //   161: ldc 90
    //   163: iconst_0
    //   164: anewarray 57	java/lang/Class
    //   167: invokevirtual 93	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   170: astore 5
    //   172: aload 5
    //   174: iconst_1
    //   175: invokevirtual 67	java/lang/reflect/Method:setAccessible	(Z)V
    //   178: aload 5
    //   180: aload_3
    //   181: iconst_0
    //   182: anewarray 4	java/lang/Object
    //   185: invokevirtual 71	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   188: astore 5
    //   190: aload 5
    //   192: astore 4
    //   194: aload 4
    //   196: checkcast 95	android/os/Looper
    //   199: astore 4
    //   201: aload 4
    //   203: ifnonnull +5 -> 208
    //   206: iconst_1
    //   207: ireturn
    //   208: new 88	com/tencent/token/acl
    //   211: dup
    //   212: aload_3
    //   213: checkcast 97	android/os/Handler
    //   216: aload_0
    //   217: getfield 16	com/tencent/token/ack:a	Landroid/view/Window;
    //   220: aload 4
    //   222: aload_0
    //   223: getfield 20	com/tencent/token/ack:c	Lcom/tencent/token/acf;
    //   226: aload_0
    //   227: getfield 18	com/tencent/token/ack:b	Ljava/lang/String;
    //   230: invokespecial 100	com/tencent/token/acl:<init>	(Landroid/os/Handler;Landroid/view/Window;Landroid/os/Looper;Lcom/tencent/token/acf;Ljava/lang/String;)V
    //   233: astore_3
    //   234: aload_2
    //   235: invokevirtual 53	java/lang/Object:getClass	()Ljava/lang/Class;
    //   238: ldc 75
    //   240: invokevirtual 79	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   243: astore 4
    //   245: aload 4
    //   247: iconst_1
    //   248: invokevirtual 82	java/lang/reflect/Field:setAccessible	(Z)V
    //   251: aload 4
    //   253: aload_2
    //   254: aload_3
    //   255: invokevirtual 104	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   258: iconst_1
    //   259: ireturn
    //   260: astore_2
    //   261: iconst_1
    //   262: ireturn
    //   263: astore_2
    //   264: goto -198 -> 66
    //   267: astore_2
    //   268: goto -160 -> 108
    //   271: astore_3
    //   272: goto -132 -> 140
    //   275: astore 5
    //   277: goto -83 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	ack
    //   22	8	1	i	int
    //   18	236	2	localObject1	Object
    //   260	1	2	localObject2	Object
    //   263	1	2	localObject3	Object
    //   267	1	2	localObject4	Object
    //   36	219	3	localObject5	Object
    //   271	1	3	localObject6	Object
    //   24	228	4	localObject7	Object
    //   157	34	5	localObject8	Object
    //   275	1	5	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   0	23	260	finally
    //   194	201	260	finally
    //   208	258	260	finally
    //   32	37	263	finally
    //   37	63	263	finally
    //   74	79	267	finally
    //   79	105	267	finally
    //   116	137	271	finally
    //   153	159	275	finally
    //   159	190	275	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ack
 * JD-Core Version:    0.7.0.1
 */