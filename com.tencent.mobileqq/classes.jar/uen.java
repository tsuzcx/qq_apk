import UserGrowth.stSimpleGetFeedListRsp;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import java.util.ArrayList;

class uen
  implements ukd
{
  uen(uem paramuem, WSRedDotPushMsg paramWSRedDotPushMsg) {}
  
  public void a(uko paramuko)
  {
    uem.a(this.jdField_a_of_type_Uem, false);
    if (paramuko == null) {
      uqf.d("WSRedDotPreloadManager", "WSRedDot preloadTask is null.");
    }
    do
    {
      return;
      uqf.b("WSRedDotPreloadManager", "onTaskResponse-resultCode:" + paramuko.b + " | resultBean:" + paramuko.jdField_a_of_type_JavaLangObject + " | thread:" + Thread.currentThread().getName());
      if (!paramuko.a())
      {
        uqf.d("WSRedDotPreloadManager", "WSRedDot preload request error. resultCode=" + paramuko.b);
        return;
      }
    } while (!(paramuko.jdField_a_of_type_Ukl instanceof uoy));
    Object localObject = (uoy)paramuko.jdField_a_of_type_Ukl;
    uqf.b("WSRedDotPreloadManager", "WSRedDot recommendRequest.mRequestId=" + ((uoy)localObject).b + ", mCurrentUniSeq=" + uem.a(this.jdField_a_of_type_Uem));
    if ((TextUtils.equals(((uoy)localObject).b, String.valueOf(uem.a(this.jdField_a_of_type_Uem)))) && ((paramuko.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp)) && (((stSimpleGetFeedListRsp)paramuko.jdField_a_of_type_JavaLangObject).feeds != null) && (((stSimpleGetFeedListRsp)paramuko.jdField_a_of_type_JavaLangObject).feeds.size() > 0))
    {
      localObject = (stSimpleGetFeedListRsp)paramuko.jdField_a_of_type_JavaLangObject;
      ArrayList localArrayList = ((stSimpleGetFeedListRsp)localObject).feeds;
      if (paramuko.jdField_a_of_type_Uke != null) {
        unu.a().a(((stSimpleGetFeedListRsp)localObject).trace_id, paramuko.jdField_a_of_type_Uke.a);
      }
      long l = uem.a(this.jdField_a_of_type_Uem, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg);
      uep.a().a(localArrayList, l);
      uem.b(this.jdField_a_of_type_Uem, false);
      return;
    }
    uqf.d("WSRedDotPreloadManager", "WSRedDot preloadList is empty. task.mResultBean=" + paramuko.jdField_a_of_type_JavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uen
 * JD-Core Version:    0.7.0.1
 */