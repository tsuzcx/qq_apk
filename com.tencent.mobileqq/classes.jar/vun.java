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

public class vun
  extends zxg
{
  public MutableLiveData<vup<List<FeedCloudMeta.StFeed>>> a;
  private String a;
  public MutableLiveData<vup<FeedCloudMeta.StTagInfo>> b;
  private String b;
  
  public vun()
  {
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_a_of_type_Vrp = vrp.a(31);
  }
  
  public FeedCloudCommon.StCommonExt a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vrp != null) {
      return this.jdField_a_of_type_Vrp.a(paramBoolean);
    }
    return new FeedCloudCommon.StCommonExt();
  }
  
  public String a()
  {
    return "QCircleTagPageViewModel";
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.jdField_a_of_type_Vrp != null) {
      this.jdField_a_of_type_Vrp.a(paramStCommonExt);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if (paramBoolean1)
    {
      str = this.jdField_a_of_type_JavaLangString;
      paramString1 = new QCircleGetFeedListRequest(paramString1, paramString2, str, this.jdField_b_of_type_JavaLangString);
      paramString2 = paramString1.mRequest.extInfo;
      if (paramBoolean1) {
        break label89;
      }
    }
    label89:
    for (boolean bool = true;; bool = false)
    {
      paramString2.set(a(bool));
      paramString1.setEnableCache(paramBoolean2);
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vup.b());
      a(paramString1, new vuo(this, paramString1, paramBoolean1));
      return;
      str = null;
      break;
    }
  }
  
  public void a(boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp, boolean paramBoolean2)
  {
    boolean bool1 = false;
    boolean bool2 = VSNetworkHelper.a(paramString);
    if ((!paramBoolean1) || (paramLong != 0L) || (paramStGetFeedListRsp == null))
    {
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vup.a(paramString).a(paramLong).b(paramBoolean2));
      return;
    }
    paramString = paramStGetFeedListRsp.vecFeed.get();
    Object localObject1;
    Object localObject2;
    if (paramString.size() > 0)
    {
      localObject1 = this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
      localObject2 = vup.a(bool2).a(paramBoolean2, paramString);
      if (paramStGetFeedListRsp.isFinish.get() > 0) {
        paramBoolean1 = true;
      }
    }
    for (;;)
    {
      ((MutableLiveData)localObject1).setValue(((vup)localObject2).c(paramBoolean1));
      localObject1 = new QQCircleFeedBase.StFeedListBusiRspData();
      if (paramStGetFeedListRsp.busiRspData.has()) {}
      try
      {
        ((QQCircleFeedBase.StFeedListBusiRspData)localObject1).mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        if (((QQCircleFeedBase.StFeedListBusiRspData)localObject1).tagPageData.has())
        {
          localObject2 = (FeedCloudMeta.StTagInfo)((QQCircleFeedBase.StFeedListBusiRspData)localObject1).tagPageData.tagInfo.get();
          if (localObject2 != null) {
            this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData.setValue(vup.a(bool2).a(false, localObject2));
          }
        }
        else
        {
          if (((QQCircleFeedBase.StFeedListBusiRspData)localObject1).refreshAttachInfo.has()) {
            this.jdField_b_of_type_JavaLangString = ((QQCircleFeedBase.StFeedListBusiRspData)localObject1).refreshAttachInfo.get();
          }
          if (paramStGetFeedListRsp.extInfo.has()) {
            a((FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
          }
          this.jdField_a_of_type_JavaLangString = paramStGetFeedListRsp.feedAttchInfo.get();
          paramString = new StringBuilder().append("feed size:").append(paramString.size()).append(" | isFinish:");
          paramBoolean1 = bool1;
          if (paramStGetFeedListRsp.isFinish.get() > 0) {
            paramBoolean1 = true;
          }
          QLog.d("QCircleTagPageViewModel", 1, paramBoolean1 + " | feedAttachInfo:" + this.jdField_a_of_type_JavaLangString);
          return;
          paramBoolean1 = false;
          continue;
          localObject1 = this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
          localObject2 = vup.a().b(paramBoolean2);
          if (paramStGetFeedListRsp.isFinish.get() > 0) {}
          for (paramBoolean1 = true;; paramBoolean1 = false)
          {
            ((MutableLiveData)localObject1).setValue(((vup)localObject2).c(paramBoolean1));
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
          this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData.setValue(vup.a());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vun
 * JD-Core Version:    0.7.0.1
 */