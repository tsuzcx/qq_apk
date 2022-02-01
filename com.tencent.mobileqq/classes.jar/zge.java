import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zge
  implements View.OnClickListener
{
  zge(zgd paramzgd, zgg paramzgg) {}
  
  public void onClick(View paramView)
  {
    if (zgd.a(this.jdField_a_of_type_Zgd) != null) {
      zgd.a(this.jdField_a_of_type_Zgd).a((SlideItemInfo)this.jdField_a_of_type_Zgg.a.getTag());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zge
 * JD-Core Version:    0.7.0.1
 */