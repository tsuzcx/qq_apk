import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.d;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aefl
  implements IphonePickerView.d
{
  public aefl(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public String d(int paramInt1, int paramInt2)
  {
    int i;
    String str;
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
      paramInt2 = ConditionSearchFriendActivity.a(this.this$0, i);
      str = accv.dS[paramInt2];
      paramInt2 = i;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "getText|pickerType : " + this.this$0.pickerType + ", column : " + paramInt1 + ", row : " + paramInt2 + ", result : " + str);
      }
      return str;
      if (this.this$0.pickerType == 3)
      {
        if (paramInt2 >= 0)
        {
          i = paramInt2;
          if (paramInt2 < accv.dT.length) {}
        }
        else
        {
          i = 0;
        }
        str = accv.dT[i];
        paramInt2 = i;
      }
      else if (((this.this$0.pickerType == 1) || (this.this$0.pickerType == 2)) && (paramInt1 < this.this$0.mLocationListArray.length) && (this.this$0.mLocationListArray[paramInt1] != null) && (((List)this.this$0.mLocationListArray[paramInt1]).size() > 0))
      {
        if (paramInt2 >= 0)
        {
          i = paramInt2;
          if (paramInt2 < ((List)this.this$0.mLocationListArray[paramInt1]).size()) {}
        }
        else
        {
          i = 0;
        }
        if (((BaseAddress)((List)this.this$0.mLocationListArray[paramInt1]).get(i)).code.equals("0"))
        {
          str = ConditionSearchFriendActivity.access$100();
          paramInt2 = i;
        }
        else
        {
          str = ((BaseAddress)((List)this.this$0.mLocationListArray[paramInt1]).get(i)).name;
          paramInt2 = i;
        }
      }
      else
      {
        str = "";
      }
    }
  }
  
  public int getColumnCount()
  {
    int j = 1;
    int i;
    if (this.this$0.pickerType == 0) {
      i = 2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "getColumnCount|pickerType : " + this.this$0.pickerType + ", count : " + i);
      }
      return i;
      i = j;
      if (this.this$0.pickerType != 3) {
        if (this.this$0.pickerType != 1)
        {
          i = j;
          if (this.this$0.pickerType != 2) {}
        }
        else
        {
          i = this.this$0.mLocationColumCount;
        }
      }
    }
  }
  
  public int t(int paramInt)
  {
    int j = 0;
    int i;
    if (this.this$0.pickerType == 0) {
      i = accv.dS.length - 17;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "getRowCount|pickerType : " + this.this$0.pickerType + ", column : " + paramInt + ", count : " + i);
      }
      return i;
      if (this.this$0.pickerType == 3)
      {
        i = accv.dT.length;
      }
      else if (this.this$0.pickerType != 1)
      {
        i = j;
        if (this.this$0.pickerType != 2) {}
      }
      else
      {
        i = j;
        if (paramInt < this.this$0.mLocationColumCount)
        {
          i = j;
          if (paramInt >= 0)
          {
            i = j;
            if (this.this$0.mLocationListArray[paramInt] != null) {
              i = ((List)this.this$0.mLocationListArray[paramInt]).size();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aefl
 * JD-Core Version:    0.7.0.1
 */