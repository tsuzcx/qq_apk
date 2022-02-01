import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zjz
  implements View.OnClickListener
{
  zjz(zjy paramzjy, zkb paramzkb) {}
  
  public void onClick(View paramView)
  {
    if (zjy.a(this.jdField_a_of_type_Zjy) != null) {
      zjy.a(this.jdField_a_of_type_Zjy).a((SlideItemInfo)this.jdField_a_of_type_Zkb.a.getTag());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjz
 * JD-Core Version:    0.7.0.1
 */