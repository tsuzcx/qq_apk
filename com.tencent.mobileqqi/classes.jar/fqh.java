import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import java.util.List;

public class fqh
  implements IphonePickerView.PickerViewAdapter
{
  public fqh(LocationSelectActivity paramLocationSelectActivity) {}
  
  public int a()
  {
    return this.a.h;
  }
  
  public int a(int paramInt)
  {
    if (this.a.a[paramInt] != null) {
      return ((List)this.a.a[paramInt]).size();
    }
    return 0;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    if (this.a.a[paramInt1] != null) {
      return ((BaseAddress)((List)this.a.a[paramInt1]).get(paramInt2)).a;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fqh
 * JD-Core Version:    0.7.0.1
 */