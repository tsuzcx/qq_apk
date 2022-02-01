import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xta
  implements View.OnClickListener
{
  xta(xsz paramxsz, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Xsz.jdField_a_of_type_Xst != null) {
      this.jdField_a_of_type_Xsz.jdField_a_of_type_Xst.a(null, 0, this.jdField_a_of_type_Xsz.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xta
 * JD-Core Version:    0.7.0.1
 */