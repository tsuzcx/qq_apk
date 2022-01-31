import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vey
  extends BaseAdapter
  implements AdapterView.OnItemClickListener, vfb
{
  private int jdField_a_of_type_Int;
  private List<vfa> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public vey(@NonNull List<vfa> paramList)
  {
    if (paramList.isEmpty()) {
      urk.d("Q.qqstory.publish.editPermissionListAdapter", "part list is empty.");
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    a();
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((vfa)paramList.next()).a(this);
    }
  }
  
  @NonNull
  private vez a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      vfa localvfa = (vfa)localIterator.next();
      j = localvfa.a() + i;
      if (paramInt <= j - 1) {
        return new vez(localvfa, paramInt - i);
      }
    }
    throw new IllegalStateException("unable find PermissionPart, position:" + paramInt);
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((vfa)localIterator.next()).a() + i) {}
    this.jdField_a_of_type_Int = i;
  }
  
  @Nullable
  public vfa a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      vfa localvfa = (vfa)localIterator.next();
      if (localvfa.a) {
        return localvfa;
      }
    }
    return null;
  }
  
  public void a(vfa paramvfa)
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
    vez localvez = a(paramInt);
    return localvez.jdField_a_of_type_Vfa.a(localvez.jdField_a_of_type_Int);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = a(paramInt);
    vfa localvfa = ((vez)localObject).jdField_a_of_type_Vfa;
    paramInt = ((vez)localObject).jdField_a_of_type_Int;
    localObject = paramView;
    if (paramView == null) {
      localObject = localvfa.a(paramInt, paramViewGroup);
    }
    localvfa.a(paramInt, (View)localObject);
    return localObject;
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
    paramView = a(paramInt);
    paramAdapterView = paramView.jdField_a_of_type_Vfa;
    paramAdapterView.a(paramView.jdField_a_of_type_Int);
    if ((paramAdapterView instanceof vex)) {
      return;
    }
    paramAdapterView.b(true);
    paramView = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramView.hasNext())
    {
      vfa localvfa = (vfa)paramView.next();
      if (localvfa != paramAdapterView)
      {
        localvfa.b(false);
        localvfa.a(false);
      }
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vey
 * JD-Core Version:    0.7.0.1
 */