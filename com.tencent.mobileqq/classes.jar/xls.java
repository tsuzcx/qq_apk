import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class xls
  implements View.OnClickListener
{
  xls(xlr paramxlr) {}
  
  public void onClick(View paramView)
  {
    Object localObject = ((StoryPlayerGroupHolder)this.a.a()).a();
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).d = 2;
    }
    this.a.a().finish();
    String str = "";
    localObject = str;
    if (this.a.jdField_a_of_type_Int >= 0)
    {
      localObject = str;
      if (this.a.jdField_a_of_type_Int < this.a.jdField_a_of_type_JavaUtilList.size()) {
        localObject = ((xne)this.a.jdField_a_of_type_JavaUtilList.get(this.a.jdField_a_of_type_Int)).a;
      }
    }
    yqu.a("play_video", "clk_quit", 0, 0, new String[] { "", "", "", localObject });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xls
 * JD-Core Version:    0.7.0.1
 */