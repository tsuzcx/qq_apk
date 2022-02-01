import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaGdtAdInfo;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class urc
  implements ula
{
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private urj jdField_a_of_type_Urj;
  
  public urc(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
  }
  
  private void a()
  {
    uuy localuuy = this.jdField_a_of_type_Urj.b();
    StringBuilder localStringBuilder = new StringBuilder().append("[WSPlayerStatusListenerImpl.java][prePlayVideo] videoItemHolder:").append(localuuy).append(", mPlayerParam:");
    if (localuuy != null) {}
    for (Object localObject = localuuy.jdField_a_of_type_Ukz;; localObject = "null")
    {
      uqf.e("WS_VIDEO_LISTENER", localObject);
      if ((localuuy != null) && (localuuy.jdField_a_of_type_Ukz != null))
      {
        uqf.e("WS_VIDEO_SCROLL", "[WSPlayerStatusListenerImpl.java][prePlayVideo] start prePlayView.");
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localuuy.jdField_a_of_type_Ukz);
      }
      return;
    }
  }
  
  public void a(WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
    if (paramWSVerticalPageFragment != null) {
      this.jdField_a_of_type_Urj = paramWSVerticalPageFragment.a();
    }
  }
  
  public void a(ukz paramukz) {}
  
  public void a(ukz paramukz, int paramInt)
  {
    boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.j();
    uqf.e("WS_VIDEO_LISTENER", "onVideoReplayOnLoop loopPlayMode:" + bool);
    if (!bool) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.f();
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramukz == null) || (paramukz.a == null) || (this.jdField_a_of_type_Urj == null) || (this.jdField_a_of_type_Urj.a() == null));
        localObject = this.jdField_a_of_type_Urj.a();
      } while ((localObject == null) || (((uuy)localObject).jdField_a_of_type_JavaLangObject == null) || (((usv)((uuy)localObject).jdField_a_of_type_JavaLangObject).a() == null) || (paramukz == null));
      localObject = ((usv)((uuy)localObject).jdField_a_of_type_JavaLangObject).a();
    } while (!(localObject instanceof stSimpleMetaFeed));
    uvt.a((stSimpleMetaFeed)localObject, paramukz, paramukz.a.c);
  }
  
  public void a(ukz paramukz, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(ukz paramukz, boolean paramBoolean)
  {
    uvv.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), paramukz, paramBoolean);
    uoi.a(paramukz, paramBoolean);
    if ((paramukz != null) && (this.jdField_a_of_type_Urj != null) && (this.jdField_a_of_type_Urj.a() != null))
    {
      Object localObject2 = this.jdField_a_of_type_Urj.a();
      if ((localObject2 != null) && (((uuy)localObject2).jdField_a_of_type_JavaLangObject != null) && (((usv)((uuy)localObject2).jdField_a_of_type_JavaLangObject).a() != null) && (paramukz != null))
      {
        Object localObject1 = ((usv)((uuy)localObject2).jdField_a_of_type_JavaLangObject).a();
        localObject2 = ((usv)((uuy)localObject2).jdField_a_of_type_JavaLangObject).a();
        if (((localObject1 instanceof stSimpleMetaFeed)) && (localObject2 != null) && (!((stSimpleMetaGdtAdInfo)localObject2).isGdtAdVidoReport)) {
          uvt.a((stSimpleMetaFeed)localObject1, paramukz);
        }
      }
    }
  }
  
  public void b(ukz paramukz)
  {
    a();
    uvv.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), paramukz);
    uhc.a().a();
  }
  
  public void c(ukz paramukz)
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.j()) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.f();
    }
  }
  
  public void d(ukz paramukz) {}
  
  public void e(ukz paramukz) {}
  
  public void f(ukz paramukz)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urc
 * JD-Core Version:    0.7.0.1
 */