import UserGrowth.stSimpleGetFeedListRsp;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import java.util.ArrayList;

class ogq
  implements oko
{
  ogq(ogp paramogp, WSRedDotPushMsg paramWSRedDotPushMsg) {}
  
  public void a(okz paramokz)
  {
    ogp.a(this.this$0, false);
    if (paramokz == null) {
      ooz.e("WSRedDotPreloadManager", "WSRedDot preloadTask is null.");
    }
    do
    {
      return;
      ooz.d("WSRedDotPreloadManager", "onTaskResponse-resultCode:" + paramokz.mResultCode + " | resultBean:" + paramokz.bb + " | thread:" + Thread.currentThread().getName());
      if (!paramokz.succeeded())
      {
        ooz.e("WSRedDotPreloadManager", "WSRedDot preload request error. resultCode=" + paramokz.mResultCode);
        return;
      }
    } while (!(paramokz.jdField_a_of_type_Okw instanceof onz));
    Object localObject = (onz)paramokz.jdField_a_of_type_Okw;
    ooz.d("WSRedDotPreloadManager", "WSRedDot recommendRequest.mRequestId=" + ((onz)localObject).mRequestId + ", mCurrentUniSeq=" + ogp.a(this.this$0));
    if ((TextUtils.equals(((onz)localObject).mRequestId, String.valueOf(ogp.a(this.this$0)))) && ((paramokz.bb instanceof stSimpleGetFeedListRsp)) && (((stSimpleGetFeedListRsp)paramokz.bb).feeds != null) && (((stSimpleGetFeedListRsp)paramokz.bb).feeds.size() > 0))
    {
      localObject = (stSimpleGetFeedListRsp)paramokz.bb;
      ArrayList localArrayList = ((stSimpleGetFeedListRsp)localObject).feeds;
      if (paramokz.jdField_a_of_type_Okp != null) {
        ohy.a().f(((stSimpleGetFeedListRsp)localObject).trace_id, paramokz.jdField_a_of_type_Okp.mapExt);
      }
      long l = ogp.a(this.this$0, this.c);
      ogr.a().c(localArrayList, l);
      ogp.b(this.this$0, false);
      return;
    }
    ooz.e("WSRedDotPreloadManager", "WSRedDot preloadList is empty. task.mResultBean=" + paramokz.bb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ogq
 * JD-Core Version:    0.7.0.1
 */