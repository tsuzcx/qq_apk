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

public class xwp
  extends BaseAdapter
{
  private List<xwv> jdField_a_of_type_JavaUtilList = new ArrayList();
  private xwt jdField_a_of_type_Xwt;
  
  public List<xwv> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<xwv> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(xwt paramxwt)
  {
    this.jdField_a_of_type_Xwt = paramxwt;
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
    xwv localxwv = (xwv)getItem(paramInt);
    Object localObject;
    if (localxwv == null) {
      localObject = paramView;
    }
    label98:
    label104:
    do
    {
      return localObject;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560238, null);
        paramViewGroup = new xwu(paramView);
        paramView.setTag(paramViewGroup);
        localObject = new GradientDrawable();
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
        {
          ((GradientDrawable)localObject).setColor(-16777216);
          if (!azib.b()) {
            break label261;
          }
          ((GradientDrawable)localObject).setCornerRadius(bdkf.b(16.0F));
          paramView.setBackgroundDrawable((Drawable)localObject);
          paramView.setOnTouchListener(new xwq(this, paramView.getBackground(), localxwv));
          paramViewGroup.c.setOnClickListener(new xwr(this, localxwv));
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new xws(this, localxwv));
          localObject = paramView.getContext().getString(2131717599, new Object[] { localxwv.a, localxwv.jdField_b_of_type_JavaLangString });
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          if (!TextUtils.isEmpty(localxwv.c)) {
            break label286;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      for (;;)
      {
        if (localxwv.jdField_b_of_type_Int != 1) {
          break label321;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846472);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return paramView;
        ((GradientDrawable)localObject).setColor(paramView.getResources().getColor(2131167058));
        break;
        ((GradientDrawable)localObject).setCornerRadius(bdkf.b(40.0F));
        break label98;
        paramViewGroup = (xwu)paramView.getTag();
        break label104;
        localObject = paramView.getContext().getString(2131717600, new Object[] { localxwv.c });
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      if (localxwv.jdField_b_of_type_Int == 2)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846471);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return paramView;
      }
      localObject = paramView;
    } while (localxwv.jdField_b_of_type_Int != 3);
    label261:
    label286:
    label321:
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846473);
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xwp
 * JD-Core Version:    0.7.0.1
 */