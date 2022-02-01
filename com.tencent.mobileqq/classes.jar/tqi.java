import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class tqi
{
  private static volatile tqi jdField_a_of_type_Tqi;
  public static boolean a;
  public int a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSystemSharedPreferences("ReadInJoySuperMaskAd", 0);
  public AdvertisementInfo a;
  private WeakReference<ListView> jdField_a_of_type_JavaLangRefWeakReference;
  tqj jdField_a_of_type_Tqj = null;
  public trs a;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  
  private static long a(long paramLong)
  {
    return (TimeZone.getTimeZone("GMT+8").getOffset(paramLong) + paramLong) / 86400000L;
  }
  
  public static String a()
  {
    try
    {
      String str = ozs.a().a("ad_mengceng", String.valueOf(1)).a();
      return str;
    }
    catch (JSONException localJSONException) {}
    return "";
  }
  
  public static tqi a()
  {
    if (jdField_a_of_type_Tqi == null) {}
    try
    {
      if (jdField_a_of_type_Tqi == null) {
        jdField_a_of_type_Tqi = new tqi();
      }
      return jdField_a_of_type_Tqi;
    }
    finally {}
  }
  
  private void a(long paramLong, int paramInt)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = str + "_" + paramLong + "_" + paramInt;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    tpx.a("ReadInJoySuperMaskAd", "setAdInfoExposure: aid = " + paramLong + " adSource = " + paramInt);
    localEditor.putBoolean(str, true);
    localEditor.apply();
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo, JSONObject paramJSONObject1, JSONObject paramJSONObject2, int paramInt1, int paramInt2)
  {
    if (tqa.l(paramAdvertisementInfo)) {}
    try
    {
      if (paramAdvertisementInfo.mAdvertisementExtInfo.n == 3) {
        paramJSONObject2.put("is_transparent", "1");
      }
      while (paramInt1 == nzq.jdField_a_of_type_Int)
      {
        nzq.a(null, "0X8009819", "0X8009819", 0, 0, "", "", "", a());
        if (paramAdvertisementInfo.mAdvertisementExtInfo.n != 1) {
          paramJSONObject2.put("volumn", paramAdvertisementInfo.mAdvertisementExtInfo.f);
        }
        if (paramJSONObject1 == null) {
          break label213;
        }
        paramJSONObject1.put("click_info_report", String.valueOf(paramJSONObject2));
        return;
        if (paramAdvertisementInfo.mAdvertisementExtInfo.n == 2) {
          paramJSONObject2.put("is_transparent", "");
        }
      }
      if (paramInt1 == nzq.jdField_b_of_type_Int)
      {
        if (paramJSONObject1 != null) {
          if ((paramAdvertisementInfo.adExperimentData != null) && (paramInt2 == nzq.ap))
          {
            if (paramAdvertisementInfo.adExperimentData.a() != 1) {
              break label202;
            }
            paramJSONObject2.put("stat_type", "2");
            QLog.d("ReadInJoySuperMaskAd", 1, "fillReportDataAndReportAdEvent: 宽口径曝光");
          }
        }
        for (;;)
        {
          paramJSONObject1.put("exposure_info_report", String.valueOf(paramJSONObject2));
          nzq.a(null, "0X8008C80", "0X8008C80", 0, 0, "", "", "", a());
          return;
          label202:
          QLog.d("ReadInJoySuperMaskAd", 1, "fillReportDataAndReportAdEvent: 严口径曝光");
        }
      }
      label213:
      return;
    }
    catch (Exception paramAdvertisementInfo) {}
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 0);
  }
  
  public static boolean f()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(206);
    if (localAladdinConfig != null)
    {
      int i = localAladdinConfig.getIntegerFromString("ad_mengceng", 0);
      QLog.d("ReadInJoySuperMaskAd", 1, new Object[] { "should show super mask, value = ", Integer.valueOf(i) });
      return i == 1;
    }
    return false;
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long a()
  {
    long l1;
    if (this.jdField_b_of_type_Int < 0) {
      l1 = NetConnInfoCenter.getServerTimeMillis();
    }
    String str;
    long l2;
    do
    {
      return l1;
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(a(this.jdField_b_of_type_Int, "RIJSuperMaskLastShowMaskTimeKey"), -1L);
      l1 = l2;
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoySuperMaskAd", 2, "current uni last show time : " + str + " at time: " + l2);
    return l2;
  }
  
  public MaterialData a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo == null)) {
      return null;
    }
    Iterator localIterator = tny.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(2).iterator();
    while (localIterator.hasNext())
    {
      MaterialData localMaterialData = (MaterialData)localIterator.next();
      if ((localMaterialData.adid.equals(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAid))) && (localMaterialData.ad_source.equals(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.j)))) {
        return localMaterialData;
      }
    }
    return null;
  }
  
  public ListView a()
  {
    return (ListView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public String a(int paramInt, String paramString)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return str + "_" + paramInt + "_" + paramString;
  }
  
  public String a(MaterialData paramMaterialData)
  {
    if (!e())
    {
      tqk.a.a(paramMaterialData, false, "version not match");
      return "";
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo == null)) {
      return "";
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = tny.a(localQQAppInterface).b(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.j), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAid));
    Object localObject1 = new File(str, "manifest.json");
    if ((!((File)localObject1).exists()) || (!((File)localObject1).isFile()) || (!((File)localObject1).canRead()))
    {
      tny.a(localQQAppInterface).a(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.j), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAid));
      tqk.a.a(paramMaterialData, false, "no manifest");
      return "";
    }
    Object localObject2 = new StringBuffer();
    fd.a((StringBuffer)localObject2, ((File)localObject1).getPath());
    localObject1 = ((StringBuffer)localObject2).toString();
    try
    {
      localObject2 = new JSONObject((String)localObject1);
      localObject1 = ((JSONObject)localObject2).getString("animFileName");
      this.jdField_a_of_type_Int = ((JSONObject)localObject2).optInt("superMaskType", 1);
      if (localObject1 != null)
      {
        localObject2 = new File(str, (String)localObject1);
        if ((!((File)localObject2).exists()) || (!((File)localObject2).isFile()) || (!((File)localObject2).canRead()))
        {
          tny.a(localQQAppInterface).a(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.j), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAid));
          tqk.a.a(paramMaterialData, false, "no animFileName");
          return "";
        }
        paramMaterialData = str + (String)localObject1;
        return paramMaterialData;
      }
    }
    catch (JSONException paramMaterialData)
    {
      return "";
    }
    return "";
  }
  
  public ArrayList a()
  {
    Object localObject = tny.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(2);
    ArrayList localArrayList = new ArrayList();
    localObject = ((CopyOnWriteArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MaterialData localMaterialData = (MaterialData)((Iterator)localObject).next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("adId", localMaterialData.adid);
      localHashMap.put("adSource", localMaterialData.ad_source);
      localHashMap.put("adMaterial", localMaterialData.ad_material);
      localHashMap.put("version", Integer.valueOf(localMaterialData.res_version));
      localHashMap.put("md5", localMaterialData.res_md5);
      localHashMap.put("adType", Integer.valueOf(localMaterialData.ad_type));
      localHashMap.put("subAdId", localMaterialData.sub_adid);
      localHashMap.put("startTime", Long.valueOf(localMaterialData.start_time));
      localHashMap.put("endTime", Long.valueOf(localMaterialData.end_time));
      localHashMap.put("deliveryEffect", Integer.valueOf(localMaterialData.delivery_effect));
      localArrayList.add(localHashMap);
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Int < 0) {}
    String str;
    long l;
    do
    {
      return;
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      l = NetConnInfoCenter.getServerTimeMillis();
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putLong(a(this.jdField_b_of_type_Int, "RIJSuperMaskLastShowMaskTimeKey"), l);
      localEditor.apply();
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoySuperMaskAd", 2, "current uni won't show today : " + str + " at time: " + l);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Tqj != null) {
      this.jdField_a_of_type_Tqj.a(paramInt, paramBoolean);
    }
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (!f())
    {
      tpx.a("ReadInJoySuperMaskAd", "notGetShowConfigFromAladdin");
      return;
    }
    if (!tqa.l(paramAdvertisementInfo))
    {
      tpx.a("ReadInJoySuperMaskAd", "isNotSuperMaskAdType");
      return;
    }
    b();
    if (!b())
    {
      tpx.a("ReadInJoySuperMaskAd", "notShowLargeThanOneDay");
      return;
    }
    if (this.jdField_c_of_type_Int == 4)
    {
      this.jdField_c_of_type_Int = 0;
      tqk.a.a(paramAdvertisementInfo, false, "is not show main or daily feeds");
      return;
    }
    b(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if ((tqa.l(paramAdvertisementInfo)) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (paramInt == nzq.jdField_b_of_type_Int)) {
      a(paramAdvertisementInfo.mAdAid, paramAdvertisementInfo.mAdvertisementExtInfo.j);
    }
  }
  
  public void a(ListView paramListView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramListView);
  }
  
  public void a(tqj paramtqj)
  {
    this.jdField_a_of_type_Tqj = paramtqj;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Trs != null) && (this.jdField_a_of_type_Trs.a())) {
      this.jdField_a_of_type_Trs.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Boolean) && (a().c()) && (f());
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long b()
  {
    long l1;
    if (this.jdField_b_of_type_Int < 0) {
      l1 = NetConnInfoCenter.getServerTimeMillis();
    }
    String str;
    long l2;
    do
    {
      return l1;
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(a(this.jdField_b_of_type_Int, "RIJSuperMaskLastReceiveMaskTimeKey"), -1L);
      l1 = l2;
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoySuperMaskAd", 2, "current uni last show time : " + str + " at time: " + l2);
    return l2;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Int < 0) {}
    String str;
    long l;
    do
    {
      return;
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      l = NetConnInfoCenter.getServerTimeMillis();
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putLong(a(this.jdField_b_of_type_Int, "RIJSuperMaskLastReceiveMaskTimeKey"), l);
      localEditor.apply();
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoySuperMaskAd", 2, "current uni won't receive today : " + str + " at time: " + l);
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    if ((paramInt == 4) && (this.jdField_a_of_type_Trs != null) && (this.jdField_a_of_type_Trs.a())) {
      this.jdField_a_of_type_Trs.a();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySuperMaskAd", 2, "setShouldAskSuperMask = " + paramBoolean);
    }
    if ((b()) && (f()))
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    if (ozs.y()) {
      QLog.d("ReadInJoySuperMaskAd", 1, "should not show super mask, isFloatWindowShowing = true");
    }
    for (;;)
    {
      return false;
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      long l2 = a();
      if ((l1 - l2 < 86400000L) && (a(l1) == a(l2))) {}
      for (int i = 1; (i == 0) || (l2 == -1L) || (g()); i = 0) {
        return true;
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Trs != null) {
      this.jdField_a_of_type_Trs = null;
    }
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo != null))
    {
      if (paramInt == 1)
      {
        jdField_a_of_type_Boolean = true;
        ocd.a(null, "", "0X8009819", "0X8009819", 0, 0, "", "", "", a(), false);
      }
    }
    else {
      return;
    }
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject2 = new JSONObject();
      if ((paramInt == nzq.jdField_a_of_type_Int) || (paramInt == nzq.C))
      {
        localJSONObject2.put("volumn", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.f);
        if (paramInt == nzq.C)
        {
          if (NetConnInfoCenter.getServerTimeMillis() - a().a() < 1000) {
            break label274;
          }
          localJSONObject2.put("is_jump_mc", "2");
        }
        label134:
        if (this.jdField_a_of_type_Int != 1)
        {
          if (this.jdField_a_of_type_Int != 3) {
            break label288;
          }
          String str1 = "1";
          label153:
          localJSONObject2.put("is_transparent", str1);
        }
        localJSONObject1.put("click_info_report", String.valueOf(localJSONObject2));
        nzq.a(new tlx().a(BaseApplication.getContext()).a(paramInt).b(nzq.ap).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(localJSONObject1).a());
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ReadInJoySuperMaskAd", 1, new Object[] { "JSONException", localJSONException.toString() });
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.f.equals("1")) {}
    for (String str2 = "0";; str2 = "1")
    {
      localJSONObject2.put("volumn", str2);
      break;
      label274:
      localJSONObject2.put("is_jump_mc", "1");
      break label134;
      label288:
      str2 = "";
      break label153;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = b();
    if (l2 == -1L)
    {
      tpx.a("ReadInJoySuperMaskAd", "receiveMaskTimeLargeThanOneDay : lastReceiveTime == -1");
      return true;
    }
    if ((l1 - l2 >= 86400000L) || (a(l1) != a(l2)))
    {
      tpx.a("ReadInJoySuperMaskAd", "receiveMaskTimeLargeThanOneDay : not in one day");
      return true;
    }
    if (g())
    {
      tpx.a("ReadInJoySuperMaskAd", "receiveMaskTimeLargeThanOneDay : isPreviewMode");
      return true;
    }
    tpx.a("ReadInJoySuperMaskAd", "receiveMaskTimeLargeThanOneDay : false");
    return false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Tqj != null) {
      this.jdField_a_of_type_Tqj = null;
    }
  }
  
  public void d(int paramInt)
  {
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo != null))
    {
      localStringBuilder = new StringBuilder().append("ReadInJoySuperMaskAdUtil.reportExposure: exposureType = ");
      if (paramInt != 1) {
        break label138;
      }
    }
    label138:
    for (String str = "宽口径";; str = "严口径")
    {
      QLog.d("ReadInJoySuperMaskAd", 1, str);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.adExperimentData == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.adExperimentData = new tmg();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.adExperimentData.a(paramInt);
      nzq.a(new tlx().a(BaseApplication.getContext()).a(nzq.jdField_b_of_type_Int).b(nzq.ap).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(new JSONObject()).a());
      return;
    }
  }
  
  public boolean d()
  {
    return (this.jdField_b_of_type_Int == 0) || (pbd.c(this.jdField_b_of_type_Int));
  }
  
  public void e(int paramInt)
  {
    if (this.jdField_a_of_type_Tqj != null) {
      this.jdField_a_of_type_Tqj.a(paramInt);
    }
  }
  
  public boolean e()
  {
    Iterator localIterator = tny.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(2).iterator();
    while (localIterator.hasNext())
    {
      MaterialData localMaterialData = (MaterialData)localIterator.next();
      if ((localMaterialData.ad_source.equals(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.j))) && (localMaterialData.adid.equals(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAid))) && (localMaterialData.res_version == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.r)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean g()
  {
    return bhsi.aA(BaseApplicationImpl.getApplication(), BaseApplicationImpl.getApplication().getRuntime().getAccount()) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tqi
 * JD-Core Version:    0.7.0.1
 */