import UserGrowth.stSimpleMetaGdtAdInfo;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class vnp
  implements vgc
{
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private vnw jdField_a_of_type_Vnw;
  
  public vnp(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
  }
  
  private void a()
  {
    vrn localvrn = this.jdField_a_of_type_Vnw.b();
    StringBuilder localStringBuilder = new StringBuilder().append("[WSPlayerStatusListenerImpl.java][prePlayVideo] videoItemHolder:").append(localvrn).append(", mPlayerParam:");
    if (localvrn != null) {}
    for (Object localObject = localvrn.jdField_a_of_type_Vgb;; localObject = "null")
    {
      vmp.e("WS_VIDEO_LISTENER", localObject);
      if ((localvrn != null) && (localvrn.jdField_a_of_type_Vgb != null))
      {
        vmp.e("WS_VIDEO_SCROLL", "[WSPlayerStatusListenerImpl.java][prePlayVideo] start prePlayView.");
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localvrn.jdField_a_of_type_Vgb);
      }
      return;
    }
  }
  
  public void a(WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
    if (paramWSVerticalPageFragment != null) {
      this.jdField_a_of_type_Vnw = paramWSVerticalPageFragment.a();
    }
  }
  
  public void a(vgb paramvgb) {}
  
  public void a(vgb paramvgb, int paramInt)
  {
    boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.j();
    vmp.e("WS_VIDEO_LISTENER", "onVideoReplayOnLoop loopPlayMode:" + bool);
    if (!bool) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.f();
    }
    vrn localvrn;
    do
    {
      do
      {
        return;
      } while ((paramvgb == null) || (paramvgb.a == null) || (this.jdField_a_of_type_Vnw == null) || (this.jdField_a_of_type_Vnw.a() == null));
      localvrn = this.jdField_a_of_type_Vnw.a();
    } while ((localvrn == null) || (localvrn.jdField_a_of_type_JavaLangObject == null) || (((vpj)localvrn.jdField_a_of_type_JavaLangObject).a() == null) || (paramvgb == null));
    vsh.a((vpj)localvrn.jdField_a_of_type_JavaLangObject, paramvgb);
  }
  
  public void a(vgb paramvgb, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(vgb paramvgb, boolean paramBoolean)
  {
    vsj.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), paramvgb, paramBoolean);
    vkq.a(paramvgb, paramBoolean);
    if ((paramvgb != null) && (this.jdField_a_of_type_Vnw != null) && (this.jdField_a_of_type_Vnw.a() != null))
    {
      vrn localvrn = this.jdField_a_of_type_Vnw.a();
      if ((localvrn != null) && (localvrn.jdField_a_of_type_JavaLangObject != null) && (((vpj)localvrn.jdField_a_of_type_JavaLangObject).a() != null) && (paramvgb != null))
      {
        stSimpleMetaGdtAdInfo localstSimpleMetaGdtAdInfo = ((vpj)localvrn.jdField_a_of_type_JavaLangObject).a();
        if ((localstSimpleMetaGdtAdInfo != null) && (!localstSimpleMetaGdtAdInfo.isGdtAdVidoReport)) {
          vsh.a((vpj)localvrn.jdField_a_of_type_JavaLangObject, paramvgb, 2);
        }
      }
    }
  }
  
  public void b(vgb paramvgb)
  {
    a();
    vsj.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), paramvgb);
    vbt.a().a();
  }
  
  public void c(vgb paramvgb)
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.j()) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.f();
    }
  }
  
  public void d(vgb paramvgb) {}
  
  public void e(vgb paramvgb) {}
  
  public void f(vgb paramvgb)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnp
 * JD-Core Version:    0.7.0.1
 */