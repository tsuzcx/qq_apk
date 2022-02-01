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

public class zyl
  extends BaseAdapter
{
  private List<zyr> jdField_a_of_type_JavaUtilList = new ArrayList();
  private zyp jdField_a_of_type_Zyp;
  
  public List<zyr> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<zyr> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(zyp paramzyp)
  {
    this.jdField_a_of_type_Zyp = paramzyp;
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
    zyr localzyr = (zyr)getItem(paramInt);
    Object localObject1;
    if (localzyr == null)
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    Object localObject2;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560404, null);
      localObject1 = new zyq(paramView);
      paramView.setTag(localObject1);
      localObject2 = new GradientDrawable();
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        ((GradientDrawable)localObject2).setColor(-16777216);
        label97:
        if (!bdgb.b()) {
          break label287;
        }
        ((GradientDrawable)localObject2).setCornerRadius(bhtq.b(16.0F));
        label114:
        paramView.setBackgroundDrawable((Drawable)localObject2);
        label120:
        paramView.setOnTouchListener(new zym(this, paramView.getBackground(), localzyr));
        ((zyq)localObject1).c.setOnClickListener(new zyn(this, localzyr));
        ((zyq)localObject1).jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new zyo(this, localzyr));
        localObject2 = paramView.getContext().getString(2131715945, new Object[] { localzyr.a, localzyr.jdField_b_of_type_JavaLangString });
        ((zyq)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if (!TextUtils.isEmpty(localzyr.c)) {
          break label313;
        }
        ((zyq)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        label236:
        if (localzyr.jdField_b_of_type_Int != 1) {
          break label349;
        }
        ((zyq)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847003);
        ((zyq)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      localObject1 = paramView;
      break;
      ((GradientDrawable)localObject2).setColor(paramView.getResources().getColor(2131167154));
      break label97;
      label287:
      ((GradientDrawable)localObject2).setCornerRadius(bhtq.b(40.0F));
      break label114;
      localObject1 = (zyq)paramView.getTag();
      break label120;
      label313:
      localObject2 = paramView.getContext().getString(2131715946, new Object[] { localzyr.c });
      ((zyq)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      break label236;
      label349:
      if (localzyr.jdField_b_of_type_Int == 2)
      {
        ((zyq)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847002);
        ((zyq)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      else if (localzyr.jdField_b_of_type_Int == 3)
      {
        ((zyq)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847004);
        ((zyq)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zyl
 * JD-Core Version:    0.7.0.1
 */