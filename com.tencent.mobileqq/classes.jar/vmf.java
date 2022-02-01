import android.arch.lifecycle.MutableLiveData;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentImage;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetFeedDetailReq;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

public class vmf
  extends aabb
{
  private final aaan jdField_a_of_type_Aaan = new aaan(this.jdField_a_of_type_Int);
  private aabu jdField_a_of_type_Aabu = new aabu();
  private final MutableLiveData<vbf> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  
  public vmf()
  {
    this.jdField_a_of_type_Vua = vua.a(57);
  }
  
  private void a(QCircleInitBean paramQCircleInitBean)
  {
    paramQCircleInitBean = new QCircleGetFeedDetailRequest(paramQCircleInitBean.getFeed().id.get(), paramQCircleInitBean.getFeed().poster.id.get(), paramQCircleInitBean.getFeed().createTime.get(), false, QCircleGetFeedDetailRequest.FROM_NATIVE, paramQCircleInitBean.getFeed());
    paramQCircleInitBean.mRequest.extInfo.set(a(true));
    a(paramQCircleInitBean, new vmi(this, paramQCircleInitBean));
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool = true;
    String str;
    if (paramBoolean)
    {
      str = this.jdField_a_of_type_Aabu.a();
      paramString1 = new QCircleGetFeedListRequest(paramString1, paramString2, true, str, this.jdField_a_of_type_Aabu.b());
      paramString2 = paramString1.mRequest.extInfo;
      if (paramBoolean) {
        break label80;
      }
    }
    for (;;)
    {
      paramString2.set(a(bool));
      a(paramString1, new vmh(this, paramString1, paramBoolean));
      return;
      str = null;
      break;
      label80:
      bool = false;
    }
  }
  
  private void a(boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp, boolean paramBoolean2)
  {
    paramBoolean1 = true;
    Object localObject;
    if (paramStGetFeedListRsp != null)
    {
      this.jdField_a_of_type_Aabu.a(paramStGetFeedListRsp.feedAttchInfo.get());
      this.jdField_a_of_type_Aabu.c(paramStGetFeedListRsp.adAttchInfo.get());
      localObject = this.jdField_a_of_type_Aabu;
      if (paramStGetFeedListRsp.isFinish.get() != 1) {
        break label180;
      }
    }
    for (;;)
    {
      ((aabu)localObject).a(paramBoolean1);
      if (paramStGetFeedListRsp.extInfo.has()) {
        a((FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
      }
      if (paramStGetFeedListRsp.busiRspData.has()) {
        localObject = new QQCircleFeedBase.StFeedListBusiRspData();
      }
      try
      {
        ((QQCircleFeedBase.StFeedListBusiRspData)localObject).mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        if (((QQCircleFeedBase.StFeedListBusiRspData)localObject).refreshAttachInfo.has()) {
          this.jdField_a_of_type_Aabu.b(((QQCircleFeedBase.StFeedListBusiRspData)localObject).refreshAttachInfo.get());
        }
        this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.postValue(new vbf(paramLong, paramString, paramStGetFeedListRsp, paramBoolean2));
        a().a(4);
        return;
        label180:
        paramBoolean1 = false;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
      }
    }
  }
  
  private void b(QCircleInitBean paramQCircleInitBean, boolean paramBoolean)
  {
    paramQCircleInitBean = new QCircleGetFeedListRequest(paramQCircleInitBean, this.jdField_a_of_type_Aabu.a(), this.jdField_a_of_type_Aabu.c(), this.jdField_a_of_type_Aabu.b());
    FeedCloudCommon.StCommonExt localStCommonExt = paramQCircleInitBean.mRequest.extInfo;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      localStCommonExt.set(a(bool));
      a(paramQCircleInitBean, new vmj(this, paramQCircleInitBean, paramBoolean));
      return;
    }
  }
  
  public aabu a()
  {
    return this.jdField_a_of_type_Aabu;
  }
  
  public MutableLiveData<vbf> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public RecyclerView.ViewHolder a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
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
    return "QCircleContentModel";
  }
  
  public void a()
  {
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    if ((localViewHolder instanceof vlw)) {
      ((vlw)localViewHolder).a.b();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = null;
      a().postValue(null);
      if (this.jdField_a_of_type_Aaan != null)
      {
        this.jdField_a_of_type_Aaan.a();
        this.jdField_a_of_type_Aaan.b();
      }
      return;
      if ((localViewHolder instanceof vlx)) {
        ((vlx)localViewHolder).a.b();
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
  }
  
  public void a(QCircleInitBean paramQCircleInitBean, boolean paramBoolean)
  {
    a().a(3);
    if (paramQCircleInitBean.isSingleFeed())
    {
      a(paramQCircleInitBean);
      return;
    }
    if (paramQCircleInitBean.getTagInfo().has())
    {
      if (aadg.a("2005"))
      {
        aadg.a("2005", new vmg(this));
        return;
      }
      a(paramQCircleInitBean.getTagInfo().tagId.get(), paramQCircleInitBean.getTagInfo().tagName.get(), paramBoolean);
      return;
    }
    b(paramQCircleInitBean, paramBoolean);
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.jdField_a_of_type_Vua != null) {
      this.jdField_a_of_type_Vua.a(paramStCommonExt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmf
 * JD-Core Version:    0.7.0.1
 */