import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudRead.StGetBusiInfoReq;
import java.util.ArrayList;

public class tzf
  extends yka
{
  FeedCloudMeta.StGPSV2 a;
  
  public tzf(FeedCloudMeta.StGPSV2 paramStGPSV2)
  {
    this.a = paramStGPSV2;
  }
  
  public void a() {}
  
  public void a(ykg paramykg)
  {
    QCircleGetTabListRequest localQCircleGetTabListRequest = new QCircleGetTabListRequest(this.a);
    paramykg = new tzg(this, localQCircleGetTabListRequest, paramykg);
    localQCircleGetTabListRequest.setEnableCache(true);
    Object localObject = tzy.a().a();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).getBytes();
      tzy.a().a(null);
      FeedCloudCommon.StCommonExt localStCommonExt = new FeedCloudCommon.StCommonExt();
      ArrayList localArrayList = new ArrayList();
      if (localObject != null)
      {
        FeedCloudCommon.BytesEntry localBytesEntry = new FeedCloudCommon.BytesEntry();
        localBytesEntry.key.set("circle_invite");
        localBytesEntry.value.set(ByteStringMicro.copyFrom((byte[])localObject));
        localArrayList.add(localBytesEntry);
        localStCommonExt.mapBytesInfo.set(localArrayList);
        if (localQCircleGetTabListRequest.mReq != null) {
          localQCircleGetTabListRequest.mReq.extInfo.set(localStCommonExt);
        }
      }
    }
    VSNetworkHelper.a().a(localQCircleGetTabListRequest, paramykg);
    QLog.d("QCircleFolderPreLoaderTask", 1, "QCircleFolderPreLoaderTask->sendQCircleRequest: CmdName:" + localQCircleGetTabListRequest.getCmdName() + "| TraceId:" + localQCircleGetTabListRequest.getTraceId() + " | SeqId:" + localQCircleGetTabListRequest.getCurrentSeq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tzf
 * JD-Core Version:    0.7.0.1
 */