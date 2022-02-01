import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.data.AddressData.NO_LIMIT_ADDRESS;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.c;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class aefw
  implements IphonePickerView.c
{
  public aefw(LocationSelectActivity paramLocationSelectActivity) {}
  
  public void dn()
  {
    LocationSelectActivity.a(this.this$0).setRightTextColor(2);
    this.this$0.jdField_d_of_type_Ausj.dismiss();
  }
  
  public void w(int paramInt1, int paramInt2)
  {
    if (this.this$0.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView == null) {
      return;
    }
    switch (paramInt1)
    {
    }
    label809:
    label812:
    for (;;)
    {
      LocationSelectActivity.a(this.this$0, LocationSelectActivity.a(this.this$0), LocationSelectActivity.a(this.this$0));
      return;
      this.this$0.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(null);
      this.this$0.aH[0] = paramInt2;
      this.this$0.a[0] = ((BaseAddress)((ArrayList)this.this$0.f[0]).get(paramInt2));
      ArrayList localArrayList1 = this.this$0.a[0].getDataList();
      if (localArrayList1.size() > 0)
      {
        this.this$0.f[1] = localArrayList1;
        this.this$0.a[1] = ((BaseAddress)localArrayList1.get(0));
        this.this$0.aH[1] = 0;
        localArrayList1 = this.this$0.a[1].getDataList();
        if (localArrayList1.size() > 0)
        {
          this.this$0.f[2] = localArrayList1;
          this.this$0.a[2] = ((BaseAddress)localArrayList1.get(0));
          this.this$0.aH[2] = 0;
        }
      }
      for (;;)
      {
        if (this.this$0.columnCount > 1)
        {
          this.this$0.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.LV(1);
          this.this$0.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.this$0.aH[1]);
          if (this.this$0.columnCount == 3)
          {
            this.this$0.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.LV(2);
            this.this$0.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.this$0.aH[2]);
          }
        }
        this.this$0.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this);
        break;
        if (this.this$0.columnCount == 3)
        {
          this.this$0.a[2] = new AddressData.NO_LIMIT_ADDRESS(3);
          this.this$0.f[2] = null;
          this.this$0.aH[2] = 0;
          continue;
          if (this.this$0.columnCount > 1)
          {
            this.this$0.a[1] = new AddressData.NO_LIMIT_ADDRESS(2);
            this.this$0.f[1] = null;
            this.this$0.aH[1] = 0;
            if (this.this$0.columnCount == 3)
            {
              this.this$0.a[2] = new AddressData.NO_LIMIT_ADDRESS(3);
              this.this$0.f[2] = null;
              this.this$0.aH[2] = 0;
            }
          }
        }
      }
      this.this$0.aH[1] = paramInt2;
      this.this$0.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(null);
      try
      {
        this.this$0.a[1] = ((BaseAddress)((ArrayList)this.this$0.f[1]).get(paramInt2));
        localArrayList1 = this.this$0.a[1].getDataList();
        if (localArrayList1.size() > 0)
        {
          this.this$0.f[2] = localArrayList1;
          this.this$0.a[2] = ((BaseAddress)localArrayList1.get(0));
          this.this$0.aH[2] = 0;
          if (this.this$0.columnCount > 2)
          {
            this.this$0.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.LV(2);
            this.this$0.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.this$0.aH[2]);
          }
          this.this$0.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.this$0.a[1] = new BaseAddress("不限", "0", 2);
          continue;
          if (this.this$0.columnCount > 2)
          {
            this.this$0.a[2] = new AddressData.NO_LIMIT_ADDRESS(3);
            this.this$0.f[2] = null;
            this.this$0.aH[2] = 0;
          }
        }
      }
      ArrayList localArrayList2;
      if (Collections.emptyList().equals(this.this$0.f[2]))
      {
        if (!QLog.isColorLevel()) {
          break label809;
        }
        QLog.d("LocationSelectActivity", 2, "columnListArray at 2 is empty");
        localArrayList2 = null;
      }
      for (;;)
      {
        if ((localArrayList2 == null) || (paramInt2 >= localArrayList2.size()) || (paramInt2 < 0)) {
          break label812;
        }
        this.this$0.a[2] = ((BaseAddress)localArrayList2.get(paramInt2));
        this.this$0.aH[2] = paramInt2;
        break;
        localArrayList2 = (ArrayList)this.this$0.f[2];
        continue;
        localArrayList2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aefw
 * JD-Core Version:    0.7.0.1
 */