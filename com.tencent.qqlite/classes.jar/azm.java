import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;

public class azm
  implements DialogInterface.OnClickListener
{
  public azm(NotificationActivity paramNotificationActivity, String paramString) {}
  
  /* Error */
  public void onClick(android.content.DialogInterface paramDialogInterface, int paramInt)
  {
    // Byte code:
    //   0: new 25	android/content/Intent
    //   3: dup
    //   4: ldc 27
    //   6: aload_0
    //   7: getfield 15	azm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10: invokestatic 33	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   13: invokespecial 36	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   16: astore_1
    //   17: aload_0
    //   18: getfield 13	azm:jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   21: aload_1
    //   22: invokevirtual 42	com/tencent/mobileqq/activity/NotificationActivity:startActivity	(Landroid/content/Intent;)V
    //   25: aconst_null
    //   26: ldc 44
    //   28: ldc 46
    //   30: ldc 48
    //   32: ldc 50
    //   34: ldc 52
    //   36: iconst_0
    //   37: iconst_0
    //   38: ldc 48
    //   40: ldc 48
    //   42: ldc 48
    //   44: ldc 48
    //   46: invokestatic 58	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_0
    //   50: getfield 13	azm:jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   53: invokevirtual 61	com/tencent/mobileqq/activity/NotificationActivity:finish	()V
    //   56: return
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 64	java/lang/Exception:printStackTrace	()V
    //   62: goto -13 -> 49
    //   65: astore_1
    //   66: aconst_null
    //   67: ldc 44
    //   69: ldc 46
    //   71: ldc 48
    //   73: ldc 50
    //   75: ldc 52
    //   77: iconst_0
    //   78: iconst_0
    //   79: ldc 48
    //   81: ldc 48
    //   83: ldc 48
    //   85: ldc 48
    //   87: invokestatic 58	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: getfield 13	azm:jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   94: invokevirtual 61	com/tencent/mobileqq/activity/NotificationActivity:finish	()V
    //   97: return
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 64	java/lang/Exception:printStackTrace	()V
    //   103: goto -13 -> 90
    //   106: astore_1
    //   107: aconst_null
    //   108: ldc 44
    //   110: ldc 46
    //   112: ldc 48
    //   114: ldc 50
    //   116: ldc 52
    //   118: iconst_0
    //   119: iconst_0
    //   120: ldc 48
    //   122: ldc 48
    //   124: ldc 48
    //   126: ldc 48
    //   128: invokestatic 58	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_0
    //   132: getfield 13	azm:jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   135: invokevirtual 61	com/tencent/mobileqq/activity/NotificationActivity:finish	()V
    //   138: aload_1
    //   139: athrow
    //   140: astore_3
    //   141: aload_3
    //   142: invokevirtual 64	java/lang/Exception:printStackTrace	()V
    //   145: goto -14 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	azm
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     azm
 * JD-Core Version:    0.7.0.1
 */