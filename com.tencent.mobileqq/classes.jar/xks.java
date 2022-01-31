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

public class xks
  extends BaseAdapter
  implements AdapterView.OnItemClickListener, xkv
{
  private int jdField_a_of_type_Int;
  private List<xku> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public xks(@NonNull List<xku> paramList)
  {
    if (paramList.isEmpty()) {
      wxe.d("Q.qqstory.publish.editPermissionListAdapter", "part list is empty.");
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    a();
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((xku)paramList.next()).a(this);
    }
  }
  
  @NonNull
  private xkt a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      xku localxku = (xku)localIterator.next();
      j = localxku.a() + i;
      if (paramInt <= j - 1) {
        return new xkt(localxku, paramInt - i);
      }
    }
    throw new IllegalStateException("unable find PermissionPart, position:" + paramInt);
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((xku)localIterator.next()).a() + i) {}
    this.jdField_a_of_type_Int = i;
  }
  
  @Nullable
  public xku a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      xku localxku = (xku)localIterator.next();
      if (localxku.a) {
        return localxku;
      }
    }
    return null;
  }
  
  public void a(xku paramxku)
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
    xkt localxkt = a(paramInt);
    return localxkt.jdField_a_of_type_Xku.a(localxkt.jdField_a_of_type_Int);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = a(paramInt);
    xku localxku = ((xkt)localObject).jdField_a_of_type_Xku;
    paramInt = ((xkt)localObject).jdField_a_of_type_Int;
    localObject = paramView;
    if (paramView == null) {
      localObject = localxku.a(paramInt, paramViewGroup);
    }
    localxku.a(paramInt, (View)localObject);
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
    paramAdapterView = paramView.jdField_a_of_type_Xku;
    paramAdapterView.a(paramView.jdField_a_of_type_Int);
    if ((paramAdapterView instanceof xkr)) {
      return;
    }
    paramAdapterView.b(true);
    paramView = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramView.hasNext())
    {
      xku localxku = (xku)paramView.next();
      if (localxku != paramAdapterView)
      {
        localxku.b(false);
        localxku.a(false);
      }
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xks
 * JD-Core Version:    0.7.0.1
 */