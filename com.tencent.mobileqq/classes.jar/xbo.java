import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ClipboardEditText;

class xbo
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private xbo(xbi paramxbi) {}
  
  public void onGlobalLayout()
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.getBottom() - this.a.c > this.a.b)
    {
      this.a.dismiss();
      return;
    }
    this.a.jdField_a_of_type_Xbm.a(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xbo
 * JD-Core Version:    0.7.0.1
 */