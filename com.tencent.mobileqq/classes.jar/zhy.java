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

public class zhy
  extends BaseAdapter
  implements AdapterView.OnItemClickListener, zib
{
  private int jdField_a_of_type_Int;
  private List<zia> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public zhy(@NonNull List<zia> paramList)
  {
    if (paramList.isEmpty()) {
      yuk.d("Q.qqstory.publish.editPermissionListAdapter", "part list is empty.");
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    a();
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((zia)paramList.next()).a(this);
    }
  }
  
  @NonNull
  private zhz a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      zia localzia = (zia)localIterator.next();
      j = localzia.a() + i;
      if (paramInt <= j - 1) {
        return new zhz(localzia, paramInt - i);
      }
    }
    throw new IllegalStateException("unable find PermissionPart, position:" + paramInt);
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((zia)localIterator.next()).a() + i) {}
    this.jdField_a_of_type_Int = i;
  }
  
  @Nullable
  public zia a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      zia localzia = (zia)localIterator.next();
      if (localzia.a) {
        return localzia;
      }
    }
    return null;
  }
  
  public void a(zia paramzia)
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
    zhz localzhz = a(paramInt);
    return localzhz.jdField_a_of_type_Zia.a(localzhz.jdField_a_of_type_Int);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    zhz localzhz = a(paramInt);
    zia localzia = localzhz.jdField_a_of_type_Zia;
    int i = localzhz.jdField_a_of_type_Int;
    if (paramView == null) {
      paramView = localzia.a(i, paramViewGroup);
    }
    for (;;)
    {
      localzia.a(i, paramView);
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
    zia localzia1 = ((zhz)localObject).jdField_a_of_type_Zia;
    localzia1.a(((zhz)localObject).jdField_a_of_type_Int);
    if ((localzia1 instanceof zhx)) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      localzia1.b(true);
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        zia localzia2 = (zia)((Iterator)localObject).next();
        if (localzia2 != localzia1)
        {
          localzia2.b(false);
          localzia2.a(false);
        }
      }
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhy
 * JD-Core Version:    0.7.0.1
 */