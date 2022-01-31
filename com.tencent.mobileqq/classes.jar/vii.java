import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class vii
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<vik> jdField_a_of_type_JavaUtilList = new ArrayList();
  @Nullable
  private vik jdField_a_of_type_Vik;
  
  public vii(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  @Nullable
  public vik a()
  {
    return this.jdField_a_of_type_Vik;
  }
  
  public void a(List<vik> paramList)
  {
    if (paramList == null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@Nullable vik paramvik)
  {
    this.jdField_a_of_type_Vik = paramvik;
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
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495789, null);
      paramView = new vij(paramViewGroup);
      paramViewGroup.setTag(paramView);
    }
    for (;;)
    {
      paramView.a((vik)this.jdField_a_of_type_JavaUtilList.get(paramInt), this.jdField_a_of_type_Vik);
      return paramView.a;
      paramView = (vij)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vii
 * JD-Core Version:    0.7.0.1
 */