import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class tyx
  implements View.OnClickListener
{
  tyx(tym paramtym, int paramInt1, int paramInt2, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Tym.a(this.jdField_a_of_type_Int, this.b);
    this.jdField_a_of_type_Tym.o = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Tym.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tyx
 * JD-Core Version:    0.7.0.1
 */