import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.a;
import com.tencent.biz.pubaccount.readinjoy.engine.MonitorTimeExecutor;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyEntityManagerFactory;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine.1;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine.2;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine.5;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine.6;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine.7;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine.8;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.LebaKDCellInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VisibleSetParam;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqAdvertisePara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;

public class lbz
{
  private static AtomicInteger P;
  private static lbz jdField_c_of_type_Lbz;
  private static HashMap<Integer, Long> dD = new HashMap();
  private static long tu;
  private int Sf;
  private ReadInJoyUserInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule;
  private SelectPositionModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule;
  private lbg jdField_a_of_type_Lbg;
  private lbk jdField_a_of_type_Lbk;
  private lby jdField_a_of_type_Lby;
  private lhb jdField_a_of_type_Lhb;
  private lhi jdField_a_of_type_Lhi;
  private lhk jdField_a_of_type_Lhk;
  private lhn jdField_a_of_type_Lhn;
  private lho jdField_a_of_type_Lho;
  private lht jdField_a_of_type_Lht;
  private lhu jdField_a_of_type_Lhu;
  private lhx jdField_a_of_type_Lhx;
  private lhy jdField_a_of_type_Lhy;
  private lic jdField_a_of_type_Lic;
  private lif jdField_a_of_type_Lif;
  private lig jdField_a_of_type_Lig;
  private lii jdField_a_of_type_Lii;
  private lij jdField_a_of_type_Lij;
  private lil jdField_a_of_type_Lil;
  private liu jdField_a_of_type_Liu;
  private liw jdField_a_of_type_Liw;
  private liz jdField_a_of_type_Liz;
  private ljc jdField_a_of_type_Ljc;
  private ljd jdField_a_of_type_Ljd;
  private ljz jdField_a_of_type_Ljz;
  private lun jdField_a_of_type_Lun;
  private final int aMZ = -1;
  private final int aNa = 1;
  private final int aNb = 0;
  private int aNc = -1;
  private int aNd;
  private kqe jdField_b_of_type_Kqe;
  private kut jdField_b_of_type_Kut;
  private lhf jdField_b_of_type_Lhf;
  private liq jdField_b_of_type_Liq;
  private ConcurrentHashMap<String, Parcelable> bd = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> be = new ConcurrentHashMap();
  private EntityManagerFactory jdField_c_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private String mAccount = "";
  private AppInterface mApp;
  private ExecutorService mExecutorService;
  private boolean mInitialized;
  private Handler mMainThreadHandler;
  
  public static lbz a()
  {
    try
    {
      if (jdField_c_of_type_Lbz == null)
      {
        jdField_c_of_type_Lbz = new lbz();
        P = new AtomicInteger(0);
      }
      lbz locallbz = jdField_c_of_type_Lbz;
      return locallbz;
    }
    finally {}
  }
  
  public static void aJt()
  {
    tu = NetConnInfoCenter.getServerTimeMillis();
  }
  
  private void bW(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return;
      paramContext = (LocationManager)paramContext.getSystemService("location");
    } while (paramContext == null);
    try
    {
      bool = paramContext.isProviderEnabled("gps");
      if (QLog.isColorLevel()) {
        QLog.i("LBS", 2, "GPS Open " + bool);
      }
      if (bool)
      {
        this.aNc = 1;
        return;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        boolean bool = false;
      }
      this.aNc = 0;
    }
  }
  
  public static void k(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = kxm.getLongAccountUin();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramArticleInfo.mArticleID;
    localReportInfo.mChannelId = ((int)paramArticleInfo.mChannelID);
    localReportInfo.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
    localReportInfo.mStrategyId = paramArticleInfo.mStrategyId;
    localReportInfo.mOperation = 30;
    if (paramArticleInfo.mChannelID == 70L) {
      localReportInfo.mOpSource = 13;
    }
    for (;;)
    {
      localReportInfo.mChannelId = ((int)paramArticleInfo.mChannelID);
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        ReportInfo.a locala = new ReportInfo.a();
        locala.vd = paramArticleInfo.mSocialFeedInfo.mFeedId;
        if (paramArticleInfo.mSocialFeedInfo.a != null) {
          locala.vg = paramArticleInfo.mSocialFeedInfo.a.uin;
        }
        locala.aSx = paramArticleInfo.mSocialFeedInfo.mLikeCount;
        locala.aSy = paramArticleInfo.mSocialFeedInfo.mCommentCount;
        localReportInfo.mFeedsReportData = locala;
      }
      localArrayList.add(localReportInfo);
      a().cb(localArrayList);
      return;
      if (paramArticleInfo.mChannelID == 56L) {
        localReportInfo.mOpSource = 11;
      } else {
        localReportInfo.mOpSource = 0;
      }
    }
  }
  
  private void qn(int paramInt)
  {
    QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "onLoadMoreArticleFalse, channelID = ", Integer.valueOf(paramInt) });
    if (this.mMainThreadHandler != null) {
      this.mMainThreadHandler.post(new ReadInJoyLogicEngine.2(this, paramInt));
    }
  }
  
  public boolean A(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "isArticleFromRecommendFeeds | mArticleInfoModule is null!");
      return false;
    }
    return this.jdField_b_of_type_Lhf.A(paramArticleInfo);
  }
  
  public JSONObject C()
  {
    if (this.jdField_a_of_type_Lht != null) {
      return this.jdField_a_of_type_Lht.D();
    }
    return null;
  }
  
  public void H(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Lhi == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleReadInfo mArticleReadInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Lhi.H(paramLong1, paramLong2);
  }
  
  public void M(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Lhb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "setLocalAdvertisementRange mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Lhb.M(paramInt1, paramInt2, paramInt3);
  }
  
  public void N(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Lho == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChildChannelFollowStatus mChannelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Lho.N(paramInt1, paramInt2, paramInt3);
  }
  
  public void U(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lhb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "setChannelNeedRequestAdvertisement mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Lhb.U(paramInt, paramBoolean);
  }
  
  public int a(Integer paramInteger)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRefreshedArticleInfoSize mArticleInfoModule is null!");
      }
      return 0;
    }
    return this.jdField_b_of_type_Lhf.a(paramInteger);
  }
  
  public Parcelable a(int paramInt)
  {
    String str = kxm.getAccount() + "_" + paramInt;
    if (this.bd == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "getLeaveChannelPosInfo mLeavePosCache is null.");
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "getPosInfo, key: ", str, ", state: ", this.bd.get(str) });
    }
    return (Parcelable)this.bd.get(str);
  }
  
  public Pair<Integer, Integer> a(int paramInt)
  {
    if (this.jdField_a_of_type_Lhb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLocalAdvertisementRange mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Lhb.a(paramInt);
  }
  
  public ReadInJoyUserInfoModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule;
  }
  
  public SelectPositionModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule;
  }
  
  public AdvertisementInfo a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Lhb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAdvertisementInfo mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Lhb.a(paramInt1, paramInt2);
  }
  
  public ArticleInfo a(int paramInt, long paramLong)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    if (lgy.aP(paramLong)) {
      return lgy.a().c(paramInt, paramLong);
    }
    return this.jdField_b_of_type_Lhf.a(Integer.valueOf(paramInt), Long.valueOf(paramLong));
  }
  
  public ArticleInfo a(Integer paramInteger)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLastReadArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    return this.jdField_b_of_type_Lhf.b(paramInteger);
  }
  
  public ChannelInfo a(int paramInt)
  {
    if (this.jdField_a_of_type_Lho != null) {
      return this.jdField_a_of_type_Lho.a(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public List<Long> a(Integer paramInteger)
  {
    if (this.jdField_b_of_type_Lhf != null) {
      return this.jdField_b_of_type_Lhf.a(paramInteger);
    }
    return null;
  }
  
  public List<BaseArticleInfo> a(Integer paramInteger, List<Long> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (Long)paramList.next();
      localObject = a(paramInteger.intValue(), ((Long)localObject).longValue());
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    return lih.P(localArrayList);
  }
  
  public kqe a()
  {
    return this.jdField_b_of_type_Kqe;
  }
  
  public kut a()
  {
    return this.jdField_b_of_type_Kut;
  }
  
  public lhb a()
  {
    return this.jdField_a_of_type_Lhb;
  }
  
  public lhf a()
  {
    return this.jdField_b_of_type_Lhf;
  }
  
  public lhk a()
  {
    return this.jdField_a_of_type_Lhk;
  }
  
  public lhu a()
  {
    return this.jdField_a_of_type_Lhu;
  }
  
  public lic a()
  {
    return this.jdField_a_of_type_Lic;
  }
  
  public lii a()
  {
    return this.jdField_a_of_type_Lii;
  }
  
  public lij a()
  {
    return this.jdField_a_of_type_Lij;
  }
  
  public lil a()
  {
    return this.jdField_a_of_type_Lil;
  }
  
  public liq a()
  {
    return this.jdField_b_of_type_Liq;
  }
  
  public ljc a()
  {
    return this.jdField_a_of_type_Ljc;
  }
  
  public ljz a()
  {
    return this.jdField_a_of_type_Ljz;
  }
  
  public oidb_cmd0x68b.ReqAdvertisePara a(luq.b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Lhb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "makeReqAdvertisePara mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Lhb.a(paramb, paramInt1, paramInt2, paramInt3, paramInt4, null);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, jys paramjys)
  {
    if (this.jdField_a_of_type_Lhb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelAdvertisementFormServer mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Lhb.a(paramInt1, paramInt2, paramInt3, paramInt4, paramjys);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelArticleFromDB mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_b_of_type_Lhf.b(paramInt1, paramInt2, paramLong, paramBoolean);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (this.jdField_b_of_type_Lhf != null) {
      this.jdField_b_of_type_Lhf.a(paramInt1, paramInt2, paramLong1, paramBoolean, paramLong2);
    }
  }
  
  public void a(int paramInt, Parcelable paramParcelable)
  {
    if (kys.dv(paramInt)) {
      return;
    }
    String str = kxm.getAccount() + "_" + paramInt;
    if (this.bd == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "updateLeaveChannelPosInfo mLeavePosCache is null.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "updatePosInfo, key: ", str, ", state: ", paramParcelable });
    }
    this.bd.put(str, paramParcelable);
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2)
  {
    if ((paramArticleInfo1 == null) || (paramArticleInfo2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyLogicEngine", 2, "###insertAfterTarget error for null, targetArticleInfo:" + paramArticleInfo1 + "     valueArticleInfo:" + paramArticleInfo2);
      }
      return;
    }
    this.jdField_b_of_type_Lhf.a(true, paramInt, Arrays.asList(new Long[] { Long.valueOf(paramArticleInfo1.mArticleID) }), Arrays.asList(new ArticleInfo[] { paramArticleInfo2 }), false);
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, Boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Lhf != null)
    {
      if (kxm.s(paramBaseArticleInfo))
      {
        Iterator localIterator = paramBaseArticleInfo.mGroupSubArticleList.iterator();
        while (localIterator.hasNext())
        {
          BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localIterator.next();
          this.jdField_b_of_type_Lhf.G(paramInt, localBaseArticleInfo.mRecommendSeq);
        }
      }
      this.jdField_b_of_type_Lhf.G(paramInt, paramBaseArticleInfo.mRecommendSeq);
    }
    while ((this.jdField_a_of_type_Lhi != null) && (paramBoolean.booleanValue())) {
      if (kxm.s(paramBaseArticleInfo))
      {
        paramBaseArticleInfo = paramBaseArticleInfo.mGroupSubArticleList.iterator();
        while (paramBaseArticleInfo.hasNext())
        {
          paramBoolean = (BaseArticleInfo)paramBaseArticleInfo.next();
          this.jdField_a_of_type_Lhi.ey(paramBoolean.mArticleID);
        }
        QLog.d("ArticleInfoModule", 2, "ReadinjoyLogicEngine articleInfoModule is null !");
      }
      else
      {
        this.jdField_a_of_type_Lhi.ey(paramBaseArticleInfo.mArticleID);
        return;
      }
    }
    QLog.d("ArticleInfoModule", 2, "ReadinjoyLogicEngine articleReadInfoModule is null !");
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6)
  {
    a(paramInt1, paramList, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramString1, paramLong1, paramString2, paramInt4, paramLong2, paramLong3, paramString3, paramInt5, paramBoolean3, paramLebaKDCellInfo, paramInt6, null);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6, List<KandianMergeManager.a> paramList1)
  {
    a(paramInt1, paramList, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramString1, paramLong1, paramString2, paramInt4, paramLong2, paramLong3, paramString3, paramInt5, paramBoolean3, paramLebaKDCellInfo, paramInt6, paramList1, null, null);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6, List<KandianMergeManager.a> paramList1, List<luq.a> paramList2, Bundle paramBundle)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelArticlesFormServer mArticleInfoModule is null!");
      }
      return;
    }
    List localList = this.jdField_b_of_type_Lhf.a(Integer.valueOf(paramInt1));
    long l = this.jdField_b_of_type_Lhf.a(Integer.valueOf(paramInt1));
    luq.b localb = new luq.b();
    localb.channelID = paramInt1;
    localb.uH = -1L;
    localb.ale = true;
    localb.it = localList;
    localb.alf = false;
    localb.iu = paramList;
    localb.aPY = paramInt2;
    localb.alg = true;
    localb.alh = true;
    localb.ali = paramBoolean1;
    localb.bm = this.jdField_b_of_type_Lhf.a(Integer.valueOf(paramInt1));
    localb.alj = paramBoolean2;
    localb.bo = lhf.D();
    localb.aPV = paramInt3;
    localb.innerUniqId = paramString1;
    localb.uJ = paramLong1;
    localb.articleTitle = paramString2;
    localb.channelType = paramInt4;
    localb.algorithmId = paramLong2;
    localb.tn = paramLong3;
    localb.pushContext = paramString3;
    localb.alm = paramBoolean3;
    localb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo = paramLebaKDCellInfo;
    localb.aPZ |= paramInt6;
    localb.iw = paramList2;
    localb.extraData = paramBundle;
    if (knd.dh(paramInt1)) {
      localb.alk = true;
    }
    paramInt2 = paramInt5;
    if (paramInt5 == 1001) {
      paramInt2 = 3;
    }
    localb.reqType = paramInt2;
    if (l == -1L) {}
    for (localb.uI = -1L;; localb.uI = (l + 1L))
    {
      localb.aPX |= 0x10;
      localb.aPX |= 0x20;
      localb.aPX |= 0x100;
      localb.aPX |= 0x40;
      localb.aPX |= 0x400;
      if (paramInt1 == 56) {
        localb.aPX |= 0x1080;
      }
      if (paramInt1 == 0) {
        localb.aPX |= 0x800;
      }
      if ((paramInt1 == 40677) || (paramInt4 == 7)) {
        localb.serviceType = 2;
      }
      if (kys.dv(paramInt1)) {
        localb.serviceType = 3;
      }
      if (paramList1 != null) {
        localb.iv.addAll(paramList1);
      }
      if ((localb.aPZ & 0x100) != 0)
      {
        localb.serviceType = 4;
        QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "feedsPreload, params service type = ", Integer.valueOf(localb.serviceType), ", beginRecommendSeq = ", Long.valueOf(localb.uH), ", endRecommendSeq = ", Long.valueOf(localb.uI) });
      }
      if (!awit.aMG()) {
        localb.aPZ |= 0x200;
      }
      QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "68b params recommendFlag = ", Integer.valueOf(localb.aPZ) });
      if ((paramInt1 == 41695) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null))
      {
        paramLebaKDCellInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a();
        if (paramLebaKDCellInfo != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyLogicEngine", 2, "refreshChannelArticlesFormServer positionData = " + paramLebaKDCellInfo);
          }
          localb.e = new SelectPositionModule.PositionData();
          localb.e.copy(paramLebaKDCellInfo);
        }
      }
      if ((localb.aPZ & 0x1000) != 0)
      {
        localb.jdField_a_of_type_Lwh$b = lwh.a().a();
        lwh.a().aNQ();
      }
      this.jdField_b_of_type_Lhf.b(localb);
      paramLebaKDCellInfo = new StringBuilder("SelectedKandianArticleIds : ");
      if (paramList == null) {
        break;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramList1 = (Long)paramList.next();
        paramLebaKDCellInfo.append(paramList1 + " , ");
      }
    }
    QLog.i("ArticleInfoModule", 1, "refreshChannelArticlesFormServer kandianArticleID : " + paramLebaKDCellInfo.toString() + " innerUniqId is : " + paramString1 + " subscribeArticleID is : " + paramLong1 + " subscribeArticleTitle : " + kxm.ev(paramString2) + " recommendFlag is : " + localb.aPZ + " pushContext：" + paramString3 + " channelID : " + paramInt1);
  }
  
  public void a(long paramLong1, long paramLong2, SocializeFeedsInfo.c paramc, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo)
  {
    a(paramLong1, paramLong2, paramc, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramArticleInfo, false);
  }
  
  public void a(long paramLong1, long paramLong2, SocializeFeedsInfo.c paramc, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_Lhf == null) || (paramc == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestMultiBiu mArticleInfoModule is null!");
      }
      return;
    }
    if (paramLong4 == -1L) {
      paramLong4 = 0L;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramString2)) && (paramInt1 == 17))
      {
        this.jdField_b_of_type_Lhf.b(paramLong1, paramString2, paramInt1, paramString1, null, paramBoolean);
        return;
      }
      this.jdField_b_of_type_Lhf.b(paramLong1, paramLong2, paramc, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramArticleInfo, paramBoolean);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, SocializeFeedsInfo.c paramc, String paramString)
  {
    this.jdField_b_of_type_Lhf.b(paramLong1, paramLong2, paramc, paramString);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteAction mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_b_of_type_Lhf.b(paramLong1, paramLong2, paramBoolean, paramArticleInfo);
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.atlas.", 2, "requestAtlasBiu rowKey is null!");
      }
      return;
    }
    this.jdField_b_of_type_Lhf.b(paramLong, paramString1, paramInt, paramString2, paramArrayList, paramBoolean);
  }
  
  public void a(long paramLong, mha parammha)
  {
    if (parammha == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "sendShieldArticle mArticleInfoModule is null!");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(parammha);
    c(paramLong, localArrayList);
  }
  
  public void a(long paramLong, boolean paramBoolean, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteFastWebArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_b_of_type_Lhf.b(paramLong, paramBoolean, paramFastWebArticleInfo);
  }
  
  public void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, long paramLong, ArrayList<DislikeInfo> paramArrayList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lhb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "doUninterestAdvertisement mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Lhb.a(paramContext, paramAdvertisementInfo, paramLong, paramArrayList, paramBoolean);
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestSubmitComment mArticleInfoModule is null!");
      }
      return;
    }
    if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.d("Q.readinjoy.info_module", 2, "requestSubmitComment articleinfo or commentinfo is null!");
      return;
    }
    this.jdField_b_of_type_Lhf.b(paramArticleInfo, paramString);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle)
  {
    if (this.jdField_a_of_type_Lhb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "handleAdvertisementResp mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Lhb.a(paramToServiceMsg, paramRspChannelArticle, 0, 0, true);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, SocializeFeedsInfo.a parama)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUGC mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_b_of_type_Lhf.a(paramString1, null, null, null, paramString2, null, null, null, null, paramArrayList, false, paramInt, 0, parama, 0);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUpMasterVideo mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_b_of_type_Lhf.a(paramString1, paramString2, paramBundle, paramArrayList, paramBoolean1, paramBoolean2, paramTroopBarPOI, paramVisibleSetParam);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, List<Integer> paramList, String paramString4, String[] paramArrayOfString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString2, int paramInt2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam, int paramInt3)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUGC mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_b_of_type_Lhf.a(paramString1, paramString2, paramString3, paramList, paramString4, "", paramArrayOfString1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString2, paramArrayList, paramBoolean, paramInt1, paramInt2, null, paramTroopBarPOI, paramVisibleSetParam, paramInt3);
  }
  
  public void a(ArrayList<ResultRecord> paramArrayList, long paramLong, String paramString)
  {
    if (this.jdField_b_of_type_Lhf != null)
    {
      this.jdField_b_of_type_Lhf.a(paramArrayList, 1, paramLong, paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "shareAQinviteFriends, uin = " + paramLong);
  }
  
  public void a(mih parammih)
  {
    if (this.jdField_a_of_type_Lhx != null) {
      this.jdField_a_of_type_Lhx.a(parammih);
    }
  }
  
  public boolean a(Integer paramInteger, List<ArticleInfo> paramList, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Lhf != null) {
      return this.jdField_b_of_type_Lhf.a(paramInteger, paramList, paramBoolean);
    }
    return false;
  }
  
  public boolean a(mhc parammhc, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadMoreBius mArticleInfoModule is null!");
      }
      return false;
    }
    this.jdField_b_of_type_Lhf.a(parammhc, paramArticleInfo);
    return true;
  }
  
  public List<mgw> aC()
  {
    if (this.jdField_a_of_type_Lhn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverSectionList mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Lhn.aC();
  }
  
  public void aC(String paramString, int paramInt)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpdateSocialFeedInfo mArticleInfoModule is null!");
      }
      return;
    }
    if ("-1".equals(paramString))
    {
      if ((kxm.c != null) && (kxm.c.mFeedId != 0L))
      {
        this.jdField_b_of_type_Lhf.b("" + kxm.c.mFeedId, kxm.c.mFeedType, -1, true);
        kxm.c = null;
        return;
      }
      QLog.w("Q.readinjoy.info_module", 2, " clicked articleInfo  " + kxm.c);
      return;
    }
    this.jdField_b_of_type_Lhf.b(paramString, paramInt, -1, true);
  }
  
  public List<TabChannelCoverInfo> aD()
  {
    if (this.jdField_a_of_type_Lhn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getMyChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Lhn.aH();
  }
  
  public List<mhg> aE()
  {
    if (this.jdField_a_of_type_Lhy == null) {
      return new ArrayList();
    }
    return this.jdField_a_of_type_Lhy.aP();
  }
  
  public void aJA()
  {
    if (this.jdField_a_of_type_Lht != null)
    {
      this.jdField_a_of_type_Lht.aMt();
      return;
    }
    QLog.e("ReadInJoyLogicEngine", 1, "[requestDailyDynamicHeaderData] mDailyDynamicHeaderModule == null");
  }
  
  public void aJg()
  {
    this.aNd = 0;
  }
  
  public void aJh()
  {
    if (this.jdField_a_of_type_Lhi == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Lhi.aJh();
  }
  
  public void aJi()
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelTopCookieList mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_b_of_type_Lhf.aJi();
  }
  
  public void aJj()
  {
    if (this.jdField_a_of_type_Lif == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestGetInterestLabelInfoList mInterestLabelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Lif.aMw();
    this.jdField_a_of_type_Lif.e(1, 1, 1, false);
  }
  
  public void aJk()
  {
    if (this.jdField_a_of_type_Liz == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionFeedList mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Liz.aJk();
  }
  
  public void aJl()
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshKanDianUnReadNum mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_b_of_type_Lhf.aJl();
  }
  
  public void aJm()
  {
    if (this.jdField_a_of_type_Liz == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Liz.aJm();
  }
  
  public void aJn()
  {
    if (this.jdField_b_of_type_Lhf == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_Lhf.Rt();
      if (this.jdField_a_of_type_Liz != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Liz.Rt();
  }
  
  public void aJo()
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
      if (this.jdField_a_of_type_Liz != null) {
        break label80;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Lhb != null) {
        break label90;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mAdvertisementInfoModule is null!");
      }
      return;
      this.jdField_b_of_type_Lhf.aMk();
      break;
      label80:
      this.jdField_a_of_type_Liz.aMk();
    }
    label90:
    this.jdField_a_of_type_Lhb.aMk();
  }
  
  public void aJp()
  {
    if (this.jdField_b_of_type_Lhf == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_Lhf.doOnStart();
      if (this.jdField_a_of_type_Liz != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Liz.doOnStart();
  }
  
  public void aJq()
  {
    if (this.jdField_b_of_type_Lhf == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_Lhf.doOnStop();
      if (this.jdField_a_of_type_Liz != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Liz.doOnStop();
  }
  
  public void aJr()
  {
    if (this.jdField_a_of_type_Lhn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshRecommendAnMyCoverListFromServer mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Lhn.aMo();
  }
  
  public void aJs()
  {
    if (this.jdField_a_of_type_Lhn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelCoverListFromDb mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Lhn.aJs();
  }
  
  public void aJu()
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestFollowTab0x8c8UpdateUpvoteAndComment mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_b_of_type_Lhf.p("-1", 0, 70);
  }
  
  public void aJv()
  {
    if (this.jdField_a_of_type_Lhx != null) {
      this.jdField_a_of_type_Lhx.aJv();
    }
  }
  
  public void aJw()
  {
    if ((this.jdField_a_of_type_Lhy != null) && (this.jdField_a_of_type_Lhy.Cm())) {
      this.jdField_a_of_type_Lhy.cO(300, 2);
    }
  }
  
  public void aJx()
  {
    if (this.jdField_a_of_type_Liw != null) {
      this.jdField_a_of_type_Liw.aMD();
    }
  }
  
  public void aJy()
  {
    if (this.jdField_a_of_type_Lho != null) {
      this.jdField_a_of_type_Lho.aMp();
    }
  }
  
  public void aJz()
  {
    if ((this.mExecutorService == null) || (this.mExecutorService.isShutdown()) || (this.mExecutorService.isTerminated()))
    {
      QLog.d("ReadInJoyLogicEngine", 1, "startFeedsPreload, executorService is not available.");
      return;
    }
    this.mExecutorService.execute(new ReadInJoyLogicEngine.8(this));
  }
  
  public boolean aO(long paramLong)
  {
    if (this.jdField_a_of_type_Lhi == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return false;
    }
    return this.jdField_a_of_type_Lhi.aO(paramLong);
  }
  
  public void aa(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Lby != null) {
      this.jdField_a_of_type_Lby.aa(paramLong, paramInt);
    }
  }
  
  public boolean aa(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Lhf == null) {
      return false;
    }
    return this.jdField_b_of_type_Lhf.ac(paramInt1, paramInt2);
  }
  
  public void ab(long paramLong, int paramInt)
  {
    aa(paramLong, paramInt);
    Object localObject1 = "publishUin = " + paramLong;
    localObject1 = getEntityManagerFactory().createEntityManager().query(ArticleInfo.class, true, (String)localObject1, null, null, null, "mRecommendSeq desc", null);
    if (localObject1 == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "no soical feeds to update article.publishUin:" + paramLong);
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    label94:
    ArticleInfo localArticleInfo;
    int i;
    label144:
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localArticleInfo = (ArticleInfo)((Iterator)localObject1).next();
      if (localArticleInfo.mSocialFeedInfo == null) {
        break label445;
      }
      if ((localArticleInfo.mSocialFeedInfo.mFollowStatus == 2) || (paramInt != 2)) {
        break label439;
      }
      i = 1;
      localArticleInfo.mSocialFeedInfo.mFollowStatus = paramInt;
      localObject2 = new articlesummary.SocializeFeedsInfo();
    }
    for (;;)
    {
      try
      {
        ((articlesummary.SocializeFeedsInfo)localObject2).mergeFrom(localArticleInfo.mSocialFeedInfoByte);
        ((articlesummary.SocializeFeedsInfo)localObject2).uint32_follow_status.set(paramInt, true);
        localArticleInfo.mSocialFeedInfoByte = ((articlesummary.SocializeFeedsInfo)localObject2).toByteArray();
        j = 1;
        k = i;
        m = j;
        if (localArticleInfo.mPolymericInfo != null)
        {
          j = i;
          if (localArticleInfo.mPolymericInfo.followStatus != 2)
          {
            j = i;
            if (paramInt == 2) {
              j = 1;
            }
          }
          localArticleInfo.mPolymericInfo.followStatus = paramInt;
          localObject2 = new articlesummary.PackInfo();
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        try
        {
          ((articlesummary.PackInfo)localObject2).mergeFrom(localArticleInfo.mPackInfoBytes);
          ((articlesummary.PackInfo)localObject2).uint32_follow_status.set(paramInt, true);
          localArticleInfo.mPackInfoBytes = ((articlesummary.PackInfo)localObject2).toByteArray();
          int m = 1;
          int k = j;
          if (m == 0) {
            break label94;
          }
          this.jdField_b_of_type_Lhf.a(localArticleInfo);
          localArticleInfo = this.jdField_b_of_type_Lhf.a(localArticleInfo, (int)localArticleInfo.mChannelID);
          if ((k != 0) && (localArticleInfo != null)) {
            localArticleInfo.isNeedShowBtnWhenFollowed = true;
          }
          if (localArticleInfo == null) {
            break label94;
          }
          localArticleInfo.invalidateProteusTemplateBean();
          break label94;
          localInvalidProtocolBufferMicroException1 = localInvalidProtocolBufferMicroException1;
          localInvalidProtocolBufferMicroException1.printStackTrace();
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
        {
          QLog.e("ReadInJoyLogicEngine", 1, "updateArticleFollowStatusByAccount article.mPackInfoBytes convert error article.publishUin:" + paramLong + " e = " + localInvalidProtocolBufferMicroException2);
          localInvalidProtocolBufferMicroException2.printStackTrace();
          continue;
        }
      }
      if (this.mMainThreadHandler == null) {
        break;
      }
      this.mMainThreadHandler.post(new ReadInJoyLogicEngine.7(this));
      return;
      label439:
      i = 0;
      break label144;
      label445:
      i = 0;
      int j = 0;
    }
  }
  
  public boolean ap(Context paramContext)
  {
    if (this.aNc == -1) {
      bW(paramContext);
    }
    return this.aNc > 0;
  }
  
  public void aq(int paramInt, String paramString)
  {
    List localList = aC();
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      while (i < localList.size())
      {
        mgw localmgw = (mgw)localList.get(i);
        int j = 0;
        while (j < localmgw.iK.size())
        {
          if (paramInt == ((TabChannelCoverInfo)localmgw.iK.get(j)).mChannelCoverId) {
            ((TabChannelCoverInfo)localmgw.iK.get(j)).mChannelCoverName = paramString;
          }
          j += 1;
        }
        i += 1;
      }
    }
    n(localList, true);
  }
  
  public void ar(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Liw != null) {
      this.jdField_a_of_type_Liw.a(paramInt, paramString, null);
    }
  }
  
  public Pair<Integer, Integer> b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Lhb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getPreloadAdvertisementAtPostion mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Lhb.b(paramInt1, paramInt2);
  }
  
  public AdvertisementInfo b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Lhb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAdvertisementInfo mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Lhb.b(paramInt1, paramInt2);
  }
  
  public ArticleInfo b(int paramInt, long paramLong)
  {
    Object localObject;
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      localObject = null;
      return localObject;
    }
    List localList = this.jdField_b_of_type_Lhf.b(Integer.valueOf(paramInt));
    if ((localList != null) && (!localList.isEmpty()))
    {
      paramInt = 0;
      for (;;)
      {
        if (paramInt >= localList.size()) {
          break label104;
        }
        ArticleInfo localArticleInfo = (ArticleInfo)localList.get(paramInt);
        localObject = localArticleInfo;
        if (localArticleInfo.mArticleID == paramLong) {
          break;
        }
        paramInt += 1;
      }
    }
    label104:
    return null;
  }
  
  public List<ArticleInfo> b(Integer paramInteger)
  {
    if (this.jdField_b_of_type_Lhf != null) {
      return this.jdField_b_of_type_Lhf.b(paramInteger);
    }
    return null;
  }
  
  public lbg b()
  {
    return this.jdField_a_of_type_Lbg;
  }
  
  public lbk b()
  {
    return this.jdField_a_of_type_Lbk;
  }
  
  public void b(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    a(paramInt, paramBaseArticleInfo, Boolean.valueOf(true));
  }
  
  public void b(ChannelInfo paramChannelInfo)
  {
    if (this.jdField_a_of_type_Lho != null) {
      this.jdField_a_of_type_Lho.c(paramChannelInfo);
    }
  }
  
  public void b(TopicInfo paramTopicInfo)
  {
    if (this.jdField_b_of_type_Lhf != null)
    {
      this.jdField_b_of_type_Lhf.c(paramTopicInfo);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTopicByKeyword: mArticleInfoModule is null when create ugc topic: " + paramTopicInfo);
  }
  
  public void b(kpp.a parama)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "transformNewBiuCardInRecommendFeeds | mArticleInfoModule is null!");
      return;
    }
    if (parama == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "transformNewBiuCardInRecommendFeeds |  biuInfo is null!");
      return;
    }
    this.jdField_b_of_type_Lhf.c(parama);
  }
  
  public boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "loadMoreArticle return false, mArticleInfoModule = null");
      qn(paramInt1);
      return false;
    }
    long l = this.jdField_b_of_type_Lhf.b(Integer.valueOf(paramInt1));
    if (l == -1L)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "loadMoreArticle return false, minRecommendSeq = -1.");
      qn(paramInt1);
      return false;
    }
    this.jdField_b_of_type_Lhf.a(paramInt1, 20, l - 1L, true, paramInt2, paramInt3, 0, paramInt4, paramInt5);
    return true;
  }
  
  public void bB(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Lig == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "get king moment module is null!");
      }
      return;
    }
    this.jdField_a_of_type_Lig.bB(paramString1, paramString2);
  }
  
  public AdvertisementInfo c(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Lhb != null)
    {
      Object localObject1 = this.jdField_a_of_type_Lhb.l(paramInt1);
      if (localObject1 != null)
      {
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        AdvertisementInfo localAdvertisementInfo;
        for (localObject1 = null;; localObject1 = localAdvertisementInfo)
        {
          localObject2 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localAdvertisementInfo = (AdvertisementInfo)localIterator.next();
          localObject2 = localObject1;
          if (localAdvertisementInfo.mAdKdPos > paramInt2) {
            break;
          }
        }
      }
    }
    Object localObject2 = null;
    return localObject2;
  }
  
  public void c(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestVideoRealTimeReplaceList mArticleInfoModule is null!");
      }
      return;
    }
    Object localObject2 = this.jdField_b_of_type_Lhf.a(Integer.valueOf(paramInt1));
    Object localObject1 = new luq.b();
    ((luq.b)localObject1).channelID = paramInt1;
    ((luq.b)localObject1).uH = -1L;
    ((luq.b)localObject1).ale = true;
    ((luq.b)localObject1).it = ((List)localObject2);
    ((luq.b)localObject1).alf = false;
    localObject2 = new ArrayList();
    ((List)localObject2).add(Long.valueOf(paramLong1));
    ((luq.b)localObject1).iu = ((List)localObject2);
    ((luq.b)localObject1).aPY = 7;
    Object localObject3 = new JSONObject();
    try
    {
      ((JSONObject)localObject3).put("next_video_algorithm_id", paramLong2);
      ((luq.b)localObject1).pushContext = ((JSONObject)localObject3).toString();
      ((luq.b)localObject1).alg = true;
      ((luq.b)localObject1).alh = true;
      ((luq.b)localObject1).ali = true;
      ((luq.b)localObject1).bm = this.jdField_b_of_type_Lhf.a(Integer.valueOf(paramInt1));
      ((luq.b)localObject1).alj = false;
      ((luq.b)localObject1).bo = lhf.D();
      ((luq.b)localObject1).aPV = 0;
      ((luq.b)localObject1).innerUniqId = null;
      ((luq.b)localObject1).uJ = -1L;
      ((luq.b)localObject1).articleTitle = null;
      ((luq.b)localObject1).channelType = paramInt2;
      ((luq.b)localObject1).algorithmId = 0L;
      ((luq.b)localObject1).tn = 0L;
      ((luq.b)localObject1).alm = false;
      ((luq.b)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo = null;
      ((luq.b)localObject1).reqType = 3;
      ((luq.b)localObject1).uI = -1L;
      ((luq.b)localObject1).aPX |= 0x10;
      ((luq.b)localObject1).aPX |= 0x2000;
      if ((paramInt1 == 40677) || (paramInt2 == 7)) {
        ((luq.b)localObject1).serviceType = 2;
      }
      if ((paramInt1 == 41695) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null))
      {
        localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a();
        if (localObject3 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyLogicEngine", 2, "requestVideoRealTimeReplaceList positionData = " + localObject3);
          }
          ((luq.b)localObject1).e = new SelectPositionModule.PositionData();
          ((luq.b)localObject1).e.copy((SelectPositionModule.PositionData)localObject3);
        }
      }
      this.jdField_b_of_type_Lhf.b((luq.b)localObject1);
      localObject1 = new StringBuilder("SelectedKandianArticleIds : ");
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Long)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append(localObject3 + " , ");
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
      QLog.i("ArticleInfoModule", 1, "###requestVideoRealTimeReplaceList kandianArticleID : " + ((StringBuilder)localObject1).toString());
    }
  }
  
  public void c(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.i("ReadInJoyLogicEngine", 1, "moveChannelToFront() called with: channelCoverId = [" + paramInt1 + "], source = [" + paramInt2 + "], addAtEnd = [" + paramBoolean1 + "]");
    if (this.jdField_a_of_type_Lhn == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "moveChannelToFront mChannelCoverInfoModule is null!");
      }
    }
    List localList;
    Object localObject;
    mgw localmgw;
    int i;
    do
    {
      do
      {
        return;
        localList = this.jdField_a_of_type_Lhn.aC();
      } while ((localList == null) || (localList.size() <= 0));
      localObject = localList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localmgw = (mgw)((Iterator)localObject).next();
        i = mis.a(localmgw.iK, new lca(this, paramInt1));
      } while (i < 0);
      localObject = (TabChannelCoverInfo)localmgw.iK.get(i);
    } while (((TabChannelCoverInfo)localObject).reason == 4);
    localmgw.iK.remove(i);
    if (localmgw == localList.get(0)) {
      paramInt1 = i;
    }
    for (;;)
    {
      localmgw = (mgw)localList.get(0);
      i = mis.a(localmgw.iK, new lcb(this));
      if (QLog.isColorLevel()) {
        lhn.i(localmgw.iK, " firstUnLockPosition : " + i);
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject != null) && (localmgw.iK != null))
      {
        kyn.d(kxm.getAppRuntime(), ((TabChannelCoverInfo)localObject).mChannelCoverId);
        if ((i < 0) || (paramBoolean1)) {
          break label405;
        }
        localmgw.iK.add(i, localObject);
      }
      for (;;)
      {
        kbp.a(null, "", "0X8009A59", "0X8009A59", 0, 0, "", "", "", kxm.a().b("uin", localQQAppInterface.getCurrentAccountUin()).a(((TabChannelCoverInfo)localObject).mChannelCoverId).b("source", paramInt2).b("fromposition", paramInt1).build(), false);
        c(localList, 2, paramBoolean2);
        return;
        label405:
        localmgw.iK.add(localObject);
      }
      paramInt1 = -1;
      continue;
      paramInt1 = -1;
      localObject = null;
    }
  }
  
  public void c(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (this.jdField_b_of_type_Lhf != null) {
      this.jdField_b_of_type_Lhf.d(paramInt, paramBaseArticleInfo);
    }
  }
  
  public void c(int paramInt, String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_Lhn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateMainChannelCoverInfo mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Lhn.c(paramInt, paramString, paramLong);
  }
  
  public void c(long paramLong, List<mha> paramList)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "sendShieldArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_b_of_type_Lhf.d(paramLong, paramList);
  }
  
  protected void c(AppInterface paramAppInterface)
  {
    QLog.i("ReadInJoyLogicEngine", 1, "[initialize]: ");
    P.addAndGet(1);
    String str = kxm.getAccount();
    if ((this.mInitialized) && (this.mAccount.equals(str)) && (paramAppInterface == this.mApp)) {
      return;
    }
    this.mInitialized = true;
    this.mAccount = str;
    this.mApp = paramAppInterface;
    this.mMainThreadHandler = new Handler(Looper.getMainLooper());
    this.mExecutorService = MonitorTimeExecutor.e();
    EntityManager localEntityManager = getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_Lun = lun.a();
    this.jdField_b_of_type_Lhf = new lhf(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_a_of_type_Ljc = new ljc(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_a_of_type_Lhi = new lhi(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_a_of_type_Lif = new lif(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_a_of_type_Liz = new liz(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_a_of_type_Lho = new lho(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_a_of_type_Lhb = new lhb(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_a_of_type_Lhn = new lhn(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_a_of_type_Liw = new liw(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_a_of_type_Lhx = new lhx(this.mApp);
    this.jdField_a_of_type_Lig = new lig(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_a_of_type_Lhu = new lhu(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule = new ReadInJoyUserInfoModule(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.a().rq(500);
    this.jdField_a_of_type_Liu = new liu(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_a_of_type_Lhy = new lhy(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_a_of_type_Lhk = new lhk(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler, this.jdField_b_of_type_Lhf);
    this.jdField_a_of_type_Ljd = new ljd(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_b_of_type_Liq = new liq(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_a_of_type_Lic = new lic(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_b_of_type_Kut = new kut(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_a_of_type_Lbg = new lbg(localEntityManager, this.mMainThreadHandler);
    this.jdField_a_of_type_Lbk = new lbk(this.mMainThreadHandler);
    this.jdField_a_of_type_Ljz = new ljz(this.mExecutorService);
    this.jdField_a_of_type_Lht = new lht(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = new SelectPositionModule(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_a_of_type_Lil = new lil(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_b_of_type_Kqe = new kqe(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_a_of_type_Lij = new lij(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    this.jdField_a_of_type_Lii = new lii(this.mApp, localEntityManager, this.mExecutorService, this.jdField_a_of_type_Lun, this.mMainThreadHandler);
    kpb.a.aFF();
    kpc.ao = null;
    kys.reset();
    this.bd = new ConcurrentHashMap();
    this.be = new ConcurrentHashMap();
    npi.reset();
    npt.reset();
    this.jdField_a_of_type_Lby = new lby(paramAppInterface, this.jdField_a_of_type_Lhy);
    QLog.d("ReadInJoyLogicEngine", 2, "readinjoy logic engine init finish ! account : " + str);
  }
  
  public void c(List<mgw> paramList, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lhn == null)
    {
      QLog.d("ReadInJoyLogicEngine", 2, "updateRecommendAndMyChannelListsToServer failed, mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Lhn.b(a().aC(), paramList, paramBoolean);
    this.jdField_a_of_type_Lhn.m(paramList, paramInt);
  }
  
  public boolean c(Long paramLong)
  {
    if (this.jdField_a_of_type_Lby != null) {
      return this.jdField_a_of_type_Lby.c(paramLong);
    }
    return false;
  }
  
  public void cE(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Lho == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelListFromServer mChannelInfoModule is null!");
      }
      return;
    }
    switch (paramInt1)
    {
    case 0: 
    default: 
      return;
    case -1: 
      this.jdField_a_of_type_Lho.nz(true);
      return;
    }
    this.jdField_a_of_type_Lho.aMr();
  }
  
  public void cF(int paramInt1, int paramInt2)
  {
    if (lhn.dJ(paramInt1)) {
      cG(paramInt1, paramInt2);
    }
  }
  
  public void cG(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2, false, true);
  }
  
  public void cH(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Lhf.cK(paramInt1, paramInt2);
  }
  
  public void cb(List<ReportInfo> paramList)
  {
    if (this.jdField_a_of_type_Ljc == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "userOperationReport mUserOperationModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ljc.cA(paramList);
  }
  
  public boolean d(Long paramLong)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "isArticleNeedHighLight mArticleInfoModule is null!");
      }
      return false;
    }
    return this.jdField_b_of_type_Lhf.d(paramLong);
  }
  
  public boolean dI(String paramString)
  {
    if ((this.jdField_a_of_type_Lby != null) && (TextUtils.isDigitsOnly(paramString))) {
      return this.jdField_a_of_type_Lby.c(Long.valueOf(paramString));
    }
    return false;
  }
  
  public boolean dy(int paramInt)
  {
    if (this.jdField_a_of_type_Lhb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "needRequestAdvertisement mAdvertisementInfoModule is null!");
      }
      return true;
    }
    return this.jdField_a_of_type_Lhb.dy(paramInt);
  }
  
  public void e(long paramLong1, long paramLong2, String paramString)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "autoRefreshForNewBiuCard | mArticleInfoModule is null!");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramLong1 != -1L) && (paramLong1 != 0L))
    {
      localArrayList.add(Long.valueOf(paramLong1));
      QLog.d("ReadInJoyLogicEngine", 2, "autoRefreshForNewBiuCard | unique_articleId : " + paramLong1);
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("BiuSetTop", "1");
        localJSONObject.put("FeedsId", paramLong2);
        localJSONObject.put("ArticleId", paramLong1);
        localJSONObject.put("biuUin", kxm.getAccount());
        localJSONObject.put("rowKey", paramString);
        paramString = new JSONObject();
        paramString.put("socialFeedsType", 3);
        localJSONObject.put("extension", paramString.toString());
        QLog.d("ReadInJoyLogicEngine", 2, "autoRefreshForNewBiuCard | pushContext: " + localJSONObject.toString());
        a(0, localArrayList, 14, true, false, 0, null, -1L, null, 0, 0L, 0L, localJSONObject.toString(), 6, false, null, 0, null);
        return;
        localArrayList.add(Long.valueOf(paramLong2));
        QLog.d("ReadInJoyLogicEngine", 2, "autoRefreshForNewBiuCard | unique_feedsId : " + paramLong2);
        paramLong1 = paramLong2;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          QLog.d("ReadInJoyLogicEngine", 2, paramString.getMessage());
        }
      }
    }
  }
  
  @UiThread
  public void e(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (this.jdField_a_of_type_Lhn == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "updateChannel mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Lhn.e(paramTabChannelCoverInfo);
  }
  
  public void es(long paramLong)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestIndividualArticlesFormServer mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_b_of_type_Lhf.ac(paramLong, 1);
  }
  
  public void et(long paramLong)
  {
    if (this.jdField_b_of_type_Lhf != null)
    {
      this.jdField_b_of_type_Lhf.ex(paramLong);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTagsByTopicId: mArticleInfoModule is null when search " + paramLong);
  }
  
  public void f(long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Liu == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "changeRecommendFollow mRecommendFollowForChangeModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Liu.f(paramLong, paramArrayOfByte);
  }
  
  public void f(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Lho == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "followUnfollowChildChannel mChannelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Lho.g(paramBoolean, paramInt1, paramInt2);
  }
  
  public EntityManagerFactory getEntityManagerFactory()
  {
    Object localObject1 = kxm.getAccount();
    if (localObject1 == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    try
    {
      if ((this.jdField_c_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) || (!TextUtils.equals(((ReadInJoyEntityManagerFactory)this.jdField_c_of_type_ComTencentMobileqqPersistenceEntityManagerFactory).name, (CharSequence)localObject1)))
      {
        localObject1 = new ReadInJoyEntityManagerFactory((String)localObject1);
        ThreadManager.post(new ReadInJoyLogicEngine.1(this, (ReadInJoyEntityManagerFactory)localObject1), 8, null, false);
        this.jdField_c_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = ((EntityManagerFactory)localObject1);
      }
      return this.jdField_c_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
    }
    finally {}
  }
  
  public void h(Long paramLong)
  {
    if (this.jdField_a_of_type_Lhx != null) {
      this.jdField_a_of_type_Lhx.h(paramLong);
    }
  }
  
  public void h(String paramString, Context paramContext)
  {
    if (this.jdField_a_of_type_Liz == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unFollowSubscribeAccount mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Liz.h(paramString, paramContext);
    kbp.b(null, "CliOper", "", "", "0X8006113", "0X8006113", 0, 0, "", "", "", "");
  }
  
  public void h(List<ReportInfo> paramList, String paramString)
  {
    if (this.jdField_a_of_type_Ljc == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "mUserOperationModule is null.");
      return;
    }
    this.jdField_a_of_type_Ljc.j(paramList, paramString);
  }
  
  public void i(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "resetBiuBreathAnimationFlag | mArticleInfoModule is null!");
      return;
    }
    this.jdField_b_of_type_Lhf.i(paramArticleInfo);
  }
  
  public void j(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleInfo mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_b_of_type_Lhf.j(paramArticleInfo);
  }
  
  public String je()
  {
    if (this.jdField_a_of_type_Lhx != null) {
      return this.jdField_a_of_type_Lhx.js();
    }
    return "";
  }
  
  public void l(ArticleInfo paramArticleInfo)
  {
    this.jdField_b_of_type_Lhf.j(paramArticleInfo);
  }
  
  public void mO(String paramString)
  {
    if (this.jdField_a_of_type_Liz == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "stickySubscriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Liz.mO(paramString);
  }
  
  public void mP(String paramString)
  {
    if (this.jdField_a_of_type_Liz == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unstickySubscriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Liz.mP(paramString);
  }
  
  public void mQ(String paramString)
  {
    if (this.jdField_a_of_type_Liz == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "removeSubsciriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Liz.mQ(paramString);
  }
  
  public void mR(String paramString)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "request0xc6dInteractiveAreaCards mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_b_of_type_Lhf.nh(paramString);
  }
  
  public void mS(String paramString)
  {
    if (this.jdField_a_of_type_Liw == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getSelfInfo mSelfInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Liw.mS(paramString);
  }
  
  public void mT(String paramString)
  {
    if (this.jdField_a_of_type_Lhx != null) {
      this.jdField_a_of_type_Lhx.nn(paramString);
    }
  }
  
  public void mU(String paramString)
  {
    if (this.jdField_b_of_type_Lhf != null)
    {
      this.jdField_b_of_type_Lhf.ni(paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTagsByKeyword: mArticleInfoModule is null when search " + paramString);
  }
  
  public void mV(String paramString)
  {
    if (this.jdField_b_of_type_Lhf != null)
    {
      this.jdField_b_of_type_Lhf.nj(paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTopicByKeyword: mArticleInfoModule is null when search: " + paramString);
  }
  
  public void mW(String paramString)
  {
    if (this.jdField_a_of_type_Lho != null) {
      this.jdField_a_of_type_Lho.nk(paramString);
    }
  }
  
  public void mX(String paramString)
  {
    if (this.jdField_a_of_type_Lht != null) {
      this.jdField_a_of_type_Lht.nl(paramString);
    }
  }
  
  protected void mX(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      if (P.addAndGet(-1) > 0)
      {
        QLog.d("ReadInJoyLogicEngine", 2, "unInit fail, referenceCount is : " + P.get());
        return;
      }
      jdField_c_of_type_Lbz = null;
      this.mApp = null;
      this.mAccount = null;
      this.mInitialized = false;
      this.jdField_c_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = null;
      if (this.mMainThreadHandler != null)
      {
        this.mMainThreadHandler.removeCallbacksAndMessages(null);
        this.mMainThreadHandler = null;
      }
      if (this.jdField_a_of_type_Lun != null)
      {
        this.jdField_a_of_type_Lun.aEL();
        this.jdField_a_of_type_Lun = null;
      }
      if (this.jdField_b_of_type_Lhf != null)
      {
        this.jdField_b_of_type_Lhf.aEL();
        this.jdField_b_of_type_Lhf = null;
      }
      if (this.jdField_a_of_type_Ljc != null)
      {
        this.jdField_a_of_type_Ljc.aEL();
        this.jdField_a_of_type_Ljc = null;
      }
      if (this.jdField_a_of_type_Lhi != null)
      {
        this.jdField_a_of_type_Lhi.aEL();
        this.jdField_a_of_type_Lhi = null;
      }
      if (this.jdField_a_of_type_Lif != null)
      {
        this.jdField_a_of_type_Lif.aEL();
        this.jdField_a_of_type_Lif = null;
      }
      if (this.jdField_a_of_type_Liz != null)
      {
        this.jdField_a_of_type_Liz.aEL();
        this.jdField_a_of_type_Liz = null;
      }
      if (this.jdField_a_of_type_Lho != null)
      {
        this.jdField_a_of_type_Lho.aEL();
        this.jdField_a_of_type_Lho = null;
      }
      if (this.jdField_a_of_type_Lhb != null)
      {
        this.jdField_a_of_type_Lhb.aEL();
        this.jdField_a_of_type_Lhb = null;
      }
      if (this.jdField_a_of_type_Lhn != null)
      {
        this.jdField_a_of_type_Lhn.aEL();
        this.jdField_a_of_type_Lhn = null;
      }
      if (this.bd != null) {
        this.bd.clear();
      }
      if (this.be != null) {
        this.be.clear();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.aEL();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule = null;
      }
      if (this.jdField_a_of_type_Liu != null)
      {
        this.jdField_a_of_type_Liu.aEL();
        this.jdField_a_of_type_Liu = null;
      }
      if (this.jdField_a_of_type_Lhk != null)
      {
        this.jdField_a_of_type_Lhk.aEL();
        this.jdField_a_of_type_Lhk = null;
      }
      if (this.jdField_a_of_type_Lic != null) {
        this.jdField_a_of_type_Lic.aEL();
      }
      if (this.jdField_a_of_type_Lbg != null)
      {
        this.jdField_a_of_type_Lbg.aEL();
        this.jdField_a_of_type_Lbg = null;
      }
      if (this.jdField_a_of_type_Lbk != null)
      {
        this.jdField_a_of_type_Lbk.aEL();
        this.jdField_a_of_type_Lbk = null;
      }
      if (this.jdField_a_of_type_Ljz != null)
      {
        this.jdField_a_of_type_Ljz.aEL();
        this.jdField_a_of_type_Ljz = null;
      }
      if (this.jdField_a_of_type_Lht != null)
      {
        this.jdField_a_of_type_Lht.aEL();
        this.jdField_a_of_type_Lht = null;
      }
      if (this.jdField_a_of_type_Lby != null)
      {
        this.jdField_a_of_type_Lby.aEL();
        this.jdField_a_of_type_Lby = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.aEL();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = null;
      }
      if (this.jdField_b_of_type_Kqe != null)
      {
        this.jdField_b_of_type_Kqe.aEL();
        this.jdField_b_of_type_Kqe = null;
      }
      if (this.jdField_a_of_type_Lij != null)
      {
        this.jdField_a_of_type_Lij.aEL();
        this.jdField_a_of_type_Lij = null;
      }
      if (this.jdField_a_of_type_Lii != null)
      {
        this.jdField_a_of_type_Lii.aEL();
        this.jdField_a_of_type_Lii = null;
      }
      kpb.a.aFF();
      kpc.ao = null;
      lka.a().reset();
      kys.reset();
      QLog.d("ReadInJoyLogicEngine", 2, "readinjoy logic engine uninit success!");
      return;
    }
    finally {}
  }
  
  public void mY(boolean paramBoolean)
  {
    s(paramBoolean, null);
  }
  
  public void mZ(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lhn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getMyChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Lhn.ny(paramBoolean);
  }
  
  public void n(List<mgw> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lhn == null)
    {
      QLog.d("ReadInJoyLogicEngine", 2, "updateRecommendAndMyChannelListsToServer failed, mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Lhn.b(a().aC(), paramList, paramBoolean);
  }
  
  public void na(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lhx != null) {
      this.jdField_a_of_type_Lhx.nA(paramBoolean);
    }
  }
  
  public void nb(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lby != null) {
      this.jdField_a_of_type_Lby.mW(paramBoolean);
    }
  }
  
  public int om()
  {
    if (this.jdField_a_of_type_Liz == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return 0;
    }
    return this.jdField_a_of_type_Liz.om();
  }
  
  public int on()
  {
    if (this.jdField_a_of_type_Lho == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelListFromCache mChannelInfoModule is null!");
      }
      return -1;
    }
    return this.jdField_a_of_type_Lho.oD();
  }
  
  public int oo()
  {
    if (this.jdField_a_of_type_Lhx != null) {
      return this.jdField_a_of_type_Lhx.oo();
    }
    return 0;
  }
  
  public int op()
  {
    String str = kxm.getAccount();
    if (this.be == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "getLeaveKanDianTabInfo mLeaveKanDianTabCache is null.");
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "getLeaveKanDianTabInfo, key: ", str, ", tabIndex: ", this.be.get(str) });
    }
    return ((Integer)this.be.get(str)).intValue();
  }
  
  public void qo(int paramInt)
  {
    if (this.jdField_a_of_type_Lhn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelCoverListFromServer mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Lhn.rl(paramInt);
  }
  
  public void qp(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = aC();
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      while (i < localList.size())
      {
        mgw localmgw1 = (mgw)localList.get(i);
        mgw localmgw2 = new mgw(localmgw1.id, localmgw1.name, localmgw1.text);
        int j = 0;
        while (j < localmgw1.iK.size())
        {
          if (paramInt != ((TabChannelCoverInfo)localmgw1.iK.get(j)).mChannelCoverId) {
            localmgw2.iK.add(localmgw1.iK.get(j));
          }
          j += 1;
        }
        localArrayList.add(localmgw2);
        i += 1;
      }
    }
    n(localArrayList, true);
  }
  
  public void qq(int paramInt)
  {
    if (this.jdField_a_of_type_Lhn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelAdvertisementFromDB mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Lhn.qq(paramInt);
  }
  
  public void qr(int paramInt)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyLogicEngine.5(this, paramInt));
  }
  
  public void qs(int paramInt)
  {
    if (paramInt != 40677) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyLogicEngine.6(this, paramInt));
  }
  
  public void qt(int paramInt)
  {
    if (this.jdField_a_of_type_Lhx != null) {
      this.jdField_a_of_type_Lhx.rn(paramInt);
    }
  }
  
  public void qu(int paramInt)
  {
    this.Sf = paramInt;
  }
  
  public void qv(int paramInt)
  {
    String str = kxm.getAccount();
    if (this.be == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "updateLeaveKanDianTabInfo mLeaveKanDianTabCache is null.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "updateLeaveKanDianTabInfo, key: ", str, ", tabIndex: ", Integer.valueOf(paramInt) });
    }
    this.be.put(str, Integer.valueOf(paramInt));
  }
  
  public void qw(int paramInt)
  {
    if (this.jdField_b_of_type_Lhf != null) {
      this.jdField_b_of_type_Lhf.qw(paramInt);
    }
  }
  
  public void qx(int paramInt)
  {
    ar(paramInt, "");
  }
  
  public List<ChannelCoverInfo> r(int paramInt)
  {
    if (this.jdField_a_of_type_Lhn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Lhn.r(paramInt);
  }
  
  public void s(boolean paramBoolean, String paramString)
  {
    long l2 = 0L;
    aJy();
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "equestFollowList mArticleInfoModule is null!");
      }
      return;
    }
    HashMap localHashMap;
    long l1;
    if (paramBoolean)
    {
      if (this.mApp != null) {
        ((KandianMergeManager)this.mApp.getManager(162)).qi(-1);
      }
      localHashMap = t();
      l1 = this.jdField_b_of_type_Lhf.a(Integer.valueOf(70));
      if (l1 == -1L) {
        break label229;
      }
      l1 += 1L;
    }
    for (;;)
    {
      Object localObject = b(Integer.valueOf(70));
      if ((localObject != null) && (!((List)localObject).isEmpty())) {}
      for (localObject = ((ArticleInfo)((List)localObject).get(((List)localObject).size() - 1)).mFeedCookie;; localObject = null)
      {
        this.aNd += 1;
        this.jdField_b_of_type_Lhf.a(l2, l1, this.aNd, localHashMap, oo(), paramString, je(), (String)localObject);
        return;
        long l3 = this.jdField_b_of_type_Lhf.b(Integer.valueOf(70));
        if (l3 == -1L) {
          break label221;
        }
        localHashMap = null;
        l1 = 0L;
        l2 = l3 - 1L;
        break;
      }
      label221:
      localHashMap = null;
      l1 = 0L;
      continue;
      label229:
      l1 = 0L;
    }
  }
  
  public HashMap<Long, Long> t()
  {
    if (this.jdField_a_of_type_Lhx != null) {
      return this.jdField_a_of_type_Lhx.t();
    }
    return null;
  }
  
  public List<TabChannelCoverInfo> t(int paramInt)
  {
    if (this.jdField_a_of_type_Lhn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRecommendChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Lhn.v(paramInt);
  }
  
  public void w(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Lhf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteFastWebArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_b_of_type_Lhf.x(paramLong, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lbz
 * JD-Core Version:    0.7.0.1
 */