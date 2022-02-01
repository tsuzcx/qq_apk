import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class tyz
  implements View.OnClickListener
{
  tyz(tyo paramtyo, int paramInt1, int paramInt2, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Tyo.a(this.jdField_a_of_type_Int, this.b);
    this.jdField_a_of_type_Tyo.o = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Tyo.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tyz
 * JD-Core Version:    0.7.0.1
 */