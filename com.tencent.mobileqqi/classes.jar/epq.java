import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.widget.PinnedDividerListView.DividerAdapter;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class epq
  extends PinnedDividerListView.DividerAdapter
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int b = 1;
  private static final int c = 2;
  
  private epq(CountryActivity paramCountryActivity) {}
  
  public int a()
  {
    return 2130903305;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramInt = ((Integer)this.a.jdField_a_of_type_JavaUtilLinkedHashMap.get(((epr)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString)).intValue();
    ((TextView)paramView).setText(((epr)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString.replace("-", " "));
  }
  
  public boolean a(int paramInt)
  {
    return ((epr)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Boolean;
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
    if (((epr)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Boolean) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    epr localepr = (epr)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (getItemViewType(paramInt) == 0)
    {
      if (paramView != null) {
        break label107;
      }
      paramView = this.a.getLayoutInflater().inflate(a(), null);
    }
    label107:
    for (;;)
    {
      ((TextView)paramView).setText(localepr.jdField_a_of_type_JavaLangString.replace("-", " "));
      for (;;)
      {
        paramView.setVisibility(0);
        return paramView;
        paramViewGroup = paramView;
        if (paramView == null)
        {
          paramViewGroup = CountryActivity.a(this.a.getLayoutInflater(), false);
          paramViewGroup.setOnClickListener(this.a);
        }
        CountryActivity.a(paramViewGroup, localepr);
        paramView = paramViewGroup;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     epq
 * JD-Core Version:    0.7.0.1
 */