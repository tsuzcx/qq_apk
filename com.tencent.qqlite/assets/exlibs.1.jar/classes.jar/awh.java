import com.tencent.mobileqq.activity.NearPeopleFilterActivity;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;

public class awh
  implements IphonePickerView.PickerViewAdapter
{
  public awh(NearPeopleFilterActivity paramNearPeopleFilterActivity) {}
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt)
  {
    if (this.a.i == 0) {
      return NearPeopleFilterActivity.NearPeopleFilters.a.length;
    }
    return NearPeopleFilterActivity.NearPeopleFilters.b.length;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    if (this.a.i == 0) {
      return NearPeopleFilterActivity.NearPeopleFilters.a[paramInt2];
    }
    return NearPeopleFilterActivity.NearPeopleFilters.b[paramInt2];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     awh
 * JD-Core Version:    0.7.0.1
 */