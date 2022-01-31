import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.onSizeChangedListenner;

public class trn
  implements InputMethodRelativeLayout.onSizeChangedListenner
{
  public trn(SubLoginActivity paramSubLoginActivity) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      int[] arrayOfInt = new int[2];
      SubLoginActivity.a(this.a).getLocationInWindow(arrayOfInt);
      paramInt1 = arrayOfInt[1];
      SubLoginActivity.a(this.a).getLocationInWindow(arrayOfInt);
      paramInt1 = paramInt1 - arrayOfInt[1] + SubLoginActivity.a(this.a).getHeight() - paramInt2;
      if (paramInt1 > 0) {
        SubLoginActivity.a(this.a).setPadding(SubLoginActivity.a(this.a).getPaddingLeft(), SubLoginActivity.a(this.a).getPaddingTop() - paramInt1, SubLoginActivity.a(this.a).getPaddingRight(), SubLoginActivity.a(this.a).getPaddingBottom());
      }
      SubLoginActivity.b(this.a).setVisibility(8);
      return;
    }
    SubLoginActivity.b(this.a).setVisibility(0);
    SubLoginActivity.a(this.a).setPadding(0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     trn
 * JD-Core Version:    0.7.0.1
 */