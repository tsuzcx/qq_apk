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

class umi
  implements Observable.OnSubscribe<ArrayList<stSimpleMetaFeed>>
{
  umi(umd paramumd, uko paramuko, long paramLong, boolean paramBoolean, WSRecommendFragment paramWSRecommendFragment) {}
  
  public void a(Subscriber<? super ArrayList<stSimpleMetaFeed>> paramSubscriber)
  {
    if (this.jdField_a_of_type_Uko.a())
    {
      if (((this.jdField_a_of_type_Uko.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp)) && (((stSimpleGetFeedListRsp)this.jdField_a_of_type_Uko.jdField_a_of_type_JavaLangObject).feeds != null) && (((stSimpleGetFeedListRsp)this.jdField_a_of_type_Uko.jdField_a_of_type_JavaLangObject).feeds.size() > 0))
      {
        Object localObject2 = this.jdField_a_of_type_Uko.jdField_a_of_type_Uke;
        localObject1 = (stSimpleGetFeedListRsp)this.jdField_a_of_type_Uko.jdField_a_of_type_JavaLangObject;
        if (localObject2 != null)
        {
          uqf.f("WSRecommendFragmentPresenter", "onLoadDataSuccess AbTestId = " + ((uke)localObject2).jdField_a_of_type_JavaLangString);
          unu.a().a(((stSimpleGetFeedListRsp)localObject1).trace_id, ((uke)localObject2).jdField_a_of_type_JavaUtilMap);
        }
        umd.b(this.jdField_a_of_type_Umd, ((stSimpleGetFeedListRsp)localObject1).is_finished);
        this.jdField_a_of_type_Umd.jdField_a_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
        uqf.a("weishi-beacon", "请求瀑布流耗时：" + this.jdField_a_of_type_Umd.jdField_a_of_type_Long + "毫秒");
        uoc.a().a(true, this.jdField_a_of_type_Umd.jdField_a_of_type_Long, "feeds", 1, "feeds", this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Boolean)
        {
          ugd.a().a(1, ((stSimpleGetFeedListRsp)localObject1).config);
          ugd.a().b(((stSimpleGetFeedListRsp)localObject1).config);
          uoc.a().c(true, this.jdField_a_of_type_Umd.jdField_a_of_type_Long);
        }
        umd.a(this.jdField_a_of_type_Umd, ((stSimpleGetFeedListRsp)this.jdField_a_of_type_Uko.jdField_a_of_type_JavaLangObject).attach_info);
        localObject2 = ((stSimpleGetFeedListRsp)localObject1).feeds;
        pgj.b((stSimpleMetaFeed)((ArrayList)localObject2).get(0));
        uqt.a((List)localObject2);
        uqf.b("WSRecommendFragmentPresenter", "size=" + ((ArrayList)localObject2).size());
        stSimpleMetaFeed localstSimpleMetaFeed = umd.a(this.jdField_a_of_type_Umd, (ArrayList)localObject2);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment.getActivity() != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment.getActivity().isFinishing()))
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if (localQQAppInterface != null) {
            ((pgj)localQQAppInterface.getManager(274)).a(localstSimpleMetaFeed);
          }
        }
        umd.d(((stSimpleGetFeedListRsp)localObject1).session);
        paramSubscriber.onNext(localObject2);
        return;
      }
      localObject1 = new WeishiRequestException();
      ((WeishiRequestException)localObject1).code = this.jdField_a_of_type_Uko.b;
      ((WeishiRequestException)localObject1).msg = anzj.a(2131715782);
      paramSubscriber.onError((Throwable)localObject1);
      return;
    }
    Object localObject1 = new WeishiRequestException();
    ((WeishiRequestException)localObject1).code = this.jdField_a_of_type_Uko.jdField_a_of_type_Int;
    ((WeishiRequestException)localObject1).msg = this.jdField_a_of_type_Uko.jdField_a_of_type_JavaLangString;
    paramSubscriber.onError((Throwable)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umi
 * JD-Core Version:    0.7.0.1
 */