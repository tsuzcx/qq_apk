import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StTagPageData;

public class pej
  extends rxi
{
  private String arO;
  public MutableLiveData<pel<List<FeedCloudMeta.StFeed>>> n = new MutableLiveData();
  public MutableLiveData<pel<FeedCloudMeta.StTagInfo>> x = new MutableLiveData();
  
  public pej()
  {
    this.a = pcx.a(31);
  }
  
  public FeedCloudCommon.StCommonExt a(boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.b(paramBoolean);
    }
    return new FeedCloudCommon.StCommonExt();
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.a != null) {
      this.a.b(paramStCommonExt);
    }
  }
  
  public void b(boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp, boolean paramBoolean2)
  {
    boolean bool1 = false;
    boolean bool2 = VSNetworkHelper.fQ(paramString);
    if ((!paramBoolean1) || (paramLong != 0L) || (paramStGetFeedListRsp == null))
    {
      this.n.setValue(pel.a(paramString).b(paramBoolean2));
      return;
    }
    paramString = paramStGetFeedListRsp.vecFeed.get();
    Object localObject;
    pel localpel;
    if (paramString.size() > 0)
    {
      localObject = this.n;
      localpel = pel.a(bool2).a(paramBoolean2, paramString);
      if (paramStGetFeedListRsp.isFinish.get() > 0) {
        paramBoolean1 = true;
      }
    }
    for (;;)
    {
      ((MutableLiveData)localObject).setValue(localpel.c(paramBoolean1));
      localObject = new QQCircleFeedBase.StFeedListBusiRspData();
      if (paramStGetFeedListRsp.busiRspData.has()) {}
      try
      {
        ((QQCircleFeedBase.StFeedListBusiRspData)localObject).mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        if (((QQCircleFeedBase.StFeedListBusiRspData)localObject).tagPageData.has())
        {
          localObject = (FeedCloudMeta.StTagInfo)((QQCircleFeedBase.StFeedListBusiRspData)localObject).tagPageData.tagInfo.get();
          if (localObject != null) {
            this.x.setValue(pel.a(bool2).a(false, localObject));
          }
        }
        else
        {
          if (paramStGetFeedListRsp.extInfo.has()) {
            a((FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
          }
          this.arO = paramStGetFeedListRsp.feedAttchInfo.get();
          paramString = new StringBuilder().append("feed size:").append(paramString.size()).append(" | isFinish:");
          paramBoolean1 = bool1;
          if (paramStGetFeedListRsp.isFinish.get() > 0) {
            paramBoolean1 = true;
          }
          QLog.d("QCircleTagPageViewModel", 1, paramBoolean1 + " | feedAttachInfo:" + this.arO);
          return;
          paramBoolean1 = false;
          continue;
          localObject = this.n;
          localpel = pel.a().b(paramBoolean2);
          if (paramStGetFeedListRsp.isFinish.get() > 0) {}
          for (paramBoolean1 = true;; paramBoolean1 = false)
          {
            ((MutableLiveData)localObject).setValue(localpel.c(paramBoolean1));
            break;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          continue;
          this.x.setValue(pel.a());
        }
      }
    }
  }
  
  public void e(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if (paramBoolean1)
    {
      str = this.arO;
      paramString1 = new QCircleGetFeedListRequest(paramString1, paramString2, str);
      paramString2 = paramString1.mRequest.extInfo;
      if (paramBoolean1) {
        break label85;
      }
    }
    label85:
    for (boolean bool = true;; bool = false)
    {
      paramString2.set(a(bool));
      paramString1.setEnableCache(paramBoolean2);
      this.n.setValue(pel.b());
      a(paramString1, new pek(this, paramString1, paramBoolean1));
      return;
      str = null;
      break;
    }
  }
  
  public String getLogTag()
  {
    return "QCircleTagPageViewModel";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pej
 * JD-Core Version:    0.7.0.1
 */