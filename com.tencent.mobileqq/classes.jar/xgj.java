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

public class xgj
  extends BaseAdapter
  implements AdapterView.OnItemClickListener, xgm
{
  private int jdField_a_of_type_Int;
  private List<xgl> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public xgj(@NonNull List<xgl> paramList)
  {
    if (paramList.isEmpty()) {
      wsv.d("Q.qqstory.publish.editPermissionListAdapter", "part list is empty.");
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    a();
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((xgl)paramList.next()).a(this);
    }
  }
  
  @NonNull
  private xgk a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      xgl localxgl = (xgl)localIterator.next();
      j = localxgl.a() + i;
      if (paramInt <= j - 1) {
        return new xgk(localxgl, paramInt - i);
      }
    }
    throw new IllegalStateException("unable find PermissionPart, position:" + paramInt);
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((xgl)localIterator.next()).a() + i) {}
    this.jdField_a_of_type_Int = i;
  }
  
  @Nullable
  public xgl a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      xgl localxgl = (xgl)localIterator.next();
      if (localxgl.a) {
        return localxgl;
      }
    }
    return null;
  }
  
  public void a(xgl paramxgl)
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
    xgk localxgk = a(paramInt);
    return localxgk.jdField_a_of_type_Xgl.a(localxgk.jdField_a_of_type_Int);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = a(paramInt);
    xgl localxgl = ((xgk)localObject).jdField_a_of_type_Xgl;
    paramInt = ((xgk)localObject).jdField_a_of_type_Int;
    localObject = paramView;
    if (paramView == null) {
      localObject = localxgl.a(paramInt, paramViewGroup);
    }
    localxgl.a(paramInt, (View)localObject);
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
    paramAdapterView = paramView.jdField_a_of_type_Xgl;
    paramAdapterView.a(paramView.jdField_a_of_type_Int);
    if ((paramAdapterView instanceof xgi)) {
      return;
    }
    paramAdapterView.b(true);
    paramView = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramView.hasNext())
    {
      xgl localxgl = (xgl)paramView.next();
      if (localxgl != paramAdapterView)
      {
        localxgl.b(false);
        localxgl.a(false);
      }
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xgj
 * JD-Core Version:    0.7.0.1
 */