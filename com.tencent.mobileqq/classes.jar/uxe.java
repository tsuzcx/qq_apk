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

public class uxe
  extends blig<stFeed, blij<stFeed>>
{
  public WSFollowFragment a;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private HashSet<blij> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  public vdq a;
  private boolean jdField_a_of_type_Boolean;
  private vdq b;
  private vdq c;
  
  public uxe(WSFollowFragment paramWSFollowFragment)
  {
    super(paramWSFollowFragment.getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment = paramWSFollowFragment;
    this.jdField_a_of_type_Boolean = paramWSFollowFragment.c();
  }
  
  private String a(vdq paramvdq)
  {
    if (paramvdq == null) {
      return "WSPlayableHolder is null.";
    }
    if (paramvdq.jdField_a_of_type_Vgb == null) {
      return "WSPlayableHolder.mPlayerParam is null.";
    }
    if (paramvdq.jdField_a_of_type_Vgb.jdField_a_of_type_Vgi == null) {
      return "WSPlayableHolder.mPlayerParam.mVideoInfo is null.";
    }
    return paramvdq.jdField_a_of_type_Vgb.jdField_a_of_type_Vgi.d;
  }
  
  private void a(vcu paramvcu)
  {
    if ((this.c == null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.b()) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null))
    {
      this.c = paramvcu;
      b(this.c);
      vmp.e("WSFollowAdapter", "[WSFollowAdapter.java][onPrePlayFirstVideo] playerParam:" + this.c.jdField_a_of_type_Vgb + ", mFistPlayableHolder:" + this.c + ", mFistPlayableHolder.mVideoInfo:" + this.c.jdField_a_of_type_Vgi);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(this.c.jdField_a_of_type_Vgb);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.b(false);
    }
  }
  
  private void c()
  {
    WSVideoPreDownloadManager localWSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.getApplication().getApplicationContext());
    localWSVideoPreDownloadManager.a(new uxf(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localWSVideoPreDownloadManager);
  }
  
  public int a(int paramInt)
  {
    Object localObject = b();
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
    Object localObject = b();
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
  
  public blij<stFeed> a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = vdf.a(paramInt, paramViewGroup, this);
    this.jdField_a_of_type_JavaUtilHashSet.add(paramViewGroup);
    vmp.a("WSFollowContinuePlayLog", "===> WSFollowAdapter onCreateCustomViewHolder viewHolder:" + paramViewGroup);
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
  
  public HashSet<blij> a()
  {
    return this.jdField_a_of_type_JavaUtilHashSet;
  }
  
  public void a()
  {
    vdq localvdq = this.b;
    if ((localvdq == null) || (localvdq == this.jdField_a_of_type_Vdq)) {
      vmp.d("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] prePlayVideoHolder:" + localvdq);
    }
    int i;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Vdq == null) || (this.jdField_a_of_type_Vdq.jdField_a_of_type_Vgb == null) || (this.jdField_a_of_type_Vdq.jdField_a_of_type_Vgb.jdField_a_of_type_Vgh == null));
      i = this.jdField_a_of_type_Vdq.jdField_a_of_type_Vgb.jdField_a_of_type_Vgh.e();
      vmp.e("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] playingPlayerState:" + i + ", prePlayVideoHolder:" + localvdq);
    } while ((i == 0) || (i == 1) || (i == 2));
    vmp.a("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] goto prePlayVideo prePlayVideoHolder:" + localvdq);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localvdq.jdField_a_of_type_Vgb);
  }
  
  public void a(blij<stFeed> paramblij)
  {
    vmp.e("WSFollowAdapter", "[************************************************************************************************************]onViewAttachedToWindow holder = " + paramblij);
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.getUserVisibleHint())
    {
      if ((paramblij instanceof vcu)) {
        ((vcu)paramblij).i();
      }
    }
    else
    {
      if (!(paramblij instanceof vcu)) {
        break label114;
      }
      ((vcu)paramblij).g();
    }
    label114:
    while (!(paramblij instanceof vdd))
    {
      return;
      if ((paramblij instanceof vdh))
      {
        ((vdh)paramblij).a();
        break;
      }
      if ((paramblij instanceof vdi))
      {
        ((vdi)paramblij).a();
        break;
      }
      if (!(paramblij instanceof vdd)) {
        break;
      }
      ((vdd)paramblij).b();
      break;
    }
    ((vdd)paramblij).a();
  }
  
  public void a(blij<stFeed> paramblij, int paramInt)
  {
    stFeed localstFeed = (stFeed)a(paramInt);
    if (localstFeed == null) {}
    do
    {
      return;
      if ((paramblij instanceof vcu))
      {
        paramblij.a(localstFeed);
        paramblij = (vcu)paramblij;
        paramblij.jdField_a_of_type_Vgi = vgd.a(localstFeed.feed);
        vbc.a().a(paramblij);
        paramblij.jdField_a_of_type_Vfs = vbc.a().a(paramblij);
        paramblij.jdField_a_of_type_Vgb = vbc.a().a(paramblij, 0L, paramInt);
        vmp.a("WSFollowAdapter", "===> WSFollowAdapter onBindCustomViewHolder position:" + paramInt + ", title: " + paramblij.jdField_a_of_type_Vgi.d + ", feedHolder:" + paramblij + ", feedHolder.mVideoInfo:" + paramblij.jdField_a_of_type_Vgi);
        a(paramblij);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a(paramblij);
        return;
      }
      if ((paramblij instanceof vdg))
      {
        ((vdg)paramblij).a(localstFeed);
        return;
      }
      if ((paramblij instanceof vdh))
      {
        ((vdh)paramblij).a(localstFeed);
        return;
      }
      if ((paramblij instanceof vdi))
      {
        ((vdi)paramblij).a(localstFeed);
        return;
      }
    } while (!(paramblij instanceof vdd));
    ((vdd)paramblij).a(localstFeed);
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
    paramWSPlayerManager = new vhz(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramWSPlayerManager);
    c();
  }
  
  public void a(vdq paramvdq)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d();
    this.jdField_a_of_type_Vdq = paramvdq;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(paramvdq.jdField_a_of_type_Vgb, false);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(this.jdField_a_of_type_Boolean);
    vbc.a().a(paramvdq.jdField_a_of_type_Vgb);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    vft localvft;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(paramBoolean);
      localvft = vft.a();
      if (paramBoolean) {
        break label46;
      }
    }
    label46:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localvft.a(paramBoolean);
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(blij<stFeed> paramblij)
  {
    super.onViewDetachedFromWindow(paramblij);
    vmp.e("WSFollowAdapter", "[************************************************************************************************************]onViewDetachedFromWindow holder = " + paramblij);
    if ((paramblij instanceof vcu)) {
      ((vcu)paramblij).h();
    }
  }
  
  public void b(vdq paramvdq)
  {
    this.b = paramvdq;
    vmp.e("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][setPrePlayingHolder]\nplayingTitle:" + a(this.jdField_a_of_type_Vdq) + "\nprePlayTitle:" + a(this.b) + "\nPlayingHolder:" + this.jdField_a_of_type_Vdq + "\nPrePlayHolder:" + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxe
 * JD-Core Version:    0.7.0.1
 */