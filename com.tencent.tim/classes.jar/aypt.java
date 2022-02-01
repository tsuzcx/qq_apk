import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.widget.AbsListView.LayoutParams;

public class aypt
  extends aypv
{
  private boolean aIy;
  private boolean aIz;
  private final int height;
  
  public aypt(Context paramContext, int paramInt)
  {
    super(paramContext, "", "", -1);
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
    paramViewGroup.setBackgroundColor(Color.parseColor("#F7F7F9"));
    View localView = new View(this.context);
    Object localObject = new RelativeLayout.LayoutParams(-1, rpq.dip2px(this.context, 1.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localView.setBackgroundColor(Color.parseColor("#DEDFE0"));
    localObject = new View(this.context);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, rpq.dip2px(this.context, 1.0F));
    localLayoutParams.addRule(12);
    ((View)localObject).setLayoutParams(localLayoutParams);
    ((View)localObject).setBackgroundColor(Color.parseColor("#DEDFE0"));
    if (QQStoryContext.isNightMode())
    {
      paramViewGroup.setBackgroundColor(this.context.getResources().getColor(2131166759));
      ((View)localObject).setBackgroundColor(this.context.getResources().getColor(2131166759));
      localView.setBackgroundColor(this.context.getResources().getColor(2131166759));
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aypt
 * JD-Core Version:    0.7.0.1
 */