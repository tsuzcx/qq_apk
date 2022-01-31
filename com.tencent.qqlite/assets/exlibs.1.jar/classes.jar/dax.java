import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.conditionsearch.CountrySelectActivity;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.widget.PinnedDividerListView.DividerAdapter;
import java.util.List;

public class dax
  extends PinnedDividerListView.DividerAdapter
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int b = 1;
  private static final int c = 2;
  
  private dax(CountrySelectActivity paramCountrySelectActivity) {}
  
  public int a()
  {
    return 2130903259;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = (TextView)paramView.findViewById(2131297013);
    Object localObject = getItem(paramInt);
    if ((localObject instanceof day)) {
      paramView.setText(((day)localObject).jdField_a_of_type_JavaLangString);
    }
    while (!(localObject instanceof BaseAddress)) {
      return;
    }
    paramView.setText(((BaseAddress)localObject).d);
  }
  
  public boolean a(int paramInt)
  {
    return getItemViewType(paramInt) == 0;
  }
  
  public int getCount()
  {
    return this.a.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.a.a.get(paramInt) instanceof day)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 0)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = this.a.getLayoutInflater().inflate(a(), null);
      }
      ((TextView)paramViewGroup.findViewById(2131297013)).setText(((day)getItem(paramInt)).jdField_a_of_type_JavaLangString);
      return paramViewGroup;
    }
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.a.getLayoutInflater().inflate(2130903260, null);
      paramView = new daz(null);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297408));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131297409));
      paramViewGroup.findViewById(2131297385).setVisibility(8);
      paramViewGroup.setTag(paramView);
      paramViewGroup.setOnClickListener(this.a);
    }
    paramView = (daz)paramViewGroup.getTag();
    BaseAddress localBaseAddress = (BaseAddress)getItem(paramInt);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localBaseAddress.jdField_a_of_type_JavaLangString);
    if ((!TextUtils.isEmpty(this.a.d)) && (this.a.d.equals(localBaseAddress.b))) {
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_JavaLangString = localBaseAddress.b;
      paramViewGroup.setContentDescription(localBaseAddress.jdField_a_of_type_JavaLangString);
      return paramViewGroup;
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dax
 * JD-Core Version:    0.7.0.1
 */