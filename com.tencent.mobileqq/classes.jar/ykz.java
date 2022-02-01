import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ykz
  implements View.OnClickListener
{
  ykz(yky paramyky, ylb paramylb) {}
  
  public void onClick(View paramView)
  {
    if (yky.a(this.jdField_a_of_type_Yky) != null) {
      yky.a(this.jdField_a_of_type_Yky).a((SlideItemInfo)this.jdField_a_of_type_Ylb.a.getTag());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ykz
 * JD-Core Version:    0.7.0.1
 */