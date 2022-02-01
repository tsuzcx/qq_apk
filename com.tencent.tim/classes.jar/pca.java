import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
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

public class pca
  extends ryn
{
  FeedCloudMeta.StGPSV2 b;
  
  public pca(FeedCloudMeta.StGPSV2 paramStGPSV2)
  {
    this.b = paramStGPSV2;
  }
  
  public void a(ryt paramryt)
  {
    QCircleGetTabListRequest localQCircleGetTabListRequest = new QCircleGetTabListRequest(this.b);
    paramryt = new pcb(this, localQCircleGetTabListRequest, paramryt);
    localQCircleGetTabListRequest.setEnableCache(true);
    Object localObject = pcr.a().ma();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).getBytes();
      pcr.a().qz(null);
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
    VSNetworkHelper.a().a(localQCircleGetTabListRequest, paramryt);
    QLog.d("QCircleFolderPreLoaderTask", 1, "QCircleFolderPreLoaderTask->sendQCircleRequest: CmdName:" + localQCircleGetTabListRequest.getCmdName() + "| TraceId:" + localQCircleGetTabListRequest.getTraceId() + " | SeqId:" + localQCircleGetTabListRequest.getCurrentSeq());
  }
  
  public void onRemove() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pca
 * JD-Core Version:    0.7.0.1
 */