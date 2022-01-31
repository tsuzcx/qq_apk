import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class tmd
  implements thm
{
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private tmf jdField_a_of_type_Tmf;
  
  public tmd(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
  }
  
  public void a(WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
    if (paramWSVerticalPageFragment != null) {
      this.jdField_a_of_type_Tmf = paramWSVerticalPageFragment.a();
    }
  }
  
  public void a(thl paramthl) {}
  
  public void a(thl paramthl, int paramInt) {}
  
  public void a(thl paramthl, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(thl paramthl, boolean paramBoolean)
  {
    tnt.a(paramthl, paramBoolean);
  }
  
  public void b(thl paramthl)
  {
    tnj localtnj = this.jdField_a_of_type_Tmf.b();
    StringBuilder localStringBuilder = new StringBuilder().append("[WSPlayerStatusListenerImpl.java][onVideoStart] videoItemHolder:").append(localtnj).append(", mPlayerParam:");
    if (localtnj != null) {}
    for (Object localObject = localtnj.a;; localObject = "null")
    {
      tlo.e("WS_VIDEO_LISTENER", localObject);
      if ((localtnj != null) && (localtnj.a != null))
      {
        tlo.e("WS_VIDEO_SCROLL", "[WSPlayerStatusListenerImpl.java][onVideoStart] start prePlayView.");
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localtnj.a);
      }
      tnt.a(paramthl);
      return;
    }
  }
  
  public void c(thl paramthl)
  {
    paramthl = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
    if (paramthl != null) {
      paramthl.a();
    }
  }
  
  public void d(thl paramthl) {}
  
  public void e(thl paramthl) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tmd
 * JD-Core Version:    0.7.0.1
 */