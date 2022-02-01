import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqreader.utils.QRDebugEnvUrlUtils;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class avmt
{
  public static final int exw = Color.parseColor("#FDFDFD");
  public static final int exx = Color.parseColor("#666666");
  public static final int exy = Color.parseColor("#E0AC00");
  private ArrayList<avnh> EN = new ArrayList();
  private ArrayList<avnh> EO = new ArrayList();
  private avni a = new avmv(this);
  private INetInfoHandler c = new avmu(this);
  private String cMd = "#FDFDFD";
  private String cMe = "#666666";
  private String cMf = "#E0AC00";
  private String[] iR;
  private String[] iS;
  private String[] iT;
  private Context mContext;
  private HashMap<Integer, Integer> qB = new HashMap(6);
  private HashMap<Integer, String> qC = new HashMap(6);
  private HashMap<Integer, String> qD = new HashMap(6);
  private int[] tF;
  
  public avmt(Activity paramActivity)
  {
    this.mContext = paramActivity;
    eAS();
    aDl();
  }
  
  private boolean a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    Object localObject2 = null;
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = (JSONArray)paramJSONObject.get("tabList");
        if (!QLog.isColorLevel()) {
          break label137;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          localObject2 = (String)paramJSONObject.get("tabColor");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            this.cMd = ((String)localObject2);
          }
          localObject2 = (String)paramJSONObject.get("tabNameDefaultColor");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            this.cMe = ((String)localObject2);
          }
          paramJSONObject = (String)paramJSONObject.get("tabNameSelectedColor");
          if (!TextUtils.isEmpty(paramJSONObject)) {
            this.cMf = paramJSONObject;
          }
          paramJSONObject = localJSONArray;
          if (paramJSONObject != null) {
            break label140;
          }
          i = 0;
          if (i != 0) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.e("ReaderTabConfigDataHelper", 2, "jsonDataToTabItemData ,size=0");
          }
          return false;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int i;
            int j;
            int m;
            ArrayList localArrayList;
            int k;
            paramJSONObject = (JSONObject)localObject1;
            Object localObject1 = localException2;
            continue;
            j += 1;
          }
        }
        localException1 = localException1;
        paramJSONObject = (JSONObject)localObject2;
      }
      QLog.e("ReaderTabConfigDataHelper", 2, localException1.getMessage());
      label137:
      continue;
      label140:
      i = paramJSONObject.length();
    }
    this.EN.clear();
    j = 0;
    if (j < i) {}
    try
    {
      localObject1 = paramJSONObject.getJSONObject(j);
      localObject2 = (JSONArray)((JSONObject)localObject1).get("tabUrls");
      m = ((JSONArray)localObject2).length();
      localArrayList = new ArrayList(2);
      k = 0;
      while (k < m)
      {
        localArrayList.add(rH(((JSONArray)localObject2).getString(k)));
        k += 1;
      }
      k = ((JSONObject)localObject1).optInt("tabHidden");
      localObject1 = new avnh(((JSONObject)localObject1).optInt("tabID", -1), ((JSONObject)localObject1).optString("tabName"), ((JSONObject)localObject1).optString("n_tabIcon"), ((JSONObject)localObject1).optString("h_tabIcon"), localArrayList, k);
      if (k != 0) {
        break label393;
      }
      this.EN.add(localObject1);
    }
    catch (Exception paramJSONObject)
    {
      if (!QLog.isColorLevel()) {
        break label379;
      }
      QLog.e("ReaderTabConfigDataHelper", 2, paramJSONObject.getMessage());
      return false;
    }
    paramJSONObject = this.mContext;
    if (this.EN.size() > 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      avob.a.W(paramJSONObject, paramBoolean);
      if (!i(this.EO, this.EN)) {
        eAT();
      }
      this.EO = this.EN;
      return true;
    }
  }
  
  private void aDl()
  {
    if (this.EN.size() > 0) {
      abN(this.EN.size());
    }
    for (;;)
    {
      fq(this.EN);
      return;
      avoc.i("ReaderTabConfigDataHelper", "tab url from local");
      abN(4);
      this.EN.clear();
      avnh localavnh = new avnh();
      localavnh.tabID = 100;
      localavnh.tabName = "书城";
      localavnh.tabIcon = "https://qzonestyle.gtimg.cn/aoi/sola/20190603213616_ELPT79nUxC.png";
      localavnh.cMk = "https://qzonestyle.gtimg.cn/aoi/sola/20190603213616_AXwBTwpLm8.png";
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(rH("https://cdn.vip.qq.com/club/client/read/6/rel/bookStore_index.html?configfrom=local&_bid=2036&_wwv=128"));
      localavnh.EP = localArrayList;
      this.EN.add(localavnh);
      localavnh = new avnh();
      localavnh.tabID = 101;
      localavnh.tabName = "分类";
      localavnh.tabIcon = "https://qzonestyle.gtimg.cn/aoi/sola/20190603213616_u3wddLskp6.png";
      localavnh.cMk = "https://qzonestyle.gtimg.cn/aoi/sola/20190603213616_xYKQeprMCg.png";
      localArrayList = new ArrayList(1);
      localArrayList.add(rH("https://cdn.vip.qq.com/club/client/read/6/rel/category_index.html?configfrom=local&_bid=2036"));
      localavnh.EP = localArrayList;
      this.EN.add(localavnh);
      localavnh = new avnh();
      localavnh.tabID = 102;
      localavnh.tabName = "书架";
      localavnh.tabIcon = "https://qzonestyle.gtimg.cn/aoi/sola/20190603213616_G6VUELHdgC.png";
      localavnh.cMk = "https://qzonestyle.gtimg.cn/aoi/sola/20190603213616_f9xtLKYkBV.png";
      localArrayList = new ArrayList(2);
      localArrayList.add(rH("https://cdn.vip.qq.com/club/client/read/6/rel/newBookShelf_index.html?configfrom=local&_bid=2036"));
      localArrayList.add(rH("https://cdn.vip.qq.com/club/client/read/6/rel/newBookShelf_fm.html?configfrom=local&_bid=2036"));
      localavnh.EP = localArrayList;
      this.EN.add(localavnh);
      localavnh = new avnh();
      localavnh.tabID = 104;
      localavnh.tabName = "我的";
      localavnh.tabIcon = "https://qzonestyle.gtimg.cn/aoi/sola/20190604150617_XAeQPgB9Z8.png";
      localavnh.cMk = "https://qzonestyle.gtimg.cn/aoi/sola/20190603213616_wdBlMCyKuS.png";
      localArrayList = new ArrayList(1);
      localArrayList.add(rH("https://cdn.vip.qq.com/club/client/read/6/rel/mytab_index.html?configfrom=local&_bid=2036"));
      localavnh.EP = localArrayList;
      this.EN.add(localavnh);
    }
  }
  
  private void abN(int paramInt)
  {
    this.tF = new int[paramInt];
    this.iR = new String[paramInt];
    this.iS = new String[paramInt];
    this.iT = new String[paramInt];
  }
  
  private String bF()
  {
    return "&" + bG();
  }
  
  private void eAQ() {}
  
  private void eAS()
  {
    this.qB.put(Integer.valueOf(102), Integer.valueOf(0));
    this.qB.put(Integer.valueOf(100), Integer.valueOf(1));
    this.qB.put(Integer.valueOf(101), Integer.valueOf(2));
    this.qB.put(Integer.valueOf(104), Integer.valueOf(3));
    this.qB.put(Integer.valueOf(103), Integer.valueOf(6));
    this.qB.put(Integer.valueOf(105), Integer.valueOf(4));
    this.qC.put(Integer.valueOf(102), "302");
    this.qC.put(Integer.valueOf(100), "10100");
    this.qC.put(Integer.valueOf(101), "300");
    this.qC.put(Integer.valueOf(104), "310");
    this.qC.put(Integer.valueOf(103), "");
    this.qC.put(Integer.valueOf(105), "");
    this.qD.put(Integer.valueOf(102), "10298");
    this.qD.put(Integer.valueOf(100), "10296");
    this.qD.put(Integer.valueOf(101), "10297");
    this.qD.put(Integer.valueOf(104), "10299");
    this.qD.put(Integer.valueOf(103), "");
    this.qD.put(Integer.valueOf(105), "");
  }
  
  private void eAU()
  {
    String str = this.mContext.getSharedPreferences("CGI_RESPONSE", 0).getString("SP_TAB_CONFIG_DATA" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), "");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    try
    {
      a(new JSONObject(str), true);
      return;
    }
    catch (JSONException localJSONException)
    {
      avoc.e("ReaderTabConfigDataHelper", "getTabConfigDataFromDB," + localJSONException.getMessage());
    }
  }
  
  private void eAV()
  {
    avop.a(avop.p, this.a);
  }
  
  private void fq(ArrayList<avnh> paramArrayList)
  {
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      avnh localavnh = (avnh)paramArrayList.get(i);
      this.iT[i] = localavnh.cMk;
      int k = localavnh.tabID;
      this.tF[i] = ((Integer)this.qB.get(Integer.valueOf(k))).intValue();
      this.iR[i] = ((String)this.qC.get(Integer.valueOf(k)));
      this.iS[i] = ((String)this.qD.get(Integer.valueOf(k)));
      i += 1;
    }
  }
  
  private boolean i(ArrayList<avnh> paramArrayList1, ArrayList<avnh> paramArrayList2)
  {
    int j = paramArrayList1.size();
    if (paramArrayList1.size() == paramArrayList2.size())
    {
      int i = 0;
      while (i < j)
      {
        if (!((avnh)paramArrayList1.get(i)).equals(paramArrayList2.get(i))) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static int lm(int paramInt)
  {
    HashMap localHashMap = new HashMap(6);
    localHashMap.put(Integer.valueOf(102), Integer.valueOf(0));
    localHashMap.put(Integer.valueOf(100), Integer.valueOf(1));
    localHashMap.put(Integer.valueOf(101), Integer.valueOf(2));
    localHashMap.put(Integer.valueOf(104), Integer.valueOf(3));
    localHashMap.put(Integer.valueOf(103), Integer.valueOf(6));
    localHashMap.put(Integer.valueOf(105), Integer.valueOf(4));
    return ((Integer)localHashMap.get(Integer.valueOf(paramInt))).intValue();
  }
  
  @Nullable
  private String rH(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = bF();
    paramString = paramString + (String)localObject;
    localObject = new StringBuilder().append(paramString);
    if (paramString.contains("?")) {}
    for (paramString = "&";; paramString = "?")
    {
      localObject = paramString;
      paramString = (String)localObject;
      if (!((String)localObject).contains("_bid=2036")) {
        paramString = (String)localObject + "_bid=2036";
      }
      localObject = paramString;
      if (!paramString.contains("&refer=qqreader")) {
        localObject = paramString + "&refer=qqreader";
      }
      paramString = (String)localObject;
      if (!((String)localObject).contains("&ChannelID=")) {
        paramString = (String)localObject + "&ChannelID=" + avoh.getChannelId();
      }
      localObject = paramString;
      if (QRDebugEnvUrlUtils.isDebugEnv()) {
        localObject = QRDebugEnvUrlUtils.getTestUrl(paramString);
      }
      avoc.d("ReaderTabConfigDataHelper", " url=" + (String)localObject);
      return localObject;
    }
  }
  
  public String FR()
  {
    return this.cMd;
  }
  
  public String FS()
  {
    return this.cMe;
  }
  
  public String FT()
  {
    return this.cMf;
  }
  
  @Nullable
  public String[] Y()
  {
    return this.iT;
  }
  
  @Nullable
  public String[] Z()
  {
    return this.iR;
  }
  
  @Nullable
  public String[] aa()
  {
    return this.iS;
  }
  
  @Nullable
  public int[] al()
  {
    return this.tF;
  }
  
  public String bG()
  {
    int i = 0;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = ImmersiveUtils.getStatusBarHeight(this.mContext);
    }
    return "&height=" + (aqcx.px2dip(this.mContext, i) + 50);
  }
  
  public void eAR()
  {
    eAU();
    eAV();
  }
  
  public void eAT()
  {
    aDl();
  }
  
  @NonNull
  public ArrayList<avnh> eB()
  {
    return this.EN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avmt
 * JD-Core Version:    0.7.0.1
 */