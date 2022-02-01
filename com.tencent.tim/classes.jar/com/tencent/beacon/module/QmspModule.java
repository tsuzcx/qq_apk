package com.tencent.beacon.module;

import android.content.Context;
import com.tencent.beacon.qimei.QimeiSDK;

public class QmspModule
  implements BeaconModule
{
  private Context a;
  private boolean b;
  private final Runnable c = new QmspModule.1(this);
  
  /* Error */
  private void a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/beacon/module/QmspModule:b	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: ldc 34
    //   16: iconst_1
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: aload_1
    //   23: aastore
    //   24: invokestatic 39	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_1
    //   28: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifne -20 -> 11
    //   34: invokestatic 51	com/tencent/beacon/a/c/c:d	()Lcom/tencent/beacon/a/c/c;
    //   37: astore 4
    //   39: invokestatic 51	com/tencent/beacon/a/c/c:d	()Lcom/tencent/beacon/a/c/c;
    //   42: invokevirtual 55	com/tencent/beacon/a/c/c:k	()Ljava/lang/String;
    //   45: astore 5
    //   47: invokestatic 51	com/tencent/beacon/a/c/c:d	()Lcom/tencent/beacon/a/c/c;
    //   50: invokevirtual 58	com/tencent/beacon/a/c/c:f	()Ljava/lang/String;
    //   53: astore 6
    //   55: ldc 60
    //   57: iconst_4
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload 5
    //   65: aastore
    //   66: dup
    //   67: iconst_1
    //   68: aload_1
    //   69: aastore
    //   70: dup
    //   71: iconst_2
    //   72: aload 6
    //   74: aastore
    //   75: dup
    //   76: iconst_3
    //   77: aload 4
    //   79: invokevirtual 63	com/tencent/beacon/a/c/c:i	()Ljava/lang/String;
    //   82: aastore
    //   83: invokestatic 39	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload_0
    //   87: getfield 65	com/tencent/beacon/module/QmspModule:a	Landroid/content/Context;
    //   90: aload 5
    //   92: aload_1
    //   93: aload 6
    //   95: aload 4
    //   97: invokevirtual 63	com/tencent/beacon/a/c/c:i	()Ljava/lang/String;
    //   100: invokestatic 68	com/tencent/beacon/base/util/c:a	()Z
    //   103: invokestatic 74	com/tencent/qmsp/sdk/u/U:startQ	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)I
    //   106: istore_2
    //   107: invokestatic 79	com/tencent/beacon/a/b/a:a	()Lcom/tencent/beacon/a/b/a;
    //   110: bipush 114
    //   112: lconst_0
    //   113: ldc2_w 80
    //   116: aload_0
    //   117: getfield 23	com/tencent/beacon/module/QmspModule:c	Ljava/lang/Runnable;
    //   120: invokevirtual 84	com/tencent/beacon/a/b/a:a	(IJJLjava/lang/Runnable;)V
    //   123: aload_0
    //   124: iconst_1
    //   125: putfield 32	com/tencent/beacon/module/QmspModule:b	Z
    //   128: ldc 86
    //   130: iconst_1
    //   131: anewarray 4	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: iload_2
    //   137: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: aastore
    //   141: invokestatic 39	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: goto -133 -> 11
    //   147: astore_1
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_1
    //   151: athrow
    //   152: astore_1
    //   153: ldc 94
    //   155: iconst_2
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: iload_2
    //   162: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: aastore
    //   166: dup
    //   167: iconst_1
    //   168: aload_1
    //   169: invokevirtual 97	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   172: aastore
    //   173: invokestatic 99	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: aload_1
    //   177: invokestatic 102	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   180: invokestatic 105	com/tencent/qmsp/sdk/u/U:stopQ	()V
    //   183: aload_0
    //   184: iconst_0
    //   185: putfield 32	com/tencent/beacon/module/QmspModule:b	Z
    //   188: goto -60 -> 128
    //   191: astore_1
    //   192: iconst_0
    //   193: istore_2
    //   194: goto -41 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	QmspModule
    //   0	197	1	paramString	java.lang.String
    //   106	88	2	i	int
    //   6	2	3	bool	boolean
    //   37	59	4	localc	com.tencent.beacon.a.c.c
    //   45	46	5	str1	java.lang.String
    //   53	41	6	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   2	7	147	finally
    //   14	55	147	finally
    //   55	107	147	finally
    //   107	128	147	finally
    //   128	144	147	finally
    //   153	188	147	finally
    //   107	128	152	java/lang/Throwable
    //   55	107	191	java/lang/Throwable
  }
  
  public void a(Context paramContext)
  {
    if (!com.tencent.beacon.a.c.c.d().l())
    {
      com.tencent.beacon.base.util.c.a("qmsp disable by user", new Object[0]);
      return;
    }
    this.a = paramContext;
    QimeiSDK.getInstance().getQimei(new QmspModule.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.module.QmspModule
 * JD-Core Version:    0.7.0.1
 */