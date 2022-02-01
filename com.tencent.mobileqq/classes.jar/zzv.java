import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zzv
  implements View.OnClickListener
{
  zzv(zzu paramzzu, agqf paramagqf) {}
  
  public void onClick(View paramView)
  {
    zzu.a(this.jdField_a_of_type_Zzu).removeCallbacks(zzu.a(this.jdField_a_of_type_Zzu));
    zzu.a(this.jdField_a_of_type_Zzu, true);
    zzu.a(this.jdField_a_of_type_Zzu, this.jdField_a_of_type_Agqf, this.jdField_a_of_type_Agqf.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzv
 * JD-Core Version:    0.7.0.1
 */