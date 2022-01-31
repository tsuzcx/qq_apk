import android.annotation.SuppressLint;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeProvider;
import com.tencent.biz.qrcode.CustomAccessibilityDelegate.1;

@SuppressLint({"NewApi"})
public class vsk
  extends View.AccessibilityDelegate
{
  private View jdField_a_of_type_AndroidViewView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CustomAccessibilityDelegate.1(this);
  private vsl jdField_a_of_type_Vsl;
  
  public vsk(View paramView, vsl paramvsl)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Vsl = paramvsl;
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
  {
    return new vsm(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     vsk
 * JD-Core Version:    0.7.0.1
 */