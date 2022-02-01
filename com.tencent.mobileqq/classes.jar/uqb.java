import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaGdtAdInfo;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class uqb
  implements ukc
{
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private uqi jdField_a_of_type_Uqi;
  
  public uqb(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
  }
  
  private void a()
  {
    utw localutw = this.jdField_a_of_type_Uqi.b();
    StringBuilder localStringBuilder = new StringBuilder().append("[WSPlayerStatusListenerImpl.java][prePlayVideo] videoItemHolder:").append(localutw).append(", mPlayerParam:");
    if (localutw != null) {}
    for (Object localObject = localutw.jdField_a_of_type_Ukb;; localObject = "null")
    {
      upe.e("WS_VIDEO_LISTENER", localObject);
      if ((localutw != null) && (localutw.jdField_a_of_type_Ukb != null))
      {
        upe.e("WS_VIDEO_SCROLL", "[WSPlayerStatusListenerImpl.java][prePlayVideo] start prePlayView.");
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localutw.jdField_a_of_type_Ukb);
      }
      return;
    }
  }
  
  public void a(WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
    if (paramWSVerticalPageFragment != null) {
      this.jdField_a_of_type_Uqi = paramWSVerticalPageFragment.a();
    }
  }
  
  public void a(ukb paramukb) {}
  
  public void a(ukb paramukb, int paramInt)
  {
    boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.i();
    upe.e("WS_VIDEO_LISTENER", "onVideoReplayOnLoop loopPlayMode:" + bool);
    if (!bool) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.g();
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramukb == null) || (paramukb.a == null) || (this.jdField_a_of_type_Uqi == null) || (this.jdField_a_of_type_Uqi.a() == null));
        localObject = this.jdField_a_of_type_Uqi.a();
      } while ((localObject == null) || (((utw)localObject).jdField_a_of_type_JavaLangObject == null) || (((uru)((utw)localObject).jdField_a_of_type_JavaLangObject).a() == null) || (paramukb == null));
      localObject = ((uru)((utw)localObject).jdField_a_of_type_JavaLangObject).a();
    } while (!(localObject instanceof stSimpleMetaFeed));
    uur.a((stSimpleMetaFeed)localObject, paramukb, paramukb.a.c);
  }
  
  public void a(ukb paramukb, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(ukb paramukb, boolean paramBoolean)
  {
    uut.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), paramukb, paramBoolean);
    unh.a(paramukb, paramBoolean);
    if ((paramukb != null) && (this.jdField_a_of_type_Uqi != null) && (this.jdField_a_of_type_Uqi.a() != null))
    {
      Object localObject2 = this.jdField_a_of_type_Uqi.a();
      if ((localObject2 != null) && (((utw)localObject2).jdField_a_of_type_JavaLangObject != null) && (((uru)((utw)localObject2).jdField_a_of_type_JavaLangObject).a() != null) && (paramukb != null))
      {
        Object localObject1 = ((uru)((utw)localObject2).jdField_a_of_type_JavaLangObject).a();
        localObject2 = ((uru)((utw)localObject2).jdField_a_of_type_JavaLangObject).a();
        if (((localObject1 instanceof stSimpleMetaFeed)) && (localObject2 != null) && (!((stSimpleMetaGdtAdInfo)localObject2).isGdtAdVidoReport)) {
          uur.a((stSimpleMetaFeed)localObject1, paramukb);
        }
      }
    }
  }
  
  public void b(ukb paramukb)
  {
    a();
    uut.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), paramukb);
    uha.a().a();
  }
  
  public void c(ukb paramukb)
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.i()) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.g();
    }
  }
  
  public void d(ukb paramukb) {}
  
  public void e(ukb paramukb) {}
  
  public void f(ukb paramukb)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqb
 * JD-Core Version:    0.7.0.1
 */