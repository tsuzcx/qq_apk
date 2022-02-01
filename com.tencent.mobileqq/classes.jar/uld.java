import UserGrowth.stSimpleGetFeedListRsp;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import java.util.ArrayList;

class uld
  implements uqy
{
  uld(ulc paramulc, WSRedDotPushMsg paramWSRedDotPushMsg) {}
  
  public void a(urj paramurj)
  {
    ulc.a(this.jdField_a_of_type_Ulc, false);
    if (paramurj == null) {
      uya.d("WSRedDotPreloadManager", "WSRedDot preloadTask is null.");
    }
    do
    {
      return;
      uya.b("WSRedDotPreloadManager", "onTaskResponse-resultCode:" + paramurj.b + " | resultBean:" + paramurj.jdField_a_of_type_JavaLangObject + " | thread:" + Thread.currentThread().getName());
      if (!paramurj.a())
      {
        uya.d("WSRedDotPreloadManager", "WSRedDot preload request error. resultCode=" + paramurj.b);
        return;
      }
    } while (!(paramurj.jdField_a_of_type_Urg instanceof uwt));
    Object localObject = (uwt)paramurj.jdField_a_of_type_Urg;
    uya.b("WSRedDotPreloadManager", "WSRedDot recommendRequest.mRequestId=" + ((uwt)localObject).b + ", mCurrentUniSeq=" + ulc.a(this.jdField_a_of_type_Ulc));
    if ((TextUtils.equals(((uwt)localObject).b, String.valueOf(ulc.a(this.jdField_a_of_type_Ulc)))) && ((paramurj.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp)) && (((stSimpleGetFeedListRsp)paramurj.jdField_a_of_type_JavaLangObject).feeds != null) && (((stSimpleGetFeedListRsp)paramurj.jdField_a_of_type_JavaLangObject).feeds.size() > 0))
    {
      localObject = (stSimpleGetFeedListRsp)paramurj.jdField_a_of_type_JavaLangObject;
      ArrayList localArrayList = ((stSimpleGetFeedListRsp)localObject).feeds;
      if (paramurj.jdField_a_of_type_Uqz != null) {
        uvo.a().a(((stSimpleGetFeedListRsp)localObject).trace_id, paramurj.jdField_a_of_type_Uqz.a);
      }
      long l = ulc.a(this.jdField_a_of_type_Ulc, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg);
      ulf.a().a(localArrayList, l);
      ulc.b(this.jdField_a_of_type_Ulc, false);
      return;
    }
    uya.d("WSRedDotPreloadManager", "WSRedDot preloadList is empty. task.mResultBean=" + paramurj.jdField_a_of_type_JavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uld
 * JD-Core Version:    0.7.0.1
 */