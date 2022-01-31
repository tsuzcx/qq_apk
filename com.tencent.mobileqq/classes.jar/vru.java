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

public class vru
  extends BaseAdapter
  implements AdapterView.OnItemClickListener, vrx
{
  private int jdField_a_of_type_Int;
  private List<vrw> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public vru(@NonNull List<vrw> paramList)
  {
    if (paramList.isEmpty()) {
      veg.d("Q.qqstory.publish.editPermissionListAdapter", "part list is empty.");
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    a();
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((vrw)paramList.next()).a(this);
    }
  }
  
  @NonNull
  private vrv a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      vrw localvrw = (vrw)localIterator.next();
      j = localvrw.a() + i;
      if (paramInt <= j - 1) {
        return new vrv(localvrw, paramInt - i);
      }
    }
    throw new IllegalStateException("unable find PermissionPart, position:" + paramInt);
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((vrw)localIterator.next()).a() + i) {}
    this.jdField_a_of_type_Int = i;
  }
  
  @Nullable
  public vrw a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      vrw localvrw = (vrw)localIterator.next();
      if (localvrw.a) {
        return localvrw;
      }
    }
    return null;
  }
  
  public void a(vrw paramvrw)
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
    vrv localvrv = a(paramInt);
    return localvrv.jdField_a_of_type_Vrw.a(localvrv.jdField_a_of_type_Int);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = a(paramInt);
    vrw localvrw = ((vrv)localObject).jdField_a_of_type_Vrw;
    paramInt = ((vrv)localObject).jdField_a_of_type_Int;
    localObject = paramView;
    if (paramView == null) {
      localObject = localvrw.a(paramInt, paramViewGroup);
    }
    localvrw.a(paramInt, (View)localObject);
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
    paramAdapterView = paramView.jdField_a_of_type_Vrw;
    paramAdapterView.a(paramView.jdField_a_of_type_Int);
    if ((paramAdapterView instanceof vrt)) {
      return;
    }
    paramAdapterView.b(true);
    paramView = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramView.hasNext())
    {
      vrw localvrw = (vrw)paramView.next();
      if (localvrw != paramAdapterView)
      {
        localvrw.b(false);
        localvrw.a(false);
      }
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vru
 * JD-Core Version:    0.7.0.1
 */