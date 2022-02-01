import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yzs
  implements View.OnClickListener
{
  yzs(yzr paramyzr, yzu paramyzu) {}
  
  public void onClick(View paramView)
  {
    if (yzr.a(this.jdField_a_of_type_Yzr) != null) {
      yzr.a(this.jdField_a_of_type_Yzr).a((SlideItemInfo)this.jdField_a_of_type_Yzu.a.getTag());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yzs
 * JD-Core Version:    0.7.0.1
 */