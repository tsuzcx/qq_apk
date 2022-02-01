import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleBaseLightInteractWidget;
import com.tencent.common.app.AppInterface;
import feedcloud.FeedCloudMeta.StFeed;

public class vdp
  extends RecyclerView.ViewHolder
{
  public vdp(vdj paramvdj, View paramView)
  {
    super(paramView);
  }
  
  public void a(AppInterface paramAppInterface, Object paramObject, int paramInt1, int paramInt2, FeedCloudMeta.StFeed paramStFeed, ReportExtraTypeInfo paramReportExtraTypeInfo)
  {
    if ((this.itemView instanceof QCircleBaseLightInteractWidget))
    {
      ((QCircleBaseLightInteractWidget)this.itemView).a(paramAppInterface, paramStFeed, paramReportExtraTypeInfo, paramInt2);
      ((QCircleBaseLightInteractWidget)this.itemView).a(paramObject, paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdp
 * JD-Core Version:    0.7.0.1
 */