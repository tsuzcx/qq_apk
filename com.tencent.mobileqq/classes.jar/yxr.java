import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class yxr
  extends BaseAdapter
  implements AdapterView.OnItemClickListener, yxu
{
  private int jdField_a_of_type_Int;
  private List<yxt> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public yxr(@NonNull List<yxt> paramList)
  {
    if (paramList.isEmpty()) {
      ykq.d("Q.qqstory.publish.editPermissionListAdapter", "part list is empty.");
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    a();
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((yxt)paramList.next()).a(this);
    }
  }
  
  @NonNull
  private yxs a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      yxt localyxt = (yxt)localIterator.next();
      j = localyxt.a() + i;
      if (paramInt <= j - 1) {
        return new yxs(localyxt, paramInt - i);
      }
    }
    throw new IllegalStateException("unable find PermissionPart, position:" + paramInt);
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((yxt)localIterator.next()).a() + i) {}
    this.jdField_a_of_type_Int = i;
  }
  
  @Nullable
  public yxt a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      yxt localyxt = (yxt)localIterator.next();
      if (localyxt.a) {
        return localyxt;
      }
    }
    return null;
  }
  
  public void a(yxt paramyxt)
  {
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    yxs localyxs = a(paramInt);
    return localyxs.jdField_a_of_type_Yxt.a(localyxs.jdField_a_of_type_Int);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    yxs localyxs = a(paramInt);
    yxt localyxt = localyxs.jdField_a_of_type_Yxt;
    int i = localyxs.jdField_a_of_type_Int;
    if (paramView == null) {
      paramView = localyxt.a(i, paramViewGroup);
    }
    for (;;)
    {
      localyxt.a(i, paramView);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = a(paramInt);
    yxt localyxt1 = ((yxs)localObject).jdField_a_of_type_Yxt;
    localyxt1.a(((yxs)localObject).jdField_a_of_type_Int);
    if ((localyxt1 instanceof yxq)) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      localyxt1.b(true);
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        yxt localyxt2 = (yxt)((Iterator)localObject).next();
        if (localyxt2 != localyxt1)
        {
          localyxt2.b(false);
          localyxt2.a(false);
        }
      }
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yxr
 * JD-Core Version:    0.7.0.1
 */