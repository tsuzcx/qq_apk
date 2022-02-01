import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
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
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import feedcloud.FeedCloudRead.StGetMainPageReq;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;

public class vxe
  extends aabb
{
  public MutableLiveData<vxq<List<FeedCloudMeta.StFeed>>> a;
  private String a;
  private MutableLiveData<vxq<FeedCloudRead.StGetMainPageRsp>> jdField_b_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private String jdField_b_of_type_JavaLangString;
  private MutableLiveData<vxq<List<FeedCloudMeta.StFeed>>> jdField_c_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private String jdField_c_of_type_JavaLangString;
  private MutableLiveData<FeedCloudMeta.StUser> d = new MutableLiveData();
  private MutableLiveData<QQCircleFeedBase.StMainPageBusiRspData> e = new MutableLiveData();
  
  public vxe()
  {
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_a_of_type_Vua = vua.a(32);
  }
  
  public MutableLiveData<vxq<FeedCloudRead.StGetMainPageRsp>> a()
  {
    return this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public FeedCloudCommon.StCommonExt a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vua != null) {
      return this.jdField_a_of_type_Vua.a(paramBoolean);
    }
    return new FeedCloudCommon.StCommonExt();
  }
  
  public String a()
  {
    return "QCirclePersonalDetailViewModel";
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.jdField_a_of_type_Vua != null) {
      this.jdField_a_of_type_Vua.a(paramStCommonExt);
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, this.jdField_a_of_type_JavaLangString, true, false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    QLog.d("QCirclePersonalDetailViewModel", 1, "requestData uin : " + paramString1);
    paramString1 = new QCircleGetMainPageRequest(paramString1, paramString2);
    paramString2 = paramString1.mRequest.extInfo;
    if (!paramBoolean1) {}
    for (;;)
    {
      paramString2.set(a(bool));
      paramString1.setEnableCache(paramBoolean2);
      this.jdField_c_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.b());
      this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.b());
      a(paramString1, new vxf(this, paramString1, paramBoolean1));
      return;
      bool = false;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    a(paramString, null, false, paramBoolean);
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.d("QCirclePersonalDetailViewModel", 1, "requestPushFeedsData uin : " + paramString);
    if (paramBoolean1) {}
    for (String str = this.jdField_b_of_type_JavaLangString;; str = null)
    {
      paramString = new QCircleGetFeedListRequest(paramString, str, this.jdField_c_of_type_JavaLangString);
      paramString.setEnableCache(paramBoolean2);
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.b());
      VSNetworkHelper.a().a(paramString, new vxg(this, paramBoolean1, paramString));
      return;
    }
  }
  
  public void a(boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp, boolean paramBoolean2)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    boolean bool3 = VSNetworkHelper.a(paramString);
    if ((!paramBoolean1) || (paramLong != 0L) || (paramStGetFeedListRsp == null)) {
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.a(paramString).a(paramLong).b(paramBoolean2));
    }
    for (;;)
    {
      return;
      Object localObject = paramStGetFeedListRsp.vecFeed.get();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramString = this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
        localObject = vxq.a(bool3).a(paramBoolean2, localObject);
        if (paramStGetFeedListRsp.isFinish.get() > 0)
        {
          paramBoolean1 = bool1;
          label109:
          paramString.setValue(((vxq)localObject).c(paramBoolean1));
          this.jdField_b_of_type_JavaLangString = paramStGetFeedListRsp.feedAttchInfo.get();
          if (!paramStGetFeedListRsp.busiRspData.has()) {
            continue;
          }
          paramString = new QQCircleFeedBase.StFeedListBusiRspData();
        }
      }
      try
      {
        paramString.mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        if (!paramString.refreshAttachInfo.has()) {
          continue;
        }
        this.jdField_c_of_type_JavaLangString = paramString.refreshAttachInfo.get();
        return;
        paramBoolean1 = false;
        break label109;
        paramString = this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
        localObject = vxq.a().b(paramBoolean2);
        if (paramStGetFeedListRsp.isFinish.get() > 0) {}
        for (paramBoolean1 = bool2;; paramBoolean1 = false)
        {
          paramString.setValue(((vxq)localObject).c(paramBoolean1));
          break;
        }
      }
      catch (InvalidProtocolBufferMicroException paramStGetFeedListRsp)
      {
        for (;;)
        {
          paramStGetFeedListRsp.printStackTrace();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp, Boolean paramBoolean1)
  {
    boolean bool1 = false;
    boolean bool2 = VSNetworkHelper.a(paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetMainPageRsp == null))
    {
      this.jdField_c_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.a(paramString).a(paramLong).b(paramBoolean1.booleanValue()));
      this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.a(paramString).b(paramBoolean1.booleanValue()));
      return;
    }
    if ((paramStGetMainPageRsp.user != null) && (!TextUtils.isEmpty(paramStGetMainPageRsp.user.id.get())))
    {
      vqn.a().a(paramStGetMainPageRsp.user.id.get(), uzg.b(paramStGetMainPageRsp.user));
      this.d.setValue(paramStGetMainPageRsp.user.get());
    }
    paramString = this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData;
    Object localObject = vxq.a(bool2).a(paramBoolean1.booleanValue(), paramStGetMainPageRsp);
    if (paramStGetMainPageRsp.isFinish.get() > 0) {
      paramBoolean = true;
    }
    for (;;)
    {
      paramString.setValue(((vxq)localObject).c(paramBoolean));
      localObject = paramStGetMainPageRsp.vecFeed.get();
      if (((List)localObject).size() > 0)
      {
        paramString = vxq.a(bool2).a(paramBoolean1.booleanValue(), localObject);
        label219:
        if (paramStGetMainPageRsp.isFinish.get() <= 0) {
          break label446;
        }
        paramBoolean = true;
        paramString.c(paramBoolean);
        if (paramStGetMainPageRsp.busiRspData.get() != null)
        {
          paramBoolean1 = new QQCircleFeedBase.StMainPageBusiRspData();
          paramString.a(paramStGetMainPageRsp.busiRspData.get().toByteArray());
        }
      }
      try
      {
        paramBoolean1.mergeFrom(paramStGetMainPageRsp.busiRspData.get().toByteArray());
        this.e.setValue(paramBoolean1);
        this.jdField_c_of_type_AndroidArchLifecycleMutableLiveData.setValue(paramString);
        if (paramStGetMainPageRsp.extInfo.has()) {
          a((FeedCloudCommon.StCommonExt)paramStGetMainPageRsp.extInfo.get());
        }
        this.jdField_a_of_type_JavaLangString = paramStGetMainPageRsp.feedAttchInfo.get();
        paramString = new StringBuilder().append("feed size:").append(((List)localObject).size()).append(" | isFinish:");
        paramBoolean = bool1;
        if (paramStGetMainPageRsp.isFinish.get() > 0) {
          paramBoolean = true;
        }
        QLog.d("QCirclePersonalDetailViewModel", 1, paramBoolean + " | feedAttachInfo:" + this.jdField_a_of_type_JavaLangString);
        return;
        paramBoolean = false;
        continue;
        paramString = vxq.a().b(paramBoolean1.booleanValue());
        break label219;
        label446:
        paramBoolean = false;
      }
      catch (Exception paramBoolean1)
      {
        for (;;)
        {
          QLog.e("QCirclePersonalDetailViewModel", 1, "mergeFrom stMainPageBusiRspData error");
        }
      }
    }
  }
  
  protected void a(Object[] paramArrayOfObject)
  {
    QLog.d("QCirclePersonalDetailViewModel", 1, "onPreloadComplete");
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 4))
    {
      QLog.d("QCirclePersonalDetailViewModel", 1, "preload requestData onReceive: dispatch Success:" + (Boolean)paramArrayOfObject[0] + " | retCode:" + (Long)paramArrayOfObject[1] + " | retMessage:" + (String)paramArrayOfObject[2]);
      a(((Boolean)paramArrayOfObject[0]).booleanValue(), ((Long)paramArrayOfObject[1]).longValue(), (String)paramArrayOfObject[2], (FeedCloudRead.StGetMainPageRsp)paramArrayOfObject[3], Boolean.valueOf(false));
    }
  }
  
  public MutableLiveData<vxq<List<FeedCloudMeta.StFeed>>> b()
  {
    return this.jdField_c_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public void b(String paramString)
  {
    a(paramString, true, false);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    a(paramString, false, paramBoolean);
  }
  
  public MutableLiveData<vxq<List<FeedCloudMeta.StFeed>>> c()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public MutableLiveData<FeedCloudMeta.StUser> d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxe
 * JD-Core Version:    0.7.0.1
 */