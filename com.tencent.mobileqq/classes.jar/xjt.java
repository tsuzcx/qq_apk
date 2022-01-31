import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class xjt
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<xjv> jdField_a_of_type_JavaUtilList = new ArrayList();
  @Nullable
  private xjv jdField_a_of_type_Xjv;
  
  public xjt(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  @Nullable
  public xjv a()
  {
    return this.jdField_a_of_type_Xjv;
  }
  
  public void a(List<xjv> paramList)
  {
    if (paramList == null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@Nullable xjv paramxjv)
  {
    this.jdField_a_of_type_Xjv = paramxjv;
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
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561569, null);
      paramView = new xju(paramViewGroup);
      paramViewGroup.setTag(paramView);
    }
    for (;;)
    {
      paramView.a((xjv)this.jdField_a_of_type_JavaUtilList.get(paramInt), this.jdField_a_of_type_Xjv);
      return paramView.a;
      paramView = (xju)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xjt
 * JD-Core Version:    0.7.0.1
 */