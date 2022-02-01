import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xcg
  implements View.OnClickListener
{
  xcg(xcf paramxcf, xce paramxce) {}
  
  public void onClick(View paramView)
  {
    if (VideoCoverListBar.a(this.jdField_a_of_type_Xcf.jdField_a_of_type_Xce.a) != null) {
      VideoCoverListBar.a(this.jdField_a_of_type_Xcf.jdField_a_of_type_Xce.a).a(xcf.a(this.jdField_a_of_type_Xcf));
    }
    ykv.a("play_video", "clk_mini", 0, 0, new String[] { "2", "", "", xcf.a(this.jdField_a_of_type_Xcf) });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcg
 * JD-Core Version:    0.7.0.1
 */