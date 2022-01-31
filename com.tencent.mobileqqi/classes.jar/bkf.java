import android.content.Context;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.PublicAccountManager.InitDoneObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public class bkf
  implements Runnable
{
  public bkf(PublicAccountManager paramPublicAccountManager, String paramString, QQAppInterface paramQQAppInterface, PublicAccountManager.InitDoneObserver paramInitDoneObserver, Context paramContext) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	bkf:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager	Lcom/tencent/biz/pubaccount/PublicAccountManager;
    //   4: invokestatic 36	com/tencent/biz/pubaccount/PublicAccountManager:a	(Lcom/tencent/biz/pubaccount/PublicAccountManager;)Ljava/util/Map;
    //   7: aload_0
    //   8: getfield 18	bkf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokeinterface 42 2 0
    //   16: ifne +223 -> 239
    //   19: aload_0
    //   20: getfield 20	bkf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   23: invokevirtual 47	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   26: invokevirtual 53	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   29: ldc 55
    //   31: aload_0
    //   32: getfield 18	bkf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   35: invokevirtual 60	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   38: checkcast 55	com/tencent/mobileqq/data/PublicAccountMenuEntity
    //   41: astore 5
    //   43: aload 5
    //   45: ifnull +160 -> 205
    //   48: new 62	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountMenuResponse
    //   51: dup
    //   52: invokespecial 63	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountMenuResponse:<init>	()V
    //   55: astore 4
    //   57: aload 4
    //   59: aload 5
    //   61: getfield 67	com/tencent/mobileqq/data/PublicAccountMenuEntity:data	[B
    //   64: invokevirtual 71	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountMenuResponse:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   67: pop
    //   68: aload 4
    //   70: ifnull +125 -> 195
    //   73: aload 4
    //   75: getfield 75	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountMenuResponse:button_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   78: invokevirtual 81	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   81: ifeq +114 -> 195
    //   84: aload 4
    //   86: getfield 75	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountMenuResponse:button_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   89: invokevirtual 85	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   92: astore 4
    //   94: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +34 -> 131
    //   100: ldc 92
    //   102: iconst_2
    //   103: new 94	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   110: ldc 97
    //   112: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 4
    //   117: invokeinterface 107 1 0
    //   122: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 118	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload 5
    //   133: getfield 122	com/tencent/mobileqq/data/PublicAccountMenuEntity:savedDateTime	J
    //   136: lstore_2
    //   137: aload 5
    //   139: getfield 126	com/tencent/mobileqq/data/PublicAccountMenuEntity:seqno	I
    //   142: istore_1
    //   143: aload_0
    //   144: getfield 16	bkf:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager	Lcom/tencent/biz/pubaccount/PublicAccountManager;
    //   147: invokestatic 129	com/tencent/biz/pubaccount/PublicAccountManager:b	(Lcom/tencent/biz/pubaccount/PublicAccountManager;)Ljava/util/Map;
    //   150: aload_0
    //   151: getfield 18	bkf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   154: lload_2
    //   155: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   158: invokeinterface 139 3 0
    //   163: pop
    //   164: aload_0
    //   165: getfield 16	bkf:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager	Lcom/tencent/biz/pubaccount/PublicAccountManager;
    //   168: aload_0
    //   169: getfield 18	bkf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   172: iload_1
    //   173: invokevirtual 142	com/tencent/biz/pubaccount/PublicAccountManager:a	(Ljava/lang/String;I)V
    //   176: aload_0
    //   177: getfield 16	bkf:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager	Lcom/tencent/biz/pubaccount/PublicAccountManager;
    //   180: invokestatic 36	com/tencent/biz/pubaccount/PublicAccountManager:a	(Lcom/tencent/biz/pubaccount/PublicAccountManager;)Ljava/util/Map;
    //   183: aload_0
    //   184: getfield 18	bkf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   187: aload 4
    //   189: invokeinterface 139 3 0
    //   194: pop
    //   195: aload_0
    //   196: getfield 22	bkf:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager$InitDoneObserver	Lcom/tencent/biz/pubaccount/PublicAccountManager$InitDoneObserver;
    //   199: invokeinterface 146 1 0
    //   204: return
    //   205: new 148	bkg
    //   208: dup
    //   209: aload_0
    //   210: invokespecial 151	bkg:<init>	(Lbkf;)V
    //   213: astore 4
    //   215: aload_0
    //   216: getfield 16	bkf:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager	Lcom/tencent/biz/pubaccount/PublicAccountManager;
    //   219: aload_0
    //   220: getfield 24	bkf:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   223: aload_0
    //   224: getfield 20	bkf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   227: aload_0
    //   228: getfield 18	bkf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   231: aload 4
    //   233: iconst_0
    //   234: invokevirtual 154	com/tencent/biz/pubaccount/PublicAccountManager:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lmqq/observer/BusinessObserver;Z)Lmqq/app/NewIntent;
    //   237: pop
    //   238: return
    //   239: aload_0
    //   240: getfield 22	bkf:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager$InitDoneObserver	Lcom/tencent/biz/pubaccount/PublicAccountManager$InitDoneObserver;
    //   243: invokeinterface 146 1 0
    //   248: return
    //   249: astore 4
    //   251: aconst_null
    //   252: astore 4
    //   254: goto -186 -> 68
    //   257: astore 6
    //   259: goto -191 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	bkf
    //   142	31	1	i	int
    //   136	19	2	l	long
    //   55	177	4	localObject1	Object
    //   249	1	4	localException1	java.lang.Exception
    //   252	1	4	localObject2	Object
    //   41	97	5	localPublicAccountMenuEntity	com.tencent.mobileqq.data.PublicAccountMenuEntity
    //   257	1	6	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   48	57	249	java/lang/Exception
    //   57	68	257	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkf
 * JD-Core Version:    0.7.0.1
 */