import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;

public class dby
  implements IphonePickerView.PickerViewAdapter
{
  public dby(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
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
    if (this.a.c == 0)
    {
      if (paramInt2 >= 0)
      {
        paramInt1 = paramInt2;
        if (paramInt2 < ConditionSearchFriendActivity.b.length) {}
      }
      else
      {
        paramInt1 = 0;
      }
      return ConditionSearchFriendActivity.b[paramInt1];
    }
    if (paramInt2 >= 0)
    {
      paramInt1 = paramInt2;
      if (paramInt2 < ConditionSearchFriendActivity.a.length) {}
    }
    else
    {
      paramInt1 = 0;
    }
    return ConditionSearchFriendActivity.a[paramInt1];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dby
 * JD-Core Version:    0.7.0.1
 */