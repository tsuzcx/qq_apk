import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.data.AddressData.NO_LIMIT_ADDRESS;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Collections;

public class flu
  implements IphonePickerView.IphonePickListener
{
  public flu(LocationSelectActivity paramLocationSelectActivity) {}
  
  public void a()
  {
    LocationSelectActivity.a(this.a).setRightTextColor(2);
    this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView == null) {
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      LocationSelectActivity.a(this.a).setRightText(LocationSelectActivity.a(this.a));
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(null);
      this.a.jdField_a_of_type_ArrayOfInt[0] = paramInt2;
      this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[0] = ((BaseAddress)((ArrayList)this.a.jdField_a_of_type_ArrayOfJavaLangObject[0]).get(paramInt2));
      ArrayList localArrayList = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[0].a();
      if (localArrayList.size() > 0)
      {
        this.a.jdField_a_of_type_ArrayOfJavaLangObject[1] = localArrayList;
        this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[1] = ((BaseAddress)localArrayList.get(0));
        this.a.jdField_a_of_type_ArrayOfInt[1] = 0;
        localArrayList = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[1].a();
        if (localArrayList.size() > 0)
        {
          this.a.jdField_a_of_type_ArrayOfJavaLangObject[2] = localArrayList;
          this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[2] = ((BaseAddress)localArrayList.get(0));
          this.a.jdField_a_of_type_ArrayOfInt[2] = 0;
        }
      }
      for (;;)
      {
        if (this.a.h > 1)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1);
          this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.a.jdField_a_of_type_ArrayOfInt[1]);
          if (this.a.h == 3)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
            this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.a.jdField_a_of_type_ArrayOfInt[2]);
          }
        }
        this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this);
        break;
        if (this.a.h == 3)
        {
          this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[2] = new AddressData.NO_LIMIT_ADDRESS(3);
          this.a.jdField_a_of_type_ArrayOfJavaLangObject[2] = null;
          this.a.jdField_a_of_type_ArrayOfInt[2] = 0;
          continue;
          if (this.a.h > 1)
          {
            this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[1] = new AddressData.NO_LIMIT_ADDRESS(2);
            this.a.jdField_a_of_type_ArrayOfJavaLangObject[1] = null;
            this.a.jdField_a_of_type_ArrayOfInt[1] = 0;
            if (this.a.h == 3)
            {
              this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[2] = new AddressData.NO_LIMIT_ADDRESS(3);
              this.a.jdField_a_of_type_ArrayOfJavaLangObject[2] = null;
              this.a.jdField_a_of_type_ArrayOfInt[2] = 0;
            }
          }
        }
      }
      this.a.jdField_a_of_type_ArrayOfInt[1] = paramInt2;
      this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(null);
      this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[1] = ((BaseAddress)((ArrayList)this.a.jdField_a_of_type_ArrayOfJavaLangObject[1]).get(paramInt2));
      localArrayList = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[1].a();
      if (localArrayList.size() > 0)
      {
        this.a.jdField_a_of_type_ArrayOfJavaLangObject[2] = localArrayList;
        this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[2] = ((BaseAddress)localArrayList.get(0));
        this.a.jdField_a_of_type_ArrayOfInt[2] = 0;
      }
      for (;;)
      {
        if (this.a.h > 2)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
          this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.a.jdField_a_of_type_ArrayOfInt[2]);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this);
        break;
        if (this.a.h > 2)
        {
          this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[2] = new AddressData.NO_LIMIT_ADDRESS(3);
          this.a.jdField_a_of_type_ArrayOfJavaLangObject[2] = Collections.EMPTY_LIST;
          this.a.jdField_a_of_type_ArrayOfInt[2] = 0;
        }
      }
      localArrayList = (ArrayList)this.a.jdField_a_of_type_ArrayOfJavaLangObject[2];
      if ((localArrayList != null) && (paramInt2 < localArrayList.size()) && (paramInt2 >= 0))
      {
        this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[2] = ((BaseAddress)localArrayList.get(paramInt2));
        this.a.jdField_a_of_type_ArrayOfInt[2] = paramInt2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     flu
 * JD-Core Version:    0.7.0.1
 */