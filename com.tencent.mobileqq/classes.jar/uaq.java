import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.TroopRobotPickerActivity;
import com.tencent.mobileqq.activity.TroopRobotPickerActivity.RobotPickerData;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class uaq
  implements DialogInterface.OnDismissListener
{
  TroopRobotPickerActivity.RobotPickerData jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData;
  
  public uaq(TroopRobotPickerActivity paramTroopRobotPickerActivity, TroopRobotPickerActivity.RobotPickerData paramRobotPickerData)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData = paramRobotPickerData;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TroopRobotPickerActivity.jdField_a_of_type_JavaLangString, 2, "onDismiss|pickerType : " + this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 2)
    {
      paramDialogInterface = new Intent();
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("ageStart", this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex1);
        localJSONObject.put("ageEnd", this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex2);
        paramDialogInterface.putExtra("result", localJSONObject.toString());
        paramDialogInterface.putExtra("callback", this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity.b);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity.setResult(-1, paramDialogInterface);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity.finish();
        if (QLog.isColorLevel()) {
          QLog.d(TroopRobotPickerActivity.jdField_a_of_type_JavaLangString, 2, "onDismiss|mCurAgeIndex1 : " + this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex1 + ", mCurAgeIndex2 : " + this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex2 + ", mAgeSelectIndex1 : " + this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex1 + ", mAgeSelectIndex2 : " + this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex2);
        }
        return;
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          localJSONException1.printStackTrace();
        }
      }
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType;
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData;
    if (i == 1)
    {
      paramDialogInterface = new Intent();
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("sex", this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mSexIndex);
        paramDialogInterface.putExtra("callback", this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity.b);
        paramDialogInterface.putExtra("result", localJSONObject.toString());
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity.setResult(-1, paramDialogInterface);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity.finish();
        return;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
    paramDialogInterface = new Intent();
    JSONObject localJSONObject = new JSONObject();
    i = 0;
    try
    {
      while (i < this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray.length)
      {
        localJSONObject.put(TroopRobotPickerActivity.jdField_a_of_type_ArrayOfJavaLangString[i], this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[i]);
        localJSONObject.put(TroopRobotPickerActivity.jdField_a_of_type_ArrayOfJavaLangString[i] + "Str", this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[i].name);
        i += 1;
      }
      localJSONObject.put("country", this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountyCode);
      localJSONObject.put("countryStr", this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry.name);
    }
    catch (JSONException localJSONException3)
    {
      for (;;)
      {
        localJSONException3.printStackTrace();
      }
    }
    paramDialogInterface.putExtra("result", localJSONObject.toString());
    paramDialogInterface.putExtra("callback", this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity.b);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity.setResult(-1, paramDialogInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uaq
 * JD-Core Version:    0.7.0.1
 */