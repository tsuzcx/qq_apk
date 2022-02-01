import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.ad.materialdownload.MaterialData;
import com.tencent.biz.pubaccount.readinjoy.ad.view.KandianAdPandentMask;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
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
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class knj
{
  private static volatile knj jdField_a_of_type_Knj;
  public static boolean agB;
  knj.a jdField_a_of_type_Knj$a = null;
  private int aKj = 0;
  public boolean agA = true;
  private boolean agC;
  private boolean agz;
  public KandianAdPandentMask b;
  private WeakReference<ListView> ce;
  public AdvertisementInfo d;
  public int maskType;
  private SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSystemSharedPreferences("ReadInJoySuperMaskAd", 0);
  
  public static knj a()
  {
    if (jdField_a_of_type_Knj == null) {}
    try
    {
      if (jdField_a_of_type_Knj == null) {
        jdField_a_of_type_Knj = new knj();
      }
      return jdField_a_of_type_Knj;
    }
    finally {}
  }
  
  public static String iw()
  {
    try
    {
      String str = kxm.a().a("ad_mengceng", String.valueOf(1)).build();
      return str;
    }
    catch (JSONException localJSONException) {}
    return "";
  }
  
  private static long z(long paramLong)
  {
    return (TimeZone.getTimeZone("GMT+8").getOffset(paramLong) + paramLong) / 86400000L;
  }
  
  private boolean zT()
  {
    if (kxm.Bc()) {
      QLog.d("ReadInJoySuperMaskAd", 1, "should not show super mask, isFloatWindowShowing = true");
    }
    for (;;)
    {
      return false;
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      long l2 = cg();
      if ((l1 - l2 < 86400000L) && (z(l1) == z(l2))) {}
      for (int i = 1; (i == 0) || (l2 == -1L) || (zW()); i = 0) {
        return true;
      }
    }
  }
  
  public static boolean zV()
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
  
  public void T(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Knj$a != null) {
      this.jdField_a_of_type_Knj$a.T(paramInt, paramBoolean);
    }
  }
  
  public void V(long paramLong, int paramInt)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = str + "_" + String.valueOf(paramLong) + "_" + String.valueOf(paramInt);
    SharedPreferences.Editor localEditor = this.sharedPreferences.edit();
    localEditor.putBoolean(str, true);
    localEditor.apply();
  }
  
  public MaterialData a()
  {
    if ((this.d == null) || (this.d.mAdvertisementExtInfo == null)) {
      return null;
    }
    Iterator localIterator = kma.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).i(2).iterator();
    while (localIterator.hasNext())
    {
      MaterialData localMaterialData = (MaterialData)localIterator.next();
      if ((localMaterialData.adid.equals(String.valueOf(this.d.mAdAid))) && (localMaterialData.ad_source.equals(String.valueOf(this.d.mAdvertisementExtInfo.aJA)))) {
        return localMaterialData;
      }
    }
    return null;
  }
  
  public void a(ListView paramListView)
  {
    this.ce = new WeakReference(paramListView);
  }
  
  public void a(knj.a parama)
  {
    this.jdField_a_of_type_Knj$a = parama;
  }
  
  public void aCG()
  {
    if ((this.d != null) && (this.d.mAdvertisementExtInfo != null)) {
      jzk.a(new kku.a().a(BaseApplication.getContext()).a(jzk.aEK).b(jzk.aFY).a(this.d).e(new JSONObject()).a());
    }
  }
  
  public void aEQ()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    long l = NetConnInfoCenter.getServerTimeMillis();
    SharedPreferences.Editor localEditor = this.sharedPreferences.edit();
    localEditor.putLong(str + "_" + "RIJSuperMaskLastShowMaskTimeKey", l);
    localEditor.apply();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySuperMaskAd", 2, "current uni won't show today : " + str + " at time: " + l);
    }
  }
  
  public ListView b()
  {
    return (ListView)this.ce.get();
  }
  
  public ArrayList bc()
  {
    Object localObject = kma.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).i(2);
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MaterialData localMaterialData = (MaterialData)((Iterator)localObject).next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("adId", localMaterialData.adid);
      localHashMap.put("adSource", localMaterialData.ad_source);
      localHashMap.put("adMaterial", localMaterialData.ad_material);
      localArrayList.add(localHashMap);
    }
    return localArrayList;
  }
  
  public long cg()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    long l = this.sharedPreferences.getLong(str + "_" + "RIJSuperMaskLastShowMaskTimeKey", -1L);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySuperMaskAd", 2, "current uni last show time : " + str + " at time: " + l);
    }
    return l;
  }
  
  public void clean()
  {
    if (this.b != null) {
      this.b = null;
    }
  }
  
  public boolean g(long paramLong, int paramInt)
  {
    boolean bool2 = false;
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = str + "_" + String.valueOf(paramLong) + "_" + String.valueOf(paramInt);
    boolean bool1 = bool2;
    if (this.sharedPreferences.getBoolean(str, false))
    {
      bool1 = bool2;
      if (!zT()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int getMaskType()
  {
    return this.maskType;
  }
  
  public int getShowStatus()
  {
    return this.aKj;
  }
  
  public void h(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((!knd.r(paramAdvertisementInfo)) || (!zT()) || (!zV())) {
      return;
    }
    if (this.aKj == 4)
    {
      this.aKj = 0;
      return;
    }
    pl(1);
    this.d = paramAdvertisementInfo;
  }
  
  public String iv()
  {
    if ((this.d == null) || (this.d.mAdvertisementExtInfo == null) || (!zU())) {
      return "";
    }
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = kma.a((QQAppInterface)localObject1).O(String.valueOf(this.d.mAdvertisementExtInfo.aJA), String.valueOf(this.d.mAdAid));
    Object localObject2 = new File(str, "manifest.json");
    if ((!((File)localObject2).exists()) || (!((File)localObject2).isFile()) || (!((File)localObject2).canRead()))
    {
      kma.a((QQAppInterface)localObject1).bt(String.valueOf(this.d.mAdvertisementExtInfo.aJA), String.valueOf(this.d.mAdAid));
      return "";
    }
    Object localObject3 = new StringBuffer();
    dx.a((StringBuffer)localObject3, ((File)localObject2).getPath());
    localObject2 = ((StringBuffer)localObject3).toString();
    try
    {
      localObject3 = new JSONObject((String)localObject2);
      localObject2 = ((JSONObject)localObject3).getString("animFileName");
      this.maskType = ((JSONObject)localObject3).optInt("superMaskType", 1);
      if (localObject2 != null)
      {
        localObject3 = new File(str, (String)localObject2);
        if ((!((File)localObject3).exists()) || (!((File)localObject3).isFile()) || (!((File)localObject3).canRead()))
        {
          kma.a((QQAppInterface)localObject1).bt(String.valueOf(this.d.mAdvertisementExtInfo.aJA), String.valueOf(this.d.mAdAid));
          return "";
        }
        localObject1 = str + (String)localObject2;
        return localObject1;
      }
    }
    catch (JSONException localJSONException)
    {
      return "";
    }
    return "";
  }
  
  public void mr(boolean paramBoolean)
  {
    if ((this.b != null) && (this.b.zY())) {
      this.b.mr(paramBoolean);
    }
  }
  
  public void ms(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySuperMaskAd", 2, "setShouldAskSuperMask = " + paramBoolean);
    }
    if ((zT()) && (zV()))
    {
      this.agz = paramBoolean;
      return;
    }
    this.agz = false;
  }
  
  public void mt(boolean paramBoolean)
  {
    this.agC = paramBoolean;
  }
  
  public void pl(int paramInt)
  {
    this.aKj = paramInt;
    if ((paramInt == 4) && (this.b != null) && (this.b.zY())) {
      this.b.aES();
    }
  }
  
  public void pm(int paramInt)
  {
    if ((this.d != null) && (this.d.mAdvertisementExtInfo != null))
    {
      if (paramInt == 1)
      {
        agB = true;
        kbp.a(null, "", "0X8009819", "0X8009819", 0, 0, "", "", "", iw(), false);
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
      if ((paramInt == jzk.aEJ) || (paramInt == jzk.aFl))
      {
        localJSONObject2.put("volumn", this.d.mAdvertisementExtInfo.aas);
        if (this.maskType != 1)
        {
          if (this.maskType != 3) {
            break label246;
          }
          String str1 = "1";
          label121:
          localJSONObject2.put("is_transparent", str1);
        }
        localJSONObject1.put("click_info_report", String.valueOf(localJSONObject2));
        jzk.a(new kku.a().a(BaseApplication.getContext()).a(paramInt).b(jzk.aFY).a(this.d).e(localJSONObject1).a());
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ReadInJoySuperMaskAd", 1, new Object[] { "JSONException", localJSONException.toString() });
      return;
    }
    if (this.d.mAdvertisementExtInfo.aas.equals("1")) {}
    for (String str2 = "0";; str2 = "1")
    {
      localJSONObject2.put("volumn", str2);
      break;
      label246:
      str2 = "";
      break label121;
    }
  }
  
  public void pn(int paramInt)
  {
    if (this.jdField_a_of_type_Knj$a != null) {
      this.jdField_a_of_type_Knj$a.pn(paramInt);
    }
  }
  
  public boolean zS()
  {
    return this.agz;
  }
  
  public boolean zU()
  {
    Iterator localIterator = kma.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).i(2).iterator();
    while (localIterator.hasNext())
    {
      MaterialData localMaterialData = (MaterialData)localIterator.next();
      if ((localMaterialData.ad_source.equals(String.valueOf(this.d.mAdvertisementExtInfo.aJA))) && (localMaterialData.adid.equals(String.valueOf(this.d.mAdAid))) && (localMaterialData.res_version == this.d.mAdvertisementExtInfo.aJI)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean zW()
  {
    return aqmj.bj(BaseApplicationImpl.getApplication(), BaseApplicationImpl.getApplication().getRuntime().getAccount()) == 1;
  }
  
  public boolean zX()
  {
    return this.agC;
  }
  
  public static abstract interface a
  {
    public abstract void T(int paramInt, boolean paramBoolean);
    
    public abstract void pn(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     knj
 * JD-Core Version:    0.7.0.1
 */