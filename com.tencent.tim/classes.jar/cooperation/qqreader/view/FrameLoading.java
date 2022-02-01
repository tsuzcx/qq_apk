package cooperation.qqreader.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import com.tencent.widget.immersive.ImmersiveUtils;

public class FrameLoading
  extends FrameLayout
{
  public LoadingImageView b;
  public TextView ny;
  
  public FrameLoading(@NonNull Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public FrameLoading(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FrameLoading(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setGravity(17);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    this.b = new LoadingImageView(paramContext);
    int i = aqcx.dip2px(paramContext, 35.0F);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams2.addRule(14);
    localRelativeLayout.addView(this.b, localLayoutParams2);
    this.ny = new TextView(paramContext);
    this.ny.setTextSize(2, 16.0F);
    this.ny.setTextColor(1426063360);
    this.ny.setGravity(17);
    localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams2.addRule(3, this.b.getId());
    localLayoutParams2.setMargins(0, aqcx.dip2px(paramContext, 15.0F) + ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
    localRelativeLayout.addView(this.ny, localLayoutParams2);
    addView(localRelativeLayout, localLayoutParams1);
  }
  
  public void setLoadingText(int paramInt)
  {
    this.ny.setText(getResources().getString(2131717141, new Object[] { Integer.valueOf(paramInt) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.view.FrameLoading
 * JD-Core Version:    0.7.0.1
 */