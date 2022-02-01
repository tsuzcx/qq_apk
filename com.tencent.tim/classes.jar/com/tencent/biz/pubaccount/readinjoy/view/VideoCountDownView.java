package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.net.URL;
import mrr;

public class VideoCountDownView
  extends RelativeLayout
{
  private KandianUrlImageView W;
  public final int aZo;
  public final int aZp;
  public final int aZq;
  private boolean aqi;
  private Button bW;
  private Button bX;
  private mrr e;
  private ImageView kF;
  private ImageView kG;
  private ImageView kH;
  private ImageView kI;
  private ImageView kJ;
  private Context mContext;
  private View mM;
  private TextView ni;
  
  public VideoCountDownView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoCountDownView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoCountDownView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    this.aZo = getResources().getDimensionPixelOffset(2131297157);
    this.aZp = getResources().getDimensionPixelOffset(2131297145);
    this.aZq = getResources().getDimensionPixelOffset(2131297147);
    initUI();
  }
  
  private void initUI()
  {
    LayoutInflater.from(this.mContext).inflate(2131560547, this);
    this.ni = ((TextView)findViewById(2131380973));
    this.bW = ((Button)findViewById(2131363967));
    this.bX = ((Button)findViewById(2131363938));
    this.W = ((KandianUrlImageView)findViewById(2131369949));
    this.mM = findViewById(2131367810);
    this.kF = ((ImageView)findViewById(2131369897));
    this.kG = ((ImageView)findViewById(2131369898));
    this.kH = ((ImageView)findViewById(2131369899));
    this.kI = ((ImageView)findViewById(2131369900));
    this.kJ = ((ImageView)findViewById(2131369901));
    Drawable localDrawable = getResources().getDrawable(2130844055);
    localDrawable.setBounds(0, 0, this.aZo, this.aZo);
    this.bW.setCompoundDrawables(localDrawable, null, null, null);
    localDrawable = getResources().getDrawable(2130844051);
    localDrawable.setBounds(0, 0, this.aZp, this.aZq);
    this.bX.setCompoundDrawables(localDrawable, null, null, null);
  }
  
  public void a(URL paramURL)
  {
    try
    {
      this.W.setVisibility(0);
      this.W.setImage(paramURL);
      return;
    }
    catch (Exception paramURL)
    {
      paramURL.printStackTrace();
    }
  }
  
  public void aYr()
  {
    this.ni.setVisibility(8);
  }
  
  public void aYs()
  {
    this.W.setVisibility(8);
  }
  
  public void resetUI()
  {
    this.bX.setVisibility(8);
    this.ni.setVisibility(8);
  }
  
  public void sM(int paramInt) {}
  
  public void setIsXgMode(boolean paramBoolean)
  {
    this.aqi = paramBoolean;
  }
  
  public void setNextVideoInfo(mrr parammrr)
  {
    this.e = parammrr;
    if (this.e == null) {
      return;
    }
    this.bX.setVisibility(0);
    this.ni.setVisibility(0);
  }
  
  public void setOnCustomClickListener(View.OnClickListener paramOnClickListener)
  {
    this.bW.setOnClickListener(paramOnClickListener);
    this.mM.setOnClickListener(paramOnClickListener);
    this.kF.setOnClickListener(paramOnClickListener);
    this.kG.setOnClickListener(paramOnClickListener);
    this.kH.setOnClickListener(paramOnClickListener);
    this.kI.setOnClickListener(paramOnClickListener);
    this.kJ.setOnClickListener(paramOnClickListener);
    this.bX.setOnClickListener(paramOnClickListener);
    this.ni.setOnClickListener(paramOnClickListener);
  }
  
  public void setTitle(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.VideoCountDownView
 * JD-Core Version:    0.7.0.1
 */