import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import java.util.List;

class tmn
  implements View.OnClickListener
{
  tmn(tmm paramtmm) {}
  
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
        paramView = ((tnz)this.a.jdField_a_of_type_JavaUtilList.get(this.a.jdField_a_of_type_Int)).a;
      }
    }
    urp.a("play_video", "clk_quit", 0, 0, new String[] { "", "", "", paramView });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tmn
 * JD-Core Version:    0.7.0.1
 */