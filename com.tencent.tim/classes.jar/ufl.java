import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.c;

public class ufl
  implements IphonePickerView.c
{
  public ufl(AgeSelectionActivity paramAgeSelectionActivity) {}
  
  public void dn()
  {
    if ((AgeSelectionActivity.a(this.a) != null) && (AgeSelectionActivity.a(this.a).isShowing())) {
      AgeSelectionActivity.a(this.a).dismiss();
    }
  }
  
  public void w(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AgeSelectionActivity.a(this.a);
      AgeSelectionActivity.b(this.a);
      if ((AgeSelectionActivity.a(this.a) != null) && ((paramInt1 == 0) || (paramInt1 == 1))) {
        AgeSelectionActivity.a(this.a).LV(2);
      }
      return;
      AgeSelectionActivity.a(this.a, paramInt2);
      continue;
      AgeSelectionActivity.b(this.a, paramInt2);
      continue;
      AgeSelectionActivity.c(this.a, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ufl
 * JD-Core Version:    0.7.0.1
 */