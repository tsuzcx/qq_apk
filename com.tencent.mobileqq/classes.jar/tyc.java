import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleFeedWidget;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class tyc
  extends RecyclerView.OnScrollListener
{
  private static String jdField_a_of_type_JavaLangString = "QCircleFeedReportHelper";
  private ArrayList<RecyclerView.ViewHolder> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, tyd> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  
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
    FeedCloudMeta.StFeed localStFeed;
    int[] arrayOfInt;
    int j;
    if ((paramView instanceof QCircleFeedWidget))
    {
      localStFeed = (FeedCloudMeta.StFeed)((QCircleFeedWidget)paramView).a();
      if (localStFeed != null)
      {
        arrayOfInt = a(localStFeed);
        j = ((QCircleFeedWidget)paramView).b();
        if (!paramBoolean) {
          break label101;
        }
      }
    }
    label101:
    for (int i = 2;; i = 1)
    {
      tyg.a(localStFeed.poster.id.get(), arrayOfInt[0], arrayOfInt[1], i, 1, j, localStFeed.id.get(), a(localStFeed), localStFeed.poster.id.get(), -1, localStFeed, null);
      return;
    }
  }
  
  private void a(tyd paramtyd)
  {
    if (paramtyd != null)
    {
      FeedCloudMeta.StFeed localStFeed = tyd.a(paramtyd);
      int[] arrayOfInt = a(localStFeed);
      long l = System.currentTimeMillis();
      paramtyd.b(l);
      paramtyd.c(l - paramtyd.a());
      tyh.a(localStFeed.poster.id.get(), arrayOfInt[0], arrayOfInt[1], paramtyd.a(), localStFeed.id.get(), a(localStFeed), String.valueOf(paramtyd.a()), String.valueOf(paramtyd.b()), String.valueOf(paramtyd.c()), localStFeed.poster.id.get(), localStFeed, null);
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
  
  private void b()
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
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      a((tyd)this.jdField_a_of_type_JavaUtilHashMap.get(str));
      localIterator.remove();
    }
    b();
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onViewAttachedToWindow" + paramViewHolder);
    a(paramViewHolder.itemView, false);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramViewHolder);
      if (((paramViewHolder.itemView instanceof QCircleFeedWidget)) && ((((QCircleFeedWidget)paramViewHolder.itemView).a() instanceof FeedCloudMeta.StFeed)))
      {
        tyd localtyd = new tyd();
        localtyd.a(System.currentTimeMillis());
        localtyd.a((QCircleFeedWidget)paramViewHolder.itemView);
        localtyd.a(((QCircleFeedWidget)paramViewHolder.itemView).b());
        localtyd.a((FeedCloudMeta.StFeed)((QCircleFeedWidget)paramViewHolder.itemView).a());
        this.jdField_a_of_type_JavaUtilHashMap.put(((FeedCloudMeta.StFeed)((QCircleFeedWidget)paramViewHolder.itemView).a()).id.get(), localtyd);
      }
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onViewDetachedFromWindow" + paramViewHolder);
    paramViewHolder = a(paramViewHolder);
    if ((paramViewHolder != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramViewHolder.id.get())))
    {
      a((tyd)this.jdField_a_of_type_JavaUtilHashMap.get(paramViewHolder.id.get()));
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramViewHolder.id.get());
      QLog.d(jdField_a_of_type_JavaLangString, 4, "report from detach: " + paramViewHolder.id.get());
    }
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onScrollStateChanged" + paramInt);
    if ((paramInt == 0) && (paramRecyclerView != null)) {}
    for (;;)
    {
      try
      {
        if ((paramRecyclerView.getLayoutManager() instanceof yee))
        {
          paramRecyclerView = (yee)paramRecyclerView.getLayoutManager();
          Object localObject1 = paramRecyclerView.findFirstVisibleItemPositions(null);
          Object localObject2 = paramRecyclerView.findLastVisibleItemPositions(null);
          paramInt = localObject1[0];
          int j = localObject2[0];
          QLog.d(jdField_a_of_type_JavaLangString, 4, paramInt + "  " + j);
          if (paramInt <= j) {
            if (paramInt <= j)
            {
              localObject1 = paramRecyclerView.findViewByPosition(paramInt);
              if ((localObject1 instanceof QCircleFeedWidget))
              {
                localObject2 = new Rect(0, 0, ImmersiveUtils.a(), ImmersiveUtils.b());
                ((View)localObject1).getGlobalVisibleRect((Rect)localObject2);
                int k = ((View)localObject1).getHeight();
                if (((Rect)localObject2).bottom <= 0) {
                  break label459;
                }
                i = ((Rect)localObject2).bottom - ((Rect)localObject2).top;
                float f = i / k;
                QLog.d(jdField_a_of_type_JavaLangString, 4, " state change :" + ((Rect)localObject2).top + " " + ((Rect)localObject2).bottom + " " + i + "  " + k + " " + f);
                if ((f >= 0.5D) && ((((QCircleFeedWidget)localObject1).a() instanceof FeedCloudMeta.StFeed)))
                {
                  localObject2 = ((FeedCloudMeta.StFeed)((QCircleFeedWidget)localObject1).a()).id.get();
                  if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2))
                  {
                    tyd localtyd = new tyd();
                    localtyd.a(System.currentTimeMillis());
                    localtyd.a((QCircleFeedWidget)localObject1);
                    localtyd.a(((QCircleFeedWidget)localObject1).b());
                    localtyd.a((FeedCloudMeta.StFeed)((QCircleFeedWidget)localObject1).a());
                    this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, localtyd);
                  }
                  QLog.d(jdField_a_of_type_JavaLangString, 4, "feed record report start:");
                  QLog.d(jdField_a_of_type_JavaLangString, 4, "report feed valid expose index:" + paramInt);
                  a((View)localObject1, true);
                }
              }
              paramInt += 1;
              continue;
            }
          }
        }
        return;
      }
      catch (Exception paramRecyclerView)
      {
        paramRecyclerView.printStackTrace();
      }
      label459:
      int i = 0;
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    int i = 0;
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    b();
    paramRecyclerView = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    if (paramRecyclerView.hasNext())
    {
      Object localObject = (String)paramRecyclerView.next();
      localObject = (tyd)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if ((localObject != null) && (((tyd)localObject).a() != null))
      {
        Rect localRect = new Rect(0, 0, ImmersiveUtils.a(), ImmersiveUtils.b());
        ((tyd)localObject).a().getGlobalVisibleRect(localRect);
        paramInt2 = ((tyd)localObject).a().getHeight();
        paramInt1 = i;
        if (localRect.bottom > 0) {
          paramInt1 = localRect.bottom - localRect.top;
        }
        if (paramInt1 / paramInt2 < 0.5D)
        {
          a((tyd)localObject);
          paramRecyclerView.remove();
          QLog.d(jdField_a_of_type_JavaLangString, 4, "report from scroll:" + ((tyd)localObject).a().id.get());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyc
 * JD-Core Version:    0.7.0.1
 */