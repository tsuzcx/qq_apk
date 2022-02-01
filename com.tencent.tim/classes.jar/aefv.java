import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.d;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aefv
  implements IphonePickerView.d
{
  public aefv(LocationSelectActivity paramLocationSelectActivity) {}
  
  public String d(int paramInt1, int paramInt2)
  {
    try
    {
      if (this.this$0.f[paramInt1] != null)
      {
        if (((BaseAddress)((List)this.this$0.f[paramInt1]).get(paramInt2)).code.equals("0")) {
          return "----";
        }
        String str = ((BaseAddress)((List)this.this$0.f[paramInt1]).get(paramInt2)).name;
        return str;
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LocationSelectActivity", 2, "", localIndexOutOfBoundsException);
      }
    }
    return "";
  }
  
  public int getColumnCount()
  {
    return this.this$0.columnCount;
  }
  
  public int t(int paramInt)
  {
    if (this.this$0.f[paramInt] != null) {
      return ((List)this.this$0.f[paramInt]).size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aefv
 * JD-Core Version:    0.7.0.1
 */