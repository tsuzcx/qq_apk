import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleFeedDividerWidget;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class vse
  extends vrw
{
  private static String jdField_a_of_type_JavaLangString = "QCircleFeedReportHelper";
  private final QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  private ArrayList<RecyclerView.ViewHolder> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, vsf> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  private int b;
  
  public vse(int paramInt, QCircleReportBean paramQCircleReportBean)
  {
    this.b = paramInt;
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = paramQCircleReportBean;
  }
  
  private FeedCloudMeta.StFeed a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder != null) && ((paramViewHolder.itemView instanceof BaseWidgetView)) && ((((BaseWidgetView)paramViewHolder.itemView).a() instanceof FeedCloudMeta.StFeed))) {
      return (FeedCloudMeta.StFeed)((BaseWidgetView)paramViewHolder.itemView).a();
    }
    return null;
  }
  
  public static String a(FeedCloudMeta.StFeed paramStFeed)
  {
    Object localObject = paramStFeed.tagInfos.get();
    paramStFeed = new StringBuilder();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FeedCloudMeta.StTagInfo localStTagInfo = (FeedCloudMeta.StTagInfo)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(paramStFeed)) {
        paramStFeed.append("|");
      }
      paramStFeed.append(localStTagInfo.tagName.get());
    }
    return paramStFeed.toString();
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    int i = 0;
    Object localObject;
    if ((paramView instanceof QCircleInsFeedItemView))
    {
      localObject = (FeedCloudMeta.StFeed)((QCircleInsFeedItemView)paramView).a();
      i = ((QCircleInsFeedItemView)paramView).b();
      paramView = (View)localObject;
    }
    for (;;)
    {
      int j;
      if (paramView != null)
      {
        localObject = a(paramView);
        if (!paramBoolean) {
          break label183;
        }
        j = 2;
        a(paramView, (int[])localObject, i);
        vrr.a().a(new vrt().a("content").b("effective_imp").a(paramView).a(a()).a(i));
      }
      for (;;)
      {
        vrc.a(paramView.poster.id.get(), localObject[0], localObject[1], j, 1, i, paramView.id.get(), a(paramView), paramView.poster.id.get(), -1, paramView, null, this.b, -1);
        return;
        if (!(paramView instanceof QCircleFeedDividerWidget)) {
          break label227;
        }
        localObject = (FeedCloudMeta.StFeed)((QCircleFeedDividerWidget)paramView).a();
        i = ((QCircleFeedDividerWidget)paramView).b();
        paramView = (View)localObject;
        break;
        label183:
        j = 1;
        vrr.a().a(new vrt().a("content").b("impression").a(paramView).a(a()).a(i));
      }
      label227:
      paramView = null;
    }
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed, int[] paramArrayOfInt, int paramInt)
  {
    String str;
    ArrayList localArrayList;
    if ((paramStFeed.type.get() == 2) && (paramStFeed.images.size() > 0))
    {
      str = ((FeedCloudMeta.StImage)paramStFeed.images.get(0)).picId.get() + "";
      localArrayList = new ArrayList();
      if (paramStFeed.type.get() != 2) {
        break label176;
      }
      localArrayList.add(vri.a("ext1", "1"));
      localArrayList.add(vri.a("ext2", "0"));
      localArrayList.add(vri.a("ext3", paramStFeed.images.size() + ""));
    }
    for (;;)
    {
      vrg.a(1, 1, paramArrayOfInt[0], paramArrayOfInt[1], paramStFeed, 1, paramInt, str, localArrayList, this.b);
      return;
      str = "";
      break;
      label176:
      if (paramStFeed.type.get() == 3) {
        localArrayList.add(vri.a("ext1", "2"));
      }
    }
  }
  
  private void a(vsf paramvsf)
  {
    if (paramvsf != null)
    {
      FeedCloudMeta.StFeed localStFeed = vsf.a(paramvsf);
      int[] arrayOfInt = a(localStFeed);
      long l = System.currentTimeMillis();
      paramvsf.b(l);
      paramvsf.c(l - paramvsf.a());
      vrd.a(localStFeed.poster.id.get(), arrayOfInt[0], arrayOfInt[1], paramvsf.a(), localStFeed.id.get(), a(localStFeed), String.valueOf(paramvsf.a()), String.valueOf(paramvsf.b()), String.valueOf(paramvsf.c()), localStFeed.poster.id.get(), localStFeed, null, this.b, -1);
    }
  }
  
  public static int[] a(FeedCloudMeta.StFeed paramStFeed)
  {
    int[] arrayOfInt = new int[2];
    if (paramStFeed != null)
    {
      if (paramStFeed.dittoFeed.dittoId.get() == 0) {
        break label31;
      }
      arrayOfInt[0] = 3;
      arrayOfInt[1] = 1;
    }
    label31:
    do
    {
      return arrayOfInt;
      if (paramStFeed.type.get() == 2)
      {
        arrayOfInt[0] = 1;
        arrayOfInt[1] = 1;
        return arrayOfInt;
      }
    } while (paramStFeed.type.get() != 3);
    arrayOfInt[0] = 1;
    arrayOfInt[1] = 2;
    return arrayOfInt;
  }
  
  private void c(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = 0;
    if (paramViewHolder != null) {
      try
      {
        View localView = paramViewHolder.itemView;
        if (localView == null) {
          return;
        }
        Rect localRect = new Rect(0, 0, ImmersiveUtils.a(), ImmersiveUtils.b());
        localView.getGlobalVisibleRect(localRect);
        int j = localView.getHeight();
        if (localRect.bottom > 0) {
          i = localRect.bottom - localRect.top;
        }
        if (i / j >= 0.5D)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 4, "report feed valid expose index:" + paramViewHolder.getLayoutPosition());
          a(paramViewHolder.itemView, true);
          return;
        }
      }
      catch (Exception paramViewHolder)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "checkFeedExpose exception:" + paramViewHolder.toString());
      }
    }
  }
  
  private void e()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "checkFirstScreenFeedExpose report expose size:" + this.jdField_a_of_type_JavaUtilArrayList.size());
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        c((RecyclerView.ViewHolder)this.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public QCircleReportBean a()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onViewAttachedToWindow" + paramViewHolder);
    a(paramViewHolder.itemView, false);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramViewHolder);
      if (((paramViewHolder.itemView instanceof QCircleInsFeedItemView)) && ((((QCircleInsFeedItemView)paramViewHolder.itemView).a() instanceof FeedCloudMeta.StFeed)))
      {
        vsf localvsf = new vsf();
        localvsf.a(System.currentTimeMillis());
        localvsf.a((QCircleInsFeedItemView)paramViewHolder.itemView);
        localvsf.a(((QCircleInsFeedItemView)paramViewHolder.itemView).b());
        localvsf.a((FeedCloudMeta.StFeed)((QCircleInsFeedItemView)paramViewHolder.itemView).a());
        this.jdField_a_of_type_JavaUtilHashMap.put(((FeedCloudMeta.StFeed)((QCircleInsFeedItemView)paramViewHolder.itemView).a()).id.get(), localvsf);
      }
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramInt1 = 0;
    e();
    paramRecyclerView = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    if (paramRecyclerView.hasNext())
    {
      Object localObject = (String)paramRecyclerView.next();
      localObject = (vsf)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if ((localObject != null) && (((vsf)localObject).a() != null))
      {
        Rect localRect = new Rect(0, 0, ImmersiveUtils.a(), ImmersiveUtils.b());
        ((vsf)localObject).a().getGlobalVisibleRect(localRect);
        paramInt2 = ((vsf)localObject).a().getHeight();
        if (localRect.bottom > 0) {
          paramInt1 = localRect.bottom - localRect.top;
        }
        if (paramInt1 / paramInt2 < 0.5D)
        {
          a((vsf)localObject);
          paramRecyclerView.remove();
          QLog.d(jdField_a_of_type_JavaLangString, 4, "report from scroll:" + ((vsf)localObject).a().id.get());
        }
      }
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, RecyclerView.LayoutManager paramLayoutManager, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onScrollStateChanged" + paramInt1);
    for (;;)
    {
      if ((paramInt1 == 0) && (paramInt2 <= paramInt3) && (paramInt2 <= paramInt3)) {
        try
        {
          paramRecyclerView = paramLayoutManager.findViewByPosition(paramInt2);
          if (((paramRecyclerView instanceof QCircleInsFeedItemView)) && (a(paramRecyclerView)) && ((((QCircleInsFeedItemView)paramRecyclerView).a() instanceof FeedCloudMeta.StFeed)))
          {
            String str = ((FeedCloudMeta.StFeed)((QCircleInsFeedItemView)paramRecyclerView).a()).id.get();
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
            {
              vsf localvsf = new vsf();
              localvsf.a(System.currentTimeMillis());
              localvsf.a((QCircleInsFeedItemView)paramRecyclerView);
              localvsf.a(((QCircleInsFeedItemView)paramRecyclerView).b());
              localvsf.a((FeedCloudMeta.StFeed)((QCircleInsFeedItemView)paramRecyclerView).a());
              this.jdField_a_of_type_JavaUtilHashMap.put(str, localvsf);
            }
            QLog.d(jdField_a_of_type_JavaLangString, 4, "feed record report start:");
            QLog.d(jdField_a_of_type_JavaLangString, 4, "report feed valid expose index:" + paramInt2);
            a(paramRecyclerView, true);
          }
          paramInt2 += 1;
        }
        catch (Exception paramRecyclerView)
        {
          paramRecyclerView.printStackTrace();
        }
      }
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onViewDetachedFromWindow" + paramViewHolder);
    paramViewHolder = a(paramViewHolder);
    if ((paramViewHolder != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramViewHolder.id.get())))
    {
      a((vsf)this.jdField_a_of_type_JavaUtilHashMap.get(paramViewHolder.id.get()));
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramViewHolder.id.get());
      QLog.d(jdField_a_of_type_JavaLangString, 4, "report from detach: " + paramViewHolder.id.get());
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      a((vsf)this.jdField_a_of_type_JavaUtilHashMap.get(str));
      localIterator.remove();
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vse
 * JD-Core Version:    0.7.0.1
 */