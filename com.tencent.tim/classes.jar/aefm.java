import android.content.res.Resources;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.conditionsearch.data.AddressData.NO_LIMIT_ADDRESS;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.c;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aefm
  implements IphonePickerView.c
{
  public aefm(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void dn()
  {
    if ((this.this$0.pickerType == 0) && (this.this$0.mCurAgeIndex1 > this.this$0.mCurAgeIndex2) && (this.this$0.mCurAgeIndex2 != 0)) {
      QQToast.a(this.this$0, this.this$0.getResources().getString(2131691949), 0).show(this.this$0.getTitleBarHeight());
    }
    while ((this.this$0.jdField_d_of_type_Ausj == null) || (!this.this$0.jdField_d_of_type_Ausj.isShowing())) {
      return;
    }
    this.this$0.jdField_d_of_type_Ausj.dismiss();
  }
  
  public void w(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "onItemSelected|pickerType : " + this.this$0.pickerType + ", column : " + paramInt1 + ", row : " + paramInt2);
    }
    int i;
    Object localObject;
    if (this.this$0.pickerType == 0)
    {
      if (paramInt2 >= 0)
      {
        i = paramInt2;
        if (paramInt2 < accv.dS.length) {}
      }
      else
      {
        i = 0;
      }
      switch (paramInt1)
      {
      default: 
        if ((this.this$0.mCurAgeIndex1 <= this.this$0.mCurAgeIndex2) || (this.this$0.mCurAgeIndex2 == 0))
        {
          this.this$0.mAgeSelectIndex1 = ConditionSearchFriendActivity.a(this.this$0, this.this$0.mCurAgeIndex1);
          this.this$0.mAgeSelectIndex2 = ConditionSearchFriendActivity.a(this.this$0, this.this$0.mCurAgeIndex2);
        }
        localObject = this.this$0.b.B(this.this$0.mAgeSelectIndex1, this.this$0.mAgeSelectIndex2);
        this.this$0.av.setRightText((CharSequence)localObject);
      }
    }
    do
    {
      return;
      this.this$0.mCurAgeIndex1 = i;
      break;
      this.this$0.mCurAgeIndex2 = i;
      break;
      if (this.this$0.pickerType == 3)
      {
        if (paramInt2 >= 0)
        {
          paramInt1 = paramInt2;
          if (paramInt2 < accv.dT.length) {}
        }
        else
        {
          paramInt1 = 0;
        }
        this.this$0.cMu = paramInt1;
        this.this$0.az.setRightText(accv.dT[paramInt1]);
        return;
      }
      switch (paramInt1)
      {
      }
      while (this.this$0.pickerType == 1)
      {
        this.this$0.aw.setRightText(this.this$0.b.je(ConditionSearchFriendActivity.a(this.this$0)));
        return;
        if ((this.this$0.mLocationListArray.length > 0) && (this.this$0.mLocationListArray[0] != null) && (((List)this.this$0.mLocationListArray[0]).size() > 0))
        {
          if (paramInt2 >= 0)
          {
            paramInt1 = paramInt2;
            if (paramInt2 < ((List)this.this$0.mLocationListArray[0]).size()) {}
          }
          else
          {
            paramInt1 = 0;
          }
          this.this$0.mLocationIndexArray[0] = paramInt1;
          this.this$0.mLocationArray[0] = ((BaseAddress)((List)this.this$0.mLocationListArray[0]).get(paramInt1));
          this.this$0.mLocationCodeArray[0] = this.this$0.mLocationArray[0].code;
          localObject = this.this$0.mLocationArray[0].getDataList();
          if (this.this$0.mLocationColumCount > 1)
          {
            this.this$0.mLocationListArray[1] = localObject;
            this.this$0.mLocationIndexArray[1] = 0;
            this.this$0.mLocationArray[1] = new AddressData.NO_LIMIT_ADDRESS(2);
            this.this$0.mLocationCodeArray[1] = "0";
            try
            {
              this.this$0.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.LV(1);
              this.this$0.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, 0);
              if (this.this$0.mLocationColumCount <= 2) {
                continue;
              }
              this.this$0.mLocationListArray[2] = null;
              this.this$0.mLocationIndexArray[2] = 0;
              this.this$0.mLocationArray[2] = new AddressData.NO_LIMIT_ADDRESS(2);
              this.this$0.mLocationCodeArray[2] = "0";
              try
              {
                this.this$0.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.LV(2);
                this.this$0.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, 0);
              }
              catch (Exception localException1)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ConditionSearchFriendActivity", 2, localException1, new Object[0]);
                }
              }
              if ((this.this$0.jdField_d_of_type_Ausj == null) || (!this.this$0.jdField_d_of_type_Ausj.isShowing())) {
                continue;
              }
              this.this$0.jdField_d_of_type_Ausj.dismiss();
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ConditionSearchFriendActivity", 2, localException2, new Object[0]);
                }
                if ((this.this$0.jdField_d_of_type_Ausj != null) && (this.this$0.jdField_d_of_type_Ausj.isShowing())) {
                  this.this$0.jdField_d_of_type_Ausj.dismiss();
                }
              }
            }
            if ((this.this$0.mLocationListArray.length > 1) && (this.this$0.mLocationListArray[1] != null) && (((List)this.this$0.mLocationListArray[1]).size() > 0))
            {
              if (paramInt2 >= 0)
              {
                paramInt1 = paramInt2;
                if (paramInt2 < ((List)this.this$0.mLocationListArray[1]).size()) {}
              }
              else
              {
                paramInt1 = 0;
              }
              this.this$0.mLocationIndexArray[1] = paramInt1;
              this.this$0.mLocationArray[1] = ((BaseAddress)((List)this.this$0.mLocationListArray[1]).get(paramInt1));
              this.this$0.mLocationCodeArray[1] = this.this$0.mLocationArray[1].code;
              ArrayList localArrayList = this.this$0.mLocationArray[1].getDataList();
              if (this.this$0.mLocationColumCount > 2)
              {
                this.this$0.mLocationListArray[2] = localArrayList;
                this.this$0.mLocationIndexArray[2] = 0;
                this.this$0.mLocationArray[2] = new AddressData.NO_LIMIT_ADDRESS(2);
                this.this$0.mLocationCodeArray[2] = "0";
                try
                {
                  this.this$0.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.LV(2);
                  this.this$0.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, 0);
                }
                catch (Exception localException3)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ConditionSearchFriendActivity", 2, localException3, new Object[0]);
                  }
                }
                if ((this.this$0.jdField_d_of_type_Ausj != null) && (this.this$0.jdField_d_of_type_Ausj.isShowing()))
                {
                  this.this$0.jdField_d_of_type_Ausj.dismiss();
                  continue;
                  if ((this.this$0.mLocationColumCount > 2) && (this.this$0.mLocationListArray[2] != null) && (((List)this.this$0.mLocationListArray[2]).size() > 0))
                  {
                    if (paramInt2 >= 0)
                    {
                      paramInt1 = paramInt2;
                      if (paramInt2 < ((List)this.this$0.mLocationListArray[2]).size()) {}
                    }
                    else
                    {
                      paramInt1 = 0;
                    }
                    this.this$0.mLocationIndexArray[2] = paramInt1;
                    this.this$0.mLocationArray[2] = ((BaseAddress)((List)this.this$0.mLocationListArray[2]).get(paramInt1));
                    this.this$0.mLocationCodeArray[2] = this.this$0.mLocationArray[2].code;
                  }
                }
              }
            }
          }
        }
      }
    } while (this.this$0.pickerType != 2);
    this.this$0.ax.setRightText(this.this$0.b.je(ConditionSearchFriendActivity.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aefm
 * JD-Core Version:    0.7.0.1
 */