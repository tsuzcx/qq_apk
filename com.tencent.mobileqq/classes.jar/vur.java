import android.graphics.Rect;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller.1;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleWaterfallFeedItemView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.webbundle.sdk.ThreadManager;
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

public class vur
  extends vui
{
  private static String jdField_a_of_type_JavaLangString = "QCircleFeedReportHelper";
  private final QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  private ArrayList<vus> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, vus> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private HashMap<String, vus> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  
  public vur(int paramInt, QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_b_of_type_Int = paramInt;
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
    FeedCloudMeta.StFeed localStFeed = null;
    int i = 0;
    if (((paramView instanceof QCircleInsFeedItemView)) || ((paramView instanceof QCircleWaterfallFeedItemView)))
    {
      localStFeed = (FeedCloudMeta.StFeed)((QCircleBaseWidgetView)paramView).a();
      i = ((QCircleBaseWidgetView)paramView).f();
    }
    int j;
    if (localStFeed != null)
    {
      paramView = a(localStFeed);
      if (!paramBoolean) {
        break label162;
      }
      j = 2;
      a(localStFeed, paramView, i);
      vud.a().a(new vuf().a("content").b("effective_imp").a(localStFeed).a(a()).a(i));
    }
    for (;;)
    {
      vtn.a(localStFeed.poster.id.get(), paramView[0], paramView[1], j, 1, i, localStFeed.id.get(), a(localStFeed), localStFeed.poster.id.get(), -1, localStFeed, null, this.jdField_b_of_type_Int, -1);
      return;
      label162:
      j = 1;
      vud.a().a(new vuf().a("content").b("impression").a(localStFeed).a(a()).a(i));
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
      localArrayList.add(vtt.a("ext1", "1"));
      localArrayList.add(vtt.a("ext2", "0"));
      localArrayList.add(vtt.a("ext3", paramStFeed.images.size() + ""));
    }
    for (;;)
    {
      vtr.a(1, 1, paramArrayOfInt[0], paramArrayOfInt[1], paramStFeed, 1, paramInt, str, localArrayList, this.jdField_b_of_type_Int);
      return;
      str = "";
      break;
      label176:
      if (paramStFeed.type.get() == 3) {
        localArrayList.add(vtt.a("ext1", "2"));
      }
    }
  }
  
  private void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      vus localvus = (vus)localIterator.next();
      if (localvus != null)
      {
        if (localvus.a() != null)
        {
          localvus.a().setTag(2131378384, Boolean.valueOf(false));
          a(localvus.a(), false);
        }
        if ((!this.jdField_b_of_type_JavaUtilHashMap.containsValue(localvus)) && (d(localvus.a())) && (localvus.a() != null))
        {
          this.jdField_b_of_type_JavaUtilHashMap.put(localvus.a().id.get(), localvus);
          QLog.d(jdField_a_of_type_JavaLangString, 4, "add valid expose poll from " + paramString + ",index:" + localvus.a() + ",feedId:" + localvus.a().id.get() + ",pageId:" + this.jdField_b_of_type_Int);
        }
      }
    }
  }
  
  private void a(vus paramvus)
  {
    if (paramvus != null)
    {
      FeedCloudMeta.StFeed localStFeed = vus.a(paramvus);
      int[] arrayOfInt = a(localStFeed);
      paramvus.a(System.currentTimeMillis());
      vto.a(localStFeed.poster.id.get(), arrayOfInt[0], arrayOfInt[1], paramvus.a(), localStFeed.id.get(), a(localStFeed), String.valueOf(paramvus.a()), String.valueOf(paramvus.b()), String.valueOf(paramvus.c()), localStFeed.poster.id.get(), localStFeed, null, this.jdField_b_of_type_Int, -1);
    }
  }
  
  private boolean a(String paramString, vus paramvus)
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsValue(paramvus))
    {
      paramvus.a();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramvus);
      return true;
    }
    return false;
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
  
  private void b(String paramString)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (vus)this.jdField_b_of_type_JavaUtilHashMap.get(localObject);
      if ((localObject != null) && (c(vus.a((vus)localObject))))
      {
        a(vus.a((vus)localObject), true);
        if (((vus)localObject).a() != null) {
          QLog.d(jdField_a_of_type_JavaLangString, 4, "report feed valid expose from flush by " + paramString + ",index:" + ((vus)localObject).a() + ",feedId:" + ((vus)localObject).a().id.get() + ",pageId:" + this.jdField_b_of_type_Int);
        }
        localIterator.remove();
      }
    }
  }
  
  private void b(vus paramvus)
  {
    if ((paramvus != null) && ((paramvus.a() instanceof QCircleBaseWidgetView)))
    {
      QCircleBaseWidgetView localQCircleBaseWidgetView = (QCircleBaseWidgetView)paramvus.a();
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)localQCircleBaseWidgetView.a();
      String str = localStFeed.id.get();
      paramvus.a(localStFeed);
      QLog.d(jdField_a_of_type_JavaLangString, 4, "refreshBeanData,index:" + localQCircleBaseWidgetView.f() + ",feedId:" + str + ",pageId:" + this.jdField_b_of_type_Int);
    }
  }
  
  private void c(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      vus localvus = (vus)localIterator.next();
      if (localvus != null)
      {
        b(localvus);
        if ((d(localvus.a())) && (localvus.a() != null))
        {
          localvus.a();
          this.jdField_a_of_type_JavaUtilHashMap.put(localvus.a().id.get(), localvus);
          QLog.d(jdField_a_of_type_JavaLangString, 4, "record feed stay event from " + paramString + ",index:" + localvus.a() + ",feedId:" + localvus.a().id.get() + ",pageId:" + this.jdField_b_of_type_Int);
        }
      }
    }
  }
  
  private boolean c(View paramView)
  {
    if (paramView != null)
    {
      if (!((Boolean)paramView.getTag(2131378384)).booleanValue()) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          paramView.setTag(2131378384, Boolean.valueOf(true));
        }
        return bool;
      }
    }
    return false;
  }
  
  private void d(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      vus localvus = (vus)this.jdField_a_of_type_JavaUtilHashMap.get(str);
      if (localvus != null)
      {
        a(localvus);
        QLog.d(jdField_a_of_type_JavaLangString, 4, "report feed stay event from flush by " + paramString + ",index:" + localvus.a() + ",feedId:" + str + ",pageId:" + this.jdField_b_of_type_Int + ",stayTime:" + localvus.c() + "ms");
      }
      localIterator.remove();
    }
  }
  
  private boolean d(View paramView)
  {
    Rect localRect;
    int j;
    if (paramView != null)
    {
      localRect = new Rect();
      paramView.getGlobalVisibleRect(localRect);
      j = paramView.getHeight();
      if (localRect.bottom <= 0) {
        break label73;
      }
    }
    label73:
    for (int i = localRect.bottom - localRect.top;; i = 0)
    {
      float f = i / j;
      return (f >= 0.5D) && (!Float.isNaN(f));
    }
  }
  
  private void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      vus localvus = (vus)localIterator.next();
      if ((localvus != null) && (!this.jdField_b_of_type_JavaUtilHashMap.containsValue(localvus)) && (d(localvus.a())) && (localvus.a() != null))
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(localvus.a().id.get(), localvus);
        QLog.d(jdField_a_of_type_JavaLangString, 4, "add valid expose poll from scroll,index:" + localvus.a() + ",feedId:" + localvus.a().id.get() + ",pageId:" + this.jdField_b_of_type_Int);
        if (a(localvus.a().id.get(), localvus)) {
          QLog.d(jdField_a_of_type_JavaLangString, 4, "record feed stay event from scroll,index:" + localvus.a() + ",feedId:" + localvus.a().id.get() + ",pageId:" + this.jdField_b_of_type_Int);
        }
      }
    }
  }
  
  public QCircleReportBean a()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  }
  
  public void a()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onPageUnSelected,pageId:" + this.jdField_b_of_type_Int);
    c();
  }
  
  public void a(int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onPageSelected index:" + paramInt + ",pageId:" + this.jdField_b_of_type_Int);
    b();
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    a(paramViewHolder.itemView, false);
    paramViewHolder.itemView.setTag(2131378384, Boolean.valueOf(false));
    if (((paramViewHolder.itemView instanceof QCircleInsFeedItemView)) || ((paramViewHolder.itemView instanceof QCircleWaterfallFeedItemView)))
    {
      paramViewHolder = (QCircleBaseWidgetView)paramViewHolder.itemView;
      if ((paramViewHolder.a() instanceof FeedCloudMeta.StFeed))
      {
        FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)paramViewHolder.a();
        vus localvus = new vus();
        localvus.a(paramViewHolder);
        localvus.a(paramViewHolder.f());
        localvus.a(localStFeed);
        this.jdField_a_of_type_JavaUtilArrayList.add(localvus);
        QLog.d(jdField_a_of_type_JavaLangString, 4, "add collect poll from attach,index:" + localvus.a() + ",feedId:" + localStFeed.id.get() + ",pageId:" + this.jdField_b_of_type_Int);
      }
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    f();
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, RecyclerView.LayoutManager paramLayoutManager, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    while ((paramInt1 == 0) && (paramInt2 <= paramInt3) && (paramInt2 <= paramInt3)) {
      try
      {
        paramRecyclerView = paramLayoutManager.findViewByPosition(paramInt2);
        if (((paramRecyclerView instanceof QCircleInsFeedItemView)) || ((paramRecyclerView instanceof QCircleWaterfallFeedItemView)))
        {
          QCircleBaseWidgetView localQCircleBaseWidgetView = (QCircleBaseWidgetView)paramRecyclerView;
          if ((d(paramRecyclerView)) && ((localQCircleBaseWidgetView.a() instanceof FeedCloudMeta.StFeed)))
          {
            FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)localQCircleBaseWidgetView.a();
            String str = localStFeed.id.get();
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
            {
              vus localvus = new vus();
              localvus.a();
              localvus.a(paramRecyclerView);
              localvus.a(localQCircleBaseWidgetView.f());
              localvus.a(localStFeed);
              this.jdField_a_of_type_JavaUtilHashMap.put(str, localvus);
              QLog.d(jdField_a_of_type_JavaLangString, 4, "record feed stay event from idle,index:" + localQCircleBaseWidgetView.f() + ",feedId:" + str + ",pageId:" + this.jdField_b_of_type_Int);
            }
            if (c(paramRecyclerView))
            {
              a(paramRecyclerView, true);
              QLog.d(jdField_a_of_type_JavaLangString, 4, "report feed valid expose from idle,index:" + localQCircleBaseWidgetView.f() + ",feedId:" + str + ",pageId:" + this.jdField_b_of_type_Int);
            }
          }
        }
        paramInt2 += 1;
      }
      catch (Exception paramRecyclerView)
      {
        paramRecyclerView.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = a();
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "onResume" + ",pageId:" + this.jdField_b_of_type_Int);
      c("onResume");
      a("onResume");
      b("onResume");
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    vus localvus;
    while (((Iterator)localObject).hasNext())
    {
      localvus = (vus)((Iterator)localObject).next();
      if (paramViewHolder.itemView == localvus.a())
      {
        if (localvus.a() != null) {
          QLog.d(jdField_a_of_type_JavaLangString, 4, "remove collect expose poll from detach,index:" + localvus.a() + ",feedId:" + localvus.a().id.get() + ",pageId:" + this.jdField_b_of_type_Int);
        }
        ((Iterator)localObject).remove();
      }
    }
    localObject = a(paramViewHolder);
    if (((paramViewHolder.itemView instanceof QCircleInsFeedItemView)) || ((paramViewHolder.itemView instanceof QCircleWaterfallFeedItemView))) {}
    for (int i = ((QCircleBaseWidgetView)paramViewHolder.itemView).f();; i = -1)
    {
      if (localObject != null)
      {
        localObject = ((FeedCloudMeta.StFeed)localObject).id.get();
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject))
        {
          localvus = (vus)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
          if (localvus != null)
          {
            a(localvus);
            QLog.d(jdField_a_of_type_JavaLangString, 4, "report feed stay event from detach,index:" + i + ",feedId:" + (String)localObject + ",pageId:" + this.jdField_b_of_type_Int + ",stayTime:" + localvus.c() + "ms");
          }
          this.jdField_a_of_type_JavaUtilHashMap.remove(localObject);
        }
        if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(localObject))
        {
          if (c(paramViewHolder.itemView))
          {
            a(paramViewHolder.itemView, true);
            QLog.d(jdField_a_of_type_JavaLangString, 4, "report feed valid expose from detach,index:" + i + ",feedId:" + (String)localObject + ",pageId:" + this.jdField_b_of_type_Int);
          }
          this.jdField_b_of_type_JavaUtilHashMap.remove(localObject);
        }
        return;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 1, "onViewDetachedFromWindow holder miss feed data!pageId:" + this.jdField_b_of_type_Int);
      return;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = a();
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "onPause" + ",pageId:" + this.jdField_b_of_type_Int);
      b("onPause");
      d("onPause");
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = a();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "onRefresh,pageId:" + this.jdField_b_of_type_Int);
      d("onRefresh");
      b("onRefresh");
      ThreadManager.getUiHandler().postDelayed(new QCircleFeedReportScroller.1(this), 100L);
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (vus)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if (localObject != null)
      {
        a((vus)localObject);
        if (((vus)localObject).a() != null) {
          QLog.d(jdField_a_of_type_JavaLangString, 4, "report feed stay event from destory,index:" + ((vus)localObject).a() + ",feedId:" + ((vus)localObject).a().id.get() + ",pageId:" + this.jdField_b_of_type_Int + ",stayTime:" + ((vus)localObject).c() + "ms");
        }
      }
      localIterator.remove();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vur
 * JD-Core Version:    0.7.0.1
 */