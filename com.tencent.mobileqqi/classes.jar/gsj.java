import android.view.MotionEvent;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.widget.ExtendInputMethodRelativeLayout.OnDownListener;
import com.tencent.util.InputMethodUtil;

public class gsj
  implements ExtendInputMethodRelativeLayout.OnDownListener
{
  public gsj(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    if (this.a.a(paramMotionEvent, this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel)) {}
    do
    {
      do
      {
        do
        {
          return false;
          if (System.currentTimeMillis() - this.a.jdField_a_of_type_Long < 500L) {
            return true;
          }
          this.a.jdField_a_of_type_Long = System.currentTimeMillis();
          if ((!this.a.i) && (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel != null) && (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() != 0) && (this.a.a(paramMotionEvent, this.a.jdField_a_of_type_AndroidWidgetImageButton)))
          {
            if ((this.a.jdField_a_of_type_AndroidWidgetEditText != null) && (this.a.jdField_a_of_type_AndroidWidgetEditText.hasFocus()))
            {
              this.a.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
              this.a.b.requestFocus();
            }
            this.a.a(true);
            return true;
          }
          if ((!this.a.i) || (this.a.a(paramMotionEvent, this.a.jdField_a_of_type_AndroidWidgetEditText)) || (this.a.a(paramMotionEvent, this.a.b))) {
            break;
          }
          if ((this.a.a(paramMotionEvent, this.a.jdField_a_of_type_AndroidWidgetImageButton)) && (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel != null))
          {
            if ((this.a.jdField_a_of_type_AndroidWidgetEditText != null) && (this.a.jdField_a_of_type_AndroidWidgetEditText.hasFocus()))
            {
              this.a.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
              this.a.b.requestFocus();
            }
            this.a.a(true);
            return true;
          }
          if ((this.a.b != null) && (this.a.b.hasFocus()))
          {
            InputMethodUtil.b(this.a.b);
            return true;
          }
        } while ((this.a.jdField_a_of_type_AndroidWidgetEditText == null) || (!this.a.jdField_a_of_type_AndroidWidgetEditText.hasFocus()));
        InputMethodUtil.b(this.a.jdField_a_of_type_AndroidWidgetEditText);
        return true;
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel == null) || (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() != 0) || (this.a.a(paramMotionEvent, this.a.jdField_a_of_type_AndroidWidgetImageButton)));
      this.a.a(false);
    } while ((this.a.a(paramMotionEvent, this.a.jdField_a_of_type_AndroidWidgetEditText)) || (this.a.a(paramMotionEvent, this.a.b)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gsj
 * JD-Core Version:    0.7.0.1
 */