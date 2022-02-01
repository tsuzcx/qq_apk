import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequestException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class ulk
  implements Observable.OnSubscribe<ArrayList<stSimpleMetaFeed>>
{
  ulk(ulf paramulf, uju paramuju, long paramLong, boolean paramBoolean, WSRecommendFragment paramWSRecommendFragment) {}
  
  public void a(Subscriber<? super ArrayList<stSimpleMetaFeed>> paramSubscriber)
  {
    if (this.jdField_a_of_type_Uju.a())
    {
      if (((this.jdField_a_of_type_Uju.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp)) && (((stSimpleGetFeedListRsp)this.jdField_a_of_type_Uju.jdField_a_of_type_JavaLangObject).feeds != null) && (((stSimpleGetFeedListRsp)this.jdField_a_of_type_Uju.jdField_a_of_type_JavaLangObject).feeds.size() > 0))
      {
        Object localObject2 = this.jdField_a_of_type_Uju.jdField_a_of_type_Ujk;
        localObject1 = (stSimpleGetFeedListRsp)this.jdField_a_of_type_Uju.jdField_a_of_type_JavaLangObject;
        if (localObject2 != null)
        {
          upe.f("WSRecommendFragmentPresenter", "onLoadDataSuccess AbTestId = " + ((ujk)localObject2).jdField_a_of_type_JavaLangString);
          ugb.a().a(((stSimpleGetFeedListRsp)localObject1).trace_id, ((ujk)localObject2).jdField_a_of_type_JavaUtilMap);
        }
        ulf.b(this.jdField_a_of_type_Ulf, ((stSimpleGetFeedListRsp)localObject1).is_finished);
        this.jdField_a_of_type_Ulf.jdField_a_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
        upe.a("weishi-beacon", "请求瀑布流耗时：" + this.jdField_a_of_type_Ulf.jdField_a_of_type_Long + "毫秒");
        unb.a().a(true, this.jdField_a_of_type_Ulf.jdField_a_of_type_Long, "feeds", 1, "feeds", this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Boolean)
        {
          ugb.a().a(((stSimpleGetFeedListRsp)localObject1).config, "global_key_recommend");
          ugb.a().b(((stSimpleGetFeedListRsp)localObject1).config);
          unb.a().c(true, this.jdField_a_of_type_Ulf.jdField_a_of_type_Long);
        }
        ulf.a(this.jdField_a_of_type_Ulf, ((stSimpleGetFeedListRsp)this.jdField_a_of_type_Uju.jdField_a_of_type_JavaLangObject).attach_info);
        localObject2 = ((stSimpleGetFeedListRsp)localObject1).feeds;
        pnp.b((stSimpleMetaFeed)((ArrayList)localObject2).get(0));
        ups.a((List)localObject2);
        upe.b("WSRecommendFragmentPresenter", "size=" + ((ArrayList)localObject2).size());
        stSimpleMetaFeed localstSimpleMetaFeed = ulf.a(this.jdField_a_of_type_Ulf, (ArrayList)localObject2);
        upe.b("WSRecommendFragmentPresenter", "lastfeed desc:" + localstSimpleMetaFeed.feed_desc + ",videoUrl:" + localstSimpleMetaFeed.video_url);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment.getActivity() != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment.getActivity().isFinishing()))
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if (localQQAppInterface != null) {
            ((pnp)localQQAppInterface.getManager(274)).a(localstSimpleMetaFeed);
          }
        }
        ulf.d(((stSimpleGetFeedListRsp)localObject1).session);
        paramSubscriber.onNext(localObject2);
        return;
      }
      localObject1 = new WeishiRequestException();
      ((WeishiRequestException)localObject1).code = this.jdField_a_of_type_Uju.b;
      ((WeishiRequestException)localObject1).msg = anni.a(2131715673);
      paramSubscriber.onError((Throwable)localObject1);
      return;
    }
    Object localObject1 = new WeishiRequestException();
    ((WeishiRequestException)localObject1).code = this.jdField_a_of_type_Uju.jdField_a_of_type_Int;
    ((WeishiRequestException)localObject1).msg = this.jdField_a_of_type_Uju.jdField_a_of_type_JavaLangString;
    paramSubscriber.onError((Throwable)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulk
 * JD-Core Version:    0.7.0.1
 */