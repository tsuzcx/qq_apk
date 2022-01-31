import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class vtz
  extends vua
  implements View.OnClickListener
{
  private long a;
  
  public vtz(@NonNull ViewGroup paramViewGroup)
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
    if (this.jdField_a_of_type_Vtt == null) {}
    while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramView = this.jdField_a_of_type_Vtt.a().getVideoLinkInfo();
    if ((paramView != null) && (paramView.a()) && (paramView.a.a()))
    {
      vod.a(a(), paramView.a.c, paramView.a.b, 1010);
      wxj.a("play_video", "clk_tips", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Vtt.a });
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vtz
 * JD-Core Version:    0.7.0.1
 */