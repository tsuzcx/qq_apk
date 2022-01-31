import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;

public class vow
  extends vpr
  implements View.OnClickListener
{
  public vow(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.a.findViewById(2131368009).setOnClickListener(this);
    this.a.findViewById(2131377715).setOnClickListener(this);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull vpk paramvpk, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramvpk, paramStoryPlayerGroupHolder);
    if (bngs.a)
    {
      paramStoryPlayerGroupHolder = (RelativeLayout.LayoutParams)this.a.findViewById(2131368009).getLayoutParams();
      paramStoryPlayerGroupHolder.topMargin = (xod.a(this.a.getContext(), 5.0F) + 114);
      this.a.findViewById(2131368009).setLayoutParams(paramStoryPlayerGroupHolder);
    }
    a().a(this, paramInt1, paramInt2, paramvpk);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    a().a(this, paramBoolean);
  }
  
  protected void b()
  {
    super.b();
    a().a(this);
  }
  
  public void onClick(View paramView)
  {
    a().a(this, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vow
 * JD-Core Version:    0.7.0.1
 */