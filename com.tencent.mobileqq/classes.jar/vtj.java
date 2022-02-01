import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto.StItemInfo;

public class vtj
  extends RecyclerView.OnScrollListener
  implements aabg<QCircleReportBean>
{
  private static String jdField_a_of_type_JavaLangString = "QCircleFeedCardReportHelper";
  private int jdField_a_of_type_Int;
  private QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private ArrayList<waz> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
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
          if ((localViewHolder instanceof waz))
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
        b((waz)localViewHolder);
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
        c((waz)this.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private void b(waz paramwaz)
  {
    QQCircleDitto.StItemInfo localStItemInfo = paramwaz.a();
    vud localvud;
    vuf localvuf;
    if (localStItemInfo != null)
    {
      vtn.a(localStItemInfo.id.get(), 3, 1, 3, 1, this.jdField_a_of_type_Int, localStItemInfo.id.get(), "", localStItemInfo.id.get(), paramwaz.a(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, null, this.jdField_b_of_type_Int, -1);
      localvud = vud.a();
      localvuf = new vuf().a("card").b("impression").a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed).a(a()).a(this.jdField_a_of_type_Int).c(localStItemInfo.id.get());
      if ((!localStItemInfo.des.has()) || (localStItemInfo.des.size() <= 0)) {
        break label166;
      }
    }
    label166:
    for (paramwaz = (String)localStItemInfo.des.get().get(0);; paramwaz = null)
    {
      localvud.a(localvuf.d(paramwaz));
      return;
    }
  }
  
  private void c(waz paramwaz)
  {
    int i = 0;
    if (paramwaz != null) {
      try
      {
        View localView = paramwaz.itemView;
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
          QLog.d(jdField_a_of_type_JavaLangString, 4, "report card expose index:" + paramwaz.a());
          b(paramwaz);
          return;
        }
      }
      catch (Exception paramwaz)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "checkCardExpose exception:" + paramwaz.toString());
      }
    }
  }
  
  public QCircleReportBean a()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  }
  
  public void a()
  {
    b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(waz paramwaz)
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramwaz);
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
      if (this.jdField_b_of_type_Boolean) {
        vtn.a("", 3, 1, 30, 2, this.jdField_a_of_type_Int, "", "", "", -1, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, null, this.jdField_b_of_type_Int, -1);
      }
      return;
    }
    catch (Exception paramRecyclerView)
    {
      for (;;)
      {
        paramRecyclerView.printStackTrace();
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if (paramInt1 > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtj
 * JD-Core Version:    0.7.0.1
 */