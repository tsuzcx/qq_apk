package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import java.io.File;
import ndd;
import wja;

public class KandianProgressView
  extends LinearLayout
{
  String Df = "";
  public a a;
  public String ajb;
  ImageView ks;
  ImageView kt;
  ImageView ku;
  View.OnClickListener listener = new ndd(this);
  public Bundle mBundle;
  ProgressBar mProgressBar;
  TextView sM;
  TextView sN;
  TextView sO;
  TextView sP;
  TextView sQ;
  
  public KandianProgressView(Context paramContext, Bundle paramBundle, a parama)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2131560560, this);
    this.ajb = paramBundle.getString("mTaskID");
    this.a = parama;
    this.Df = paramBundle.getString("arg_video_cover");
    this.mBundle = paramBundle;
    initViews();
  }
  
  private void initViews()
  {
    this.sM = ((TextView)findViewById(2131366693));
    this.sN = ((TextView)findViewById(2131377623));
    this.sO = ((TextView)findViewById(2131377230));
    this.sP = ((TextView)findViewById(2131365714));
    this.sQ = ((TextView)findViewById(2131372519));
    this.mProgressBar = ((ProgressBar)findViewById(2131373668));
    this.ks = ((ImageView)findViewById(2131365481));
    this.kt = ((ImageView)findViewById(2131377222));
    this.ku = ((ImageView)findViewById(2131365697));
    this.kt.setOnClickListener(this.listener);
    this.sO.setOnClickListener(this.listener);
    this.ku.setOnClickListener(this.listener);
    this.sP.setOnClickListener(this.listener);
    setCoverImg();
  }
  
  private void pt(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      tq(0);
      tr(8);
      return;
    }
    tq(8);
    tr(0);
  }
  
  private void tq(int paramInt)
  {
    this.mProgressBar.setVisibility(paramInt);
    this.sQ.setVisibility(paramInt);
  }
  
  private void tr(int paramInt)
  {
    this.sM.setVisibility(paramInt);
    this.kt.setVisibility(paramInt);
    this.sO.setVisibility(paramInt);
    this.ku.setVisibility(paramInt);
    this.sP.setVisibility(paramInt);
  }
  
  public void aVG()
  {
    pt(false);
  }
  
  public void setCoverImg()
  {
    setImage(this.Df);
  }
  
  protected void setImage(String paramString)
  {
    int j = 1;
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      int i = wja.dp2px(100.0F, getResources());
      int k = wja.dp2px(100.0F, getResources());
      float f1 = ((BitmapFactory.Options)localObject).outWidth / i;
      float f2 = ((BitmapFactory.Options)localObject).outHeight / k;
      i = j;
      if (f1 >= 1.0F)
      {
        i = j;
        if (f2 >= 1.0F) {
          i = (int)Math.floor(Math.min(f1, f2));
        }
      }
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = i;
      try
      {
        localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        paramString = ReadInJoyBaseDeliverActivity.rotaingImageView(ReadInJoyBaseDeliverActivity.U(paramString), (Bitmap)localObject);
        this.ks.setImageBitmap(paramString);
        this.ks.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return;
      }
      catch (OutOfMemoryError paramString)
      {
        this.ks.setImageDrawable(new ColorDrawable(-16777216));
        this.ks.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return;
      }
    }
    this.ks.setImageDrawable(new ColorDrawable(-16777216));
    this.ks.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public void setViewInformation(Bundle paramBundle)
  {
    this.ajb = paramBundle.getString("mTaskID");
    this.Df = paramBundle.getString("arg_video_cover");
    this.mBundle = paramBundle;
    setCoverImg();
  }
  
  public void updateProgress(int paramInt)
  {
    this.mProgressBar.setProgress(paramInt);
    pt(true);
  }
  
  public static abstract interface a
  {
    public abstract void aK(Bundle paramBundle);
    
    public abstract void f(String paramString, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.KandianProgressView
 * JD-Core Version:    0.7.0.1
 */