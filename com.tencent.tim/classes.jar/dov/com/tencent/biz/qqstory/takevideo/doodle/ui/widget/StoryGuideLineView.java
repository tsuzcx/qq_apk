package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aypi;
import ayxa;
import com.tencent.biz.qqstory.view.PressDarkImageView;
import rmw;
import rmw.a;

public class StoryGuideLineView
  extends LinearLayout
{
  public static int bqQ;
  public static int bqR;
  public static int bqS;
  public static int bqT;
  private ImageView IV;
  private View Nn;
  private View No;
  private View Np;
  private TextView ahY;
  private TextView ahZ;
  private TextView aia;
  private PressDarkImageView c;
  private LinearLayout mx;
  private LinearLayout my;
  private LinearLayout mz;
  
  public StoryGuideLineView(Context paramContext)
  {
    super(paramContext);
    initUI(paramContext);
  }
  
  public StoryGuideLineView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI(paramContext);
  }
  
  public StoryGuideLineView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI(paramContext);
  }
  
  private void initUI(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131563117, this, true);
    this.c = ((PressDarkImageView)findViewById(2131375115));
    this.ahY = ((TextView)findViewById(2131375221));
    this.ahZ = ((TextView)findViewById(2131378803));
    this.mx = ((LinearLayout)findViewById(2131379212));
    this.my = ((LinearLayout)findViewById(2131369133));
    this.aia = ((TextView)findViewById(2131370513));
    this.mz = ((LinearLayout)findViewById(2131375161));
    this.Nn = findViewById(2131375162);
    this.Np = findViewById(2131375170);
    this.No = findViewById(2131375167);
    this.IV = ((ImageView)findViewById(2131370521));
    setViewAlpha(this.mz);
  }
  
  public void ZI(boolean paramBoolean)
  {
    if ((this.mz != null) && (this.Nn != null))
    {
      this.Nn.setVisibility(0);
      if (paramBoolean) {
        this.mz.setVisibility(0);
      }
    }
  }
  
  public boolean aQS()
  {
    return this.mz.getVisibility() == 0;
  }
  
  public void eSV()
  {
    if (this.mx != null)
    {
      this.mx.setVisibility(0);
      requestLayout();
    }
  }
  
  public void eSW()
  {
    if (this.mx != null)
    {
      this.mx.setVisibility(8);
      requestLayout();
    }
  }
  
  public void eSX()
  {
    if (this.my != null)
    {
      this.my.setVisibility(0);
      requestLayout();
    }
  }
  
  public void eSY()
  {
    if (this.my != null)
    {
      this.my.setVisibility(8);
      requestLayout();
    }
  }
  
  public void eSZ()
  {
    if ((this.mz != null) && (this.Nn != null))
    {
      this.Nn.setVisibility(8);
      this.mz.setVisibility(8);
    }
  }
  
  public void eTa()
  {
    if (this.Np != null) {
      this.Np.setVisibility(0);
    }
  }
  
  public void eTb()
  {
    if (this.Np != null) {
      this.Np.setVisibility(8);
    }
  }
  
  public void eTc()
  {
    if (this.No != null) {
      this.No.setVisibility(0);
    }
  }
  
  public void eTd()
  {
    if (this.No != null) {
      this.No.setVisibility(8);
    }
  }
  
  public void eTe()
  {
    eTb();
    eTd();
    eSZ();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    measureChild(this.mz, paramInt1, paramInt2);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    bqQ = this.No.getMeasuredWidth();
    bqR = localDisplayMetrics.widthPixels - this.Np.getMeasuredWidth();
    bqS = 0;
    bqT = localDisplayMetrics.heightPixels - this.mz.getMeasuredHeight();
    if (ayxa.isLiuHaiUseValid()) {
      bqT = localDisplayMetrics.heightPixels - this.mz.getMeasuredHeight() - ayxa.eMW - ayxa.sNotchHeight;
    }
  }
  
  public void setFollow()
  {
    if ((this.aia == null) || (this.IV == null)) {
      return;
    }
    this.aia.setText(acfp.m(2131714855));
    this.IV.setImageResource(2130847301);
  }
  
  public void setLinkerObject(aypi paramaypi)
  {
    if ((paramaypi == null) || (this.aia == null) || (this.IV == null)) {
      return;
    }
    this.aia.setText(paramaypi.aue);
    if (TextUtils.isEmpty(paramaypi.aue)) {
      this.aia.setText(paramaypi.mUrl);
    }
    this.IV.setImageResource(2130840151);
  }
  
  public void setStoryTag(rmw paramrmw)
  {
    if ((paramrmw == null) || (this.ahZ == null)) {
      return;
    }
    this.ahZ.setText(paramrmw.a.name);
  }
  
  public void setUserHead(Bitmap paramBitmap)
  {
    if (this.c != null) {
      this.c.setImageBitmap(paramBitmap);
    }
  }
  
  public void setUserName(String paramString)
  {
    if ((this.ahY != null) && (!TextUtils.isEmpty(paramString))) {
      this.ahY.setText(paramString);
    }
  }
  
  public void setViewAlpha(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    if (j == 0) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < j)
      {
        View localView = paramViewGroup.getChildAt(i);
        if ((localView instanceof ViewGroup)) {
          setViewAlpha((ViewGroup)localView);
        }
        if (localView.getBackground() != null) {
          localView.getBackground().mutate().setAlpha(60);
        }
        localView.setAlpha(0.6F);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView
 * JD-Core Version:    0.7.0.1
 */