import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class uay
  extends uaz
  implements View.OnClickListener
{
  private long a;
  
  public uay(@NonNull ViewGroup paramViewGroup)
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
    if (this.jdField_a_of_type_Uas == null) {}
    while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramView = this.jdField_a_of_type_Uas.a().getVideoLinkInfo();
    if ((paramView != null) && (paramView.a()) && (paramView.a.a()))
    {
      tvc.a(a(), paramView.a.c, paramView.a.b, 1010);
      vei.a("play_video", "clk_tips", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Uas.a });
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uay
 * JD-Core Version:    0.7.0.1
 */