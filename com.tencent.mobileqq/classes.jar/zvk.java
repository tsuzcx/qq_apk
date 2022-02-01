import android.annotation.SuppressLint;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeProvider;
import com.tencent.biz.qrcode.CustomAccessibilityDelegate.1;

@SuppressLint({"NewApi"})
public class zvk
  extends View.AccessibilityDelegate
{
  private View jdField_a_of_type_AndroidViewView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CustomAccessibilityDelegate.1(this);
  private zvl jdField_a_of_type_Zvl;
  
  public zvk(View paramView, zvl paramzvl)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Zvl = paramzvl;
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
  {
    return new zvm(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zvk
 * JD-Core Version:    0.7.0.1
 */