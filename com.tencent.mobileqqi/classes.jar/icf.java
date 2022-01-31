import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cooperation.qzone.UploadServerSetting.ConfigItem;
import java.util.ArrayList;

public final class icf
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public icf(Context paramContext, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
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
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903907, paramViewGroup, false);
    }
    paramView = (UploadServerSetting.ConfigItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramViewGroup = (TextView)localView.findViewById(2131234268);
    TextView localTextView1 = (TextView)localView.findViewById(2131234270);
    TextView localTextView2 = (TextView)localView.findViewById(2131234271);
    if (paramView.jdField_a_of_type_Boolean) {
      localTextView2.setVisibility(0);
    }
    while (paramInt == 0)
    {
      ((TextView)localView.findViewById(2131234269)).setVisibility(4);
      paramViewGroup.setText("正式环境");
      return localView;
      localTextView2.setVisibility(4);
    }
    paramViewGroup.setText(paramView.jdField_a_of_type_JavaLangString);
    localTextView1.setText(paramView.jdField_a_of_type_Int + "");
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     icf
 * JD-Core Version:    0.7.0.1
 */