import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.List;

public class wia
  extends BaseAdapter
{
  private List<wig> jdField_a_of_type_JavaUtilList = new ArrayList();
  private wie jdField_a_of_type_Wie;
  
  public List<wig> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<wig> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(wie paramwie)
  {
    this.jdField_a_of_type_Wie = paramwie;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    wig localwig = (wig)getItem(paramInt);
    Object localObject;
    if (localwig == null) {
      localObject = paramView;
    }
    label98:
    label104:
    do
    {
      return localObject;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560130, null);
        paramViewGroup = new wif(paramView);
        paramView.setTag(paramViewGroup);
        localObject = new GradientDrawable();
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
        {
          ((GradientDrawable)localObject).setColor(-16777216);
          if (!axmt.b()) {
            break label261;
          }
          ((GradientDrawable)localObject).setCornerRadius(bbkx.b(16.0F));
          paramView.setBackgroundDrawable((Drawable)localObject);
          paramView.setOnTouchListener(new wib(this, paramView.getBackground(), localwig));
          paramViewGroup.c.setOnClickListener(new wic(this, localwig));
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new wid(this, localwig));
          localObject = paramView.getContext().getString(2131717216, new Object[] { localwig.a, localwig.jdField_b_of_type_JavaLangString });
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          if (!TextUtils.isEmpty(localwig.c)) {
            break label286;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      for (;;)
      {
        if (localwig.jdField_b_of_type_Int != 1) {
          break label321;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846087);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return paramView;
        ((GradientDrawable)localObject).setColor(paramView.getResources().getColor(2131167007));
        break;
        ((GradientDrawable)localObject).setCornerRadius(bbkx.b(40.0F));
        break label98;
        paramViewGroup = (wif)paramView.getTag();
        break label104;
        localObject = paramView.getContext().getString(2131717217, new Object[] { localwig.c });
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      if (localwig.jdField_b_of_type_Int == 2)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846086);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return paramView;
      }
      localObject = paramView;
    } while (localwig.jdField_b_of_type_Int != 3);
    label261:
    label286:
    label321:
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846088);
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wia
 * JD-Core Version:    0.7.0.1
 */