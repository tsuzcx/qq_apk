import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import java.util.ArrayList;

public class vvo
  extends BaseAdapter
{
  int jdField_a_of_type_Int = -1;
  Context jdField_a_of_type_AndroidContentContext;
  ArrayList<vvt> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public vvo(HorizontalSelectColorLayout paramHorizontalSelectColorLayout, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(ArrayList<vvt> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    vvt localvvt = (vvt)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561226, paramViewGroup, false);
      paramView = new vvp(this);
      paramView.a = ((ImageView)localView.findViewById(2131368320));
      paramView.b = ((ImageView)localView.findViewById(2131368375));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a.setImageDrawable(localvvt.a);
      if (paramInt != this.jdField_a_of_type_Int) {
        break;
      }
      paramViewGroup.b.setVisibility(0);
      return localView;
      paramViewGroup = (vvp)paramView.getTag();
      localView = paramView;
    }
    paramViewGroup.b.setVisibility(8);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vvo
 * JD-Core Version:    0.7.0.1
 */