package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.conditionsearch.data.AddressData;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cqk;
import cql;
import cqn;
import cqo;
import cqp;
import cqr;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceRespInfo;

public class ConditionSearchManager
  implements Manager
{
  private static final String A = "key_home_dist_code";
  private static final String B = "key_config_version";
  private static final String C = "temp_admin_regin_config";
  private static final String D = "key_last_checkup_time";
  public static final int a = 0;
  static final String jdField_a_of_type_JavaLangString = "ConditionSearch.Manager";
  public static final String[] a;
  public static final int b = 0;
  public static final String b = "不限";
  public static final String[] b;
  public static final int c = 1;
  private static final long jdField_c_of_type_Long = 0L;
  public static final String c = "0";
  public static final int d = 2;
  public static final String d = "中国";
  public static final int e = 0;
  public static final String e = "1";
  public static final int f = 1;
  private static final long jdField_f_of_type_Long = 120000L;
  public static final String f = "-1";
  public static final int g = 2;
  public static final String g = "-";
  public static final int h = 3;
  public static final String h = "location_string";
  public static final int i = 0;
  public static final String i = "home_string";
  public static final int j = 1;
  public static final String j = "admin_region_config";
  private static final String m = "key_first_run";
  private static final String n = "key_first_select_location";
  private static final String o = "key_first_select_home";
  private static final String p = "key_frist_run_in_5_2";
  private static final String q = "key_frist_run_add_contact";
  private static final String r = "key_sex_index";
  private static final String s = "key_age_index_v2";
  private static final String t = "key_loc_country_code";
  private static final String u = "key_loc_prov_code";
  private static final String v = "key_loc_city_code";
  private static final String w = "key_loc_dist_code";
  private static final String x = "key_home_country_code";
  private static final String y = "key_home_prov_code";
  private static final String z = "key_home_city_code";
  public long a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new cqr(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AddressData jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData = null;
  public Object a;
  LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public List a;
  public volatile boolean a;
  public long b;
  public LinkedList b;
  public volatile boolean b;
  LinkedList jdField_c_of_type_JavaUtilLinkedList = null;
  public volatile boolean c;
  public String[] c;
  private volatile long d;
  public boolean d;
  public String[] d;
  private volatile long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean = false;
  private String[] jdField_e_of_type_ArrayOfJavaLangString;
  private boolean jdField_f_of_type_Boolean = false;
  private String[] jdField_f_of_type_ArrayOfJavaLangString;
  private volatile boolean g = false;
  public int k;
  public String k;
  public int l;
  private final String l;
  public int m = 0;
  public int n = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "不限", "男", "女" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "不限", "18岁以下", "18-22岁", "23-26岁", "27-35岁", "35岁以上" };
  }
  
  public ConditionSearchManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_l_of_type_JavaLangString = "condation_search_sp";
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilLinkedList = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("condation_search_sp", 0);
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_first_run" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_config_version", 0L);
    this.jdField_e_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_last_checkup_time", 0L);
    this.jdField_f_of_type_Boolean = e();
    ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
  }
  
  public static final int a(String paramString)
  {
    int i1 = 0;
    int i2 = 0;
    if (paramString.equals("0")) {
      return i2;
    }
    int i4 = paramString.length();
    i2 = 0;
    for (;;)
    {
      int i3 = i2;
      i2 = i1;
      if (i3 >= i4) {
        break;
      }
      int i5 = paramString.charAt(i3);
      i2 = i3 + 1;
      i1 = (i5 << (i4 - 1 - i3) * 8) + i1;
    }
  }
  
  private BaseAddress a(Map paramMap, String paramString)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return null;
    }
    Object localObject = new ArrayList(paramMap.size());
    ((List)localObject).addAll(paramMap.values());
    paramMap = ((List)localObject).iterator();
    while (paramMap.hasNext())
    {
      localObject = (BaseAddress)paramMap.next();
      if (((BaseAddress)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
        return localObject;
      }
    }
    return null;
  }
  
  public static final String a(long paramLong)
  {
    if (paramLong == 0L) {
      return "0";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    while (paramLong != 0L)
    {
      localStringBuilder.append((char)(int)(paramLong % 256L));
      paramLong >>= 8;
    }
    return localStringBuilder.reverse().toString();
  }
  
  public static final int b(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return paramInt + 10;
  }
  
  private int d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "updateLocal | isParsing = " + this.g);
    }
    if (this.g) {
      return 0;
    }
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), "admin_region_config");
    if ((localFile == null) || (!localFile.exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "updateLocal | file is not exist");
      }
      this.jdField_d_of_type_Long = 0L;
      return 3;
    }
    this.g = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new cql(this, localFile));
    return 0;
  }
  
  private boolean e()
  {
    boolean bool = true;
    if (this.jdField_e_of_type_Boolean) {
      bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_frist_run_add_contact", true);
    }
    while ((this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_frist_run_in_5_2" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true)) && (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_sex_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0) == 0) && (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_age_index_v2" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0) == 0) && (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_loc_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0").equals("0")) && (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_home_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0").equals("0"))) {
      return bool;
    }
    return false;
  }
  
  public int a()
  {
    int i1;
    if (this.jdField_d_of_type_Long == 0L) {
      i1 = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "checkUpdate | result = " + i1);
      }
      return i1;
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData == null) {
        i1 = 2;
      } else {
        i1 = 0;
      }
    }
  }
  
  public int a(int paramInt)
  {
    if (paramInt == 1)
    {
      l1 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("update | isCheckingUpdate = ").append(this.jdField_a_of_type_Boolean).append(" | interval is enough ");
        if (Math.abs(l1 - this.jdField_e_of_type_Long) >= 120000L)
        {
          bool = true;
          QLog.d("ConditionSearch.Manager", 2, bool + " | isNetAvaiable = " + NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
        }
      }
      else
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label112;
        }
      }
    }
    label112:
    while (paramInt != 2)
    {
      long l1;
      for (;;)
      {
        return 0;
        boolean bool = false;
      }
      if (Math.abs(l1 - this.jdField_e_of_type_Long) < 120000L) {
        return 1;
      }
      if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
        return 2;
      }
      Object localObject = (ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4);
      ((ConfigHandler)localObject).a(null, new GetResourceReqInfo[] { ((ConfigHandler)localObject).d() });
      return 0;
    }
    return d();
  }
  
  public final long a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_last_checkup_time", this.jdField_e_of_type_Long).commit();
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "getConfigVersion | version = " + this.jdField_d_of_type_Long);
    }
    return this.jdField_d_of_type_Long;
  }
  
  public BaseAddress a(String paramString)
  {
    BaseAddress localBaseAddress = null;
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData != null) {
      localBaseAddress = (BaseAddress)this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a.get(paramString);
    }
    return localBaseAddress;
  }
  
  public String a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("location_string" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "不限");
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("home_string" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "不限");
  }
  
  public String a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = "";
    }
    String str;
    do
    {
      for (;;)
      {
        return localObject;
        str = paramString;
        try
        {
          String[] arrayOfString = paramString.split("-");
          str = paramString;
          if (arrayOfString[0].equals("中国"))
          {
            str = paramString;
            if (arrayOfString.length > 2)
            {
              paramString = arrayOfString[2];
              localObject = paramString;
              str = paramString;
              if (arrayOfString.length > 3)
              {
                str = paramString;
                return paramString + "-" + arrayOfString[3];
              }
            }
            else
            {
              localObject = paramString;
              str = paramString;
              if (arrayOfString.length > 1) {
                return arrayOfString[1];
              }
            }
          }
          else
          {
            localObject = paramString;
            str = paramString;
            if (arrayOfString.length > 2)
            {
              str = paramString;
              paramString = arrayOfString[(arrayOfString.length - 2)] + "-" + arrayOfString[(arrayOfString.length - 1)];
              return paramString;
            }
          }
        }
        catch (Exception paramString)
        {
          localObject = str;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ConditionSearch.Manager", 2, "", paramString);
    return str;
  }
  
  public String a(String[] paramArrayOfString)
  {
    String str2 = b(paramArrayOfString);
    String str1 = str2;
    if ("1".equals(paramArrayOfString[0]))
    {
      str1 = str2;
      if (str2.split("-").length > 1) {
        str1 = str2.substring(str2.indexOf("-") + 1, str2.length());
      }
    }
    return str1;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData != null)
    {
      localArrayList = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a.size());
      localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a.values());
      Collections.sort(localArrayList, new cqk(this));
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = true;
    a(this.jdField_a_of_type_JavaLangObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new cqp(this));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_sex_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt).commit();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("location_string" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString).commit();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("home_string" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString).commit();
  }
  
  /* Error */
  public void a(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 162	com/tencent/mobileqq/app/ConditionSearchManager:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   6: aload_1
    //   7: invokevirtual 490	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   10: ifne +84 -> 94
    //   13: aload_0
    //   14: getfield 162	com/tencent/mobileqq/app/ConditionSearchManager:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   17: aload_1
    //   18: invokevirtual 493	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   21: pop
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield 157	com/tencent/mobileqq/app/ConditionSearchManager:jdField_b_of_type_Boolean	Z
    //   27: aload_0
    //   28: aload_0
    //   29: invokevirtual 495	com/tencent/mobileqq/app/ConditionSearchManager:a	()I
    //   32: invokevirtual 497	com/tencent/mobileqq/app/ConditionSearchManager:a	(I)I
    //   35: pop
    //   36: aload_1
    //   37: instanceof 499
    //   40: ifeq +57 -> 97
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield 141	com/tencent/mobileqq/app/ConditionSearchManager:jdField_e_of_type_Boolean	Z
    //   48: aload_0
    //   49: getfield 202	com/tencent/mobileqq/app/ConditionSearchManager:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   52: invokeinterface 401 1 0
    //   57: new 204	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   64: ldc 63
    //   66: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_0
    //   70: getfield 189	com/tencent/mobileqq/app/ConditionSearchManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   73: invokevirtual 212	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   76: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: iconst_0
    //   83: invokeinterface 503 3 0
    //   88: invokeinterface 410 1 0
    //   93: pop
    //   94: aload_0
    //   95: monitorexit
    //   96: return
    //   97: aload_1
    //   98: instanceof 505
    //   101: ifeq -7 -> 94
    //   104: aload_0
    //   105: iconst_0
    //   106: putfield 143	com/tencent/mobileqq/app/ConditionSearchManager:jdField_f_of_type_Boolean	Z
    //   109: aload_0
    //   110: getfield 202	com/tencent/mobileqq/app/ConditionSearchManager:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   113: invokeinterface 401 1 0
    //   118: new 204	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   125: ldc 72
    //   127: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_0
    //   131: getfield 189	com/tencent/mobileqq/app/ConditionSearchManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   134: invokevirtual 212	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   137: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: iconst_0
    //   144: invokeinterface 503 3 0
    //   149: invokeinterface 410 1 0
    //   154: pop
    //   155: aload_0
    //   156: getfield 202	com/tencent/mobileqq/app/ConditionSearchManager:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   159: invokeinterface 401 1 0
    //   164: new 204	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   171: ldc 75
    //   173: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: getfield 189	com/tencent/mobileqq/app/ConditionSearchManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   180: invokevirtual 212	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   183: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: iconst_0
    //   190: invokeinterface 503 3 0
    //   195: invokeinterface 410 1 0
    //   200: pop
    //   201: goto -107 -> 94
    //   204: astore_1
    //   205: aload_0
    //   206: monitorexit
    //   207: aload_1
    //   208: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	ConditionSearchManager
    //   0	209	1	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	94	204	finally
    //   97	201	204	finally
  }
  
  public void a(GetResourceRespInfo paramGetResourceRespInfo)
  {
    int i1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onCheckupConfig | resp = ").append(paramGetResourceRespInfo).append(" | iResult = ");
      if (paramGetResourceRespInfo != null)
      {
        i1 = paramGetResourceRespInfo.iResult;
        QLog.d("ConditionSearch.Manager", 2, i1);
      }
    }
    else
    {
      if ((paramGetResourceRespInfo != null) && (paramGetResourceRespInfo.iResult == 0)) {
        break label77;
      }
      a(false);
    }
    label77:
    do
    {
      return;
      i1 = -1000;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "onCheckupConfig | local version = " + this.jdField_d_of_type_Long + " | server version = " + paramGetResourceRespInfo.uiNewVer);
      }
    } while (this.jdField_d_of_type_Long == paramGetResourceRespInfo.uiNewVer);
    Object localObject = paramGetResourceRespInfo.strResURL_big;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ConditionSearch.Manager", 2, "onCheckupConfig | url is null");
      }
      a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new cqn(this, (String)localObject, paramGetResourceRespInfo));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new cqo(this, paramBoolean));
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "seachFriend | restart = " + paramBoolean + " | keyword = " + paramString);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Long += 1L;
      this.jdField_k_of_type_JavaLangString = paramString;
      this.jdField_k_of_type_Int = paramInt1;
      this.jdField_l_of_type_Int = paramInt2;
      this.jdField_c_of_type_ArrayOfJavaLangString = paramArrayOfString1;
      this.jdField_d_of_type_ArrayOfJavaLangString = paramArrayOfString2;
      this.m = -1;
      this.jdField_b_of_type_Long = 0L;
    }
    while (this.jdField_d_of_type_Boolean)
    {
      this.n = 0;
      this.jdField_a_of_type_JavaUtilList = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(this.jdField_a_of_type_Long, this.m + 1, this.jdField_b_of_type_Long, this.jdField_k_of_type_JavaLangString, this.jdField_k_of_type_Int, this.jdField_l_of_type_Int, this.jdField_c_of_type_ArrayOfJavaLangString, this.jdField_d_of_type_ArrayOfJavaLangString);
      return;
    }
    throw new RuntimeException("No more elements");
  }
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_c_of_type_JavaUtilLinkedList != null)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilLinkedList.iterator();
      while (localIterator.hasNext()) {
        ((ConditionSearchManager.ISearchListener)localIterator.next()).a(paramBoolean1, paramList, paramBoolean2);
      }
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    if (paramArrayOfString.length != 4) {
      throw new IllegalArgumentException("Error size " + paramArrayOfString.length);
    }
    this.jdField_e_of_type_ArrayOfJavaLangString = ((String[])paramArrayOfString.clone());
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("key_loc_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_e_of_type_ArrayOfJavaLangString[0]).putString("key_loc_prov_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_e_of_type_ArrayOfJavaLangString[1]).putString("key_loc_city_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_e_of_type_ArrayOfJavaLangString[2]).putString("key_loc_dist_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_e_of_type_ArrayOfJavaLangString[3]).commit();
  }
  
  public boolean a()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public String[] a()
  {
    if (this.jdField_e_of_type_ArrayOfJavaLangString == null)
    {
      this.jdField_e_of_type_ArrayOfJavaLangString = new String[4];
      this.jdField_e_of_type_ArrayOfJavaLangString[0] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_loc_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
      this.jdField_e_of_type_ArrayOfJavaLangString[1] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_loc_prov_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
      this.jdField_e_of_type_ArrayOfJavaLangString[2] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_loc_city_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
      this.jdField_e_of_type_ArrayOfJavaLangString[3] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_loc_dist_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
    }
    return this.jdField_e_of_type_ArrayOfJavaLangString;
  }
  
  public String[] a(String paramString)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "不限";
    arrayOfString[1] = "不限";
    if ((!TextUtils.isEmpty(paramString)) && (!"不限".equals(paramString)))
    {
      int i1 = paramString.indexOf("-");
      if (i1 != -1)
      {
        arrayOfString[0] = paramString.substring(0, i1);
        arrayOfString[1] = paramString.substring(i1 + 1);
      }
    }
    else
    {
      return arrayOfString;
    }
    arrayOfString[0] = paramString;
    return arrayOfString;
  }
  
  public String[] a(String paramString1, String paramString2, String paramString3)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "0";
    arrayOfString[1] = "0";
    arrayOfString[2] = "0";
    arrayOfString[3] = "0";
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "parseAddressToCodeArray | address data = null");
      }
    }
    do
    {
      do
      {
        BaseAddress localBaseAddress;
        do
        {
          do
          {
            return arrayOfString;
          } while (TextUtils.isEmpty(paramString1));
          localBaseAddress = a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a, paramString1);
        } while (localBaseAddress == null);
        arrayOfString[0] = localBaseAddress.b;
        paramString1 = localBaseAddress;
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString2 = a(localBaseAddress.jdField_a_of_type_JavaUtilLinkedHashMap, paramString2);
          paramString1 = paramString2;
          if (paramString2 != null)
          {
            arrayOfString[1] = paramString2.b;
            paramString1 = paramString2;
          }
        }
      } while ((paramString1 == null) || (TextUtils.isEmpty(paramString3)));
      paramString1 = a(paramString1.jdField_a_of_type_JavaUtilLinkedHashMap, paramString3);
    } while (paramString1 == null);
    arrayOfString[2] = paramString1.b;
    return arrayOfString;
  }
  
  public String[] a(String[] paramArrayOfString)
  {
    int i1 = 1;
    if ((paramArrayOfString == null) || (paramArrayOfString.length != 4) || ("-1".equals(paramArrayOfString[0]))) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData == null)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfString = new StringBuilder().append("praseCodeArrayToAddress addressData == null is ");
        if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData != null) {
          break label77;
        }
      }
      label77:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("ConditionSearch.Manager", 2, bool);
        return null;
      }
    }
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    arrayOfString[3] = "";
    if ("-1".equals(paramArrayOfString[0])) {
      return arrayOfString;
    }
    Object localObject1 = (BaseAddress)this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a.get(paramArrayOfString[0]);
    if (localObject1 == null) {
      return arrayOfString;
    }
    arrayOfString[0] = ((BaseAddress)localObject1).jdField_a_of_type_JavaLangString;
    while (i1 < 4)
    {
      Object localObject2 = localObject1;
      if (!"0".equals(paramArrayOfString[i1]))
      {
        localObject2 = (BaseAddress)((BaseAddress)localObject1).jdField_a_of_type_JavaUtilLinkedHashMap.get(paramArrayOfString[i1]);
        if (localObject2 == null) {
          break;
        }
        arrayOfString[i1] = ((BaseAddress)localObject2).jdField_a_of_type_JavaLangString;
      }
      i1 += 1;
      localObject1 = localObject2;
    }
    return arrayOfString;
  }
  
  public int b()
  {
    Card localCard;
    int i1;
    if (this.jdField_f_of_type_Boolean)
    {
      localCard = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (localCard == null) {
        break label147;
      }
      if (localCard.shGender == 0) {
        i1 = 2;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_sex_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1).commit();
      return i1;
      if (localCard.shGender == 1)
      {
        i1 = 1;
        continue;
        return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_sex_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
      }
      else
      {
        i1 = 0;
      }
    }
    label147:
    return 0;
  }
  
  public String b(String[] paramArrayOfString)
  {
    int i1 = 1;
    boolean bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length != 4) || ("-1".equals(paramArrayOfString[0]))) {
      return "0";
    }
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData == null)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfString = new StringBuilder().append("praseCodeArrayToAddress addressData == null is ");
        if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData == null) {
          bool = true;
        }
        QLog.d("ConditionSearch.Manager", 2, bool);
      }
      return "不限";
    }
    if ("-1".equals(paramArrayOfString[0])) {
      return "不限";
    }
    Object localObject1 = (BaseAddress)this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a.get(paramArrayOfString[0]);
    if (localObject1 == null) {
      return "不限";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((BaseAddress)localObject1).jdField_a_of_type_JavaLangString);
    while (i1 < 4)
    {
      Object localObject2 = localObject1;
      if (!"0".equals(paramArrayOfString[i1]))
      {
        localObject2 = (BaseAddress)((BaseAddress)localObject1).jdField_a_of_type_JavaUtilLinkedHashMap.get(paramArrayOfString[i1]);
        if (localObject2 == null) {
          break;
        }
        localStringBuilder.append("-").append(((BaseAddress)localObject2).jdField_a_of_type_JavaLangString);
      }
      i1 += 1;
      localObject1 = localObject2;
    }
    return localStringBuilder.toString();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_age_index_v2" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt).commit();
  }
  
  public void b(Object paramObject)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramObject);
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() == 0)
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData = null;
      }
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public void b(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    if (paramArrayOfString.length != 4) {
      throw new IllegalArgumentException("Error size " + paramArrayOfString.length);
    }
    this.jdField_f_of_type_ArrayOfJavaLangString = ((String[])paramArrayOfString.clone());
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("key_home_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_f_of_type_ArrayOfJavaLangString[0]).putString("key_home_prov_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_f_of_type_ArrayOfJavaLangString[1]).putString("key_home_city_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_f_of_type_ArrayOfJavaLangString[2]).putString("key_home_dist_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_f_of_type_ArrayOfJavaLangString[3]).commit();
  }
  
  public final boolean b()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public String[] b()
  {
    if (this.jdField_f_of_type_ArrayOfJavaLangString == null)
    {
      this.jdField_f_of_type_ArrayOfJavaLangString = new String[4];
      this.jdField_f_of_type_ArrayOfJavaLangString[0] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_home_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
      this.jdField_f_of_type_ArrayOfJavaLangString[1] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_home_prov_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
      this.jdField_f_of_type_ArrayOfJavaLangString[2] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_home_city_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
      this.jdField_f_of_type_ArrayOfJavaLangString[3] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_home_dist_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
    }
    return this.jdField_f_of_type_ArrayOfJavaLangString;
  }
  
  public int c()
  {
    if (this.jdField_f_of_type_Boolean)
    {
      Card localCard = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (localCard != null)
      {
        int i1;
        if (localCard.shGender != 0) {
          if ((localCard.age > 0) && (localCard.age < 18)) {
            i1 = 1;
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_age_index_v2" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1).commit();
          return i1;
          if ((localCard.age >= 18) && (localCard.age <= 22))
          {
            i1 = 2;
          }
          else if ((localCard.age >= 23) && (localCard.age <= 26))
          {
            i1 = 3;
          }
          else if ((localCard.age >= 27) && (localCard.age <= 35))
          {
            i1 = 4;
          }
          else if (localCard.age >= 35)
          {
            i1 = 5;
          }
          else
          {
            i1 = 0;
            continue;
            i1 = 2;
          }
        }
      }
    }
    else
    {
      return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_age_index_v2" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    }
    return 0;
  }
  
  public void c(Object paramObject)
  {
    if ((paramObject instanceof ConditionSearchManager.IConfigListener))
    {
      if (this.jdField_b_of_type_JavaUtilLinkedList == null) {
        this.jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
      }
      if (this.jdField_b_of_type_JavaUtilLinkedList.contains(paramObject)) {}
    }
    do
    {
      this.jdField_b_of_type_JavaUtilLinkedList.add((ConditionSearchManager.IConfigListener)paramObject);
      do
      {
        return;
      } while ((!(paramObject instanceof ConditionSearchManager.ISearchListener)) || (!(paramObject instanceof ConditionSearchManager.ISearchListener)));
      if (this.jdField_c_of_type_JavaUtilLinkedList == null) {
        this.jdField_c_of_type_JavaUtilLinkedList = new LinkedList();
      }
    } while (this.jdField_c_of_type_JavaUtilLinkedList.contains(paramObject));
    this.jdField_c_of_type_JavaUtilLinkedList.add((ConditionSearchManager.ISearchListener)paramObject);
  }
  
  public boolean c()
  {
    boolean bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_first_select_location" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
    if (bool) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_first_select_location" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false).commit();
    }
    return bool;
  }
  
  public void d(Object paramObject)
  {
    if ((paramObject instanceof ConditionSearchManager.IConfigListener)) {
      if (this.jdField_b_of_type_JavaUtilLinkedList != null) {
        this.jdField_b_of_type_JavaUtilLinkedList.remove(paramObject);
      }
    }
    while ((!(paramObject instanceof ConditionSearchManager.ISearchListener)) || (!(paramObject instanceof ConditionSearchManager.ISearchListener)) || (this.jdField_c_of_type_JavaUtilLinkedList == null)) {
      return;
    }
    this.jdField_c_of_type_JavaUtilLinkedList.remove(paramObject);
  }
  
  public boolean d()
  {
    boolean bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_first_select_home" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
    if (bool) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_first_select_home" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false).commit();
    }
    return bool;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a();
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager
 * JD-Core Version:    0.7.0.1
 */