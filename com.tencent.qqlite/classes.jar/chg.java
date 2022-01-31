import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.widget.PinnedDividerListView.DividerAdapter;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class chg
  extends PinnedDividerListView.DividerAdapter
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int b = 1;
  private static final int c = 2;
  
  private chg(CountryActivity paramCountryActivity) {}
  
  public int a()
  {
    return 2130903259;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramInt = ((Integer)this.a.jdField_a_of_type_JavaUtilLinkedHashMap.get(((chh)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString)).intValue();
    ((TextView)paramView.findViewById(2131297009)).setText(((chh)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(int paramInt)
  {
    return ((chh)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Boolean;
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((chh)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Boolean) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    chh localchh = (chh)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (getItemViewType(paramInt) == 0)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = this.a.getLayoutInflater().inflate(a(), null);
      }
      ((TextView)paramViewGroup.findViewById(2131297009)).setText(localchh.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      paramViewGroup.setVisibility(0);
      return paramViewGroup;
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = CountryActivity.a(this.a.getLayoutInflater(), false);
        paramViewGroup.setOnClickListener(this.a);
      }
      CountryActivity.a(paramViewGroup, localchh);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     chg
 * JD-Core Version:    0.7.0.1
 */