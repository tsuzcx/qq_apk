import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.shareGroup.infocard.view.MyMemoriesListView.b;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.a;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.b;
import com.tencent.biz.qqstory.storyHome.memory.view.MemoriesInnerListView.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class qpx
  extends BaseAdapter
{
  protected MyMemoriesListView.b a;
  protected VideoCollectionItem.a a;
  protected MemoriesInnerListView.a a;
  protected Context mContext;
  private final int mScreenHeight;
  protected ArrayList<VideoCollectionItem> ne = new ArrayList();
  
  public qpx(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem$a = new VideoCollectionItem.a();
    this.mContext = paramContext;
    this.mScreenHeight = (paramContext.getResources().getDisplayMetrics().heightPixels - rpq.dip2px(this.mContext, 60.0F));
    tb(true);
  }
  
  private VideoCollectionItem a(int paramInt)
  {
    ram.i("Q.qqstory.home.BaseStoryTimeLineAdapter", "getSimpleFakeItem");
    VideoCollectionItem localVideoCollectionItem = new VideoCollectionItem();
    localVideoCollectionItem.collectionId = String.valueOf(paramInt);
    localVideoCollectionItem.collectionTime = -1L;
    localVideoCollectionItem.key = "local_empty_item";
    localVideoCollectionItem.isEmptyFakeItem = true;
    return localVideoCollectionItem;
  }
  
  protected void D(List<VideoCollectionItem> paramList, boolean paramBoolean)
  {
    if (paramList.size() == 0) {
      tb(true);
    }
    int j;
    int i;
    do
    {
      return;
      tb(false);
      j = this.mScreenHeight - rpq.dip2px(this.mContext, 100.0F);
      Iterator localIterator = paramList.iterator();
      i = j;
      while (localIterator.hasNext())
      {
        VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)localIterator.next();
        b(localVideoCollectionItem);
        if (paramList.size() <= 3)
        {
          if (localVideoCollectionItem.collectionType == 0) {
            i -= rpq.dip2px(this.mContext, 65.0F);
          }
          for (;;)
          {
            break;
            if (!TextUtils.isEmpty(roq.b(localVideoCollectionItem.collectionTime)[0])) {
              i -= rpq.dip2px(this.mContext, 190.0F);
            } else {
              i -= rpq.dip2px(this.mContext, 150.0F);
            }
          }
        }
      }
    } while ((X(paramBoolean)) || (i == j) || (i <= 0));
    this.ne.add(a(i));
  }
  
  public void E(List<VideoCollectionItem> paramList, boolean paramBoolean)
  {
    F(paramList, paramBoolean);
    notifyDataSetChanged();
  }
  
  protected void F(List<VideoCollectionItem> paramList, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.ne.size() > 0)
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)this.ne.get(this.ne.size() - 1);
      localObject1 = localObject2;
      if (localVideoCollectionItem.isEmptyFakeItem)
      {
        ram.w("Q.qqstory.home.BaseStoryTimeLineAdapter", "addData, has fake");
        this.ne.remove(this.ne.size() - 1);
        localObject1 = localVideoCollectionItem;
      }
    }
    ram.b("Q.qqstory.home.BaseStoryTimeLineAdapter", "addData, new dataList=%s", paramList);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      b((VideoCollectionItem)paramList.next());
    }
    if (localObject1 != null)
    {
      this.ne.add(localObject1);
      ram.d("Q.qqstory.home.BaseStoryTimeLineAdapter", "add fake item.");
    }
    X(paramBoolean);
  }
  
  public abstract boolean X(boolean paramBoolean);
  
  public VideoCollectionItem a()
  {
    if (this.ne.size() > 0)
    {
      VideoCollectionItem localVideoCollectionItem2 = (VideoCollectionItem)this.ne.get(this.ne.size() - 1);
      VideoCollectionItem localVideoCollectionItem1;
      if (localVideoCollectionItem2.isEmptyFakeItem)
      {
        if (this.ne.size() >= 2)
        {
          localVideoCollectionItem1 = (VideoCollectionItem)this.ne.get(this.ne.size() - 2);
          if (TextUtils.isEmpty(localVideoCollectionItem1.collectionId)) {}
        }
      }
      else {
        do
        {
          return localVideoCollectionItem1;
          localVideoCollectionItem1 = localVideoCollectionItem2;
        } while (!TextUtils.isEmpty(localVideoCollectionItem2.collectionId));
      }
    }
    return null;
  }
  
  protected void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ram.b("Q.qqstory.home.BaseStoryTimeLineAdapter", "bindview. postion=%d", Integer.valueOf(paramInt));
    paramViewGroup = (VideoCollectionItem)this.ne.get(paramInt);
    ((qpx.a)paramView.getTag()).a(paramViewGroup, paramView, paramInt);
  }
  
  public void a(MemoriesInnerListView.a parama, MyMemoriesListView.b paramb)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewMemoriesInnerListView$a = parama;
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$b = paramb;
  }
  
  protected void b(VideoCollectionItem paramVideoCollectionItem)
  {
    if (this.ne.indexOf(paramVideoCollectionItem) > 0) {
      ram.d("Q.qqstory.home.BaseStoryTimeLineAdapter", "data already exist, id=%s, time=%d", paramVideoCollectionItem.collectionId, Long.valueOf(paramVideoCollectionItem.collectionTime));
    }
    do
    {
      return;
      i = Collections.binarySearch(this.ne, paramVideoCollectionItem, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem$a);
    } while (i >= 0);
    int i = -i;
    this.ne.add(i - 1, paramVideoCollectionItem);
  }
  
  public void bpC()
  {
    clearData();
    b(VideoCollectionItem.getProfilePlaceholderItem(QQStoryContext.a().getCurrentUid()));
  }
  
  public ArrayList<VideoCollectionItem> bt()
  {
    return this.ne;
  }
  
  protected void clearData()
  {
    this.ne.clear();
  }
  
  protected abstract View d(int paramInt, ViewGroup paramViewGroup);
  
  public int getCount()
  {
    return this.ne.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.ne.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((VideoCollectionItem)this.ne.get(paramInt)).collectionType;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = d(paramInt, paramViewGroup);
    }
    for (;;)
    {
      if (paramView != null) {
        a(paramInt, paramView, paramViewGroup);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return VideoCollectionItem.TYPE_ORDER.length;
  }
  
  public boolean isEmpty()
  {
    return getCount() <= 1;
  }
  
  protected abstract boolean isSelf();
  
  public abstract void l(String paramString, List<VideoCollectionItem.b> paramList);
  
  public void setData(List<VideoCollectionItem> paramList, boolean paramBoolean)
  {
    ram.b("Q.qqstory.home.BaseStoryTimeLineAdapter", "setData, dataList size=%d", Integer.valueOf(paramList.size()));
    clearData();
    D(paramList, paramBoolean);
    notifyDataSetChanged();
  }
  
  protected void tb(boolean paramBoolean)
  {
    b(VideoCollectionItem.getProfilePlaceholderItem(QQStoryContext.a().getCurrentUid()));
    if ((isSelf()) && (paramBoolean))
    {
      b(VideoCollectionItem.getCurrentYearFakeItem(QQStoryContext.a().getCurrentUid()));
      b(VideoCollectionItem.getTodayFakeItem(QQStoryContext.a().getCurrentUid()));
      int i = this.mScreenHeight;
      int j = rpq.dip2px(this.mContext, 100.0F);
      int k = rpq.dip2px(this.mContext, 65.0F);
      int m = rpq.dip2px(this.mContext, 150.0F);
      this.ne.add(a(i - j - k - m));
    }
  }
  
  public static abstract class a
  {
    public int type;
    
    public abstract void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qpx
 * JD-Core Version:    0.7.0.1
 */