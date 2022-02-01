package com.tencent.open.appstore.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import arvn;
import arvo;
import arvp;

public class CommonTitleBar
  extends RelativeLayout
{
  private ImageView Gr;
  private ImageView Gs;
  private a a;
  private TextView ada;
  private TextView adb;
  private ProgressBar mProgressBar;
  
  public CommonTitleBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CommonTitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommonTitleBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131559860, this);
    this.Gr = ((ImageView)findViewById(2131368815));
    this.Gr.setOnClickListener(new arvn(this));
    this.ada = ((TextView)findViewById(2131381132));
    this.ada.setOnClickListener(new arvo(this));
    this.adb = ((TextView)findViewById(2131381165));
    this.Gs = ((ImageView)findViewById(2131368816));
    this.Gs.setOnClickListener(new arvp(this));
    this.mProgressBar = ((ProgressBar)findViewById(2131373668));
  }
  
  public void hideProgressBar()
  {
    this.mProgressBar.setVisibility(8);
  }
  
  public void hideSearchIcon()
  {
    this.Gs.setVisibility(8);
  }
  
  public void setBackText(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.ada.setText(paramString);
    }
  }
  
  public void setIClickListener(a parama)
  {
    this.a = parama;
  }
  
  public void setTitleText(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.adb.setText(paramString);
    }
  }
  
  public void showProgressBar()
  {
    this.mProgressBar.setVisibility(0);
  }
  
  public static abstract interface a
  {
    public abstract void elO();
    
    public abstract void onBack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.component.CommonTitleBar
 * JD-Core Version:    0.7.0.1
 */