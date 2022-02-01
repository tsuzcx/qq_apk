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
import ezz;
import faa;
import fac;
import fad;
import fae;
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
  private static final String A = "temp_admin_regin_config";
  private static final String B = "key_last_checkup_time";
  public static final int a = 0;
  static final String jdField_a_of_type_JavaLangString = "ConditionSearch.Manager";
  public static final String[] a;
  public static final int b = 0;
  public static final String b = "不限";
  public static final String[] b;
  public static final int c = 1;
  private static final long c = 0L;
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
  private static final String l = "key_first_run";
  private static final String m = "key_first_select_location";
  private static final String n = "key_first_select_home";
  private static final String o = "key_sex_index";
  private static final String p = "key_age_index_v2";
  private static final String q = "key_loc_country_code";
  private static final String r = "key_loc_prov_code";
  private static final String s = "key_loc_city_code";
  private static final String t = "key_loc_dist_code";
  private static final String u = "key_home_country_code";
  private static final String v = "key_home_prov_code";
  private static final String w = "key_home_city_code";
  private static final String x = "key_home_dist_code";
  private static final String y = "key_config_version";
  private static final String z = "admin_region_config";
  public long a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new fae(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AddressData jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData = null;
  public LinkedList a;
  public List a;
  public volatile boolean a;
  public long b;
  LinkedList b;
  public boolean b;
  public boolean c;
  public String[] c;
  private volatile long jdField_d_of_type_Long = 0L;
  private boolean jdField_d_of_type_Boolean = false;
  public String[] d;
  private volatile long jdField_e_of_type_Long;
  private volatile boolean jdField_e_of_type_Boolean = false;
  private String[] jdField_e_of_type_ArrayOfJavaLangString;
  private String[] jdField_f_of_type_ArrayOfJavaLangString;
  public String j;
  public int k;
  private final String k;
  public int l;
  public int m = 0;
  public int n = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "不限", "男", "女" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "不限", "18岁以下", "18-22岁", "23-26岁", "27-35岁", "35岁以上" };
  }
  
  public ConditionSearchManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_k_of_type_JavaLangString = "condation_search_sp";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilLinkedList = null;
    this.jdField_b_of_type_JavaUtilLinkedList = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("condation_search_sp", 0);
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_first_run" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_config_version", 0L);
    this.jdField_e_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_last_checkup_time", 0L);
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
      QLog.d("ConditionSearch.Manager", 2, "updateLocal | isParsing = " + this.jdField_e_of_type_Boolean);
    }
    if (this.jdField_e_of_type_Boolean) {
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
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new faa(this, localFile));
    return 0;
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
      ((ConfigHandler)localObject).a(new GetResourceReqInfo[] { ((ConfigHandler)localObject).e() });
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
  
  public String a(String[] paramArrayOfString)
  {
    int i1 = 1;
    boolean bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length != 4) || ("-1".equals(paramArrayOfString[0])))
    {
      localObject1 = new StringBuilder().append("Error happened!  codes size = ");
      if (paramArrayOfString != null) {}
      for (i1 = paramArrayOfString.length;; i1 = -1000) {
        throw new IllegalArgumentException(i1);
      }
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
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData != null)
    {
      localArrayList = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a.size());
      localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a.values());
      Collections.sort(localArrayList, new ezz(this));
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_first_run" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false).commit();
    }
    a(a());
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
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof ConditionSearchManager.IConfigListener))
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList == null) {
        this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
      }
      if (this.jdField_a_of_type_JavaUtilLinkedList.contains(paramObject)) {}
    }
    do
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add((ConditionSearchManager.IConfigListener)paramObject);
      do
      {
        return;
      } while ((!(paramObject instanceof ConditionSearchManager.ISearchListener)) || (!(paramObject instanceof ConditionSearchManager.ISearchListener)));
      if (this.jdField_b_of_type_JavaUtilLinkedList == null) {
        this.jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
      }
    } while (this.jdField_b_of_type_JavaUtilLinkedList.contains(paramObject));
    this.jdField_b_of_type_JavaUtilLinkedList.add((ConditionSearchManager.ISearchListener)paramObject);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new fac(this, (String)localObject, paramGetResourceRespInfo));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new fad(this, paramBoolean));
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "seachFriend | restart = " + paramBoolean + " | keyword = " + paramString);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Long += 1L;
      this.j = paramString;
      this.jdField_k_of_type_Int = paramInt1;
      this.l = paramInt2;
      this.jdField_c_of_type_ArrayOfJavaLangString = paramArrayOfString1;
      this.jdField_d_of_type_ArrayOfJavaLangString = paramArrayOfString2;
      this.m = -1;
      this.jdField_b_of_type_Long = 0L;
    }
    while (this.jdField_c_of_type_Boolean)
    {
      this.n = 0;
      this.jdField_a_of_type_JavaUtilList = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(this.jdField_a_of_type_Long, this.m + 1, this.jdField_b_of_type_Long, this.j, this.jdField_k_of_type_Int, this.l, this.jdField_c_of_type_ArrayOfJavaLangString, this.jdField_d_of_type_ArrayOfJavaLangString);
      return;
    }
    throw new RuntimeException("No more elements");
  }
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_b_of_type_JavaUtilLinkedList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedList.iterator();
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
  
  public final boolean a()
  {
    return this.jdField_d_of_type_Boolean;
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
  
  public int b()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      Card localCard = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (localCard != null)
      {
        if (localCard.shGender == 0) {
          return 2;
        }
        if (localCard.shGender == 1) {
          return 1;
        }
      }
    }
    else
    {
      return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_sex_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    }
    return 0;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData = null;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_age_index_v2" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt).commit();
  }
  
  public void b(Object paramObject)
  {
    if ((paramObject instanceof ConditionSearchManager.IConfigListener)) {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null) {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(paramObject);
      }
    }
    while ((!(paramObject instanceof ConditionSearchManager.ISearchListener)) || (!(paramObject instanceof ConditionSearchManager.ISearchListener)) || (this.jdField_b_of_type_JavaUtilLinkedList == null)) {
      return;
    }
    this.jdField_b_of_type_JavaUtilLinkedList.remove(paramObject);
  }
  
  public void b(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    if (paramArrayOfString.length != 4) {
      throw new IllegalArgumentException("Error size " + paramArrayOfString.length);
    }
    this.f = ((String[])paramArrayOfString.clone());
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("key_home_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.f[0]).putString("key_home_prov_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.f[1]).putString("key_home_city_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.f[2]).putString("key_home_dist_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.f[3]).commit();
  }
  
  public boolean b()
  {
    boolean bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_first_select_location" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
    if (bool) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_first_select_location" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false).commit();
    }
    return bool;
  }
  
  public String[] b()
  {
    if (this.f == null)
    {
      this.f = new String[4];
      this.f[0] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_home_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
      this.f[1] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_home_prov_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
      this.f[2] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_home_city_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
      this.f[3] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_home_dist_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
    }
    return this.f;
  }
  
  public int c()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      Card localCard = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (localCard != null)
      {
        int i1;
        if (localCard.shGender != 0) {
          if (localCard.age < 18) {
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
  
  public boolean c()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager
 * JD-Core Version:    0.7.0.1
 */