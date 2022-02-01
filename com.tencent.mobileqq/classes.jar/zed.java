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

public class zed
  extends BaseAdapter
  implements AdapterView.OnItemClickListener, zeg
{
  private int jdField_a_of_type_Int;
  private List<zef> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public zed(@NonNull List<zef> paramList)
  {
    if (paramList.isEmpty()) {
      yqp.d("Q.qqstory.publish.editPermissionListAdapter", "part list is empty.");
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    a();
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((zef)paramList.next()).a(this);
    }
  }
  
  @NonNull
  private zee a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      zef localzef = (zef)localIterator.next();
      j = localzef.a() + i;
      if (paramInt <= j - 1) {
        return new zee(localzef, paramInt - i);
      }
    }
    throw new IllegalStateException("unable find PermissionPart, position:" + paramInt);
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((zef)localIterator.next()).a() + i) {}
    this.jdField_a_of_type_Int = i;
  }
  
  @Nullable
  public zef a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      zef localzef = (zef)localIterator.next();
      if (localzef.a) {
        return localzef;
      }
    }
    return null;
  }
  
  public void a(zef paramzef)
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
    zee localzee = a(paramInt);
    return localzee.jdField_a_of_type_Zef.a(localzee.jdField_a_of_type_Int);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    zee localzee = a(paramInt);
    zef localzef = localzee.jdField_a_of_type_Zef;
    int i = localzee.jdField_a_of_type_Int;
    if (paramView == null) {
      paramView = localzef.a(i, paramViewGroup);
    }
    for (;;)
    {
      localzef.a(i, paramView);
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
    zef localzef1 = ((zee)localObject).jdField_a_of_type_Zef;
    localzef1.a(((zee)localObject).jdField_a_of_type_Int);
    if ((localzef1 instanceof zec)) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      localzef1.b(true);
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        zef localzef2 = (zef)((Iterator)localObject).next();
        if (localzef2 != localzef1)
        {
          localzef2.b(false);
          localzef2.a(false);
        }
      }
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zed
 * JD-Core Version:    0.7.0.1
 */