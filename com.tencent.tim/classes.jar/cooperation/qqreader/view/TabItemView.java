package cooperation.qqreader.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqcx;

public class TabItemView
  extends LinearLayout
{
  public ImageView Hx;
  public View LK;
  public TextView agh;
  
  public TabItemView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public TabItemView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabItemView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, aqcx.dip2px(paramContext, 54.0F));
    this.LK = new View(paramContext);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, aqcx.dip2px(paramContext, 1.0F));
    localLinearLayout.addView(this.LK, localLayoutParams2);
    this.Hx = new ImageView(paramContext);
    int i = aqcx.dip2px(paramContext, 25.0F);
    localLayoutParams2 = new LinearLayout.LayoutParams(i, i);
    localLayoutParams2.gravity = 17;
    localLayoutParams2.setMargins(0, aqcx.dip2px(paramContext, 5.0F), 0, aqcx.dip2px(paramContext, 2.0F));
    localLinearLayout.addView(this.Hx, localLayoutParams2);
    this.agh = new TextView(paramContext);
    this.agh.setTextSize(2, 11.0F);
    this.agh.setTextColor(-1728053248);
    this.agh.setGravity(17);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    localLinearLayout.addView(this.agh, paramContext);
    addView(localLinearLayout, localLayoutParams1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.view.TabItemView
 * JD-Core Version:    0.7.0.1
 */