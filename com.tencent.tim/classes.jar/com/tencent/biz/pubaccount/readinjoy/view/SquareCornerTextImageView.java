package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import kwz;
import kxm;

public class SquareCornerTextImageView
  extends FrameLayout
{
  public boolean asB = true;
  TextView cB;
  View mL;
  KandianUrlImageView t;
  TextView textView;
  
  public SquareCornerTextImageView(@NonNull Context paramContext)
  {
    super(paramContext);
    initViews(paramContext);
  }
  
  private void b(@NonNull a parama)
  {
    float f = 1.0F * a.a(parama) / a.b(parama);
    if ((a.a(parama)) && ((f < 0.455D) || (f > 2.2D)))
    {
      this.textView.setVisibility(0);
      this.textView.setText(getResources().getString(2131718543));
    }
    for (;;)
    {
      if (a.b(parama))
      {
        this.textView.setVisibility(0);
        this.textView.setText(getResources().getString(2131718542));
      }
      if ((!a.c(parama)) || (TextUtils.isEmpty(a.a(parama)))) {
        break;
      }
      this.cB.setText(a.a(parama));
      this.mL.setVisibility(0);
      return;
      this.textView.setVisibility(4);
    }
    this.mL.setVisibility(8);
  }
  
  private void initViews(Context paramContext)
  {
    this.t = new KandianUrlImageView(paramContext);
    this.t.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.textView = new TextView(paramContext);
    this.textView.setGravity(17);
    this.textView.setBackgroundColor(Color.parseColor("#80000000"));
    this.textView.setTextColor(-1);
    paramContext = new FrameLayout.LayoutParams(Utils.dp2px(30.0D), Utils.dp2px(18.0D));
    paramContext.gravity = 85;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.t, localLayoutParams);
    addView(this.textView, paramContext);
    this.mL = LayoutInflater.from(getContext()).inflate(2131560313, null);
    this.cB = ((TextView)this.mL.findViewById(2131380841));
    this.mL.setVisibility(8);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.mL, paramContext);
  }
  
  public void a(@NonNull a parama)
  {
    kwz.a(this.t, a.a(parama), getContext());
    b(parama);
  }
  
  public void a(@NonNull a parama, String paramString, int paramInt1, int paramInt2)
  {
    if (!kxm.dz(paramString))
    {
      a(parama);
      return;
    }
    String str = kxm.c(paramString, paramInt1, paramInt2);
    if (QLog.isDebugVersion()) {
      QLog.i("SquareCornerTextImageView", 2, "[configSmartSizeImage], url = " + paramString + "\n, smartUrl = " + str + "\n, width = " + paramInt1 + ", height = " + paramInt2);
    }
    try
    {
      paramString = new URL(str);
      kwz.a(this.t, paramString, getContext());
      b(parama);
      return;
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        QLog.e("SquareCornerTextImageView", 1, "[configSmartSizeImage], e = " + paramString);
        kwz.a(this.t, a.a(parama), getContext());
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.asB)
    {
      super.onMeasure(paramInt1, paramInt1);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public static class a
  {
    private String alv;
    private boolean asC;
    private boolean asD;
    private final int height;
    private final boolean isGif;
    private final URL url;
    private final int width;
    
    public a(int paramInt1, int paramInt2, URL paramURL, boolean paramBoolean)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.url = paramURL;
      this.isGif = paramBoolean;
    }
    
    public void pJ(boolean paramBoolean)
    {
      this.asC = paramBoolean;
    }
    
    public void pK(boolean paramBoolean)
    {
      this.asD = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView
 * JD-Core Version:    0.7.0.1
 */