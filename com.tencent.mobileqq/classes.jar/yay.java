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

public class yay
  extends BaseAdapter
{
  private List<ybe> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ybc jdField_a_of_type_Ybc;
  
  public List<ybe> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<ybe> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(ybc paramybc)
  {
    this.jdField_a_of_type_Ybc = paramybc;
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
    ybe localybe = (ybe)getItem(paramInt);
    Object localObject;
    if (localybe == null) {
      localObject = paramView;
    }
    label98:
    label104:
    do
    {
      return localObject;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560237, null);
        paramViewGroup = new ybd(paramView);
        paramView.setTag(paramViewGroup);
        localObject = new GradientDrawable();
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
        {
          ((GradientDrawable)localObject).setColor(-16777216);
          if (!azmk.b()) {
            break label261;
          }
          ((GradientDrawable)localObject).setCornerRadius(bdoo.b(16.0F));
          paramView.setBackgroundDrawable((Drawable)localObject);
          paramView.setOnTouchListener(new yaz(this, paramView.getBackground(), localybe));
          paramViewGroup.c.setOnClickListener(new yba(this, localybe));
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new ybb(this, localybe));
          localObject = paramView.getContext().getString(2131717611, new Object[] { localybe.a, localybe.jdField_b_of_type_JavaLangString });
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          if (!TextUtils.isEmpty(localybe.c)) {
            break label286;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      for (;;)
      {
        if (localybe.jdField_b_of_type_Int != 1) {
          break label321;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846545);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return paramView;
        ((GradientDrawable)localObject).setColor(paramView.getResources().getColor(2131167060));
        break;
        ((GradientDrawable)localObject).setCornerRadius(bdoo.b(40.0F));
        break label98;
        paramViewGroup = (ybd)paramView.getTag();
        break label104;
        localObject = paramView.getContext().getString(2131717612, new Object[] { localybe.c });
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      if (localybe.jdField_b_of_type_Int == 2)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846544);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return paramView;
      }
      localObject = paramView;
    } while (localybe.jdField_b_of_type_Int != 3);
    label261:
    label286:
    label321:
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846546);
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yay
 * JD-Core Version:    0.7.0.1
 */