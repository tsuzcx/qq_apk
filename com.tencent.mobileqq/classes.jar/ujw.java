import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.BabyQAIOPanel;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;

public class ujw
  extends BaseAdapter
{
  public ujw(BabyQAIOPanel paramBabyQAIOPanel) {}
  
  public uju a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < BabyQAIOPanel.a(this.a).size())) {
      return (uju)BabyQAIOPanel.a(this.a).get(paramInt);
    }
    return new uju();
  }
  
  public int getCount()
  {
    return BabyQAIOPanel.a(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      localObject = new ujv();
      paramView = LayoutInflater.from(BabyQAIOPanel.a(this.a)).inflate(2130968626, paramViewGroup, false);
      ((ujv)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362749));
      ((ujv)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362960));
      ((ujv)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362961));
      ((ujv)localObject).b = ((ImageView)paramView.findViewById(2131362962));
      paramView.setTag(localObject);
      paramViewGroup = (ViewGroup)localObject;
      localObject = (RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (paramInt % 2 == 0) {
        break label249;
      }
      ((RelativeLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(this.a.getContext(), 8.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(this.a.getContext(), 12.0F);
      label148:
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = a(paramInt);
      paramViewGroup.jdField_a_of_type_Int = ((uju)localObject).jdField_a_of_type_Int;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((uju)localObject).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(((uju)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      if (!((uju)localObject).jdField_a_of_type_Boolean) {
        break label286;
      }
      paramViewGroup.b.setVisibility(0);
    }
    for (;;)
    {
      paramView.setOnClickListener(this.a);
      if (AppSetting.b) {
        paramView.setContentDescription(((uju)localObject).jdField_a_of_type_JavaLangString);
      }
      return paramView;
      paramViewGroup = (ujv)paramView.getTag();
      break;
      label249:
      ((RelativeLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(this.a.getContext(), 12.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(this.a.getContext(), 8.0F);
      break label148;
      label286:
      paramViewGroup.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ujw
 * JD-Core Version:    0.7.0.1
 */