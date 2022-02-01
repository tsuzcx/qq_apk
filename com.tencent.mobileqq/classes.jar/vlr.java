import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetFeedDetailReq;
import feedcloud.FeedCloudRead.StGetFeedListReq;

public class vlr
  extends zxg
{
  private final MutableLiveData<uzp> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private zws jdField_a_of_type_Zws = new zws(this.jdField_a_of_type_Int);
  
  public MutableLiveData<uzp> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
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
    return "QCircleFeedDetailModel";
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Zws != null)
    {
      this.jdField_a_of_type_Zws.a();
      this.jdField_a_of_type_Zws.b();
    }
  }
  
  public void a(QCircleInitBean paramQCircleInitBean)
  {
    int i = QCircleGetFeedDetailRequest.FROM_NATIVE;
    if (paramQCircleInitBean.isSingleFeed) {
      i = QCircleGetFeedDetailRequest.FROM_PUSH_DETAIL;
    }
    paramQCircleInitBean = new QCircleGetFeedDetailRequest(paramQCircleInitBean.getFeed().id.get(), paramQCircleInitBean.getFeed().poster.id.get(), paramQCircleInitBean.getFeed().createTime.get(), false, i, paramQCircleInitBean.getFeed());
    paramQCircleInitBean.mRequest.extInfo.set(a(true));
    a(paramQCircleInitBean, new vls(this, paramQCircleInitBean));
  }
  
  public void a(QCircleInitBean paramQCircleInitBean, zxz paramzxz)
  {
    boolean bool2 = paramzxz.e();
    paramQCircleInitBean = new QCircleGetFeedListRequest(paramQCircleInitBean, paramzxz.a());
    FeedCloudCommon.StCommonExt localStCommonExt = paramQCircleInitBean.mRequest.extInfo;
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localStCommonExt.set(a(bool1));
      a(paramQCircleInitBean, new vlt(this, paramQCircleInitBean, bool2, paramzxz));
      return;
    }
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.jdField_a_of_type_Vrp != null) {
      this.jdField_a_of_type_Vrp.a(paramStCommonExt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlr
 * JD-Core Version:    0.7.0.1
 */