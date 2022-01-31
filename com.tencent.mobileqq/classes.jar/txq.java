import android.arch.lifecycle.MutableLiveData;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentImage;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetFeedDetailReq;
import feedcloud.FeedCloudRead.StGetFeedListReq;

public class txq
  extends ubk
{
  private final MutableLiveData<tsb> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private yii jdField_a_of_type_Yii = new yii();
  
  public txq()
  {
    this.jdField_a_of_type_Uae = uae.a(57);
  }
  
  private void a(QCircleInitBean paramQCircleInitBean)
  {
    paramQCircleInitBean = new QCircleGetFeedDetailRequest(paramQCircleInitBean.getFeed().id.get(), paramQCircleInitBean.getFeed().poster.id.get(), paramQCircleInitBean.getFeed().createTime.get(), false);
    paramQCircleInitBean.mRequest.extInfo.set(a(true));
    a(paramQCircleInitBean, new txr(this, paramQCircleInitBean));
  }
  
  private void b(QCircleInitBean paramQCircleInitBean, boolean paramBoolean)
  {
    paramQCircleInitBean = new QCircleGetFeedListRequest(paramQCircleInitBean, this.jdField_a_of_type_Yii.a(), this.jdField_a_of_type_Yii.b());
    FeedCloudCommon.StCommonExt localStCommonExt = paramQCircleInitBean.mRequest.extInfo;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      localStCommonExt.set(a(bool));
      a(paramQCircleInitBean, new txs(this, paramQCircleInitBean, paramBoolean));
      return;
    }
  }
  
  public MutableLiveData<tsb> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public RecyclerView.ViewHolder a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
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
    return "QCircleContentModel";
  }
  
  public yii a()
  {
    return this.jdField_a_of_type_Yii;
  }
  
  public void a()
  {
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    if ((localViewHolder instanceof txm)) {
      ((txm)localViewHolder).a.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = null;
      a().postValue(null);
      return;
      if ((localViewHolder instanceof txn)) {
        ((txn)localViewHolder).a.a();
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
    if (paramQCircleInitBean.isSingleFeed)
    {
      a(paramQCircleInitBean);
      return;
    }
    b(paramQCircleInitBean, paramBoolean);
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.jdField_a_of_type_Uae != null) {
      this.jdField_a_of_type_Uae.a(paramStCommonExt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txq
 * JD-Core Version:    0.7.0.1
 */