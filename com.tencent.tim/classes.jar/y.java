import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageButton;
import com.dataline.activities.LiteActivity;
import com.tencent.widget.XEditTextEx;

public class y
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public y(LiteActivity paramLiteActivity) {}
  
  public void onGlobalLayout()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 3) && (!LiteActivity.a(this.this$0)))
    {
      this.this$0.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      return;
    }
    this.this$0.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     y
 * JD-Core Version:    0.7.0.1
 */