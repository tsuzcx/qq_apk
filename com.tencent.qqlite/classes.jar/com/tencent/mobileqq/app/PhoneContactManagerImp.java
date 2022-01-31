package com.tencent.mobileqq.app;

import SecurityAccountServer.AddressBookItem;
import SecurityAccountServer.MobileContactsDetailInfoEncrypt;
import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.ContentObserver;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PhoneNumInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cvj;
import cvl;
import cvm;
import cvn;
import cvo;
import cvp;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import oicq.wlogin_sdk.tools.MD5;

public class PhoneContactManagerImp
  implements PhoneContactManager
{
  static final long jdField_a_of_type_Long = 120000L;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "data1", "display_name", "contact_id" };
  public static int b = 0;
  public static int c = 0;
  public static boolean c = false;
  private static final boolean jdField_f_of_type_Boolean = true;
  public volatile int a;
  public SharedPreferences a;
  private ContentObserver jdField_a_of_type_AndroidDatabaseContentObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new cvj(this);
  private cvp jdField_a_of_type_Cvp;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public volatile boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  public long b;
  private SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences;
  private String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  volatile boolean jdField_b_of_type_Boolean;
  public long c;
  private String jdField_c_of_type_JavaLangString = "";
  private List jdField_c_of_type_JavaUtilList = null;
  private ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public long d;
  private List jdField_d_of_type_JavaUtilList = null;
  private ConcurrentHashMap jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean d;
  private ConcurrentHashMap jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_e_of_type_Boolean = false;
  private ConcurrentHashMap jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  static
  {
    jdField_c_of_type_Boolean = false;
    jdField_b_of_type_Int = 0;
    jdField_c_of_type_Int = 2;
  }
  
  public PhoneContactManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = false;
    this.f = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    this.jdField_b_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("contact_bind_info_global", 0);
    this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("session_id", "").getBytes();
    this.jdField_b_of_type_JavaLangString = d();
    this.jdField_a_of_type_Int = a(a());
    paramQQAppInterface = (ContactSyncManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    k();
    ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
  }
  
  private int a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    if (paramRespondQueryQQBindingStat == null) {}
    do
    {
      return 0;
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "getSelfBindState : " + this.jdField_b_of_type_JavaLangString + " " + paramRespondQueryQQBindingStat.mobileNo + " " + paramRespondQueryQQBindingStat.originBinder + " " + paramRespondQueryQQBindingStat.MobileUniqueNo + " " + paramRespondQueryQQBindingStat.lastUsedFlag + " " + paramRespondQueryQQBindingStat.isRecommend + " " + paramRespondQueryQQBindingStat.bindingTime);
      }
      if (TextUtils.isEmpty(paramRespondQueryQQBindingStat.mobileNo)) {
        return 1;
      }
      if ((paramRespondQueryQQBindingStat.originBinder == 2L) || (paramRespondQueryQQBindingStat.originBinder == 3L)) {
        return 2;
      }
    } while (paramRespondQueryQQBindingStat.originBinder != 1L);
    if (paramRespondQueryQQBindingStat.MobileUniqueNo.equals("init padding")) {
      paramRespondQueryQQBindingStat.MobileUniqueNo = null;
    }
    if (TextUtils.isEmpty(paramRespondQueryQQBindingStat.MobileUniqueNo)) {
      return 4;
    }
    if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(paramRespondQueryQQBindingStat.MobileUniqueNo)) {
      return 7;
    }
    return 3;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return paramString;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramString.length());
    int i = 0;
    if (i < paramString.length())
    {
      char c1 = paramString.charAt(i);
      if ((c1 == ' ') || (c1 == '-') || (c1 == ')') || (c1 == '(') || (c1 == '_')) {}
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append(c1);
      }
    }
    return localStringBuffer.toString();
  }
  
  private String a(String paramString1, String paramString2)
  {
    paramString1 = paramString1.getBytes();
    byte[] arrayOfByte = paramString2.getBytes();
    if (paramString1.length > 10)
    {
      paramString2 = new byte[10];
      System.arraycopy(paramString1, 0, paramString2, 0, 10);
      paramString1 = paramString2;
    }
    for (;;)
    {
      return MD5.toMD5(ByteBuffer.allocate(paramString1.length + arrayOfByte.length).put(paramString1).put(arrayOfByte).array());
    }
  }
  
  private String a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramString;
    }
    paramString = paramString.getBytes();
    int j = paramString.length;
    paramArrayOfByte = a(paramArrayOfByte);
    paramString = a(paramString);
    int i = 0;
    while (i < j)
    {
      paramArrayOfByte[i] = ((byte)(paramString[i] ^ paramArrayOfByte[i]));
      i += 1;
    }
    j = paramArrayOfByte.length;
    i = j - 1;
    if (i >= 0) {
      if (paramArrayOfByte[i] == 0) {}
    }
    for (;;)
    {
      if (i != j - 1)
      {
        paramString = new byte[i + 1];
        System.arraycopy(paramArrayOfByte, 0, paramString, 0, i + 1);
        paramArrayOfByte = paramString;
      }
      for (;;)
      {
        return new String(a(paramArrayOfByte));
        i -= 1;
        break;
      }
      i = 0;
    }
  }
  
  /* Error */
  private ArrayList a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: invokespecial 310	com/tencent/mobileqq/app/PhoneContactManagerImp:l	()V
    //   7: aload_0
    //   8: getfield 102	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokevirtual 107	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   14: invokevirtual 314	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   17: getstatic 320	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   20: getstatic 43	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokevirtual 326	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore 4
    //   31: new 328	java/util/ArrayList
    //   34: dup
    //   35: invokespecial 329	java/util/ArrayList:<init>	()V
    //   38: astore 7
    //   40: aload 4
    //   42: ifnull +521 -> 563
    //   45: invokestatic 333	java/lang/System:currentTimeMillis	()J
    //   48: lstore_2
    //   49: aload 4
    //   51: invokeinterface 338 1 0
    //   56: istore_1
    //   57: aload 7
    //   59: iload_1
    //   60: invokevirtual 341	java/util/ArrayList:ensureCapacity	(I)V
    //   63: new 66	java/util/concurrent/ConcurrentHashMap
    //   66: dup
    //   67: iload_1
    //   68: invokespecial 342	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   71: astore 8
    //   73: aload 6
    //   75: astore 5
    //   77: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +34 -> 114
    //   83: aload 6
    //   85: astore 5
    //   87: ldc_w 344
    //   90: iconst_2
    //   91: new 109	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 346
    //   101: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: iload_1
    //   105: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   108: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload 6
    //   116: astore 5
    //   118: aload_0
    //   119: getfield 102	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   122: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   125: invokestatic 192	com/tencent/mobileqq/utils/ChnToSpell:a	(Landroid/content/Context;)V
    //   128: aload 6
    //   130: astore 5
    //   132: aload_0
    //   133: getfield 176	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   136: invokevirtual 354	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   139: astore 6
    //   141: aload 6
    //   143: astore 5
    //   145: aload 6
    //   147: invokevirtual 358	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   150: aload 6
    //   152: astore 5
    //   154: aload 4
    //   156: invokeinterface 361 1 0
    //   161: pop
    //   162: aload 6
    //   164: astore 5
    //   166: aload 4
    //   168: invokeinterface 364 1 0
    //   173: ifne +296 -> 469
    //   176: aload 6
    //   178: astore 5
    //   180: aload 4
    //   182: aload 4
    //   184: ldc 37
    //   186: invokeinterface 368 2 0
    //   191: invokeinterface 371 2 0
    //   196: invokestatic 373	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   199: astore 9
    //   201: aload 6
    //   203: astore 5
    //   205: aload 4
    //   207: aload 4
    //   209: ldc 39
    //   211: invokeinterface 368 2 0
    //   216: invokeinterface 371 2 0
    //   221: astore 10
    //   223: aload 6
    //   225: astore 5
    //   227: aload 4
    //   229: aload 4
    //   231: ldc 41
    //   233: invokeinterface 368 2 0
    //   238: invokeinterface 377 2 0
    //   243: istore_1
    //   244: aload 6
    //   246: astore 5
    //   248: aload 9
    //   250: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   253: ifne +15 -> 268
    //   256: aload 6
    //   258: astore 5
    //   260: aload 10
    //   262: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   265: ifeq +53 -> 318
    //   268: aload 6
    //   270: astore 5
    //   272: aload 4
    //   274: invokeinterface 380 1 0
    //   279: pop
    //   280: goto -118 -> 162
    //   283: astore 6
    //   285: aload 5
    //   287: ifnull +8 -> 295
    //   290: aload 5
    //   292: invokevirtual 382	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   295: aload 4
    //   297: invokeinterface 385 1 0
    //   302: aload 6
    //   304: athrow
    //   305: astore 4
    //   307: aload 4
    //   309: invokevirtual 388	java/lang/Exception:printStackTrace	()V
    //   312: aconst_null
    //   313: astore 4
    //   315: goto -284 -> 31
    //   318: aload 6
    //   320: astore 5
    //   322: new 390	com/tencent/mobileqq/data/PhoneContact
    //   325: dup
    //   326: invokespecial 391	com/tencent/mobileqq/data/PhoneContact:<init>	()V
    //   329: astore 11
    //   331: aload 6
    //   333: astore 5
    //   335: aload 11
    //   337: aload 9
    //   339: putfield 392	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   342: aload 6
    //   344: astore 5
    //   346: aload 11
    //   348: aload 10
    //   350: putfield 395	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   353: aload 6
    //   355: astore 5
    //   357: aload 11
    //   359: iload_1
    //   360: putfield 398	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   363: aload 6
    //   365: astore 5
    //   367: aload 11
    //   369: lload_2
    //   370: putfield 401	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   373: aload 6
    //   375: astore 5
    //   377: aload 11
    //   379: aload 10
    //   381: iconst_1
    //   382: invokestatic 404	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   385: putfield 407	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   388: aload 6
    //   390: astore 5
    //   392: aload 11
    //   394: aload 10
    //   396: iconst_2
    //   397: invokestatic 404	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   400: putfield 410	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   403: aload 6
    //   405: astore 5
    //   407: aload 11
    //   409: aload_0
    //   410: aload 10
    //   412: aload 9
    //   414: invokespecial 412	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   417: putfield 415	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   420: aload 6
    //   422: astore 5
    //   424: aload 8
    //   426: aload 9
    //   428: aload 11
    //   430: invokevirtual 418	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   433: pop
    //   434: aload 6
    //   436: astore 5
    //   438: aload_0
    //   439: getfield 92	com/tencent/mobileqq/app/PhoneContactManagerImp:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   442: aload 11
    //   444: getfield 415	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   447: aload 11
    //   449: invokevirtual 418	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   452: pop
    //   453: aload 6
    //   455: astore 5
    //   457: aload_0
    //   458: getfield 176	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   461: aload 11
    //   463: invokevirtual 421	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   466: goto -198 -> 268
    //   469: aload 6
    //   471: astore 5
    //   473: aload 6
    //   475: invokevirtual 423	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   478: aload 6
    //   480: ifnull +8 -> 488
    //   483: aload 6
    //   485: invokevirtual 382	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   488: aload 4
    //   490: invokeinterface 385 1 0
    //   495: aload_0
    //   496: aload 8
    //   498: invokespecial 426	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/util/concurrent/ConcurrentHashMap;)V
    //   501: aload_0
    //   502: getfield 86	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   505: invokevirtual 430	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   508: invokeinterface 436 1 0
    //   513: astore 4
    //   515: aload 4
    //   517: invokeinterface 441 1 0
    //   522: ifeq +41 -> 563
    //   525: aload 4
    //   527: invokeinterface 445 1 0
    //   532: checkcast 390	com/tencent/mobileqq/data/PhoneContact
    //   535: astore 5
    //   537: aload 7
    //   539: new 447	SecurityAccountServer/AddressBookItem
    //   542: dup
    //   543: aload 5
    //   545: getfield 392	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   548: aload 5
    //   550: getfield 395	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   553: invokespecial 450	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   556: invokevirtual 453	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   559: pop
    //   560: goto -45 -> 515
    //   563: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   566: ifeq +34 -> 600
    //   569: ldc_w 344
    //   572: iconst_2
    //   573: new 109	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   580: ldc_w 455
    //   583: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: aload 7
    //   588: invokevirtual 458	java/util/ArrayList:size	()I
    //   591: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   594: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   600: aload 7
    //   602: areturn
    //   603: astore 4
    //   605: goto -110 -> 495
    //   608: astore 4
    //   610: goto -308 -> 302
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	613	0	this	PhoneContactManagerImp
    //   56	304	1	i	int
    //   48	322	2	l	long
    //   29	267	4	localCursor	android.database.Cursor
    //   305	3	4	localException1	Exception
    //   313	213	4	localIterator	Iterator
    //   603	1	4	localException2	Exception
    //   608	1	4	localException3	Exception
    //   75	474	5	localObject1	Object
    //   1	268	6	localEntityTransaction	EntityTransaction
    //   283	201	6	localObject2	Object
    //   38	563	7	localArrayList	ArrayList
    //   71	426	8	localConcurrentHashMap	ConcurrentHashMap
    //   199	228	9	str1	String
    //   221	190	10	str2	String
    //   329	133	11	localPhoneContact	PhoneContact
    // Exception table:
    //   from	to	target	type
    //   77	83	283	finally
    //   87	114	283	finally
    //   118	128	283	finally
    //   132	141	283	finally
    //   145	150	283	finally
    //   154	162	283	finally
    //   166	176	283	finally
    //   180	201	283	finally
    //   205	223	283	finally
    //   227	244	283	finally
    //   248	256	283	finally
    //   260	268	283	finally
    //   272	280	283	finally
    //   322	331	283	finally
    //   335	342	283	finally
    //   346	353	283	finally
    //   357	363	283	finally
    //   367	373	283	finally
    //   377	388	283	finally
    //   392	403	283	finally
    //   407	420	283	finally
    //   424	434	283	finally
    //   438	453	283	finally
    //   457	466	283	finally
    //   473	478	283	finally
    //   7	31	305	java/lang/Exception
    //   488	495	603	java/lang/Exception
    //   295	302	608	java/lang/Exception
  }
  
  /* Error */
  private ArrayList a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    // Byte code:
    //   0: new 463	java/util/HashMap
    //   3: dup
    //   4: invokespecial 464	java/util/HashMap:<init>	()V
    //   7: astore 10
    //   9: new 328	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 329	java/util/ArrayList:<init>	()V
    //   16: astore 9
    //   18: invokestatic 333	java/lang/System:currentTimeMillis	()J
    //   21: lstore 4
    //   23: aload_0
    //   24: getfield 102	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: invokevirtual 107	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   30: invokevirtual 314	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   33: astore 6
    //   35: aload 6
    //   37: getstatic 320	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   40: getstatic 43	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokevirtual 326	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore 6
    //   51: aload 6
    //   53: ifnull +734 -> 787
    //   56: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +36 -> 95
    //   62: ldc_w 344
    //   65: iconst_2
    //   66: new 109	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 466
    //   76: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 6
    //   81: invokeinterface 338 1 0
    //   86: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aconst_null
    //   96: astore 8
    //   98: aload_0
    //   99: getfield 102	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   102: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   105: invokestatic 192	com/tencent/mobileqq/utils/ChnToSpell:a	(Landroid/content/Context;)V
    //   108: aload_0
    //   109: getfield 176	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   112: invokevirtual 354	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   115: astore 7
    //   117: aload 7
    //   119: invokevirtual 358	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   122: aload 6
    //   124: invokeinterface 361 1 0
    //   129: pop
    //   130: aload 6
    //   132: invokeinterface 364 1 0
    //   137: ifne +445 -> 582
    //   140: aload 6
    //   142: aload 6
    //   144: ldc 37
    //   146: invokeinterface 368 2 0
    //   151: invokeinterface 371 2 0
    //   156: invokestatic 373	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   159: astore 8
    //   161: aload 6
    //   163: aload 6
    //   165: ldc 39
    //   167: invokeinterface 368 2 0
    //   172: invokeinterface 371 2 0
    //   177: astore 11
    //   179: aload 6
    //   181: aload 6
    //   183: ldc 41
    //   185: invokeinterface 368 2 0
    //   190: invokeinterface 377 2 0
    //   195: istore_3
    //   196: aload 8
    //   198: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   201: ifne +11 -> 212
    //   204: aload 11
    //   206: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   209: ifeq +43 -> 252
    //   212: aload 6
    //   214: invokeinterface 380 1 0
    //   219: pop
    //   220: goto -90 -> 130
    //   223: astore_1
    //   224: aload 7
    //   226: astore_2
    //   227: aload_2
    //   228: ifnull +7 -> 235
    //   231: aload_2
    //   232: invokevirtual 382	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   235: aload 6
    //   237: invokeinterface 385 1 0
    //   242: aload_1
    //   243: athrow
    //   244: astore 6
    //   246: aconst_null
    //   247: astore 6
    //   249: goto -198 -> 51
    //   252: aload_0
    //   253: getfield 86	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   256: aload 8
    //   258: invokevirtual 470	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   261: checkcast 390	com/tencent/mobileqq/data/PhoneContact
    //   264: astore 12
    //   266: aload 12
    //   268: ifnonnull +128 -> 396
    //   271: new 390	com/tencent/mobileqq/data/PhoneContact
    //   274: dup
    //   275: invokespecial 391	com/tencent/mobileqq/data/PhoneContact:<init>	()V
    //   278: astore 12
    //   280: aload 12
    //   282: aload 8
    //   284: putfield 392	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   287: aload 12
    //   289: aload 11
    //   291: putfield 395	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   294: aload 12
    //   296: iload_3
    //   297: putfield 398	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   300: aload 12
    //   302: lload 4
    //   304: putfield 401	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   307: aload 12
    //   309: aload 11
    //   311: iconst_1
    //   312: invokestatic 404	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   315: putfield 407	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   318: aload 12
    //   320: aload 11
    //   322: iconst_2
    //   323: invokestatic 404	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   326: putfield 410	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   329: aload_0
    //   330: getfield 86	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   333: aload 8
    //   335: aload 12
    //   337: invokevirtual 418	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   340: pop
    //   341: aload 12
    //   343: aload_0
    //   344: aload 11
    //   346: aload 8
    //   348: invokespecial 412	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   351: putfield 415	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   354: aload_0
    //   355: getfield 92	com/tencent/mobileqq/app/PhoneContactManagerImp:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   358: aload 12
    //   360: getfield 415	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   363: aload 12
    //   365: invokevirtual 418	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   368: pop
    //   369: aload 9
    //   371: aload 12
    //   373: invokevirtual 453	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   376: pop
    //   377: aload_1
    //   378: new 447	SecurityAccountServer/AddressBookItem
    //   381: dup
    //   382: aload 8
    //   384: aload 11
    //   386: invokespecial 450	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   389: invokevirtual 453	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   392: pop
    //   393: goto -181 -> 212
    //   396: aload 12
    //   398: iload_3
    //   399: putfield 398	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   402: aload 12
    //   404: lload 4
    //   406: putfield 401	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   409: aload 12
    //   411: getfield 415	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   414: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   417: ifeq +34 -> 451
    //   420: aload 12
    //   422: aload_0
    //   423: aload 12
    //   425: getfield 395	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   428: aload 8
    //   430: invokespecial 412	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   433: putfield 415	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   436: aload_0
    //   437: getfield 92	com/tencent/mobileqq/app/PhoneContactManagerImp:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   440: aload 12
    //   442: getfield 415	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   445: aload 12
    //   447: invokevirtual 418	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   450: pop
    //   451: aload 12
    //   453: getfield 473	com/tencent/mobileqq/data/PhoneContact:isUploaded	Z
    //   456: ifeq +99 -> 555
    //   459: aload 11
    //   461: aload 12
    //   463: getfield 395	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   466: invokevirtual 246	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   469: ifne +75 -> 544
    //   472: aload 10
    //   474: aload 8
    //   476: aload 11
    //   478: invokevirtual 474	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   481: pop
    //   482: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   485: ifeq -273 -> 212
    //   488: ldc_w 344
    //   491: iconst_2
    //   492: new 109	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   499: ldc_w 476
    //   502: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: aload 12
    //   507: getfield 395	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   510: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: ldc_w 478
    //   516: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: aload 11
    //   521: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: ldc_w 480
    //   527: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload 8
    //   532: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   541: goto -329 -> 212
    //   544: aload 10
    //   546: aload 8
    //   548: invokevirtual 483	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   551: pop
    //   552: goto -340 -> 212
    //   555: aload_1
    //   556: new 447	SecurityAccountServer/AddressBookItem
    //   559: dup
    //   560: aload 8
    //   562: aload 11
    //   564: invokespecial 450	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   567: invokevirtual 453	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   570: pop
    //   571: aload 9
    //   573: aload 12
    //   575: invokevirtual 453	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   578: pop
    //   579: goto -367 -> 212
    //   582: aload 10
    //   584: invokevirtual 487	java/util/HashMap:keySet	()Ljava/util/Set;
    //   587: invokeinterface 490 1 0
    //   592: astore 8
    //   594: aload 8
    //   596: invokeinterface 441 1 0
    //   601: ifeq +164 -> 765
    //   604: aload 8
    //   606: invokeinterface 445 1 0
    //   611: checkcast 35	java/lang/String
    //   614: astore 11
    //   616: aload_0
    //   617: getfield 86	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   620: aload 11
    //   622: invokevirtual 470	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   625: checkcast 390	com/tencent/mobileqq/data/PhoneContact
    //   628: astore 12
    //   630: aload 12
    //   632: ifnull -38 -> 594
    //   635: aload 10
    //   637: aload 11
    //   639: invokevirtual 491	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   642: checkcast 35	java/lang/String
    //   645: astore 13
    //   647: aload_2
    //   648: new 447	SecurityAccountServer/AddressBookItem
    //   651: dup
    //   652: aload 11
    //   654: aload 12
    //   656: getfield 395	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   659: invokespecial 450	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   662: invokevirtual 453	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   665: pop
    //   666: aload_1
    //   667: new 447	SecurityAccountServer/AddressBookItem
    //   670: dup
    //   671: aload 11
    //   673: aload 13
    //   675: invokespecial 450	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   678: invokevirtual 453	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   681: pop
    //   682: aload 12
    //   684: aload 13
    //   686: putfield 395	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   689: aload 12
    //   691: aload 13
    //   693: iconst_1
    //   694: invokestatic 404	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   697: putfield 407	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   700: aload 12
    //   702: aload 13
    //   704: iconst_2
    //   705: invokestatic 404	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   708: putfield 410	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   711: aload_0
    //   712: getfield 92	com/tencent/mobileqq/app/PhoneContactManagerImp:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   715: aload 12
    //   717: getfield 415	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   720: aload 12
    //   722: invokevirtual 494	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   725: pop
    //   726: aload 12
    //   728: aload_0
    //   729: aload 13
    //   731: aload 11
    //   733: invokespecial 412	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   736: putfield 415	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   739: aload_0
    //   740: getfield 92	com/tencent/mobileqq/app/PhoneContactManagerImp:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   743: aload 12
    //   745: getfield 415	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   748: aload 12
    //   750: invokevirtual 418	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   753: pop
    //   754: aload 9
    //   756: aload 12
    //   758: invokevirtual 453	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   761: pop
    //   762: goto -168 -> 594
    //   765: aload 7
    //   767: invokevirtual 423	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   770: aload 7
    //   772: ifnull +8 -> 780
    //   775: aload 7
    //   777: invokevirtual 382	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   780: aload 6
    //   782: invokeinterface 385 1 0
    //   787: aload_2
    //   788: invokevirtual 458	java/util/ArrayList:size	()I
    //   791: ifeq +3 -> 794
    //   794: aload_0
    //   795: iconst_0
    //   796: putfield 84	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_Boolean	Z
    //   799: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   802: ifeq +35 -> 837
    //   805: ldc_w 344
    //   808: iconst_2
    //   809: new 109	java/lang/StringBuilder
    //   812: dup
    //   813: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   816: ldc_w 496
    //   819: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: invokestatic 333	java/lang/System:currentTimeMillis	()J
    //   825: lload 4
    //   827: lsub
    //   828: invokevirtual 215	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   831: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   834: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   837: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   840: ifeq +33 -> 873
    //   843: ldc_w 344
    //   846: iconst_2
    //   847: new 109	java/lang/StringBuilder
    //   850: dup
    //   851: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   854: ldc_w 498
    //   857: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: aload_1
    //   861: invokevirtual 458	java/util/ArrayList:size	()I
    //   864: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   867: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   870: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   873: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   876: ifeq +33 -> 909
    //   879: ldc_w 344
    //   882: iconst_2
    //   883: new 109	java/lang/StringBuilder
    //   886: dup
    //   887: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   890: ldc_w 500
    //   893: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: aload_2
    //   897: invokevirtual 458	java/util/ArrayList:size	()I
    //   900: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   903: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   906: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   909: aload 9
    //   911: areturn
    //   912: astore 6
    //   914: goto -127 -> 787
    //   917: astore_2
    //   918: goto -676 -> 242
    //   921: astore_1
    //   922: aload 8
    //   924: astore_2
    //   925: goto -698 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	928	0	this	PhoneContactManagerImp
    //   0	928	1	paramArrayList1	ArrayList
    //   0	928	2	paramArrayList2	ArrayList
    //   195	204	3	i	int
    //   21	805	4	l	long
    //   33	203	6	localObject1	Object
    //   244	1	6	localThrowable	Throwable
    //   247	534	6	localObject2	Object
    //   912	1	6	localException	Exception
    //   115	661	7	localEntityTransaction	EntityTransaction
    //   96	827	8	localObject3	Object
    //   16	894	9	localArrayList	ArrayList
    //   7	629	10	localHashMap	java.util.HashMap
    //   177	555	11	str1	String
    //   264	493	12	localPhoneContact	PhoneContact
    //   645	85	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   117	130	223	finally
    //   130	212	223	finally
    //   212	220	223	finally
    //   252	266	223	finally
    //   271	393	223	finally
    //   396	451	223	finally
    //   451	541	223	finally
    //   544	552	223	finally
    //   555	579	223	finally
    //   582	594	223	finally
    //   594	630	223	finally
    //   635	762	223	finally
    //   765	770	223	finally
    //   35	51	244	java/lang/Throwable
    //   780	787	912	java/lang/Exception
    //   235	242	917	java/lang/Exception
    //   98	117	921	finally
  }
  
  private void a(int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 29);
    localNewIntent.putExtra("next_flag", 0L);
    localNewIntent.putExtra("getRecommendedTimeStamp", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("getRecommendedTimeStamp", 0L));
    localNewIntent.putExtra("session_id", new byte[0]);
    localNewIntent.putExtra("recommend_type", paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("queryContactTimeStamp", paramLong).commit();
  }
  
  private void a(String paramString, ArrayList paramArrayList)
  {
    if (paramString == null) {
      return;
    }
    ArrayList localArrayList = paramArrayList;
    if (paramArrayList == null) {
      localArrayList = new ArrayList(0);
    }
    paramArrayList = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    paramArrayList.putExtra("req_type", 14);
    paramArrayList.putExtra("unique_phone_no", paramString);
    paramArrayList.putExtra("next_flag", 0L);
    paramArrayList.putExtra("upload_package_no", 0);
    paramArrayList.putExtra("contact_list", localArrayList);
    paramArrayList.putExtra("session_id", new byte[0]);
    paramArrayList.putExtra("is_resend", false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramArrayList);
    this.jdField_d_of_type_Long = System.currentTimeMillis();
  }
  
  private void a(String paramString, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    if (paramString == null) {}
    while ((paramArrayList1 == null) && (paramArrayList2 == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 15);
    localNewIntent.putExtra("unique_phone_no", paramString);
    localNewIntent.putExtra("add_contact_list", paramArrayList1);
    localNewIntent.putExtra("del_contact_list", paramArrayList2);
    localNewIntent.putExtra("rename_contact_list", paramArrayList3);
    localNewIntent.putExtra("next_flag", 0L);
    localNewIntent.putExtra("upload_package_no", 0);
    localNewIntent.putExtra("session_id", new byte[0]);
    localNewIntent.putExtra("is_resend", false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  private void a(ConcurrentHashMap paramConcurrentHashMap)
  {
    Object localObject1 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      PhoneContact localPhoneContact = (PhoneContact)((Map.Entry)localObject2).getValue();
      localObject2 = (PhoneContact)paramConcurrentHashMap.get(((Map.Entry)localObject2).getKey());
      if ((localObject2 != null) && (localPhoneContact != null))
      {
        ((PhoneContact)localObject2).uin = localPhoneContact.uin;
        ((PhoneContact)localObject2).nationCode = localPhoneContact.nationCode;
        ((PhoneContact)localObject2).mobileCode = localPhoneContact.mobileCode;
        ((PhoneContact)localObject2).bindingDate = localPhoneContact.bindingDate;
        ((PhoneContact)localObject2).nickName = localPhoneContact.nickName;
        ((PhoneContact)localObject2).isUploaded = localPhoneContact.isUploaded;
        ((PhoneContact)localObject2).originBinder = localPhoneContact.originBinder;
        ((PhoneContact)localObject2).ability = localPhoneContact.ability;
      }
    }
    localObject1 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = paramConcurrentHashMap;
    ((ConcurrentHashMap)localObject1).clear();
  }
  
  private boolean a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    int i = a(paramRespondQueryQQBindingStat);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "syncBindState newState = " + i);
    }
    switch (i)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 0) {
        this.jdField_a_of_type_Int = i;
      }
      return bool1;
      if (this.jdField_a_of_type_Int != i) {
        o();
      }
      this.jdField_a_of_type_Int = i;
      continue;
      if (paramRespondQueryQQBindingStat.lastUsedFlag == 2L) {
        bool1 = true;
      }
      for (;;)
      {
        this.jdField_a_of_type_Int = i;
        break;
        bool1 = bool2;
        if (paramRespondQueryQQBindingStat.lastUsedFlag == 3L)
        {
          o();
          bool1 = bool2;
        }
      }
      this.jdField_a_of_type_Int = i;
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    int j = 0;
    int k = paramArrayOfByte.length - 1;
    while (k > j * 2)
    {
      int i = paramArrayOfByte[j];
      paramArrayOfByte[j] = paramArrayOfByte[(k - j)];
      paramArrayOfByte[(k - j)] = i;
      j += 1;
    }
    return paramArrayOfByte;
  }
  
  private String d()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("contact_bind_info_unique", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      return localObject1;
    }
    Object localObject2 = e();
    localObject1 = localObject2;
    if (((String)localObject2).equals("|")) {
      localObject1 = e();
    }
    localObject2 = localObject1;
    if (((String)localObject1).equals("|"))
    {
      localObject1 = new Random();
      localObject2 = ((Random)localObject1).nextLong() + "|" + ((Random)localObject1).nextLong();
    }
    localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject1).putString("contact_bind_info_unique", (String)localObject2);
    ((SharedPreferences.Editor)localObject1).commit();
    return localObject2;
  }
  
  private String e()
  {
    try
    {
      str1 = ((TelephonyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSystemService("phone")).getDeviceId();
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          String str1;
          String str2 = ((WifiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSystemService("wifi")).getConnectionInfo().getMacAddress();
          return str1 + "|" + str2;
          localException1 = localException1;
          Object localObject1 = null;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
    }
  }
  
  private static String e(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (paramString = "#";; paramString = String.valueOf(paramString.charAt(0)).toUpperCase())
    {
      String str = paramString;
      if (!StringUtil.c(paramString.charAt(0))) {
        str = "#";
      }
      return str;
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidDatabaseContentObserver = new cvl(this, new Handler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getMainLooper()));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, true, this.jdField_a_of_type_AndroidDatabaseContentObserver);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PhoneContact", 2, localThrowable.getMessage(), localThrowable);
    }
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "preLoadLocalContact");
    }
    a(0L);
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.f.clear();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new PhoneContact().getTableName(), null, null);
      g();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void m()
  {
    if ((this.jdField_b_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_b_of_type_Long < 120000L)) {
      return;
    }
    this.jdField_a_of_type_Int = 9;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_b_of_type_JavaUtilList = null;
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 28);
    localNewIntent.putExtra("next_flag", 0L);
    localNewIntent.putExtra("time_stamp", this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryContactTimeStamp", 0L));
    localNewIntent.putExtra("session_id", new byte[0]);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  private void n()
  {
    try
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = a(localArrayList1, localArrayList2);
      if ((!localArrayList1.isEmpty()) || (!localArrayList2.isEmpty()))
      {
        a(this.jdField_b_of_type_JavaLangString, localArrayList1, localArrayList2, localArrayList3);
        e();
      }
      return;
    }
    finally {}
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("contact_bind_info_upload", false).commit();
    p();
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "deleteLocalData");
    }
    this.jdField_b_of_type_Boolean = false;
    a(0L);
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.f.clear();
    e();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new PhoneContact().getTableName(), null, null);
      g();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public int a()
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = a();
    if (localRespondQueryQQBindingStat == null) {
      return jdField_c_of_type_Int;
    }
    if (this.jdField_a_of_type_Cvp != null) {
      this.jdField_a_of_type_Cvp.cancel(true);
    }
    this.jdField_a_of_type_Cvp = new cvp(this, null);
    this.jdField_a_of_type_Cvp.execute(new RespondQueryQQBindingStat[] { localRespondQueryQQBindingStat });
    return jdField_b_of_type_Int;
  }
  
  public RespondQueryQQBindingStat a()
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = new RespondQueryQQBindingStat();
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    if (localSharedPreferences == null) {}
    do
    {
      return null;
      localRespondQueryQQBindingStat.nationCode = localSharedPreferences.getString("contact_bind_info_nation", null);
    } while (localRespondQueryQQBindingStat.nationCode == null);
    localRespondQueryQQBindingStat.mobileNo = localSharedPreferences.getString("contact_bind_info_mobile", "");
    localRespondQueryQQBindingStat.MobileUniqueNo = localSharedPreferences.getString("contact_bind_info_imei", "");
    localRespondQueryQQBindingStat.isRecommend = localSharedPreferences.getLong("contact_bind_info_recommend", 0L);
    localRespondQueryQQBindingStat.originBinder = localSharedPreferences.getLong("contact_bind_info_origin", 0L);
    localRespondQueryQQBindingStat.bindingTime = localSharedPreferences.getLong("contact_bind_info_time", 0L);
    localRespondQueryQQBindingStat.lastUsedFlag = localSharedPreferences.getLong("contact_bind_info_flag", 0L);
    return localRespondQueryQQBindingStat;
  }
  
  public PhoneContact a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (PhoneContact)this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public List a()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        localArrayList.addAll(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values());
        return localArrayList;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContactManager", 2, localException.toString());
        }
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class);
  }
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidDatabaseContentObserver != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver().unregisterContentObserver(this.jdField_a_of_type_AndroidDatabaseContentObserver);
      this.jdField_a_of_type_AndroidDatabaseContentObserver = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact", 2, localThrowable.getMessage(), localThrowable);
        }
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("contact_bind_strategy_version", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactManager", 2, "localVersion=" + l + "|configVersion=" + paramLong1 + "|popWindowsCount=" + paramLong2 + "|popWindowsTime=" + paramLong3 + "|popCloseCount=" + paramLong4);
    }
    if (l != paramLong1)
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      l = paramLong3;
      if (paramLong3 < 86400L) {
        l = 86400L;
      }
      paramLong3 = paramLong2;
      if (paramLong2 <= 0L) {
        paramLong3 = 1L;
      }
      localEditor.putLong("contact_bind_strategy_version", paramLong1);
      localEditor.putLong("contact_bind_strategy_popcount", paramLong3);
      localEditor.putLong("contact_bind_strategy_poptime", l);
      localEditor.putLong("contact_bind_strategy_closecount", paramLong4);
      localEditor.putLong("contact_bind_strategy_forcepopup", paramLong5);
      localEditor.putLong("contact_bind_strategy_user_closecount", 0L);
      localEditor.commit();
      ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void a(long paramLong1, long paramLong2, List paramList1, List paramList2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "saveContactFromServer start");
      }
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = paramList1;
      }
      while (paramLong1 != 4294967295L)
      {
        return;
        this.jdField_a_of_type_JavaUtilList.addAll(paramList1);
      }
      paramLong1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryContactTimeStamp", 0L);
    }
    finally {}
    a(paramLong2);
    Object localObject1;
    if ((paramLong1 != 0L) && (paramLong1 != paramLong2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "saveContactFromServer localTimestamp != timestamp");
      }
      this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      paramList1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      paramList1.a();
      try
      {
        paramList2 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.elements();
        while (paramList2.hasMoreElements())
        {
          localObject1 = (PhoneContact)paramList2.nextElement();
          if ((((PhoneContact)localObject1).uin != null) && (((PhoneContact)localObject1).uin.length() > 0))
          {
            ((PhoneContact)localObject1).bindingDate = 0L;
            ((PhoneContact)localObject1).isRecommend = 0;
            ((PhoneContact)localObject1).uin = "";
            ((PhoneContact)localObject1).originBinder = 0L;
            ((PhoneContact)localObject1).ability = 0;
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject1);
          }
        }
      }
      finally
      {
        paramList1.b();
      }
      paramList1.b();
    }
    boolean bool;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      paramList1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      paramList2 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      try
      {
        paramList1.a();
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContact", 2, "md52PhoneContact size = " + this.f.size());
          }
          localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (MobileContactsDetailInfoEncrypt)((Iterator)localObject1).next();
            PhoneContact localPhoneContact = (PhoneContact)this.f.get(((MobileContactsDetailInfoEncrypt)localObject2).contactsInfoEncrypt.toUpperCase());
            if (localPhoneContact != null)
            {
              localPhoneContact.uin = ((MobileContactsDetailInfoEncrypt)localObject2).QQ;
              localPhoneContact.bindingDate = ((MobileContactsDetailInfoEncrypt)localObject2).bindingDate;
              localPhoneContact.nickName = ((MobileContactsDetailInfoEncrypt)localObject2).nickname;
              localPhoneContact.isUploaded = true;
              localPhoneContact.originBinder = ((MobileContactsDetailInfoEncrypt)localObject2).originBinder;
              localPhoneContact.ability = ((MobileContactsDetailInfoEncrypt)localObject2).accountAbi;
              localPhoneContact.unifiedCode = a(((MobileContactsDetailInfoEncrypt)localObject2).MobileNoMask, localPhoneContact.mobileNo);
              localPhoneContact.mobileCode = localPhoneContact.unifiedCode;
              localPhoneContact.nationCode = "";
              localPhoneContact.isUpdated = true;
              if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!localPhoneContact.uin.equals("0")))
              {
                localObject2 = paramList2.c(localPhoneContact.uin);
                if (localObject2 != null) {
                  localPhoneContact.nickName = ((Friends)localObject2).name;
                }
                this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.uin, localPhoneContact);
                paramList2.a(localPhoneContact.unifiedCode, false);
              }
              if (!TextUtils.isEmpty(localPhoneContact.unifiedCode)) {
                this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.unifiedCode, localPhoneContact);
              }
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localPhoneContact);
            }
          }
        }
        paramList2 = this.f.entrySet().iterator();
      }
      finally
      {
        paramList1.b();
      }
      bool = false;
      label659:
      if (paramList2.hasNext())
      {
        localObject1 = (PhoneContact)((Map.Entry)paramList2.next()).getValue();
        if (!((PhoneContact)localObject1).isUpdated)
        {
          if ((!TextUtils.isEmpty(((PhoneContact)localObject1).uin)) && (!((PhoneContact)localObject1).uin.equals("0"))) {
            this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((PhoneContact)localObject1).uin);
          }
          ((PhoneContact)localObject1).uin = "";
          ((PhoneContact)localObject1).isUploaded = true;
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject1);
          bool = true;
          break label853;
        }
        ((PhoneContact)localObject1).isUpdated = false;
        break label853;
      }
      paramList1.c();
      paramList1.b();
      break label856;
    }
    for (;;)
    {
      if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0) {
        this.jdField_b_of_type_Boolean = true;
      }
      this.jdField_a_of_type_JavaUtilList = null;
      this.jdField_b_of_type_JavaUtilList = null;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PhoneContact", 2, "saveContactFromServer end hasNoBindData = " + bool);
      break;
      bool = false;
      break label856;
      label853:
      break label659;
      label856:
      if (!bool) {}
    }
  }
  
  public void a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = a(a());
    }
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = paramRespondQueryQQBindingStat;
    if (paramRespondQueryQQBindingStat == null) {
      localRespondQueryQQBindingStat = new RespondQueryQQBindingStat();
    }
    paramRespondQueryQQBindingStat = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    paramRespondQueryQQBindingStat.putString("contact_bind_info_mobile", localRespondQueryQQBindingStat.mobileNo);
    paramRespondQueryQQBindingStat.putString("contact_bind_info_nation", localRespondQueryQQBindingStat.nationCode);
    paramRespondQueryQQBindingStat.putString("contact_bind_info_imei", localRespondQueryQQBindingStat.MobileUniqueNo);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_recommend", localRespondQueryQQBindingStat.isRecommend);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_origin", localRespondQueryQQBindingStat.originBinder);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_time", localRespondQueryQQBindingStat.bindingTime);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_flag", localRespondQueryQQBindingStat.lastUsedFlag);
    paramRespondQueryQQBindingStat.commit();
    if (a(localRespondQueryQQBindingStat)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new cvo(this));
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, 0);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 16);
    localNewIntent.putExtra("verify_smscode", paramString);
    localNewIntent.putExtra("session_id", this.jdField_a_of_type_ArrayOfByte);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 0);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 13);
    localNewIntent.putExtra("country_code", paramString1);
    localNewIntent.putExtra("phone_number", paramString2);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactManager", 2, "updateRenameList");
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    EntityTransaction localEntityTransaction;
    label135:
    do
    {
      for (;;)
      {
        return;
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        try
        {
          localEntityTransaction.a();
          paramArrayList = paramArrayList.iterator();
          for (;;)
          {
            if (!paramArrayList.hasNext()) {
              break label135;
            }
            localPhoneContact = (PhoneContact)paramArrayList.next();
            if (localPhoneContact.getStatus() != 1000) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localPhoneContact);
          }
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            PhoneContact localPhoneContact;
            if (QLog.isColorLevel()) {
              QLog.d("PhoneContactManager", 2, paramArrayList.getMessage());
            }
            return;
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localPhoneContact);
          }
        }
        finally
        {
          if (localEntityTransaction != null) {
            localEntityTransaction.b();
          }
        }
      }
      localEntityTransaction.c();
    } while (localEntityTransaction == null);
    localEntityTransaction.b();
  }
  
  public void a(List paramList)
  {
    Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ContactListView.class);
    if (localHandler != null)
    {
      localHandler.removeMessages(5);
      Message localMessage = localHandler.obtainMessage(5);
      localMessage.obj = paramList;
      localHandler.sendMessageDelayed(localMessage, 100L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((g()) && ((paramBoolean) || (this.jdField_d_of_type_Boolean))) {
      n();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("session_id", new String(paramArrayOfByte)).commit();
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactManager", 2, "onFirstQueryResp" + jdField_c_of_type_Boolean);
    }
    for (;;)
    {
      int i;
      boolean bool;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = false;
          i = d();
          bool = c();
          if ((i != 7) || (bool)) {
            break label111;
          }
          f();
          return true;
          if (!g()) {
            continue;
          }
          a(true);
        }
      }
      return false;
      label111:
      if ((i != 4) || (!bool)) {}
    }
  }
  
  public int b()
  {
    return d();
  }
  
  public PhoneContact b(String paramString)
  {
    if (this.jdField_b_of_type_Boolean) {
      return (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      return (PhoneContact)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class, paramString);
    }
    return null;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public String b(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      if (localEntityManager == null) {
        return null;
      }
      PhoneNumInfo localPhoneNumInfo = (PhoneNumInfo)localEntityManager.a(PhoneNumInfo.class, paramString);
      if (localPhoneNumInfo != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localPhoneNumInfo.uin);
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneNumInfo.uin, paramString);
      }
      localEntityManager.a();
    }
    return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public List b()
  {
    Object localObject1 = null;
    long l = System.currentTimeMillis();
    Object localObject2;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    FriendManager localFriendManager;
    if (this.jdField_c_of_type_JavaUtilList == null)
    {
      localObject2 = new ArrayList();
      ((List)localObject2).addAll(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values());
      Collections.sort((List)localObject2, new cvm(this));
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (((List)localObject2).size() > 0) {
        if (a() != null) {}
      }
    }
    label358:
    do
    {
      return localObject1;
      String str = a().mobileNo;
      Iterator localIterator = ((List)localObject2).iterator();
      localObject1 = null;
      while (localIterator.hasNext())
      {
        localObject2 = (PhoneContact)localIterator.next();
        if ((str == null) || (!str.endsWith(((PhoneContact)localObject2).mobileNo.trim())))
        {
          PhoneContact localPhoneContact = (PhoneContact)((PhoneContact)localObject2).clone();
          if (localPhoneContact.pinyinFirst == null) {
            localPhoneContact.pinyinFirst = e(localPhoneContact.pinyinInitial);
          }
          if (TextUtils.isEmpty(localPhoneContact.uin))
          {
            if (localObject1 == null) {
              localObject1 = localPhoneContact;
            }
            for (;;)
            {
              break;
              if (localPhoneContact.contactID == ((PhoneContact)localObject1).contactID)
              {
                ((PhoneContact)localObject1).mobileNo = (((PhoneContact)localObject1).mobileNo + "|" + localPhoneContact.mobileNo);
                if (!QLog.isColorLevel()) {
                  break label412;
                }
                QLog.d("PhoneContactManager", 2, "getContactListForDisplay: conbine contact contact name is:" + ((PhoneContact)localObject1).name + "uin is :" + ((PhoneContact)localObject1).uin + "number is:" + ((PhoneContact)localObject1).mobileNo);
              }
              else
              {
                localArrayList2.add(localObject1);
                localObject1 = localPhoneContact;
              }
            }
          }
          if (localPhoneContact.uin.equals("0"))
          {
            localObject2 = null;
            if ((localObject2 == null) || (((Friends)localObject2).groupid < 0)) {
              break label432;
            }
            localPhoneContact.nickName = ContactSorter.a((Friends)localObject2);
            localPhoneContact.remark = ((Friends)localObject2).remark;
            localPhoneContact.faceUrl = Short.toString(((Friends)localObject2).faceid);
          }
          for (;;)
          {
            localArrayList1.add(localPhoneContact);
            break;
            localObject2 = localFriendManager.c(localPhoneContact.uin);
            break label358;
            localPhoneContact.uin = "0";
          }
        }
      }
      if (localObject1 != null) {
        localArrayList2.add(localObject1);
      }
      localObject1 = new cvn(this);
      Collections.sort(localArrayList1, (Comparator)localObject1);
      Collections.sort(localArrayList2, (Comparator)localObject1);
      this.jdField_c_of_type_JavaUtilList = localArrayList1;
      this.jdField_d_of_type_JavaUtilList = localArrayList2;
      localObject2 = new ArrayList();
      ((List)localObject2).add(this.jdField_c_of_type_JavaUtilList);
      ((List)localObject2).add(this.jdField_d_of_type_JavaUtilList);
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    label412:
    label432:
    QLog.d("PhoneContactManager", 2, "sort contact cost time: " + (System.currentTimeMillis() - l));
    return localObject2;
  }
  
  public void b()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.f.clear();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject).next();
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.mobileNo, localPhoneContact);
          if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!localPhoneContact.uin.equals("0"))) {
            this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.uin, localPhoneContact);
          }
          if (!TextUtils.isEmpty(localPhoneContact.unifiedCode)) {
            this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.unifiedCode, localPhoneContact);
          }
          if (!TextUtils.isEmpty(localPhoneContact.md5)) {
            this.f.put(localPhoneContact.md5, localPhoneContact);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContactManager", 2, "No contacts.");
      }
      this.jdField_b_of_type_Boolean = true;
      e();
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 19);
    localNewIntent.putExtra("country_code", paramString1);
    localNewIntent.putExtra("phone_number", paramString2);
    localNewIntent.putExtra("cmd_param_bind_type", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 19);
    localNewIntent.putExtra("country_code", paramString1);
    localNewIntent.putExtra("phone_number", paramString2);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void b(List paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      EntityTransaction localEntityTransaction;
      try
      {
        boolean bool = paramList.isEmpty();
        if (bool) {
          return;
        }
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        try
        {
          localEntityTransaction.a();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            Object localObject = (AddressBookItem)paramList.next();
            localObject = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((AddressBookItem)localObject).mobileNo);
            if (localObject == null) {
              continue;
            }
            ((PhoneContact)localObject).isUploaded = true;
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject);
            continue;
            paramList = finally;
          }
        }
        finally
        {
          localEntityTransaction.b();
        }
        localEntityTransaction.c();
      }
      finally {}
      localEntityTransaction.b();
    }
  }
  
  public boolean b()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public PhoneContact c(String paramString)
  {
    return (PhoneContact)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public String c(String paramString)
  {
    Object localObject = (String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (localObject == null) {
      return null;
    }
    paramString = (PhoneNumInfo)((EntityManager)localObject).a(PhoneNumInfo.class, "uin=?", new String[] { paramString });
    if (paramString != null) {
      return paramString.phoneNum;
    }
    return null;
  }
  
  public void c()
  {
    if ((this.jdField_c_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_c_of_type_Long < 120000L)) {
      return;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 12);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void c(String paramString1, String paramString2)
  {
    int i = 0;
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      localEntityTransaction.a();
      paramString1 = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (paramString1 != null)
      {
        int j = 1;
        paramString1.uin = paramString2;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramString1);
        i = j;
        if (!TextUtils.isEmpty(paramString1.uin))
        {
          i = j;
          if (!paramString1.uin.equals("0"))
          {
            this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
            i = j;
          }
        }
      }
      localEntityTransaction.c();
      localEntityTransaction.b();
      if (i != 0) {}
      return;
    }
    finally
    {
      localEntityTransaction.b();
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("contact_bind_info_upload", false);
  }
  
  public int d()
  {
    switch (this.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      return 0;
    case -1: 
      this.jdField_a_of_type_Int = a(a());
      return d();
    case 6: 
      return 6;
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      return 7;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public void d()
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = a();
    if ((localRespondQueryQQBindingStat == null) || (localRespondQueryQQBindingStat.nationCode == null) || (localRespondQueryQQBindingStat.mobileNo == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 20);
    localNewIntent.putExtra("country_code", localRespondQueryQQBindingStat.nationCode);
    localNewIntent.putExtra("phone_number", localRespondQueryQQBindingStat.mobileNo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void d(String paramString1, String paramString2)
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
    if ((localObject == null) || (!((String)localObject).equals(paramString2)))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, paramString2);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, paramString1);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      PhoneNumInfo localPhoneNumInfo = new PhoneNumInfo();
      localPhoneNumInfo.phoneNum = paramString1;
      localPhoneNumInfo.uin = paramString2;
      if (localObject != null)
      {
        ((EntityManager)localObject).b(localPhoneNumInfo);
        ((EntityManager)localObject).a();
      }
    }
  }
  
  public boolean d()
  {
    if (!"3.5.0".equals(this.jdField_b_of_type_AndroidContentSharedPreferences.getString("phone_version_run", ""))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.jdField_b_of_type_AndroidContentSharedPreferences.edit().remove("phone_app_first_run").commit();
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "isPhoneContactFirstRun result = " + bool);
      }
      return bool;
    }
  }
  
  public void e()
  {
    this.jdField_d_of_type_JavaUtilList = null;
    this.jdField_c_of_type_JavaUtilList = null;
    Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ContactListView.class);
    if (localHandler != null)
    {
      localHandler.removeMessages(2);
      localHandler.sendEmptyMessageDelayed(2, 100L);
    }
    localHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ContactsInnerFrame.class);
    if (localHandler != null)
    {
      localHandler.removeMessages(3);
      localHandler.sendEmptyMessageDelayed(3, 100L);
    }
  }
  
  public boolean e()
  {
    if (!"3.5.0".equals(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("phone_contact_need_star_v", ""))) {}
    for (boolean bool = true; bool; bool = false)
    {
      int i = d();
      if ((i == 0) || (i == 1) || (i == 2) || (i == 3) || (i == 6)) {
        break;
      }
      return false;
    }
    return bool;
  }
  
  public void f()
  {
    try
    {
      this.jdField_a_of_type_Int = 6;
      ArrayList localArrayList = a();
      a(this.jdField_b_of_type_JavaLangString, localArrayList);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean f()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.V, 4000);
    if (localList == null) {
      return false;
    }
    int i = localList.size() - 1;
    while (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
      if ((localMessageRecord != null) && (localMessageRecord.msg != null) && (localMessageRecord.msg.length() > 0) && ((localMessageRecord.msgtype == 1) || (localMessageRecord.msgtype == 0)) && (!localMessageRecord.isread)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public void g() {}
  
  public boolean g()
  {
    int i = d();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "isBindContactOk = " + i);
    }
    return i >= 7;
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "runPhoneContact");
    }
    SharedPreferences.Editor localEditor = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString("phone_version_run", "3.5.0");
    localEditor.commit();
  }
  
  public boolean h()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_Int != 6)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Int != 3) {}
    }
    else
    {
      bool1 = bool2;
      if (a() != null)
      {
        bool1 = bool2;
        if (a().lastUsedFlag == 2L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void i()
  {
    h();
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString("phone_contact_need_star_v", "3.5.0");
    localEditor.commit();
  }
  
  public void j() {}
  
  public void onDestroy()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_JavaUtilList = null;
    this.jdField_c_of_type_JavaUtilList = null;
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "onDestroy");
    }
    a();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneContactManagerImp
 * JD-Core Version:    0.7.0.1
 */