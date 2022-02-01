package cooperation.qzone.panorama.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqnm;

public class PanoramaLoadingLayout
  extends RelativeLayout
{
  public static final int HEIGHT = aqnm.dpToPx(55.0F);
  public static final int WIDTH = aqnm.dpToPx(55.0F);
  public static boolean dpr;
  private PanoramaLoadingBackground jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground;
  private PanoramaLoadingBall jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall;
  private PanoramaLoadingBall b;
  private Context context;
  private TextView eA;
  
  public PanoramaLoadingLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
  }
  
  public PanoramaLoadingLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  @SuppressLint({"ResourceType"})
  public void cL(boolean paramBoolean1, boolean paramBoolean2)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(WIDTH, HEIGHT);
    localLayoutParams.addRule(13);
    if (this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground == null)
    {
      this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground = new PanoramaLoadingBackground(this.context);
      this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground.setId(1);
      addView(this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground, localLayoutParams);
    }
    if (this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall == null)
    {
      this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall = new PanoramaLoadingBall(this.context);
      this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall.setRotationX(60.0F);
      addView(this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall, localLayoutParams);
    }
    if (this.b == null)
    {
      this.b = new PanoramaLoadingBall(this.context);
      this.b.setRotationY(60.0F);
      addView(this.b, localLayoutParams);
    }
    if (this.eA == null)
    {
      this.eA = new TextView(this.context);
      this.eA.setText(this.context.getResources().getString(2131717998));
      this.eA.setTextColor(-1);
      this.eA.setTextSize(14.0F);
      this.eA.setShadowLayer(2.0F, 2.0F, 2.0F, -16777216);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(3, this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground.getId());
      localLayoutParams.topMargin = (aqnm.dip2px(10.0F) + WIDTH / 5);
      addView(this.eA, localLayoutParams);
    }
    if (paramBoolean1) {
      eCp();
    }
    if (paramBoolean2)
    {
      this.eA.setVisibility(0);
      return;
    }
    this.eA.setVisibility(8);
  }
  
  public void eCp()
  {
    if ((this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall != null) && (this.b != null) && (this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground != null))
    {
      this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall.a(60.0F, 0, this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground);
      this.b.a(60.0F, 1, this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground);
    }
  }
  
  public void eCq()
  {
    if (this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall != null)
    {
      this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall.stopTimer();
      this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall.setRotationX(60.0F);
    }
    if (this.b != null)
    {
      this.b.stopTimer();
      this.b.setRotationY(60.0F);
    }
  }
  
  public void onRecycled()
  {
    if (this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall != null)
    {
      this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall.stopTimer();
      removeView(this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall);
    }
    if (this.b != null)
    {
      this.b.stopTimer();
      removeView(this.b);
    }
    if (this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground != null) {
      removeView(this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground);
    }
    this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground = null;
    this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall = null;
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaLoadingLayout
 * JD-Core Version:    0.7.0.1
 */