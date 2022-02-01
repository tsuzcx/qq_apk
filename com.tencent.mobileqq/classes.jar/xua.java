import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class xua
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  ArrayList<VideoCollectionItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, WeakReference<xub>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  xtx jdField_a_of_type_Xtx;
  xty jdField_a_of_type_Xty;
  xtz jdField_a_of_type_Xtz;
  
  public xua(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561798, paramViewGroup, false);
    paramViewGroup.setTag(new xub(this, paramViewGroup, this.jdField_a_of_type_Xtz));
    return paramViewGroup;
  }
  
  private void a(int paramInt, View paramView)
  {
    VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    ((xub)paramView.getTag()).a(paramInt, localVideoCollectionItem);
  }
  
  public VideoCollectionItem a()
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return (VideoCollectionItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    }
    return null;
  }
  
  public List<VideoCollectionItem> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(String paramString, List<yap> paramList)
  {
    WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((xtt)((xub)localWeakReference.get()).a.a()).b(paramList, paramString);
    }
  }
  
  public void a(List<VideoCollectionItem> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public void a(xtx paramxtx)
  {
    this.jdField_a_of_type_Xtx = paramxtx;
  }
  
  public void a(xty paramxty)
  {
    this.jdField_a_of_type_Xty = paramxty;
  }
  
  public void a(xtz paramxtz)
  {
    this.jdField_a_of_type_Xtz = paramxtz;
  }
  
  public void b(List<VideoCollectionItem> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
      a(paramInt, paramView);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xua
 * JD-Core Version:    0.7.0.1
 */