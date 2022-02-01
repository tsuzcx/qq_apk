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

public class vss
  extends aadf
{
  FeedCloudMeta.StGPSV2 a;
  
  public vss(FeedCloudMeta.StGPSV2 paramStGPSV2)
  {
    this.a = paramStGPSV2;
  }
  
  public void a() {}
  
  public void a(aadl paramaadl)
  {
    QCircleGetTabListRequest localQCircleGetTabListRequest = new QCircleGetTabListRequest(this.a);
    paramaadl = new vst(this, localQCircleGetTabListRequest, paramaadl);
    localQCircleGetTabListRequest.setEnableCache(true);
    Object localObject = vtt.a().a();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).getBytes();
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
    VSNetworkHelper.a().a(localQCircleGetTabListRequest, paramaadl);
    QLog.d("QCircleFolderPreLoaderTask", 1, "QCircleFolderPreLoaderTask->sendQCircleRequest: CmdName:" + localQCircleGetTabListRequest.getCmdName() + "| TraceId:" + localQCircleGetTabListRequest.getTraceId() + " | SeqId:" + localQCircleGetTabListRequest.getCurrentSeq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vss
 * JD-Core Version:    0.7.0.1
 */