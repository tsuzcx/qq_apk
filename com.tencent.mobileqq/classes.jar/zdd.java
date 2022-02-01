import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ClipboardEditText;

class zdd
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private zdd(zcx paramzcx) {}
  
  public void onGlobalLayout()
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.getBottom() - this.a.c > this.a.b)
    {
      this.a.dismiss();
      return;
    }
    this.a.jdField_a_of_type_Zdb.a(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zdd
 * JD-Core Version:    0.7.0.1
 */