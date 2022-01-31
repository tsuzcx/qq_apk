import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;
import java.util.Iterator;

public class wux
  extends BaseAdapter
{
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity.jdField_a_of_type_JavaUtilArrayList;
  
  private wux(NewStyleCountryActivity paramNewStyleCountryActivity) {}
  
  private int a(wuv paramwuv)
  {
    if (paramwuv.a) {
      return 0;
    }
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.equals(""))) {
      return 0;
    }
    String str2 = paramwuv.c;
    String str3 = paramwuv.b;
    String str1 = paramwuv.d;
    paramwuv = str1;
    if (str1 != null) {
      paramwuv = str1.toLowerCase();
    }
    str1 = ChnToSpell.a(str3, 1);
    String str4 = ChnToSpell.a(str3, 2);
    if ((str2.equals(this.jdField_a_of_type_JavaLangString)) || (str3.equals(this.jdField_a_of_type_JavaLangString)) || (str1.equals(this.jdField_a_of_type_JavaLangString)) || (str4.equals(this.jdField_a_of_type_JavaLangString)) || ((paramwuv != null) && (paramwuv.equals(this.jdField_a_of_type_JavaLangString)))) {
      return 3;
    }
    if ((str2.indexOf(this.jdField_a_of_type_JavaLangString) == 0) || (str3.indexOf(this.jdField_a_of_type_JavaLangString) == 0) || (str1.indexOf(this.jdField_a_of_type_JavaLangString) == 0) || (str4.indexOf(this.jdField_a_of_type_JavaLangString) == 0) || ((paramwuv != null) && (paramwuv.indexOf(this.jdField_a_of_type_JavaLangString) == 0))) {
      return 2;
    }
    if ((str2.indexOf(this.jdField_a_of_type_JavaLangString) > 0) || (str3.indexOf(this.jdField_a_of_type_JavaLangString) > 0) || (str1.indexOf(this.jdField_a_of_type_JavaLangString) > 0) || (str4.indexOf(this.jdField_a_of_type_JavaLangString) > 0)) {
      return 1;
    }
    return 0;
  }
  
  public void a(String paramString)
  {
    int j = 0;
    Object localObject = paramString.toLowerCase();
    paramString = (String)localObject;
    if (((String)localObject).equals("hk")) {
      paramString = "xianggang";
    }
    localObject = paramString;
    if (paramString.equals("uk")) {
      localObject = "united kingdom";
    }
    int i;
    label81:
    wuv localwuv;
    int k;
    if (((String)localObject).startsWith(this.jdField_a_of_type_JavaLangString))
    {
      paramString = this.jdField_a_of_type_JavaUtilArrayList;
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      localObject = new ArrayList(8);
      paramString = paramString.iterator();
      i = 0;
      if (!paramString.hasNext()) {
        break label181;
      }
      localwuv = (wuv)paramString.next();
      k = a(localwuv);
      if (k != 3) {
        break label141;
      }
      ((ArrayList)localObject).add(j, localwuv);
      j += 1;
    }
    for (;;)
    {
      break label81;
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity.jdField_a_of_type_JavaUtilArrayList;
      break;
      label141:
      if (k == 2)
      {
        ((ArrayList)localObject).add(i + j, localwuv);
        i += 1;
      }
      else if (k == 1)
      {
        ((ArrayList)localObject).add(localwuv);
      }
    }
    label181:
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
    View localView = paramView;
    if (paramView == null)
    {
      localView = NewStyleCountryActivity.a(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity.getLayoutInflater(), true);
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity);
    }
    NewStyleCountryActivity.a(localView, (wuv)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wux
 * JD-Core Version:    0.7.0.1
 */