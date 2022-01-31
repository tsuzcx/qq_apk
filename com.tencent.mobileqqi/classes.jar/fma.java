import SummaryCard.CondFitUser;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.conditionsearch.SearchResultActivity;
import java.util.List;

public class fma
  extends BaseAdapter
{
  private fma(SearchResultActivity paramSearchResultActivity) {}
  
  public int getCount()
  {
    int j = this.a.a.size();
    if (this.a.b != 0) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.a.a.size()) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (getItemViewType(paramInt) == 0)
    {
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = this.a.getLayoutInflater().inflate(2130903556, null);
        paramViewGroup.setOnClickListener(this.a);
        paramView = new fmb();
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131232909));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131232911));
        paramView.c = ((TextView)paramViewGroup.findViewById(2131232913));
        paramView.b = ((TextView)paramViewGroup.findViewById(2131232912));
        paramViewGroup.setTag(paramView);
      }
      paramView = (fmb)paramViewGroup.getTag();
      localObject = (CondFitUser)this.a.a.get(paramInt);
      paramViewGroup.setContentDescription(this.a.a(paramView, (CondFitUser)localObject));
      paramView = paramViewGroup;
    }
    do
    {
      return paramView;
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = this.a.getLayoutInflater().inflate(2130903283, null);
        paramViewGroup.setOnClickListener(this.a);
        paramView = new fmc();
        paramViewGroup.setTag(paramView);
        paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131231066));
        paramViewGroup.findViewById(2131231868).setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131231869));
      }
      if (this.a.b == 1)
      {
        this.a.b = 2;
        this.a.d();
      }
      localObject = (fmc)paramViewGroup.getTag();
      if (this.a.b == 3)
      {
        ((fmc)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        ((fmc)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(this.a.getString(2131559226));
        return paramViewGroup;
      }
      if (this.a.b == 2)
      {
        ((fmc)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        ((fmc)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(this.a.getString(2131559227));
        return paramViewGroup;
      }
      paramView = paramViewGroup;
    } while (this.a.b != 4);
    ((fmc)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    ((fmc)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(this.a.getString(2131559228));
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fma
 * JD-Core Version:    0.7.0.1
 */