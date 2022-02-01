import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class zzm
  implements View.OnClickListener
{
  zzm(zzq paramzzq, String paramString, bkzi parambkzi) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Zzq.a(false, this.jdField_a_of_type_JavaLangString, true);
    this.jdField_a_of_type_Bkzi.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzm
 * JD-Core Version:    0.7.0.1
 */