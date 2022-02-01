import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyProteusFamilyUtil.4;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.AdInfo;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.articlesummary.articlesummary.FeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.PosAdInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspGetFollowTabFeeds;

public class kxb
  implements lcm.e
{
  private static String KEY_VERSION = "version";
  private static String TAG = "ReadInJoyProteusFamilyUtil";
  private static kxb jdField_a_of_type_Kxb;
  private static int aMq;
  private static int aMr;
  public static String adc = "https://oa.m.tencent.com/an:kandiandata/api/kd_proteus_card?version=0&is_update=1";
  private static String add = adc;
  private static String ade = "local_data";
  private static String adf = "local_update_time";
  private static String adg = "remote_update_time";
  private static String adh = "family_data";
  private static String adi = "proteus_card_list";
  private static String adj = "card_id";
  private static String adk = "card_value";
  private static String adl = "utime";
  private static String adn;
  private static boolean aig;
  private static JSONObject am = new JSONObject();
  private static JSONObject an = new JSONObject();
  private static JSONObject ao = new JSONObject();
  private static Map<Pair<Long, BaseArticleInfo>, String> dZ = new TreeMap(new kxd());
  private static List<BaseArticleInfo> gO = new ArrayList();
  private kxb.a jdField_a_of_type_Kxb$a;
  private String adm;
  private Map<Pair<Long, Pair<View, BaseArticleInfo>>, Long> dW = new TreeMap(new kxc(this));
  private Map<String, Long> ea = new HashMap();
  private List<View> gN = new ArrayList();
  private List<Long> gP = new ArrayList();
  
  static
  {
    aMr = 86400000;
  }
  
  private kxb()
  {
    iO();
    QLog.d(TAG, 2, "init mPskey " + adn);
    init();
    lcm.d.a(this);
  }
  
  public static boolean AG()
  {
    return false;
  }
  
  public static List<BaseArticleInfo> B(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    localArrayList = new ArrayList();
    try
    {
      localJSONObject = new JSONObject(paramString);
      if (localJSONObject == null) {
        return null;
      }
      i = 0;
      localHashMap = new HashMap();
      localStringBuilder = new StringBuilder();
      localIterator = localJSONObject.keys();
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        int i;
        Iterator localIterator;
        String str;
        Object localObject2;
        int j;
        paramString.printStackTrace();
        return localArrayList;
        Object localObject3;
        if (j == 1)
        {
          localObject3 = new oidb_cmd0x68b.RspGetFollowTabFeeds();
          ((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject3).mergeFrom(Arrays.copyOfRange((byte[])localObject2, 1, localObject2.length));
          if ((!((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject3).msg_article_summary.has()) || (!((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject3).uint32_feeds_type.has())) {
            break;
          }
          localObject1 = lum.a((articlesummary.ArticleSummary)((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject3).msg_article_summary.get(), 70, 0, null);
          paramString = (String)localObject1;
          if (localObject1 == null) {
            break label862;
          }
          paramString = (String)localObject1;
          if (((ArticleInfo)localObject1).mArticleID == -1L) {
            break label862;
          }
          paramString = (String)localObject1;
          if (((ArticleInfo)localObject1).mRecommendSeq == -1L) {
            break label862;
          }
          if (((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject3).uint64_follow_recommend_id.has()) {
            ((ArticleInfo)localObject1).mRecommendFollowId = ((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject3).uint64_follow_recommend_id.get();
          }
          ((ArticleInfo)localObject1).mFeedType = ((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject3).uint32_feeds_type.get();
          paramString = (String)localObject1;
          break label862;
        }
        paramString = (String)localObject1;
        if (j == 2)
        {
          localObject3 = new articlesummary.ArticleSummary();
          ((articlesummary.ArticleSummary)localObject3).mergeFrom(Arrays.copyOfRange((byte[])localObject2, 1, localObject2.length));
          paramString = (String)localObject1;
          if (((articlesummary.ArticleSummary)localObject3).msg_feeds_info.has())
          {
            paramString = (String)localObject1;
            if (((articlesummary.ArticleSummary)localObject3).msg_feeds_info.get() != null)
            {
              paramString = (String)localObject1;
              if (((articlesummary.FeedsInfo)((articlesummary.ArticleSummary)localObject3).msg_feeds_info.get()).msg_pos_ad_info.has())
              {
                localObject2 = (articlesummary.PosAdInfo)((articlesummary.FeedsInfo)((articlesummary.ArticleSummary)localObject3).msg_feeds_info.get()).msg_pos_ad_info.get();
                paramString = (String)localObject1;
                if (localObject2 != null)
                {
                  paramString = (String)localObject1;
                  if (((articlesummary.PosAdInfo)localObject2).int32_ret.get() == 0)
                  {
                    j = ((articlesummary.PosAdInfo)localObject2).enum_pos_layout.get();
                    long l1 = ((articlesummary.PosAdInfo)localObject2).uint64_pos_id.get();
                    long l2 = ((articlesummary.PosAdInfo)localObject2).is_auto_play.get();
                    paramString = new AdvertisementInfo((articlesummary.AdInfo)((articlesummary.PosAdInfo)localObject2).msg_ad_info.get());
                    lum.a((articlesummary.ArticleSummary)localObject3, 0, 0, paramString);
                    ((AdvertisementInfo)paramString).mAdPosLayout = j;
                    ((AdvertisementInfo)paramString).mAdPosID = l1;
                    ((AdvertisementInfo)paramString).mADVideoAutoPlay = l2;
                  }
                }
              }
            }
          }
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramString)
    {
      for (;;)
      {
        HashMap localHashMap;
        StringBuilder localStringBuilder;
        Object localObject1;
        paramString.printStackTrace();
        continue;
        paramString = localHashMap.entrySet().iterator();
        while (paramString.hasNext())
        {
          localObject1 = (Map.Entry)paramString.next();
          QLog.d(TAG, 2, "convert2ArticleInfoList  | cnt key : " + (String)((Map.Entry)localObject1).getKey() + " count " + ((Map.Entry)localObject1).getValue());
        }
        QLog.d(TAG, 2, "convert2ArticleInfoList  | family num :" + localArrayList.size() + " ;card view type list : " + localStringBuilder.toString());
        continue;
        break label859;
        paramString = null;
        break label862;
      }
    }
    if ((localIterator != null) && (localIterator.hasNext()))
    {
      str = (String)localIterator.next();
      paramString = localJSONObject.getString(str);
      localStringBuilder.append(str + ",");
      if (!localHashMap.containsKey(str)) {
        localHashMap.put(str, Integer.valueOf(1));
      }
      for (;;)
      {
        localObject2 = aqgo.decode(paramString.getBytes(), 0);
        j = localObject2[0];
        localObject1 = null;
        if (j != 0) {
          break;
        }
        paramString = new articlesummary.ArticleSummary();
        paramString.mergeFrom(Arrays.copyOfRange((byte[])localObject2, 1, localObject2.length));
        paramString = lum.a(paramString, 0, 0, null);
        if ((paramString == null) || (TextUtils.isEmpty(b(paramString, 8888)))) {
          break label851;
        }
        localArrayList.add(paramString);
        QLog.d(TAG, 2, "convert2ArticleInfoList  | position : " + i + " key : " + str + " itemtype :" + a(paramString, 8888) + " article_title: " + paramString.mTitle);
        i += 1;
        break label859;
        localHashMap.put(str, Integer.valueOf(((Integer)localHashMap.get(str)).intValue() + 1));
      }
    }
  }
  
  private static int a(ArticleInfo paramArticleInfo, int paramInt)
  {
    return ndi.b(paramArticleInfo, paramInt);
  }
  
  private static String a(ArticleInfo paramArticleInfo, int paramInt)
  {
    int i = a(paramArticleInfo, paramInt);
    if (kmz.dg(i)) {
      return String.valueOf(i);
    }
    if ((paramArticleInfo != null) && (paramArticleInfo.mFeedType == 29)) {}
    for (paramInt = 1; (!kvx.jdMethod_do(i)) && (paramInt == 0); paramInt = 0) {
      return "";
    }
    if (paramInt == 0) {}
    for (paramArticleInfo = String.valueOf(i);; paramArticleInfo = b(paramArticleInfo))
    {
      QLog.d(TAG, 2, "getPTSCardViewType " + paramArticleInfo);
      return paramArticleInfo;
    }
  }
  
  public static kxb a()
  {
    if (jdField_a_of_type_Kxb == null) {}
    try
    {
      if (jdField_a_of_type_Kxb == null) {
        jdField_a_of_type_Kxb = new kxb();
      }
      return jdField_a_of_type_Kxb;
    }
    finally {}
  }
  
  private static boolean a(ArticleInfo paramArticleInfo, int paramInt)
  {
    int i = 0;
    boolean bool3 = true;
    int j = a(paramArticleInfo, paramInt);
    if (kmz.dg(j)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramInt = i;
      if (paramArticleInfo != null)
      {
        paramInt = i;
        if (paramArticleInfo.mFeedType == 29) {
          paramInt = 1;
        }
      }
      boolean bool2 = bool3;
      if (!kvx.jdMethod_do(j)) {
        if (paramInt == 0) {
          break label100;
        }
      }
      label100:
      for (bool2 = bool3;; bool2 = bool1)
      {
        QLog.d(TAG, 2, "isPtsCard | viewType : " + j + " isPts " + bool2);
        return bool2;
      }
    }
  }
  
  private static void aHG()
  {
    if ((am == null) || (am.length() == 0)) {}
    do
    {
      return;
      awit.H(adf, am.toString());
    } while ((ao == null) || (ao.length() == 0));
    awit.H(ade, ao.toString());
  }
  
  private List<BaseArticleInfo> aw()
  {
    ArrayList localArrayList = new ArrayList();
    if (gO != null) {
      localArrayList.addAll(gO);
    }
    return localArrayList;
  }
  
  private static String b(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramArticleInfo.proteusItemsData))) {
      return "";
    }
    try
    {
      paramArticleInfo = new JSONObject(paramArticleInfo.proteusItemsData).optString("style_ID");
      return paramArticleInfo;
    }
    catch (JSONException paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
    }
    return "";
  }
  
  private static String b(ArticleInfo paramArticleInfo, int paramInt)
  {
    paramArticleInfo = ndi.d(paramArticleInfo, paramInt);
    QLog.d(TAG, 2, "getPtsFamilyCardViewType | viewType : " + paramArticleInfo);
    return paramArticleInfo;
  }
  
  private void bY(List<BaseArticleInfo> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      if ((gO != null) && (gO.size() > 0)) {
        gO.clear();
      }
      paramList = paramList.listIterator();
      while (paramList.hasNext())
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramList.next();
        if (localBaseArticleInfo != null)
        {
          localBaseArticleInfo.articleViewModel = nte.a(localBaseArticleInfo);
          gO.add(localBaseArticleInfo);
        }
      }
    }
  }
  
  private boolean dx(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) || (dy(String.valueOf(paramString)));
  }
  
  private static boolean dy(String paramString)
  {
    if ((ao == null) || (TextUtils.isEmpty(ao.optString(paramString))) || (am == null) || (am.optLong(paramString) == 0L)) {}
    long l;
    do
    {
      return true;
      l = am.optLong(paramString);
    } while (System.currentTimeMillis() - l > aMr);
    return false;
  }
  
  private static String eq(String paramString)
  {
    try
    {
      String str = adc;
      Bundle localBundle = new Bundle();
      if (!TextUtils.isEmpty(paramString)) {
        localBundle.putString("card_id_list", paramString);
      }
      for (;;)
      {
        QLog.d(TAG, 2, "cgi req  url: " + str + "; req params " + localBundle.toString());
        paramString = jqc.a(BaseApplicationImpl.getContext(), str, "GET", localBundle, f());
        if (paramString != null) {
          break;
        }
        return "";
        localBundle.putString("version", aMq + "");
      }
      paramString = new String(paramString);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return "";
    }
    QLog.d(TAG, 2, "cgi resp : " + paramString);
    paramString = new JSONObject(paramString);
    if ((paramString != null) && (Integer.parseInt(paramString.getString(KEY_VERSION)) > 0))
    {
      int i = Integer.parseInt(paramString.getString(KEY_VERSION));
      if (i > aMq)
      {
        aMq = i;
        reset();
        gO.clear();
      }
      awit.H(KEY_VERSION, Integer.valueOf(aMq));
      QLog.d(TAG, 2, "update version " + aMq);
    }
    paramString = paramString.optString(adi);
    return paramString;
  }
  
  private static Bundle f()
  {
    Bundle localBundle = new Bundle();
    Object localObject = (QQAppInterface)kxm.getAppRuntime();
    String str1 = kxm.getAccount();
    localObject = (TicketManager)((QQAppInterface)localObject).getManager(2);
    String str2 = ((TicketManager)localObject).getSkey(str1);
    ((TicketManager)localObject).getPskey(str1, "oa.m.tencent.com");
    new StringBuilder().append("p_skey=").append(adn).toString();
    localBundle.putString("cookie", "uin=o" + str1 + ";p_skey=" + adn + ";p_uin=o" + str1 + ";skey=" + str2);
    QLog.d(TAG, 2, "cgi req  header : " + localBundle);
    return localBundle;
  }
  
  private static String iO()
  {
    Object localObject2 = ndi.getApp();
    if (localObject2 == null)
    {
      QLog.d(TAG, 2, "getPskeyFromServer | mApp is null");
      return "";
    }
    Object localObject1 = (TicketManager)((QQAppInterface)localObject2).getManager(2);
    if (localObject1 != null)
    {
      String str = ((QQAppInterface)localObject2).getCurrentAccountUin();
      localObject2 = new kxe((TicketManager)localObject1, (QQAppInterface)localObject2);
      localObject1 = ((TicketManager)localObject1).GetPskey(str, 16L, new String[] { "m.tencent.com" }, (WtTicketPromise)localObject2);
      if ((localObject1 != null) && (((Ticket)localObject1)._pskey_map != null) && (((Ticket)localObject1)._pskey_map.get("m.tencent.com") != null))
      {
        QLog.i(TAG, 1, "getPskeyFromServerAndRetry get pskey with promise success! isImediately Resend: ");
        localObject1 = new String((byte[])((Ticket)localObject1)._pskey_map.get("m.tencent.com"));
        adn = (String)localObject1;
        QLog.d(TAG, 2, "getPskeyFromServer mPskey : " + adn);
        return localObject1;
      }
      QLog.i(TAG, 1, "getPskeyFromServerAndRetry get pskey from server now!");
    }
    for (;;)
    {
      localObject1 = null;
      break;
      QLog.e(TAG, 1, "getPskeyFromServerAndRetry,ticketmanager is null");
    }
  }
  
  private void init()
  {
    aMq = ((Integer)awit.f(KEY_VERSION, Integer.valueOf(0))).intValue();
    QLog.d(TAG, 2, "local version " + aMq);
    try
    {
      am = new JSONObject((String)awit.f(adf, ""));
      an = new JSONObject((String)awit.f(adg, ""));
      ao = new JSONObject((String)awit.f(ade, ""));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void reset()
  {
    aig = false;
    gO.clear();
    dZ.clear();
  }
  
  public void a(int paramInt, List<oidb_cmd0x68b.RspGetFollowTabFeeds> paramList, List<ArticleInfo> paramList1)
  {
    if ((paramList == null) || (paramList1 == null) || (paramList.size() != paramList1.size()) || (ao == null)) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = paramList1.size();
        i = 0;
        if (i < j)
        {
          String str = b((ArticleInfo)paramList1.get(i), paramInt);
          a((ArticleInfo)paramList1.get(i), paramInt);
          if (!dx(str)) {
            break label218;
          }
          Object localObject = ((oidb_cmd0x68b.RspGetFollowTabFeeds)paramList.get(i)).toByteArray();
          byte[] arrayOfByte = new byte[localObject.length + 1];
          arrayOfByte[0] = 1;
          System.arraycopy(localObject, 0, arrayOfByte, 1, localObject.length);
          localObject = new String(aqgo.encode(arrayOfByte, 0));
          if (ao != null)
          {
            ao.put(str, localObject);
            this.adm = ao.toString();
          }
          if (am == null) {
            break label218;
          }
          am.put(str, System.currentTimeMillis());
        }
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
        return;
      }
      aHG();
      QLog.d(TAG, 2, "collect social card articleinfo ");
      return;
      label218:
      i += 1;
    }
  }
  
  public void a(kxb.a parama)
  {
    this.jdField_a_of_type_Kxb$a = parama;
  }
  
  public void a(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    if (paramArticleSummary == null) {}
    for (;;)
    {
      return;
      try
      {
        String str = b(paramArticleInfo, 0);
        a(paramArticleInfo, 0);
        if (dx(str))
        {
          paramArticleSummary = paramArticleSummary.toByteArray();
          paramArticleInfo = new byte[paramArticleSummary.length + 1];
          paramArticleInfo[0] = 2;
          System.arraycopy(paramArticleSummary, 0, paramArticleInfo, 1, paramArticleSummary.length);
          paramArticleSummary = new String(aqgo.encode(paramArticleInfo, 0));
          if (ao != null)
          {
            ao.put(str, paramArticleSummary);
            this.adm = ao.toString();
          }
          if (am != null) {
            am.put(str, System.currentTimeMillis());
          }
          aHG();
          QLog.d(TAG, 2, "collect ad card articleinfo ");
          return;
        }
      }
      catch (JSONException paramArticleSummary) {}
    }
  }
  
  public void aCg() {}
  
  public void aHF()
  {
    if (this.jdField_a_of_type_Kxb$a == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyProteusFamilyUtil.4(this));
  }
  
  public void c(List<articlesummary.ArticleSummary> paramList, List<ArticleInfo> paramList1, int paramInt)
  {
    if ((paramList == null) || (paramList1 == null) || (paramList.size() != paramList1.size()) || (ao == null)) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = paramList1.size();
        i = 0;
        if (i < j)
        {
          String str = b((ArticleInfo)paramList1.get(i), paramInt);
          a((ArticleInfo)paramList1.get(i), 0);
          if (!dx(str)) {
            break label218;
          }
          Object localObject = ((articlesummary.ArticleSummary)paramList.get(i)).toByteArray();
          byte[] arrayOfByte = new byte[localObject.length + 1];
          arrayOfByte[0] = 0;
          System.arraycopy(localObject, 0, arrayOfByte, 1, localObject.length);
          localObject = new String(aqgo.encode(arrayOfByte, 0));
          if (ao != null)
          {
            ao.put(str, localObject);
            this.adm = ao.toString();
          }
          if (am == null) {
            break label218;
          }
          am.put(str, System.currentTimeMillis());
        }
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
        return;
      }
      aHG();
      QLog.d(TAG, 2, "collect normal card articleinfo ");
      return;
      label218:
      i += 1;
    }
  }
  
  public void foreground() {}
  
  public void removeListener()
  {
    this.jdField_a_of_type_Kxb$a = null;
  }
  
  public static abstract interface a
  {
    public abstract void h(boolean paramBoolean, List<BaseArticleInfo> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kxb
 * JD-Core Version:    0.7.0.1
 */