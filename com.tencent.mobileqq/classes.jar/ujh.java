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

public class ujh
  extends bjwv<stFeed, bjwy<stFeed>>
{
  public WSFollowFragment a;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private HashSet<bjwy> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  public upp a;
  private boolean jdField_a_of_type_Boolean;
  private upp b;
  private upp c;
  
  public ujh(WSFollowFragment paramWSFollowFragment)
  {
    super(paramWSFollowFragment.getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment = paramWSFollowFragment;
    this.jdField_a_of_type_Boolean = paramWSFollowFragment.c();
  }
  
  private String a(upp paramupp)
  {
    if (paramupp == null) {
      return "WSPlayableHolder is null.";
    }
    if (paramupp.jdField_a_of_type_Urt == null) {
      return "WSPlayableHolder.mPlayerParam is null.";
    }
    if (paramupp.jdField_a_of_type_Urt.jdField_a_of_type_Urx == null) {
      return "WSPlayableHolder.mPlayerParam.mVideoInfo is null.";
    }
    return paramupp.jdField_a_of_type_Urt.jdField_a_of_type_Urx.d;
  }
  
  private void a(uou paramuou)
  {
    if ((this.c == null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.b()) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null))
    {
      this.c = paramuou;
      b(this.c);
      uya.e("WSFollowAdapter", "[WSFollowAdapter.java][onPrePlayFirstVideo] playerParam:" + this.c.jdField_a_of_type_Urt + ", mFistPlayableHolder:" + this.c + ", mFistPlayableHolder.mVideoInfo:" + this.c.jdField_a_of_type_Urx);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(this.c.jdField_a_of_type_Urt);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.b(false);
    }
  }
  
  private void c()
  {
    WSVideoPreDownloadManager localWSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.getApplication().getApplicationContext());
    localWSVideoPreDownloadManager.a(new uji(this));
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
  
  public bjwy<stFeed> a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = upe.a(paramInt, paramViewGroup, this);
    this.jdField_a_of_type_JavaUtilHashSet.add(paramViewGroup);
    uya.a("WSFollowContinuePlayLog", "===> WSFollowAdapter onCreateCustomViewHolder viewHolder:" + paramViewGroup);
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
  
  public HashSet<bjwy> a()
  {
    return this.jdField_a_of_type_JavaUtilHashSet;
  }
  
  public void a()
  {
    upp localupp = this.b;
    if ((localupp == null) || (localupp == this.jdField_a_of_type_Upp)) {
      uya.d("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] prePlayVideoHolder:" + localupp);
    }
    int i;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Upp == null) || (this.jdField_a_of_type_Upp.jdField_a_of_type_Urt == null) || (this.jdField_a_of_type_Upp.jdField_a_of_type_Urt.jdField_a_of_type_Urw == null));
      i = this.jdField_a_of_type_Upp.jdField_a_of_type_Urt.jdField_a_of_type_Urw.e();
      uya.e("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] playingPlayerState:" + i + ", prePlayVideoHolder:" + localupp);
    } while ((i == 0) || (i == 1) || (i == 2));
    uya.a("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] goto prePlayVideo prePlayVideoHolder:" + localupp);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localupp.jdField_a_of_type_Urt);
  }
  
  public void a(bjwy<stFeed> parambjwy)
  {
    uya.b("WSFollowAdapter", "[WSFollowAdapter.java][onViewAttachedToWindow] holder: " + parambjwy);
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.getUserVisibleHint())
    {
      if (!(parambjwy instanceof uou)) {
        break label49;
      }
      ((uou)parambjwy).h();
    }
    label49:
    do
    {
      return;
      if ((parambjwy instanceof upg))
      {
        ((upg)parambjwy).a();
        return;
      }
      if ((parambjwy instanceof uph))
      {
        ((uph)parambjwy).a();
        return;
      }
    } while (!(parambjwy instanceof upc));
    ((upc)parambjwy).a();
  }
  
  public void a(bjwy<stFeed> parambjwy, int paramInt)
  {
    stFeed localstFeed = (stFeed)a(paramInt);
    if (localstFeed == null) {}
    do
    {
      return;
      if ((parambjwy instanceof uou))
      {
        parambjwy.a(localstFeed);
        parambjwy = (uou)parambjwy;
        parambjwy.jdField_a_of_type_Urx = urv.a(localstFeed.feed);
        unc.a().a(parambjwy);
        parambjwy.jdField_a_of_type_Urk = unc.a().a(parambjwy);
        parambjwy.jdField_a_of_type_Urt = unc.a().a(parambjwy, 0L, paramInt);
        uya.a("WSFollowAdapter", "===> WSFollowAdapter onBindCustomViewHolder position:" + paramInt + ", title: " + parambjwy.jdField_a_of_type_Urx.d + ", feedHolder:" + parambjwy + ", feedHolder.mVideoInfo:" + parambjwy.jdField_a_of_type_Urx);
        a(parambjwy);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a(parambjwy);
        return;
      }
      if ((parambjwy instanceof upf))
      {
        ((upf)parambjwy).a(localstFeed);
        return;
      }
      if ((parambjwy instanceof upg))
      {
        ((upg)parambjwy).a(localstFeed);
        return;
      }
      if ((parambjwy instanceof uph))
      {
        ((uph)parambjwy).a(localstFeed);
        return;
      }
    } while (!(parambjwy instanceof upc));
    ((upc)parambjwy).a(localstFeed);
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
    paramWSPlayerManager = new uto(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramWSPlayerManager);
    c();
  }
  
  public void a(upp paramupp)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d();
    this.jdField_a_of_type_Upp = paramupp;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(paramupp.jdField_a_of_type_Urt, false);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(this.jdField_a_of_type_Boolean);
    unc.a().a(paramupp.jdField_a_of_type_Urt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    url localurl;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(paramBoolean);
      localurl = url.a();
      if (paramBoolean) {
        break label46;
      }
    }
    label46:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localurl.a(paramBoolean);
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(bjwy<stFeed> parambjwy)
  {
    super.onViewDetachedFromWindow(parambjwy);
    if ((parambjwy instanceof uou)) {
      ((uou)parambjwy).g();
    }
  }
  
  public void b(upp paramupp)
  {
    this.b = paramupp;
    uya.e("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][setPrePlayingHolder]\nplayingTitle:" + a(this.jdField_a_of_type_Upp) + "\nprePlayTitle:" + a(this.b) + "\nPlayingHolder:" + this.jdField_a_of_type_Upp + "\nPrePlayHolder:" + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujh
 * JD-Core Version:    0.7.0.1
 */