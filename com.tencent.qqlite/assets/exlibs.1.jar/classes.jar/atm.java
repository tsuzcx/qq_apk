import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class atm
  implements Runnable
{
  public atm(LoginActivity paramLoginActivity, String paramString, QQProgressDialog paramQQProgressDialog) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	atm:jdField_a_of_type_ComTencentMobileqqActivityLoginActivity	Lcom/tencent/mobileqq/activity/LoginActivity;
    //   4: invokevirtual 31	com/tencent/mobileqq/activity/LoginActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7: ldc 33
    //   9: invokevirtual 39	mqq/app/AppRuntime:stopPCActivePolling	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 14	atm:jdField_a_of_type_ComTencentMobileqqActivityLoginActivity	Lcom/tencent/mobileqq/activity/LoginActivity;
    //   16: invokevirtual 31	com/tencent/mobileqq/activity/LoginActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   19: iconst_0
    //   20: invokevirtual 43	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   23: checkcast 45	mqq/manager/AccountManager
    //   26: aload_0
    //   27: getfield 16	atm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   30: aconst_null
    //   31: invokeinterface 48 3 0
    //   36: aload_0
    //   37: getfield 16	atm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   40: invokestatic 52	com/tencent/mobileqq/utils/HistoryChatMsgSearchKeyUtil:a	(Ljava/lang/String;)V
    //   43: aload_0
    //   44: getfield 14	atm:jdField_a_of_type_ComTencentMobileqqActivityLoginActivity	Lcom/tencent/mobileqq/activity/LoginActivity;
    //   47: getfield 55	com/tencent/mobileqq/activity/LoginActivity:a	Lcom/tencent/mobileqq/widget/PadQQCheckBox;
    //   50: invokevirtual 60	com/tencent/mobileqq/widget/PadQQCheckBox:a	()Z
    //   53: ifeq +28 -> 81
    //   56: new 62	com/tencent/mobileqq/managers/MessageRecordManagerImpl
    //   59: dup
    //   60: invokespecial 63	com/tencent/mobileqq/managers/MessageRecordManagerImpl:<init>	()V
    //   63: aload_0
    //   64: getfield 16	atm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   67: invokevirtual 64	com/tencent/mobileqq/managers/MessageRecordManagerImpl:a	(Ljava/lang/String;)V
    //   70: aload_0
    //   71: getfield 14	atm:jdField_a_of_type_ComTencentMobileqqActivityLoginActivity	Lcom/tencent/mobileqq/activity/LoginActivity;
    //   74: aload_0
    //   75: getfield 16	atm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   78: invokevirtual 67	com/tencent/mobileqq/activity/LoginActivity:b	(Ljava/lang/String;)V
    //   81: iconst_0
    //   82: ifeq +11 -> 93
    //   85: new 69	java/lang/NullPointerException
    //   88: dup
    //   89: invokespecial 70	java/lang/NullPointerException:<init>	()V
    //   92: athrow
    //   93: aload_0
    //   94: getfield 14	atm:jdField_a_of_type_ComTencentMobileqqActivityLoginActivity	Lcom/tencent/mobileqq/activity/LoginActivity;
    //   97: new 72	atn
    //   100: dup
    //   101: aload_0
    //   102: invokespecial 75	atn:<init>	(Latm;)V
    //   105: invokevirtual 79	com/tencent/mobileqq/activity/LoginActivity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   108: return
    //   109: astore_1
    //   110: iconst_0
    //   111: ifeq -18 -> 93
    //   114: new 69	java/lang/NullPointerException
    //   117: dup
    //   118: invokespecial 70	java/lang/NullPointerException:<init>	()V
    //   121: athrow
    //   122: astore_1
    //   123: iconst_0
    //   124: ifeq +11 -> 135
    //   127: new 69	java/lang/NullPointerException
    //   130: dup
    //   131: invokespecial 70	java/lang/NullPointerException:<init>	()V
    //   134: athrow
    //   135: aload_1
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	atm
    //   109	1	1	localException	java.lang.Exception
    //   122	14	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	81	109	java/lang/Exception
    //   12	81	122	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     atm
 * JD-Core Version:    0.7.0.1
 */