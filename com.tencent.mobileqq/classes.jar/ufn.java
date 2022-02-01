import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ufn
  implements View.OnClickListener
{
  ufn(ufd paramufd, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Ufd.j();
    this.jdField_a_of_type_Ufd.o = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Ufd.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufn
 * JD-Core Version:    0.7.0.1
 */