import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qjg
  extends qjw
  implements View.OnClickListener
{
  public qjg(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.mItemView.findViewById(2131368925).setOnClickListener(this);
    this.mItemView.findViewById(2131379571).setOnClickListener(this);
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull qjq paramqjq, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramqjq, paramStoryPlayerGroupHolder);
    if (ayxa.sHasNotch)
    {
      paramStoryPlayerGroupHolder = (RelativeLayout.LayoutParams)this.mItemView.findViewById(2131368925).getLayoutParams();
      paramStoryPlayerGroupHolder.topMargin = (rpq.dip2px(this.mItemView.getContext(), 5.0F) + 114);
      this.mItemView.findViewById(2131368925).setLayoutParams(paramStoryPlayerGroupHolder);
    }
    a().a(this, paramInt1, paramInt2, paramqjq);
  }
  
  public void onClick(View paramView)
  {
    a().a(this, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    a().a(this);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void sE(boolean paramBoolean)
  {
    super.sE(paramBoolean);
    a().a(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qjg
 * JD-Core Version:    0.7.0.1
 */