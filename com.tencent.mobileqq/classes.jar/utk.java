import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class utk
  implements View.OnClickListener
{
  utk(uta paramuta, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Uta.j();
    this.jdField_a_of_type_Uta.o = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Uta.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utk
 * JD-Core Version:    0.7.0.1
 */