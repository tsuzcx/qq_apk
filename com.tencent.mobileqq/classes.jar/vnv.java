import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetFeedDetailReq;
import feedcloud.FeedCloudRead.StGetFeedListReq;

public class vnv
  extends aabb
{
  private aaan jdField_a_of_type_Aaan = new aaan(this.jdField_a_of_type_Int);
  private final MutableLiveData<vbf> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  
  public MutableLiveData<vbf> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
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
    return "QCircleFeedDetailModel";
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Aaan != null)
    {
      this.jdField_a_of_type_Aaan.a();
      this.jdField_a_of_type_Aaan.b();
    }
  }
  
  public void a(QCircleInitBean paramQCircleInitBean)
  {
    int i = QCircleGetFeedDetailRequest.FROM_NATIVE;
    if (paramQCircleInitBean.isSingleFeed()) {
      i = QCircleGetFeedDetailRequest.FROM_PUSH_DETAIL;
    }
    paramQCircleInitBean = new QCircleGetFeedDetailRequest(paramQCircleInitBean.getFeed().id.get(), paramQCircleInitBean.getFeed().poster.id.get(), paramQCircleInitBean.getFeed().createTime.get(), false, i, paramQCircleInitBean.getFeed());
    paramQCircleInitBean.mRequest.extInfo.set(a(true));
    a(paramQCircleInitBean, new vnw(this, paramQCircleInitBean));
  }
  
  public void a(QCircleInitBean paramQCircleInitBean, aabu paramaabu)
  {
    boolean bool2 = paramaabu.e();
    paramQCircleInitBean = new QCircleGetFeedListRequest(paramQCircleInitBean, paramaabu.a());
    FeedCloudCommon.StCommonExt localStCommonExt = paramQCircleInitBean.mRequest.extInfo;
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localStCommonExt.set(a(bool1));
      a(paramQCircleInitBean, new vnx(this, paramQCircleInitBean, bool2, paramaabu));
      return;
    }
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.jdField_a_of_type_Vua != null) {
      this.jdField_a_of_type_Vua.a(paramStCommonExt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnv
 * JD-Core Version:    0.7.0.1
 */