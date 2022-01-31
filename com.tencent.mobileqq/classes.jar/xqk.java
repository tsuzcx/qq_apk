import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity;
import com.tencent.mobileqq.activity.richmedia.view.RotationSeekBar;

class xqk
  implements Runnable
{
  xqk(xqj paramxqj, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_Xqj.a).setProgress((int)(this.jdField_a_of_type_Long * 100L / this.b));
    QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_Xqj.a).setText(QzDynamicVideoPreviewActivity.a(this.jdField_a_of_type_Long));
    QzDynamicVideoPreviewActivity.b(this.jdField_a_of_type_Xqj.a).setText(QzDynamicVideoPreviewActivity.a(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xqk
 * JD-Core Version:    0.7.0.1
 */