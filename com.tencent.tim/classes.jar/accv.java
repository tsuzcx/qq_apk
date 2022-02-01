import SummaryCard.CondFitUser;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ConditionSearchManager.2;
import com.tencent.mobileqq.app.ConditionSearchManager.3;
import com.tencent.mobileqq.app.ConditionSearchManager.4;
import com.tencent.mobileqq.app.ConditionSearchManager.DownloadTask.1;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.conditionsearch.data.AddressData;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import mqq.manager.Manager;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceRespInfo;

public class accv
  implements Manager
{
  public static final String[] dR = { "不限", "男", "女" };
  public static final String[] dS = { "不限", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99" };
  public static final String[] dT = { "不限", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };
  public static final String[] dU = { "不限", "计算机/互联网/通信", "生产/工艺/制造", "医疗/护理/制药", "金融/银行/投资/保险", "商业/服务业/个体经营", "文化/广告/传媒", "娱乐/艺术/表演", "律师/法务", "教育/培训", "公务员/行政/事业单位", "模特", "空姐", "学生", "其他职业" };
  public static final String[] dV = { "", "IT", "制造", "医疗", "金融", "商业", "文化", "艺术", "法律", "教育", "行政", "模特", "空姐", "学生", "" };
  public static final int[] kf = { 2130846799, 2130845823, 2130845823, 2130845823, 2130846556, 2130846556, 2130846817, 2130846817, 2130846338, 2130846338, 2130846338, 2130846799, 2130846799, 2130846617, 2130846799 };
  public static final int[] kg = { -16777216, -11362561, -11362561, -11362561, -274353, -274353, -893603, -893603, -7745469, -7745469, -7745469, -8291118, -8291118, -16723548, -16777216 };
  public static final int[] kh = { 11, 12 };
  public LinkedList<accv.b> J = null;
  LinkedList<accv.d> K = null;
  private volatile long Ph = 0L;
  private volatile long Pi;
  long Pj = 0L;
  private acfd jdField_a_of_type_Acfd = new accx(this);
  private AddressData jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData;
  private QQAppInterface app;
  private accv.c b;
  private boolean bGW;
  private boolean bGX;
  public boolean bGY;
  private volatile boolean bGZ;
  public volatile boolean bHa = false;
  public volatile boolean bHb = false;
  public volatile boolean bHc = false;
  private final String bnY = "condation_search_sp";
  String bnZ;
  public Object cn = new Object();
  int cuF;
  int cuG;
  int cuH;
  int cuI;
  int cuJ;
  int cuK = 0;
  int cuL = 0;
  private String[] dW;
  private String[] dX;
  private String[] dY;
  String[] dZ;
  public volatile Card e = null;
  String[] ea;
  boolean hasMore = false;
  long mSessionId = 0L;
  public String mUrl;
  private SharedPreferences pref;
  List<Object> xk = Collections.synchronizedList(new LinkedList());
  List<CondFitUser> xl;
  
  public accv(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.pref = this.app.getApp().getSharedPreferences("condation_search_sp", 0);
    this.bGW = this.pref.getBoolean("key_first_run" + this.app.getCurrentAccountUin(), true);
    this.Ph = this.pref.getLong("key_config_version", 0L);
    this.Pi = this.pref.getLong("key_last_checkup_time", 0L);
    this.bGX = ZJ();
  }
  
  private int Aj()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "updateLocal | isParsing = " + this.bGZ);
    }
    if (this.bGZ) {
      return 0;
    }
    File localFile = new File(getConfigPath("admin_region_config"));
    if ((localFile == null) || (!localFile.exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "updateLocal | file is not exist");
      }
      this.Ph = 0L;
      return 3;
    }
    this.bGZ = true;
    ThreadManagerV2.excute(new ConditionSearchManager.2(this, localFile), 128, null, true);
    return 0;
  }
  
  private void EG(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, String.format("notifyRemoteUpdateResult isSuccess=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    this.app.runOnUiThread(new ConditionSearchManager.3(this, paramBoolean));
  }
  
  private boolean ZJ()
  {
    boolean bool = true;
    if (this.bGW) {
      bool = this.pref.getBoolean("key_frist_run_add_contact" + this.app.getCurrentAccountUin(), true);
    }
    while ((this.pref.getBoolean("key_frist_run_in_5_2" + this.app.getCurrentAccountUin(), true)) && (this.pref.getInt("key_sex_index" + this.app.getCurrentAccountUin(), 0) == 0) && (this.pref.getInt("key_age_index_v2_1" + this.app.getCurrentAccountUin(), 0) == 0) && (this.pref.getInt("key_age_index_v2_2" + this.app.getCurrentAccountUin(), 0) == 0) && (this.pref.getInt("key_job_index" + this.app.getCurrentAccountUin(), 0) == 0) && (this.pref.getInt("key_xingzuo_index" + this.app.getCurrentAccountUin(), 0) == 0) && (this.pref.getString("key_loc_country_code" + this.app.getCurrentAccountUin(), "0").equals("0")) && (this.pref.getString("key_home_country_code" + this.app.getCurrentAccountUin(), "0").equals("0"))) {
      return bool;
    }
    return false;
  }
  
  public static final String bi(long paramLong)
  {
    if (paramLong == 0L) {
      return "0";
    }
    StringBuilder localStringBuilder = new StringBuilder(6);
    while (paramLong != 0L) {
      try
      {
        localStringBuilder.append((char)(int)(paramLong % 256L));
        paramLong >>= 8;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ConditionSearch.Manager", 2, localOutOfMemoryError, new Object[0]);
        }
        return "0";
      }
    }
    return localOutOfMemoryError.reverse().toString();
  }
  
  public static final int cm(String paramString)
  {
    int i = 0;
    int k = 0;
    int j = k;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals("0")) {
        j = k;
      }
    }
    else {
      return j;
    }
    int m = paramString.length();
    j = 0;
    for (;;)
    {
      k = j;
      j = i;
      if (k >= m) {
        break;
      }
      int n = paramString.charAt(k);
      j = k + 1;
      i = (n << (m - 1 - k) * 8) + i;
    }
  }
  
  public static String getConfigPath(String paramString)
  {
    return BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/condition_search/" + paramString;
  }
  
  public int Ai()
  {
    int i;
    if (this.Ph == 0L) {
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "checkUpdate | result = " + i);
      }
      return i;
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData == null) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public int Ak()
  {
    int i = 0;
    if (!this.bGX) {
      i = this.pref.getInt("key_job_index" + this.app.getCurrentAccountUin(), 0);
    }
    return i;
  }
  
  public int Al()
  {
    int i = 0;
    if (!this.bGX) {
      i = this.pref.getInt("key_xingzuo_index" + this.app.getCurrentAccountUin(), 0);
    }
    return i;
  }
  
  public int Am()
  {
    if (this.bGX)
    {
      Card localCard = ((acff)this.app.getManager(51)).b(this.app.getCurrentAccountUin());
      if (localCard == null) {
        break label134;
      }
      if (localCard.shGender != 0) {
        break label129;
      }
    }
    label129:
    for (int i = 2;; i = 0)
    {
      this.pref.edit().putInt("key_sex_index" + this.app.getCurrentAccountUin(), i).commit();
      return i;
      return this.pref.getInt("key_sex_index" + this.app.getCurrentAccountUin(), 0);
    }
    label134:
    return 0;
  }
  
  public String B(int paramInt1, int paramInt2)
  {
    if (((paramInt1 > paramInt2) && (paramInt2 != 0)) || (paramInt1 < 0) || (paramInt2 < 0)) {
      return dS[0];
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return dS[0];
    }
    if ((paramInt1 == 0) && (paramInt2 != 0)) {
      return dS[paramInt2] + "岁及以下";
    }
    if ((paramInt1 != 0) && (paramInt2 == 0)) {
      return dS[paramInt1] + "岁及以上";
    }
    if (paramInt1 == paramInt2) {
      return dS[paramInt1] + "岁";
    }
    return dS[paramInt1] + "-" + dS[paramInt2] + "岁";
  }
  
  public void G(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    if (paramArrayOfString.length != 4) {
      throw new IllegalArgumentException("Error size " + paramArrayOfString.length);
    }
    this.dW = ((String[])paramArrayOfString.clone());
    this.pref.edit().putString("key_cur_loc_country_code" + this.app.getCurrentAccountUin(), this.dW[0]).putString("key_cur_loc_prov_code" + this.app.getCurrentAccountUin(), this.dW[1]).putString("key_cur_loc_city_code" + this.app.getCurrentAccountUin(), this.dW[2]).putString("key_cur_loc_dist_code" + this.app.getCurrentAccountUin(), this.dW[3]).commit();
  }
  
  public String[] G()
  {
    if (this.dW == null)
    {
      this.dW = new String[4];
      this.dW[0] = this.pref.getString("key_cur_loc_country_code" + this.app.getCurrentAccountUin(), "0");
      this.dW[1] = this.pref.getString("key_cur_loc_prov_code" + this.app.getCurrentAccountUin(), "0");
      this.dW[2] = this.pref.getString("key_cur_loc_city_code" + this.app.getCurrentAccountUin(), "0");
      this.dW[3] = this.pref.getString("key_cur_loc_dist_code" + this.app.getCurrentAccountUin(), "0");
    }
    return this.dW;
  }
  
  public void H(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    if (paramArrayOfString.length != 4) {
      throw new IllegalArgumentException("Error size " + paramArrayOfString.length);
    }
    this.dX = ((String[])paramArrayOfString.clone());
    this.pref.edit().putString("key_loc_country_code" + this.app.getCurrentAccountUin(), this.dX[0]).putString("key_loc_prov_code" + this.app.getCurrentAccountUin(), this.dX[1]).putString("key_loc_city_code" + this.app.getCurrentAccountUin(), this.dX[2]).putString("key_loc_dist_code" + this.app.getCurrentAccountUin(), this.dX[3]).commit();
  }
  
  public String[] H()
  {
    if (this.dX == null)
    {
      this.dX = new String[4];
      this.dX[0] = this.pref.getString("key_loc_country_code" + this.app.getCurrentAccountUin(), "0");
      this.dX[1] = this.pref.getString("key_loc_prov_code" + this.app.getCurrentAccountUin(), "0");
      this.dX[2] = this.pref.getString("key_loc_city_code" + this.app.getCurrentAccountUin(), "0");
      this.dX[3] = this.pref.getString("key_loc_dist_code" + this.app.getCurrentAccountUin(), "0");
    }
    return this.dX;
  }
  
  public void I(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    if (paramArrayOfString.length != 4) {
      throw new IllegalArgumentException("Error size " + paramArrayOfString.length);
    }
    this.dY = ((String[])paramArrayOfString.clone());
    this.pref.edit().putString("key_home_country_code" + this.app.getCurrentAccountUin(), this.dY[0]).putString("key_home_prov_code" + this.app.getCurrentAccountUin(), this.dY[1]).putString("key_home_city_code" + this.app.getCurrentAccountUin(), this.dY[2]).putString("key_home_dist_code" + this.app.getCurrentAccountUin(), this.dY[3]).commit();
  }
  
  public String[] I()
  {
    if (this.dY == null)
    {
      this.dY = new String[4];
      this.dY[0] = this.pref.getString("key_home_country_code" + this.app.getCurrentAccountUin(), "0");
      this.dY[1] = this.pref.getString("key_home_prov_code" + this.app.getCurrentAccountUin(), "0");
      this.dY[2] = this.pref.getString("key_home_city_code" + this.app.getCurrentAccountUin(), "0");
      this.dY[3] = this.pref.getString("key_home_dist_code" + this.app.getCurrentAccountUin(), "0");
    }
    return this.dY;
  }
  
  public void IL(int paramInt)
  {
    this.pref.edit().putInt("key_job_index" + this.app.getCurrentAccountUin(), paramInt).commit();
  }
  
  public void IM(int paramInt)
  {
    this.pref.edit().putInt("key_xingzuo_index" + this.app.getCurrentAccountUin(), paramInt).commit();
  }
  
  public void IN(int paramInt)
  {
    this.pref.edit().putInt("key_sex_index" + this.app.getCurrentAccountUin(), paramInt).commit();
  }
  
  public int[] N()
  {
    Card localCard;
    int i;
    int j;
    if (this.bGX)
    {
      localCard = ((acff)this.app.getManager(51)).b(this.app.getCurrentAccountUin());
      if (localCard == null) {
        break label357;
      }
      if ((localCard.age <= 5) || (localCard.age >= 60))
      {
        i = 0;
        j = 0;
        this.pref.edit().putInt("key_age_index_v2_1" + this.app.getCurrentAccountUin(), j).commit();
        this.pref.edit().putInt("key_age_index_v2_2" + this.app.getCurrentAccountUin(), i).commit();
      }
    }
    for (;;)
    {
      return new int[] { j, i };
      if ((localCard.age >= 6) && (localCard.age <= 11))
      {
        i = 11;
        j = 6;
        break;
      }
      if ((localCard.age >= 12) && (localCard.age <= 17))
      {
        i = 17;
        j = 12;
        break;
      }
      if ((localCard.age >= 18) && (localCard.age <= 21))
      {
        i = 21;
        j = 18;
        break;
      }
      if (localCard.shGender != 0)
      {
        j = localCard.age - 5;
        i = localCard.age + 10;
        break;
      }
      i = localCard.age + 5;
      j = 18;
      break;
      j = this.pref.getInt("key_age_index_v2_1" + this.app.getCurrentAccountUin(), 0);
      i = this.pref.getInt("key_age_index_v2_2" + this.app.getCurrentAccountUin(), 0);
      continue;
      label357:
      i = 0;
      j = 0;
    }
  }
  
  public boolean ZK()
  {
    return this.bGX;
  }
  
  public boolean ZL()
  {
    boolean bool = this.pref.getBoolean("key_first_select_location" + this.app.getCurrentAccountUin(), true);
    if (bool) {
      this.pref.edit().putBoolean("key_first_select_location" + this.app.getCurrentAccountUin(), false).commit();
    }
    return bool;
  }
  
  public BaseAddress a(String paramString)
  {
    BaseAddress localBaseAddress = null;
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData != null) {
      localBaseAddress = (BaseAddress)this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.W.get(paramString);
    }
    return localBaseAddress;
  }
  
  public void a(int paramInt, File paramFile, GetResourceRespInfo paramGetResourceRespInfo)
  {
    boolean bool3 = true;
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "onConfigFileDownloadSuccess, result=" + paramInt + ", file=" + paramFile + ", resp=" + paramGetResourceRespInfo);
    }
    boolean bool1;
    if (paramInt == 0)
    {
      File localFile = new File(getConfigPath("admin_region_config"));
      if ((paramFile.renameTo(localFile)) || (paramFile.renameTo(localFile)) || (paramFile.renameTo(localFile)))
      {
        this.Ph = paramGetResourceRespInfo.uiNewVer;
        this.pref.edit().putLong("key_config_version", this.Ph).commit();
        bool1 = true;
        bool2 = bool1;
        if (QLog.isColorLevel()) {
          QLog.d("ConditionSearch.Manager", 2, "onCheckupConfig | rename result = " + bool1);
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = true)
    {
      if ((paramInt == 0) && (bool2)) {}
      for (bool1 = bool3;; bool1 = false)
      {
        EG(bool1);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  public void a(accv.c paramc)
  {
    this.b = paramc;
  }
  
  public void a(GetResourceRespInfo paramGetResourceRespInfo)
  {
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onCheckupConfig | resp = ").append(paramGetResourceRespInfo).append(" | iResult = ");
      if (paramGetResourceRespInfo != null)
      {
        i = paramGetResourceRespInfo.iResult;
        QLog.d("ConditionSearch.Manager", 2, i + ", needDownloadNow=" + this.bGY);
      }
    }
    else
    {
      if ((paramGetResourceRespInfo != null) && (paramGetResourceRespInfo.iResult == 0)) {
        break label93;
      }
      EG(false);
    }
    label93:
    boolean bool;
    do
    {
      do
      {
        return;
        i = -1000;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ConditionSearch.Manager", 2, "onCheckupConfig | local version = " + this.Ph + " | server version = " + paramGetResourceRespInfo.uiNewVer);
        }
      } while (this.Ph == paramGetResourceRespInfo.uiNewVer);
      localObject = paramGetResourceRespInfo.strResURL_big;
      this.mUrl = ((String)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ConditionSearch.Manager", 2, "onCheckupConfig | url is null");
        }
        EG(false);
        return;
      }
      File localFile = new File(getConfigPath("temp_admin_regin_config"));
      paramGetResourceRespInfo = new accv.a(this.app, (String)localObject, paramGetResourceRespInfo, localFile);
      if (this.bGY)
      {
        this.bGY = false;
        paramGetResourceRespInfo.realStart();
        return;
      }
      bool = ((aopo)this.app.getManager(193)).a(10023, "prd", (String)localObject, 0, (String)localObject, localFile.getAbsolutePath(), 2, 0, false, paramGetResourceRespInfo);
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "innerDownload, PreDownloadController.ret=" + bool);
      }
    } while (bool);
    EG(false);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt4, int paramInt5, int paramInt6)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seachFriend | restart = ").append(paramBoolean).append(" | keyword = ").append(paramString).append(" | sexIndex = ").append(paramInt1).append(" | ageIndex1 = ").append(paramInt2).append(" | ageIndex2 = ").append(paramInt3).append(" | jobIndex = ").append(paramInt4).append(" | xingzuoIndex = ").append(paramInt5).append(" | searchFromMore = ").append(paramInt6);
      int i;
      if ((paramArrayOfString1 != null) && (paramArrayOfString1.length > 0))
      {
        localStringBuilder.append(" | locCodes = ");
        i = 0;
        while (i < paramArrayOfString1.length)
        {
          localStringBuilder.append(paramArrayOfString1[i]).append("、");
          i += 1;
        }
      }
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0))
      {
        localStringBuilder.append(" | homeCodes = ");
        i = 0;
        while (i < paramArrayOfString2.length)
        {
          localStringBuilder.append(paramArrayOfString2[i]).append("、");
          i += 1;
        }
      }
      QLog.d("ConditionSearch.Manager", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      this.Pj += 1L;
      this.bnZ = paramString;
      this.cuF = paramInt1;
      this.cuG = paramInt2;
      this.cuH = paramInt3;
      this.dZ = paramArrayOfString1;
      this.ea = paramArrayOfString2;
      this.cuI = paramInt4;
      this.cuJ = paramInt5;
      this.cuK = -1;
      this.mSessionId = 0L;
    }
    while (this.hasMore)
    {
      this.cuL = 0;
      this.xl = null;
      this.app.addObserver(this.jdField_a_of_type_Acfd);
      ((FriendListHandler)this.app.getBusinessHandler(1)).a(this.Pj, this.cuK + 1, this.mSessionId, this.bnZ, this.cuF, this.cuG, this.cuH, this.dZ, this.ea, this.cuI, this.cuJ, paramInt6);
      return;
    }
    throw new RuntimeException("No more elements");
  }
  
  void a(boolean paramBoolean1, List<CondFitUser> paramList, boolean paramBoolean2, int paramInt)
  {
    this.app.removeObserver(this.jdField_a_of_type_Acfd);
    if (this.K != null)
    {
      Object localObject = new LinkedList();
      ((LinkedList)localObject).addAll(this.K);
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((accv.d)((Iterator)localObject).next()).b(paramBoolean1, paramList, paramBoolean2, paramInt);
      }
    }
  }
  
  public void aV(Object paramObject)
  {
    try
    {
      if (!this.xk.contains(paramObject))
      {
        this.xk.add(paramObject);
        this.bHb = true;
        gt(Ai());
        if ((paramObject instanceof ConditionSearchFriendActivity))
        {
          this.bGW = false;
          this.pref.edit().putBoolean("key_first_run" + this.app.getCurrentAccountUin(), false).commit();
        }
      }
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public void aW(Object paramObject)
  {
    try
    {
      this.xk.remove(paramObject);
      if (this.xk.size() == 0)
      {
        this.bHb = false;
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
  
  public void addListener(Object paramObject)
  {
    if ((paramObject instanceof accv.b))
    {
      if (this.J == null) {
        this.J = new LinkedList();
      }
      if (this.J.contains(paramObject)) {}
    }
    do
    {
      this.J.add((accv.b)paramObject);
      do
      {
        return;
      } while (!(paramObject instanceof accv.d));
      if (this.K == null) {
        this.K = new LinkedList();
      }
    } while (this.K.contains(paramObject));
    this.K.add((accv.d)paramObject);
  }
  
  public void bZ(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      this.pref.edit().putString("location_string" + this.app.getCurrentAccountUin(), paramString).commit();
      return;
    }
    this.pref.edit().putString("home_string" + this.app.getCurrentAccountUin(), paramString).commit();
  }
  
  public void cHY()
  {
    if (this.b != null) {
      this.b.ckb();
    }
  }
  
  public void cHZ()
  {
    if (this.bGX)
    {
      this.bGX = false;
      this.pref.edit().putBoolean("key_frist_run_in_5_2" + this.app.getCurrentAccountUin(), false).commit();
      this.pref.edit().putBoolean("key_frist_run_add_contact" + this.app.getCurrentAccountUin(), false).commit();
    }
  }
  
  public String d(String[] paramArrayOfString)
  {
    String str2 = e(paramArrayOfString);
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
  
  public String[] d(String[] paramArrayOfString)
  {
    int i = 1;
    if ((paramArrayOfString == null) || (paramArrayOfString.length != 4) || ("-1".equals(paramArrayOfString[0]))) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData == null)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfString = new StringBuilder().append("praseCodeArrayToAddress addressData == null is ");
        if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData != null) {
          break label79;
        }
      }
      label79:
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
    Object localObject1 = (BaseAddress)this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.W.get(paramArrayOfString[0]);
    if (localObject1 == null) {
      return arrayOfString;
    }
    arrayOfString[0] = ((BaseAddress)localObject1).name;
    while (i < 4)
    {
      Object localObject2 = localObject1;
      if (!"0".equals(paramArrayOfString[i]))
      {
        localObject2 = (BaseAddress)((BaseAddress)localObject1).dataMap.get(paramArrayOfString[i]);
        if (localObject2 == null) {
          break;
        }
        arrayOfString[i] = ((BaseAddress)localObject2).name;
      }
      i += 1;
      localObject1 = localObject2;
    }
    return arrayOfString;
  }
  
  public List<BaseAddress> dP()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData != null)
    {
      localArrayList = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.W.size());
      localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.W.values());
      Collections.sort(localArrayList, new accw(this));
    }
    return localArrayList;
  }
  
  public String dw(int paramInt)
  {
    if (paramInt == 0) {
      return this.pref.getString("location_string" + this.app.getCurrentAccountUin(), "不限");
    }
    return this.pref.getString("home_string" + this.app.getCurrentAccountUin(), "不限");
  }
  
  public String e(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length != 4) || ("-1".equals(paramArrayOfString[0]))) {
      return "0";
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "praseCodeArrayToAddress addressData == null is");
      }
      return "不限";
    }
    if ("-1".equals(paramArrayOfString[0])) {
      return "不限";
    }
    if (((AddressData)localObject1).W != null) {}
    for (localObject1 = (BaseAddress)((AddressData)localObject1).W.get(paramArrayOfString[0]); localObject1 == null; localObject1 = null) {
      return "不限";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((BaseAddress)localObject1).name);
    int i = 1;
    while (i < 4)
    {
      Object localObject2 = localObject1;
      if (!"0".equals(paramArrayOfString[i]))
      {
        localObject2 = (BaseAddress)((BaseAddress)localObject1).dataMap.get(paramArrayOfString[i]);
        if (localObject2 == null) {
          break;
        }
        localStringBuilder.append("-").append(((BaseAddress)localObject2).name);
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localStringBuilder.toString();
  }
  
  public final long f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.Pi = System.currentTimeMillis();
      this.pref.edit().putLong("key_last_checkup_time", this.Pi).commit();
      this.bHa = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "getConfigVersion | version = " + this.Ph);
    }
    return this.Ph;
  }
  
  public void gS(int paramInt1, int paramInt2)
  {
    this.pref.edit().putInt("key_age_index_v2_1" + this.app.getCurrentAccountUin(), paramInt1).commit();
    this.pref.edit().putInt("key_age_index_v2_2" + this.app.getCurrentAccountUin(), paramInt2).commit();
  }
  
  public int gt(int paramInt)
  {
    return q(paramInt, false);
  }
  
  public void j(Card paramCard)
  {
    this.bHc = true;
    this.e = paramCard;
    aV(this.cn);
    this.app.runOnUiThread(new ConditionSearchManager.4(this));
  }
  
  public String jd(String paramString)
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
  
  public String je(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("中国"))
    {
      String[] arrayOfString = aqmr.split(paramString, '-');
      str = paramString;
      if (arrayOfString.length >= 2)
      {
        paramString = new StringBuilder();
        int i = 1;
        while (i < arrayOfString.length)
        {
          paramString.append(arrayOfString[i]);
          if (i != arrayOfString.length - 1) {
            paramString.append("-");
          }
          i += 1;
        }
        str = paramString.toString();
      }
    }
    return str;
  }
  
  public String[] k(String paramString)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "不限";
    arrayOfString[1] = "不限";
    if ((!TextUtils.isEmpty(paramString)) && (!"不限".equals(paramString)))
    {
      int i = paramString.indexOf("-");
      if (i != -1)
      {
        arrayOfString[0] = paramString.substring(0, i);
        arrayOfString[1] = paramString.substring(i + 1);
      }
    }
    else
    {
      return arrayOfString;
    }
    arrayOfString[0] = paramString;
    return arrayOfString;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.destory();
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData = null;
    }
  }
  
  public int q(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "update, result=" + paramInt + ", downloadNow=" + paramBoolean);
    }
    if (paramInt == 1)
    {
      l = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("update | isCheckingUpdate = ").append(this.bHa).append(" | interval is enough ");
        if (Math.abs(l - this.Pi) >= 60000L)
        {
          bool = true;
          QLog.d("ConditionSearch.Manager", 2, bool + " | isNetAvaiable = " + aqiw.isNetSupport(this.app.getApp()));
        }
      }
      else
      {
        if (!this.bHa) {
          break label264;
        }
        if ((!paramBoolean) || (TextUtils.isEmpty(this.mUrl))) {
          break label246;
        }
        localObject = ((aopo)this.app.getManager(193)).a(this.mUrl);
        if (QLog.isColorLevel()) {
          QLog.d("ConditionSearch.Manager", 2, "update, find task=" + localObject);
        }
        if ((localObject != null) && ((localObject instanceof accv.a))) {
          ((accv.a)localObject).realStart();
        }
      }
    }
    label246:
    while (paramInt != 2)
    {
      long l;
      Object localObject;
      do
      {
        for (;;)
        {
          return 0;
          boolean bool = false;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ConditionSearch.Manager", 2, "update mUrl might be null");
      return 0;
      if (Math.abs(l - this.Pi) < 60000L) {
        return 1;
      }
      if (!aqiw.isNetSupport(this.app.getApp())) {
        return 2;
      }
      if ((this.bGY) || (paramBoolean)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.bGY = paramBoolean;
        localObject = (accy)this.app.getBusinessHandler(4);
        ((accy)localObject).a(null, new GetResourceReqInfo[] { ((accy)localObject).e() });
        return 0;
      }
    }
    label264:
    return Aj();
  }
  
  public void removeListener(Object paramObject)
  {
    if ((paramObject instanceof accv.b)) {
      if (this.J != null) {
        this.J.remove(paramObject);
      }
    }
    while ((!(paramObject instanceof accv.d)) || (this.K == null)) {
      return;
    }
    this.K.remove(paramObject);
  }
  
  public static class a
    extends aopm
  {
    public GetResourceRespInfo a;
    public File af;
    
    public a(QQAppInterface paramQQAppInterface, String paramString, GetResourceRespInfo paramGetResourceRespInfo, File paramFile)
    {
      super(paramString);
      this.a = paramGetResourceRespInfo;
      this.af = paramFile;
    }
    
    protected void realCancel()
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "DownloadTask realCancel");
      }
    }
    
    protected void realStart()
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "DownloadTask realStart");
      }
      String str = this.key;
      QQAppInterface localQQAppInterface = this.app;
      GetResourceRespInfo localGetResourceRespInfo = this.a;
      ThreadManagerV2.excute(new ConditionSearchManager.DownloadTask.1(this, str, this.af, localQQAppInterface, localGetResourceRespInfo), 128, null, true);
    }
    
    public String toString()
    {
      return "[DownloadTask] url=" + this.key;
    }
  }
  
  public static abstract interface b
  {
    public abstract void D(int paramInt, boolean paramBoolean);
  }
  
  public static abstract interface c
  {
    public abstract void ckb();
  }
  
  public static abstract interface d
  {
    public abstract void b(boolean paramBoolean1, List<CondFitUser> paramList, boolean paramBoolean2, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     accv
 * JD-Core Version:    0.7.0.1
 */