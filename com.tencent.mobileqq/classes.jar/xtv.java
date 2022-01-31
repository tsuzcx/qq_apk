import android.annotation.SuppressLint;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeProvider;
import com.tencent.biz.qrcode.CustomAccessibilityDelegate.1;

@SuppressLint({"NewApi"})
public class xtv
  extends View.AccessibilityDelegate
{
  private View jdField_a_of_type_AndroidViewView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CustomAccessibilityDelegate.1(this);
  private xtw jdField_a_of_type_Xtw;
  
  public xtv(View paramView, xtw paramxtw)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Xtw = paramxtw;
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
  {
    return new xtx(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xtv
 * JD-Core Version:    0.7.0.1
 */