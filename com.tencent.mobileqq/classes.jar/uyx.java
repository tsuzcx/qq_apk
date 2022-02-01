import UserGrowth.stSimpleMetaGdtAdInfo;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class uyx
  implements uru
{
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private uze jdField_a_of_type_Uze;
  
  public uyx(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
  }
  
  private void a()
  {
    vct localvct = this.jdField_a_of_type_Uze.b();
    StringBuilder localStringBuilder = new StringBuilder().append("[WSPlayerStatusListenerImpl.java][prePlayVideo] videoItemHolder:").append(localvct).append(", mPlayerParam:");
    if (localvct != null) {}
    for (Object localObject = localvct.jdField_a_of_type_Urt;; localObject = "null")
    {
      uya.e("WS_VIDEO_LISTENER", localObject);
      if ((localvct != null) && (localvct.jdField_a_of_type_Urt != null))
      {
        uya.e("WS_VIDEO_SCROLL", "[WSPlayerStatusListenerImpl.java][prePlayVideo] start prePlayView.");
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localvct.jdField_a_of_type_Urt);
      }
      return;
    }
  }
  
  public void a(WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
    if (paramWSVerticalPageFragment != null) {
      this.jdField_a_of_type_Uze = paramWSVerticalPageFragment.a();
    }
  }
  
  public void a(urt paramurt) {}
  
  public void a(urt paramurt, int paramInt)
  {
    boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.j();
    uya.e("WS_VIDEO_LISTENER", "onVideoReplayOnLoop loopPlayMode:" + bool);
    if (!bool) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.f();
    }
    vct localvct;
    do
    {
      do
      {
        return;
      } while ((paramurt == null) || (paramurt.a == null) || (this.jdField_a_of_type_Uze == null) || (this.jdField_a_of_type_Uze.a() == null));
      localvct = this.jdField_a_of_type_Uze.a();
    } while ((localvct == null) || (localvct.jdField_a_of_type_JavaLangObject == null) || (((vaq)localvct.jdField_a_of_type_JavaLangObject).a() == null) || (paramurt == null));
    vdo.a((vaq)localvct.jdField_a_of_type_JavaLangObject, paramurt);
  }
  
  public void a(urt paramurt, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(urt paramurt, boolean paramBoolean)
  {
    vdq.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), paramurt, paramBoolean);
    uwc.a(paramurt, paramBoolean);
    if ((paramurt != null) && (this.jdField_a_of_type_Uze != null) && (this.jdField_a_of_type_Uze.a() != null))
    {
      vct localvct = this.jdField_a_of_type_Uze.a();
      if ((localvct != null) && (localvct.jdField_a_of_type_JavaLangObject != null) && (((vaq)localvct.jdField_a_of_type_JavaLangObject).a() != null) && (paramurt != null))
      {
        stSimpleMetaGdtAdInfo localstSimpleMetaGdtAdInfo = ((vaq)localvct.jdField_a_of_type_JavaLangObject).a();
        if ((localstSimpleMetaGdtAdInfo != null) && (!localstSimpleMetaGdtAdInfo.isGdtAdVidoReport)) {
          vdo.a((vaq)localvct.jdField_a_of_type_JavaLangObject, paramurt, 2);
        }
      }
    }
  }
  
  public void b(urt paramurt)
  {
    a();
    vdq.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), paramurt);
    unt.a().a();
  }
  
  public void c(urt paramurt)
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.j()) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.f();
    }
  }
  
  public void d(urt paramurt) {}
  
  public void e(urt paramurt) {}
  
  public void f(urt paramurt)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyx
 * JD-Core Version:    0.7.0.1
 */