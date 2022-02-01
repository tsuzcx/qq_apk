package com.tencent.gdtad.api.banner;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.tencent.image.URLImageView;
import java.lang.ref.WeakReference;
import thc;
import tkw;
import tmi;
import tmi.a;

public class GdtBannerImageView
  extends LinearLayout
{
  private tmi.a jdField_a_of_type_Tmi$a = new thc(this);
  private tmi jdField_a_of_type_Tmi;
  
  public GdtBannerImageView(Context paramContext, String paramString)
  {
    super(paramContext);
    setGravity(17);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setStroke(1, Color.parseColor("#EFEFEF"));
    if (Build.VERSION.SDK_INT >= 16) {
      setBackground(localGradientDrawable);
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      tkw.e("GdtBannerImageView", "constructor");
      return;
    }
    paramContext = new URLImageView(paramContext);
    addView(paramContext);
    this.jdField_a_of_type_Tmi = new tmi(paramString, new WeakReference(this.jdField_a_of_type_Tmi$a));
    this.jdField_a_of_type_Tmi.load();
    paramContext.setImageDrawable(this.jdField_a_of_type_Tmi.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerImageView
 * JD-Core Version:    0.7.0.1
 */