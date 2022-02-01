import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendWidget.b;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import qqcircle.QQCircleDitto.StItemInfo;

public class pci
  extends RecyclerView.OnScrollListener
{
  private static String TAG = "QCircleFeedCardReportHelper";
  private volatile boolean azk;
  private int bgA;
  private FeedCloudMeta.StFeed f;
  private ArrayList<QCircleRecommendWidget.b> mt = new ArrayList();
  
  private void b(QCircleRecommendWidget.b paramb)
  {
    QQCircleDitto.StItemInfo localStItemInfo = paramb.a();
    if (localStItemInfo != null) {
      pcl.a(localStItemInfo.id.get(), 3, 1, 3, 1, this.bgA, localStItemInfo.id.get(), "", localStItemInfo.id.get(), paramb.getPos(), this.f, null);
    }
  }
  
  private void bjs()
  {
    if (!this.azk)
    {
      QLog.d(TAG, 4, "checkFirstScreenCardExpose report expose size:" + this.mt.size());
      int i = 0;
      while (i < this.mt.size())
      {
        c((QCircleRecommendWidget.b)this.mt.get(i));
        i += 1;
      }
      this.azk = true;
    }
    this.mt.clear();
  }
  
  private void c(QCircleRecommendWidget.b paramb)
  {
    int i = 0;
    if (paramb != null) {
      try
      {
        View localView = paramb.itemView;
        if (localView == null) {
          return;
        }
        Rect localRect = new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight());
        localView.getGlobalVisibleRect(localRect);
        int j = localView.getWidth();
        if (localRect.right > 0) {
          i = localRect.right - localRect.left;
        }
        if (i / j >= 0.5D)
        {
          QLog.d(TAG, 4, "report card expose index:" + paramb.getPos());
          b(paramb);
          return;
        }
      }
      catch (Exception paramb)
      {
        QLog.e(TAG, 1, "checkCardExpose exception:" + paramb.toString());
      }
    }
  }
  
  private void d(RecyclerView paramRecyclerView)
  {
    int i;
    RecyclerView.ViewHolder localViewHolder;
    Rect localRect;
    int m;
    if ((paramRecyclerView != null) && ((paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager)))
    {
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
      i = localLinearLayoutManager.findFirstVisibleItemPosition();
      int k = localLinearLayoutManager.findLastVisibleItemPosition();
      if (i <= k) {
        if (i <= k)
        {
          View localView = localLinearLayoutManager.findViewByPosition(i);
          localViewHolder = paramRecyclerView.findViewHolderForLayoutPosition(i);
          if ((localViewHolder instanceof QCircleRecommendWidget.b))
          {
            localRect = new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight());
            localView.getGlobalVisibleRect(localRect);
            m = localView.getWidth();
            if (localRect.right <= 0) {
              break label180;
            }
          }
        }
      }
    }
    label180:
    for (int j = localRect.right - localRect.left;; j = 0)
    {
      if (j / m >= 0.5D)
      {
        QLog.d(TAG, 4, "report card expose index:" + i);
        b((QCircleRecommendWidget.b)localViewHolder);
      }
      i += 1;
      break;
      return;
    }
  }
  
  public void a(QCircleRecommendWidget.b paramb)
  {
    if (!this.azk) {
      this.mt.add(paramb);
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    this.f = paramStFeed;
    this.bgA = paramInt;
  }
  
  public void onDestory()
  {
    bjs();
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    QLog.d(TAG, 4, "onScrollStateChanged" + paramInt);
    if (paramInt == 0) {}
    try
    {
      d(paramRecyclerView);
      return;
    }
    catch (Exception paramRecyclerView)
    {
      paramRecyclerView.printStackTrace();
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    bjs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pci
 * JD-Core Version:    0.7.0.1
 */