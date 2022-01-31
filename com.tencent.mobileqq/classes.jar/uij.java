import android.content.res.Resources;
import com.tencent.mobileqq.activity.TroopRobotPickerActivity;
import com.tencent.mobileqq.activity.TroopRobotPickerActivity.RobotPickerData;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.conditionsearch.data.AddressData.NO_LIMIT_ADDRESS;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.List;

public class uij
  implements IphonePickerView.IphonePickListener
{
  public TroopRobotPickerActivity.RobotPickerData a;
  IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  
  public uij(TroopRobotPickerActivity paramTroopRobotPickerActivity, TroopRobotPickerActivity.RobotPickerData paramRobotPickerData, IphonePickerView paramIphonePickerView, ActionSheet paramActionSheet)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData = paramRobotPickerData;
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = paramIphonePickerView;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = paramActionSheet;
  }
  
  public void onConfirmBtClicked()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex1 > this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex2) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex2 != 0)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity.getResources().getString(2131437322), 0).a();
    }
    while ((this.jdField_a_of_type_ComTencentWidgetActionSheet == null) || (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData == null) {}
    do
    {
      do
      {
        ArrayList localArrayList2;
        do
        {
          do
          {
            for (;;)
            {
              return;
              if (QLog.isColorLevel()) {
                QLog.d(TroopRobotPickerActivity.a, 2, "onItemSelected|pickerType : " + this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType + ", column : " + paramInt1 + ", row : " + paramInt2);
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 2)
              {
                int i;
                if (paramInt2 >= 0)
                {
                  i = paramInt2;
                  if (paramInt2 < ConditionSearchManager.b.length) {}
                }
                else
                {
                  i = 0;
                }
                switch (paramInt1)
                {
                }
                while ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex1 <= this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex2) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex2 == 0))
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex1;
                  this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex2 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex2;
                  return;
                  this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex1 = i;
                  continue;
                  this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex2 = i;
                }
              }
              else
              {
                if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 1)
                {
                  if (paramInt2 >= 0)
                  {
                    paramInt1 = paramInt2;
                    if (paramInt2 < ConditionSearchManager.c.length) {}
                  }
                  else
                  {
                    paramInt1 = 0;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mSexIndex = paramInt1;
                  return;
                }
                switch (paramInt1)
                {
                default: 
                  return;
                case 0: 
                  if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[0] != null) && (((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[0]).size() > 0))
                  {
                    if (paramInt2 >= 0)
                    {
                      paramInt1 = paramInt2;
                      if (paramInt2 < ((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[0]).size()) {}
                    }
                    else
                    {
                      paramInt1 = 0;
                    }
                    this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[0] = paramInt1;
                    this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[0] = ((BaseAddress)((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[0]).get(paramInt1));
                    this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[0] = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[0].code;
                    ArrayList localArrayList1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[0].getDataList();
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount > 1)
                    {
                      this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[1] = localArrayList1;
                      this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[1] = 0;
                      this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[1] = new AddressData.NO_LIMIT_ADDRESS(2);
                      this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[1] = "0";
                      try
                      {
                        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1);
                        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, 0);
                        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount > 2)
                        {
                          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[2] = null;
                          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[2] = 0;
                          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[2] = new AddressData.NO_LIMIT_ADDRESS(2);
                          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[2] = "0";
                          try
                          {
                            this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
                            this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, 0);
                            return;
                          }
                          catch (Exception localException1)
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d(TroopRobotPickerActivity.a, 2, localException1, new Object[0]);
                            }
                          }
                          if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
                          {
                            this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
                            return;
                          }
                        }
                      }
                      catch (Exception localException2)
                      {
                        for (;;)
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d(TroopRobotPickerActivity.a, 2, localException2, new Object[0]);
                          }
                          if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
                            this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
                          }
                        }
                      }
                    }
                  }
                  break;
                }
              }
            }
          } while ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[1] == null) || (((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[1]).size() <= 0));
          if (paramInt2 >= 0)
          {
            paramInt1 = paramInt2;
            if (paramInt2 < ((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[1]).size()) {}
          }
          else
          {
            paramInt1 = 0;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[1] = paramInt1;
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[1] = ((BaseAddress)((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[1]).get(paramInt1));
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[1] = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[1].code;
          localArrayList2 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[1].getDataList();
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount <= 2);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[2] = localArrayList2;
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[2] = 0;
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[2] = new AddressData.NO_LIMIT_ADDRESS(2);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[2] = "0";
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, 0);
          return;
        }
        catch (Exception localException3)
        {
          if (QLog.isColorLevel()) {
            QLog.d(TroopRobotPickerActivity.a, 2, localException3, new Object[0]);
          }
        }
      } while ((this.jdField_a_of_type_ComTencentWidgetActionSheet == null) || (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[2] == null) || (((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[2]).size() <= 0));
    if (paramInt2 >= 0)
    {
      paramInt1 = paramInt2;
      if (paramInt2 < ((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[2]).size()) {}
    }
    else
    {
      paramInt1 = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[2] = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[2] = ((BaseAddress)((List)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[2]).get(paramInt1));
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[2] = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[2].code;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uij
 * JD-Core Version:    0.7.0.1
 */