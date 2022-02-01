import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSplitBlock;
import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ucr
  extends blsv<stFeed, blsy<stFeed>>
{
  public WSFollowFragment a;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private HashSet<blsy> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  public uiu a;
  private boolean jdField_a_of_type_Boolean;
  private uiu b;
  private uiu c;
  
  public ucr(WSFollowFragment paramWSFollowFragment)
  {
    super(paramWSFollowFragment.getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment = paramWSFollowFragment;
    this.jdField_a_of_type_Boolean = paramWSFollowFragment.c();
  }
  
  private String a(uiu paramuiu)
  {
    if (paramuiu == null) {
      return "WSPlayableHolder is null.";
    }
    if (paramuiu.jdField_a_of_type_Ukz == null) {
      return "WSPlayableHolder.mPlayerParam is null.";
    }
    if (paramuiu.jdField_a_of_type_Ukz.jdField_a_of_type_Uld == null) {
      return "WSPlayableHolder.mPlayerParam.mVideoInfo is null.";
    }
    return paramuiu.jdField_a_of_type_Ukz.jdField_a_of_type_Uld.d;
  }
  
  private void a(uhz paramuhz)
  {
    if ((this.c == null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.b()) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null))
    {
      this.c = paramuhz;
      b(this.c);
      uqf.e("WSFollowAdapter", "[WSFollowAdapter.java][onPrePlayFirstVideo] playerParam:" + this.c.jdField_a_of_type_Ukz + ", mFistPlayableHolder:" + this.c + ", mFistPlayableHolder.mVideoInfo:" + this.c.jdField_a_of_type_Uld);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(this.c.jdField_a_of_type_Ukz);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.b(false);
    }
  }
  
  private void c()
  {
    WSVideoPreDownloadManager localWSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.getApplication().getApplicationContext());
    localWSVideoPreDownloadManager.a(new ucs(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localWSVideoPreDownloadManager);
  }
  
  public int a(int paramInt)
  {
    Object localObject = a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (stFeed)((List)localObject).get(paramInt);
      if (localObject == null) {
        return 2;
      }
      stSplitBlock localstSplitBlock = ((stFeed)localObject).recommend_splitter;
      if ((localstSplitBlock != null) && (((stFeed)localObject).feed_type == 3)) {}
      switch (localstSplitBlock.style)
      {
      default: 
        return ((stFeed)localObject).feed_type;
      case 1: 
        return 101;
      }
      return 102;
    }
    return 2;
  }
  
  public stSimpleMetaFeed a()
  {
    Object localObject = a();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      stFeed localstFeed = (stFeed)((Iterator)localObject).next();
      if ((localstFeed.feed != null) && (!TextUtils.isEmpty(localstFeed.feed.id))) {
        return localstFeed.feed;
      }
    }
    return null;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.getActivity();
  }
  
  public blsy<stFeed> a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = uij.a(paramInt, paramViewGroup, this);
    this.jdField_a_of_type_JavaUtilHashSet.add(paramViewGroup);
    uqf.a("WSFollowContinuePlayLog", "===> WSFollowAdapter onCreateCustomViewHolder viewHolder:" + paramViewGroup);
    return paramViewGroup;
  }
  
  public WSFollowFragment a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment;
  }
  
  public WSPlayerManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  }
  
  public HashSet<blsy> a()
  {
    return this.jdField_a_of_type_JavaUtilHashSet;
  }
  
  public void a()
  {
    uiu localuiu = this.b;
    if ((localuiu == null) || (localuiu == this.jdField_a_of_type_Uiu)) {
      uqf.d("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] prePlayVideoHolder:" + localuiu);
    }
    int i;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Uiu == null) || (this.jdField_a_of_type_Uiu.jdField_a_of_type_Ukz == null) || (this.jdField_a_of_type_Uiu.jdField_a_of_type_Ukz.jdField_a_of_type_Ulc == null));
      i = this.jdField_a_of_type_Uiu.jdField_a_of_type_Ukz.jdField_a_of_type_Ulc.e();
      uqf.e("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] playingPlayerState:" + i + ", prePlayVideoHolder:" + localuiu);
    } while ((i == 0) || (i == 1) || (i == 2));
    uqf.a("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] goto prePlayVideo prePlayVideoHolder:" + localuiu);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localuiu.jdField_a_of_type_Ukz);
  }
  
  public void a(blsy<stFeed> paramblsy)
  {
    uqf.b("WSFollowAdapter", "[WSFollowAdapter.java][onViewAttachedToWindow] holder: " + paramblsy);
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.getUserVisibleHint())
    {
      if (!(paramblsy instanceof uhz)) {
        break label49;
      }
      ((uhz)paramblsy).h();
    }
    label49:
    do
    {
      return;
      if ((paramblsy instanceof uil))
      {
        ((uil)paramblsy).a();
        return;
      }
      if ((paramblsy instanceof uim))
      {
        ((uim)paramblsy).a();
        return;
      }
    } while (!(paramblsy instanceof uih));
    ((uih)paramblsy).a();
  }
  
  public void a(blsy<stFeed> paramblsy, int paramInt)
  {
    stFeed localstFeed = (stFeed)a(paramInt);
    if (localstFeed == null) {}
    do
    {
      return;
      if ((paramblsy instanceof uhz))
      {
        paramblsy.a(localstFeed);
        paramblsy = (uhz)paramblsy;
        paramblsy.jdField_a_of_type_Uld = ulb.a(localstFeed.feed);
        ugl.a().a(paramblsy);
        paramblsy.jdField_a_of_type_Ukp = ugl.a().a(paramblsy);
        paramblsy.jdField_a_of_type_Ukz = ugl.a().a(paramblsy, 0L, paramInt);
        uqf.a("WSFollowAdapter", "===> WSFollowAdapter onBindCustomViewHolder position:" + paramInt + ", title: " + paramblsy.jdField_a_of_type_Uld.d + ", feedHolder:" + paramblsy + ", feedHolder.mVideoInfo:" + paramblsy.jdField_a_of_type_Uld);
        a(paramblsy);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a(paramblsy);
        return;
      }
      if ((paramblsy instanceof uik))
      {
        ((uik)paramblsy).a(localstFeed);
        return;
      }
      if ((paramblsy instanceof uil))
      {
        ((uil)paramblsy).a(localstFeed);
        return;
      }
      if ((paramblsy instanceof uim))
      {
        ((uim)paramblsy).a(localstFeed);
        return;
      }
    } while (!(paramblsy instanceof uih));
    ((uih)paramblsy).a(localstFeed);
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
    paramWSPlayerManager = new ulu(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramWSPlayerManager);
    c();
  }
  
  public void a(uiu paramuiu)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d();
    this.jdField_a_of_type_Uiu = paramuiu;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(paramuiu.jdField_a_of_type_Ukz, false);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(this.jdField_a_of_type_Boolean);
    ugl.a().a(paramuiu.jdField_a_of_type_Ukz);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    ukq localukq;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(paramBoolean);
      localukq = ukq.a();
      if (paramBoolean) {
        break label46;
      }
    }
    label46:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localukq.a(paramBoolean);
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(blsy<stFeed> paramblsy)
  {
    super.onViewDetachedFromWindow(paramblsy);
    if ((paramblsy instanceof uhz)) {
      ((uhz)paramblsy).g();
    }
  }
  
  public void b(uiu paramuiu)
  {
    this.b = paramuiu;
    uqf.e("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][setPrePlayingHolder]\nplayingTitle:" + a(this.jdField_a_of_type_Uiu) + "\nprePlayTitle:" + a(this.b) + "\nPlayingHolder:" + this.jdField_a_of_type_Uiu + "\nPrePlayHolder:" + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ucr
 * JD-Core Version:    0.7.0.1
 */