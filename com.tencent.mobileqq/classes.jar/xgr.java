import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;

public class xgr
  extends xhm
  implements View.OnClickListener
{
  public xgr(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.a.findViewById(2131368599).setOnClickListener(this);
    this.a.findViewById(2131378823).setOnClickListener(this);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull xhf paramxhf, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramxhf, paramStoryPlayerGroupHolder);
    if (LiuHaiUtils.a)
    {
      paramStoryPlayerGroupHolder = (RelativeLayout.LayoutParams)this.a.findViewById(2131368599).getLayoutParams();
      paramStoryPlayerGroupHolder.topMargin = (UIUtils.dip2px(this.a.getContext(), 5.0F) + 114);
      this.a.findViewById(2131368599).setLayoutParams(paramStoryPlayerGroupHolder);
    }
    a().a(this, paramInt1, paramInt2, paramxhf);
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
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgr
 * JD-Core Version:    0.7.0.1
 */