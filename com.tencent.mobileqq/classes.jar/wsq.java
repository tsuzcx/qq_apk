import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wsq
  extends wsr
  implements View.OnClickListener
{
  private long a;
  
  public wsq(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Wsk == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 500L)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        vwm localvwm = this.jdField_a_of_type_Wsk.a().getVideoLinkInfo();
        if ((localvwm != null) && (localvwm.a()) && (localvwm.a.a()))
        {
          wmu.a(a(), localvwm.a.c, localvwm.a.b, 1010);
          xwa.a("play_video", "clk_tips", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Wsk.a });
        }
        else
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsq
 * JD-Core Version:    0.7.0.1
 */