import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView.a;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView.b;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView.c;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class qqo
  extends BaseAdapter
{
  StoryPickerHorizontalListView.b jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$b;
  StoryPickerHorizontalListView.c jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$c;
  StoryPickerHorizontalListView.a b;
  ArrayList<VideoCollectionItem> ed = new ArrayList();
  HashMap<String, WeakReference<qqo.a>> fp = new HashMap();
  Context mContext;
  
  public qqo(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131561969, paramViewGroup, false);
    paramViewGroup.setTag(new qqo.a(paramViewGroup, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$c));
    return paramViewGroup;
  }
  
  private void m(int paramInt, View paramView)
  {
    VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)this.ed.get(paramInt);
    ((qqo.a)paramView.getTag()).a(paramInt, localVideoCollectionItem);
  }
  
  public VideoCollectionItem a()
  {
    if (!this.ed.isEmpty()) {
      return (VideoCollectionItem)this.ed.get(this.ed.size() - 1);
    }
    return null;
  }
  
  public void a(StoryPickerHorizontalListView.a parama)
  {
    this.b = parama;
  }
  
  public void a(StoryPickerHorizontalListView.b paramb)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$b = paramb;
  }
  
  public void ca(List<VideoCollectionItem> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.ed.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.ed.size();
  }
  
  public List<VideoCollectionItem> getData()
  {
    return this.ed;
  }
  
  public Object getItem(int paramInt)
  {
    return this.ed.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = a(paramViewGroup);
    }
    for (;;)
    {
      m(paramInt, paramView);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
  
  public void l(String paramString, List<VideoCollectionItem.b> paramList)
  {
    WeakReference localWeakReference = (WeakReference)this.fp.get(paramString);
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((qql)((qqo.a)localWeakReference.get()).b.getAdapter()).o(paramList, paramString);
    }
  }
  
  public void setData(List<VideoCollectionItem> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.ed.clear();
      this.ed.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public void setOnHorizontalScrollListener(StoryPickerHorizontalListView.c paramc)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$c = paramc;
  }
  
  class a
  {
    public StoryPickerHorizontalListView b;
    public TextView xM;
    
    public a(View paramView, StoryPickerHorizontalListView.c paramc)
    {
      this.xM = ((TextView)paramView.findViewById(2131365621));
      this.jdField_b_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView = ((StoryPickerHorizontalListView)paramView.findViewById(2131368624));
      this.jdField_b_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setSelection(0);
      this.jdField_b_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setOnHorizontalScrollListener(paramc);
      paramView = (qql)this.jdField_b_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.getAdapter();
      paramView.a(qqo.this.a);
      paramView.a(qqo.this.b);
    }
    
    public void a(int paramInt, VideoCollectionItem paramVideoCollectionItem)
    {
      this.jdField_b_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setData(paramVideoCollectionItem.collectionVideoUIItemList, paramVideoCollectionItem.collectionId);
      this.jdField_b_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setTag(Integer.valueOf(paramInt));
      this.xM.setText(roq.aI(paramVideoCollectionItem.collectionTime));
      this.jdField_b_of_type_Qqo.fp.put(paramVideoCollectionItem.collectionId, new WeakReference(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqo
 * JD-Core Version:    0.7.0.1
 */