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

public class vvd
  extends BaseAdapter
{
  private List<vvj> jdField_a_of_type_JavaUtilList = new ArrayList();
  private vvh jdField_a_of_type_Vvh;
  
  public List<vvj> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<vvj> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(vvh paramvvh)
  {
    this.jdField_a_of_type_Vvh = paramvvh;
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
    vvj localvvj = (vvj)getItem(paramInt);
    Object localObject;
    if (localvvj == null) {
      localObject = paramView;
    }
    label98:
    label104:
    do
    {
      return localObject;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494558, null);
        paramViewGroup = new vvi(paramView);
        paramView.setTag(paramViewGroup);
        localObject = new GradientDrawable();
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
        {
          ((GradientDrawable)localObject).setColor(-16777216);
          if (!awnu.b()) {
            break label261;
          }
          ((GradientDrawable)localObject).setCornerRadius(bajq.b(16.0F));
          paramView.setBackgroundDrawable((Drawable)localObject);
          paramView.setOnTouchListener(new vve(this, paramView.getBackground(), localvvj));
          paramViewGroup.c.setOnClickListener(new vvf(this, localvvj));
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new vvg(this, localvvj));
          localObject = paramView.getContext().getString(2131651424, new Object[] { localvvj.a, localvvj.jdField_b_of_type_JavaLangString });
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          if (!TextUtils.isEmpty(localvvj.c)) {
            break label286;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      for (;;)
      {
        if (localvvj.jdField_b_of_type_Int != 1) {
          break label321;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845906);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return paramView;
        ((GradientDrawable)localObject).setColor(paramView.getResources().getColor(2131101412));
        break;
        ((GradientDrawable)localObject).setCornerRadius(bajq.b(40.0F));
        break label98;
        paramViewGroup = (vvi)paramView.getTag();
        break label104;
        localObject = paramView.getContext().getString(2131651425, new Object[] { localvvj.c });
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      if (localvvj.jdField_b_of_type_Int == 2)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845905);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return paramView;
      }
      localObject = paramView;
    } while (localvvj.jdField_b_of_type_Int != 3);
    label261:
    label286:
    label321:
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845907);
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     vvd
 * JD-Core Version:    0.7.0.1
 */