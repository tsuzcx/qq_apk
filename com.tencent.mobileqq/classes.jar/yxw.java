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

public class yxw
  extends BaseAdapter
{
  private List<yyc> jdField_a_of_type_JavaUtilList = new ArrayList();
  private yya jdField_a_of_type_Yya;
  
  public List<yyc> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<yyc> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(yya paramyya)
  {
    this.jdField_a_of_type_Yya = paramyya;
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
    yyc localyyc = (yyc)getItem(paramInt);
    Object localObject1;
    if (localyyc == null)
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    Object localObject2;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560414, null);
      localObject1 = new yyb(paramView);
      paramView.setTag(localObject1);
      localObject2 = new GradientDrawable();
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        ((GradientDrawable)localObject2).setColor(-16777216);
        label97:
        if (!bbyp.b()) {
          break label287;
        }
        ((GradientDrawable)localObject2).setCornerRadius(ViewUtils.dpToPx(16.0F));
        label114:
        paramView.setBackgroundDrawable((Drawable)localObject2);
        label120:
        paramView.setOnTouchListener(new yxx(this, paramView.getBackground(), localyyc));
        ((yyb)localObject1).c.setOnClickListener(new yxy(this, localyyc));
        ((yyb)localObject1).jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new yxz(this, localyyc));
        localObject2 = paramView.getContext().getString(2131716179, new Object[] { localyyc.a, localyyc.jdField_b_of_type_JavaLangString });
        ((yyb)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if (!TextUtils.isEmpty(localyyc.c)) {
          break label313;
        }
        ((yyb)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        label236:
        if (localyyc.jdField_b_of_type_Int != 1) {
          break label349;
        }
        ((yyb)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846911);
        ((yyb)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      localObject1 = paramView;
      break;
      ((GradientDrawable)localObject2).setColor(paramView.getResources().getColor(2131167177));
      break label97;
      label287:
      ((GradientDrawable)localObject2).setCornerRadius(ViewUtils.dpToPx(40.0F));
      break label114;
      localObject1 = (yyb)paramView.getTag();
      break label120;
      label313:
      localObject2 = paramView.getContext().getString(2131716180, new Object[] { localyyc.c });
      ((yyb)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      break label236;
      label349:
      if (localyyc.jdField_b_of_type_Int == 2)
      {
        ((yyb)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846910);
        ((yyb)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      else if (localyyc.jdField_b_of_type_Int == 3)
      {
        ((yyb)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846912);
        ((yyb)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yxw
 * JD-Core Version:    0.7.0.1
 */