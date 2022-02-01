import UserGrowth.stFeed;
import UserGrowth.stSplitBlock;
import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.List;

public class ucp
  extends bkrs<stFeed, bkrv<stFeed>>
{
  public WSFollowFragment a;
  private WSPlayerManager a;
  public uif a;
  private uif b;
  private uif c;
  
  public ucp(WSFollowFragment paramWSFollowFragment)
  {
    super(paramWSFollowFragment.getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment = paramWSFollowFragment;
  }
  
  private String a(uif paramuif)
  {
    if (paramuif == null) {
      return "WSPlayableHolder is null.";
    }
    if (paramuif.jdField_a_of_type_Ukb == null) {
      return "WSPlayableHolder.mPlayerParam is null.";
    }
    if (paramuif.jdField_a_of_type_Ukb.jdField_a_of_type_Ukf == null) {
      return "WSPlayableHolder.mPlayerParam.mVideoInfo is null.";
    }
    return paramuif.jdField_a_of_type_Ukb.jdField_a_of_type_Ukf.d;
  }
  
  private void a(uhk paramuhk)
  {
    if ((this.c == null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.b()) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null))
    {
      this.c = paramuhk;
      b(this.c);
      upe.e("WSFollowAdapter", "[WSFollowAdapter.java][onPrePlayFirstVideo] playerParam:" + this.c.jdField_a_of_type_Ukb + ", mFistPlayableHolder:" + this.c + ", mFistPlayableHolder.mVideoInfo:" + this.c.jdField_a_of_type_Ukf);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(this.c.jdField_a_of_type_Ukb);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.b(false);
    }
  }
  
  private void c()
  {
    WSVideoPreDownloadManager localWSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.getApplication().getApplicationContext());
    localWSVideoPreDownloadManager.a(new ucq(this));
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
  
  public Activity a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.getActivity();
  }
  
  public bkrv<stFeed> a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = uhu.a(paramInt, paramViewGroup, this);
    upe.a("WSFollowContinuePlayLog", "===> WSFollowAdapter onCreateCustomViewHolder viewHolder:" + paramViewGroup);
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
  
  public void a()
  {
    uif localuif = this.b;
    if ((localuif == null) || (localuif == this.jdField_a_of_type_Uif)) {
      upe.d("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] prePlayVideoHolder:" + localuif);
    }
    int i;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Uif == null) || (this.jdField_a_of_type_Uif.jdField_a_of_type_Ukb == null) || (this.jdField_a_of_type_Uif.jdField_a_of_type_Ukb.jdField_a_of_type_Uke == null));
      i = this.jdField_a_of_type_Uif.jdField_a_of_type_Ukb.jdField_a_of_type_Uke.e();
      upe.e("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] playingPlayerState:" + i + ", prePlayVideoHolder:" + localuif);
    } while ((i == 0) || (i == 1) || (i == 2));
    upe.a("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] goto prePlayVideo prePlayVideoHolder:" + localuif);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localuif.jdField_a_of_type_Ukb);
  }
  
  public void a(bkrv<stFeed> parambkrv)
  {
    upe.b("WSFollowAdapter", "[WSFollowAdapter.java][onViewAttachedToWindow] holder: " + parambkrv);
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.getUserVisibleHint())
    {
      if (!(parambkrv instanceof uhk)) {
        break label49;
      }
      ((uhk)parambkrv).d();
    }
    label49:
    do
    {
      return;
      if ((parambkrv instanceof uhw))
      {
        ((uhw)parambkrv).a();
        return;
      }
      if ((parambkrv instanceof uhx))
      {
        ((uhx)parambkrv).a();
        return;
      }
    } while (!(parambkrv instanceof uhs));
    ((uhs)parambkrv).a();
  }
  
  public void a(bkrv<stFeed> parambkrv, int paramInt)
  {
    stFeed localstFeed = (stFeed)a(paramInt);
    if (localstFeed == null) {}
    do
    {
      return;
      if ((parambkrv instanceof uhk))
      {
        parambkrv.a(localstFeed);
        parambkrv = (uhk)parambkrv;
        parambkrv.jdField_a_of_type_Ukf = ukd.a(localstFeed.feed);
        ugj.a().a(parambkrv);
        parambkrv.jdField_a_of_type_Ujv = ugj.a().a(parambkrv);
        parambkrv.jdField_a_of_type_Ukb = ugj.a().a(parambkrv, 0L, paramInt);
        upe.a("WSFollowAdapter", "===> WSFollowAdapter onBindCustomViewHolder position:" + paramInt + ", title: " + parambkrv.jdField_a_of_type_Ukf.d + ", feedHolder:" + parambkrv + ", feedHolder.mVideoInfo:" + parambkrv.jdField_a_of_type_Ukf);
        a(parambkrv);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a(parambkrv);
        return;
      }
      if ((parambkrv instanceof uhv))
      {
        ((uhv)parambkrv).a(localstFeed);
        return;
      }
      if ((parambkrv instanceof uhw))
      {
        ((uhw)parambkrv).a(localstFeed);
        return;
      }
      if ((parambkrv instanceof uhx))
      {
        ((uhx)parambkrv).a(localstFeed);
        return;
      }
    } while (!(parambkrv instanceof uhs));
    ((uhs)parambkrv).a(localstFeed);
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
    paramWSPlayerManager = new ukw(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramWSPlayerManager);
    c();
  }
  
  public void a(uif paramuif)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d();
    this.jdField_a_of_type_Uif = paramuif;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(paramuif.jdField_a_of_type_Ukb, false);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(true);
    ugj.a().a(paramuif.jdField_a_of_type_Ukb);
  }
  
  public void b(bkrv<stFeed> parambkrv)
  {
    super.onViewDetachedFromWindow(parambkrv);
    if ((parambkrv instanceof uhk)) {
      ((uhk)parambkrv).c();
    }
  }
  
  public void b(uif paramuif)
  {
    this.b = paramuif;
    upe.e("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][setPrePlayingHolder]\nplayingTitle:" + a(this.jdField_a_of_type_Uif) + "\nprePlayTitle:" + a(this.b) + "\nPlayingHolder:" + this.jdField_a_of_type_Uif + "\nPrePlayHolder:" + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ucp
 * JD-Core Version:    0.7.0.1
 */