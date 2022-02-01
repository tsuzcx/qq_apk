import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class ctr
  implements Runnable
{
  public ctr(LoginActivity paramLoginActivity, String paramString, QQProgressDialog paramQQProgressDialog) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	ctr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4: invokestatic 30	com/tencent/mobileqq/app/PrivacyDeclareHelper:a	(Ljava/lang/String;)V
    //   7: aload_0
    //   8: getfield 14	ctr:jdField_a_of_type_ComTencentMobileqqActivityLoginActivity	Lcom/tencent/mobileqq/activity/LoginActivity;
    //   11: invokevirtual 36	com/tencent/mobileqq/activity/LoginActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   14: iconst_0
    //   15: invokevirtual 42	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   18: checkcast 44	mqq/manager/AccountManager
    //   21: aload_0
    //   22: getfield 16	ctr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   25: aconst_null
    //   26: invokeinterface 48 3 0
    //   31: aload_0
    //   32: getfield 16	ctr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   35: invokestatic 51	com/tencent/mobileqq/utils/HistoryChatMsgSearchKeyUtil:a	(Ljava/lang/String;)V
    //   38: aload_0
    //   39: getfield 14	ctr:jdField_a_of_type_ComTencentMobileqqActivityLoginActivity	Lcom/tencent/mobileqq/activity/LoginActivity;
    //   42: getfield 54	com/tencent/mobileqq/activity/LoginActivity:a	Lcom/tencent/mobileqq/widget/PadQQCheckBox;
    //   45: invokevirtual 59	com/tencent/mobileqq/widget/PadQQCheckBox:a	()Z
    //   48: ifeq +28 -> 76
    //   51: new 61	com/tencent/mobileqq/managers/MessageRecordManagerImpl
    //   54: dup
    //   55: invokespecial 62	com/tencent/mobileqq/managers/MessageRecordManagerImpl:<init>	()V
    //   58: aload_0
    //   59: getfield 16	ctr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   62: invokevirtual 63	com/tencent/mobileqq/managers/MessageRecordManagerImpl:a	(Ljava/lang/String;)V
    //   65: aload_0
    //   66: getfield 14	ctr:jdField_a_of_type_ComTencentMobileqqActivityLoginActivity	Lcom/tencent/mobileqq/activity/LoginActivity;
    //   69: aload_0
    //   70: getfield 16	ctr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   73: invokevirtual 66	com/tencent/mobileqq/activity/LoginActivity:b	(Ljava/lang/String;)V
    //   76: iconst_0
    //   77: ifeq +11 -> 88
    //   80: new 68	java/lang/NullPointerException
    //   83: dup
    //   84: invokespecial 69	java/lang/NullPointerException:<init>	()V
    //   87: athrow
    //   88: aload_0
    //   89: getfield 14	ctr:jdField_a_of_type_ComTencentMobileqqActivityLoginActivity	Lcom/tencent/mobileqq/activity/LoginActivity;
    //   92: new 71	cts
    //   95: dup
    //   96: aload_0
    //   97: invokespecial 74	cts:<init>	(Lctr;)V
    //   100: invokevirtual 78	com/tencent/mobileqq/activity/LoginActivity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   103: return
    //   104: astore_1
    //   105: iconst_0
    //   106: ifeq -18 -> 88
    //   109: new 68	java/lang/NullPointerException
    //   112: dup
    //   113: invokespecial 69	java/lang/NullPointerException:<init>	()V
    //   116: athrow
    //   117: astore_1
    //   118: iconst_0
    //   119: ifeq +11 -> 130
    //   122: new 68	java/lang/NullPointerException
    //   125: dup
    //   126: invokespecial 69	java/lang/NullPointerException:<init>	()V
    //   129: athrow
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	ctr
    //   104	1	1	localException	java.lang.Exception
    //   117	14	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	76	104	java/lang/Exception
    //   0	76	117	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ctr
 * JD-Core Version:    0.7.0.1
 */