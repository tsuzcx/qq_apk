import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class vpq
  extends vpr
  implements View.OnClickListener
{
  private long a;
  
  public vpq(@NonNull ViewGroup paramViewGroup)
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
    if (this.jdField_a_of_type_Vpk == null) {}
    while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramView = this.jdField_a_of_type_Vpk.a().getVideoLinkInfo();
    if ((paramView != null) && (paramView.a()) && (paramView.a.a()))
    {
      vju.a(a(), paramView.a.c, paramView.a.b, 1010);
      wta.a("play_video", "clk_tips", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Vpk.a });
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vpq
 * JD-Core Version:    0.7.0.1
 */