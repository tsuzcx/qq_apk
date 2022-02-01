import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.ExclusiveGiftItem;
import tencent.im.oidb.cmd0xcd1.Oidb_0xcd1.EmptyPackagePage;

public class snf
{
  public boolean MX;
  public sna.a a;
  public sna.b a;
  public sna.c a;
  public snf.a a;
  public snf.b a;
  public snf.c a;
  public String aEX;
  public String aEY;
  public SparseArray<apsz.a> bg = new SparseArray();
  public SparseArray<apsz.b> bh = new SparseArray();
  public int bye;
  public int byf;
  public int byg = -1;
  public int byh = -1;
  public int byi;
  public long date;
  public String mData;
  public ArrayList<Object> oj;
  public ArrayList<Object> ok;
  public ArrayList<Object> ol;
  public ArrayList<Object> om;
  public ArrayList<Object> on;
  public ArrayList<snf.e> oo;
  
  public snf(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      this.mData = paramJSONObject.toString();
      try
      {
        Object localObject1 = paramJSONObject.optString("date");
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String)localObject1).getTime();
        this.MX = paramJSONObject.optBoolean("isShowRedDot");
        this.aEX = paramJSONObject.optString("defaultPackageID");
        this.bye = paramJSONObject.optInt("defaultPersonalID");
        this.byf = paramJSONObject.optInt("defaultPublicID");
        this.aEY = paramJSONObject.optString("defaultQuantity");
        Object localObject6 = paramJSONObject.optJSONArray("items_personal");
        Object localObject4 = paramJSONObject.optJSONArray("items_public");
        Object localObject7 = paramJSONObject.optJSONArray("items_custom");
        Object localObject5 = paramJSONObject.optJSONArray("items_interact");
        JSONArray localJSONArray1 = paramJSONObject.optJSONArray("items_exclusive_lib");
        Object localObject3 = paramJSONObject.optJSONArray("items_package_lib");
        JSONArray localJSONArray2 = paramJSONObject.optJSONArray("items_personal_tab");
        Object localObject2 = paramJSONObject.optJSONArray("items_personal_free_tab");
        localObject1 = paramJSONObject.optJSONArray("web_panel_tab");
        JSONObject localJSONObject1 = paramJSONObject.optJSONObject("operationInfo");
        JSONObject localJSONObject2 = paramJSONObject.optJSONObject("coinInfo");
        if ((localObject7 != null) && (localObject6 != null))
        {
          j = ((JSONArray)localObject7).length();
          this.oj = new ArrayList();
          i = 0;
          if (i < j)
          {
            Object localObject8 = ((JSONArray)localObject7).optJSONObject(i);
            if (localObject8 != null)
            {
              localObject8 = new sne((JSONObject)localObject8, i);
              if (((sne)localObject8).bxY <= 4) {
                break label293;
              }
            }
            for (;;)
            {
              i += 1;
              break;
              label293:
              this.oj.add(localObject8);
            }
          }
          j = ((JSONArray)localObject6).length();
          i = 0;
          if (i < j)
          {
            localObject7 = ((JSONArray)localObject6).optJSONObject(i);
            if (localObject7 != null)
            {
              localObject7 = new sne((JSONObject)localObject7, this.oj.size());
              if (((sne)localObject7).bxY <= 4) {
                break label368;
              }
            }
            for (;;)
            {
              i += 1;
              break;
              label368:
              if (((sne)localObject7).bxX != 0) {
                this.oj.add(localObject7);
              }
            }
          }
        }
        else if (localObject6 != null)
        {
          j = ((JSONArray)localObject6).length();
          this.oj = new ArrayList();
          i = 0;
          if (i < j)
          {
            localObject7 = ((JSONArray)localObject6).optJSONObject(i);
            if (localObject7 != null)
            {
              localObject7 = new sne((JSONObject)localObject7, this.oj.size());
              if (((sne)localObject7).bxY <= 4) {
                break label467;
              }
            }
            for (;;)
            {
              i += 1;
              break;
              label467:
              this.oj.add(localObject7);
            }
          }
        }
        if (localObject5 != null)
        {
          j = ((JSONArray)localObject5).length();
          this.om = new ArrayList(j);
          i = 0;
          if (i < j)
          {
            localObject6 = ((JSONArray)localObject5).optJSONObject(i);
            if (localObject6 != null)
            {
              localObject6 = new sne((JSONObject)localObject6, i);
              if (((sne)localObject6).bxY <= 4) {
                break label554;
              }
            }
            for (;;)
            {
              i += 1;
              break;
              label554:
              ((sne)localObject6).aMf = true;
              this.om.add(localObject6);
            }
          }
        }
        if (localObject4 != null)
        {
          j = ((JSONArray)localObject4).length();
          if (this.om == null) {
            this.om = new ArrayList(j);
          }
          i = 0;
          if (i < j)
          {
            localObject5 = ((JSONArray)localObject4).optJSONObject(i);
            if (localObject5 != null)
            {
              localObject5 = new sne((JSONObject)localObject5, this.om.size());
              if (((sne)localObject5).bxY <= 2) {
                break label660;
              }
            }
            for (;;)
            {
              i += 1;
              break;
              label660:
              this.om.add(localObject5);
            }
          }
        }
        if (localJSONObject1 != null) {
          this.jdField_a_of_type_Snf$c = new snf.c(localJSONObject1);
        }
        if (localJSONObject2 != null) {
          this.jdField_a_of_type_Snf$a = new snf.a(localJSONObject2);
        }
        a(localJSONArray1, paramString);
        if (localObject3 != null)
        {
          j = ((JSONArray)localObject3).length();
          if (this.on == null) {
            this.on = new ArrayList(j);
          }
          i = 0;
          if (i < j)
          {
            localObject4 = ((JSONArray)localObject3).optJSONObject(i);
            if (localObject4 != null)
            {
              localObject4 = new sne((JSONObject)localObject4, i);
              if (((sne)localObject4).bxY <= 4) {
                break label797;
              }
            }
            for (;;)
            {
              i += 1;
              break;
              label797:
              ((sne)localObject4).bxY = 5;
              ((sne)localObject4).aMh = true;
              this.on.add(localObject4);
            }
          }
        }
        this.jdField_a_of_type_Sna$a = sna.a(paramJSONObject.optJSONObject("activityInfo"));
        localObject3 = paramJSONObject.optJSONObject("profileCard");
        if (localObject3 != null) {
          this.jdField_a_of_type_Sna$c = sna.a(((JSONObject)localObject3).optJSONObject("giftItem"));
        }
        this.jdField_a_of_type_Sna$b = sna.a(paramJSONObject.optJSONObject("panelEntry"));
        paramJSONObject = new HashMap();
        if ((this.oj != null) && (this.oj.size() > 0))
        {
          localObject3 = this.oj.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = ((Iterator)localObject3).next();
            if ((localObject4 instanceof sne))
            {
              localObject4 = (sne)localObject4;
              paramJSONObject.put(Integer.valueOf(((sne)localObject4).bxW), localObject4);
            }
          }
        }
        int k;
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
        {
          j = ((JSONArray)localObject2).length();
          this.ol = new ArrayList(j);
          i = 0;
          while (i < j)
          {
            localObject3 = ((JSONArray)localObject2).optJSONObject(i);
            if (localObject3 != null)
            {
              localObject3 = new snf.d((JSONObject)localObject3);
              this.ol.add(localObject3);
              localObject4 = ((snf.d)localObject3).oq.iterator();
              while (((Iterator)localObject4).hasNext())
              {
                k = ((Integer)((Iterator)localObject4).next()).intValue();
                if (paramJSONObject.containsKey(Integer.valueOf(k))) {
                  ((snf.d)localObject3).or.add(paramJSONObject.get(Integer.valueOf(k)));
                }
              }
            }
            i += 1;
          }
        }
        if (localJSONArray2 != null)
        {
          int n = localJSONArray2.length();
          if (this.ok == null) {
            this.ok = new ArrayList(n);
          }
          j = 0;
          if (j < n)
          {
            localObject2 = localJSONArray2.optJSONObject(j);
            if (localObject2 != null)
            {
              localObject2 = new snf.d((JSONObject)localObject2);
              if ((!TextUtils.isEmpty(((snf.d)localObject2).name)) && (((snf.d)localObject2).oq != null) && (((snf.d)localObject2).or != null)) {
                break label1214;
              }
            }
            for (;;)
            {
              j += 1;
              break;
              label1214:
              localObject3 = ((snf.d)localObject2).oq.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                int i1 = ((Integer)((Iterator)localObject3).next()).intValue();
                if (paramJSONObject.containsKey(Integer.valueOf(i1)))
                {
                  int m = 1;
                  i = m;
                  int i3;
                  if (localJSONArray1 != null)
                  {
                    i3 = localJSONArray1.length();
                    k = 0;
                  }
                  for (;;)
                  {
                    i = m;
                    int i2;
                    if (k < i3)
                    {
                      localObject4 = localJSONArray1.optJSONObject(k);
                      if (localObject4 != null)
                      {
                        i2 = ((JSONObject)localObject4).optInt("packageID");
                        if ((((JSONObject)localObject4).optInt("giftType") != 0) || (i2 != i1)) {}
                      }
                    }
                    else
                    {
                      for (;;)
                      {
                        try
                        {
                          localObject4 = new JSONArray(paramString);
                          i = 0;
                          if (i >= ((JSONArray)localObject4).length()) {
                            break label1597;
                          }
                          k = ((Integer)((JSONArray)localObject4).get(i)).intValue();
                          if (k != i2) {
                            continue;
                          }
                          i = 1;
                        }
                        catch (Exception localException)
                        {
                          if (!QLog.isColorLevel()) {
                            continue;
                          }
                          QLog.e("TroopGiftAioPanelData", 2, "mergeExclusiveGift search exp:", localException);
                          i = 0;
                          continue;
                        }
                        if (i == 0) {
                          break;
                        }
                        ((snf.d)localObject2).or.add(paramJSONObject.get(Integer.valueOf(i1)));
                        break;
                        i += 1;
                      }
                    }
                    k += 1;
                  }
                }
              }
              this.ok.add(localObject2);
            }
          }
        }
        if ((this.ol != null) && (this.ol.size() > 0))
        {
          i = 0;
          paramJSONObject = this.ol.iterator();
          while (paramJSONObject.hasNext())
          {
            paramString = paramJSONObject.next();
            this.ok.add(i, paramString);
            i += 1;
          }
        }
        if (localObject1 == null) {
          continue;
        }
        int j = ((JSONArray)localObject1).length();
        if (this.oo == null) {
          this.oo = new ArrayList(j);
        }
        i = 0;
        while (i < j)
        {
          paramJSONObject = ((JSONArray)localObject1).optJSONObject(i);
          if (paramJSONObject != null)
          {
            paramJSONObject = new snf.e(paramJSONObject);
            this.oo.add(paramJSONObject);
          }
          i += 1;
        }
      }
      catch (ParseException localParseException)
      {
        for (;;)
        {
          continue;
          label1597:
          int i = 0;
        }
      }
    }
  }
  
  public static snf a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, "");
  }
  
  public static snf a(Context paramContext, int paramInt, String paramString)
  {
    long l = System.currentTimeMillis();
    String str = aqfe.get(paramContext, "troop_gift_aio_panel_data_v2_" + paramInt);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(str);
        if (paramInt != 5) {
          break label159;
        }
        paramContext = nC();
        paramContext = new snf(localJSONObject, paramContext);
        if (!QLog.isColorLevel()) {
          break label157;
        }
        QLog.d("TroopGiftPanel.time", 2, "getLocalGiftData, time=" + (System.currentTimeMillis() - l) + ", data.len=" + str.length());
        return paramContext;
      }
      catch (JSONException paramContext)
      {
        label122:
        if (!QLog.isColorLevel()) {
          break label148;
        }
        QLog.d("zivonchen", 2, QLog.getStackTraceString(paramContext));
      }
      paramContext = gG(paramString);
      continue;
      label148:
      return null;
      label157:
      label159:
      do
      {
        paramContext = "";
        break;
        return paramContext;
        if ((paramInt == 1) || (paramInt == 6)) {
          break label122;
        }
      } while (paramInt != 4);
    }
  }
  
  public static void cN(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return;
      BaseApplication localBaseApplication = BaseApplication.getContext();
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      paramString2 = "exclusive_gift_ids_troop_" + str + "_" + paramString2;
      aqfe.J(localBaseApplication, paramString2, paramString1);
    } while (!QLog.isColorLevel());
    QLog.d("TroopGiftAioPanelData", 2, "saveTroopExclusiveGiftIds, key=" + paramString2 + ", data=" + paramString1);
  }
  
  public static void cO(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return;
      BaseApplication localBaseApplication = BaseApplication.getContext();
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      paramString1 = "troop_gift_last_receiver_" + str + "_" + paramString1;
      aqfe.J(localBaseApplication, paramString1, paramString2);
    } while (!QLog.isColorLevel());
    QLog.d("TroopGiftAioPanelData", 2, "saveLastGiftReceiver, key=" + paramString1 + ", data=" + paramString2);
  }
  
  public static String gG(String paramString)
  {
    Object localObject = BaseApplication.getContext();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    paramString = "exclusive_gift_ids_troop_" + str + "_" + paramString;
    localObject = aqfe.get((Context)localObject, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAioPanelData", 2, "getTroopExclusiveGiftIds, key=" + paramString + ", data=" + (String)localObject);
    }
    return localObject;
  }
  
  public static String gH(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return aqfe.get(localBaseApplication, "troop_gift_last_receiver_" + str + "_" + paramString);
  }
  
  public static String nC()
  {
    Object localObject = BaseApplication.getContext();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "exclusive_gift_ids_c2c_" + str;
    localObject = aqfe.get((Context)localObject, str);
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAioPanelData", 2, "getC2CExclusiveGiftIds, key=" + str + ", data=" + (String)localObject);
    }
    return localObject;
  }
  
  public static void tr(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "exclusive_gift_ids_c2c_" + str;
    aqfe.J(localBaseApplication, str, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAioPanelData", 2, "saveC2CExclusiveGiftIds, key=" + str + ", data=" + paramString);
    }
  }
  
  public static String v(List<oidb_0x6c3.ExclusiveGiftItem> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        localJSONArray.put(((oidb_0x6c3.ExclusiveGiftItem)paramList.get(i)).gift_id.get());
        i += 1;
      }
    }
    return localJSONArray.toString();
  }
  
  public void X(Context paramContext, int paramInt)
  {
    if (!TextUtils.isEmpty(this.mData)) {
      aqfe.J(paramContext, "troop_gift_aio_panel_data_v2_" + paramInt, this.mData);
    }
  }
  
  protected void a(JSONArray paramJSONArray, String paramString)
  {
    int k = 0;
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAioPanelData", 2, "mergeExclusiveGift jsonArrayExclusive is empty");
      }
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopGiftAioPanelData", 2, "mergeExclusiveGift exclusiveGiftIds is empty");
    return;
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    int i;
    label98:
    int j;
    try
    {
      paramString = new JSONArray(paramString);
      if ((paramString.length() > 0) && (paramJSONArray.length() > 0))
      {
        i = 0;
        if (i < paramString.length())
        {
          int m = ((Integer)paramString.get(i)).intValue();
          j = 0;
          label122:
          if (j >= paramJSONArray.length()) {
            break label486;
          }
          JSONObject localJSONObject = paramJSONArray.optJSONObject(j);
          int n = localJSONObject.optInt("packageID");
          int i1 = localJSONObject.optInt("giftType");
          if (m != n) {
            break label493;
          }
          if (i1 == 0) {
            localArrayList2.add(new sne(localJSONObject, localArrayList2.size()));
          } else if (i1 == 1) {
            localArrayList1.add(new sne(localJSONObject, localArrayList1.size()));
          }
        }
      }
    }
    catch (Exception paramJSONArray)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopGiftAioPanelData", 2, "mergeExclusiveGift search exp:", paramJSONArray);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAioPanelData", 2, "mergeExclusiveGift, persional.size=" + localArrayList2.size() + ", public.size=" + localArrayList1.size());
      }
    }
    for (;;)
    {
      try
      {
        if ((this.oj != null) && (localArrayList2.size() > 0))
        {
          i = localArrayList2.size() - 1;
          if (i < 0) {
            break label502;
          }
          paramJSONArray = localArrayList2.get(i);
          this.oj.add(0, paramJSONArray);
          i -= 1;
          continue;
          if (i < this.oj.size())
          {
            ((sne)this.oj.get(i)).mIndex = i;
            i += 1;
            continue;
          }
        }
        if ((this.om == null) || (localArrayList1.size() <= 0)) {
          break;
        }
        i = localArrayList1.size() - 1;
        j = k;
        if (i >= 0)
        {
          paramJSONArray = localArrayList1.get(i);
          this.om.add(0, paramJSONArray);
          i -= 1;
          continue;
        }
        if (j >= this.om.size()) {
          break;
        }
        ((sne)this.om.get(j)).mIndex = j;
        j += 1;
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramJSONArray) {}
      QLog.e("TroopGiftAioPanelData", 2, "mergeExclusiveGift merge exp:", paramJSONArray);
      return;
      label486:
      i += 1;
      break label98;
      label493:
      j += 1;
      break label122;
      label502:
      i = 0;
    }
  }
  
  public void a(snf.b paramb)
  {
    this.jdField_a_of_type_Snf$b = paramb;
  }
  
  public void fh(List<apsz.a> paramList)
  {
    this.bg.clear();
    int i = 0;
    while (i < paramList.size())
    {
      apsz.a locala = (apsz.a)paramList.get(i);
      this.bg.put(locala.giftId, locala);
      i += 1;
    }
  }
  
  public void fi(List<apsz.b> paramList)
  {
    int j = 0;
    this.bh.clear();
    int i = 0;
    Object localObject;
    while (i < paramList.size())
    {
      localObject = (apsz.b)paramList.get(i);
      this.bh.put(((apsz.b)localObject).dVO, localObject);
      i += 1;
    }
    if (this.on != null)
    {
      paramList = new ArrayList();
      i = j;
      if (this.on != null)
      {
        i = j;
        if (this.on.size() > 0)
        {
          i = 0;
          while (i < this.on.size())
          {
            localObject = (sne)this.on.get(i);
            if (this.bh.get(((sne)localObject).bxW) != null)
            {
              ((sne)localObject).mIndex = i;
              paramList.add(localObject);
            }
            i += 1;
          }
          this.on.clear();
          this.on.addAll(paramList);
          paramList.clear();
          i = j;
        }
      }
      while (i < this.on.size())
      {
        ((sne)this.on.get(i)).mIndex = i;
        i += 1;
      }
      if (this.on.size() > this.byi) {
        ((sne)this.on.get(this.byi)).mSelected = true;
      }
    }
  }
  
  public boolean fm(int paramInt)
  {
    if ((this.ok != null) && (this.ol != null) && (paramInt >= 0) && (paramInt < this.ok.size()) && (paramInt < this.ol.size()) && ((this.ok.get(paramInt) instanceof snf.d)))
    {
      snf.d locald1 = (snf.d)this.ok.get(paramInt);
      if ((this.ol.get(paramInt) instanceof snf.d))
      {
        snf.d locald2 = (snf.d)this.ol.get(paramInt);
        if ((locald2.name != null) && (locald2.name.equals(locald1.name))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static class a
  {
    public String aEZ;
    public String aFa;
    public String icon;
    public String jumpUrl;
    
    public a(JSONObject paramJSONObject)
    {
      this.icon = paramJSONObject.optString("icon");
      this.aEZ = paramJSONObject.optString("iconGrid");
      this.jumpUrl = paramJSONObject.optString("jumpUrl");
      this.aFa = paramJSONObject.optString("iconLoveGrid");
    }
  }
  
  public static class b
  {
    public String aFb;
    public int enable;
    public String jumpUrl;
    public String wording;
    
    public b(Oidb_0xcd1.EmptyPackagePage paramEmptyPackagePage)
    {
      this.enable = paramEmptyPackagePage.enable.get();
      this.wording = paramEmptyPackagePage.wording.get();
      this.aFb = paramEmptyPackagePage.jump_wording.get();
      this.jumpUrl = paramEmptyPackagePage.jump_url.get();
    }
  }
  
  public static class c
  {
    public String icon;
    public String jumpUrl;
    
    public c(JSONObject paramJSONObject)
    {
      this.icon = paramJSONObject.optString("icon");
      this.jumpUrl = paramJSONObject.optString("jumpUrl");
    }
  }
  
  public static class d
  {
    public String name;
    public ArrayList<Integer> oq;
    public ArrayList<Object> or;
    
    public d(JSONObject paramJSONObject)
    {
      try
      {
        if (paramJSONObject.has("name")) {
          this.name = paramJSONObject.optString("name");
        }
        if (paramJSONObject.has("packageIDs"))
        {
          paramJSONObject = paramJSONObject.optJSONArray("packageIDs");
          int j = paramJSONObject.length();
          this.oq = new ArrayList();
          this.or = new ArrayList();
          int i = 0;
          while (i < j)
          {
            this.oq.add(Integer.valueOf(paramJSONObject.getInt(i)));
            i += 1;
          }
        }
        return;
      }
      catch (Exception paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopGiftAioPanelData", 2, "PersonalTabItemInfo json:", paramJSONObject);
        }
      }
    }
  }
  
  public static class e
  {
    public int height;
    public String icon;
    public String jumpUrl;
    public int tabID;
    public String title;
    public int width;
    
    public e(JSONObject paramJSONObject)
    {
      if (paramJSONObject.has("title")) {
        this.title = paramJSONObject.optString("title");
      }
      if (paramJSONObject.has("tabID")) {
        this.tabID = paramJSONObject.optInt("tabID");
      }
      if (paramJSONObject.has("icon")) {
        this.icon = paramJSONObject.optString("icon");
      }
      if (paramJSONObject.has("jumpUrl")) {
        this.jumpUrl = paramJSONObject.optString("jumpUrl");
      }
      if (paramJSONObject.has("width")) {
        this.width = paramJSONObject.optInt("width");
      }
      if (paramJSONObject.has("height")) {
        this.height = paramJSONObject.optInt("height");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     snf
 * JD-Core Version:    0.7.0.1
 */