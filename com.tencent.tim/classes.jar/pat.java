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

public class pat
  extends rxi
{
  private RecyclerView.ViewHolder c;
  private final MutableLiveData<owb> m = new MutableLiveData();
  private rxt mLoadInfo = new rxt();
  
  public pat()
  {
    this.a = pcx.a(57);
  }
  
  private void b(QCircleInitBean paramQCircleInitBean)
  {
    paramQCircleInitBean = new QCircleGetFeedDetailRequest(paramQCircleInitBean.getFeed().id.get(), paramQCircleInitBean.getFeed().poster.id.get(), paramQCircleInitBean.getFeed().createTime.get(), false);
    paramQCircleInitBean.mRequest.extInfo.set(a(true));
    a(paramQCircleInitBean, new pau(this, paramQCircleInitBean));
  }
  
  private void b(QCircleInitBean paramQCircleInitBean, boolean paramBoolean)
  {
    paramQCircleInitBean = new QCircleGetFeedListRequest(paramQCircleInitBean, this.mLoadInfo.nm(), this.mLoadInfo.nn());
    FeedCloudCommon.StCommonExt localStCommonExt = paramQCircleInitBean.mRequest.extInfo;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      localStCommonExt.set(a(bool));
      a(paramQCircleInitBean, new pav(this, paramQCircleInitBean, paramBoolean));
      return;
    }
  }
  
  public RecyclerView.ViewHolder a()
  {
    return this.c;
  }
  
  public FeedCloudCommon.StCommonExt a(boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.b(paramBoolean);
    }
    return new FeedCloudCommon.StCommonExt();
  }
  
  public void a(QCircleInitBean paramQCircleInitBean, boolean paramBoolean)
  {
    getLoadInfo().setCurrentState(3);
    if (paramQCircleInitBean.isSingleFeed)
    {
      b(paramQCircleInitBean);
      return;
    }
    b(paramQCircleInitBean, paramBoolean);
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.a != null) {
      this.a.b(paramStCommonExt);
    }
  }
  
  public void f(RecyclerView.ViewHolder paramViewHolder)
  {
    this.c = paramViewHolder;
  }
  
  public rxt getLoadInfo()
  {
    return this.mLoadInfo;
  }
  
  public String getLogTag()
  {
    return "QCircleContentModel";
  }
  
  public MutableLiveData<owb> j()
  {
    return this.m;
  }
  
  public void onDestroy()
  {
    RecyclerView.ViewHolder localViewHolder = this.c;
    if ((localViewHolder instanceof pao.a)) {
      ((pao.a)localViewHolder).a.release();
    }
    for (;;)
    {
      this.c = null;
      j().postValue(null);
      return;
      if ((localViewHolder instanceof pao.b)) {
        ((pao.b)localViewHolder).a.release();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pat
 * JD-Core Version:    0.7.0.1
 */