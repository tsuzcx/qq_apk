import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar;

class vkl
  implements View.OnClickListener
{
  vkl(vkk paramvkk, vkj paramvkj) {}
  
  public void onClick(View paramView)
  {
    if (VideoCoverListBar.a(this.jdField_a_of_type_Vkk.jdField_a_of_type_Vkj.a) != null) {
      VideoCoverListBar.a(this.jdField_a_of_type_Vkk.jdField_a_of_type_Vkj.a).a(vkk.a(this.jdField_a_of_type_Vkk));
    }
    wta.a("play_video", "clk_mini", 0, 0, new String[] { "2", "", "", vkk.a(this.jdField_a_of_type_Vkk) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vkl
 * JD-Core Version:    0.7.0.1
 */