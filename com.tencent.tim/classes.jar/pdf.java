import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
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
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class pdf
  extends pcz
{
  private static String TAG = "QCircleFeedReportHelper";
  private volatile boolean azk;
  private HashMap<String, pdf.a> eY = new HashMap();
  private ArrayList<RecyclerView.ViewHolder> mt = new ArrayList();
  
  private FeedCloudMeta.StFeed a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder != null) && ((paramViewHolder.itemView instanceof BaseWidgetView)) && ((((BaseWidgetView)paramViewHolder.itemView).getData() instanceof FeedCloudMeta.StFeed))) {
      return (FeedCloudMeta.StFeed)((BaseWidgetView)paramViewHolder.itemView).getData();
    }
    return null;
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
        break label172;
      }
      localArrayList.add(pcr.a("ext1", "1"));
      localArrayList.add(pcr.a("ext2", "0"));
      localArrayList.add(pcr.a("ext3", paramStFeed.images.size() + ""));
    }
    for (;;)
    {
      pcp.a(1, 1, paramArrayOfInt[0], paramArrayOfInt[1], paramStFeed, 1, paramInt, str, localArrayList);
      return;
      str = "";
      break;
      label172:
      if (paramStFeed.type.get() == 3) {
        localArrayList.add(pcr.a("ext1", "2"));
      }
    }
  }
  
  private void a(pdf.a parama)
  {
    if (parama != null)
    {
      FeedCloudMeta.StFeed localStFeed = pdf.a.a(parama);
      int[] arrayOfInt = a(localStFeed);
      long l = System.currentTimeMillis();
      parama.setEndTime(l);
      parama.eZ(l - parama.getStartTime());
      pcm.a(localStFeed.poster.id.get(), arrayOfInt[0], arrayOfInt[1], parama.getPosition(), localStFeed.id.get(), b(localStFeed), String.valueOf(parama.getStartTime()), String.valueOf(parama.getEndTime()), String.valueOf(parama.getStayTime()), localStFeed.poster.id.get(), localStFeed, null);
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
  
  public static String b(FeedCloudMeta.StFeed paramStFeed)
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
  
  private void bjI()
  {
    if (!this.azk)
    {
      QLog.d(TAG, 4, "checkFirstScreenFeedExpose report expose size:" + this.mt.size());
      int i = 0;
      while (i < this.mt.size())
      {
        g((RecyclerView.ViewHolder)this.mt.get(i));
        i += 1;
      }
      this.azk = true;
    }
    this.mt.clear();
  }
  
  private void g(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = 0;
    if (paramViewHolder != null) {
      try
      {
        View localView = paramViewHolder.itemView;
        if (localView == null) {
          return;
        }
        Rect localRect = new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight());
        localView.getGlobalVisibleRect(localRect);
        int j = localView.getHeight();
        if (localRect.bottom > 0) {
          i = localRect.bottom - localRect.top;
        }
        if (i / j >= 0.5D)
        {
          QLog.d(TAG, 4, "report feed valid expose index:" + paramViewHolder.getLayoutPosition());
          r(paramViewHolder.itemView, true);
          return;
        }
      }
      catch (Exception paramViewHolder)
      {
        QLog.e(TAG, 1, "checkFeedExpose exception:" + paramViewHolder.toString());
      }
    }
  }
  
  private void r(View paramView, boolean paramBoolean)
  {
    FeedCloudMeta.StFeed localStFeed;
    int[] arrayOfInt;
    int j;
    int i;
    if ((paramView instanceof QCircleFeedWidget))
    {
      localStFeed = (FeedCloudMeta.StFeed)((QCircleFeedWidget)paramView).getData();
      if (localStFeed != null)
      {
        arrayOfInt = a(localStFeed);
        j = ((QCircleFeedWidget)paramView).getPosition();
        if (!paramBoolean) {
          break label111;
        }
        i = 2;
        a(localStFeed, arrayOfInt, j);
      }
    }
    for (;;)
    {
      pcl.a(localStFeed.poster.id.get(), arrayOfInt[0], arrayOfInt[1], i, 1, j, localStFeed.id.get(), b(localStFeed), localStFeed.poster.id.get(), -1, localStFeed, null);
      return;
      label111:
      i = 1;
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramInt1 = 0;
    bjI();
    paramRecyclerView = this.eY.keySet().iterator();
    if (paramRecyclerView.hasNext())
    {
      Object localObject = (String)paramRecyclerView.next();
      localObject = (pdf.a)this.eY.get(localObject);
      if ((localObject != null) && (((pdf.a)localObject).a() != null))
      {
        Rect localRect = new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight());
        ((pdf.a)localObject).a().getGlobalVisibleRect(localRect);
        paramInt2 = ((pdf.a)localObject).a().getHeight();
        if (localRect.bottom > 0) {
          paramInt1 = localRect.bottom - localRect.top;
        }
        if (paramInt1 / paramInt2 < 0.5D)
        {
          a((pdf.a)localObject);
          paramRecyclerView.remove();
          QLog.d(TAG, 4, "report from scroll:" + ((pdf.a)localObject).getFeed().id.get());
        }
      }
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, rxy paramrxy, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    QLog.d(TAG, 4, "onScrollStateChanged" + paramInt1);
    for (;;)
    {
      if ((paramInt1 == 0) && (paramInt2 <= paramInt3) && (paramInt2 <= paramInt3)) {
        try
        {
          paramRecyclerView = paramrxy.findViewByPosition(paramInt2);
          if (((paramRecyclerView instanceof QCircleFeedWidget)) && (D(paramRecyclerView)) && ((((QCircleFeedWidget)paramRecyclerView).getData() instanceof FeedCloudMeta.StFeed)))
          {
            String str = ((FeedCloudMeta.StFeed)((QCircleFeedWidget)paramRecyclerView).getData()).id.get();
            if (!this.eY.containsKey(str))
            {
              pdf.a locala = new pdf.a();
              locala.setStartTime(System.currentTimeMillis());
              locala.a((QCircleFeedWidget)paramRecyclerView);
              locala.setPosition(((QCircleFeedWidget)paramRecyclerView).getPosition());
              locala.setFeed((FeedCloudMeta.StFeed)((QCircleFeedWidget)paramRecyclerView).getData());
              this.eY.put(str, locala);
            }
            QLog.d(TAG, 4, "feed record report start:");
            QLog.d(TAG, 4, "report feed valid expose index:" + paramInt2);
            r(paramRecyclerView, true);
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
  
  public void onDestroy()
  {
    Iterator localIterator = this.eY.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      a((pdf.a)this.eY.get(str));
      localIterator.remove();
    }
    bjI();
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.d(TAG, 4, "onViewAttachedToWindow" + paramViewHolder);
    r(paramViewHolder.itemView, false);
    if (!this.azk)
    {
      this.mt.add(paramViewHolder);
      if (((paramViewHolder.itemView instanceof QCircleFeedWidget)) && ((((QCircleFeedWidget)paramViewHolder.itemView).getData() instanceof FeedCloudMeta.StFeed)))
      {
        pdf.a locala = new pdf.a();
        locala.setStartTime(System.currentTimeMillis());
        locala.a((QCircleFeedWidget)paramViewHolder.itemView);
        locala.setPosition(((QCircleFeedWidget)paramViewHolder.itemView).getPosition());
        locala.setFeed((FeedCloudMeta.StFeed)((QCircleFeedWidget)paramViewHolder.itemView).getData());
        this.eY.put(((FeedCloudMeta.StFeed)((QCircleFeedWidget)paramViewHolder.itemView).getData()).id.get(), locala);
      }
    }
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.d(TAG, 4, "onViewDetachedFromWindow" + paramViewHolder);
    paramViewHolder = a(paramViewHolder);
    if ((paramViewHolder != null) && (this.eY.containsKey(paramViewHolder.id.get())))
    {
      a((pdf.a)this.eY.get(paramViewHolder.id.get()));
      this.eY.remove(paramViewHolder.id.get());
      QLog.d(TAG, 4, "report from detach: " + paramViewHolder.id.get());
    }
  }
  
  public static class a
  {
    private QCircleFeedWidget a;
    private long fq;
    private FeedCloudMeta.StFeed g;
    private long mEndTime;
    private int mPosition;
    private long mStartTime;
    
    public QCircleFeedWidget a()
    {
      return this.a;
    }
    
    public void a(QCircleFeedWidget paramQCircleFeedWidget)
    {
      this.a = paramQCircleFeedWidget;
    }
    
    public void eZ(long paramLong)
    {
      this.fq = paramLong;
    }
    
    public long getEndTime()
    {
      return this.mEndTime;
    }
    
    public FeedCloudMeta.StFeed getFeed()
    {
      return this.g;
    }
    
    public int getPosition()
    {
      return this.mPosition;
    }
    
    public long getStartTime()
    {
      return this.mStartTime;
    }
    
    public long getStayTime()
    {
      return this.fq;
    }
    
    public void setEndTime(long paramLong)
    {
      this.mEndTime = paramLong;
    }
    
    public void setFeed(FeedCloudMeta.StFeed paramStFeed)
    {
      this.g = paramStFeed;
    }
    
    public void setPosition(int paramInt)
    {
      this.mPosition = paramInt;
    }
    
    public void setStartTime(long paramLong)
    {
      this.mStartTime = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pdf
 * JD-Core Version:    0.7.0.1
 */