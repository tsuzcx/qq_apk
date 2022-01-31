import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudRead.StGetBusiInfoReq;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StBusiInfoData;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class tzi
  extends tyz
{
  private MutableLiveData<tzm<List<QQCircleFeedBase.StTabInfo>>> a = new MutableLiveData();
  
  public MutableLiveData<tzm<List<QQCircleFeedBase.StTabInfo>>> a()
  {
    return this.a;
  }
  
  public void a(FeedCloudMeta.StGPSV2 paramStGPSV2)
  {
    paramStGPSV2 = new QCircleGetTabListRequest(paramStGPSV2);
    paramStGPSV2.setEnableCache(true);
    Object localObject = tym.a().a();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).getBytes();
      tym.a().a(null);
      FeedCloudCommon.StCommonExt localStCommonExt = new FeedCloudCommon.StCommonExt();
      ArrayList localArrayList = new ArrayList();
      if (localObject != null)
      {
        FeedCloudCommon.BytesEntry localBytesEntry = new FeedCloudCommon.BytesEntry();
        localBytesEntry.key.set("circle_invite");
        localBytesEntry.value.set(ByteStringMicro.copyFrom((byte[])localObject));
        localArrayList.add(localBytesEntry);
        localStCommonExt.mapBytesInfo.set(localArrayList);
        if (paramStGPSV2.mReq != null) {
          paramStGPSV2.mReq.extInfo.set(localStCommonExt);
        }
      }
    }
    this.a.setValue(tzm.b());
    a(paramStGPSV2, new tzj(this, paramStGPSV2));
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetBusiInfoRsp paramStGetBusiInfoRsp)
  {
    boolean bool = VSNetworkHelper.a(paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetBusiInfoRsp == null))
    {
      this.a.setValue(tzm.a(paramString));
      return;
    }
    paramString = new QQCircleFeedBase.StBusiInfoData();
    paramStGetBusiInfoRsp = paramStGetBusiInfoRsp.busiRspData.get().toByteArray();
    for (;;)
    {
      try
      {
        paramString.mergeFrom(paramStGetBusiInfoRsp);
        tpz.a().a(paramStGetBusiInfoRsp);
        paramStGetBusiInfoRsp = paramString.tabInfos.get();
        if (paramStGetBusiInfoRsp.size() > 0)
        {
          this.a.setValue(tzm.a(bool).a(false, paramStGetBusiInfoRsp));
          paramStGetBusiInfoRsp = paramString.allPolyInfo.get();
          if ((paramStGetBusiInfoRsp != null) && (!bool)) {
            tqg.a(paramStGetBusiInfoRsp);
          }
          tqg.a(paramString.schoolInfos.get(), paramString.companyInfos.get());
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramString)
      {
        paramString.printStackTrace();
        this.a.setValue(tzm.a("parse stBusiInfo data exception!"));
        return;
      }
      this.a.setValue(tzm.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tzi
 * JD-Core Version:    0.7.0.1
 */