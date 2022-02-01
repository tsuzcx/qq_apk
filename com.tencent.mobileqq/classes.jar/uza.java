import UserGrowth.stSimpleGetFeedListRsp;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import java.util.ArrayList;

class uza
  implements vfg
{
  uza(uyz paramuyz, WSRedDotPushMsg paramWSRedDotPushMsg) {}
  
  public void a(vfr paramvfr)
  {
    uyz.a(this.jdField_a_of_type_Uyz, false);
    if (paramvfr == null) {
      vmp.d("WSRedDotPreloadManager", "WSRedDot preloadTask is null.");
    }
    do
    {
      return;
      vmp.b("WSRedDotPreloadManager", "onTaskResponse-resultCode:" + paramvfr.b + " | resultBean:" + paramvfr.jdField_a_of_type_JavaLangObject + " | thread:" + Thread.currentThread().getName());
      if (!paramvfr.a())
      {
        vmp.d("WSRedDotPreloadManager", "WSRedDot preload request error. resultCode=" + paramvfr.b);
        return;
      }
    } while (!(paramvfr.jdField_a_of_type_Vfo instanceof vli));
    Object localObject = (vli)paramvfr.jdField_a_of_type_Vfo;
    vmp.b("WSRedDotPreloadManager", "WSRedDot recommendRequest.mRequestId=" + ((vli)localObject).b + ", mCurrentUniSeq=" + uyz.a(this.jdField_a_of_type_Uyz));
    if ((TextUtils.equals(((vli)localObject).b, String.valueOf(uyz.a(this.jdField_a_of_type_Uyz)))) && ((paramvfr.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp)) && (((stSimpleGetFeedListRsp)paramvfr.jdField_a_of_type_JavaLangObject).feeds != null) && (((stSimpleGetFeedListRsp)paramvfr.jdField_a_of_type_JavaLangObject).feeds.size() > 0))
    {
      localObject = (stSimpleGetFeedListRsp)paramvfr.jdField_a_of_type_JavaLangObject;
      ArrayList localArrayList = ((stSimpleGetFeedListRsp)localObject).feeds;
      if (paramvfr.jdField_a_of_type_Vfh != null) {
        vkc.a().a(((stSimpleGetFeedListRsp)localObject).trace_id, paramvfr.jdField_a_of_type_Vfh.a);
      }
      long l = uyz.a(this.jdField_a_of_type_Uyz, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg);
      uzf.a().a(localArrayList, l);
      uyz.b(this.jdField_a_of_type_Uyz, false);
      return;
    }
    vmp.d("WSRedDotPreloadManager", "WSRedDot preloadList is empty. task.mResultBean=" + paramvfr.jdField_a_of_type_JavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uza
 * JD-Core Version:    0.7.0.1
 */