import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import feedcloud.FeedCloudTagcategorysvr.StTagCategoryRecomRsp;

class avrh
  implements rxc.a<FeedCloudTagcategorysvr.StTagCategoryRecomRsp>
{
  avrh(avre paramavre, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudTagcategorysvr.StTagCategoryRecomRsp paramStTagCategoryRecomRsp)
  {
    QLog.i("[QzoneIPCModule_upload2]QCircle", 1, "ACTION_QCIRCLE_PULISH_FEED onReceive isSuccess:" + paramBoolean + " retCode:" + paramLong + " errMsg:" + paramString);
    if ((paramBoolean) && (paramLong == 0L) && (paramStTagCategoryRecomRsp != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("key_return_code", paramLong);
      localBundle.putString("key_error_msg", paramString);
      localBundle.putByteArray("key_qcircle_tag_list_rsp", paramStTagCategoryRecomRsp.toByteArray());
      this.b.callbackResult(this.val$callbackId, EIPCResult.createResult(0, localBundle));
      return;
    }
    paramStTagCategoryRecomRsp = new Bundle();
    paramStTagCategoryRecomRsp.putLong("key_return_code", paramLong);
    paramStTagCategoryRecomRsp.putString("key_error_msg", paramString);
    this.b.callbackResult(this.val$callbackId, EIPCResult.createResult(-102, paramStTagCategoryRecomRsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avrh
 * JD-Core Version:    0.7.0.1
 */