import android.content.DialogInterface.OnDismissListener;

public class acyg
{
  private static acyi a;
  private static DialogInterface.OnDismissListener c = new acyh();
  
  /* Error */
  public static boolean a(com.tencent.mobileqq.app.BaseActivity paramBaseActivity, java.util.ArrayList<com.tencent.mobileqq.data.QIMNotifyAddFriend> paramArrayList)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: getstatic 21	acyg:a	Lacyi;
    //   9: ifnull +25 -> 34
    //   12: getstatic 21	acyg:a	Lacyi;
    //   15: invokevirtual 28	acyi:isShowing	()Z
    //   18: ifeq +16 -> 34
    //   21: getstatic 21	acyg:a	Lacyi;
    //   24: aload_1
    //   25: invokevirtual 32	acyi:al	(Ljava/util/List;)Z
    //   28: istore_3
    //   29: ldc 2
    //   31: monitorexit
    //   32: iload_3
    //   33: ireturn
    //   34: iconst_0
    //   35: istore_3
    //   36: iload_3
    //   37: istore_2
    //   38: aload_1
    //   39: ifnull +41 -> 80
    //   42: iload_3
    //   43: istore_2
    //   44: aload_1
    //   45: invokevirtual 38	java/util/ArrayList:size	()I
    //   48: ifle +32 -> 80
    //   51: new 24	acyi
    //   54: dup
    //   55: aload_0
    //   56: aload_1
    //   57: invokespecial 41	acyi:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Ljava/util/ArrayList;)V
    //   60: putstatic 21	acyg:a	Lacyi;
    //   63: getstatic 21	acyg:a	Lacyi;
    //   66: getstatic 17	acyg:c	Landroid/content/DialogInterface$OnDismissListener;
    //   69: invokevirtual 45	acyi:setOnDismissListener	(Landroid/content/DialogInterface$OnDismissListener;)V
    //   72: getstatic 21	acyg:a	Lacyi;
    //   75: invokevirtual 48	acyi:show	()V
    //   78: iconst_1
    //   79: istore_2
    //   80: iload 4
    //   82: istore_3
    //   83: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq -57 -> 29
    //   89: ldc 55
    //   91: iconst_2
    //   92: new 57	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   99: ldc 60
    //   101: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: iload_2
    //   105: invokevirtual 67	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   108: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: iload 4
    //   116: istore_3
    //   117: goto -88 -> 29
    //   120: astore_0
    //   121: ldc 2
    //   123: monitorexit
    //   124: aload_0
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramBaseActivity	com.tencent.mobileqq.app.BaseActivity
    //   0	126	1	paramArrayList	java.util.ArrayList<com.tencent.mobileqq.data.QIMNotifyAddFriend>
    //   37	68	2	bool1	boolean
    //   28	89	3	bool2	boolean
    //   1	114	4	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   6	29	120	finally
    //   44	78	120	finally
    //   83	114	120	finally
  }
  
  public static void bF()
  {
    if ((a != null) && (a.isShowing())) {
      a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acyg
 * JD-Core Version:    0.7.0.1
 */