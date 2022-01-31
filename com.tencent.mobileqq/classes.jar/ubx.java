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

public class ubx
  extends ubk
{
  public MutableLiveData<ubz<List<FeedCloudMeta.StFeed>>> a;
  private String a;
  public MutableLiveData<ubz<FeedCloudMeta.StTagInfo>> b = new MutableLiveData();
  
  public ubx()
  {
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_a_of_type_Uae = uae.a(31);
  }
  
  public FeedCloudCommon.StCommonExt a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Uae != null) {
      return this.jdField_a_of_type_Uae.a(paramBoolean);
    }
    return new FeedCloudCommon.StCommonExt();
  }
  
  public String a()
  {
    return "QCircleTagPageViewModel";
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.jdField_a_of_type_Uae != null) {
      this.jdField_a_of_type_Uae.a(paramStCommonExt);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if (paramBoolean1)
    {
      str = this.jdField_a_of_type_JavaLangString;
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
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(ubz.b());
      a(paramString1, new uby(this, paramString1, paramBoolean1));
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
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(ubz.a(paramString).b(paramBoolean2));
      return;
    }
    paramString = paramStGetFeedListRsp.vecFeed.get();
    Object localObject;
    ubz localubz;
    if (paramString.size() > 0)
    {
      localObject = this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
      localubz = ubz.a(bool2).a(paramBoolean2, paramString);
      if (paramStGetFeedListRsp.isFinish.get() > 0) {
        paramBoolean1 = true;
      }
    }
    for (;;)
    {
      ((MutableLiveData)localObject).setValue(localubz.c(paramBoolean1));
      localObject = new QQCircleFeedBase.StFeedListBusiRspData();
      if (paramStGetFeedListRsp.busiRspData.has()) {}
      try
      {
        ((QQCircleFeedBase.StFeedListBusiRspData)localObject).mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        if (((QQCircleFeedBase.StFeedListBusiRspData)localObject).tagPageData.has())
        {
          localObject = (FeedCloudMeta.StTagInfo)((QQCircleFeedBase.StFeedListBusiRspData)localObject).tagPageData.tagInfo.get();
          if (localObject != null) {
            this.b.setValue(ubz.a(bool2).a(false, localObject));
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
          localubz = ubz.a().b(paramBoolean2);
          if (paramStGetFeedListRsp.isFinish.get() > 0) {}
          for (paramBoolean1 = true;; paramBoolean1 = false)
          {
            ((MutableLiveData)localObject).setValue(localubz.c(paramBoolean1));
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
          this.b.setValue(ubz.a());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ubx
 * JD-Core Version:    0.7.0.1
 */