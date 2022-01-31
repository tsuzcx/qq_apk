import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class vve
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<vvg> jdField_a_of_type_JavaUtilList = new ArrayList();
  @Nullable
  private vvg jdField_a_of_type_Vvg;
  
  public vve(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  @Nullable
  public vvg a()
  {
    return this.jdField_a_of_type_Vvg;
  }
  
  public void a(List<vvg> paramList)
  {
    if (paramList == null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@Nullable vvg paramvvg)
  {
    this.jdField_a_of_type_Vvg = paramvvg;
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
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561380, null);
      paramView = new vvf(paramViewGroup);
      paramViewGroup.setTag(paramView);
    }
    for (;;)
    {
      paramView.a((vvg)this.jdField_a_of_type_JavaUtilList.get(paramInt), this.jdField_a_of_type_Vvg);
      return paramView.a;
      paramView = (vvf)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vve
 * JD-Core Version:    0.7.0.1
 */