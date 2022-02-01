import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.SRTUniversalID;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTClickInfo;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTRule;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class kxj
{
  private static kxj jdField_a_of_type_Kxj;
  private oidb_cmd0x64e.SRTClickInfo jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo;
  private String ado;
  private int axw;
  private String channelId;
  private List<oidb_cmd0x64e.SRTRule> gQ = new ArrayList();
  private List<kxj.a> gR = new ArrayList();
  
  private kxj()
  {
    init();
  }
  
  private String a(BaseArticleInfo paramBaseArticleInfo, String paramString, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((paramBaseArticleInfo == null) || (TextUtils.isEmpty(paramString)) || (paramBaseArticleInfo.srtUniversalID == null))
    {
      QLog.d("ReadInJoySrtUtils", 1, "getRowKey error, some object is null");
      if (paramBaseArticleInfo != null)
      {
        paramString = new StringBuilder().append("srtuniversalIdList is null = ");
        if (paramBaseArticleInfo.srtUniversalID != null) {
          break label71;
        }
      }
      label71:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("ReadInJoySrtUtils", 1, bool);
        return "";
      }
    }
    paramBaseArticleInfo = a(paramBaseArticleInfo.srtUniversalID, paramTemplateBean, paramViewBase);
    if (paramBaseArticleInfo == null)
    {
      QLog.d("ReadInJoySrtUtils", 1, "srtUniversalID is null ");
      return "";
    }
    if ((paramString.equals("com.tencent.reading")) && (paramBaseArticleInfo.bytes_kb_id.has()))
    {
      if (paramBaseArticleInfo.bytes_kb_id.get() != null) {
        return paramBaseArticleInfo.bytes_kb_id.get().toStringUtf8();
      }
      return "";
    }
    if ((paramString.equals("com.tencent.rijvideo")) && (paramBaseArticleInfo.bytes_ks_id.has()))
    {
      if (paramBaseArticleInfo.bytes_ks_id.get() != null) {
        return paramBaseArticleInfo.bytes_ks_id.get().toStringUtf8();
      }
      return "";
    }
    if ((paramString.equals("com.tencent.weishi")) && (paramBaseArticleInfo.bytes_ws_id.has()))
    {
      if (paramBaseArticleInfo.bytes_ws_id.get() != null) {
        return paramBaseArticleInfo.bytes_ws_id.get().toStringUtf8();
      }
      return "";
    }
    QLog.d("ReadInJoySrtUtils", 1, "getRowKey : no appPackageName hit ");
    return "";
  }
  
  private String a(kxj.a parama, BaseArticleInfo paramBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if (paramBaseArticleInfo == null) {
      return "";
    }
    if ((TextUtils.isEmpty(parama.h5Url)) || (TextUtils.isEmpty(parama.AG)) || (TextUtils.isEmpty(parama.packageName))) {
      return "";
    }
    String str3 = parama.packageName;
    String str1 = parama.h5Url;
    String str2 = parama.AG;
    paramTemplateBean = a(paramBaseArticleInfo, str3, paramTemplateBean, paramViewBase);
    QLog.d("ReadInJoySrtUtils", 1, "appPackageName = " + str3 + "defaultURL = " + str1 + "appSchema = " + str2 + " rowKey = " + paramTemplateBean);
    if ((TextUtils.isEmpty(paramTemplateBean)) && ((str1.contains("${rowkey}")) || (str2.contains("${rowkey}")))) {
      return "";
    }
    paramBaseArticleInfo = str2;
    parama = str1;
    if (!TextUtils.isEmpty(paramTemplateBean))
    {
      parama = str1.replace("${rowkey}", paramTemplateBean).replace("${uin}", kxm.getAccount());
      paramBaseArticleInfo = str2.replace("${rowkey}", paramTemplateBean).replace("${uin}", kxm.getAccount());
    }
    paramTemplateBean = new StringBuilder();
    try
    {
      paramTemplateBean.append("mqqapi://readinjoy/open?src_type=internal&target=4").append("&defaultURL=").append(URLEncoder.encode(parama, "utf-8")).append("&appSchema=").append(URLEncoder.encode(paramBaseArticleInfo, "utf-8")).append("&appPackageName=").append(str3).append("&readinjoyNotDecodeUrl=1").append("&version=1").append("&isCancelJump=0");
      QLog.d("ReadInJoySrtUtils", 1, paramTemplateBean.toString());
      return paramTemplateBean.toString();
    }
    catch (UnsupportedEncodingException parama)
    {
      for (;;)
      {
        parama.printStackTrace();
      }
    }
  }
  
  private kxj.a a(oidb_cmd0x64e.SRTRule paramSRTRule)
  {
    if (paramSRTRule == null) {
      return null;
    }
    kxj.a locala = new kxj.a();
    if (paramSRTRule.uint32_click_number.has()) {
      locala.gT = paramSRTRule.uint32_click_number.get();
    }
    if (paramSRTRule.uint32_feeds_type.has()) {
      locala.gS = paramSRTRule.uint32_feeds_type.get();
    }
    if (paramSRTRule.uint32_network_type.has()) {
      locala.aMs = paramSRTRule.uint32_network_type.get();
    }
    if (paramSRTRule.bytes_app_package_name.has()) {
      locala.packageName = paramSRTRule.bytes_app_package_name.get().toStringUtf8();
    }
    if (paramSRTRule.bytes_schema.has()) {
      locala.AG = paramSRTRule.bytes_schema.get().toStringUtf8();
    }
    if (paramSRTRule.bytes_h5.has()) {
      locala.h5Url = paramSRTRule.bytes_h5.get().toStringUtf8();
    }
    QLog.d("ReadInJoySrtUtils", 1, "convertSRTPbToSRTClassclickNumList = " + locala.gT + " feedsTypeList= " + locala.gS + " netWorkType= " + locala.aMs + " packageName = " + locala.packageName + " schemaUrl= " + locala.AG + " h5Url= " + locala.h5Url);
    return locala;
  }
  
  public static kxj a()
  {
    try
    {
      if (jdField_a_of_type_Kxj == null) {
        jdField_a_of_type_Kxj = new kxj();
      }
      kxj localkxj = jdField_a_of_type_Kxj;
      return localkxj;
    }
    finally {}
  }
  
  private articlesummary.SRTUniversalID a(List<articlesummary.SRTUniversalID> paramList, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    if ((paramTemplateBean == null) || (paramViewBase == null)) {
      return (articlesummary.SRTUniversalID)paramList.get(0);
    }
    paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getViewId()).get("srt_universal_id_index");
    if ((paramTemplateBean instanceof String)) {}
    for (;;)
    {
      try
      {
        i = Integer.parseInt((String)paramTemplateBean);
        if ((paramList.size() <= i) || (i < 0)) {
          break;
        }
        return (articlesummary.SRTUniversalID)paramList.get(i);
      }
      catch (Exception paramTemplateBean)
      {
        QLog.e("ReadInJoySrtUtils", 1, "handlePositionAndGetSRT parse int error");
      }
      int i = 0;
    }
    return null;
  }
  
  private oidb_cmd0x64e.SRTRule a(kxj.a parama)
  {
    if (parama == null) {
      return null;
    }
    oidb_cmd0x64e.SRTRule localSRTRule = new oidb_cmd0x64e.SRTRule();
    if (parama.AG != null) {
      localSRTRule.bytes_schema.set(ByteStringMicro.copyFromUtf8(parama.AG));
    }
    if (parama.h5Url != null) {
      localSRTRule.bytes_h5.set(ByteStringMicro.copyFromUtf8(parama.h5Url));
    }
    if (parama.packageName != null) {
      localSRTRule.bytes_app_package_name.set(ByteStringMicro.copyFromUtf8(parama.packageName));
    }
    if (parama.gT != null) {
      localSRTRule.uint32_click_number.set(parama.gT);
    }
    if (parama.gS != null) {
      localSRTRule.uint32_feeds_type.set(parama.gS);
    }
    localSRTRule.uint32_network_type.set(parama.aMs);
    return localSRTRule;
  }
  
  private void a(kxj.a parama, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.gQ == null) || (paramInt3 >= this.gQ.size())) {}
    do
    {
      return;
      QLog.d("ReadInJoySrtUtils", 1, "convertSRTClickInfo feedsType:" + paramInt1 + " clickTimes: " + paramInt2 + " position" + paramInt3);
      this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo = new oidb_cmd0x64e.SRTClickInfo();
      parama = a(parama);
      if (parama != null)
      {
        ArrayList localArrayList1 = new ArrayList();
        localArrayList1.add(Integer.valueOf(paramInt2));
        ArrayList localArrayList2 = new ArrayList();
        localArrayList2.add(Integer.valueOf(paramInt1));
        parama.uint32_click_number.set(localArrayList1);
        parama.uint32_feeds_type.set(localArrayList2);
      }
      this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo.msg_srt_rule_list.set(this.gQ);
      this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo.uint32_hit_srt_rule_index.set(paramInt3);
    } while (parama == null);
    this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo.msg_hit_srt_rule.set(parama);
  }
  
  private boolean a(kxj.a parama, int paramInt)
  {
    if (parama == null) {}
    int i;
    int j;
    do
    {
      do
      {
        return false;
      } while ((parama.gT == null) || (parama.gS == null));
      i = parama.aMs;
      j = jqi.getNetworkType(BaseActivity.sTopActivity);
    } while ((j == 0) || ((i == 1) && (j != 1)) || ((i == 2) && (j == 1)) || (!parama.gS.contains(Integer.valueOf(paramInt))));
    return parama.gT.contains(Integer.valueOf(this.axw));
  }
  
  private void aHR()
  {
    try
    {
      Object localObject = (String)awit.f("readinjoy_srt_click_time_key", "");
      String str1;
      int i;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject();
        String str2 = ((JSONObject)localObject).optString("time", "");
        int j = ((JSONObject)localObject).optInt("clickTimes" + this.channelId, 0);
        str1 = mgk.getDateString();
        i = j;
        if (j == 0) {
          i = this.axw;
        }
        if (str2.equals(str1)) {
          break label180;
        }
        localObject = new JSONObject();
        i = 0;
      }
      for (;;)
      {
        i += 1;
        this.axw = i;
        ((JSONObject)localObject).put("time", str1);
        ((JSONObject)localObject).put("clickTimes" + this.channelId, i);
        awit.H("readinjoy_srt_click_time_key", ((JSONObject)localObject).toString());
        return;
        localObject = new JSONObject((String)localObject);
        break;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return;
    }
  }
  
  private void init() {}
  
  public boolean AH()
  {
    return (this.gR != null) && (this.gR.size() != 0);
  }
  
  public oidb_cmd0x64e.SRTClickInfo a()
  {
    if (this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo == null)
    {
      QLog.d("ReadInJoySrtUtils", 1, "getNoDifferenceDiversionInfo cache is null");
      return null;
    }
    QLog.d("ReadInJoySrtUtils", 1, "getNoDifferenceDiversionInfo");
    oidb_cmd0x64e.SRTClickInfo localSRTClickInfo = this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo;
    this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo = null;
    return localSRTClickInfo;
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((this.gR == null) || (this.gR.size() == 0) || (paramBaseArticleInfo == null) || ((paramBaseArticleInfo.mChannelID != 0L) && (!kys.dv((int)paramBaseArticleInfo.mChannelID)))) {
      QLog.d("ReadInJoySrtUtils", 1, "judgeIsNeedNoDifferenceDiversion srtInfos is null");
    }
    label255:
    for (;;)
    {
      return false;
      aHR();
      int i = 0;
      for (;;)
      {
        if (i >= this.gR.size()) {
          break label255;
        }
        kxj.a locala = (kxj.a)this.gR.get(i);
        int j = kxm.a(paramBaseArticleInfo);
        QLog.d("ReadInJoySrtUtils", 1, "startJudge feedsType:" + j + " clickTimes: " + this.axw + " position" + i);
        if (a(locala, j))
        {
          paramBaseArticleInfo = a(locala, paramBaseArticleInfo, paramTemplateBean, paramViewBase);
          if (TextUtils.isEmpty(paramBaseArticleInfo)) {
            break;
          }
          this.ado = paramBaseArticleInfo;
          a(locala, j, this.axw, i);
          QLog.d("ReadInJoySrtUtils", 1, "hitSrtRules feedsType:" + j + " clickTimes: " + this.axw + " position" + i);
          return true;
        }
        i += 1;
      }
    }
  }
  
  public void bZ(List<oidb_cmd0x64e.SRTRule> paramList)
  {
    if (paramList != null)
    {
      this.gQ = paramList;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        kxj.a locala = a((oidb_cmd0x64e.SRTRule)localIterator.next());
        if (locala != null) {
          localArrayList.add(locala);
        }
      }
      this.gR = localArrayList;
      QLog.d("ReadInJoySrtUtils", 1, "handle0x80aRespInfo  size = " + paramList.size());
    }
  }
  
  public void clearData()
  {
    this.gQ.clear();
    this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo = null;
    this.ado = null;
    this.gR = null;
    this.axw = 0;
    QLog.d("ReadInJoySrtUtils", 1, "clearData");
  }
  
  public String gd()
  {
    if (this.ado == null) {
      QLog.d("ReadInJoySrtUtils", 1, "getJumpSchema schemaCache is null");
    }
    String str = this.ado;
    this.ado = null;
    return str;
  }
  
  public void mB(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.channelId = paramString;
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("channel_id");
    localAttributeList.att_value.set(paramString);
    localArrayList.add(localAttributeList);
    ocp.y(202, localArrayList);
    QLog.d("ReadInJoySrtUtils", 1, "start requestSRTRulesattris size = " + localArrayList.size() + "event_id = " + 202 + "id: " + paramString);
  }
  
  public class a
  {
    public String AG;
    public int aMs;
    public List<Integer> gS;
    public List<Integer> gT;
    public String h5Url;
    public String packageName;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kxj
 * JD-Core Version:    0.7.0.1
 */