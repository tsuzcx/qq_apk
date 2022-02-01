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
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class zmz
  extends BaseAdapter
{
  private List<znf> jdField_a_of_type_JavaUtilList = new ArrayList();
  private znd jdField_a_of_type_Znd;
  
  public List<znf> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<znf> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(znd paramznd)
  {
    this.jdField_a_of_type_Znd = paramznd;
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
    znf localznf = (znf)getItem(paramInt);
    Object localObject1;
    if (localznf == null)
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    Object localObject2;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560464, null);
      localObject1 = new zne(paramView);
      paramView.setTag(localObject1);
      localObject2 = new GradientDrawable();
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        ((GradientDrawable)localObject2).setColor(-16777216);
        label97:
        if (!bdfk.b()) {
          break label287;
        }
        ((GradientDrawable)localObject2).setCornerRadius(ViewUtils.dpToPx(16.0F));
        label114:
        paramView.setBackgroundDrawable((Drawable)localObject2);
        label120:
        paramView.setOnTouchListener(new zna(this, paramView.getBackground(), localznf));
        ((zne)localObject1).c.setOnClickListener(new znb(this, localznf));
        ((zne)localObject1).jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new znc(this, localznf));
        localObject2 = paramView.getContext().getString(2131716536, new Object[] { localznf.a, localznf.jdField_b_of_type_JavaLangString });
        ((zne)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if (!TextUtils.isEmpty(localznf.c)) {
          break label313;
        }
        ((zne)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        label236:
        if (localznf.jdField_b_of_type_Int != 1) {
          break label349;
        }
        ((zne)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847008);
        ((zne)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      localObject1 = paramView;
      break;
      ((GradientDrawable)localObject2).setColor(paramView.getResources().getColor(2131167191));
      break label97;
      label287:
      ((GradientDrawable)localObject2).setCornerRadius(ViewUtils.dpToPx(40.0F));
      break label114;
      localObject1 = (zne)paramView.getTag();
      break label120;
      label313:
      localObject2 = paramView.getContext().getString(2131716537, new Object[] { localznf.c });
      ((zne)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      break label236;
      label349:
      if (localznf.jdField_b_of_type_Int == 2)
      {
        ((zne)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847007);
        ((zne)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      else if (localznf.jdField_b_of_type_Int == 3)
      {
        ((zne)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847009);
        ((zne)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zmz
 * JD-Core Version:    0.7.0.1
 */