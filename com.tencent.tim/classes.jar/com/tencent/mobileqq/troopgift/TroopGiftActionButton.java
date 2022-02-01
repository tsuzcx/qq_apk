package com.tencent.mobileqq.troopgift;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import apwv;
import aqcx;
import org.json.JSONObject;

public class TroopGiftActionButton
  extends RelativeLayout
{
  protected ImageView EQ;
  private ProgressView a;
  private JSONObject bW;
  protected AnimationDrawable mAnimationDrawable;
  protected Handler mHandler;
  public View.OnClickListener x;
  
  public TroopGiftActionButton(Context paramContext, JSONObject paramJSONObject, View.OnClickListener paramOnClickListener)
  {
    super(paramContext);
    this.bW = paramJSONObject;
    this.x = paramOnClickListener;
    this.mHandler = new Handler(Looper.getMainLooper());
    init();
  }
  
  public void Ud(String paramString)
  {
    this.mHandler.post(new TroopGiftActionButton.2(this, paramString));
  }
  
  protected void init()
  {
    this.a = new ProgressView(getContext());
    Object localObject1 = new RelativeLayout.LayoutParams(aqcx.dip2px(getContext(), 68.0F), aqcx.dip2px(getContext(), 68.0F));
    ((RelativeLayout.LayoutParams)localObject1).addRule(10);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = aqcx.dip2px(getContext(), 53.5F);
    addView(this.a, (ViewGroup.LayoutParams)localObject1);
    Object localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setShape(1);
    ((GradientDrawable)localObject2).setCornerRadius(aqcx.dip2px(getContext(), 56.0F));
    ((GradientDrawable)localObject2).setColor(Color.parseColor(this.bW.optString("buttonColor")));
    localObject1 = new TextView(getContext());
    ((TextView)localObject1).setText(this.bW.optString("buttonText"));
    ((TextView)localObject1).setTextColor(Color.parseColor(this.bW.optString("buttonTextColor")));
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
    localObject2 = new RelativeLayout.LayoutParams(aqcx.dip2px(getContext(), 56.0F), aqcx.dip2px(getContext(), 56.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = aqcx.dip2px(getContext(), 59.5F);
    addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.EQ = new ImageView(getContext());
    this.EQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
    ((TextView)localObject1).setOnTouchListener(new apwv(this, (TextView)localObject1));
  }
  
  public void setProgress(int paramInt)
  {
    this.a.setProgress(paramInt);
  }
  
  class ProgressView
    extends View
  {
    private Paint mPaint = new Paint();
    private int mProgress;
    private RectF mRectF;
    
    public ProgressView(Context paramContext)
    {
      super();
      this.mPaint.setAntiAlias(true);
      this.mPaint.setColor(Color.parseColor(TroopGiftActionButton.a(TroopGiftActionButton.this).optString("buttonColor")));
      this.mPaint.setStrokeWidth(aqcx.dip2px(getContext(), 3.0F));
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mRectF = new RectF();
      this.mRectF.left = (aqcx.dip2px(getContext(), 3.0F) / 2);
      this.mRectF.top = (aqcx.dip2px(getContext(), 3.0F) / 2);
      this.mRectF.right = (aqcx.dip2px(getContext(), 68.0F) - aqcx.dip2px(getContext(), 3.0F) / 2);
      this.mRectF.bottom = (aqcx.dip2px(getContext(), 68.0F) - aqcx.dip2px(getContext(), 3.0F) / 2);
      setProgress(0);
    }
    
    protected void onDraw(Canvas paramCanvas)
    {
      super.onDraw(paramCanvas);
      paramCanvas.drawArc(this.mRectF, -90.0F, -(100 - this.mProgress) * 360 / 100, false, this.mPaint);
    }
    
    public void setProgress(int paramInt)
    {
      this.mProgress = paramInt;
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftActionButton
 * JD-Core Version:    0.7.0.1
 */