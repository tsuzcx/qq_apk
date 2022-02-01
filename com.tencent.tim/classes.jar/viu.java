import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;

public class viu
  implements DialogInterface.OnClickListener
{
  public viu(NotificationActivity paramNotificationActivity, String paramString) {}
  
  /* Error */
  public void onClick(android.content.DialogInterface paramDialogInterface, int paramInt)
  {
    // Byte code:
    //   0: new 26	android/content/Intent
    //   3: dup
    //   4: ldc 28
    //   6: aload_0
    //   7: getfield 16	viu:val$url	Ljava/lang/String;
    //   10: invokestatic 34	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   13: invokespecial 37	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   16: astore_1
    //   17: aload_0
    //   18: getfield 14	viu:this$0	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   21: aload_1
    //   22: invokevirtual 43	com/tencent/mobileqq/activity/NotificationActivity:startActivity	(Landroid/content/Intent;)V
    //   25: aconst_null
    //   26: ldc 45
    //   28: ldc 47
    //   30: ldc 49
    //   32: ldc 51
    //   34: ldc 53
    //   36: iconst_0
    //   37: iconst_0
    //   38: ldc 49
    //   40: ldc 49
    //   42: ldc 49
    //   44: ldc 49
    //   46: invokestatic 59	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_0
    //   50: getfield 14	viu:this$0	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   53: invokevirtual 62	com/tencent/mobileqq/activity/NotificationActivity:finish	()V
    //   56: return
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   62: goto -13 -> 49
    //   65: astore_1
    //   66: aconst_null
    //   67: ldc 45
    //   69: ldc 47
    //   71: ldc 49
    //   73: ldc 51
    //   75: ldc 53
    //   77: iconst_0
    //   78: iconst_0
    //   79: ldc 49
    //   81: ldc 49
    //   83: ldc 49
    //   85: ldc 49
    //   87: invokestatic 59	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: getfield 14	viu:this$0	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   94: invokevirtual 62	com/tencent/mobileqq/activity/NotificationActivity:finish	()V
    //   97: return
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   103: goto -13 -> 90
    //   106: astore_1
    //   107: aconst_null
    //   108: ldc 45
    //   110: ldc 47
    //   112: ldc 49
    //   114: ldc 51
    //   116: ldc 53
    //   118: iconst_0
    //   119: iconst_0
    //   120: ldc 49
    //   122: ldc 49
    //   124: ldc 49
    //   126: ldc 49
    //   128: invokestatic 59	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_0
    //   132: getfield 14	viu:this$0	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   135: invokevirtual 62	com/tencent/mobileqq/activity/NotificationActivity:finish	()V
    //   138: aload_1
    //   139: athrow
    //   140: astore_3
    //   141: aload_3
    //   142: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   145: goto -14 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	viu
    //   0	148	1	paramDialogInterface	android.content.DialogInterface
    //   0	148	2	paramInt	int
    //   140	2	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   25	49	57	java/lang/Exception
    //   0	25	65	java/lang/Exception
    //   66	90	98	java/lang/Exception
    //   0	25	106	finally
    //   107	131	140	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     viu
 * JD-Core Version:    0.7.0.1
 */