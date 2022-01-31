import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.onSizeChangedListenner;
import com.tencent.qphone.base.util.QLog;

public class czr
  implements InputMethodRelativeLayout.onSizeChangedListenner
{
  public czr(LoginActivity paramLoginActivity) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity", 2, "onSizeChange isOpen:" + paramBoolean + " preH:" + paramInt1 + " curH:" + paramInt2);
    }
    if (paramBoolean)
    {
      int[] arrayOfInt = new int[2];
      this.a.jdField_a_of_type_AndroidWidgetButton.getLocationInWindow(arrayOfInt);
      paramInt1 = arrayOfInt[1];
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.getLocationInWindow(arrayOfInt);
      int i = arrayOfInt[1];
      paramInt2 = paramInt1 - i + this.a.jdField_a_of_type_AndroidWidgetButton.getHeight() - paramInt2;
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity", 2, "onSizeChange btnY:" + paramInt1 + " layoutY:" + i + " paddingY:" + paramInt2);
      }
      if (paramInt2 > 0) {
        this.a.c.setPadding(this.a.c.getPaddingLeft(), this.a.c.getPaddingTop() - paramInt2, this.a.c.getPaddingRight(), this.a.c.getPaddingBottom());
      }
      this.a.b.setVisibility(8);
      return;
    }
    this.a.b.setVisibility(0);
    this.a.c.setPadding(0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     czr
 * JD-Core Version:    0.7.0.1
 */