package com.tencent.av.redpacket.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import atau.a;
import com.tencent.mobileqq.portal.StrokeTextView;
import wja;

public class RedPacketRollNumberView
  extends LinearLayout
  implements RedPacketRollTextView.a
{
  private a a;
  private int count;
  private boolean isRool = true;
  private Context mContext;
  private int mTextSize;
  private int mViewRolledCount;
  
  public RedPacketRollNumberView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public RedPacketRollNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    getAttrs(paramContext, paramAttributeSet);
  }
  
  public RedPacketRollNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    getAttrs(paramContext, paramAttributeSet);
  }
  
  private void getAttrs(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.ta);
    this.mTextSize = ((int)paramContext.getDimension(3, 12.0F));
    paramContext.recycle();
  }
  
  public void init(double paramDouble)
    throws Exception
  {
    if (paramDouble <= 0.0D) {
      throw new Exception("no must be positive");
    }
    StrokeTextView localStrokeTextView = new StrokeTextView(this.mContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localStrokeTextView.setIncludeFontPadding(false);
    localStrokeTextView.setLayoutParams(localLayoutParams);
    localStrokeTextView.setGravity(80);
    localStrokeTextView.setTextSize(0, this.mTextSize);
    localStrokeTextView.setStrokeEnable(true);
    localStrokeTextView.setStrokeColor(-1);
    localStrokeTextView.setStrokeSize(wja.dp2px(6.0F, getResources()));
    localStrokeTextView.setInnerTextColor(-2094274);
    localStrokeTextView.setTypeface(Typeface.defaultFromStyle(1));
    int i = (int)paramDouble;
    int j = (int)Math.round((paramDouble - i) * 1000.0D) / 10;
    init(j);
    if (j < 10) {
      init(0);
    }
    localStrokeTextView.setText(".");
    addView(localStrokeTextView, 0);
    init(i);
  }
  
  public void init(int paramInt)
    throws Exception
  {
    if (paramInt < 0) {
      throw new Exception("no must be positive");
    }
    RedPacketRollTextView localRedPacketRollTextView = new RedPacketRollTextView(this.mContext, this.mTextSize, this.isRool);
    localRedPacketRollTextView.setListener(this);
    addView(localRedPacketRollTextView, 0);
    localRedPacketRollTextView.setScope(0, paramInt % 10);
    paramInt /= 10;
    while (paramInt > 0)
    {
      localRedPacketRollTextView = new RedPacketRollTextView(this.mContext, this.mTextSize, this.isRool);
      localRedPacketRollTextView.setListener(this);
      localRedPacketRollTextView.setScope(0, paramInt % 10);
      addView(localRedPacketRollTextView, 0);
      paramInt /= 10;
    }
  }
  
  public void onRollTextChanged(Bitmap paramBitmap) {}
  
  public void onRollTextComplete()
  {
    if ((this.mViewRolledCount == this.count - 2) && (this.a != null)) {
      this.a.complete();
    }
    this.mViewRolledCount += 1;
  }
  
  public void reset(double paramDouble)
  {
    int i = 0;
    while (i < this.count)
    {
      View localView = getChildAt(i);
      if ((localView != null) && ((localView instanceof RedPacketRollTextView))) {
        ((RedPacketRollTextView)localView).stopRoll();
      }
      i += 1;
    }
    removeAllViews();
    try
    {
      this.mViewRolledCount = 0;
      init(paramDouble);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void roll()
  {
    post(new RedPacketRollNumberView.1(this));
  }
  
  public void setIsRool(boolean paramBoolean)
  {
    this.isRool = paramBoolean;
  }
  
  public void setLisener(a parama)
  {
    if (parama != null) {
      this.a = parama;
    }
  }
  
  public static abstract interface a
  {
    public abstract void complete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketRollNumberView
 * JD-Core Version:    0.7.0.1
 */