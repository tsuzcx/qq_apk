import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.theme.ThemeUtil;

public class yix
  extends yja
{
  private final int b;
  private boolean c;
  private boolean d;
  
  public yix(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString, -1);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.b = i;
  }
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt)
  {
    return 4;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new RelativeLayout(this.a);
    paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, this.b));
    paramViewGroup.setBackgroundResource(2130850015);
    paramInt = -2170912;
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
      paramInt = -16444373;
    }
    View localView = new View(this.a);
    Object localObject = new RelativeLayout.LayoutParams(-1, UIUtils.dip2px(this.a, 1.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localView.setBackgroundColor(paramInt);
    localObject = new View(this.a);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, UIUtils.dip2px(this.a, 1.0F));
    localLayoutParams.addRule(12);
    ((View)localObject).setLayoutParams(localLayoutParams);
    ((View)localObject).setBackgroundColor(paramInt);
    paramViewGroup.addView(localView);
    paramViewGroup.addView((View)localObject);
    return paramViewGroup;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, View paramView)
  {
    View localView = ((ViewGroup)paramView).getChildAt(0);
    paramView = ((ViewGroup)paramView).getChildAt(1);
    if (this.c) {
      localView.setVisibility(0);
    }
    while (this.d)
    {
      paramView.setVisibility(0);
      return;
      localView.setVisibility(4);
    }
    paramView.setVisibility(4);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c = paramBoolean1;
    this.d = paramBoolean2;
  }
  
  public void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yix
 * JD-Core Version:    0.7.0.1
 */