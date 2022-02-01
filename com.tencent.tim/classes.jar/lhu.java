import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.2;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.3;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.5;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RelatedSearchData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RelatedSearchData.a;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.feeds_info.BiuMultiLevel;
import tencent.im.oidb.articlesummary.feeds_info.SocializeFeedsExtInfo;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.Client;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ReqArticle;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ReqBody;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.RspBody;
import tencent.im.oidb.cmd0xad7.oidb_cmd0xad7.Client;
import tencent.im.oidb.cmd0xad7.oidb_cmd0xad7.ReqArticle;
import tencent.im.oidb.cmd0xad7.oidb_cmd0xad7.ReqBody;
import tencent.im.oidb.cmd0xad7.oidb_cmd0xad7.RspBody;
import tencent.im.oidb.cmd0xad7.oidb_cmd0xad7.RspShare;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.ArticleBusiness;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.Client;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RelatedSearchWord;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.ReqArticle;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.ReqBody;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.ReqOption;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RspBiuCount;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RspBody;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RspTopic;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.SentimentEntityData;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.StyleCard;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.UnionNlpInfo;
import tencent.im.oidb.cmd0xbd3.oidb_cmd0xbd3.FeedParam;
import tencent.im.oidb.cmd0xbd3.oidb_cmd0xbd3.ReqBody;
import tencent.im.oidb.cmd0xbd3.oidb_cmd0xbd3.RspBody;
import tencent.im.oidb.cmd0xbd3.oidb_cmd0xbd3.ShareInfo;

public class lhu
  extends lir
{
  public static final String TAG = lhu.class.getSimpleName();
  private AtomicInteger R = new AtomicInteger(0);
  private QQLruCache<String, List<BaseData>> b;
  private ConcurrentHashMap<Integer, Object> bf = new ConcurrentHashMap();
  private ConcurrentHashMap<String, lhu.c<FastWebArticleInfo>> bm = new ConcurrentHashMap();
  private HashMap<String, lhu.c<Parcelable>> dS = new HashMap();
  
  public lhu(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, lun paramlun, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramlun, paramHandler);
    aMu();
  }
  
  private Object a(Integer paramInteger)
  {
    return this.bf.remove(paramInteger);
  }
  
  private void a(Integer paramInteger, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    this.bf.put(paramInteger, paramObject);
  }
  
  private void aMu()
  {
    this.b = new lhv(this, 2012, 30, 1);
  }
  
  private void ad(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("ad6Seq")).intValue();
    String str = (String)paramToServiceMsg.getAttribute("uniflag");
    long l = System.currentTimeMillis() - ((Long)paramToServiceMsg.getAttribute("ad6ReqTime")).longValue();
    int j = ((Integer)paramToServiceMsg.getAttribute("reqType")).intValue();
    oidb_cmd0xad6.RspBody localRspBody = new oidb_cmd0xad6.RspBody();
    int k = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool1 = false;
    boolean bool2 = false;
    paramToServiceMsg = null;
    if (k == 0)
    {
      bool1 = bool2;
      if (localRspBody.bool_use_webview.has())
      {
        bool1 = bool2;
        if (localRspBody.bool_use_webview.get()) {
          bool1 = true;
        }
      }
      paramToServiceMsg = new FastWebArticleInfo();
      boolean bool3 = paramToServiceMsg.a(localRspBody, j);
      bool2 = bool1;
      bool1 = bool3;
    }
    for (;;)
    {
      paramFromServiceMsg = (lhu.b)a(Integer.valueOf(i));
      if (paramFromServiceMsg != null)
      {
        QLog.d("Q.readinjoy.fast_web", 2, "callback  result : " + bool1 + ", seq : " + i + ", useWebView : " + bool2 + ", cost : " + l + ", retCode : " + k + ", native info : " + paramToServiceMsg + "  callback : " + paramFromServiceMsg);
        ThreadManager.getUIHandler().post(new FastWebModule.1(this, paramFromServiceMsg, bool1, bool2, paramToServiceMsg));
      }
      QLog.d("Q.readinjoy.fast_web", 2, "ad6 resp  result : " + bool1 + ", seq : " + i + ", useWebView : " + bool2 + ", cost : " + l + ", retCode : " + k + ", native info : " + paramToServiceMsg);
      if (str != null)
      {
        if ((j != 1) && ((j != 3) || (!bool1))) {
          break label513;
        }
        this.bm.put(str, new lhu.c(paramToServiceMsg));
      }
      for (;;)
      {
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("which", "2");
        paramToServiceMsg.put("reqType", String.valueOf(j));
        paramToServiceMsg.put("param_uin", kxm.getAccount());
        paramToServiceMsg.put("param_retCode", k + "");
        paramToServiceMsg.put("param_succ", String.valueOf(bool1));
        paramToServiceMsg.put("param_netType", aroc.getNetType(null) + "");
        anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianFastWebCost", bool1, l, 0L, paramToServiceMsg, null);
        return;
        label513:
        if ((paramToServiceMsg != null) && (this.bm.containsKey(str)))
        {
          paramFromServiceMsg = (lhu.c)this.bm.get(str);
          ((FastWebArticleInfo)paramFromServiceMsg.get()).I(paramToServiceMsg.sN, paramToServiceMsg.xK);
          paramFromServiceMsg.update(paramFromServiceMsg.get());
        }
      }
      bool2 = false;
    }
  }
  
  private void ae(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("ad7Seq")).intValue();
    long l1 = System.currentTimeMillis();
    long l2 = ((Long)paramToServiceMsg.getAttribute("ad7ReqTime")).longValue();
    int j = ((Integer)paramToServiceMsg.getAttribute("ad7Action")).intValue();
    paramToServiceMsg = new oidb_cmd0xad7.RspBody();
    int k = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = new nnf();
    boolean bool;
    if ((k == 0) && (paramToServiceMsg.msg_rsp_share.has()))
    {
      bool = true;
      paramToServiceMsg = (oidb_cmd0xad7.RspShare)paramToServiceMsg.msg_rsp_share.get();
      paramFromServiceMsg.amv = paramToServiceMsg.bytes_wechat_pyq.get().toStringUtf8();
      paramFromServiceMsg.amu = paramToServiceMsg.bytes_weibo.get().toStringUtf8();
      paramFromServiceMsg.amx = paramToServiceMsg.bytes_friend.get().toStringUtf8();
      paramFromServiceMsg.amw = paramToServiceMsg.bytes_wechat.get().toStringUtf8();
      paramFromServiceMsg.amy = paramToServiceMsg.bytes_qzhone.get().toStringUtf8();
    }
    for (;;)
    {
      paramToServiceMsg = (lhu.a)a(Integer.valueOf(i));
      if (paramToServiceMsg != null) {
        paramToServiceMsg.a(bool, j, paramFromServiceMsg);
      }
      QLog.d("Q.readinjoy.fast_web", 2, "handle ad7rsp , succ " + bool + ", retCode : " + k + ", seq : " + i + ", cost : " + (l1 - l2) + "\n" + paramFromServiceMsg);
      return;
      bool = false;
    }
  }
  
  private void af(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("bd3Seq")).intValue();
    long l = System.currentTimeMillis() - ((Long)paramToServiceMsg.getAttribute("bd3ReqTime")).longValue();
    int j = ((Integer)paramToServiceMsg.getAttribute("bd3ShareType")).intValue();
    oidb_cmd0xbd3.RspBody localRspBody = new oidb_cmd0xbd3.RspBody();
    int k = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = (nrl.a)a(Integer.valueOf(i));
    paramToServiceMsg = "";
    if ((k == 0) && (localRspBody.rpt_share_info.has()) && (localRspBody.rpt_share_info.get() != null) && (localRspBody.rpt_share_info.get().size() > 0))
    {
      paramToServiceMsg = (oidb_cmd0xbd3.ShareInfo)localRspBody.rpt_share_info.get().get(0);
      if (paramToServiceMsg.bytes_share_json.has()) {
        paramToServiceMsg = paramToServiceMsg.bytes_share_json.get().toStringUtf8();
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (paramFromServiceMsg != null) {
        ThreadManager.getUIHandler().post(new FastWebModule.2(this, paramFromServiceMsg, bool, j, paramToServiceMsg));
      }
      QLog.d(TAG, 1, new Object[] { "handle0xbd3Resp, retCode = ", Integer.valueOf(k), ", success= ", Boolean.valueOf(bool), ", cost = ", Long.valueOf(l), ", shareJson = ", paramToServiceMsg });
      kxm.a(kxm.getAppRuntime(), bool, l, k);
      return;
      paramToServiceMsg = "";
      break;
    }
  }
  
  private Object b(Integer paramInteger)
  {
    return this.bf.get(paramInteger);
  }
  
  private long t(int paramInt)
  {
    int i = aroc.getNetType(null);
    Object localObject = awit.j(kxm.getAppRuntime());
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return 1000L;
      localObject = ((String)localObject).split(",");
    } while (localObject.length != 5);
    if (paramInt == 3) {
      return Long.valueOf(localObject[4]).longValue();
    }
    switch (i)
    {
    default: 
      return 1000L;
    case 1: 
      return Long.valueOf(localObject[0]).longValue();
    case 2: 
      return Long.valueOf(localObject[1]).longValue();
    case 3: 
      return Long.valueOf(localObject[2]).longValue();
    }
    return Long.valueOf(localObject[3]).longValue();
  }
  
  public List<BaseData> C(String paramString)
  {
    return nnn.ab((List)this.b.get(paramString));
  }
  
  public void N(Object paramObject)
  {
    if (paramObject == null) {}
    label81:
    label82:
    for (;;)
    {
      return;
      Object localObject = this.bf.entrySet();
      Integer localInteger = null;
      localObject = ((Set)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (localEntry.getValue() != paramObject) {
          break label81;
        }
        localInteger = (Integer)localEntry.getKey();
      }
      for (;;)
      {
        break;
        if (localInteger == null) {
          break label82;
        }
        this.bf.remove(localInteger);
        return;
      }
    }
  }
  
  public int a(String paramString1, String paramString2, String paramString3, int paramInt, lhu.b paramb)
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        QLog.d("Q.readinjoy.fast_web", 1, "getArticleContent, rowkey : " + paramString2 + ", url : " + paramString1 + " callback: " + paramb + ", reqType : " + paramInt);
        if ((paramInt != 2) && (paramString2 != null))
        {
          localObject1 = (lhu.c)this.bm.get(paramString2);
          if (localObject1 != null)
          {
            if (!((lhu.c)localObject1).Cl()) {
              continue;
            }
            this.bm.remove(paramString2);
          }
        }
        localObject1 = new oidb_cmd0xad6.ReqBody();
        Object localObject2 = new oidb_cmd0xad6.Client();
        ((oidb_cmd0xad6.Client)localObject2).bytes_version.set(ByteStringMicro.copyFromUtf8("3.4.4"));
        ((oidb_cmd0xad6.Client)localObject2).uint32_type.set(1);
        ((oidb_cmd0xad6.ReqBody)localObject1).msg_client.set((MessageMicro)localObject2);
        localObject2 = new oidb_cmd0xad6.ReqArticle();
        if (paramString2 != null) {
          ((oidb_cmd0xad6.ReqArticle)localObject2).bytes_row_key.set(ByteStringMicro.copyFromUtf8(paramString2));
        }
        if (!TextUtils.isEmpty(paramString1)) {
          ((oidb_cmd0xad6.ReqArticle)localObject2).bytes_url.set(ByteStringMicro.copyFromUtf8(paramString1));
        }
        ((oidb_cmd0xad6.ReqArticle)localObject2).uint32_zip.set(1);
        if (!TextUtils.isEmpty(paramString3)) {
          ((oidb_cmd0xad6.ReqArticle)localObject2).uint64_public_uin.set(Long.valueOf(paramString3).longValue());
        }
        ((oidb_cmd0xad6.ReqArticle)localObject2).uint64_prev_version.set(0L);
        ((oidb_cmd0xad6.ReqBody)localObject1).msg_req_article.set((MessageMicro)localObject2);
        if (paramInt == 1)
        {
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_article.set(1);
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_comment.set(1);
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_read_count.set(1);
          paramString3 = lup.makeOIDBPkg("OidbSvc.0xad6", 2774, 0, ((oidb_cmd0xad6.ReqBody)localObject1).toByteArray());
          int i = this.R.incrementAndGet();
          long l = t(paramInt);
          paramString3.addAttribute("ad6Seq", Integer.valueOf(i));
          paramString3.addAttribute("ad6ReqTime", Long.valueOf(System.currentTimeMillis()));
          paramString3.addAttribute("uniflag", paramString2);
          paramString3.addAttribute("reqType", Integer.valueOf(paramInt));
          paramString3.setTimeout(l);
          a(Integer.valueOf(i), paramb);
          QLog.d("Q.readinjoy.fast_web", 2, "send get content req , seq : " + i + ", rowkey : " + paramString2 + ", oriUrl : " + paramString1 + ", reqType : " + paramInt + ", timeout : " + l);
          sendPbReq(paramString3);
          return i;
          if (paramb != null)
          {
            paramb.a(true, ((lhu.c)localObject1).akp, (FastWebArticleInfo)((lhu.c)localObject1).get());
            kbp.a(null, "CliOper", "", "", "0X8009C51", "0X8009C51", 0, 0, "", "", "", "", false);
          }
          QLog.d("Q.readinjoy.fast_web", 2, "hit cache, rowkey : " + paramString2 + ", url : " + paramString1 + " isUserWeb " + ((lhu.c)localObject1).akp);
          return -1;
        }
        if (paramInt == 3)
        {
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_article.set(1);
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_comment.set(0);
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_read_count.set(0);
          continue;
        }
        if (paramInt != 2) {
          continue;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        QLog.d("Q.readinjoy.fast_web", 2, "send ad6 req error " + paramString1);
        if (paramb != null) {
          paramb.a(false, true, null);
        }
        return -1;
      }
      ((oidb_cmd0xad6.ReqBody)localObject1).uint32_article.set(0);
      ((oidb_cmd0xad6.ReqBody)localObject1).uint32_comment.set(1);
      ((oidb_cmd0xad6.ReqBody)localObject1).uint32_read_count.set(1);
    }
  }
  
  public Parcelable a(String paramString)
  {
    paramString = (lhu.c)this.dS.get(paramString);
    if ((paramString == null) || (paramString.Cl())) {
      return null;
    }
    return (Parcelable)paramString.get();
  }
  
  public FastWebArticleInfo a(String paramString)
  {
    paramString = (lhu.c)this.bm.get(paramString);
    if (paramString != null) {
      return (FastWebArticleInfo)paramString.get();
    }
    return null;
  }
  
  public void a(@NonNull ArticleInfo paramArticleInfo, int paramInt, nrl.a parama)
  {
    oidb_cmd0xbd3.ReqBody localReqBody = new oidb_cmd0xbd3.ReqBody();
    oidb_cmd0xbd3.FeedParam localFeedParam = new oidb_cmd0xbd3.FeedParam();
    localFeedParam.feed_type.set(paramArticleInfo.mFeedType);
    localFeedParam.uint64_feed_id.set(paramArticleInfo.mFeedId);
    PBBytesField localPBBytesField = localFeedParam.bytes_subscribe_name;
    Object localObject;
    if (TextUtils.isEmpty(paramArticleInfo.mSubscribeName)) {
      localObject = "";
    }
    for (;;)
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localFeedParam.multi_level_info.set(paramArticleInfo.mSocialFeedInfo.a.a());
      localFeedParam.uint64_uin.set(paramArticleInfo.publishUin);
      localFeedParam.uint32_share_type.set(paramInt);
      try
      {
        if ((paramArticleInfo.mSocialFeedInfo.br != null) && (paramArticleInfo.mSocialFeedInfo.br.length > 0)) {
          localFeedParam.feed_ext_info.mergeFrom(paramArticleInfo.mSocialFeedInfo.br);
        }
        localObject = new ArrayList();
        ((List)localObject).add(localFeedParam);
        QLog.d(TAG, 2, new Object[] { "req0xbd3ShareJson, feed_type = ", Integer.valueOf(localFeedParam.feed_type.get()), "\n", "feed_id = ", Long.valueOf(localFeedParam.uint64_feed_id.get()), "\n", "subscribe_name = ", localFeedParam.bytes_subscribe_name.get().toStringUtf8(), "\n", "uin = ", Long.valueOf(localFeedParam.uint64_uin.get()), "\n", "share_type = ", Integer.valueOf(localFeedParam.uint32_share_type.get()) });
        localReqBody.rpt_feed_param.set((List)localObject);
        localObject = lup.makeOIDBPkg("OidbSvc.0xbd3", 3027, 0, localReqBody.toByteArray());
        int i = this.R.incrementAndGet();
        ((ToServiceMsg)localObject).addAttribute("bd3Seq", Integer.valueOf(i));
        ((ToServiceMsg)localObject).addAttribute("bd3ReqTime", Long.valueOf(System.currentTimeMillis()));
        ((ToServiceMsg)localObject).addAttribute("bd3ShareType", Integer.valueOf(paramInt));
        a(Integer.valueOf(i), parama);
        sendPbReq((ToServiceMsg)localObject);
        QLog.d(TAG, 1, new Object[] { "req0xbd3ShareJson, articleInfo = ", paramArticleInfo, ", seq = ", Integer.valueOf(i), ", shareType = ", Integer.valueOf(paramInt) });
        return;
        localObject = paramArticleInfo.mSubscribeName;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          QLog.d(TAG, 2, "req0xbd3ShareJson feed_ext_info exception");
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
      }
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, lhu.a parama, boolean paramBoolean)
  {
    Object localObject1 = new oidb_cmd0xb54.ReqBody();
    Object localObject2 = new oidb_cmd0xb54.Client();
    ((oidb_cmd0xb54.Client)localObject2).bytes_version.set(ByteStringMicro.copyFromUtf8("3.4.4"));
    ((oidb_cmd0xb54.Client)localObject2).uint32_type.set(1);
    ((oidb_cmd0xb54.ReqBody)localObject1).msg_client.set((MessageMicro)localObject2);
    localObject2 = new oidb_cmd0xb54.ReqOption();
    ((oidb_cmd0xb54.ReqOption)localObject2).uint32_need_fusion_biu_info.set(1);
    ((oidb_cmd0xb54.ReqOption)localObject2).uint32_like_count.set(1);
    ((oidb_cmd0xb54.ReqOption)localObject2).uint32_is_like.set(1);
    if (awit.s(this.mApp) != 1) {
      ((oidb_cmd0xb54.ReqOption)localObject2).uint32_biu_count.set(1);
    }
    ((oidb_cmd0xb54.ReqOption)localObject2).uint32_related_search_size.set(6);
    if (paramBoolean) {
      ((oidb_cmd0xb54.ReqOption)localObject2).uint32_article_business.set(1);
    }
    ((oidb_cmd0xb54.ReqOption)localObject2).uint32_need_proteus_json_data.set(1);
    oidb_cmd0xb54.ReqArticle localReqArticle = new oidb_cmd0xb54.ReqArticle();
    localReqArticle.bytes_row_key.set(ByteStringMicro.copyFromUtf8(paramArticleInfo.innerUniqueID));
    Object localObject3 = (lhu.c)this.bm.get(paramArticleInfo.innerUniqueID);
    if (localObject3 != null)
    {
      localObject3 = (FastWebArticleInfo)((lhu.c)localObject3).get();
      if ((localObject3 != null) && (!((FastWebArticleInfo)localObject3).bj().isEmpty()))
      {
        ((oidb_cmd0xb54.ReqOption)localObject2).uint32_style_card.set(1);
        localObject3 = ((FastWebArticleInfo)localObject3).bj().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          localReqArticle.rpt_bytes_style_card_id.add(ByteStringMicro.copyFromUtf8(str));
        }
      }
    }
    ((oidb_cmd0xb54.ReqBody)localObject1).msg_option.set((MessageMicro)localObject2);
    ((oidb_cmd0xb54.ReqBody)localObject1).msg_req_article.set(localReqArticle);
    ((oidb_cmd0xb54.ReqBody)localObject1).uint32_topic.set(1);
    localObject1 = lup.makeOIDBPkg("OidbSvc.0xb54", 2900, 0, ((oidb_cmd0xb54.ReqBody)localObject1).toByteArray());
    int i = this.R.incrementAndGet();
    ((ToServiceMsg)localObject1).addAttribute("b54Seq", Integer.valueOf(i));
    ((ToServiceMsg)localObject1).addAttribute("b54ReqTime", Long.valueOf(System.currentTimeMillis()));
    ((ToServiceMsg)localObject1).addAttribute("uniflag", paramArticleInfo.innerUniqueID);
    ((ToServiceMsg)localObject1).addAttribute("rowkey", paramArticleInfo.innerUniqueID);
    ((ToServiceMsg)localObject1).addAttribute("fetchBusiness", Boolean.valueOf(paramBoolean));
    a(Integer.valueOf(i), parama);
    sendPbReq((ToServiceMsg)localObject1);
    QLog.d("Q.readinjoy.fast_web", 2, "req article topic info , rowkey : " + paramArticleInfo.innerUniqueID + ", seq : " + i);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, lhu.a parama)
  {
    oidb_cmd0xad7.ReqBody localReqBody = new oidb_cmd0xad7.ReqBody();
    Object localObject = new oidb_cmd0xad7.Client();
    ((oidb_cmd0xad7.Client)localObject).bytes_version.set(ByteStringMicro.copyFromUtf8("3.4.4"));
    ((oidb_cmd0xad7.Client)localObject).uint32_type.set(1);
    localReqBody.msg_client.set((MessageMicro)localObject);
    localObject = new oidb_cmd0xad7.ReqArticle();
    ((oidb_cmd0xad7.ReqArticle)localObject).bytes_article_id.set(ByteStringMicro.copyFromUtf8(paramString2));
    ((oidb_cmd0xad7.ReqArticle)localObject).bytes_url.set(ByteStringMicro.copyFromUtf8(paramString1));
    try
    {
      ((oidb_cmd0xad7.ReqArticle)localObject).uint64_public_uin.set(Long.valueOf(paramString3).longValue());
      ((oidb_cmd0xad7.ReqArticle)localObject).uint32_prev_version.set(0);
      localReqBody.msg_req_article.set((MessageMicro)localObject);
      if (paramInt == 72)
      {
        localReqBody.uint32_friend.set(1);
        paramString3 = lup.makeOIDBPkg("OidbSvc.0xad7", 2775, 0, localReqBody.toByteArray());
        int i = this.R.incrementAndGet();
        paramString3.addAttribute("ad7Seq", Integer.valueOf(i));
        paramString3.addAttribute("ad7ReqTime", Long.valueOf(System.currentTimeMillis()));
        paramString3.addAttribute("ad7Action", Integer.valueOf(paramInt));
        a(Integer.valueOf(i), parama);
        sendPbReq(paramString3);
        QLog.d("Q.readinjoy.fast_web", 2, "get share Json  articleID : " + paramString2 + ", oriUrl : " + paramString1 + ", seq : " + i + ", action : " + paramInt);
        return;
      }
    }
    catch (NumberFormatException paramString3)
    {
      for (;;)
      {
        paramString3.printStackTrace();
        continue;
        if (paramInt == 73) {
          localReqBody.uint32_friend.set(1);
        } else if (paramInt == 2) {
          localReqBody.uint32_friend.set(1);
        } else if (paramInt == 3) {
          localReqBody.uint32_qzhone.set(1);
        } else if (paramInt == 12) {
          localReqBody.uint32_weibo.set(1);
        } else if (paramInt == 9) {
          localReqBody.uint32_wechat.set(1);
        } else if (paramInt == 10) {
          localReqBody.uint32_wechat_pyq.set(1);
        }
      }
    }
  }
  
  public void aEL()
  {
    this.bf.clear();
  }
  
  public void ag(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("b54Seq")).intValue();
    Object localObject3 = (String)paramToServiceMsg.getAttribute("uniflag");
    System.currentTimeMillis();
    ((Long)paramToServiceMsg.getAttribute("b54ReqTime")).longValue();
    Object localObject1 = (String)paramToServiceMsg.getAttribute("rowkey");
    Object localObject2 = new oidb_cmd0xb54.RspBody();
    int j = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject2);
    paramFromServiceMsg = (lhu.a)b(Integer.valueOf(i));
    paramObject = (lhu.c)this.bm.get(localObject3);
    if (paramObject == null) {
      return;
    }
    paramObject = (FastWebArticleInfo)paramObject.get();
    if (j == 0)
    {
      if ((!((oidb_cmd0xb54.RspBody)localObject2).msg_rsp_topic.has()) || (((oidb_cmd0xb54.RspBody)localObject2).msg_rsp_biu_count.has()))
      {
        paramObject.xL = ((oidb_cmd0xb54.RspBiuCount)((oidb_cmd0xb54.RspBody)localObject2).msg_rsp_biu_count.get()).uint64_biu_count.get();
        QLog.d(TAG, 2, "0xb54 resp biu count is : " + paramObject.xL);
        if (paramFromServiceMsg != null) {
          paramFromServiceMsg.B(paramObject.xL, (String)localObject1);
        }
      }
      if (((oidb_cmd0xb54.RspBody)localObject2).uint32_like_count.has())
      {
        paramObject.likeCnt = ((oidb_cmd0xb54.RspBody)localObject2).uint32_like_count.get();
        if (paramFromServiceMsg != null) {
          paramFromServiceMsg.au(paramObject.likeCnt, (String)localObject1);
        }
        QLog.d(TAG, 2, "0xb54 resp like count is : " + paramObject.likeCnt);
      }
      Object localObject5;
      if (((oidb_cmd0xb54.RspBody)localObject2).rpt_msg_style_card.has())
      {
        localObject3 = ((oidb_cmd0xb54.RspBody)localObject2).rpt_msg_style_card.get().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject5 = (oidb_cmd0xb54.StyleCard)((Iterator)localObject3).next();
          try
          {
            if ((((oidb_cmd0xb54.StyleCard)localObject5).bytes_sourceid.has()) && (((oidb_cmd0xb54.StyleCard)localObject5).bytes_style.has()))
            {
              String str1 = ((oidb_cmd0xb54.StyleCard)localObject5).bytes_sourceid.get().toStringUtf8();
              localObject5 = ((oidb_cmd0xb54.StyleCard)localObject5).bytes_style.get().toStringUtf8();
              QLog.d(TAG, 2, "0xb54 resp bytes_sourceid : " + str1 + " json " + (String)localObject5);
              paramObject.l(str1, new JSONObject((String)localObject5));
            }
          }
          catch (JSONException localJSONException)
          {
            QLog.d(TAG, 1, localJSONException, new Object[] { "0xb54 rpt_msg_style_card " });
          }
        }
        if (paramFromServiceMsg != null) {
          paramFromServiceMsg.nm(paramObject.rowKey);
        }
      }
      if (((oidb_cmd0xb54.RspBody)localObject2).uint32_is_like.has()) {
        if (((oidb_cmd0xb54.RspBody)localObject2).uint32_is_like.get() != 1) {
          break label897;
        }
      }
      label897:
      for (boolean bool = true;; bool = false)
      {
        paramObject.isLiked = bool;
        if (paramFromServiceMsg != null) {
          paramFromServiceMsg.u(paramObject.isLiked, (String)localObject1);
        }
        QLog.d(TAG, 2, "0xb54 resp isLiked : " + ((oidb_cmd0xb54.RspBody)localObject2).uint32_is_like.get());
        if (((oidb_cmd0xb54.RspBody)localObject2).bytes_proteus_json_data.has())
        {
          localObject3 = ((oidb_cmd0xb54.RspBody)localObject2).bytes_proteus_json_data.get().toStringUtf8();
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            paramObject.aA.clear();
            nmx.a((String)localObject3, paramObject.aA);
          }
        }
        if ((!((oidb_cmd0xb54.RspBody)localObject2).rpt_related_search_word.has()) || (((oidb_cmd0xb54.RspBody)localObject2).rpt_related_search_word.get() == null)) {
          break label1273;
        }
        Object localObject4 = ((oidb_cmd0xb54.RspBody)localObject2).rpt_related_search_word.get();
        localObject3 = new RelatedSearchData(paramObject);
        paramObject.a = ((RelatedSearchData)localObject3);
        QLog.d(TAG, 1, new Object[] { "0xb54 related search words size = ", Integer.valueOf(((List)localObject4).size()) });
        localObject4 = ((List)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject6 = (oidb_cmd0xb54.RelatedSearchWord)((Iterator)localObject4).next();
          if ((((oidb_cmd0xb54.RelatedSearchWord)localObject6).bytes_word.has()) && (((oidb_cmd0xb54.RelatedSearchWord)localObject6).str_jmp_url.has()))
          {
            localObject5 = ((oidb_cmd0xb54.RelatedSearchWord)localObject6).bytes_word.get().toStringUtf8();
            String str2 = ((oidb_cmd0xb54.RelatedSearchWord)localObject6).str_jmp_url.get();
            float f = ((oidb_cmd0xb54.RelatedSearchWord)localObject6).float_score.get();
            String str3 = ((oidb_cmd0xb54.RelatedSearchWord)localObject6).str_modle_name.get();
            i = ((oidb_cmd0xb54.RelatedSearchWord)localObject6).uint32_modle_id.get();
            if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty(str2)))
            {
              localObject6 = new RelatedSearchData.a();
              ((RelatedSearchData.a)localObject6).word = ((String)localObject5);
              ((RelatedSearchData.a)localObject6).jumpUrl = str2;
              ((RelatedSearchData.a)localObject6).score = f;
              ((RelatedSearchData.a)localObject6).modelName = str3;
              ((RelatedSearchData.a)localObject6).bah = i;
              if (((RelatedSearchData)localObject3).kl.size() < 6) {
                ((RelatedSearchData)localObject3).kl.add(localObject6);
              }
            }
            QLog.d(TAG, 2, new Object[] { "relatedSearch word = ", localObject5, ", jumpUrl = ", str2 });
          }
        }
      }
      if ((((oidb_cmd0xb54.RspBody)localObject2).bytes_search_word_sid.has()) && (((oidb_cmd0xb54.RspBody)localObject2).bytes_search_word_sid.get() != null)) {
        if (paramObject.a != null)
        {
          paramObject.a.sid = ((oidb_cmd0xb54.RspBody)localObject2).bytes_search_word_sid.get().toStringUtf8();
          if ((paramObject.a.kl.size() > 0) && (paramFromServiceMsg != null)) {
            paramFromServiceMsg.a(paramObject, (String)localObject1);
          }
          label976:
          if (((Boolean)paramToServiceMsg.getAttribute("fetchBusiness", Boolean.valueOf(false))).booleanValue())
          {
            if ((!((oidb_cmd0xb54.RspBody)localObject2).msg_article_business.has()) || (((oidb_cmd0xb54.RspBody)localObject2).msg_article_business.get() == null)) {
              break label1286;
            }
            localObject1 = (oidb_cmd0xb54.ArticleBusiness)((oidb_cmd0xb54.RspBody)localObject2).msg_article_business.get();
            i = ((oidb_cmd0xb54.ArticleBusiness)localObject1).uint32_business_cash_flag.get();
            if ((!((oidb_cmd0xb54.ArticleBusiness)localObject1).bytes_business_cash_info.has()) || (((oidb_cmd0xb54.ArticleBusiness)localObject1).bytes_business_cash_info.get() == null)) {
              break label1341;
            }
          }
        }
      }
    }
    label1286:
    label1341:
    for (paramToServiceMsg = ((oidb_cmd0xb54.ArticleBusiness)localObject1).bytes_business_cash_info.get().toStringUtf8();; paramToServiceMsg = "")
    {
      if ((((oidb_cmd0xb54.ArticleBusiness)localObject1).msg_sentiment_entity_data.has()) && (((oidb_cmd0xb54.ArticleBusiness)localObject1).msg_sentiment_entity_data.get() != null))
      {
        localObject2 = (oidb_cmd0xb54.SentimentEntityData)((oidb_cmd0xb54.ArticleBusiness)localObject1).msg_sentiment_entity_data.get();
        if ((((oidb_cmd0xb54.SentimentEntityData)localObject2).bytes_data.has()) && (((oidb_cmd0xb54.SentimentEntityData)localObject2).bytes_data.get() != null)) {
          paramObject.amj = ((oidb_cmd0xb54.SentimentEntityData)localObject2).bytes_data.get().toStringUtf8();
        }
      }
      if ((((oidb_cmd0xb54.ArticleBusiness)localObject1).msg_union_nlp_info.has()) && (((oidb_cmd0xb54.ArticleBusiness)localObject1).msg_union_nlp_info.get() != null))
      {
        localObject1 = (oidb_cmd0xb54.UnionNlpInfo)((oidb_cmd0xb54.ArticleBusiness)localObject1).msg_union_nlp_info.get();
        if ((((oidb_cmd0xb54.UnionNlpInfo)localObject1).bytes_union_chann.has()) && (((oidb_cmd0xb54.UnionNlpInfo)localObject1).bytes_union_chann.get() != null)) {
          paramObject.amk = ((oidb_cmd0xb54.UnionNlpInfo)localObject1).bytes_union_chann.get().toStringUtf8();
        }
      }
      if (paramFromServiceMsg != null) {
        paramFromServiceMsg.a(paramObject, i, paramToServiceMsg);
      }
      for (;;)
      {
        ThreadManager.getUIHandler().post(new FastWebModule.5(this));
        return;
        QLog.d(TAG, 1, "0xb54 related search word, fastWebInfo.mRelatedSearchData is null.");
        break;
        QLog.d(TAG, 1, "0xb54 related search word sid is null");
        break;
        label1273:
        QLog.d(TAG, 1, "0xb54 related search words is null");
        break label976;
        if (paramFromServiceMsg != null) {
          paramFromServiceMsg.a(paramObject, 0, "");
        }
        QLog.d(TAG, 1, "0xb54 article business is null");
        continue;
        QLog.d("Q.readinjoy.fast_web", 2, "oxb54 resp error, code : " + j);
      }
    }
  }
  
  public void b(String paramString, Parcelable paramParcelable)
  {
    lhu.c localc = (lhu.c)this.dS.get(paramString);
    if (localc == null)
    {
      paramParcelable = new lhu.c(paramParcelable);
      this.dS.put(paramString, paramParcelable);
      return;
    }
    localc.update(paramParcelable);
  }
  
  public void bQ(List<ArticleInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.mExecutorService.execute(new FastWebModule.3(this, paramList));
  }
  
  public void h(String paramString, List<BaseData> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null)) {
      return;
    }
    this.b.put(paramString, paramList);
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xad6")) {
      ad(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xad7"))
      {
        ae(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xb54"))
      {
        ag(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbd3"));
    af(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void rm(int paramInt)
  {
    if (this.bf != null) {
      this.bf.remove(Integer.valueOf(paramInt));
    }
  }
  
  public static class a
  {
    public void B(long paramLong, String paramString) {}
    
    public void a(FastWebArticleInfo paramFastWebArticleInfo, int paramInt, String paramString) {}
    
    public void a(FastWebArticleInfo paramFastWebArticleInfo, String paramString) {}
    
    public void a(boolean paramBoolean, int paramInt, nnf paramnnf) {}
    
    public void au(int paramInt, String paramString) {}
    
    public void nm(String paramString) {}
    
    public void u(boolean paramBoolean, String paramString) {}
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, FastWebArticleInfo paramFastWebArticleInfo);
  }
  
  public class c<T>
  {
    T aK;
    public boolean akp;
    private long lastUpdateTime;
    private long ut;
    
    public c()
    {
      this(localObject, 600000L);
      if (localObject == null) {
        this.akp = true;
      }
    }
    
    public c(long paramLong)
    {
      this.aK = paramLong;
      this.lastUpdateTime = System.currentTimeMillis();
      Object localObject;
      this.ut = localObject;
    }
    
    public boolean Cl()
    {
      return System.currentTimeMillis() - this.lastUpdateTime >= this.ut;
    }
    
    public T get()
    {
      return this.aK;
    }
    
    public void update(T paramT)
    {
      this.aK = paramT;
      this.lastUpdateTime = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lhu
 * JD-Core Version:    0.7.0.1
 */