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

public class whx
  extends BaseAdapter
{
  private List<wid> jdField_a_of_type_JavaUtilList = new ArrayList();
  private wib jdField_a_of_type_Wib;
  
  public List<wid> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<wid> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(wib paramwib)
  {
    this.jdField_a_of_type_Wib = paramwib;
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
    wid localwid = (wid)getItem(paramInt);
    Object localObject;
    if (localwid == null) {
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
        paramViewGroup = new wic(paramView);
        paramView.setTag(paramViewGroup);
        localObject = new GradientDrawable();
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
        {
          ((GradientDrawable)localObject).setColor(-16777216);
          if (!axmv.b()) {
            break label261;
          }
          ((GradientDrawable)localObject).setCornerRadius(bbll.b(16.0F));
          paramView.setBackgroundDrawable((Drawable)localObject);
          paramView.setOnTouchListener(new why(this, paramView.getBackground(), localwid));
          paramViewGroup.c.setOnClickListener(new whz(this, localwid));
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new wia(this, localwid));
          localObject = paramView.getContext().getString(2131717227, new Object[] { localwid.a, localwid.jdField_b_of_type_JavaLangString });
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          if (!TextUtils.isEmpty(localwid.c)) {
            break label286;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      for (;;)
      {
        if (localwid.jdField_b_of_type_Int != 1) {
          break label321;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846093);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return paramView;
        ((GradientDrawable)localObject).setColor(paramView.getResources().getColor(2131167007));
        break;
        ((GradientDrawable)localObject).setCornerRadius(bbll.b(40.0F));
        break label98;
        paramViewGroup = (wic)paramView.getTag();
        break label104;
        localObject = paramView.getContext().getString(2131717228, new Object[] { localwid.c });
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      if (localwid.jdField_b_of_type_Int == 2)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846092);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return paramView;
      }
      localObject = paramView;
    } while (localwid.jdField_b_of_type_Int != 3);
    label261:
    label286:
    label321:
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846094);
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     whx
 * JD-Core Version:    0.7.0.1
 */