import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.maproam.data.LocationDetail;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog;
import java.util.List;

public class ggx
  extends BaseAdapter
{
  public boolean a;
  public boolean b = false;
  
  public ggx(RoamSearchDialog paramRoamSearchDialog) {}
  
  public int getCount()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_JavaUtilList.size();
    if (this.b) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_JavaUtilList.size()) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 8;
    Object localObject;
    switch (getItemViewType(paramInt))
    {
    default: 
      localObject = paramView;
      return localObject;
    case 0: 
      LocationDetail localLocationDetail = (LocationDetail)getItem(paramInt);
      if (paramView == null)
      {
        paramView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_AndroidContentContext, 2130903670, null);
        paramViewGroup = new ggw(null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131230941));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131233353));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.b.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localLocationDetail.b);
        paramViewGroup.b.setText(localLocationDetail.c);
        if (TextUtils.isEmpty(localLocationDetail.b)) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        localObject = paramView;
        if (!TextUtils.isEmpty(localLocationDetail.c)) {
          break;
        }
        paramViewGroup.b.setVisibility(8);
        return paramView;
        paramViewGroup = (ggw)paramView.getTag();
      }
    }
    if (paramView == null)
    {
      paramView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_AndroidContentContext, 2130903281, null);
      paramViewGroup = new ggw(null);
      paramView.setTag(paramViewGroup);
      paramViewGroup.c = ((TextView)paramView.findViewById(2131231867));
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131231066));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231866));
      ((LinearLayout)paramView).setOrientation(0);
      localObject = paramViewGroup.c;
      if (!this.jdField_a_of_type_Boolean) {
        break label357;
      }
      paramInt = 2131562334;
      label297:
      ((TextView)localObject).setText(paramInt);
      localObject = paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label363;
      }
      paramInt = 0;
      label318:
      ((ProgressBar)localObject).setVisibility(paramInt);
      paramViewGroup = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label369;
      }
    }
    label357:
    label363:
    label369:
    for (paramInt = i;; paramInt = 0)
    {
      paramViewGroup.setVisibility(paramInt);
      return paramView;
      paramViewGroup = (ggw)paramView.getTag();
      break;
      paramInt = 2131562926;
      break label297;
      paramInt = 8;
      break label318;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ggx
 * JD-Core Version:    0.7.0.1
 */