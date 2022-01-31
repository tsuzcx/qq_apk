import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class xoc
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<xoe> jdField_a_of_type_JavaUtilList = new ArrayList();
  @Nullable
  private xoe jdField_a_of_type_Xoe;
  
  public xoc(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  @Nullable
  public xoe a()
  {
    return this.jdField_a_of_type_Xoe;
  }
  
  public void a(List<xoe> paramList)
  {
    if (paramList == null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@Nullable xoe paramxoe)
  {
    this.jdField_a_of_type_Xoe = paramxoe;
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
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561587, null);
      paramView = new xod(paramViewGroup);
      paramViewGroup.setTag(paramView);
    }
    for (;;)
    {
      paramView.a((xoe)this.jdField_a_of_type_JavaUtilList.get(paramInt), this.jdField_a_of_type_Xoe);
      return paramView.a;
      paramView = (xod)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xoc
 * JD-Core Version:    0.7.0.1
 */