import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.biz.widgets.TabLayout.TabAdapter.1;
import java.util.List;

public abstract class xof<T>
  extends BaseAdapter
{
  protected Context a;
  public TabLayout a;
  protected List<T> a;
  
  public xof(Context paramContext, List<T> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected abstract int a();
  
  public void a(TabLayout paramTabLayout)
  {
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout = paramTabLayout;
  }
  
  protected abstract void a(xog paramxog, T paramT, int paramInt);
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size() + 1;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = null;
    if (paramInt < getCount() - 1)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(paramInt);
      paramView = (View)localObject2;
      if (localObject2 == null)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(a(), paramViewGroup, false);
        paramView.post(new TabLayout.TabAdapter.1(this, paramInt, paramView));
      }
      localObject2 = new xog(paramView, null);
      paramView.setTranslationX(0.0F);
      paramViewGroup = localObject1;
      if (this.jdField_a_of_type_JavaUtilList != null) {
        paramViewGroup = this.jdField_a_of_type_JavaUtilList.get(paramInt);
      }
      a((xog)localObject2, paramViewGroup, paramInt);
      return paramView;
    }
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559967, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     xof
 * JD-Core Version:    0.7.0.1
 */