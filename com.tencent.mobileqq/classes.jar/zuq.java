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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class zuq
  extends BaseAdapter
{
  private List<zuw> jdField_a_of_type_JavaUtilList = new ArrayList();
  private zuu jdField_a_of_type_Zuu;
  
  public List<zuw> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<zuw> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(zuu paramzuu)
  {
    this.jdField_a_of_type_Zuu = paramzuu;
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
    zuw localzuw = (zuw)getItem(paramInt);
    Object localObject1;
    if (localzuw == null)
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    Object localObject2;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560389, null);
      localObject1 = new zuv(paramView);
      paramView.setTag(localObject1);
      localObject2 = new GradientDrawable();
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        ((GradientDrawable)localObject2).setColor(-16777216);
        label97:
        if (!bcnj.b()) {
          break label287;
        }
        ((GradientDrawable)localObject2).setCornerRadius(bgtn.b(16.0F));
        label114:
        paramView.setBackgroundDrawable((Drawable)localObject2);
        label120:
        paramView.setOnTouchListener(new zur(this, paramView.getBackground(), localzuw));
        ((zuv)localObject1).c.setOnClickListener(new zus(this, localzuw));
        ((zuv)localObject1).jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new zut(this, localzuw));
        localObject2 = paramView.getContext().getString(2131715836, new Object[] { localzuw.a, localzuw.jdField_b_of_type_JavaLangString });
        ((zuv)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if (!TextUtils.isEmpty(localzuw.c)) {
          break label313;
        }
        ((zuv)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        label236:
        if (localzuw.jdField_b_of_type_Int != 1) {
          break label349;
        }
        ((zuv)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846986);
        ((zuv)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      localObject1 = paramView;
      break;
      ((GradientDrawable)localObject2).setColor(paramView.getResources().getColor(2131167144));
      break label97;
      label287:
      ((GradientDrawable)localObject2).setCornerRadius(bgtn.b(40.0F));
      break label114;
      localObject1 = (zuv)paramView.getTag();
      break label120;
      label313:
      localObject2 = paramView.getContext().getString(2131715837, new Object[] { localzuw.c });
      ((zuv)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      break label236;
      label349:
      if (localzuw.jdField_b_of_type_Int == 2)
      {
        ((zuv)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846985);
        ((zuv)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      else if (localzuw.jdField_b_of_type_Int == 3)
      {
        ((zuv)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846987);
        ((zuv)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zuq
 * JD-Core Version:    0.7.0.1
 */