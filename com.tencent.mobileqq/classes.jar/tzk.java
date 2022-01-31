import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
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

public class tzk
  extends tyz
{
  public MutableLiveData<tzm<List<FeedCloudMeta.StFeed>>> a;
  private String a;
  public MutableLiveData<tzm<FeedCloudMeta.StTagInfo>> b = new MutableLiveData();
  
  public tzk()
  {
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_a_of_type_Tys = tys.a(31);
  }
  
  public FeedCloudCommon.StCommonExt a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Tys != null) {
      return this.jdField_a_of_type_Tys.a(paramBoolean);
    }
    return new FeedCloudCommon.StCommonExt();
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.jdField_a_of_type_Tys != null) {
      this.jdField_a_of_type_Tys.a(paramStCommonExt);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool2 = true;
    String str;
    if (paramBoolean)
    {
      str = this.jdField_a_of_type_JavaLangString;
      paramString1 = new QCircleGetFeedListRequest(paramString1, paramString2, str);
      paramString2 = paramString1.mRequest.extInfo;
      if (paramBoolean) {
        break label96;
      }
      bool1 = true;
      label40:
      paramString2.set(a(bool1));
      if (paramBoolean) {
        break label102;
      }
    }
    label96:
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramString1.setEnableCache(bool1);
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(tzm.b());
      a(paramString1, new tzl(this, paramString1, paramBoolean));
      return;
      str = null;
      break;
      bool1 = false;
      break label40;
    }
  }
  
  public void a(boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp, boolean paramBoolean2)
  {
    boolean bool1 = false;
    boolean bool2 = VSNetworkHelper.a(paramString);
    if ((!paramBoolean1) || (paramLong != 0L) || (paramStGetFeedListRsp == null))
    {
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(tzm.a(paramString).b(paramBoolean2));
      return;
    }
    paramString = paramStGetFeedListRsp.vecFeed.get();
    Object localObject;
    tzm localtzm;
    if (paramString.size() > 0)
    {
      localObject = this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
      localtzm = tzm.a(bool2).a(paramBoolean2, paramString);
      if (paramStGetFeedListRsp.isFinish.get() > 0) {
        paramBoolean1 = true;
      }
    }
    for (;;)
    {
      ((MutableLiveData)localObject).setValue(localtzm.c(paramBoolean1));
      localObject = new QQCircleFeedBase.StFeedListBusiRspData();
      if (paramStGetFeedListRsp.busiRspData.has()) {}
      try
      {
        ((QQCircleFeedBase.StFeedListBusiRspData)localObject).mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        if (((QQCircleFeedBase.StFeedListBusiRspData)localObject).tagPageData.has())
        {
          localObject = (FeedCloudMeta.StTagInfo)((QQCircleFeedBase.StFeedListBusiRspData)localObject).tagPageData.tagInfo.get();
          if (localObject != null) {
            this.b.setValue(tzm.a(bool2).a(false, localObject));
          }
        }
        else
        {
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
          localObject = this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
          localtzm = tzm.a().b(paramBoolean2);
          if (paramStGetFeedListRsp.isFinish.get() > 0) {}
          for (paramBoolean1 = true;; paramBoolean1 = false)
          {
            ((MutableLiveData)localObject).setValue(localtzm.c(paramBoolean1));
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
          this.b.setValue(tzm.a());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tzk
 * JD-Core Version:    0.7.0.1
 */