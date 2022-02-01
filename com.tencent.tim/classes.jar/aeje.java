import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aeje
{
  public static class a
    extends aeje.m
    implements aehx<String>
  {
    protected String mContent = "";
    public ArrayList<aeje.k> vs = new ArrayList();
    
    private static adpq.a a(JSONObject paramJSONObject)
    {
      if (paramJSONObject == null) {
        return null;
      }
      adpq.a locala = new adpq.a();
      locala.type = paramJSONObject.optInt("type", -1);
      locala.md5 = paramJSONObject.optString("md5", null);
      locala.url = paramJSONObject.optString("url", null);
      locala.name = paramJSONObject.optString("name", null);
      locala.identifier = paramJSONObject.optString("identifier", null);
      if (!locala.isValid())
      {
        QLog.i("AIDictConfig", 1, "getDictInfoFromJSON, invalid dict info");
        return null;
      }
      QLog.i("AIDictConfig", 1, "onParse getDictInfoFromJSON  info.type=" + locala.type + ", info.md5=" + locala.md5 + ", info.url=" + locala.url + ",  info.name =" + locala.name + ",  info.identifier =" + locala.identifier);
      paramJSONObject = paramJSONObject.optJSONObject("diff");
      if (paramJSONObject != null)
      {
        locala.bva = paramJSONObject.optString("url");
        locala.bvb = paramJSONObject.optString("diff-md5");
        locala.bvc = paramJSONObject.optString("source-md5");
        if (!locala.afr()) {
          locala.cTH();
        }
        QLog.i("AIDictConfig", 1, "onParse getDictInfoFromJSON info.diffURL=" + locala.bva + ", info.diffMD5=" + locala.bvb + ", info.diffSourceMD5=" + locala.bvc);
      }
      return locala;
    }
    
    public String getContent()
    {
      return this.mContent;
    }
    
    public void lR(String paramString)
    {
      int k = 0;
      if (TextUtils.isEmpty(paramString))
      {
        ArkAppCenter.r("AIDictConfig", "onParse,fileOrRes is null");
        return;
      }
      this.mContent = paramString;
      Object localObject1;
      int i;
      Object localObject2;
      Object localObject3;
      Object localObject5;
      int j;
      try
      {
        paramString = new JSONObject(paramString);
        this.bxX = paramString.optString("environment");
        this.bxW = paramString.optString("timestamp");
        this.bxY = paramString.optString("ark_dict_init");
        this.apj = paramString.optString("netType", "");
        localObject1 = paramString.optJSONArray("conditional_dict_list");
        if (localObject1 == null) {
          break label420;
        }
        i = 0;
        if (i >= ((JSONArray)localObject1).length()) {
          break label420;
        }
        localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        if (localObject2 == null) {
          break label518;
        }
        localObject3 = ((JSONObject)localObject2).optJSONObject("condition");
        Object localObject4 = ((JSONObject)localObject2).optJSONObject("dict");
        if ((localObject3 == null) || (localObject4 == null)) {
          break label518;
        }
        localObject2 = new aeje.k();
        localObject5 = new aeje.j();
        ((aeje.j)localObject5).ayV = ((JSONObject)localObject3).optString("date", "");
        ((aeje.k)localObject2).a = ((aeje.j)localObject5);
        localObject3 = new aeje.m();
        ((aeje.m)localObject3).bxX = ((JSONObject)localObject4).optString("environment");
        ((aeje.m)localObject3).bxW = ((JSONObject)localObject4).optString("timestamp");
        ((aeje.m)localObject3).bxY = ((JSONObject)localObject4).optString("ark_dict_init");
        ((aeje.m)localObject3).apj = ((JSONObject)localObject4).optString("netType", "");
        QLog.i("AIDictConfig", 1, "onParse conditional_dict_list tDict.environment=" + ((aeje.m)localObject3).bxX + ", tDict.mTimestamp =" + ((aeje.m)localObject3).bxW + ", tDict.mArkDictInit =" + ((aeje.m)localObject3).bxY + ", tDict.mNetType =" + ((aeje.m)localObject3).apj + ", tCondition.mData =" + ((aeje.j)localObject5).ayV);
        localObject4 = ((JSONObject)localObject4).optJSONArray("word_dict_list");
        if (localObject4 == null) {
          break label400;
        }
        localObject5 = new ArrayList();
        j = 0;
        label343:
        if (j < ((JSONArray)localObject4).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject4).optJSONObject(j);
          if (localJSONObject == null) {
            break label525;
          }
          ((ArrayList)localObject5).add(a(localJSONObject));
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("AIDictConfig", 1, "onParse error e = ", paramString);
        return;
      }
      ((aeje.m)localObject3).vE = ((ArrayList)localObject5);
      label400:
      ((aeje.k)localObject2).b = ((aeje.m)localObject3);
      this.vs.add(localObject2);
      break label518;
      label420:
      paramString = paramString.optJSONArray("word_dict_list");
      if (paramString != null)
      {
        this.vE = new ArrayList();
        i = k;
      }
      for (;;)
      {
        if (i < paramString.length())
        {
          localObject1 = paramString.optJSONObject(i);
          if (localObject1 != null)
          {
            localObject1 = a((JSONObject)localObject1);
            this.vE.add(localObject1);
          }
        }
        else
        {
          QLog.d("AIDictConfig", 1, new Object[] { "mWordDictList list size =", Integer.valueOf(this.vE.size()) });
          return;
          label518:
          i += 1;
          break;
          label525:
          j += 1;
          break label343;
        }
        i += 1;
      }
    }
  }
  
  public static class b
    implements aehx<String>
  {
    public long Wg;
    public String bxM = "";
    public String bxN = "";
    public String bxO = "";
    public int cNj;
    public int cNk;
    public int cNl;
    public int cNm;
    public int cNn;
    public int cNo;
    public int cNp;
    public int cNq;
    public int cNr;
    public int cNs;
    public ArrayList<aeje.i> vt = new ArrayList();
    public ArrayList<String> vu = new ArrayList();
    public ArrayList<aeje.f> vv = new ArrayList();
    public ArrayList<aeje.e> vw = new ArrayList();
    public ArrayList<String> vx = new ArrayList();
    public ArrayList<String> vy = new ArrayList();
    public ArrayList<aeje.d> vz = new ArrayList();
    
    public void lR(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("AiKeywordConfig", 1, "onParse,fileOrRes is null");
        return;
      }
      int i;
      Object localObject2;
      Object localObject3;
      try
      {
        paramString = new JSONObject(paramString);
        localObject1 = paramString.optJSONArray("ark_server_keyword_configs");
        if (localObject1 != null)
        {
          i = 0;
          if (i >= ((JSONArray)localObject1).length()) {
            break label304;
          }
          localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          if (localObject2 == null) {
            break label1811;
          }
          localObject3 = new aeje.i();
          ((aeje.i)localObject3).mContext = ((JSONObject)localObject2).optString("context", "");
          ((aeje.i)localObject3).mType = ((JSONObject)localObject2).optString("type", "");
          ((aeje.i)localObject3).M = Boolean.valueOf(((JSONObject)localObject2).optBoolean("enable", false));
          ((aeje.i)localObject3).bxT = ((JSONObject)localObject2).optString("regex", "");
          ((aeje.i)localObject3).mTips = ((JSONObject)localObject2).optString("tips", "");
          ArkAppCenter.r("AiKeywordConfig", String.format("onParse, ark_server_keyword_configs, name=%s, type=%s, enable=%s, pattern=%s, tip=%s", new Object[] { ((aeje.i)localObject3).mContext, ((aeje.i)localObject3).mType, Boolean.toString(((aeje.i)localObject3).M.booleanValue()), ((aeje.i)localObject3).bxT, ((aeje.i)localObject3).mTips }));
          if ((TextUtils.isEmpty(((aeje.i)localObject3).mContext)) || (TextUtils.isEmpty(((aeje.i)localObject3).mType)) || (!((aeje.i)localObject3).M.booleanValue()) || (TextUtils.isEmpty(((aeje.i)localObject3).bxT)) || (TextUtils.isEmpty(((aeje.i)localObject3).mTips))) {
            break label1811;
          }
          this.vt.add(localObject3);
        }
      }
      catch (JSONException paramString)
      {
        ArkAppCenter.r("AiKeywordConfig", String.format("onParse AiKeywordConfig onParse, parse json failed, err=%s", new Object[] { paramString.getMessage() }));
        return;
      }
      ArkAppCenter.r("AiKeywordConfig", "onParse, ark_server_keyword_configs is empty");
      label304:
      this.bxM = paramString.optString("ark_ai_match_graytips_visibility");
      Object localObject1 = paramString.optJSONArray("ark_navi_msg_appnames");
      if (localObject1 != null)
      {
        i = 0;
        label329:
        if (i < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).optString(i);
          if ((TextUtils.isEmpty((CharSequence)localObject2)) || (this.vu.contains(localObject2))) {
            break label1818;
          }
          QLog.d("AiKeywordConfig", 1, new Object[] { "onParse ark_navi_msg_appnames appName = ", localObject2 });
          this.vu.add(localObject2);
          break label1818;
        }
      }
      localObject1 = paramString.optJSONArray("ark_module_api_frequency");
      label414:
      Object localObject4;
      if (localObject1 != null)
      {
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          if (localObject2 == null) {
            break label1825;
          }
          localObject3 = ((JSONObject)localObject2).optString("module");
          localObject4 = ((JSONObject)localObject2).optString("api");
          long l1 = ((JSONObject)localObject2).optLong("times", -1L);
          long l2 = ((JSONObject)localObject2).optLong("period", -1L);
          QLog.d("AiKeywordConfig", 1, new Object[] { "onParse ark_module_api_frequency module = ", localObject3, "api = ", localObject4, "times = ", Long.valueOf(l1), "period = ", Long.valueOf(l2) });
          if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject4)) || (l1 == -1L) || (l2 == -1L)) {
            break label1825;
          }
          localObject2 = new aeje.f((String)localObject3, (String)localObject4, l1, l2);
          this.vv.add(localObject2);
          break label1825;
        }
      }
      QLog.d("AiKeywordConfig", 1, new Object[] { "onParse,mArkModuleApiFrequencyList list size =", Integer.valueOf(this.vv.size()) });
      localObject1 = paramString.optJSONArray("ark_jsdebugger_download");
      int j;
      if (localObject1 != null)
      {
        j = ((JSONArray)localObject1).length();
        i = 0;
        label651:
        if (i < j)
        {
          localObject4 = ((JSONArray)localObject1).optJSONObject(i);
          if (localObject4 == null) {
            break label1832;
          }
          localObject2 = ((JSONObject)localObject4).optString("jscmd5");
          localObject3 = ((JSONObject)localObject4).optString("url");
          localObject4 = ((JSONObject)localObject4).optString("md5");
          QLog.d("AiKeywordConfig", 1, new Object[] { "onParse jscomd5 = ", localObject2, "ur = ", localObject3, "md5 = ", localObject4 });
          if ((localObject2 == null) || (TextUtils.isEmpty((CharSequence)localObject4)) || (TextUtils.isEmpty((CharSequence)localObject3))) {
            break label1832;
          }
          this.vw.add(new aeje.e((String)localObject2, (String)localObject3, (String)localObject4));
          break label1832;
        }
      }
      QLog.e("AiKeywordConfig", 1, new Object[] { "mArkJsdebuggerDownloadList list size =", Integer.valueOf(this.vw.size()) });
      this.cNj = paramString.optInt("singlecontext_singleapp_card_limit", 5);
      this.cNk = paramString.optInt("ark_app_limit", 3);
      this.cNl = paramString.optInt("ark_each_app_card_limit", 1);
      this.cNm = paramString.optInt("ark_input_apps_limit", 3);
      this.cNn = paramString.optInt("ark_input_each_context_apps_limit", 3);
      this.cNo = paramString.optInt("ark_babyq_card_limit_total", 10);
      this.cNp = paramString.optInt("ark_babyq_card_limit_per_app", 1);
      this.cNq = paramString.optInt("ark_babyq_guide_count_limit_per_day", 1);
      this.cNr = paramString.optInt("ark_babyq_guide_day_limit_total", 3);
      this.bxN = paramString.optString("ark_babyq_guide_hint_text");
      this.Wg = paramString.optLong("ark_babyq_bubble_disappear_duration", 10000L);
      localObject1 = paramString.optJSONArray("ark_babyq_input_hint_text_list");
      if (localObject1 != null)
      {
        j = ((JSONArray)localObject1).length();
        i = 0;
        label973:
        if (i < j)
        {
          localObject2 = ((JSONArray)localObject1).optString(i);
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label1839;
          }
          QLog.d("AiKeywordConfig", 1, new Object[] { "onParse ark_babyq_input_hint_text_list itemStr = ", localObject2 });
          this.vx.add(localObject2);
          break label1839;
        }
      }
      QLog.d("AiKeywordConfig", 1, new Object[] { "onParse mArkBabyqInputHintTextList list size =", Integer.valueOf(this.vx.size()) });
      this.bxO = paramString.optString("ark_babyq_no_result_recommend_title");
      localObject1 = paramString.optJSONArray("ark_babyq_no_result_recommend_items");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        i = 0;
        label1092:
        if (i < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).optString(i);
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label1846;
          }
          QLog.d("AiKeywordConfig", 1, new Object[] { "onParse ark_babyq_no_result_recommend_items itemStr = ", localObject2 });
          this.vy.add(localObject2);
          break label1846;
        }
      }
      QLog.d("AiKeywordConfig", 1, new Object[] { "onParse mArkBabyqNoResultRecommendItems list size =", Integer.valueOf(this.vy.size()) });
      this.cNs = paramString.optInt("ark_babyq_gray_tip_total_limit", 1);
      paramString = paramString.optJSONArray("ark_babyq_gray_tip_configs");
      if ((paramString != null) && (paramString.length() > 0)) {
        i = 0;
      }
      for (;;)
      {
        int k;
        int m;
        if (i < paramString.length())
        {
          localObject1 = paramString.optJSONObject(i);
          if (localObject1 == null) {
            break label1860;
          }
          k = ((JSONObject)localObject1).optInt("type");
          m = ((JSONObject)localObject1).optInt("limit");
          QLog.d("AiKeywordConfig", 1, new Object[] { "onParse tipType =", Integer.valueOf(k), "itemLimit = ", Integer.valueOf(m) });
          if (k == 4)
          {
            localObject1 = ((JSONObject)localObject1).optJSONArray("tips_array");
            if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
              break label1860;
            }
            localObject2 = new ArrayList();
            j = 0;
          }
        }
        for (;;)
        {
          if (j < ((JSONArray)localObject1).length())
          {
            Object localObject5 = ((JSONArray)localObject1).optJSONObject(j);
            if (localObject5 != null)
            {
              localObject3 = ((JSONObject)localObject5).optString("prefix");
              localObject4 = ((JSONObject)localObject5).optString("keyword");
              String str = ((JSONObject)localObject5).optString("postfix");
              localObject5 = ((JSONObject)localObject5).optString("app");
              if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
              {
                QLog.d("AiKeywordConfig", 1, new Object[] { "onParse prefix =", localObject3, "keyword = ", localObject4, "postfix = ", str, "appName = ", localObject5 });
                ((ArrayList)localObject2).add(new aeje.n((String)localObject3, (String)localObject4, str, (String)localObject5));
              }
            }
          }
          else
          {
            this.vz.add(new aeje.d(k, m, null, (ArrayList)localObject2));
            break label1860;
            if (k <= 0) {
              break label1860;
            }
            localObject1 = ((JSONObject)localObject1).optString("tip");
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label1860;
            }
            QLog.d("AiKeywordConfig", 1, new Object[] { "onParse tipText =", localObject1 });
            this.vz.add(new aeje.d(k, m, (String)localObject1, null));
            break label1860;
            QLog.d("AiKeywordConfig", 1, new Object[] { "onParse mArkBabyqGrayTipConfigs list size =", Integer.valueOf(this.vz.size()) });
            QLog.i("AiKeywordConfig", 1, "onParse ark_ai_match_graytips_visibility=" + this.bxM + ", singlecontext_singleapp_card_limit=" + this.cNj + ", ark_app_limit=" + this.cNk + ", ark_each_app_card_limit=" + this.cNl + ", ark_input_apps_limit=" + this.cNm + ", ark_input_each_context_apps_limit=" + this.cNn + ", ark_babyq_card_limit_total=" + this.cNo + ", ark_babyq_card_limit_total=" + this.cNp + ", ark_babyq_guide_count_limit_per_day=" + this.cNq + ", ark_babyq_guide_hint_text=" + this.bxN + ", ark_babyq_bubble_disappear_duration=" + this.Wg + ", ark_babyq_no_result_recommend_title=" + this.bxO + ", ark_babyq_gray_tip_total_limit=" + this.cNs);
            return;
            label1811:
            i += 1;
            break;
            label1818:
            i += 1;
            break label329;
            label1825:
            i += 1;
            break label414;
            label1832:
            i += 1;
            break label651;
            label1839:
            i += 1;
            break label973;
            label1846:
            i += 1;
            break label1092;
          }
          j += 1;
        }
        label1860:
        i += 1;
      }
    }
  }
  
  public static class c
    implements aehx<String>
  {
    public HashMap<String, String> jT = new HashMap();
    
    public void lR(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        ArkAppCenter.r("ArkAIKeyWordSDKShareConfig", "onParse,fileOrRes is null");
      }
      for (;;)
      {
        return;
        try
        {
          paramString = new JSONObject(paramString).optJSONArray("ark_ai_keyword_sdk_share_app_info");
          if (paramString != null)
          {
            int i = 0;
            while (i < paramString.length())
            {
              Object localObject = (JSONObject)paramString.get(i);
              String str = ((JSONObject)localObject).getString("appID");
              localObject = ((JSONObject)localObject).getString("appName");
              QLog.i("ArkAIKeyWordSDKShareConfig", 1, "onParse ark_ai_keyword_sdk_share_app_info id=" + str + ", name=" + (String)localObject);
              this.jT.put(str, localObject);
              i += 1;
            }
          }
          ArkAppCenter.r("ArkAIKeyWordSDKShareConfig", "getArkShareConfig,ark_ai_keyword_sdk_share_app_info is empty");
          return;
        }
        catch (JSONException paramString)
        {
          QLog.e("ArkAIKeyWordSDKShareConfig", 1, "onParse error e = ", paramString);
        }
      }
    }
  }
  
  public static class d
  {
    public String bxP;
    public int mLimit;
    public int mType;
    public ArrayList<aeje.n> vA;
    
    public d(int paramInt1, int paramInt2, String paramString, ArrayList<aeje.n> paramArrayList)
    {
      this.mType = paramInt1;
      this.mLimit = paramInt2;
      this.bxP = paramString;
      this.vA = paramArrayList;
    }
  }
  
  public static class e
  {
    public String bxQ;
    public String mMd5;
    public String mUrl;
    
    public e(String paramString1, String paramString2, String paramString3)
    {
      this.bxQ = paramString1;
      this.mUrl = paramString2;
      this.mMd5 = paramString3;
    }
  }
  
  public static class f
  {
    public long Vl;
    public String buU;
    public String bxR;
    public long mPeriod;
    
    public f(String paramString1, String paramString2, long paramLong1, long paramLong2)
    {
      this.bxR = paramString1;
      this.buU = paramString2;
      this.Vl = paramLong1;
      this.mPeriod = paramLong2;
    }
  }
  
  public static class g
    implements aehx<String>
  {
    public boolean bUj = true;
    public boolean bUk = true;
    
    public void lR(String paramString)
    {
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        paramString = new JSONObject(paramString);
        if (paramString.optInt("ark_app_manage_panel_disable", 1) != 0)
        {
          bool = true;
          this.bUj = bool;
          adph.bPZ = this.bUj;
          if (paramString.optInt("ark_download_by_yyb_disable", 1) == 0) {
            break label115;
          }
        }
        label115:
        for (boolean bool = true;; bool = false)
        {
          this.bUk = bool;
          adph.bQc = this.bUk;
          QLog.i("ArkMsgAIDisableConfig", 1, "onParse " + ", ark_app_manage_panel_disable=" + this.bUj + ", ark_download_by_yyb_disable =" + this.bUk);
          return;
          bool = false;
          break;
        }
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("ArkMsgAIDisableConfig", 1, "handleArkMsgAIDisableConfig parse config_content exception=" + paramString);
      }
    }
  }
  
  public static class h
    implements aehx<String>
  {
    public boolean bUl;
    public boolean bUm;
    public boolean bUn;
    public String bxS = "";
    public ConcurrentHashMap<String, adqy.a> eH = new ConcurrentHashMap(8);
    public ConcurrentHashMap<String, ArrayList<String>> eZ = new ConcurrentHashMap();
    protected String mContent = "";
    public ArrayList<String> vB = new ArrayList();
    public ArrayList<String> vC = new ArrayList();
    public ArrayList<String> vD = new ArrayList();
    
    public void lR(String paramString)
    {
      boolean bool2 = false;
      if (TextUtils.isEmpty(paramString))
      {
        ArkAppCenter.r("ArkPlatformConfig", "onParse,fileOrRes is null");
        return;
      }
      this.mContent = paramString;
      int i;
      Object localObject2;
      boolean bool1;
      label127:
      Object localObject3;
      label181:
      label253:
      int j;
      try
      {
        paramString = new JSONObject(paramString);
        localObject1 = paramString.optJSONArray("ark_force_update_app_list");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optString(i);
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label937;
            }
            this.vB.add(localObject2);
            QLog.d("ArkPlatformConfig", 1, new Object[] { "get config update app=", localObject2 });
            break label937;
          }
        }
        if (paramString.optInt("ark_url_check_enable", 1) != 1) {
          break label951;
        }
        bool1 = true;
        this.bUl = bool1;
        QLog.d("ArkPlatformConfig", 1, new Object[] { "mIsUrlCheckEnable = ", Boolean.valueOf(this.bUl) });
        localObject1 = paramString.optJSONArray("ark_url_check_disable_apps");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optString(i);
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label944;
            }
            this.vC.add(localObject2);
            QLog.d("ArkPlatformConfig", 1, new Object[] { "get config disable app=", localObject2 });
            break label944;
          }
        }
        if (paramString.optInt("ark_memory_optimize", 0) != 1) {
          break label964;
        }
        bool1 = true;
        this.bUm = bool1;
        QLog.d("ArkPlatformConfig", 1, new Object[] { "mIsOptimizeEnable = ", Boolean.valueOf(this.bUm) });
        this.bxS = paramString.optString("ark_toast_info_config", "");
        QLog.d("ArkPlatformConfig", 1, new Object[] { "mToastStr = ", this.bxS });
        localObject1 = paramString.optJSONArray("predownload_cfg_list");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          i = 0;
          label341:
          if (i < ((JSONArray)localObject1).length())
          {
            localObject3 = ((JSONArray)localObject1).getJSONObject(i);
            localObject2 = ((JSONObject)localObject3).optString("app_name");
            j = ((JSONObject)localObject3).optInt("preload");
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject3 = new adqy.a();
              ((adqy.a)localObject3).appname = ((String)localObject2);
              ((adqy.a)localObject3).cJt = j;
              QLog.d("ArkPlatformConfig", 1, "onParse predownload_cfg_list name = " + (String)localObject2 + ", preload = " + j);
              this.eH.put(localObject2, localObject3);
            }
            else
            {
              QLog.d("ArkPlatformConfig", 1, "onParse predownload_cfg_list app_name is empty");
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("ArkPlatformConfig", 1, "onParse error e = ", paramString);
        return;
      }
      QLog.d("ArkPlatformConfig", 1, new Object[] { "onParse mPreDownload list size =", Integer.valueOf(this.eH.size()) });
      Object localObject1 = paramString.optJSONObject("app_global_url_config");
      if (localObject1 != null)
      {
        localObject2 = ((JSONObject)localObject1).optJSONArray("white");
        if (localObject2 != null)
        {
          j = ((JSONArray)localObject2).length();
          localObject3 = new ArrayList();
          i = 0;
          label546:
          if (i < j)
          {
            String str = ((JSONArray)localObject2).optString(i, "");
            if (TextUtils.isEmpty(str)) {
              break label970;
            }
            QLog.d("ArkPlatformConfig", 1, "onParse white url = " + str);
            ((ArrayList)localObject3).add(str);
            break label970;
          }
          QLog.d("ArkPlatformConfig", 1, new Object[] { "white list size =", Integer.valueOf(((ArrayList)localObject3).size()) });
          this.eZ.put("white", localObject3);
        }
        localObject1 = ((JSONObject)localObject1).optJSONArray("black");
        if (localObject1 != null)
        {
          j = ((JSONArray)localObject1).length();
          localObject2 = new ArrayList();
          i = 0;
          label672:
          if (i < j)
          {
            localObject3 = ((JSONArray)localObject1).optString(i, "");
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              break label977;
            }
            QLog.d("ArkPlatformConfig", 1, "onParse black url = " + (String)localObject3);
            ((ArrayList)localObject2).add(localObject3);
            break label977;
          }
          QLog.d("ArkPlatformConfig", 1, "black list size = " + ((ArrayList)localObject2).size());
          this.eZ.put("black", localObject2);
        }
      }
      QLog.d("ArkPlatformConfig", 1, "mGlobalUrlConfig list size = " + this.eZ.size());
      localObject1 = paramString.optJSONArray("ark_download_ctrl_disable_list");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
        i = 0;
      }
      for (;;)
      {
        if (i < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).optString(i);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            this.vD.add(localObject2);
          }
        }
        else
        {
          QLog.d("ArkPlatformConfig", 1, new Object[] { "ark.dctrl get config disable download ctrl apps=", this.vD.toString() });
          bool1 = bool2;
          if (paramString.optInt("ark_vip_report_enable", 1) == 1) {
            bool1 = true;
          }
          this.bUn = bool1;
          QLog.d("ArkPlatformConfig", 1, new Object[] { "ark VipReport enable=", Boolean.valueOf(this.bUn) });
          return;
          label937:
          i += 1;
          break;
          label944:
          i += 1;
          break label181;
          label951:
          bool1 = false;
          break label127;
          i += 1;
          break label341;
          label964:
          bool1 = false;
          break label253;
          label970:
          i += 1;
          break label546;
          label977:
          i += 1;
          break label672;
        }
        i += 1;
      }
    }
  }
  
  public static class i
  {
    public Boolean M;
    public String bxT;
    public String mContext;
    public String mTips;
    public String mType;
  }
  
  public static class j
  {
    public String ayV;
  }
  
  public static class k
  {
    public aeje.j a;
    public aeje.m b;
  }
  
  public static class l
    implements aehx<String>
  {
    public boolean bUo;
    public boolean bUp;
    public boolean bUq;
    public boolean bUr;
    public boolean bUs;
    public String bxU = "";
    public String bxV = "";
    public HashMap<String, ArrayList<String>> jU = new HashMap();
    
    public boolean a(JSONObject paramJSONObject, String paramString)
    {
      if (paramJSONObject == null)
      {
        QLog.e("DialogConfig", 1, "getArkBoolConfig, dictConfigJsonString is empty");
        return false;
      }
      paramJSONObject = paramJSONObject.optString(paramString);
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        QLog.i("DialogConfig", 1, String.format("getArkBoolConfig, " + paramString + "=%s", new Object[] { paramJSONObject }));
        return paramJSONObject.equals("true");
      }
      QLog.i("DialogConfig", 1, "getArkBoolConfig, " + paramString + " is empty");
      return false;
    }
    
    public String d(JSONObject paramJSONObject, String paramString)
    {
      if (paramJSONObject == null)
      {
        QLog.e("DialogConfig", 1, "getArkStringConfig, json is empty");
        return "";
      }
      paramJSONObject = paramJSONObject.optString(paramString);
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        QLog.i("DialogConfig", 1, String.format("getArkStringConfig, " + paramString + "=%s", new Object[] { paramJSONObject }));
        return paramJSONObject;
      }
      QLog.i("DialogConfig", 1, "getArkStringConfig, " + paramString + " is empty");
      return "";
    }
    
    public void lR(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
      {
        ArkAppCenter.r("DialogConfig", "onParse,fileOrRes is null");
        return;
      }
      for (;;)
      {
        String str1;
        ArrayList localArrayList;
        int i;
        try
        {
          for (;;)
          {
            JSONObject localJSONObject = new JSONObject(paramString);
            this.bUo = a(localJSONObject, "ark_map_transfer_struct");
            this.bxV = d(localJSONObject, "business_percent");
            if (localJSONObject.optInt("ark_use_android_http", 0) == 0) {
              break label470;
            }
            bool = true;
            this.bUp = bool;
            this.bUq = a(localJSONObject, "ark_support_android9_emoji");
            this.bUr = a(localJSONObject, "ark_engine_multi_thread");
            this.bxU = d(localJSONObject, "ark_engine_hardware_rendering_device_matcher");
            this.bUs = a(localJSONObject, "ark_engine_disable_hardware_rendering");
            QLog.i("DialogConfig", 1, "mArkMapTransferStruct=" + this.bUo + ", mBusinessPercent=" + this.bxV + ", mArkUseAndroidHttp=" + this.bUp + ", mArkAndroid9EmojiFeatureSupport=" + this.bUq + ", mArkEngineMultiThread" + this.bUr + ", mArkEngineHardwareRenderingDeviceMatcher=" + this.bxU + ", mArkEngineDisableHardwareRendering=" + this.bUs);
            try
            {
              aejg.a().aV(localJSONObject);
              localJSONObject = localJSONObject.optJSONObject("msgai_intent_app_map");
              if (localJSONObject == null) {
                break;
              }
              Iterator localIterator = localJSONObject.keys();
              JSONArray localJSONArray;
              do
              {
                if (!localIterator.hasNext()) {
                  break;
                }
                str1 = (String)localIterator.next();
                QLog.i("DialogConfig", 1, "msgai_intent_app_map, intent = " + str1);
                localJSONArray = localJSONObject.optJSONArray(str1);
              } while (localJSONArray == null);
              localArrayList = new ArrayList();
              i = 0;
              if (i < localJSONArray.length())
              {
                String str2 = localJSONArray.optString(i);
                QLog.i("DialogConfig", 1, "msgai_intent_app_map, appID = " + str2);
                if (TextUtils.isEmpty(str2)) {
                  break label463;
                }
                localArrayList.add(str2);
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QLog.e("DialogConfig", 1, "ArkMsgReplyConfigMgr updateConfig exception:" + localException.getMessage());
              }
            }
          }
          if (localArrayList.isEmpty()) {
            continue;
          }
        }
        catch (JSONException localJSONException)
        {
          QLog.e("DialogConfig", 1, String.format("updateDialogConfig, parse json fail, json=%s, err=%s", new Object[] { paramString, localJSONException.getMessage() }));
          return;
        }
        this.jU.put(str1, localArrayList);
        continue;
        label463:
        i += 1;
        continue;
        label470:
        boolean bool = false;
      }
    }
  }
  
  public static class m
  {
    public String apj;
    public String bxW;
    public String bxX;
    public String bxY;
    public ArrayList<adpq.a> vE;
  }
  
  public static class n
  {
    public String bxZ;
    public String bya;
    public String mKeyword;
    public String mPrefix;
    
    public n(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.mPrefix = paramString1;
      this.mKeyword = paramString2;
      this.bxZ = paramString3;
      this.bya = paramString4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeje
 * JD-Core Version:    0.7.0.1
 */