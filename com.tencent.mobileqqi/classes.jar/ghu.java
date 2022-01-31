import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity.ItemViewHolder;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity.MoreViewHolder;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;

public class ghu
  extends BaseAdapter
{
  private ghu(StatusHistoryActivity paramStatusHistoryActivity) {}
  
  public int getCount()
  {
    int i = 1;
    int j = StatusHistoryActivity.a(this.a).size();
    if (j == 0) {
      return 1;
    }
    if (StatusHistoryActivity.a(this.a) != 0) {}
    for (;;)
    {
      return i + j;
      i = 0;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return getItemViewType(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = StatusHistoryActivity.a(this.a).size();
    if (i == 0) {
      return 2;
    }
    if (paramInt < i) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (i == 2)
    {
      StatusHistoryActivity.a(this.a).setLayoutParams(new AbsListView.LayoutParams(StatusHistoryActivity.a(this.a).getWidth(), StatusHistoryActivity.a(this.a).getHeight()));
      return StatusHistoryActivity.a(this.a);
    }
    if (i == 0)
    {
      RichStatus localRichStatus;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.a).inflate(2130903989, null);
        paramView.setFocusable(true);
        paramViewGroup = new StatusHistoryActivity.ItemViewHolder();
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131234528));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView = ((ClickableColorSpanTextView)paramView.findViewById(2131234529));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131234527));
        paramViewGroup.b = paramView.findViewById(2131234526);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView.setTag(paramViewGroup);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView.setSpanClickListener(this.a);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramView.findViewById(2131230987));
        paramViewGroup.jdField_a_of_type_AndroidViewView = paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.findViewById(2131231701);
        paramView.setTag(paramViewGroup);
        paramView.setClickable(true);
        localRichStatus = (RichStatus)StatusHistoryActivity.a(this.a).get(paramInt);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = localRichStatus;
        if (!TextUtils.isEmpty(localRichStatus.c)) {
          break label352;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840236);
        label240:
        if (StatusHistoryActivity.a(this.a).size() != 1) {
          break label380;
        }
        paramViewGroup.b.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView.setText(localRichStatus.a(null, this.a.getResources().getColor(2131362083)));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localRichStatus.a(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView, TimeFormatterUtils.a(this.a, 3, localRichStatus.a * 1000L) + "    "));
        return paramView;
        paramViewGroup = (StatusHistoryActivity.ItemViewHolder)paramView.getTag();
        break;
        label352:
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(StatusHistoryActivity.a(this.a).a(localRichStatus.b, 201));
        break label240;
        label380:
        paramViewGroup.b.setVisibility(0);
        if (paramInt == 0) {
          paramViewGroup.b.setBackgroundResource(2130840239);
        } else if (paramInt == StatusHistoryActivity.a(this.a).size() - 1) {
          paramViewGroup.b.setBackgroundResource(2130840237);
        } else {
          paramViewGroup.b.setBackgroundResource(2130840238);
        }
      }
    }
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.a.getLayoutInflater().inflate(2130903283, null);
      paramViewGroup.setOnClickListener(this.a);
      paramView = new StatusHistoryActivity.MoreViewHolder();
      paramViewGroup.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131231066));
      paramViewGroup.findViewById(2131231868).setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131231869));
    }
    if (StatusHistoryActivity.a(this.a) == 1)
    {
      StatusHistoryActivity.a(this.a, 2);
      this.a.a(false, false);
    }
    paramView = (StatusHistoryActivity.MoreViewHolder)paramViewGroup.getTag();
    if (StatusHistoryActivity.a(this.a) == 3)
    {
      paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.getString(2131559278));
      return paramViewGroup;
    }
    paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.getString(2131559279));
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return 2 != getItemViewType(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ghu
 * JD-Core Version:    0.7.0.1
 */