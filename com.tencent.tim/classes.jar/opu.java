import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class opu
  implements olf
{
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private oqb jdField_a_of_type_Oqb;
  private WSVerticalPageFragment b;
  
  public opu(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
  }
  
  public void a(WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    this.b = paramWSVerticalPageFragment;
    if (paramWSVerticalPageFragment != null) {
      this.jdField_a_of_type_Oqb = paramWSVerticalPageFragment.a();
    }
  }
  
  public void a(ole paramole, int paramInt) {}
  
  public void d(ole paramole)
  {
    osf localosf = this.jdField_a_of_type_Oqb.b();
    StringBuilder localStringBuilder = new StringBuilder().append("[WSPlayerStatusListenerImpl.java][onVideoStart] videoItemHolder:").append(localosf).append(", mPlayerParam:");
    if (localosf != null) {}
    for (Object localObject = localosf.b;; localObject = "null")
    {
      ooz.bY("WS_VIDEO_LISTENER", localObject);
      if ((localosf != null) && (localosf.b != null))
      {
        ooz.bY("WS_VIDEO_SCROLL", "[WSPlayerStatusListenerImpl.java][onVideoStart] start prePlayView.");
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.k(localosf.b);
      }
      osv.a(this.b.getFrom(), this.b.getPlayScene(), paramole);
      return;
    }
  }
  
  public void e(ole paramole) {}
  
  public void f(ole paramole) {}
  
  public void g(ole paramole, boolean paramBoolean)
  {
    osv.a(this.b.getFrom(), this.b.getPlayScene(), paramole, paramBoolean);
  }
  
  public void m(ole paramole) {}
  
  public void n(ole paramole)
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.Ha()) {
      this.b.Jw();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     opu
 * JD-Core Version:    0.7.0.1
 */