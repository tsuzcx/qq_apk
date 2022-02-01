import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zzc
  implements View.OnClickListener
{
  zzc(zzb paramzzb, int paramInt, View paramView, zyv paramzyv) {}
  
  public void onClick(View paramView)
  {
    zzb.a(this.jdField_a_of_type_Zzb, this.jdField_a_of_type_Int);
    if (aauy.a(String.valueOf(this.jdField_a_of_type_AndroidViewView.hashCode()))) {
      this.jdField_a_of_type_Zyv.onDoubleClickTitle();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzc
 * JD-Core Version:    0.7.0.1
 */