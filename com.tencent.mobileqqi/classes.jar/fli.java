import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;

public class fli
  implements IphonePickerView.PickerViewAdapter
{
  public fli(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt)
  {
    if (this.a.c == 0) {
      return ConditionSearchFriendActivity.b.length;
    }
    return ConditionSearchFriendActivity.a.length;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    if (this.a.c == 0) {
      return ConditionSearchFriendActivity.b[paramInt2];
    }
    return ConditionSearchFriendActivity.a[paramInt2];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fli
 * JD-Core Version:    0.7.0.1
 */