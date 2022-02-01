import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;
import java.util.Iterator;

public class ele
  extends BaseAdapter
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int b = 1;
  private static final int c = 2;
  private static final int d = 3;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity.jdField_a_of_type_JavaUtilArrayList;
  
  private ele(CountryActivity paramCountryActivity) {}
  
  private int a(elc paramelc)
  {
    if (paramelc.a) {}
    String str1;
    String str2;
    String str3;
    do
    {
      do
      {
        return 0;
      } while ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.equals("")));
      str1 = paramelc.c;
      paramelc = paramelc.b;
      str2 = ChnToSpell.a(paramelc, 1);
      str3 = ChnToSpell.a(paramelc, 2);
      if ((str1.equals(this.jdField_a_of_type_JavaLangString)) || (paramelc.equals(this.jdField_a_of_type_JavaLangString)) || (str2.equals(this.jdField_a_of_type_JavaLangString)) || (str3.equals(this.jdField_a_of_type_JavaLangString))) {
        return 3;
      }
      if ((str1.indexOf(this.jdField_a_of_type_JavaLangString) == 0) || (paramelc.indexOf(this.jdField_a_of_type_JavaLangString) == 0) || (str2.indexOf(this.jdField_a_of_type_JavaLangString) == 0) || (str3.indexOf(this.jdField_a_of_type_JavaLangString) == 0)) {
        return 2;
      }
    } while ((str1.indexOf(this.jdField_a_of_type_JavaLangString) <= 0) && (paramelc.indexOf(this.jdField_a_of_type_JavaLangString) <= 0) && (str2.indexOf(this.jdField_a_of_type_JavaLangString) <= 0) && (str3.indexOf(this.jdField_a_of_type_JavaLangString) <= 0));
    return 1;
  }
  
  public void a(String paramString)
  {
    int j = 0;
    Object localObject = paramString.toLowerCase();
    int i;
    label49:
    elc localelc;
    int k;
    if (((String)localObject).startsWith(this.jdField_a_of_type_JavaLangString))
    {
      paramString = this.jdField_a_of_type_JavaUtilArrayList;
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      localObject = new ArrayList(8);
      paramString = paramString.iterator();
      i = 0;
      if (!paramString.hasNext()) {
        break label177;
      }
      localelc = (elc)paramString.next();
      k = a(localelc);
      if (k != 3) {
        break label123;
      }
      ((ArrayList)localObject).add(i, localelc);
      k = j;
      j = i + 1;
      i = k;
    }
    for (;;)
    {
      k = j;
      j = i;
      i = k;
      break label49;
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity.jdField_a_of_type_JavaUtilArrayList;
      break;
      label123:
      if (k == 2)
      {
        ((ArrayList)localObject).add(j + i, localelc);
        k = j + 1;
        j = i;
        i = k;
      }
      else
      {
        if (k == 1) {
          ((ArrayList)localObject).add(localelc);
        }
        k = i;
        i = j;
        j = k;
      }
    }
    label177:
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = CountryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity.getLayoutInflater(), true);
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity);
    }
    CountryActivity.a(paramViewGroup, (elc)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ele
 * JD-Core Version:    0.7.0.1
 */