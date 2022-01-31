import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;

public class uae
  extends uaz
  implements View.OnClickListener
{
  public uae(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.a.findViewById(2131367874).setOnClickListener(this);
    this.a.findViewById(2131377194).setOnClickListener(this);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull uas paramuas, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramuas, paramStoryPlayerGroupHolder);
    if (bkvi.a)
    {
      paramStoryPlayerGroupHolder = (RelativeLayout.LayoutParams)this.a.findViewById(2131367874).getLayoutParams();
      paramStoryPlayerGroupHolder.topMargin = (vzl.a(this.a.getContext(), 5.0F) + 114);
      this.a.findViewById(2131367874).setLayoutParams(paramStoryPlayerGroupHolder);
    }
    a().a(this, paramInt1, paramInt2, paramuas);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uae
 * JD-Core Version:    0.7.0.1
 */