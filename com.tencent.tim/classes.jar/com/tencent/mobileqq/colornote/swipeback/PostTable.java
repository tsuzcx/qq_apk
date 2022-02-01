package com.tencent.mobileqq.colornote.swipeback;

import aebl;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.theme.ThemeUtil;

public class PostTable
  extends RelativeLayout
{
  private View Bu;
  private TextView QY;
  private TextView QZ;
  private boolean bTi;
  public RelativeLayout jO;
  private int mBottom;
  private Context mContext;
  private int mCurState;
  private int mHeight;
  private int mLeft;
  private int mRight;
  private int mTop;
  private int mWidth;
  private int screenHeight;
  private int screenWidth;
  private ImageView yu;
  private ImageView yv;
  
  public PostTable(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public PostTable(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  private void cWq()
  {
    this.mHeight = this.mContext.getResources().getDimensionPixelSize(2131297940);
    this.mWidth = this.mContext.getResources().getDimensionPixelSize(2131297941);
    this.mHeight = ((int)(this.mHeight * 1.083333F));
    this.mWidth = ((int)(this.mWidth * 1.0F));
    this.mBottom = (this.screenHeight - getResources().getDimensionPixelSize(2131297939));
    this.mTop = (this.mBottom - this.mHeight);
    this.mLeft = this.screenWidth;
    this.mRight = (this.mLeft + this.mWidth);
  }
  
  private void cWu()
  {
    this.QZ.setVisibility(0);
    this.QY.setVisibility(8);
    this.yv.setVisibility(8);
    this.yu.setVisibility(8);
  }
  
  private void cWv()
  {
    this.QZ.setVisibility(4);
    this.QY.setVisibility(0);
    this.yv.setVisibility(0);
    this.yu.setVisibility(0);
    this.yv.setScaleX(0.0F);
    this.yv.setScaleY(0.0F);
  }
  
  private void initView(Context paramContext)
  {
    this.mContext = paramContext;
    this.mCurState = 0;
    this.jO = ((RelativeLayout)LayoutInflater.from(paramContext).inflate(2131559017, this));
    this.yu = ((ImageView)this.jO.findViewById(2131373530));
    this.yv = ((ImageView)this.jO.findViewById(2131373531));
    this.QY = ((TextView)this.jO.findViewById(2131373532));
    this.QZ = ((TextView)this.jO.findViewById(2131373529));
    this.Bu = this.jO.findViewById(2131373528);
    if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
      this.Bu.setBackgroundDrawable(paramContext.getResources().getDrawable(2130839488));
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    this.screenWidth = paramContext.getDefaultDisplay().getWidth();
    this.screenHeight = paramContext.getDefaultDisplay().getHeight();
    cWq();
  }
  
  public void A(double paramDouble)
  {
    if (this.bTi)
    {
      cWq();
      this.bTi = false;
    }
    this.mLeft = (this.screenWidth - (int)(this.mWidth * paramDouble));
    this.mRight = (this.screenWidth - (int)(this.mWidth * paramDouble) + this.mWidth);
    layout(this.mLeft, this.mTop, this.mRight, this.mBottom);
    invalidate();
  }
  
  public void cWr()
  {
    if (this.mCurState == 0) {
      return;
    }
    if (this.mCurState == 2) {
      cWv();
    }
    this.bTi = true;
    this.mCurState = 0;
    aebl.a(this.yv, 300, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F);
    aebl.a(this.yu, 300, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F);
    aebl.a(this.Bu, 300, 1.0F, 1.0F, 1.083333F, 1.0F);
  }
  
  public void cWs()
  {
    if (this.mCurState == 1) {
      return;
    }
    if (this.mCurState == 2) {
      cWv();
    }
    this.bTi = true;
    this.mCurState = 1;
    aebl.a(this.yu, 300, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F);
    aebl.a(this.yv, 300, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F);
    aebl.a(this.Bu, 300, 1.0F, 1.0F, 1.0F, 1.083333F);
  }
  
  public void cWt()
  {
    if (this.mCurState == 2) {
      return;
    }
    this.bTi = true;
    cWu();
    this.mCurState = 2;
    this.Bu.setScaleX(1.0F);
    this.Bu.setScaleY(1.083333F);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, this.mLeft, this.mTop, this.mRight, this.mBottom);
    if (paramInt2 == 0) {
      layout(this.mLeft, this.mTop, this.mRight, this.mBottom);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.swipeback.PostTable
 * JD-Core Version:    0.7.0.1
 */