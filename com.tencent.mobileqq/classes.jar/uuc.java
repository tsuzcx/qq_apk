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

class uuc
  implements Observable.OnSubscribe<ArrayList<stSimpleMetaFeed>>
{
  uuc(utx paramutx, urj paramurj, long paramLong, boolean paramBoolean, WSRecommendFragment paramWSRecommendFragment) {}
  
  public void a(Subscriber<? super ArrayList<stSimpleMetaFeed>> paramSubscriber)
  {
    if (this.jdField_a_of_type_Urj.a())
    {
      if (((this.jdField_a_of_type_Urj.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp)) && (((stSimpleGetFeedListRsp)this.jdField_a_of_type_Urj.jdField_a_of_type_JavaLangObject).feeds != null) && (((stSimpleGetFeedListRsp)this.jdField_a_of_type_Urj.jdField_a_of_type_JavaLangObject).feeds.size() > 0))
      {
        Object localObject2 = this.jdField_a_of_type_Urj.jdField_a_of_type_Uqz;
        localObject1 = (stSimpleGetFeedListRsp)this.jdField_a_of_type_Urj.jdField_a_of_type_JavaLangObject;
        if (localObject2 != null)
        {
          uya.f("WSRecommendFragmentPresenter", "onLoadDataSuccess AbTestId = " + ((uqz)localObject2).jdField_a_of_type_JavaLangString);
          uvo.a().a(((stSimpleGetFeedListRsp)localObject1).trace_id, ((uqz)localObject2).jdField_a_of_type_JavaUtilMap);
        }
        utx.b(this.jdField_a_of_type_Utx, ((stSimpleGetFeedListRsp)localObject1).is_finished);
        this.jdField_a_of_type_Utx.jdField_a_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
        uya.a("weishi-beacon", "请求瀑布流耗时：" + this.jdField_a_of_type_Utx.jdField_a_of_type_Long + "毫秒");
        uvw.a().a(this.jdField_a_of_type_Utx.jdField_a_of_type_Long, this.jdField_a_of_type_Urj.jdField_a_of_type_Urg, "feeds", this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Boolean)
        {
          umu.a().a(1, ((stSimpleGetFeedListRsp)localObject1).config);
          umu.a().b(((stSimpleGetFeedListRsp)localObject1).config);
          uvw.a().c(true, this.jdField_a_of_type_Utx.jdField_a_of_type_Long);
        }
        utx.a(this.jdField_a_of_type_Utx, ((stSimpleGetFeedListRsp)this.jdField_a_of_type_Urj.jdField_a_of_type_JavaLangObject).attach_info);
        localObject2 = ((stSimpleGetFeedListRsp)localObject1).feeds;
        plv.b((stSimpleMetaFeed)((ArrayList)localObject2).get(0));
        uyo.a((List)localObject2);
        uya.b("WSRecommendFragmentPresenter", "size=" + ((ArrayList)localObject2).size());
        stSimpleMetaFeed localstSimpleMetaFeed = utx.a(this.jdField_a_of_type_Utx, (ArrayList)localObject2);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment.getActivity() != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment.getActivity().isFinishing()))
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if (localQQAppInterface != null) {
            ((plv)localQQAppInterface.getManager(274)).a(localstSimpleMetaFeed);
          }
        }
        utx.d(((stSimpleGetFeedListRsp)localObject1).session);
        paramSubscriber.onNext(localObject2);
        return;
      }
      localObject1 = new WeishiRequestException();
      ((WeishiRequestException)localObject1).code = this.jdField_a_of_type_Urj.b;
      ((WeishiRequestException)localObject1).msg = amtj.a(2131716016);
      paramSubscriber.onError((Throwable)localObject1);
      uvw.a().a(this.jdField_a_of_type_Utx.jdField_a_of_type_Long, this.jdField_a_of_type_Urj.jdField_a_of_type_Urg, -1, "数据无法解析或为空");
      return;
    }
    Object localObject1 = new WeishiRequestException();
    ((WeishiRequestException)localObject1).code = this.jdField_a_of_type_Urj.jdField_a_of_type_Int;
    ((WeishiRequestException)localObject1).msg = this.jdField_a_of_type_Urj.jdField_a_of_type_JavaLangString;
    paramSubscriber.onError((Throwable)localObject1);
    uvw.a().a(this.jdField_a_of_type_Utx.jdField_a_of_type_Long, this.jdField_a_of_type_Urj.jdField_a_of_type_Urg, this.jdField_a_of_type_Urj.jdField_a_of_type_Int, this.jdField_a_of_type_Urj.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uuc
 * JD-Core Version:    0.7.0.1
 */