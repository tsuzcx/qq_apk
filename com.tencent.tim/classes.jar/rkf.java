import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.theme.ThemeUtil;

public class rkf
  extends rkh
{
  private boolean aIy;
  private boolean aIz;
  private final int height;
  
  public rkf(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString, -1);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.height = i;
  }
  
  public int J(int paramInt)
  {
    return 4;
  }
  
  public void av(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.aIy = paramBoolean1;
    this.aIz = paramBoolean2;
  }
  
  public View d(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new RelativeLayout(this.context);
    paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, this.height));
    paramViewGroup.setBackgroundResource(2130851104);
    paramInt = -2170912;
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.c(), false, null)) {
      paramInt = -16444373;
    }
    View localView = new View(this.context);
    Object localObject = new RelativeLayout.LayoutParams(-1, rpq.dip2px(this.context, 1.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localView.setBackgroundColor(paramInt);
    localObject = new View(this.context);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, rpq.dip2px(this.context, 1.0F));
    localLayoutParams.addRule(12);
    ((View)localObject).setLayoutParams(localLayoutParams);
    ((View)localObject).setBackgroundColor(paramInt);
    paramViewGroup.addView(localView);
    paramViewGroup.addView((View)localObject);
    return paramViewGroup;
  }
  
  public void m(int paramInt, View paramView)
  {
    View localView = ((ViewGroup)paramView).getChildAt(0);
    paramView = ((ViewGroup)paramView).getChildAt(1);
    if (this.aIy) {
      localView.setVisibility(0);
    }
    while (this.aIz)
    {
      paramView.setVisibility(0);
      return;
      localView.setVisibility(4);
    }
    paramView.setVisibility(4);
  }
  
  public void onClick(int paramInt) {}
  
  public void setOpen(boolean paramBoolean) {}
  
  public void setSelect(boolean paramBoolean) {}
  
  public int tz()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rkf
 * JD-Core Version:    0.7.0.1
 */