import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xma
  implements View.OnClickListener
{
  xma(xlz paramxlz, xly paramxly) {}
  
  public void onClick(View paramView)
  {
    if (VideoCoverListBar.a(this.jdField_a_of_type_Xlz.jdField_a_of_type_Xly.a) != null) {
      VideoCoverListBar.a(this.jdField_a_of_type_Xlz.jdField_a_of_type_Xly.a).a(xlz.a(this.jdField_a_of_type_Xlz));
    }
    yup.a("play_video", "clk_mini", 0, 0, new String[] { "2", "", "", xlz.a(this.jdField_a_of_type_Xlz) });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xma
 * JD-Core Version:    0.7.0.1
 */