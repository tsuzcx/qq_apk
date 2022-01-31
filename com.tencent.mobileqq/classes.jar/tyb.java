import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import qqcircle.QQCircleDitto.StItemInfo;

public class tyb
  extends RecyclerView.OnScrollListener
{
  private static String jdField_a_of_type_JavaLangString = "QCircleFeedCardReportHelper";
  private int jdField_a_of_type_Int;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private ArrayList<ucp> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean;
  
  private void a(RecyclerView paramRecyclerView)
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
          if ((localViewHolder instanceof ucp))
          {
            localRect = new Rect(0, 0, ImmersiveUtils.a(), ImmersiveUtils.b());
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
        QLog.d(jdField_a_of_type_JavaLangString, 4, "report card expose index:" + i);
        b((ucp)localViewHolder);
      }
      i += 1;
      break;
      return;
    }
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "checkFirstScreenCardExpose report expose size:" + this.jdField_a_of_type_JavaUtilArrayList.size());
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        c((ucp)this.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private void b(ucp paramucp)
  {
    QQCircleDitto.StItemInfo localStItemInfo = paramucp.a();
    if (localStItemInfo != null) {
      tyg.a(localStItemInfo.id.get(), 3, 1, 3, 1, this.jdField_a_of_type_Int, localStItemInfo.id.get(), "", localStItemInfo.id.get(), paramucp.a(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, null);
    }
  }
  
  private void c(ucp paramucp)
  {
    int i = 0;
    if (paramucp != null) {
      try
      {
        View localView = paramucp.itemView;
        if (localView == null) {
          return;
        }
        Rect localRect = new Rect(0, 0, ImmersiveUtils.a(), ImmersiveUtils.b());
        localView.getGlobalVisibleRect(localRect);
        int j = localView.getWidth();
        if (localRect.right > 0) {
          i = localRect.right - localRect.left;
        }
        if (i / j >= 0.5D)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 4, "report card expose index:" + paramucp.a());
          b(paramucp);
          return;
        }
      }
      catch (Exception paramucp)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "checkCardExpose exception:" + paramucp.toString());
      }
    }
  }
  
  public void a()
  {
    b();
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ucp paramucp)
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramucp);
    }
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onScrollStateChanged" + paramInt);
    if (paramInt == 0) {}
    try
    {
      a(paramRecyclerView);
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
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyb
 * JD-Core Version:    0.7.0.1
 */