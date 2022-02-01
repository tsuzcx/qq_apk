import android.annotation.SuppressLint;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeProvider;
import com.tencent.biz.qrcode.CustomAccessibilityDelegate.1;

@SuppressLint({"NewApi"})
public class zjo
  extends View.AccessibilityDelegate
{
  private View jdField_a_of_type_AndroidViewView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CustomAccessibilityDelegate.1(this);
  private zjp jdField_a_of_type_Zjp;
  
  public zjo(View paramView, zjp paramzjp)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Zjp = paramzjp;
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
  {
    return new zjq(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjo
 * JD-Core Version:    0.7.0.1
 */