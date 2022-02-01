import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.launchbean.QCirclePolymerizationBean;
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
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

public class vxh
  extends aabb
{
  public MutableLiveData<vxq<List<FeedCloudMeta.StFeed>>> a;
  private String a;
  public MutableLiveData<vxq<QQCircleFeedBase.StFeedListBusiRspData>> b;
  private String b;
  
  public vxh()
  {
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
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
    return "QCirclePolymerizationVi";
  }
  
  public void a(QCirclePolymerizationBean paramQCirclePolymerizationBean, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramQCirclePolymerizationBean == null)
    {
      QLog.e("QCirclePolymerizationVi", 1, "initBean == null");
      return;
    }
    Object localObject;
    if (paramBoolean1)
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      paramQCirclePolymerizationBean = new QCircleGetFeedListRequest(paramQCirclePolymerizationBean, (String)localObject, this.jdField_b_of_type_JavaLangString);
      localObject = paramQCirclePolymerizationBean.mRequest.extInfo;
      if (paramBoolean1) {
        break label110;
      }
    }
    label110:
    for (boolean bool = true;; bool = false)
    {
      ((FeedCloudCommon.StCommonExt)localObject).set(a(bool));
      paramQCirclePolymerizationBean.setEnableCache(paramBoolean2);
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.b());
      QLog.d("QCirclePolymerizationVi", 1, "================================================================");
      a(paramQCirclePolymerizationBean, new vxi(this, paramQCirclePolymerizationBean, paramBoolean1));
      return;
      localObject = null;
      break;
    }
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.jdField_a_of_type_Vua != null) {
      this.jdField_a_of_type_Vua.a(paramStCommonExt);
    }
  }
  
  public void a(boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp, boolean paramBoolean2)
  {
    boolean bool = VSNetworkHelper.a(paramString);
    if ((!paramBoolean1) || (paramLong != 0L) || (paramStGetFeedListRsp == null))
    {
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.a(paramString).a(paramLong).b(paramBoolean2));
      return;
    }
    if (paramStGetFeedListRsp.extInfo.has()) {
      a((FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
    }
    this.jdField_a_of_type_JavaLangString = paramStGetFeedListRsp.feedAttchInfo.get();
    Object localObject = paramStGetFeedListRsp.vecFeed.get();
    if (((List)localObject).size() > 0)
    {
      paramString = this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
      localObject = vxq.a(bool).a(paramBoolean2, localObject);
      if (paramStGetFeedListRsp.isFinish.get() > 0) {
        paramBoolean1 = true;
      }
    }
    for (;;)
    {
      paramString.setValue(((vxq)localObject).c(paramBoolean1));
      paramString = new QQCircleFeedBase.StFeedListBusiRspData();
      if (paramStGetFeedListRsp.busiRspData.has()) {}
      try
      {
        paramString.mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        if (paramString.has())
        {
          this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.a(bool).a(false, paramString));
          if (paramString.refreshAttachInfo.has()) {
            this.jdField_b_of_type_JavaLangString = paramString.refreshAttachInfo.get();
          }
          QLog.d("QCirclePolymerizationVi", 1, "feedAttachInfo:" + this.jdField_a_of_type_JavaLangString);
          return;
          paramBoolean1 = false;
          continue;
          paramString = this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
          localObject = vxq.a().a(paramLong).b(paramBoolean2);
          if (paramStGetFeedListRsp.isFinish.get() > 0) {}
          for (paramBoolean1 = true;; paramBoolean1 = false)
          {
            paramString.setValue(((vxq)localObject).c(paramBoolean1));
            break;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramStGetFeedListRsp)
      {
        for (;;)
        {
          paramStGetFeedListRsp.printStackTrace();
          continue;
          this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.a());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxh
 * JD-Core Version:    0.7.0.1
 */