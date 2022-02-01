import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xrf
  extends xrg
  implements View.OnClickListener
{
  private long a;
  
  public xrf(@NonNull ViewGroup paramViewGroup)
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
    if (this.jdField_a_of_type_Xqz == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 500L)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        wuw localwuw = this.jdField_a_of_type_Xqz.a().getVideoLinkInfo();
        if ((localwuw != null) && (localwuw.a()) && (localwuw.a.a()))
        {
          xlj.a(a(), localwuw.a.c, localwuw.a.b, 1010);
          yup.a("play_video", "clk_tips", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Xqz.a });
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
 * Qualified Name:     xrf
 * JD-Core Version:    0.7.0.1
 */