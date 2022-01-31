package btmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

public class ev
{
  private static String pa = "";
  private static long pb = -1L;
  private static long pc = -1L;
  private static int pd = -1;
  
  /* Error */
  private static int a(Context paramContext, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2)
  {
    // Byte code:
    //   0: invokestatic 38	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: new 4	java/lang/Object
    //   7: dup
    //   8: invokespecial 41	java/lang/Object:<init>	()V
    //   11: astore 5
    //   13: new 43	android/content/Intent
    //   16: dup
    //   17: invokespecial 44	android/content/Intent:<init>	()V
    //   20: astore 6
    //   22: aload 6
    //   24: new 46	android/content/ComponentName
    //   27: dup
    //   28: ldc 48
    //   30: ldc 50
    //   32: invokespecial 53	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: invokevirtual 57	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   38: pop
    //   39: aload 6
    //   41: ldc 59
    //   43: invokevirtual 63	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   46: pop
    //   47: aload_0
    //   48: aload 6
    //   50: new 65	btmsdkobf/iz
    //   53: dup
    //   54: lload_3
    //   55: aload_1
    //   56: aload_2
    //   57: aload 5
    //   59: invokespecial 68	btmsdkobf/iz:<init>	(JLjava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   62: iconst_1
    //   63: invokevirtual 74	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   66: ifne +7 -> 73
    //   69: sipush -400
    //   72: ireturn
    //   73: aload_1
    //   74: invokevirtual 80	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   77: ifnonnull +17 -> 94
    //   80: aload 5
    //   82: monitorenter
    //   83: aload 5
    //   85: ldc2_w 81
    //   88: invokevirtual 86	java/lang/Object:wait	(J)V
    //   91: aload 5
    //   93: monitorexit
    //   94: aload_1
    //   95: invokevirtual 80	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   98: ifnonnull +13 -> 111
    //   101: sipush -405
    //   104: ireturn
    //   105: astore_0
    //   106: aload 5
    //   108: monitorexit
    //   109: aload_0
    //   110: athrow
    //   111: iconst_0
    //   112: ireturn
    //   113: astore_0
    //   114: goto -23 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramContext	Context
    //   0	117	1	paramAtomicReference1	AtomicReference
    //   0	117	2	paramAtomicReference2	AtomicReference
    //   3	52	3	l	long
    //   11	96	5	localObject	Object
    //   20	29	6	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   83	91	105	finally
    //   91	94	105	finally
    //   106	109	105	finally
    //   83	91	113	java/lang/Throwable
  }
  
  public static String a(Context paramContext)
  {
    if (!o(paramContext))
    {
      pd = -407;
      return pa;
    }
    if (TextUtils.isEmpty(pa)) {
      return p(paramContext);
    }
    return pa;
  }
  
  /* Error */
  private static int b(Context paramContext, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2)
  {
    // Byte code:
    //   0: new 4	java/lang/Object
    //   3: dup
    //   4: invokespecial 41	java/lang/Object:<init>	()V
    //   7: astore 5
    //   9: new 76	java/util/concurrent/atomic/AtomicReference
    //   12: dup
    //   13: iconst_0
    //   14: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokespecial 110	java/util/concurrent/atomic/AtomicReference:<init>	(Ljava/lang/Object;)V
    //   20: astore 6
    //   22: invokestatic 38	java/lang/System:currentTimeMillis	()J
    //   25: lstore_3
    //   26: new 112	btmsdkobf/ja
    //   29: dup
    //   30: aload_1
    //   31: aload 6
    //   33: aload_0
    //   34: aload_2
    //   35: aload 5
    //   37: invokespecial 115	btmsdkobf/ja:<init>	(Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Landroid/content/Context;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   40: invokevirtual 118	btmsdkobf/ja:start	()V
    //   43: aload 5
    //   45: monitorenter
    //   46: aload 5
    //   48: ldc2_w 81
    //   51: invokevirtual 86	java/lang/Object:wait	(J)V
    //   54: aload 5
    //   56: monitorexit
    //   57: invokestatic 38	java/lang/System:currentTimeMillis	()J
    //   60: lload_3
    //   61: lsub
    //   62: putstatic 23	btmsdkobf/ev:pc	J
    //   65: aload 6
    //   67: invokevirtual 80	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   70: checkcast 103	java/lang/Integer
    //   73: invokevirtual 122	java/lang/Integer:intValue	()I
    //   76: ireturn
    //   77: astore_0
    //   78: aload 5
    //   80: monitorexit
    //   81: aload_0
    //   82: athrow
    //   83: astore_0
    //   84: goto -30 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramContext	Context
    //   0	87	1	paramAtomicReference1	AtomicReference
    //   0	87	2	paramAtomicReference2	AtomicReference
    //   25	36	3	l	long
    //   7	72	5	localObject	Object
    //   20	46	6	localAtomicReference	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   46	54	77	finally
    //   54	57	77	finally
    //   78	81	77	finally
    //   46	54	83	java/lang/Throwable
  }
  
  private static boolean o(Context paramContext)
  {
    return true;
  }
  
  private static String p(Context paramContext)
  {
    try
    {
      pd = 0;
      AtomicReference localAtomicReference1 = new AtomicReference();
      AtomicReference localAtomicReference2 = new AtomicReference();
      pd = a(paramContext, localAtomicReference1, localAtomicReference2);
      if (pd == 0) {
        pd = b(paramContext, localAtomicReference1, localAtomicReference2);
      }
      paramContext = pa;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      eg.e("OPPOImpl", paramContext.getMessage());
      pd = -406;
    }
    return pa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ev
 * JD-Core Version:    0.7.0.1
 */