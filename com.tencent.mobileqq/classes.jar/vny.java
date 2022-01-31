import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import java.util.List;

class vny
  implements View.OnClickListener
{
  vny(vnx paramvnx) {}
  
  public void onClick(View paramView)
  {
    paramView = ((StoryPlayerGroupHolder)this.a.a()).a();
    if (paramView != null) {
      paramView.d = 2;
    }
    this.a.a().finish();
    String str = "";
    paramView = str;
    if (this.a.jdField_a_of_type_Int >= 0)
    {
      paramView = str;
      if (this.a.jdField_a_of_type_Int < this.a.jdField_a_of_type_JavaUtilList.size()) {
        paramView = ((vpk)this.a.jdField_a_of_type_JavaUtilList.get(this.a.jdField_a_of_type_Int)).a;
      }
    }
    wta.a("play_video", "clk_quit", 0, 0, new String[] { "", "", "", paramView });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vny
 * JD-Core Version:    0.7.0.1
 */