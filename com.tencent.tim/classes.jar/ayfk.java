import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayfk
  implements View.OnClickListener
{
  ayfk(ayfh paramayfh, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.b.jdField_a_of_type_Ayii != null) && (this.a.b.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)) {
      this.a.b.changeState(this.eKa);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayfk
 * JD-Core Version:    0.7.0.1
 */