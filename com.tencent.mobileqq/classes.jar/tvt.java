import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar;

class tvt
  implements View.OnClickListener
{
  tvt(tvs paramtvs, tvr paramtvr) {}
  
  public void onClick(View paramView)
  {
    if (VideoCoverListBar.a(this.jdField_a_of_type_Tvs.jdField_a_of_type_Tvr.a) != null) {
      VideoCoverListBar.a(this.jdField_a_of_type_Tvs.jdField_a_of_type_Tvr.a).a(tvs.a(this.jdField_a_of_type_Tvs));
    }
    vei.a("play_video", "clk_mini", 0, 0, new String[] { "2", "", "", tvs.a(this.jdField_a_of_type_Tvs) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tvt
 * JD-Core Version:    0.7.0.1
 */