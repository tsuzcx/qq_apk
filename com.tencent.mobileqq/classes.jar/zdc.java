import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ClipboardEditText;

class zdc
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private zdc(zcx paramzcx) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.getBottom();
    if (this.a.c < 0)
    {
      this.a.c = i;
      this.a.jdField_a_of_type_Zdb.a();
    }
    do
    {
      do
      {
        return;
      } while (this.a.c - i <= this.a.b);
      this.a.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      this.a.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this.a.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      this.a.c = i;
      this.a.jdField_a_of_type_AndroidViewViewGroup.requestLayout();
    } while (this.a.jdField_a_of_type_Zdb == null);
    this.a.jdField_a_of_type_Zdb.a(true, null);
    this.a.jdField_a_of_type_Zdb.a(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zdc
 * JD-Core Version:    0.7.0.1
 */