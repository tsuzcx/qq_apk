import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xif
  implements View.OnClickListener
{
  xif(xie paramxie, xid paramxid) {}
  
  public void onClick(View paramView)
  {
    if (VideoCoverListBar.a(this.jdField_a_of_type_Xie.jdField_a_of_type_Xid.a) != null) {
      VideoCoverListBar.a(this.jdField_a_of_type_Xie.jdField_a_of_type_Xid.a).a(xie.a(this.jdField_a_of_type_Xie));
    }
    yqu.a("play_video", "clk_mini", 0, 0, new String[] { "2", "", "", xie.a(this.jdField_a_of_type_Xie) });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xif
 * JD-Core Version:    0.7.0.1
 */