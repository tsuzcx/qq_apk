import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.BackOffGroupInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqChannelPara;

public class mgn
  implements mgk.a
{
  private static String TAG = "UGRuleManager";
  private static int action;
  public static String agD = "readinjoy_sp_update_one_day";
  public static String agE = "readinjoy_sp_clcik_times_one_day";
  public static String agF = "readinjoy_sp_remain_times_one_day";
  private static int id;
  private final int aRj = 3;
  private final int aRk = 108;
  private final int aRl = 7;
  private final int aRm = 109;
  private final int aRn = 110;
  private Map<String, mgn.a> eu = new HashMap();
  
  public static boolean Z(BaseArticleInfo paramBaseArticleInfo)
  {
    if (aa(paramBaseArticleInfo)) {}
    while ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.weishiUGInfo != null) && (paramBaseArticleInfo.weishiUGInfo.uint32_use_ug.has()) && (paramBaseArticleInfo.weishiUGInfo.uint32_use_ug.get() > 0) && (paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info.has()) && (paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info.get() != null)) {
      return true;
    }
    return false;
  }
  
  public static int a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    if (!Z(paramBaseArticleInfo)) {
      return 0;
    }
    if (!paramBoolean) {
      return 2;
    }
    return action;
  }
  
  private int a(mgn.a parama, String paramString1, String paramString2)
  {
    try
    {
      Object localObject = (String)awit.f(agE, "");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return parama.aRr;
      }
      localObject = new JSONObject((String)localObject);
      String str = ((JSONObject)localObject).optString("time", "");
      int j = ((JSONObject)localObject).optInt("clickTimes" + paramString2 + paramString1, 0);
      if (!str.equals(mgk.getDateString())) {
        return parama.aRr;
      }
      int i = j;
      if (j == 0) {
        i = parama.aRr;
      }
      QLog.d(TAG, 1, "getChannelClickTimes :" + i);
      return i;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return parama.aRr;
  }
  
  private BaseArticleInfo a(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.viewRowkey != null) && (!paramBaseArticleInfo.viewRowkey.equals(paramBaseArticleInfo.innerUniqueID)) && (paramBaseArticleInfo.mSubArtilceList != null) && (paramBaseArticleInfo.mSubArtilceList.size() > 0) && (paramBaseArticleInfo.mSubArtilceList.get(0) != null) && (paramBaseArticleInfo.viewRowkey.equals(((ArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0)).innerUniqueID))) {
      return (BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
    }
    return paramBaseArticleInfo;
  }
  
  public static List<String> a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!Z(paramBaseArticleInfo)) {
      return null;
    }
    if ((!paramBaseArticleInfo.weishiUGInfo.rpt_bytes_report_base_url.has()) || (paramBaseArticleInfo.weishiUGInfo.rpt_bytes_report_base_url.get() == null))
    {
      QLog.d(TAG, 1, "getReportUrl is null");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramBaseArticleInfo = paramBaseArticleInfo.weishiUGInfo.rpt_bytes_report_base_url.get().iterator();
    while (paramBaseArticleInfo.hasNext())
    {
      ByteStringMicro localByteStringMicro = (ByteStringMicro)paramBaseArticleInfo.next();
      localArrayList.add(localByteStringMicro.toStringUtf8());
      QLog.d(TAG, 1, "getReportUrl is " + localByteStringMicro.toStringUtf8());
    }
    return localArrayList;
  }
  
  private mgn.a a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramString1 = null;
    }
    String str;
    do
    {
      return paramString1;
      str = paramString2 + paramString1;
      paramString2 = (mgn.a)this.eu.get(str);
      paramString1 = paramString2;
    } while (paramString2 != null);
    paramString1 = new mgn.a();
    this.eu.put(str, paramString1);
    return paramString1;
  }
  
  private void a(List<ArticleInfo> paramList, mgn.a parama, mgn.c paramc)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)paramList.next();
      if (parama.agG.equals(o(localArticleInfo))) {
        paramc.iJ.add(localArticleInfo.innerUniqueID);
      }
      if ((localArticleInfo.mSubArtilceList != null) && (localArticleInfo.mSubArtilceList.size() > 0)) {
        a(localArticleInfo.mSubArtilceList, parama, paramc);
      }
    }
  }
  
  private void a(mgn.a parama, String paramString1, String paramString2)
  {
    try
    {
      Object localObject = (String)awit.f(agE, "");
      QLog.d(TAG, 1, "start saveChannelClickToSP :" + (String)localObject);
      String str1;
      int i;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject();
        String str2 = ((JSONObject)localObject).optString("time", "");
        int j = ((JSONObject)localObject).optInt("clickTimes" + paramString2 + paramString1, 0);
        str1 = mgk.getDateString();
        i = j;
        if (j == 0) {
          i = parama.aRr;
        }
        if (str2.equals(str1)) {
          break label258;
        }
        localObject = new JSONObject();
        i = 0;
      }
      for (;;)
      {
        i += 1;
        parama.aRr = i;
        ((JSONObject)localObject).put("time", str1);
        ((JSONObject)localObject).put("clickTimes" + paramString2 + paramString1, i);
        QLog.d(TAG, 1, "end saveChannelClickToSP :" + ((JSONObject)localObject).toString());
        awit.H(agE, ((JSONObject)localObject).toString());
        return;
        localObject = new JSONObject((String)localObject);
        break;
      }
    }
    catch (JSONException parama)
    {
      parama.printStackTrace();
      return;
    }
  }
  
  private void a(mgn.b paramb)
  {
    if ((paramb != null) && (paramb.iH.size() > 0))
    {
      Iterator localIterator = paramb.iH.iterator();
      while (localIterator.hasNext())
      {
        oidb_cmd0x68b.BackOffGroupInfo localBackOffGroupInfo = (oidb_cmd0x68b.BackOffGroupInfo)localIterator.next();
        if (localBackOffGroupInfo.bytes_back_off_group.has()) {
          a(localBackOffGroupInfo, paramb.iI);
        }
      }
    }
  }
  
  private void a(oidb_cmd0x68b.BackOffGroupInfo paramBackOffGroupInfo, List<ArticleInfo> paramList)
  {
    int j = 0;
    if ((paramList == null) || (paramList.size() == 0)) {}
    mgn.a locala;
    do
    {
      return;
      long l = ((ArticleInfo)paramList.get(0)).mChannelID;
      locala = a(paramBackOffGroupInfo.bytes_back_off_group.get().toStringUtf8(), String.valueOf(l));
    } while (locala == null);
    locala.agG = paramBackOffGroupInfo.bytes_back_off_group.get().toStringUtf8();
    if (paramBackOffGroupInfo.uint32_max_evoke_count.has()) {}
    for (int i = paramBackOffGroupInfo.uint32_max_evoke_count.get();; i = 0)
    {
      locala.aRp = i;
      i = j;
      if (paramBackOffGroupInfo.uint32_max_fresh_evoke_count.has()) {
        i = paramBackOffGroupInfo.uint32_max_fresh_evoke_count.get();
      }
      locala.aRq = i;
      paramBackOffGroupInfo = new mgn.c();
      a(paramList, locala, paramBackOffGroupInfo);
      locala.a(paramBackOffGroupInfo);
      return;
    }
  }
  
  public static void a(oidb_cmd0x68b.ReqChannelPara paramReqChannelPara, String paramString)
  {
    try
    {
      Object localObject = (String)awit.f(agD, "");
      QLog.d(TAG, 1, "start addFreshTimesToUGAndSaveToSp : " + (String)localObject);
      int i;
      String str1;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject();
        String str2 = ((JSONObject)localObject).optString("time", "");
        i = ((JSONObject)localObject).optInt("freshTimes" + paramString, 0);
        str1 = mgk.getDateString();
        if (str2.equals(str1)) {
          break label221;
        }
        localObject = new JSONObject();
        i = 0;
      }
      for (;;)
      {
        i += 1;
        ((JSONObject)localObject).put("time", str1);
        ((JSONObject)localObject).put("freshTimes" + paramString, i);
        QLog.d(TAG, 1, "end addFreshTimesToUGAndSaveToSp : " + ((JSONObject)localObject).toString());
        awit.H(agD, ((JSONObject)localObject).toString());
        paramReqChannelPara.uint32_update_times_one_day.set(i);
        return;
        localObject = new JSONObject((String)localObject);
        break;
      }
    }
    catch (JSONException paramReqChannelPara)
    {
      paramReqChannelPara.printStackTrace();
      return;
    }
  }
  
  public static void aPb()
  {
    rK(id);
  }
  
  public static boolean aa(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.weishiUGInfo != null) && (paramBaseArticleInfo.weishiUGInfo.uint32_is_with_angle_sign.has()) && (paramBaseArticleInfo.weishiUGInfo.uint32_is_with_angle_sign.get() > 0) && (paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info.has()) && (paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info.get() != null);
  }
  
  public static boolean ab(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!Z(paramBaseArticleInfo))
    {
      QLog.d(TAG, 1, "judgeIsAgreement is not isUgCard");
      return false;
    }
    int i = paramBaseArticleInfo.weishiUGInfo.uint32_use_ug.get();
    paramBaseArticleInfo = paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info;
    if (paramBaseArticleInfo.bytes_jump_bundle.has())
    {
      paramBaseArticleInfo = paramBaseArticleInfo.bytes_jump_bundle.get().toStringUtf8();
      bool = aqiz.isAppInstalled(BaseApplicationImpl.getApplication(), paramBaseArticleInfo);
      QLog.d(TAG, 1, "judgeIsAgreement isappInstall " + paramBaseArticleInfo + " :" + bool + " useUg: " + i);
      if (((!bool) || (i != 2)) && ((bool) || (i != 1))) {
        break label142;
      }
    }
    label142:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      paramBaseArticleInfo = "";
      break;
    }
  }
  
  public static boolean dV(String paramString)
  {
    if ((paramString.startsWith("http://clientui.3g.qq.com/mqqapi/")) || (paramString.startsWith("http://clientui.3g.qq.com/mqq/")) || (paramString.startsWith("http://qm.qq.com/cgi-bin/")) || (paramString.startsWith("https://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard"))) {}
    for (int i = 1;; i = 0) {
      return (i == 0) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://")));
    }
  }
  
  public static int j(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!Z(paramBaseArticleInfo)) {}
    while (!paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info.uint32_jump_src.has()) {
      return 1;
    }
    return paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info.uint32_jump_src.get();
  }
  
  private String o(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!Z(paramBaseArticleInfo)) {}
    while (!paramBaseArticleInfo.weishiUGInfo.bytes_back_off_group.has()) {
      return null;
    }
    return paramBaseArticleInfo.weishiUGInfo.bytes_back_off_group.get().toStringUtf8();
  }
  
  public static void rJ(int paramInt)
  {
    if (id != paramInt)
    {
      QLog.d(TAG, 1, "wakeUpTimeCalculate change channel channel id is " + paramInt);
      rK(id);
    }
    if ((paramInt == 0) || (kys.du(paramInt)))
    {
      id = paramInt;
      kxy localkxy2 = kxy.a(String.valueOf(paramInt));
      kxy localkxy1 = localkxy2;
      if (localkxy2 == null)
      {
        localkxy1 = new kxy();
        kxy.a(String.valueOf(paramInt), localkxy1);
      }
      QLog.d(TAG, 1, "wakeUpTimeCalculate channel id is " + paramInt);
      localkxy1.wakeUp();
    }
  }
  
  public static void rK(int paramInt)
  {
    if ((paramInt == 0) || (kys.du(paramInt)))
    {
      kxy localkxy = kxy.a(String.valueOf(paramInt));
      if ((localkxy != null) && (localkxy.Bf()))
      {
        rL(paramInt);
        localkxy.aIc();
        localkxy.reset();
        QLog.d(TAG, 1, "stopTimeCalculate channel id is " + paramInt);
      }
    }
  }
  
  private static void rL(int paramInt)
  {
    if (paramInt != 0) {}
    for (;;)
    {
      try
      {
        if (!kys.du(paramInt)) {
          break;
        }
        Object localObject = kxy.a(String.valueOf(paramInt));
        if (localObject != null)
        {
          l1 = ((kxy)localObject).b(false);
          localObject = (String)awit.f(agF, "");
          QLog.d(TAG, 1, "start saveRemainTimeToSP string is " + (String)localObject);
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new JSONObject();
            long l2 = ((JSONObject)localObject).optLong("remainTime" + paramInt, 0L);
            String str2 = ((JSONObject)localObject).optString("time", "");
            String str1 = mgk.getDateString();
            if (!str2.equals(str1))
            {
              localObject = new JSONObject();
              l2 = 0L;
              ((JSONObject)localObject).put("time", str1);
              ((JSONObject)localObject).put("remainTime" + paramInt, l2 + l1);
              QLog.d(TAG, 1, "end saveRemainTimeToSP string is " + ((JSONObject)localObject).toString());
              awit.H(agF, ((JSONObject)localObject).toString());
            }
          }
          else
          {
            localObject = new JSONObject((String)localObject);
            continue;
          }
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      long l1 = 0L;
    }
  }
  
  public static long u(int paramInt)
  {
    if (paramInt != 0) {}
    for (;;)
    {
      try
      {
        if (kys.du(paramInt))
        {
          Object localObject = kxy.a(String.valueOf(paramInt));
          if (localObject == null) {
            break label239;
          }
          l1 = ((kxy)localObject).b(false);
          localObject = (String)awit.f(agF, "");
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            QLog.d(TAG, 1, "getNowRemainTime time is" + l1 / 1000L);
            return l1 / 1000L;
          }
          localObject = new JSONObject((String)localObject);
          String str = ((JSONObject)localObject).optString("time", "");
          long l2 = ((JSONObject)localObject).optLong("remainTime" + paramInt, 0L);
          if (!str.equals(mgk.getDateString()))
          {
            QLog.d(TAG, 1, "getNowRemainTime time is" + l1 / 1000L);
            return l1 / 1000L;
          }
          QLog.d(TAG, 1, "getNowRemainTime time is" + (l1 + l2) / 1000L);
          l1 = (l1 + l2) / 1000L;
          return l1;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return 0L;
      label239:
      long l1 = 0L;
    }
  }
  
  public void T(Object paramObject)
  {
    if (!(paramObject instanceof mgn.b)) {
      return;
    }
    QLog.d(TAG, 1, "handleRules");
    a((mgn.b)paramObject);
  }
  
  public String a(BaseArticleInfo paramBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if (!Z(paramBaseArticleInfo)) {
      return null;
    }
    paramViewBase = a(paramBaseArticleInfo);
    paramTemplateBean = paramViewBase.weishiUGInfo.msg_url_jump_info;
    if (paramTemplateBean.bytes_jump_schema.has())
    {
      paramBaseArticleInfo = paramTemplateBean.bytes_jump_schema.get().toStringUtf8();
      if (!paramTemplateBean.bytes_jump_url.has()) {
        break label144;
      }
      paramTemplateBean = paramTemplateBean.bytes_jump_url.get().toStringUtf8();
      label65:
      if (!paramViewBase.weishiUGInfo.msg_url_jump_info.uint32_jump_type.has()) {
        break label150;
      }
    }
    int j;
    label144:
    label150:
    for (int i = paramViewBase.weishiUGInfo.msg_url_jump_info.uint32_jump_type.get();; i = 0)
    {
      j = paramViewBase.weishiUGInfo.uint32_use_ug.get();
      if ((!TextUtils.isEmpty(paramBaseArticleInfo)) || (!TextUtils.isEmpty(paramTemplateBean))) {
        break label156;
      }
      QLog.d(TAG, 1, "getJumpUrl schema & h5 is null");
      action = 3;
      return null;
      paramBaseArticleInfo = "";
      break;
      paramTemplateBean = "";
      break label65;
    }
    label156:
    if (!ab(paramViewBase))
    {
      if ((j == 2) && (i == 2) && (!TextUtils.isEmpty(paramTemplateBean)))
      {
        QLog.d(TAG, 1, "getJumpUrl return is h5:" + paramTemplateBean);
        action = 108;
        return paramTemplateBean;
      }
      QLog.d(TAG, 1, "getJumpUrl judgeIsAgreement is false");
      action = 109;
      return null;
    }
    if (j == 1)
    {
      if ((i == 1) && (!TextUtils.isEmpty(paramTemplateBean)))
      {
        QLog.d(TAG, 1, "getJumpUrl return is h5:" + paramTemplateBean);
        action = 108;
        return paramTemplateBean;
      }
    }
    else if (j == 2)
    {
      if ((i == 2) && (!TextUtils.isEmpty(paramBaseArticleInfo)))
      {
        QLog.d(TAG, 1, "getJumpUrl return is schema:" + paramBaseArticleInfo);
        action = 7;
        return paramBaseArticleInfo;
      }
      if ((i == 1) && (!TextUtils.isEmpty(paramTemplateBean)))
      {
        QLog.d(TAG, 1, "getJumpUrl return is h5:" + paramTemplateBean);
        action = 108;
        return paramTemplateBean;
      }
    }
    action = 3;
    QLog.d(TAG, 1, "getJumpUrl return is null");
    return null;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = a(paramBaseArticleInfo, paramBoolean2);
    if (j != 0)
    {
      int i = j;
      if (!paramBoolean1)
      {
        i = j;
        if (j != 110) {
          i = 3;
        }
      }
      QLog.d(TAG, 1, "UGRuleManager getUGSchema action is:" + i);
      obr.k(paramBaseArticleInfo, i);
    }
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if (aa(paramBaseArticleInfo))
    {
      QLog.d(TAG, 1, "judgeHitRule isWithAngleSign");
      bool1 = true;
      return bool1;
    }
    if (!Z(paramBaseArticleInfo))
    {
      QLog.d(TAG, 1, "judgeHitRule isNotUgCard");
      return false;
    }
    String str2 = paramBaseArticleInfo.weishiUGInfo.bytes_back_off_group.get().toStringUtf8();
    String str1 = paramBaseArticleInfo.innerUniqueID;
    if (paramBaseArticleInfo.viewRowkey != null) {
      str1 = paramBaseArticleInfo.viewRowkey;
    }
    for (;;)
    {
      mgn.a locala = a(str2, String.valueOf(paramBaseArticleInfo.mChannelID));
      if (locala == null)
      {
        QLog.d(TAG, 1, "judgeHitRule backOffGroup is null");
        return false;
      }
      if (paramBaseArticleInfo.weishiUGInfo.uint32_residence_threshold.has()) {}
      for (int i = paramBaseArticleInfo.weishiUGInfo.uint32_residence_threshold.get(); i > u((int)paramBaseArticleInfo.mChannelID); i = 0)
      {
        QLog.d(TAG, 1, "judgeHitRule is not reach minTime");
        action = 110;
        return false;
      }
      locala.aRr = a(locala, str2, String.valueOf(paramBaseArticleInfo.mChannelID));
      QLog.d(TAG, 1, "judgeHitRule backOffGroup.clickTime is " + locala.aRr + " backOffGroup.maxEvokeCount is " + locala.aRp + " groupid is " + locala.agG);
      if (locala.aRr >= locala.aRp)
      {
        QLog.d(TAG, 1, "judgeHitRule over groupClick");
        return false;
      }
      Iterator localIterator = locala.d.iterator();
      mgn.c localc;
      do
      {
        bool1 = bool2;
        if (!localIterator.hasNext()) {
          break;
        }
        localc = (mgn.c)localIterator.next();
      } while (!localc.iJ.contains(str1));
      QLog.d(TAG, 1, "judgeHitRule freshInfo.clickTime is " + localc.aRr + " backOffGroup.maxFreshEvokeCount is " + locala.aRq);
      bool1 = bool2;
      if (localc.aRr >= locala.aRq) {
        break;
      }
      if ((paramBoolean) && (!TextUtils.isEmpty(a(paramBaseArticleInfo, null, null))))
      {
        localc.aRr += 1;
        a(locala, str2, String.valueOf(paramBaseArticleInfo.mChannelID));
      }
      return true;
    }
  }
  
  class a
  {
    private final int aRo = 50;
    int aRp;
    int aRq;
    int aRr = 0;
    String agG;
    Deque<mgn.c> d = new LinkedList();
    
    a() {}
    
    boolean a(mgn.c paramc)
    {
      if (this.d.size() >= 50) {
        this.d.poll();
      }
      return this.d.offer(paramc);
    }
  }
  
  public static class b
  {
    public List<oidb_cmd0x68b.BackOffGroupInfo> iH;
    public List<ArticleInfo> iI;
  }
  
  class c
  {
    int aRr = 0;
    List<String> iJ = new ArrayList();
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mgn
 * JD-Core Version:    0.7.0.1
 */