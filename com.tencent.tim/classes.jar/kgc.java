import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelWaterFallViewController.2;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelWaterFallViewController.3;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.SerializableMap;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyFragmentWithSubChannel.a;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.f;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView.a;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.Constants.LogoutReason;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class kgc
  extends kfr
  implements ReadInjoyXRecyclerView.a
{
  public ReadInJoyPicWaterFallFragment.f a;
  protected kxa a;
  private int aIz = 1;
  protected boolean aeK;
  private boolean aeL;
  private boolean aeM;
  private ArrayList<ChannelCoverInfo> kc = new ArrayList();
  private int mChannelID;
  private int mChannelType = -1;
  protected boolean mIsResume;
  protected lce mObserver = new kgd(this);
  private long oK;
  boolean zw = false;
  
  public kgc(int paramInt1, int paramInt2, Activity paramActivity, ReadInJoyFragmentWithSubChannel.a parama)
  {
    super(paramActivity);
    this.mChannelType = paramInt2;
    this.mChannelID = paramInt1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f = ((ReadInJoyPicWaterFallFragment.f)parama);
    this.jdField_a_of_type_Kxa = new kxa();
    this.jdField_a_of_type_Kxa.sT = awit.a(paramInt1, (QQAppInterface)kxm.getAppRuntime());
  }
  
  private boolean N(boolean paramBoolean)
  {
    if (!isResume()) {
      return false;
    }
    long l = System.currentTimeMillis();
    boolean bool2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f.BY();
    boolean bool3 = kfv.db(this.mChannelID);
    Object localObject = (KandianMergeManager)((BaseActivity)getActivity()).app.getManager(162);
    boolean bool1;
    if (System.currentTimeMillis() - this.jdField_a_of_type_Kxa.sZ > 300000L)
    {
      bool1 = true;
      boolean bool4 = zm();
      if ((bool2) || (bool1) || (bool4)) {
        break label312;
      }
      paramBoolean = false;
      label95:
      QLog.d("ReadInJoyChannelWaterFallViewController_" + this.mChannelID, 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool4), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false) }));
      if (!zl()) {
        break label322;
      }
      bool1 = kfv.dd(this.mChannelID);
      if ((!bool2) && (!bool1) && (!bool4) && (!bool3)) {
        break label317;
      }
      paramBoolean = true;
      label217:
      QLog.d("ReadInJoyChannelWaterFallViewController", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool4), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(bool3) }));
      bool1 = paramBoolean;
    }
    for (;;)
    {
      if (!bool1) {
        break label372;
      }
      O(true, 2);
      return true;
      bool1 = false;
      break;
      label312:
      paramBoolean = true;
      break label95;
      label317:
      paramBoolean = false;
      break label217;
      label322:
      bool1 = paramBoolean;
      if (this.mChannelID != 70)
      {
        bool1 = paramBoolean;
        if (this.mChannelID != 56)
        {
          bool1 = paramBoolean;
          if (this.mChannelID != 40677)
          {
            bool1 = paramBoolean;
            if (!kys.dv(this.mChannelID)) {
              bool1 = true;
            }
          }
        }
      }
    }
    label372:
    localObject = this.jdField_a_of_type_Kxa;
    if (this.jdField_a_of_type_Kxa.sT == 0L) {}
    for (;;)
    {
      ((kxa)localObject).sT = l;
      if (this.mChannelID == 0) {}
      return false;
      l = this.jdField_a_of_type_Kxa.sT;
    }
  }
  
  private void a(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    this.jdField_a_of_type_Kxa.sT = System.currentTimeMillis();
    awit.a(this.mChannelID, this.jdField_a_of_type_Kxa.sT, (QQAppInterface)kxm.getAppRuntime());
    ArrayList localArrayList = null;
    int j = -1;
    Object localObject = (KandianMergeManager)((BaseActivity)getActivity()).app.getManager(162);
    long l = ca();
    ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f.h(0);
    localObject = localArrayList;
    int i = j;
    if (l != -1L)
    {
      localObject = localArrayList;
      i = j;
      if (localArticleInfo != null)
      {
        localObject = localArrayList;
        i = j;
        if (l != localArticleInfo.mArticleID)
        {
          localObject = new ArrayList();
          ((List)localObject).add(Long.valueOf(l));
          i = 6;
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f.nq(paramBoolean1);
    localArrayList = new ArrayList();
    lbz.a().a(this.mChannelID, (List)localObject, i, true, false, this.aIz, null, -1L, null, ni(), 0L, 0L, null, paramInt1, false, null, 0, localArrayList);
    this.aIz += 1;
    if ((getActivity() instanceof ReadInJoyNewFeedsActivity)) {
      oL(-2);
    }
    odv.a(paramInt1, this.mChannelID, getActivity(), paramBoolean2, paramInt2);
  }
  
  private void aCA() {}
  
  private void bO(List<BaseArticleInfo> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramList.next();
        if (localBaseArticleInfo.mGalleryFeedsInfo == null) {
          paramList.remove();
        } else if ((localBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get() != 4) && (localBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get() != 5)) {
          paramList.remove();
        } else if ((localBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get() == 4) && (localBaseArticleInfo.mJsonPictureList == null)) {
          paramList.remove();
        }
      }
    }
  }
  
  private long ca()
  {
    if ((zn()) && (getActivity().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (ReadInJoyChannelActivity.SerializableMap)getActivity().getIntent().getSerializableExtra("channel_map_data");
      if ((localObject != null) && (((ReadInJoyChannelActivity.SerializableMap)localObject).getMap() != null))
      {
        localObject = ((ReadInJoyChannelActivity.SerializableMap)localObject).getMap();
        long l = ((Long)((Map)localObject).get("param_key_ariticle_id")).longValue();
        if (((Integer)((Map)localObject).get("param_key_channel_cover_style")).intValue() == 1) {
          return l;
        }
      }
    }
    return -1L;
  }
  
  private boolean isResume()
  {
    return this.mIsResume;
  }
  
  private int ni()
  {
    if (this.mChannelType != -1) {
      return this.mChannelType;
    }
    return getActivity().getIntent().getIntExtra("channel_type", 0);
  }
  
  private void setAdapterData(List<BaseArticleInfo> paramList, int paramInt)
  {
    bO(paramList);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f.aG());
    paramList = lgy.a().a(this.mChannelID, paramList, localArrayList, paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f.setData(paramList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f.notifyDataChange();
  }
  
  private boolean zm()
  {
    return false;
  }
  
  private boolean zn()
  {
    return this.mChannelID != 0;
  }
  
  public void O(boolean paramBoolean, int paramInt)
  {
    if (!this.aeK) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f.aGI();
    } while (!paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f.refreshData();
  }
  
  public Set<Long> a(Integer paramInteger)
  {
    Set localSet = (Set)this.dB.get(paramInteger);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.dB.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f.aG();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f.d(paramBaseArticleInfo, paramInt);
    QQToast.a(this.activity, -1, this.activity.getString(2131701914), 0).show(((BaseActivity)this.activity).getTitleBarHeight());
    if (lgy.aP(paramBaseArticleInfo.mRecommendSeq)) {
      lgy.a().F(this.mChannelID, paramBaseArticleInfo.mRecommendSeq);
    }
    do
    {
      do
      {
        return;
        String str = kxm.getAccount();
        DislikeInfo localDislikeInfo = new DislikeInfo();
        localDislikeInfo.type = 9;
        localDislikeInfo.puin = "";
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localDislikeInfo);
        lbz.a().a(Long.valueOf(str).longValue(), ((ArticleInfo)paramBaseArticleInfo).makeDislikeParam(localArrayList));
        lbz.a().b(this.mChannelID, paramBaseArticleInfo);
      } while (paramInt != 0);
      paramBaseArticleInfo = (KandianMergeManager)((QQAppInterface)kxm.getAppRuntime()).getManager(162);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f.aG().size() > 0);
    lbz.a().a(this.mChannelID, 20, 9223372036854775807L, true);
  }
  
  public void a(ReadInjoyXRecyclerView paramReadInjoyXRecyclerView, int paramInt)
  {
    boolean bool;
    int i;
    if (paramInt == 4)
    {
      bool = true;
      this.aeL = bool;
      if (this.mChannelID != 40830) {
        break label72;
      }
      i = this.aIz;
      this.aIz = (i + 1);
    }
    for (;;)
    {
      lbz.a().b(this.mChannelID, ni(), paramInt, 0, i);
      ThreadManager.executeOnSubThread(new ReadInJoyChannelWaterFallViewController.3(this));
      return;
      bool = false;
      break;
      label72:
      i = 1;
    }
  }
  
  public void a(ReadInjoyXRecyclerView paramReadInjoyXRecyclerView, boolean paramBoolean)
  {
    if (kys.dv(this.mChannelID)) {
      kvs.oT(1);
    }
    int i;
    if ((!kxm.AI()) || (zn()) || (paramBoolean))
    {
      i = 1;
      if (i == 0) {
        break label93;
      }
      i = 3;
      label39:
      if (paramBoolean) {
        break label100;
      }
      lcc.a().h(2, null);
      ReadinjoyTabFrame localReadinjoyTabFrame = kxm.a(getActivity());
      if (localReadinjoyTabFrame != null) {
        localReadinjoyTabFrame.oT(1);
      }
      kxm.pW(3);
    }
    for (;;)
    {
      a(true, i, paramBoolean, -paramReadInjoyXRecyclerView.getScrollY());
      return;
      i = 0;
      break;
      label93:
      i = 1001;
      break label39;
      label100:
      lcc.a().h(2, null);
      i = 1;
    }
  }
  
  public void aBY()
  {
    if (this.zw) {
      return;
    }
    this.zw = true;
    super.aBY();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f.b(a(Integer.valueOf(this.mChannelID)), b(Integer.valueOf(this.mChannelID)));
    }
    this.jdField_a_of_type_Kxa.sX = System.currentTimeMillis();
    this.jdField_a_of_type_Kxa.sZ = awit.c((QQAppInterface)kxm.getAppRuntime(), this.mChannelID);
    aCz();
  }
  
  public void aBZ()
  {
    if (!this.zw) {}
    do
    {
      return;
      this.zw = false;
      super.aBZ();
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f.a(b(Integer.valueOf(this.mChannelID)), b(Integer.valueOf(this.mChannelID)));
  }
  
  public void aCB() {}
  
  public void aCc() {}
  
  public void aCe()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f != null)
    {
      Map localMap1 = a(Integer.valueOf(this.mChannelID));
      Map localMap2 = odv.a(this.mChannelID);
      ThreadManager.executeOnSubThread(new ReadInJoyChannelWaterFallViewController.2(this, localMap1, b(Integer.valueOf(this.mChannelID)), localMap2, kxm.bf(this.mChannelID)));
      b(Integer.valueOf(this.mChannelID)).clear();
      this.dB.clear();
    }
  }
  
  public void aCy()
  {
    this.kc = ((ArrayList)lbz.a().r(this.mChannelID));
    if ((this.kc == null) || (this.kc.size() == 0)) {
      lbz.a().qq(this.mChannelID);
    }
    if ((this.kc != null) && (this.kc.size() > 0)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f.ch(this.kc);
    }
    lbz.a().qo(this.mChannelID);
  }
  
  public void aCz()
  {
    if (!this.aeK)
    {
      lbz.a().a(this.mChannelID, 20, 9223372036854775807L, true);
      this.aeK = true;
      return;
    }
    QLog.d("ReadInJoyChannelWaterFallViewController", 2, new Object[] { "has loaded article, mChannelID = ", Integer.valueOf(this.mChannelID) });
  }
  
  public Map<Long, mgu> b(Integer paramInteger)
  {
    Map localMap = (Map)this.dD.get(paramInteger);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new ConcurrentHashMap();
      this.dD.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public boolean b(Integer paramInteger)
  {
    paramInteger = (Boolean)this.dC.get(paramInteger);
    if (paramInteger != null) {
      return paramInteger.booleanValue();
    }
    return false;
  }
  
  public void lP(boolean paramBoolean)
  {
    O(paramBoolean, 0);
  }
  
  public void oL(int paramInt) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate()
  {
    super.onCreate();
    lcc.a().b(this.mObserver);
    this.dC.put(Integer.valueOf(this.mChannelID), Boolean.valueOf(true));
    aBY();
  }
  
  public void onDestroy()
  {
    lcc.a().c(this.mObserver);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$f.a(b(Integer.valueOf(this.mChannelID)), b(Integer.valueOf(this.mChannelID)));
    }
    super.onDestroy();
    this.dB.clear();
    this.dD.clear();
    this.dC.clear();
    this.dE.clear();
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.mIsResume = true;
    aCz();
  }
  
  public boolean zl()
  {
    return getActivity() instanceof SplashActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kgc
 * JD-Core Version:    0.7.0.1
 */