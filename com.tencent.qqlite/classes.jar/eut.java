import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;

public class eut
  implements View.OnTouchListener
{
  public eut(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839035);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eut
 * JD-Core Version:    0.7.0.1
 */