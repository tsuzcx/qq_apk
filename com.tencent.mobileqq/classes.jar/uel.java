import UserGrowth.stSimpleGetFeedListRsp;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import java.util.ArrayList;

class uel
  implements ujj
{
  uel(uek paramuek, WSRedDotPushMsg paramWSRedDotPushMsg) {}
  
  public void a(uju paramuju)
  {
    uek.a(this.jdField_a_of_type_Uek, false);
    if (paramuju == null) {
      upe.d("WSRedDotPreloadManager", "WSRedDot preloadTask is null.");
    }
    do
    {
      return;
      upe.b("WSRedDotPreloadManager", "onTaskResponse-resultCode:" + paramuju.b + " | resultBean:" + paramuju.jdField_a_of_type_JavaLangObject + " | thread:" + Thread.currentThread().getName());
      if (!paramuju.a())
      {
        upe.d("WSRedDotPreloadManager", "WSRedDot preload request error. resultCode=" + paramuju.b);
        return;
      }
    } while (!(paramuju.jdField_a_of_type_Ujr instanceof unx));
    Object localObject = (unx)paramuju.jdField_a_of_type_Ujr;
    upe.b("WSRedDotPreloadManager", "WSRedDot recommendRequest.mRequestId=" + ((unx)localObject).b + ", mCurrentUniSeq=" + uek.a(this.jdField_a_of_type_Uek));
    if ((TextUtils.equals(((unx)localObject).b, String.valueOf(uek.a(this.jdField_a_of_type_Uek)))) && ((paramuju.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp)) && (((stSimpleGetFeedListRsp)paramuju.jdField_a_of_type_JavaLangObject).feeds != null) && (((stSimpleGetFeedListRsp)paramuju.jdField_a_of_type_JavaLangObject).feeds.size() > 0))
    {
      localObject = (stSimpleGetFeedListRsp)paramuju.jdField_a_of_type_JavaLangObject;
      ArrayList localArrayList = ((stSimpleGetFeedListRsp)localObject).feeds;
      if (paramuju.jdField_a_of_type_Ujk != null) {
        ugb.a().a(((stSimpleGetFeedListRsp)localObject).trace_id, paramuju.jdField_a_of_type_Ujk.a);
      }
      long l = uek.a(this.jdField_a_of_type_Uek, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg);
      uen.a().a(localArrayList, l);
      uek.b(this.jdField_a_of_type_Uek, false);
      return;
    }
    upe.d("WSRedDotPreloadManager", "WSRedDot preloadList is empty. task.mResultBean=" + paramuju.jdField_a_of_type_JavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uel
 * JD-Core Version:    0.7.0.1
 */