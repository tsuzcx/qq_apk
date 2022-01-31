import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class vvb
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<vvd> jdField_a_of_type_JavaUtilList = new ArrayList();
  @Nullable
  private vvd jdField_a_of_type_Vvd;
  
  public vvb(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  @Nullable
  public vvd a()
  {
    return this.jdField_a_of_type_Vvd;
  }
  
  public void a(List<vvd> paramList)
  {
    if (paramList == null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@Nullable vvd paramvvd)
  {
    this.jdField_a_of_type_Vvd = paramvvd;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561379, null);
      paramView = new vvc(paramViewGroup);
      paramViewGroup.setTag(paramView);
    }
    for (;;)
    {
      paramView.a((vvd)this.jdField_a_of_type_JavaUtilList.get(paramInt), this.jdField_a_of_type_Vvd);
      return paramView.a;
      paramView = (vvc)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vvb
 * JD-Core Version:    0.7.0.1
 */