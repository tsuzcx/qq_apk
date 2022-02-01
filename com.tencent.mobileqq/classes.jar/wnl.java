import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class wnl
  implements View.OnClickListener
{
  wnl(wnk paramwnk, wnj paramwnj) {}
  
  public void onClick(View paramView)
  {
    if (VideoCoverListBar.a(this.jdField_a_of_type_Wnk.jdField_a_of_type_Wnj.a) != null) {
      VideoCoverListBar.a(this.jdField_a_of_type_Wnk.jdField_a_of_type_Wnj.a).a(wnk.a(this.jdField_a_of_type_Wnk));
    }
    xwa.a("play_video", "clk_mini", 0, 0, new String[] { "2", "", "", wnk.a(this.jdField_a_of_type_Wnk) });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnl
 * JD-Core Version:    0.7.0.1
 */