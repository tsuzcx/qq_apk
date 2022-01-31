import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class unn
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  ArrayList<VideoCollectionItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, WeakReference<uno>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  unk jdField_a_of_type_Unk;
  unl jdField_a_of_type_Unl;
  unm jdField_a_of_type_Unm;
  
  public unn(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561368, paramViewGroup, false);
    paramViewGroup.setTag(new uno(this, paramViewGroup, this.jdField_a_of_type_Unm));
    return paramViewGroup;
  }
  
  private void a(int paramInt, View paramView)
  {
    VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    ((uno)paramView.getTag()).a(paramInt, localVideoCollectionItem);
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
  
  public void a(String paramString, List<uuc> paramList)
  {
    WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((ung)((uno)localWeakReference.get()).a.a()).b(paramList, paramString);
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
  
  public void a(unk paramunk)
  {
    this.jdField_a_of_type_Unk = paramunk;
  }
  
  public void a(unl paramunl)
  {
    this.jdField_a_of_type_Unl = paramunl;
  }
  
  public void a(unm paramunm)
  {
    this.jdField_a_of_type_Unm = paramunm;
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
    View localView = paramView;
    if (paramView == null) {
      localView = a(paramViewGroup);
    }
    a(paramInt, localView);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     unn
 * JD-Core Version:    0.7.0.1
 */