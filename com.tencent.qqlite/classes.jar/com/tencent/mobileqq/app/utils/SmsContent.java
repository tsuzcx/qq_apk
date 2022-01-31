package com.tencent.mobileqq.app.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

public class SmsContent
  extends ContentObserver
{
  public static final String a = "sms.content";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "_id", "address", "body" };
  public static final String b = "_id";
  public static final String c = "address";
  public static final String d = "body";
  private static final String e = "content://sms/";
  private static final String f = "content://sms/inbox";
  Context jdField_a_of_type_AndroidContentContext;
  SMSBodyObserver jdField_a_of_type_ComTencentMobileqqAppUtilsSMSBodyObserver;
  
  public SmsContent(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      this.jdField_a_of_type_AndroidContentContext.getContentResolver().unregisterContentObserver(this);
      if (QLog.isColorLevel()) {
        QLog.d("sms.content", 2, "unregister...");
      }
      this.jdField_a_of_type_AndroidContentContext = null;
    }
  }
  
  public void a(Context paramContext, SMSBodyObserver paramSMSBodyObserver)
  {
    if (paramContext == null) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSMSBodyObserver = paramSMSBodyObserver;
      this.jdField_a_of_type_AndroidContentContext.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this);
    } while (!QLog.isColorLevel());
    QLog.d("sms.content", 2, "register...");
  }
  
  /* Error */
  public void onChange(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial 83	android/database/ContentObserver:onChange	(Z)V
    //   5: aload_0
    //   6: getfield 39	com/tencent/mobileqq/app/utils/SmsContent:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9: ifnonnull +18 -> 27
    //   12: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +11 -> 26
    //   18: ldc 8
    //   20: iconst_2
    //   21: ldc 85
    //   23: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: return
    //   27: aload_0
    //   28: getfield 39	com/tencent/mobileqq/app/utils/SmsContent:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   31: invokevirtual 45	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   34: ldc 24
    //   36: invokestatic 71	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   39: getstatic 32	com/tencent/mobileqq/app/utils/SmsContent:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   42: aconst_null
    //   43: aconst_null
    //   44: ldc 87
    //   46: invokevirtual 91	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore_3
    //   50: aload_3
    //   51: ifnull +131 -> 182
    //   54: aload_3
    //   55: astore_2
    //   56: aload_3
    //   57: invokeinterface 96 1 0
    //   62: ifne +120 -> 182
    //   65: aload_3
    //   66: astore_2
    //   67: aload_3
    //   68: invokeinterface 99 1 0
    //   73: ifeq +109 -> 182
    //   76: aload_3
    //   77: astore_2
    //   78: aload_3
    //   79: aload_3
    //   80: ldc 15
    //   82: invokeinterface 103 2 0
    //   87: invokeinterface 107 2 0
    //   92: astore 4
    //   94: aload_3
    //   95: astore_2
    //   96: aload_3
    //   97: aload_3
    //   98: ldc 18
    //   100: invokeinterface 103 2 0
    //   105: invokeinterface 107 2 0
    //   110: astore 5
    //   112: aload_3
    //   113: astore_2
    //   114: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +41 -> 158
    //   120: aload_3
    //   121: astore_2
    //   122: ldc 8
    //   124: iconst_2
    //   125: new 109	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   132: ldc 113
    //   134: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 4
    //   139: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc 119
    //   144: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload 5
    //   149: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload_3
    //   159: astore_2
    //   160: aload_0
    //   161: getfield 65	com/tencent/mobileqq/app/utils/SmsContent:jdField_a_of_type_ComTencentMobileqqAppUtilsSMSBodyObserver	Lcom/tencent/mobileqq/app/utils/SMSBodyObserver;
    //   164: ifnull +18 -> 182
    //   167: aload_3
    //   168: astore_2
    //   169: aload_0
    //   170: getfield 65	com/tencent/mobileqq/app/utils/SmsContent:jdField_a_of_type_ComTencentMobileqqAppUtilsSMSBodyObserver	Lcom/tencent/mobileqq/app/utils/SMSBodyObserver;
    //   173: aload 4
    //   175: aload 5
    //   177: invokeinterface 129 3 0
    //   182: aload_3
    //   183: ifnull -157 -> 26
    //   186: aload_3
    //   187: invokeinterface 132 1 0
    //   192: return
    //   193: astore 4
    //   195: aconst_null
    //   196: astore_3
    //   197: aload_3
    //   198: astore_2
    //   199: aload 4
    //   201: invokevirtual 135	java/lang/Exception:printStackTrace	()V
    //   204: aload_3
    //   205: ifnull -179 -> 26
    //   208: aload_3
    //   209: invokeinterface 132 1 0
    //   214: return
    //   215: astore_3
    //   216: aconst_null
    //   217: astore_2
    //   218: aload_2
    //   219: ifnull +9 -> 228
    //   222: aload_2
    //   223: invokeinterface 132 1 0
    //   228: aload_3
    //   229: athrow
    //   230: astore_3
    //   231: goto -13 -> 218
    //   234: astore 4
    //   236: goto -39 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	SmsContent
    //   0	239	1	paramBoolean	boolean
    //   55	168	2	localCursor1	android.database.Cursor
    //   49	160	3	localCursor2	android.database.Cursor
    //   215	14	3	localObject1	java.lang.Object
    //   230	1	3	localObject2	java.lang.Object
    //   92	82	4	str1	String
    //   193	7	4	localException1	java.lang.Exception
    //   234	1	4	localException2	java.lang.Exception
    //   110	66	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   27	50	193	java/lang/Exception
    //   27	50	215	finally
    //   56	65	230	finally
    //   67	76	230	finally
    //   78	94	230	finally
    //   96	112	230	finally
    //   114	120	230	finally
    //   122	158	230	finally
    //   160	167	230	finally
    //   169	182	230	finally
    //   199	204	230	finally
    //   56	65	234	java/lang/Exception
    //   67	76	234	java/lang/Exception
    //   78	94	234	java/lang/Exception
    //   96	112	234	java/lang/Exception
    //   114	120	234	java/lang/Exception
    //   122	158	234	java/lang/Exception
    //   160	167	234	java/lang/Exception
    //   169	182	234	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.SmsContent
 * JD-Core Version:    0.7.0.1
 */